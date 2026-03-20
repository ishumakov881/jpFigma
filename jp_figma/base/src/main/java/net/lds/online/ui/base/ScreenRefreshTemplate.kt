package net.lds.online.ui.base

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap

import net.lds.online.components.ErrorView


/*
Разметка под
- PullToRefreshBox
- Content
- FullScreen ошибки с кнопкой refresh
- возможно диалоги под Warning и Alert не критичных ошибок и оповещений
- возможно проброс sealed interface ServicesEffect { data class ShowToast(val message: String) : ServicesEffect }
* */
@Composable
fun <T> BaseScreenLayout(
    state: ScreenState<T>,
    onRefresh: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    shimmerContent: @Composable () -> Unit = { ShimmerScreen() },
    emptyContent: @Composable () -> Unit = { EmptyView() },
    successContent: @Composable (T) -> Unit
) {
    Crossfade(
        targetState = state.contentState,
        label = "BaseStateTransition",
        modifier = modifier.fillMaxSize()
    ) { contentState ->
        when (contentState) {
            is UiState.Loading -> shimmerContent()

            is UiState.Empty -> emptyContent()

            is UiState.Error -> ErrorView(
                message = contentState.message,
                onRetry = onRetry
            )

            is UiState.Success -> {
                PullToRefreshBox(
                    isRefreshing = contentState.isRefreshing,
                    onRefresh = onRefresh,
                    modifier = Modifier.fillMaxSize()
                ) {
                    successContent(contentState.data)
                }
            }
        }
    }
}

@Composable
fun ShimmerScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(strokeCap = StrokeCap.Round)
    }
}

@Composable
fun EmptyView() {
    TODO("Not yet implemented")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRefreshTemplate(modifier: Modifier, error: String?, content: @Composable (() -> Unit)? = null, onRefresh: () -> Unit) {
    Box(modifier = modifier.fillMaxSize()) {
        val pullRefreshState = rememberPullToRefreshState()

        PullToRefreshBox(
            modifier = Modifier.fillMaxSize(),
            isRefreshing = false,
            onRefresh = onRefresh,
            state = pullRefreshState
        ) {
            content?.invoke()
        }
        error?.let {
            //ErrorCard(text = "it")
            //WarningCard(text = "it")
            ErrorView(
                title = it,
                modifier = Modifier.align(Alignment.Center),
                onRetry = onRefresh
            )
        }
    }
}

//@Composable
//fun ScreenRefreshTemplate0(modifier: Modifier, error: String?, content: @Composable (() -> Unit),
//                           effect: Flow<ServicesEffect>, onRefresh: () -> Unit) {
//    val context = LocalContext.current
//
//    LaunchedEffect(Unit) {
//        effect.collect { effect ->
//            when (effect) {
//                is ShowToast -> {
//                    Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }
//
//}
/*@Composable
fun <T> ScreenRefreshTemplate0(
    modifier: Modifier = Modifier,
    state: UiState<T>,
    effect: Flow<ServicesEffect>,
    onRefresh: () -> Unit,
    content: @Composable (T) -> Unit
) {
    val context = LocalContext.current

    // Обработка эффектов
    LaunchedEffect(effect) {
        effect.collect { e ->
            when (e) {
                is ShowToast -> {
                    Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        val pullRefreshState = rememberPullToRefreshState()

        PullToRefreshBox(
            modifier = Modifier.fillMaxSize(),
            isRefreshing = state.isLoading,
            onRefresh = onRefresh,
            state = pullRefreshState
        ) {
            content(state.data) // передаем data в контент
        }

        state.error?.let { errorMsg ->
            ErrorView(
                title = errorMsg,
                modifier = Modifier.align(Alignment.Center),
                onRetry = onRefresh
            )
        }
    }
}
*/