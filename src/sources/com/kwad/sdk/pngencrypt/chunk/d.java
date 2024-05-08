package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public final byte[] aMa;
    private CRC32 aMd;
    public final String ahi;
    public final int len;
    public byte[] data = null;
    private long aMb = 0;
    public byte[] aMc = new byte[4];

    public d(int i10, String str, boolean z10) {
        this.len = i10;
        this.ahi = str;
        this.aMa = b.gi(str);
        for (int i11 = 0; i11 < 4; i11++) {
            byte[] bArr = this.aMa;
            if (bArr[i11] < 65 || bArr[i11] > 122 || (bArr[i11] > 90 && bArr[i11] < 97)) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z10) {
            Kk();
        }
    }

    private void Kk() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream Kl() {
        return new ByteArrayInputStream(this.data);
    }

    public final long Km() {
        return this.aMb;
    }

    public final void aD(long j10) {
        this.aMb = j10;
    }

    public final void bI(boolean z10) {
        int value = (int) this.aMd.getValue();
        int g3 = com.kwad.sdk.pngencrypt.n.g(this.aMc, 0);
        if (value != g3) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.ahi, Long.valueOf(this.aMb), Integer.valueOf(g3), Integer.valueOf(value));
            if (z10) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.ahi;
        if (str == null) {
            if (dVar.ahi != null) {
                return false;
            }
        } else if (!str.equals(dVar.ahi)) {
            return false;
        }
        return this.aMb == dVar.aMb;
    }

    public final void f(byte[] bArr, int i10, int i11) {
        if (this.aMd == null) {
            this.aMd = new CRC32();
        }
        this.aMd.update(bArr, i10, i11);
    }

    public final int hashCode() {
        String str = this.ahi;
        int hashCode = str == null ? 0 : str.hashCode();
        long j10 = this.aMb;
        return ((hashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.aMa) + " len=" + this.len;
    }
}
