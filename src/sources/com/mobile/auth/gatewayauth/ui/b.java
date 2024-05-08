package com.mobile.auth.gatewayauth.ui;

import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f37368a;

    /* renamed from: b, reason: collision with root package name */
    private String f37369b;

    /* renamed from: c, reason: collision with root package name */
    private int f37370c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f37371a;

        /* renamed from: b, reason: collision with root package name */
        private String f37372b;

        /* renamed from: c, reason: collision with root package name */
        private int f37373c;

        private a() {
        }

        public static /* synthetic */ String a(a aVar) {
            try {
                return aVar.f37371a;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ String b(a aVar) {
            try {
                return aVar.f37372b;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public static /* synthetic */ int c(a aVar) {
            try {
                return aVar.f37373c;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return -1;
            }
        }

        public a a(int i10) {
            try {
                this.f37373c = i10;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public a a(String str) {
            try {
                this.f37371a = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public b a() {
            try {
                return new b(this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }

        public a b(String str) {
            try {
                this.f37372b = str;
                return this;
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
                return null;
            }
        }
    }

    private b(a aVar) {
        this.f37368a = a.a(aVar);
        this.f37369b = a.b(aVar);
        this.f37370c = a.c(aVar);
    }

    public static a a() {
        try {
            return new a();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String b() {
        try {
            return this.f37368a;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public String c() {
        try {
            return this.f37369b;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public int d() {
        try {
            return this.f37370c;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }
}
