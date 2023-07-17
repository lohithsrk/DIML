package com.diml.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/diml/utils/Converter;", "", "()V", "dateToTimestamp", "", "date", "Ljava/time/LocalDateTime;", "fromTimestamp", "value", "app_debug"})
public final class Converter {
    
    public Converter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDateTime fromTimestamp(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.lang.String dateToTimestamp(@org.jetbrains.annotations.Nullable
    java.time.LocalDateTime date) {
        return null;
    }
}