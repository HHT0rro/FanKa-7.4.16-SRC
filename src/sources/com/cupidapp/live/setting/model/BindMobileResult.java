package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BindMobileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BindMobileResult {

    @Nullable
    private final String message;

    public BindMobileResult(@Nullable String str) {
        this.message = str;
    }

    public static /* synthetic */ BindMobileResult copy$default(BindMobileResult bindMobileResult, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bindMobileResult.message;
        }
        return bindMobileResult.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final BindMobileResult copy(@Nullable String str) {
        return new BindMobileResult(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BindMobileResult) && s.d(this.message, ((BindMobileResult) obj).message);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.message;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "BindMobileResult(message=" + this.message + ")";
    }
}
