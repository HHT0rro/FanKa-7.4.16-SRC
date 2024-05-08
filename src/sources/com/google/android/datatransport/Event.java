package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i10, T t2) {
        return new AutoValue_Event(Integer.valueOf(i10), t2, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i10, T t2) {
        return new AutoValue_Event(Integer.valueOf(i10), t2, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i10, T t2) {
        return new AutoValue_Event(Integer.valueOf(i10), t2, Priority.HIGHEST);
    }

    @Nullable
    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> Event<T> ofData(T t2) {
        return new AutoValue_Event(null, t2, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(T t2) {
        return new AutoValue_Event(null, t2, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(T t2) {
        return new AutoValue_Event(null, t2, Priority.HIGHEST);
    }
}
