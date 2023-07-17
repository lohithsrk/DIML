package com.diml.screens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0003\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001aH\u0010\u0010\u001a4\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0015`\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003H\u0007\u00a8\u0006\u0017"}, d2 = {"CustomIndicator", "", "tabPositions", "", "Landroidx/compose/material/TabPosition;", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "LikedScreen", "navController", "Landroidx/navigation/NavController;", "logViewModel", "Lcom/diml/viewmodel/LogViewModel;", "date", "", "d", "Ljava/time/LocalDate;", "segregateLikedLogsByDate", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lcom/diml/dataClass/LogEntity;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "logs", "app_debug"})
public final class LikedScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void LikedScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    com.diml.viewmodel.LogViewModel logViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    private static final void CustomIndicator(java.util.List<androidx.compose.material.TabPosition> tabPositions, com.google.accompanist.pager.PagerState pagerState) {
    }
    
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final java.lang.String date(@org.jetbrains.annotations.NotNull
    java.time.LocalDate d) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final java.util.HashMap<java.time.LocalDate, java.util.HashSet<com.diml.dataClass.LogEntity>> segregateLikedLogsByDate(@org.jetbrains.annotations.NotNull
    java.util.List<com.diml.dataClass.LogEntity> logs) {
        return null;
    }
}