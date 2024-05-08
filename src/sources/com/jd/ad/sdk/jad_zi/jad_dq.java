package com.jd.ad.sdk.jad_zi;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_dq implements jad_mz {
    public final /* synthetic */ jad_na jad_an;
    public final /* synthetic */ InputStream jad_bo;

    public jad_dq(jad_na jad_naVar, InputStream inputStream) {
        this.jad_an = jad_naVar;
        this.jad_bo = inputStream;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_bo.close();
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz
    public long jad_an(jad_an jad_anVar, long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        try {
            this.jad_an.jad_an();
            jad_jw jad_an = jad_anVar.jad_an(1);
            int read = this.jad_bo.read(jad_an.jad_an, jad_an.jad_cp, (int) Math.min(j10, 8192 - jad_an.jad_cp));
            if (read == -1) {
                return -1L;
            }
            jad_an.jad_cp += read;
            long j11 = read;
            jad_anVar.jad_bo += j11;
            return j11;
        } catch (AssertionError e2) {
            if ((e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) ? false : true) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    public String toString() {
        StringBuilder jad_an = jad_pc.jad_an("source(");
        jad_an.append((Object) this.jad_bo);
        jad_an.append(")");
        return jad_an.toString();
    }
}
