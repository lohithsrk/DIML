package com.diml.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diml.dataClass.LogEntity
import com.diml.ui.theme.accent
import com.diml.viewmodel.LogViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UpdateLogScreen(navController: NavController, logViewModel: LogViewModel?, log: LogEntity) {

    var title by remember {
        mutableStateOf(log.title)
    }
    var description by remember {
        mutableStateOf(log.description)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(accent)
    ) {
        TopAppBar(backgroundColor = accent, title = {
            Text(
                text = "Update Log", color = Color.White, fontWeight = FontWeight.ExtraBold
            )
        }, elevation = 30.dp, navigationIcon = {
            IconButton(onClick = { navController.popBackStack("home", inclusive = false) }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        })
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(15.dp)) {

                Text(text = "Title", color = Color.White)
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    placeholder = { Text(text = "What did you do?", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        cursorColor = Color.White,
                        textColor = Color.White,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    maxLines = 1
                )
                Text(text = "Description", color = Color.White)
                TextField(
                    value = description,
                    onValueChange = { text -> description = text },
                    placeholder = { Text(text = "Tell something about it...", color = Color.Gray) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        cursorColor = Color.White,
                        textColor = Color.White,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )

                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), Arrangement.SpaceBetween
            ) {
                Text(text = "Log your activity now...", color = Color.White)
                ClickableText(
                    onClick = {
                        logViewModel?.updateLog(
                            LogEntity(
                                log.id, title.replaceFirstChar(Char::titlecase),
                                description.replaceFirstChar(Char::titlecase)


                            )
                        )
                        navController.popBackStack()

                    },
                    text = AnnotatedString("Post"),
                    style = TextStyle(color = Color.Blue)
                )
            }
        }

    }
}

@Preview
@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun UpdateLogPreview() {
    UpdateLogScreen(rememberNavController(), null, LogEntity(0, "title", "description"))
}