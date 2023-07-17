package com.diml.room;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0019\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/diml/room/Repository;", "", "logDB", "Lcom/diml/room/LogDB;", "(Lcom/diml/room/LogDB;)V", "likedLogs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/diml/dataClass/LogEntity;", "getLikedLogs", "()Lkotlinx/coroutines/flow/Flow;", "addLog", "", "logEntity", "(Lcom/diml/dataClass/LogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLog", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogsPerDate", "currentDateTimeStart", "Ljava/time/LocalDateTime;", "currentDateTimeEnd", "updateLog", "app_debug"})
public final class Repository {
    private final com.diml.room.LogDB logDB = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> likedLogs = null;
    
    public Repository(@org.jetbrains.annotations.NotNull
    com.diml.room.LogDB logDB) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addLog(@org.jetbrains.annotations.NotNull
    com.diml.dataClass.LogEntity logEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLog(@org.jetbrains.annotations.NotNull
    com.diml.dataClass.LogEntity logEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteLog(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> getLikedLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> getLogsPerDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentDateTimeStart, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentDateTimeEnd) {
        return null;
    }
}