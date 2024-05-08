package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Timed<T> {
    public final long time;
    public final TimeUnit unit;
    public final T value;

    public Timed(@NonNull T t2, long j10, @NonNull TimeUnit timeUnit) {
        this.value = t2;
        this.time = j10;
        this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        return ObjectHelper.equals(this.value, timed.value) && this.time == timed.time && ObjectHelper.equals(this.unit, timed.unit);
    }

    public int hashCode() {
        T t2 = this.value;
        int hashCode = t2 != null ? t2.hashCode() : 0;
        long j10 = this.time;
        return (((hashCode * 31) + ((int) (j10 ^ (j10 >>> 31)))) * 31) + this.unit.hashCode();
    }

    public long time() {
        return this.time;
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + ((Object) this.unit) + ", value=" + ((Object) this.value) + "]";
    }

    @NonNull
    public TimeUnit unit() {
        return this.unit;
    }

    @NonNull
    public T value() {
        return this.value;
    }

    public long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.time, this.unit);
    }
}
