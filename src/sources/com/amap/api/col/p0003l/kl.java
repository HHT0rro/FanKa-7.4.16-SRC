package com.amap.api.col.p0003l;

import java.io.Serializable;

/* compiled from: AmapCell.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class kl implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f6644a;

    /* renamed from: b, reason: collision with root package name */
    public String f6645b;

    /* renamed from: c, reason: collision with root package name */
    public int f6646c;

    /* renamed from: d, reason: collision with root package name */
    public int f6647d;

    /* renamed from: e, reason: collision with root package name */
    public long f6648e;

    /* renamed from: f, reason: collision with root package name */
    public long f6649f;

    /* renamed from: g, reason: collision with root package name */
    public int f6650g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6651h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6652i;

    public kl() {
        this.f6644a = "";
        this.f6645b = "";
        this.f6646c = 99;
        this.f6647d = Integer.MAX_VALUE;
        this.f6648e = 0L;
        this.f6649f = 0L;
        this.f6650g = 0;
        this.f6652i = true;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            kv.a(e2);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract kl clone();

    public final int b() {
        return a(this.f6644a);
    }

    public final int c() {
        return a(this.f6645b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f6644a + ", mnc=" + this.f6645b + ", signalStrength=" + this.f6646c + ", asulevel=" + this.f6647d + ", lastUpdateSystemMills=" + this.f6648e + ", lastUpdateUtcMills=" + this.f6649f + ", age=" + this.f6650g + ", main=" + this.f6651h + ", newapi=" + this.f6652i + '}';
    }

    public final void a(kl klVar) {
        this.f6644a = klVar.f6644a;
        this.f6645b = klVar.f6645b;
        this.f6646c = klVar.f6646c;
        this.f6647d = klVar.f6647d;
        this.f6648e = klVar.f6648e;
        this.f6649f = klVar.f6649f;
        this.f6650g = klVar.f6650g;
        this.f6651h = klVar.f6651h;
        this.f6652i = klVar.f6652i;
    }

    public kl(boolean z10, boolean z11) {
        this.f6644a = "";
        this.f6645b = "";
        this.f6646c = 99;
        this.f6647d = Integer.MAX_VALUE;
        this.f6648e = 0L;
        this.f6649f = 0L;
        this.f6650g = 0;
        this.f6651h = z10;
        this.f6652i = z11;
    }
}
