package com.cupidapp.live.base.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResultErrorHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ResultException extends RuntimeException {

    @Nullable
    private final String buttonName;

    @Nullable
    private final Integer errorCode;

    @Nullable
    private final String errorMessage;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String style;

    public /* synthetic */ ResultException(Integer num, String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? -1 : num, (i10 & 2) != 0 ? "服务异常!" : str, str2, str3, str4);
    }

    @Nullable
    public final String getButtonName() {
        return this.buttonName;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final ResultShowErrorStyle getResultShowErrorStyle() {
        String str = this.style;
        ResultShowErrorStyle resultShowErrorStyle = ResultShowErrorStyle.ALERT;
        if (s.d(str, resultShowErrorStyle.getValue())) {
            return resultShowErrorStyle;
        }
        ResultShowErrorStyle resultShowErrorStyle2 = ResultShowErrorStyle.JUMP;
        if (s.d(str, resultShowErrorStyle2.getValue())) {
            return resultShowErrorStyle2;
        }
        ResultShowErrorStyle resultShowErrorStyle3 = ResultShowErrorStyle.TOAST;
        if (s.d(str, resultShowErrorStyle3.getValue())) {
            return resultShowErrorStyle3;
        }
        return null;
    }

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    public ResultException(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        super(str);
        this.errorCode = num;
        this.errorMessage = str;
        this.style = str2;
        this.jumpUrl = str3;
        this.buttonName = str4;
    }
}
