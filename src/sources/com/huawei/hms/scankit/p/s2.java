package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EdifactEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s2 implements v2 {
    public int a() {
        return 4;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            a(y2Var.c(), sb2);
            y2Var.f31753f++;
            if (sb2.length() >= 4) {
                y2Var.a(a(sb2, 0));
                sb2.delete(0, 4);
                if (d4.a(y2Var.d(), y2Var.f31753f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            }
        }
        sb2.append((char) 31);
        a(y2Var, sb2);
    }

    private static void a(y2 y2Var, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z10 = true;
            if (length == 1) {
                y2Var.l();
                int a10 = y2Var.g().a() - y2Var.a();
                int f10 = y2Var.f();
                if (f10 > a10) {
                    y2Var.c(y2Var.a() + 1);
                    a10 = y2Var.g().a() - y2Var.a();
                }
                if (f10 <= a10 && a10 <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i10 = length - 1;
                String a11 = a(charSequence, 0);
                if (!(!y2Var.i()) || i10 > 2) {
                    z10 = false;
                }
                if (i10 <= 2) {
                    y2Var.c(y2Var.a() + i10);
                    if (y2Var.g().a() - y2Var.a() >= 3) {
                        y2Var.c(y2Var.a() + a11.length());
                        z10 = false;
                    }
                }
                if (z10) {
                    y2Var.k();
                    y2Var.f31753f -= i10;
                } else {
                    y2Var.a(a11);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            y2Var.b(0);
        }
    }

    private static void a(char c4, StringBuilder sb2) {
        if (c4 >= ' ' && c4 <= '?') {
            sb2.append(c4);
        } else if (c4 >= '@' && c4 <= '^') {
            sb2.append((char) (c4 - '@'));
        } else {
            d4.a(c4);
        }
    }

    private static String a(CharSequence charSequence, int i10) {
        int length = charSequence.length() - i10;
        if (length != 0) {
            int charAt = (charSequence.charAt(i10) << 18) + ((length >= 2 ? charSequence.charAt(i10 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i10 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i10 + 3) : (char) 0);
            char c4 = (char) ((charAt >> 16) & 255);
            char c10 = (char) ((charAt >> 8) & 255);
            char c11 = (char) (charAt & 255);
            StringBuilder sb2 = new StringBuilder(3);
            sb2.append(c4);
            if (length >= 2) {
                sb2.append(c10);
            }
            if (length >= 3) {
                sb2.append(c11);
            }
            return sb2.toString();
        }
        try {
            throw new IllegalStateException("StringBuilder must not be empty");
        } catch (Exception e2) {
            throw e2;
        }
    }
}
