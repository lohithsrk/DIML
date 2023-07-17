package com.diml.room;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.diml.utils.Converter.class})
@androidx.room.Database(entities = {com.diml.dataClass.LogEntity.class}, version = 1, exportSchema = false)
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/diml/room/LogDB;", "Landroidx/room/RoomDatabase;", "()V", "logDAO", "Lcom/diml/room/LogDAO;", "Companion", "app_debug"})
public abstract class LogDB extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.diml.room.LogDB.Companion Companion = null;
    @kotlin.jvm.Volatile
    private static volatile com.diml.room.LogDB INSTANCE;
    
    public LogDB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.diml.room.LogDAO logDAO();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/diml/room/LogDB$Companion;", "", "()V", "INSTANCE", "Lcom/diml/room/LogDB;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.diml.room.LogDB getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}