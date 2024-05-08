package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Base256Encoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class n implements v2 {
    public int a() {
        return 5;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) 0);
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            sb2.append(y2Var.c());
            y2Var.f31753f++;
            if (d4.a(y2Var.d(), y2Var.f31753f, a()) != a()) {
                y2Var.b(0);
                break;
            }
        }
        int length = sb2.length() - 1;
        int a10 = y2Var.a() + length + 1;
        y2Var.c(a10);
        boolean z10 = y2Var.g().a() - a10 > 0;
        if (y2Var.i() || z10) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb2.setCharAt(0, (char) ((length / 250) + 249));
                sb2.insert(1, (char) (length % 250));
            } else {
                try {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        int length2 = sb2.length();
        for (int i10 = 0; i10 < length2; i10++) {
            y2Var.a(a(sb2.charAt(i10), y2Var.a() + 1));
        }
    }

    private static char a(char c4, int i10) {
        int i11 = c4 + ((i10 * 149) % 255) + 1;
        return i11 <= 255 ? (char) i11 : (char) (i11 - 256);
    }
}
