package com.diml.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diml.ui.theme.DIMLTheme
import com.diml.ui.theme.accent

@Composable
fun BottomAppBar(navController: NavController,screen:String) {
    var selectedScreen by remember {
        mutableStateOf(screen)
    }

    Box() {
        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter),
            backgroundColor = accent
        ) {
            prepareBottomMenu().forEach { menuItem ->
                BottomNavigationItem(
                    selected = (selectedScreen == menuItem.label),
                    onClick = {
                        selectedScreen = menuItem.label
                        navController.navigate(menuItem.label)
                    },
                    icon = {
                        Icon(
                            imageVector = menuItem.icon,
                            contentDescription = menuItem.label,
                            tint = if (selectedScreen == menuItem.label) Color.White else Color.Gray
                        )
                    },
                    enabled = true
                )

            }
        }
    }
}

fun prepareBottomMenu(): ArrayList<BottomMenuItem> {
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()
    bottomMenuItemList.add(BottomMenuItem("home", Icons.Filled.Home))
    bottomMenuItemList.add(BottomMenuItem("addlog", Icons.Filled.AddCircle))
//    bottomMenuItemList.add(BottomMenuItem("liked", Icons.Filled.Favorite))
    return bottomMenuItemList
}


@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview() {
    DIMLTheme {
        BottomAppBar(navController = rememberNavController(),"home")
    }
}