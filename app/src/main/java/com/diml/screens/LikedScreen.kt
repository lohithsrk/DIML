package com.diml.screens

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.diml.components.BottomAppBar
import com.diml.dataClass.LogEntity
import com.diml.ui.theme.accent
import com.diml.viewmodel.LogViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar

@OptIn(ExperimentalPagerApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LikedScreen(navController: NavController, logViewModel: LogViewModel) {
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

            val logs by logViewModel.likedLogs.collectAsState(initial = emptyList())
            val likedLogs = segregateLikedLogsByDate(logs)
            val pages = likedLogs.keys.toMutableList().map { it -> date(it) }
            Log.i("TTT", pages.size.toString())
            val pagerState = rememberPagerState(pages.size)
            val indicator = @Composable { tabPositions: List<TabPosition> ->
                CustomIndicator(tabPositions, pagerState)
            }

            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = indicator, backgroundColor = accent
            ) {
                pages.reversed().forEachIndexed { index, title ->

                    Tab(
                        modifier = Modifier.zIndex(6f),
                        text = { Text(text = "title", color = Color.White) },
                        selected = pagerState.currentPage == index,
                        onClick = { /* TODO */ },
                    )
                }
            }

//            HorizontalPager(
//                count = pages.size,
//                state = pagerState,
//                modifier = Modifier.fillMaxSize()
//            ) { page ->
//
////                LazyColumn(
////                    modifier = Modifier
////                        .fillMaxSize()
////                        .background(Color.Black)
////                        .padding(10.dp),
////                    verticalArrangement = Arrangement.Bottom,
////                ) {
////                    items(items = logs) {
////                        Log(it, navController, logViewModel)
////                    }
////                    item {
////                        if (logs.isEmpty()) {
////                            Text(
////                                text = "No logs found",
////                                color = Color.White,
////                                textAlign = TextAlign.Center,
////                                modifier = Modifier.fillMaxWidth()
////                            )
////                        }
////                    }
////                }
//            }
        }
        BottomAppBar(navController, "liked")
    }


}


@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage, label = "")
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(color = Color(0xFFFF7455), RoundedCornerShape(50))
            .border(BorderStroke(2.dp, Color(0xFFC13D25)), RoundedCornerShape(50))
            .zIndex(1f)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat")
fun date(d: LocalDate): String {
    val simpleDateFormat = SimpleDateFormat("dd MMM")
    val calendar: Calendar = Calendar.getInstance()
    calendar.set(d.year, d.monthValue, d.dayOfMonth)
    return simpleDateFormat.format(calendar.time)
}

@RequiresApi(Build.VERSION_CODES.O)
fun segregateLikedLogsByDate(logs: List<LogEntity>): HashMap<LocalDate, HashSet<LogEntity>> {
    val segregatedLikedLogs = HashMap<LocalDate, HashSet<LogEntity>>()

    logs.forEachIndexed { _, log ->
        if (segregatedLikedLogs[log.date.toLocalDate()]?.filter {
                log.date >= LocalDateTime.of(log.date.toLocalDate(), LocalTime.of(0, 0)) &&
                        log.date <= LocalDateTime.of(
                    log.date.toLocalDate(),
                    LocalTime.of(23, 59, 59)
                )
            } != null) {
            segregatedLikedLogs[log.date.toLocalDate()]?.add(log)
        } else {
            segregatedLikedLogs[log.date.toLocalDate()] = hashSetOf(log)
        }
    }


    return segregatedLikedLogs
}