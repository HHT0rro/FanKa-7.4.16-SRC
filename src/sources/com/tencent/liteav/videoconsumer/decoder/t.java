package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private boolean f43999a = false;

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        s sVar = new s(inputStream, byteArrayOutputStream);
        sVar.b(8);
        int a10 = (int) sVar.a();
        sVar.b(8);
        sVar.a();
        sVar.d();
        boolean z10 = false;
        if (a10 == 100 || a10 == 110 || a10 == 122 || a10 == 144) {
            if (sVar.c() == 3) {
                sVar.b(1);
            }
            sVar.d();
            sVar.d();
            sVar.b(1);
            if (sVar.a(true)) {
                for (int i10 = 0; i10 < 8; i10++) {
                    if (sVar.a(true)) {
                        if (i10 < 6) {
                            sVar.c(16);
                        } else {
                            sVar.c(64);
                        }
                    }
                }
            }
        }
        sVar.d();
        int c4 = sVar.c();
        if (c4 == 0) {
            sVar.d();
        } else if (c4 == 1) {
            sVar.b(1);
            sVar.d();
            sVar.d();
            int c10 = sVar.c();
            for (int i11 = 0; i11 < c10; i11++) {
                sVar.d();
            }
        }
        sVar.c();
        sVar.b(1);
        sVar.d();
        sVar.d();
        if (!sVar.a(true)) {
            sVar.b(1);
        }
        sVar.b(1);
        if (sVar.a(true)) {
            sVar.d();
            sVar.d();
            sVar.d();
            sVar.d();
        }
        if (sVar.a(false)) {
            sVar.b(true);
            if (sVar.a(true) && ((int) sVar.a()) == 255) {
                sVar.b(16);
                sVar.b(16);
            }
            if (sVar.a(true)) {
                sVar.b(1);
            }
            if (sVar.a(true)) {
                sVar.b(3);
                sVar.b(1);
                if (sVar.a(true)) {
                    sVar.b(8);
                    sVar.b(8);
                    sVar.b(8);
                }
            }
            if (sVar.a(true)) {
                sVar.d();
                sVar.d();
            }
            if (sVar.a(true)) {
                sVar.b(32);
                sVar.b(32);
                sVar.b(1);
            }
            boolean a11 = sVar.a(true);
            if (a11) {
                a(sVar);
            }
            boolean a12 = sVar.a(true);
            if (a12) {
                a(sVar);
            }
            if (a11 || a12) {
                sVar.b(1);
            }
            sVar.b(1);
            if (sVar.a(false)) {
                sVar.b(true);
                sVar.a(true);
                sVar.d();
                sVar.d();
                sVar.d();
                sVar.d();
                sVar.d();
                if (!this.f43999a) {
                    LiteavLog.w("H264SPSModifier", "decode: do not add max_dec_frame_buffering when it is ".concat(String.valueOf(sVar.b())));
                    this.f43999a = true;
                }
            } else {
                sVar.b(true);
                sVar.b(true);
                sVar.d(0);
                sVar.d(0);
                sVar.d(10);
                sVar.d(10);
                sVar.d(0);
                sVar.d(1);
                if (!this.f43999a) {
                    LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when it is no exist");
                    this.f43999a = true;
                }
                z10 = true;
            }
            if (!z10) {
                return null;
            }
        } else {
            sVar.b(true);
            sVar.b(false);
            sVar.b(false);
            sVar.b(false);
            sVar.b(false);
            sVar.b(false);
            sVar.b(false);
            sVar.b(false);
            sVar.b(false);
            sVar.b(true);
            sVar.b(true);
            sVar.d(0);
            sVar.d(0);
            sVar.d(10);
            sVar.d(10);
            sVar.d(0);
            sVar.d(1);
            if (!this.f43999a) {
                LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when vui is no exist");
                this.f43999a = true;
            }
        }
        sVar.e();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length * 3) / 2];
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            if (i10 < bArr.length - 2 && bArr[i10] == 0) {
                int i12 = i10 + 1;
                if (bArr[i12] == 0) {
                    int i13 = i10 + 2;
                    if (bArr[i13] <= 3) {
                        int i14 = i11 + 1;
                        bArr2[i11] = bArr[i10];
                        int i15 = i14 + 1;
                        bArr2[i14] = bArr[i12];
                        i11 = i15 + 1;
                        bArr2[i15] = 3;
                        i10 = i13;
                    }
                }
            }
            bArr2[i11] = bArr[i10];
            i10++;
            i11++;
        }
        if (i11 == bArr.length) {
            return bArr;
        }
        byte[] bArr3 = new byte[i11];
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i11);
        return bArr3;
    }

    private static void a(s sVar) throws IOException {
        int c4 = sVar.c();
        sVar.a(4);
        sVar.a(4);
        for (int i10 = 0; i10 <= c4; i10++) {
            sVar.d();
            sVar.d();
            sVar.a(1);
        }
        sVar.a(5);
        sVar.a(5);
        sVar.a(5);
        sVar.a(5);
    }

    public final byte[] a(byte[] bArr) throws IOException {
        byte[] bArr2;
        byte[] bArr3 = new byte[bArr.length];
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            if (i10 < bArr.length - 3 && bArr[i10] == 0) {
                int i12 = i10 + 1;
                if (bArr[i12] == 0 && bArr[i10 + 2] == 3) {
                    int i13 = i10 + 3;
                    if (bArr[i13] <= 3) {
                        int i14 = i11 + 1;
                        bArr3[i11] = bArr[i10];
                        i11 = i14 + 1;
                        bArr3[i14] = bArr[i12];
                        i10 = i13;
                    }
                }
            }
            bArr3[i11] = bArr[i10];
            i10++;
            i11++;
        }
        if (i11 != bArr.length) {
            bArr2 = new byte[i11];
            System.arraycopy((Object) bArr3, 0, (Object) bArr2, 0, i11);
        } else {
            bArr2 = null;
        }
        if (bArr2 != null) {
            z10 = true;
            bArr = bArr2;
        }
        byte[] a10 = a(new ByteArrayInputStream(bArr));
        return (a10 == null || !z10) ? a10 : b(a10);
    }
}
