package com.huawei.hms.common.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ResolveClientBean {

    /* renamed from: a, reason: collision with root package name */
    private final int f29730a;

    /* renamed from: b, reason: collision with root package name */
    private final AnyClient f29731b;

    /* renamed from: c, reason: collision with root package name */
    private int f29732c;

    public ResolveClientBean(AnyClient anyClient, int i10) {
        this.f29731b = anyClient;
        this.f29730a = Objects.hashCode(anyClient);
        this.f29732c = i10;
    }

    public void clientReconnect() {
        this.f29731b.connect(this.f29732c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f29731b.equals(((ResolveClientBean) obj).f29731b);
    }

    public AnyClient getClient() {
        return this.f29731b;
    }

    public int hashCode() {
        return this.f29730a;
    }
}
