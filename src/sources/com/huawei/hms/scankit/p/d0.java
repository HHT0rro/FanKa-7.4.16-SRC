package com.huawei.hms.scankit.p;

import com.android.internal.accessibility.common.ShortcutConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: C40Encoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d0 implements v2 {
    public static void b(y2 y2Var, StringBuilder sb2) {
        y2Var.a(a(sb2, 0));
        sb2.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c4 = y2Var.c();
            y2Var.f31753f++;
            int a10 = a(c4, sb2);
            int a11 = y2Var.a() + ((sb2.length() / 3) * 2);
            y2Var.c(a11);
            int a12 = y2Var.g().a() - a11;
            if (!y2Var.i()) {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && (a12 < 2 || a12 > 2)) {
                    a10 = a(y2Var, sb2, sb3, a10);
                }
                while (sb2.length() % 3 == 1 && ((a10 <= 3 && a12 != 1) || a10 > 3)) {
                    a10 = a(y2Var, sb2, sb3, a10);
                }
            } else if (sb2.length() % 3 == 0 && d4.a(y2Var.d(), y2Var.f31753f, a()) != a()) {
                y2Var.b(0);
                break;
            }
        }
        a(y2Var, sb2);
    }

    private int a(y2 y2Var, StringBuilder sb2, StringBuilder sb3, int i10) {
        int length = sb2.length();
        sb2.delete(length - i10, length);
        y2Var.f31753f--;
        int a10 = a(y2Var.c(), sb3);
        y2Var.k();
        return a10;
    }

    public void a(y2 y2Var, StringBuilder sb2) {
        int length = (sb2.length() / 3) * 2;
        int length2 = sb2.length() % 3;
        int a10 = y2Var.a() + length;
        y2Var.c(a10);
        int a11 = y2Var.g().a() - a10;
        if (length2 == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                b(y2Var, sb2);
            }
            if (y2Var.i()) {
                y2Var.a((char) 254);
            }
        } else if (a11 == 1 && length2 == 1) {
            while (sb2.length() >= 3) {
                b(y2Var, sb2);
            }
            if (y2Var.i()) {
                y2Var.a((char) 254);
            }
            y2Var.f31753f--;
        } else if (length2 == 0) {
            while (sb2.length() >= 3) {
                b(y2Var, sb2);
            }
            if (a11 > 0 || y2Var.i()) {
                y2Var.a((char) 254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                o4.b("exception", "Exception");
            }
        }
        y2Var.b(0);
    }

    public int a(char c4, StringBuilder sb2) {
        if (c4 == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c4 >= '0' && c4 <= '9') {
            sb2.append((char) ((c4 - '0') + 4));
            return 1;
        }
        if (c4 >= 'A' && c4 <= 'Z') {
            sb2.append((char) ((c4 - 'A') + 14));
            return 1;
        }
        if (c4 < ' ') {
            sb2.append((char) 0);
            sb2.append(c4);
            return 2;
        }
        if (c4 >= '!' && c4 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c4 - '!'));
            return 2;
        }
        if (c4 >= ':' && c4 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) ((c4 - ShortcutConstants.SERVICES_SEPARATOR) + 15));
            return 2;
        }
        if (c4 >= '[' && c4 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) ((c4 - '[') + 22));
            return 2;
        }
        if (c4 >= '`' && c4 <= 127) {
            sb2.append((char) 2);
            sb2.append((char) (c4 - '`'));
            return 2;
        }
        sb2.append("\u0001\u001e");
        return a((char) (c4 - 128), sb2) + 2;
    }

    private static String a(CharSequence charSequence, int i10) {
        int charAt = (charSequence.charAt(i10) * 1600) + (charSequence.charAt(i10 + 1) * '(') + charSequence.charAt(i10 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
