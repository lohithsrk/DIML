package com.diml.room;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J$\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\'J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/diml/room/LogDAO;", "", "addLog", "", "log", "Lcom/diml/dataClass/LogEntity;", "(Lcom/diml/dataClass/LogEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLog", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLikedLogs", "Lkotlinx/coroutines/flow/Flow;", "", "getLogsPerDate", "currentDateTimeStart", "Ljava/time/LocalDateTime;", "currentDateTimeEnd", "updateLog", "app_debug"})
public abstract interface LogDAO {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert
    public abstract java.lang.Object addLog(@org.jetbrains.annotations.NotNull
    com.diml.dataClass.LogEntity log, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateLog(@org.jetbrains.annotations.NotNull
    com.diml.dataClass.LogEntity log, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM Log WHERE id = :id")
    public abstract java.lang.Object deleteLog(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Log WHERE liked = 1")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> getLikedLogs();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Log WHERE date >= :currentDateTimeStart AND date <= :currentDateTimeEnd")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.diml.dataClass.LogEntity>> getLogsPerDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentDateTimeStart, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime currentDateTimeEnd);
}