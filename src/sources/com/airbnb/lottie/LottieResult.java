package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LottieResult<V> {

    @Nullable
    private final Throwable exception;

    @Nullable
    private final V value;

    public LottieResult(V v2) {
        this.value = v2;
        this.exception = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (getValue() != null && getValue().equals(lottieResult.getValue())) {
            return true;
        }
        if (getException() == null || lottieResult.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    @Nullable
    public Throwable getException() {
        return this.exception;
    }

    @Nullable
    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }

    public LottieResult(Throwable th) {
        this.exception = th;
        this.value = null;
    }
}
