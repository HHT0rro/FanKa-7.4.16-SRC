package com.jd.ad.sdk.jad_zi;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_hu extends InputStream {
    public final /* synthetic */ jad_iv jad_an;

    public jad_hu(jad_iv jad_ivVar) {
        this.jad_an = jad_ivVar;
    }

    @Override // java.io.InputStream
    public int available() {
        jad_iv jad_ivVar = this.jad_an;
        if (jad_ivVar.jad_cp) {
            throw new IOException("closed");
        }
        return (int) Math.min(jad_ivVar.jad_an.jad_bo, ZipUtils.UPPER_UNIXTIME_BOUND);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.close();
    }

    @Override // java.io.InputStream
    public int read() {
        jad_iv jad_ivVar = this.jad_an;
        if (jad_ivVar.jad_cp) {
            throw new IOException("closed");
        }
        jad_an jad_anVar = jad_ivVar.jad_an;
        if (jad_anVar.jad_bo == 0 && jad_ivVar.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.jad_an.jad_an.jad_bo() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (this.jad_an.jad_cp) {
            throw new IOException("closed");
        }
        jad_ob.jad_an(bArr.length, i10, i11);
        jad_iv jad_ivVar = this.jad_an;
        jad_an jad_anVar = jad_ivVar.jad_an;
        if (jad_anVar.jad_bo == 0 && jad_ivVar.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.jad_an.jad_an.jad_an(bArr, i10, i11);
    }

    public String toString() {
        return ((Object) this.jad_an) + ".inputStream()";
    }
}
