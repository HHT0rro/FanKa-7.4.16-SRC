package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ASCIIEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b implements v2 {
    public int a() {
        return 0;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        if (d4.a(y2Var.d(), y2Var.f31753f) >= 2) {
            y2Var.a(a(y2Var.d().charAt(y2Var.f31753f), y2Var.d().charAt(y2Var.f31753f + 1)));
            y2Var.f31753f += 2;
            return;
        }
        char c4 = y2Var.c();
        int a10 = d4.a(y2Var.d(), y2Var.f31753f, a());
        if (a10 == a()) {
            if (d4.c(c4)) {
                y2Var.a((char) 235);
                y2Var.a((char) ((c4 - 128) + 1));
                y2Var.f31753f++;
                return;
            } else {
                y2Var.a((char) (c4 + 1));
                y2Var.f31753f++;
                return;
            }
        }
        if (a10 == 1) {
            y2Var.a((char) 230);
            y2Var.b(1);
            return;
        }
        if (a10 == 2) {
            y2Var.a((char) 239);
            y2Var.b(2);
            return;
        }
        if (a10 == 3) {
            y2Var.a((char) 238);
            y2Var.b(3);
            return;
        }
        if (a10 == 4) {
            y2Var.a((char) 240);
            y2Var.b(4);
        } else {
            if (a10 == 5) {
                y2Var.a((char) 231);
                y2Var.b(5);
                return;
            }
            try {
                throw new IllegalStateException("Illegal mode: " + a10);
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static char a(char c4, char c10) {
        if (d4.b(c4) && d4.b(c10)) {
            return (char) (((c4 - '0') * 10) + (c10 - '0') + 130);
        }
        try {
            throw new IllegalArgumentException("not digits: " + c4 + c10);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
