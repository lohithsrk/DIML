package com.diml.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diml.R
import com.diml.dataClass.LogEntity
import com.diml.ui.theme.DIMLTheme
import com.diml.ui.theme.accent
import com.diml.viewmodel.LogViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Log(log: LogEntity, navController: NavController, logViewModel: LogViewModel?) {
    var isContextMenuVisible by rememberSaveable() {
        mutableStateOf(false)
    }
    var pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }

    var itemWidth by remember {
        mutableStateOf(0.dp)
    }
    val density = LocalDensity.current

    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    itemWidth = with(density) { it.width.toDp() }
                }
        ) {
            Text(text = log.title, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${log.date.hour}:${log.date.minute}",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(end = 5.dp)
                )

                IconButton(
                    onClick = {
                        isContextMenuVisible = true

                    }, modifier = Modifier
                        .width(15.dp)
                        .height(15.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.ellipsis),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }


        DropdownMenuComposable(
            isContextMenuVisible,
            { isContextMenuVisible = false },
            pressOffset,
            itemWidth, navController, log, logViewModel!!
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(end = 6.dp)
        ) {

            Text(
                text = log.description,
                color = Color.Gray,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(
                color = Color.DarkGray, modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DropdownMenuComposable(
    isContextMenuVisible: Boolean,
    setIsContextMenuVisible: () -> Unit,
    pressOffset: DpOffset,
    itemWidth: Dp,
    navController: NavController,
    log: LogEntity,
    logViewModel: LogViewModel
) {
    var itemHeight by remember {
        mutableStateOf(0.dp)
    }
    val density = LocalDensity.current

    DropdownMenu(
        expanded = isContextMenuVisible,
        onDismissRequest = setIsContextMenuVisible,
        modifier = Modifier
            .background(accent)
            .onSizeChanged {
                itemHeight = with(density) { it.height.toDp() }
            },
        offset = pressOffset.copy(
            y = pressOffset.y,
            x = pressOffset.x + itemWidth
        )
    ) {
        DropdownMenuItem(onClick = {
            setIsContextMenuVisible()
            log.liked = !log.liked
            logViewModel.updateLog(log)
        }) {
            Text(text = if (!log.liked) "Like" else "Unlike", color = Color.White)
        }
        if (log.date >= LocalDateTime.of(LocalDate.now().minusDays(0), LocalTime.of(0, 0)) &&
            log.date <= LocalDateTime.of(LocalDate.now().minusDays(0), LocalTime.of(23, 59, 59))
        ) {
            DropdownMenuItem(onClick = {
                setIsContextMenuVisible()
                navController.navigate("updatelog/${log.id}/${log.title}/${log.description}")
            }) {
                Text(text = "Edit", color = Color.White)
            }
            DropdownMenuItem(onClick = {
                setIsContextMenuVisible()
                logViewModel.deleteLog(log.id)
            }) {
                Text(text = "Delete", color = Color.White)
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun LogPreview() {
    DIMLTheme {
        Log(LogEntity(0, "title", "Description"), rememberNavController(), null)
    }
}