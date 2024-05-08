package com.mobile.auth.gatewayauth.detectnet;

import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f37136a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37137b;

    /* renamed from: c, reason: collision with root package name */
    private String f37138c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f37139d;

    /* renamed from: e, reason: collision with root package name */
    private long f37140e;

    public c a(int i10) {
        try {
            this.f37139d = i10;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public c a(long j10) {
        try {
            this.f37140e = j10;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public c a(String str) {
        try {
            this.f37136a = str;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public c a(boolean z10) {
        try {
            this.f37137b = z10;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public boolean a() {
        try {
            return this.f37137b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public long b() {
        try {
            return this.f37140e;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1L;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1L;
            }
        }
    }

    public c b(String str) {
        try {
            this.f37138c = str;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String toString() {
        try {
            return "PingResult{address='" + this.f37136a + "', isReachable=" + this.f37137b + ", error='" + this.f37138c + "', errorCode=" + this.f37139d + ", timeTaken=" + this.f37140e + '}';
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
