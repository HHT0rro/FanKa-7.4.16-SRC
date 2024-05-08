package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface TrackOutput {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int i10, byte[] bArr, int i11, int i12) {
            this.cryptoMode = i10;
            this.encryptionKey = bArr;
            this.encryptedBlocks = i11;
            this.clearBlocks = i12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CryptoData.class != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            return this.cryptoMode == cryptoData.cryptoMode && this.encryptedBlocks == cryptoData.encryptedBlocks && this.clearBlocks == cryptoData.clearBlocks && Arrays.equals(this.encryptionKey, cryptoData.encryptionKey);
        }

        public int hashCode() {
            return (((((this.cryptoMode * 31) + Arrays.hashCode(this.encryptionKey)) * 31) + this.encryptedBlocks) * 31) + this.clearBlocks;
        }
    }

    void a(ParsableByteArray parsableByteArray, int i10);

    void b(Format format);

    int c(o6.g gVar, int i10, boolean z10) throws IOException;

    void d(long j10, int i10, int i11, int i12, @Nullable CryptoData cryptoData);

    int e(o6.g gVar, int i10, boolean z10, int i11) throws IOException;

    void f(ParsableByteArray parsableByteArray, int i10, int i11);
}
