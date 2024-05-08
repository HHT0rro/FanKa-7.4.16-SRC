package com.huawei.appgallery.agd.serverreq.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OKHttpClientParams {
    public static final int DEFALUT_CONNECTION_TIMEOUT = 10;
    public static final int DEFALUT_KEEP_ALIVE_DURATION = 5;
    public static final int DEFALUT_MAX_HTTP1_REQUESTS = 5;
    public static final int DEFALUT_MAX_HTTP2_REQUESTS = 32;
    public static final int DEFALUT_MAX_IDLE_CONNECTIONS = 5;
    public static final int DEFALUT_MAX_REQEUSTS = 64;
    public static final int DEFALUT_READ_TIMEOUT = 10;
    public static final int DEFALUT_WRITE_TIMEOUT = 10;

    /* renamed from: a, reason: collision with root package name */
    public int f27523a = 5;

    /* renamed from: b, reason: collision with root package name */
    public int f27524b = 5;

    /* renamed from: c, reason: collision with root package name */
    public int f27525c = 10;

    /* renamed from: d, reason: collision with root package name */
    public int f27526d = 10;

    /* renamed from: e, reason: collision with root package name */
    public int f27527e = 10;

    public int getConnectTimeout() {
        return this.f27525c;
    }

    public int getKeepAliveDuration() {
        return this.f27524b;
    }

    public int getMaxIdleConnections() {
        return this.f27523a;
    }

    public int getReadTimeout() {
        return this.f27526d;
    }

    public int getWriteTimeout() {
        return this.f27527e;
    }

    public void setConnectTimeout(int i10) {
        this.f27525c = i10;
    }

    public void setKeepAliveDuration(int i10) {
        this.f27524b = i10;
    }

    public void setMaxIdleConnections(int i10) {
        this.f27523a = i10;
    }

    public void setReadTimeout(int i10) {
        this.f27526d = i10;
    }

    public void setWriteTimeout(int i10) {
        this.f27527e = i10;
    }
}
