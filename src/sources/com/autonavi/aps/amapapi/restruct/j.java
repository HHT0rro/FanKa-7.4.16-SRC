package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;

/* compiled from: WifiInfoWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private WifiInfo f9488a;

    /* renamed from: b, reason: collision with root package name */
    private String f9489b;

    /* renamed from: c, reason: collision with root package name */
    private String f9490c;

    /* renamed from: d, reason: collision with root package name */
    private int f9491d = -1;

    public j(WifiInfo wifiInfo) {
        this.f9488a = wifiInfo;
    }

    public final String a() {
        if (this.f9490c == null) {
            this.f9490c = h.a(this.f9488a);
        }
        return this.f9490c;
    }

    public final String b() {
        if (this.f9489b == null) {
            this.f9489b = h.b(this.f9488a);
        }
        return this.f9489b;
    }

    public final int c() {
        if (this.f9491d == -1) {
            this.f9491d = h.c(this.f9488a);
        }
        return this.f9491d;
    }

    public final boolean d() {
        return (this.f9488a == null || TextUtils.isEmpty(b()) || !com.autonavi.aps.amapapi.utils.j.a(a())) ? false : true;
    }
}
