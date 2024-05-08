package com.google.common.hash;

import com.google.common.primitives.Longs;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum LittleEndianByteArray$JavaLittleEndianBytes {
    INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes.1
        @Override // com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i10) {
            return Longs.d(bArr[i10 + 7], bArr[i10 + 6], bArr[i10 + 5], bArr[i10 + 4], bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
        }

        @Override // com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
            long j11 = 255;
            for (int i11 = 0; i11 < 8; i11++) {
                bArr[i10 + i11] = (byte) ((j10 & j11) >> (i11 * 8));
                j11 <<= 8;
            }
        }
    };

    public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i10);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i10, long j10);
}
