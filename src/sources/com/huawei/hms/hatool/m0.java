package com.huawei.hms.hatool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f30176a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f30177b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + p.a();
    }

    public void a(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.lineSeparator());
        sb2.append("======================================= ");
        sb2.append(System.lineSeparator());
        sb2.append(a());
        sb2.append("");
        sb2.append(System.lineSeparator());
        sb2.append("=======================================");
        this.f30177b = i10;
        this.f30176a = true;
    }

    public void a(int i10, String str, String str2) {
    }

    public void b(int i10, String str, String str2) {
        a(i10, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i10) {
        return this.f30176a && i10 >= this.f30177b;
    }
}
