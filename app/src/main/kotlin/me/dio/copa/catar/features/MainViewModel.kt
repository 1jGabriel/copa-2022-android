package me.dio.copa.catar.features

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.dio.copa.catar.core.BaseViewModel
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.domain.usecase.DisableNotificationUseCase
import me.dio.copa.catar.domain.usecase.EnableNotificationUseCase
import me.dio.copa.catar.domain.usecase.GetMatchesUseCase
import me.dio.copa.catar.remote.NotFoundException
import me.dio.copa.catar.remote.UnexpectedException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase,
    private val disableNotificationUseCase: DisableNotificationUseCase,
    private val enableNotificationUseCase: EnableNotificationUseCase,
) : BaseViewModel<MainUiState, MainUiAction>(MainUiState()) {
    fun fetchMatches(group: String) = viewModelScope.launch {
        getMatchesUseCase(group)
            .flowOn(Dispatchers.Main)
            .catch {
                when (it) {
                    is NotFoundException ->
                        sendAction(MainUiAction.MatchesNotFound(it.message ?: "Erro sem mensagem"))

                    is UnexpectedException ->
                        sendAction(MainUiAction.Unexpected)
                }
            }.collect { matches ->
                setState {
                    copy(matches = matches.rounds.flatMap { it.matches })
                }
            }
    }

    fun toggleNotification(match: Match) {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.Main) {
                    val action = if (match.notificationEnabled) {
                        disableNotificationUseCase(match.id)
                        MainUiAction.DisableNotification(match)
                    } else {
                        enableNotificationUseCase(match.id)
                        MainUiAction.EnableNotification(match)
                    }

                    sendAction(action)
                }
            }
        }
    }
}

enum class GroupEnum(val url: String) {
    GROUP_A("group-a.json"),
    GROUP_B("group-b.json"),
    GROUP_C("group-c.json"),
    GROUP_D("group-d.json"),
    GROUP_E("group-e.json"),
    GROUP_F("group-f.json"),
    GROUP_G("group-g.json"),
    GROUP_H("group-h.json"),
}

data class MainUiState(
    val matches: List<Match> = emptyList()
)

sealed interface MainUiAction {
    object Unexpected : MainUiAction
    data class MatchesNotFound(val message: String) : MainUiAction
    data class EnableNotification(val match: Match) : MainUiAction
    data class DisableNotification(val match: Match) : MainUiAction
}
