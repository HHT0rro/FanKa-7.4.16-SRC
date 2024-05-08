package com.jd.ad.sdk.jad_zi;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_iv implements jad_bo {
    public final jad_an jad_an = new jad_an();
    public final jad_mz jad_bo;
    public boolean jad_cp;

    public jad_iv(jad_mz jad_mzVar) {
        Objects.requireNonNull(jad_mzVar, "source == null");
        this.jad_bo = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.jad_cp) {
            return;
        }
        this.jad_cp = true;
        this.jad_bo.close();
        jad_an jad_anVar = this.jad_an;
        jad_anVar.getClass();
        try {
            jad_anVar.jad_dq(jad_anVar.jad_bo);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public int jad_an(jad_fs jad_fsVar) {
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        do {
            int jad_an = this.jad_an.jad_an(jad_fsVar, true);
            if (jad_an == -1) {
                return -1;
            }
            if (jad_an != -2) {
                this.jad_an.jad_dq(jad_fsVar.jad_an[jad_an].jad_cp());
                return jad_an;
            }
        } while (this.jad_bo.jad_an(this.jad_an, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz
    public long jad_an(jad_an jad_anVar, long j10) {
        if (jad_anVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        jad_an jad_anVar2 = this.jad_an;
        if (jad_anVar2.jad_bo == 0 && this.jad_bo.jad_an(jad_anVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.jad_an.jad_an(jad_anVar, Math.min(j10, this.jad_an.jad_bo));
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public long jad_an(jad_cp jad_cpVar) {
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        long j10 = 0;
        while (true) {
            long jad_an = this.jad_an.jad_an(jad_cpVar, j10);
            if (jad_an != -1) {
                return jad_an;
            }
            jad_an jad_anVar = this.jad_an;
            long j11 = jad_anVar.jad_bo;
            if (this.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, j11);
        }
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public jad_an jad_an() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public boolean jad_an(long j10) {
        jad_an jad_anVar;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        do {
            jad_anVar = this.jad_an;
            if (jad_anVar.jad_bo >= j10) {
                return true;
            }
        } while (this.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    public jad_bo jad_bo() {
        return new jad_iv(new jad_jt(this));
    }

    public byte jad_cp() {
        if (jad_an(1L)) {
            return this.jad_an.jad_bo();
        }
        throw new EOFException();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        jad_an jad_anVar = this.jad_an;
        if (jad_anVar.jad_bo == 0 && this.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.jad_an.read(byteBuffer);
    }

    public String toString() {
        StringBuilder jad_an = jad_pc.jad_an("buffer(");
        jad_an.append((Object) this.jad_bo);
        jad_an.append(")");
        return jad_an.toString();
    }
}
