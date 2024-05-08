package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: X12Encoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class n8 extends d0 {
    @Override // com.huawei.hms.scankit.p.d0
    public int a() {
        return 3;
    }

    @Override // com.huawei.hms.scankit.p.d0, com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c4 = y2Var.c();
            y2Var.f31753f++;
            a(c4, sb2);
            if (sb2.length() % 3 == 0) {
                d0.b(y2Var, sb2);
                if (d4.a(y2Var.d(), y2Var.f31753f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            }
        }
        a(y2Var, sb2);
    }

    @Override // com.huawei.hms.scankit.p.d0
    public int a(char c4, StringBuilder sb2) {
        if (c4 == '\r') {
            sb2.append((char) 0);
        } else if (c4 == ' ') {
            sb2.append((char) 3);
        } else if (c4 == '*') {
            sb2.append((char) 1);
        } else if (c4 == '>') {
            sb2.append((char) 2);
        } else if (c4 >= '0' && c4 <= '9') {
            sb2.append((char) ((c4 - '0') + 4));
        } else if (c4 >= 'A' && c4 <= 'Z') {
            sb2.append((char) ((c4 - 'A') + 14));
        } else {
            d4.a(c4);
        }
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.d0
    public void a(y2 y2Var, StringBuilder sb2) {
        y2Var.l();
        int a10 = y2Var.g().a() - y2Var.a();
        y2Var.f31753f -= sb2.length();
        if (y2Var.f() > 1 || a10 > 1 || y2Var.f() != a10) {
            y2Var.a((char) 254);
        }
        if (y2Var.e() < 0) {
            y2Var.b(0);
        }
    }
}
