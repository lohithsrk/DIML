package com.diml

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.diml.dataClass.LogEntity
import com.diml.room.LogDB
import com.diml.room.Repository
import com.diml.screens.AddLogScreen
import com.diml.screens.LikedScreen
import com.diml.screens.LoggerScreen
import com.diml.screens.UpdateLogScreen
import com.diml.ui.theme.DIMLTheme
import com.diml.viewmodel.LogViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DIMLTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black), color = MaterialTheme.colorScheme.background
                ) {

                    val mContext = LocalContext.current
                    val db = LogDB.getInstance(mContext)
                    val repository = Repository(db)
                    val logViewModel = LogViewModel(repository)

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            LoggerScreen(navController, logViewModel)
                        }
                        composable("addlog") {
                            AddLogScreen(
                                navController,
                                logViewModel,
                                LogEntity(0, "", "")
                            )

                        }
                        composable("updatelog/{id}/{title}/{description}") {

                            val id = it.arguments?.getString("id")
                            val title = it.arguments?.getString("title")
                            val description = it.arguments?.getString("description")
                            UpdateLogScreen(
                                navController,
                                logViewModel,
                                LogEntity(id!!.toInt(), title!!, description!!)
                            )

                        }

                        composable("liked") {
                            LikedScreen(navController,logViewModel)
                        }
                    }

                }
            }
        }
    }


}