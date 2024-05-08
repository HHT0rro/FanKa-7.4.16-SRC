package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Result.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class Result<T> {

    @Nullable
    private final String buttonName;

    @Nullable
    private final T data;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String message;

    @Nullable
    private final Integer status;

    @Nullable
    private final String style;
    private final boolean success;

    public Result() {
        this(null, false, null, null, null, null, null, 127, null);
    }

    public Result(@Nullable T t2, boolean z10, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.data = t2;
        this.success = z10;
        this.status = num;
        this.message = str;
        this.style = str2;
        this.jumpUrl = str3;
        this.buttonName = str4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Result copy$default(Result result, Object obj, boolean z10, Integer num, String str, String str2, String str3, String str4, int i10, Object obj2) {
        T t2 = obj;
        if ((i10 & 1) != 0) {
            t2 = result.data;
        }
        if ((i10 & 2) != 0) {
            z10 = result.success;
        }
        boolean z11 = z10;
        if ((i10 & 4) != 0) {
            num = result.status;
        }
        Integer num2 = num;
        if ((i10 & 8) != 0) {
            str = result.message;
        }
        String str5 = str;
        if ((i10 & 16) != 0) {
            str2 = result.style;
        }
        String str6 = str2;
        if ((i10 & 32) != 0) {
            str3 = result.jumpUrl;
        }
        String str7 = str3;
        if ((i10 & 64) != 0) {
            str4 = result.buttonName;
        }
        return result.copy(t2, z11, num2, str5, str6, str7, str4);
    }

    @Nullable
    public final T component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.success;
    }

    @Nullable
    public final Integer component3() {
        return this.status;
    }

    @Nullable
    public final String component4() {
        return this.message;
    }

    @Nullable
    public final String component5() {
        return this.style;
    }

    @Nullable
    public final String component6() {
        return this.jumpUrl;
    }

    @Nullable
    public final String component7() {
        return this.buttonName;
    }

    @NotNull
    public final Result<T> copy(@Nullable T t2, boolean z10, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new Result<>(t2, z10, num, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return s.d(this.data, result.data) && this.success == result.success && s.d(this.status, result.status) && s.d(this.message, result.message) && s.d(this.style, result.style) && s.d(this.jumpUrl, result.jumpUrl) && s.d(this.buttonName, result.buttonName);
    }

    @Nullable
    public final String getButtonName() {
        return this.buttonName;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        T t2 = this.data;
        int hashCode = (t2 == null ? 0 : t2.hashCode()) * 31;
        boolean z10 = this.success;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        Integer num = this.status;
        int hashCode2 = (i11 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.message;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.style;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.jumpUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buttonName;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        T t2 = this.data;
        boolean z10 = this.success;
        Integer num = this.status;
        return "Result(data=" + ((Object) t2) + ", success=" + z10 + ", status=" + ((Object) num) + ", message=" + this.message + ", style=" + this.style + ", jumpUrl=" + this.jumpUrl + ", buttonName=" + this.buttonName + ")";
    }

    public /* synthetic */ Result(Object obj, boolean z10, Integer num, String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4);
    }
}
