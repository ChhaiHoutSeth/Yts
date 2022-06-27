package com.example.yts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.yts.ui.theme.YtsTheme
import com.example.yts.ui.theme.graySurface

enum class BottomNavType {
    HOME, FAVORITE, PROFILE
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YtsTheme {
                MainAppContent()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainAppContent() {
    val bottomNavItemState = rememberSaveable { mutableStateOf(BottomNavType.HOME) }
    Scaffold(
        bottomBar = { MainBottomNavigation(bottomNavItemState = bottomNavItemState) },
        content = { MainBodyContent(bottomNavType = bottomNavItemState.value) }
    )
}

@Composable
fun MainBottomNavigation(bottomNavItemState: MutableState<BottomNavType>) {
    BottomNavigation {
        BottomNavigationItem(
            selected = bottomNavItemState.value == BottomNavType.HOME,
            onClick = { bottomNavItemState.value = BottomNavType.HOME },
            icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.home)) },
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.White
        )
        BottomNavigationItem(
            selected = bottomNavItemState.value == BottomNavType.FAVORITE,
            onClick = { bottomNavItemState.value = BottomNavType.FAVORITE },
            icon = { Icon(imageVector = Icons.Outlined.Favorite, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.favorite)) },
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.White
        )
        BottomNavigationItem(
            selected = bottomNavItemState.value == BottomNavType.PROFILE,
            onClick = { bottomNavItemState.value = BottomNavType.PROFILE },
            icon = { Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.profile)) },
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.White
        )
    }
}

@Composable
fun MainBodyContent(bottomNavType: BottomNavType) {
    Crossfade(targetState = bottomNavType) { navType ->
        when (navType) {
            BottomNavType.HOME -> ""
            BottomNavType.FAVORITE -> ""
            BottomNavType.PROFILE -> ""
        }
    }
}
