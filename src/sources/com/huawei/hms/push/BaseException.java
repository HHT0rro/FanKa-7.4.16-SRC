package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BaseException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f30351a;

    /* renamed from: b, reason: collision with root package name */
    private final ErrorEnum f30352b;

    public BaseException(int i10) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i10);
        this.f30352b = fromCode;
        this.f30351a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f30351a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f30352b.getMessage();
    }
}
