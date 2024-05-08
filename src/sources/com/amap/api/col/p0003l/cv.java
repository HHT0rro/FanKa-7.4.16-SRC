package com.amap.api.col.p0003l;

import android.text.TextUtils;

/* compiled from: EngineStyleKeyItem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cv {

    /* renamed from: a, reason: collision with root package name */
    public int f5255a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f5256b;

    /* renamed from: c, reason: collision with root package name */
    public int f5257c;

    /* renamed from: d, reason: collision with root package name */
    public int f5258d;

    /* renamed from: e, reason: collision with root package name */
    public String f5259e;

    /* renamed from: f, reason: collision with root package name */
    public String f5260f;

    /* renamed from: g, reason: collision with root package name */
    public String f5261g;

    public cv(int i10, int[] iArr, String str, String str2, String str3) {
        this.f5255a = i10;
        this.f5256b = iArr;
        this.f5259e = str;
        this.f5260f = str2;
        this.f5261g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.f5257c = -1000;
        if ("regions".equals(str)) {
            this.f5257c = 1001;
        } else if ("water".equals(str)) {
            this.f5257c = 1002;
        } else if ("buildings".equals(str)) {
            this.f5257c = 1003;
        } else if ("roads".equals(str)) {
            this.f5257c = 1004;
        } else if ("labels".equals(str)) {
            this.f5257c = 1005;
        } else if ("borders".equals(str)) {
            this.f5257c = 1006;
        }
        this.f5258d = (i10 * 1000) + iArr.hashCode();
    }
}
