package com.alibaba.security.realidentity.oss.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OSSRequest {

    /* renamed from: k, reason: collision with root package name */
    public boolean f4049k = true;

    /* renamed from: l, reason: collision with root package name */
    public Enum f4050l = CRC64Config.NULL;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum CRC64Config {
        NULL,
        YES,
        NO
    }

    private boolean a() {
        return this.f4049k;
    }

    private Enum b() {
        return this.f4050l;
    }

    private void a(boolean z10) {
        this.f4049k = z10;
    }

    private void a(Enum r12) {
        this.f4050l = r12;
    }
}
