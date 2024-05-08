package com.huawei.flexiblelayout.services.imageloader;

import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Length {
    public final Unit unit;
    public final float value;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Unit {
        DEFAULT,
        PERCENT
    }

    public Length(float f10, @NonNull Unit unit) {
        this.value = f10;
        this.unit = unit;
    }

    public static Length make(float f10, @NonNull Unit unit) {
        return new Length(f10, unit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Length.class != obj.getClass()) {
            return false;
        }
        Length length = (Length) obj;
        return Float.compare(length.value, this.value) == 0 && this.unit == length.unit;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.value), this.unit);
    }

    public static Length make(float f10) {
        return new Length(f10, Unit.DEFAULT);
    }
}
