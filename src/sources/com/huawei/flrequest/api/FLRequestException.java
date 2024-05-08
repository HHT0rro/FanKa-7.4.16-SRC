package com.huawei.flrequest.api;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLRequestException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f28703a;

    /* renamed from: b, reason: collision with root package name */
    private final int f28704b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ErrorCode {
        public static final int ERROR = -1;
        public static final int ERROR_INVALID_DATA = 5;
        public static final int ERROR_INVALID_PARAM = 4;
        public static final int ERROR_INVALID_SERVER_URL = 6;
        public static final int ERROR_IO = 2;
        public static final int ERROR_NO_DATA = 8;
        public static final int ERROR_NO_NETWORK = 3;
        public static final int ERROR_RENDER = 7;
        public static final int ERROR_TIMEOUT = 1;
        public static final int OK = 0;
    }

    public FLRequestException(int i10, String str) {
        this(i10, 0, str, null);
    }

    public int getErrorCode() {
        return this.f28704b;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        return super.getMessage() + " | error: " + this.f28704b + ", response: " + this.f28703a + ".";
    }

    public String getOriginalMessage() {
        return super.getMessage();
    }

    public int getResponseCode() {
        return this.f28703a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }

    public FLRequestException(int i10, int i11, String str) {
        this(i10, i11, str, null);
    }

    public FLRequestException(int i10, String str, Throwable th) {
        this(i10, 0, str, th);
    }

    public FLRequestException(int i10, int i11, String str, Throwable th) {
        super(str, th);
        this.f28704b = i10;
        this.f28703a = i11;
    }
}
