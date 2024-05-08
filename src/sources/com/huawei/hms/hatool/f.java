package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f implements g {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f30095a;

    /* renamed from: b, reason: collision with root package name */
    private String f30096b;

    /* renamed from: c, reason: collision with root package name */
    private String f30097c;

    /* renamed from: d, reason: collision with root package name */
    private String f30098d;

    /* renamed from: e, reason: collision with root package name */
    private String f30099e;

    /* renamed from: f, reason: collision with root package name */
    private List<b1> f30100f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f30095a = (byte[]) bArr.clone();
        this.f30096b = str;
        this.f30097c = str2;
        this.f30099e = str3;
        this.f30098d = str4;
        this.f30100f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f30096b, this.f30095a, map);
    }

    private Map<String, String> a() {
        return k.b(this.f30097c, this.f30099e, this.f30098d);
    }

    private void b() {
        b0.c().a(new d1(this.f30100f, this.f30097c, this.f30098d, this.f30099e));
    }

    @Override // java.lang.Runnable
    public void run() {
        v.c("hmsSdk", "send data running");
        int b4 = a(a()).b();
        if (b4 != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f30098d, this.f30099e, this.f30097c, Integer.valueOf(b4));
    }
}
