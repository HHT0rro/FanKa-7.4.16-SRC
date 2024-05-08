package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t3 extends s3 {
    @Override // com.google.android.gms.internal.clearcut.s3
    public final int a(int i10, byte[] bArr, int i11, int i12) {
        int j10;
        int j11;
        while (i11 < i12 && bArr[i11] >= 0) {
            i11++;
        }
        if (i11 >= i12) {
            return 0;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            byte b4 = bArr[i11];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i13 >= i12) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i11 = i13 + 1;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return -1;
                }
                if (b4 >= -16) {
                    if (i13 >= i12 - 2) {
                        j11 = r3.j(bArr, i13, i12);
                        return j11;
                    }
                    int i14 = i13 + 1;
                    byte b10 = bArr[i13];
                    if (b10 <= -65 && (((b4 << 28) + (b10 + 112)) >> 30) == 0) {
                        int i15 = i14 + 1;
                        if (bArr[i14] <= -65) {
                            i13 = i15 + 1;
                            if (bArr[i15] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i13 >= i12 - 1) {
                    j10 = r3.j(bArr, i13, i12);
                    return j10;
                }
                int i16 = i13 + 1;
                byte b11 = bArr[i13];
                if (b11 <= -65 && ((b4 != -32 || b11 >= -96) && (b4 != -19 || b11 < -96))) {
                    i11 = i16 + 1;
                    if (bArr[i16] > -65) {
                    }
                }
                return -1;
            }
            i11 = i13;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.clearcut.s3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.t3.b(java.lang.CharSequence, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.clearcut.s3
    public final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        s3.d(charSequence, byteBuffer);
    }
}
