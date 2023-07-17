package com.diml.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.diml.components.BottomAppBar
import com.diml.components.LoggerTabBar
import com.diml.ui.theme.accent
import com.diml.viewmodel.LogViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoggerScreen(navController: NavController, logViewModel: LogViewModel) {
    Column {
        TopAppBar(
            backgroundColor = accent,
            title = {
                Text(
                    text = "DAY IN MY LIFE",
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            }, elevation = 30.dp
        )
        Column(modifier = Modifier.weight(1f)) {

            LoggerTabBar(navController, logViewModel)
        }

        BottomAppBar(navController,"home")

    }
}


//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun LoggerScreenPreview() {
//    DIMLTheme {
//        LoggerScreen(rememberNavController())
//    }
//}