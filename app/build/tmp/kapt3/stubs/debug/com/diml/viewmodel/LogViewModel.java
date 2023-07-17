package com.diml.viewmodel;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/diml/viewmodel/LogViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/diml/room/Repository;", "(Lcom/diml/room/Repository;)V", "likedLogs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/diml/dataClass/LogEntity;", "getLikedLogs", "()Lkotlinx/coroutines/flow/Flow;", "getRepository", "()Lcom/diml/room/Repository;", "addLog", "Lkotlinx/coroutines/Job;", "log", "deleteLog", "id", "", "logsPerDate", "currentDateTimeStart", "Ljava/time/LocalDateTime;", "currentDateTimeEnd", "updateLog", "app_debug"})
public final class LogViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.diml.room.Repository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> likedLogs = null;
    
    public LogViewModel(@org.jetbrains.annotations.NotNull
    com.diml.room.Repository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.diml.room.Repository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addLog(@org.jetbrains.annotations.NotNull
    com.diml.dataClass.LogEntity log) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job updateLog(@org.jetbrains.annotations.NotNull
    com.diml.dataClass.LogEntity log) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job deleteLog(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> getLikedLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> logsPerDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentDateTimeStart, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentDateTimeEnd) {
        return null;
    }
}