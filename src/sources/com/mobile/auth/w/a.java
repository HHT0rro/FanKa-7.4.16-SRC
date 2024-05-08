package com.mobile.auth.w;

import android.util.SparseArray;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.VendorConfig;
import com.nirvana.tools.requestqueue.TimeoutResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a extends TimeoutResponse {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37655a;

    /* renamed from: b, reason: collision with root package name */
    private String f37656b;

    /* renamed from: c, reason: collision with root package name */
    private String f37657c;

    /* renamed from: d, reason: collision with root package name */
    private String f37658d;

    public a(boolean z10, String str, String str2) {
        super(z10);
        this.f37656b = str;
        this.f37658d = str2;
    }

    public void a(String str) {
        try {
            this.f37657c = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(boolean z10) {
        try {
            this.f37655a = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean a() {
        try {
            return this.f37655a;
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

    public String b() {
        try {
            String str = this.f37657c;
            return str == null ? "" : str;
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

    public String c() {
        try {
            return this.f37656b;
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

    public String d() {
        try {
            return this.f37658d;
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

    public abstract SparseArray<VendorConfig> e();
}
