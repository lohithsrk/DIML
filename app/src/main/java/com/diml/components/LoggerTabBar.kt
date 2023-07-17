package com.diml.components

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.diml.ui.theme.accent
import com.diml.viewmodel.LogViewModel
import com.google.accompanist.pager.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar
import kotlin.math.abs

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun LoggerTabBar(navController: NavController, logViewModel: LogViewModel) {
    val pagerState = rememberPagerState(4)
    val logs by logViewModel.logsPerDate(
        allDay(abs(pagerState.currentPage - 4).toLong())[0],
        allDay(abs(pagerState.currentPage - 4).toLong())[1]
    )
        .collectAsState(initial = emptyList())
    val pages = listOf(
        date(0), date(-1), date(-2), date(-3), date(-4)
    )

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
                text = { Text(text = title, color = Color.White) },
                selected = pagerState.currentPage == index,
                onClick = { /* TODO */ },
            )
        }
    }

    HorizontalPager(
        count = pages.size,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(10.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            items(items = logs) {
                Log(it, navController,logViewModel)
            }
            item {
                if (logs.isEmpty()) {
                    if (pages[4] == pages[pagerState.currentPage]) {

                        Button(
                            onClick = { navController.navigate("addlog") },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = accent)
                        ) {
                            Text(text = "Start my day... ", color = Color.White)
                        }
                    } else {

                        Text(
                            text = "No logs found on this day",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
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

@SuppressLint("SimpleDateFormat")
fun date(i: Int): String {
    val simpleDateFormat = SimpleDateFormat("dd MMM")
    val cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.DATE, i);
    return simpleDateFormat.format(cal.time)
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat")
fun allDay(i: Long): List<LocalDateTime> {
    return listOf(
        LocalDateTime.of(LocalDate.now().minusDays(i), LocalTime.of(0, 0)),
        LocalDateTime.of(LocalDate.now().minusDays(i), LocalTime.of(23, 59, 59)),
    )
}