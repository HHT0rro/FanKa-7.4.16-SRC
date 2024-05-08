package com.jd.ad.sdk.jad_zi;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_an implements jad_bo, Closeable, Flushable, WritableByteChannel, Cloneable, ByteChannel {

    @Nullable
    public jad_jw jad_an;
    public long jad_bo;

    public Object clone() {
        jad_an jad_anVar = new jad_an();
        if (this.jad_bo != 0) {
            jad_jw jad_bo = this.jad_an.jad_bo();
            jad_anVar.jad_an = jad_bo;
            jad_bo.jad_jt = jad_bo;
            jad_bo.jad_fs = jad_bo;
            jad_jw jad_jwVar = this.jad_an;
            while (true) {
                jad_jwVar = jad_jwVar.jad_fs;
                if (jad_jwVar == this.jad_an) {
                    break;
                }
                jad_anVar.jad_an.jad_jt.jad_an(jad_jwVar.jad_bo());
            }
            jad_anVar.jad_bo = this.jad_bo;
        }
        return jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jad_an)) {
            return false;
        }
        jad_an jad_anVar = (jad_an) obj;
        long j10 = this.jad_bo;
        if (j10 != jad_anVar.jad_bo) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        jad_jw jad_jwVar = this.jad_an;
        jad_jw jad_jwVar2 = jad_anVar.jad_an;
        int i10 = jad_jwVar.jad_bo;
        int i11 = jad_jwVar2.jad_bo;
        while (j11 < this.jad_bo) {
            long min = Math.min(jad_jwVar.jad_cp - i10, jad_jwVar2.jad_cp - i11);
            int i12 = 0;
            while (i12 < min) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (jad_jwVar.jad_an[i10] != jad_jwVar2.jad_an[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == jad_jwVar.jad_cp) {
                jad_jwVar = jad_jwVar.jad_fs;
                i10 = jad_jwVar.jad_bo;
            }
            if (i11 == jad_jwVar2.jad_cp) {
                jad_jwVar2 = jad_jwVar2.jad_fs;
                i11 = jad_jwVar2.jad_bo;
            }
            j11 += min;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = jad_jwVar.jad_cp;
            for (int i12 = jad_jwVar.jad_bo; i12 < i11; i12++) {
                i10 = (i10 * 31) + jad_jwVar.jad_an[i12];
            }
            jad_jwVar = jad_jwVar.jad_fs;
        } while (jad_jwVar != this.jad_an);
        return i10;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public int jad_an(jad_fs jad_fsVar) {
        int jad_an = jad_an(jad_fsVar, false);
        if (jad_an == -1) {
            return -1;
        }
        try {
            jad_dq(jad_fsVar.jad_an[jad_an].jad_cp());
            return jad_an;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int jad_an(com.jd.ad.sdk.jad_zi.jad_fs r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 161
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_zi.jad_an.jad_an(com.jd.ad.sdk.jad_zi.jad_fs, boolean):int");
    }

    public int jad_an(byte[] bArr, int i10, int i11) {
        jad_ob.jad_an(bArr.length, i10, i11);
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1;
        }
        int min = Math.min(i11, jad_jwVar.jad_cp - jad_jwVar.jad_bo);
        System.arraycopy((Object) jad_jwVar.jad_an, jad_jwVar.jad_bo, (Object) bArr, i10, min);
        int i12 = jad_jwVar.jad_bo + min;
        jad_jwVar.jad_bo = i12;
        this.jad_bo -= min;
        if (i12 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        }
        return min;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz
    public long jad_an(jad_an jad_anVar, long j10) {
        if (jad_anVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        long j11 = this.jad_bo;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        jad_anVar.jad_bo(this, j10);
        return j10;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public long jad_an(jad_cp jad_cpVar) {
        return jad_an(jad_cpVar, 0L);
    }

    public long jad_an(jad_cp jad_cpVar, long j10) {
        int i10;
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1L;
        }
        long j12 = this.jad_bo;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                jad_jwVar = jad_jwVar.jad_jt;
                j12 -= jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            }
        } else {
            while (true) {
                long j13 = (jad_jwVar.jad_cp - jad_jwVar.jad_bo) + j11;
                if (j13 >= j10) {
                    break;
                }
                jad_jwVar = jad_jwVar.jad_fs;
                j11 = j13;
            }
            j12 = j11;
        }
        if (jad_cpVar.jad_cp() == 2) {
            byte jad_an = jad_cpVar.jad_an(0);
            byte jad_an2 = jad_cpVar.jad_an(1);
            while (j12 < this.jad_bo) {
                byte[] bArr = jad_jwVar.jad_an;
                i10 = (int) ((jad_jwVar.jad_bo + j10) - j12);
                int i11 = jad_jwVar.jad_cp;
                while (i10 < i11) {
                    byte b4 = bArr[i10];
                    if (b4 != jad_an && b4 != jad_an2) {
                        i10++;
                    }
                    return (i10 - jad_jwVar.jad_bo) + j12;
                }
                j12 += jad_jwVar.jad_cp - jad_jwVar.jad_bo;
                jad_jwVar = jad_jwVar.jad_fs;
                j10 = j12;
            }
            return -1L;
        }
        byte[] jad_bo = jad_cpVar.jad_bo();
        while (j12 < this.jad_bo) {
            byte[] bArr2 = jad_jwVar.jad_an;
            i10 = (int) ((jad_jwVar.jad_bo + j10) - j12);
            int i12 = jad_jwVar.jad_cp;
            while (i10 < i12) {
                byte b10 = bArr2[i10];
                for (byte b11 : jad_bo) {
                    if (b10 == b11) {
                        return (i10 - jad_jwVar.jad_bo) + j12;
                    }
                }
                i10++;
            }
            j12 += jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            jad_jwVar = jad_jwVar.jad_fs;
            j10 = j12;
        }
        return -1L;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public jad_an jad_an() {
        return this;
    }

    public jad_an jad_an(String str, int i10, int i11) {
        char charAt;
        int i12;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        while (i10 < i11) {
            char charAt2 = str.charAt(i10);
            if (charAt2 < 128) {
                jad_jw jad_an = jad_an(1);
                byte[] bArr = jad_an.jad_an;
                int i13 = jad_an.jad_cp - i10;
                int min = Math.min(i11, 8192 - i13);
                int i14 = i10 + 1;
                bArr[i10 + i13] = (byte) charAt2;
                while (true) {
                    i10 = i14;
                    if (i10 >= min || (charAt = str.charAt(i10)) >= 128) {
                        break;
                    }
                    i14 = i10 + 1;
                    bArr[i10 + i13] = (byte) charAt;
                }
                int i15 = jad_an.jad_cp;
                int i16 = (i13 + i10) - i15;
                jad_an.jad_cp = i15 + i16;
                this.jad_bo += i16;
            } else {
                if (charAt2 < 2048) {
                    i12 = (charAt2 >> 6) | 192;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    jad_bo((charAt2 >> '\f') | 224);
                    i12 = ((charAt2 >> 6) & 63) | 128;
                } else {
                    int i17 = i10 + 1;
                    char charAt3 = i17 < i11 ? str.charAt(i17) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        jad_bo(63);
                        i10 = i17;
                    } else {
                        int i18 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        jad_bo((i18 >> 18) | 240);
                        jad_bo(((i18 >> 12) & 63) | 128);
                        jad_bo(((i18 >> 6) & 63) | 128);
                        jad_bo((i18 & 63) | 128);
                        i10 += 2;
                    }
                }
                jad_bo(i12);
                jad_bo((charAt2 & '?') | 128);
                i10++;
            }
        }
        return this;
    }

    public jad_jw jad_an(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar != null) {
            jad_jw jad_jwVar2 = jad_jwVar.jad_jt;
            return (jad_jwVar2.jad_cp + i10 > 8192 || !jad_jwVar2.jad_er) ? jad_jwVar2.jad_an(jad_kx.jad_an()) : jad_jwVar2;
        }
        jad_jw jad_an = jad_kx.jad_an();
        this.jad_an = jad_an;
        jad_an.jad_jt = jad_an;
        jad_an.jad_fs = jad_an;
        return jad_an;
    }

    public String jad_an(long j10, Charset charset) {
        jad_ob.jad_an(this.jad_bo, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        if (j10 == 0) {
            return "";
        }
        jad_jw jad_jwVar = this.jad_an;
        int i10 = jad_jwVar.jad_bo;
        if (i10 + j10 > jad_jwVar.jad_cp) {
            return new String(jad_cp(j10), charset);
        }
        String str = new String(jad_jwVar.jad_an, i10, (int) j10, charset);
        int i11 = (int) (jad_jwVar.jad_bo + j10);
        jad_jwVar.jad_bo = i11;
        this.jad_bo -= j10;
        if (i11 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        }
        return str;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public boolean jad_an(long j10) {
        return this.jad_bo >= j10;
    }

    public byte jad_bo() {
        long j10 = this.jad_bo;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        jad_jw jad_jwVar = this.jad_an;
        int i10 = jad_jwVar.jad_bo;
        int i11 = jad_jwVar.jad_cp;
        int i12 = i10 + 1;
        byte b4 = jad_jwVar.jad_an[i10];
        this.jad_bo = j10 - 1;
        if (i12 == i11) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        } else {
            jad_jwVar.jad_bo = i12;
        }
        return b4;
    }

    public final byte jad_bo(long j10) {
        int i10;
        jad_ob.jad_an(this.jad_bo, j10, 1L);
        long j11 = this.jad_bo;
        if (j11 - j10 <= j10) {
            long j12 = j10 - j11;
            jad_jw jad_jwVar = this.jad_an;
            do {
                jad_jwVar = jad_jwVar.jad_jt;
                int i11 = jad_jwVar.jad_cp;
                i10 = jad_jwVar.jad_bo;
                j12 += i11 - i10;
            } while (j12 < 0);
            return jad_jwVar.jad_an[i10 + ((int) j12)];
        }
        jad_jw jad_jwVar2 = this.jad_an;
        while (true) {
            int i12 = jad_jwVar2.jad_cp;
            int i13 = jad_jwVar2.jad_bo;
            long j13 = i12 - i13;
            if (j10 < j13) {
                return jad_jwVar2.jad_an[i13 + ((int) j10)];
            }
            j10 -= j13;
            jad_jwVar2 = jad_jwVar2.jad_fs;
        }
    }

    public jad_an jad_bo(int i10) {
        jad_jw jad_an = jad_an(1);
        byte[] bArr = jad_an.jad_an;
        int i11 = jad_an.jad_cp;
        jad_an.jad_cp = i11 + 1;
        bArr[i11] = (byte) i10;
        this.jad_bo++;
        return this;
    }

    public void jad_bo(jad_an jad_anVar, long j10) {
        jad_jw jad_an;
        if (jad_anVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        jad_ob.jad_an(jad_anVar.jad_bo, 0L, j10);
        while (j10 > 0) {
            jad_jw jad_jwVar = jad_anVar.jad_an;
            int i10 = jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            if (j10 < i10) {
                jad_jw jad_jwVar2 = this.jad_an;
                jad_jw jad_jwVar3 = jad_jwVar2 != null ? jad_jwVar2.jad_jt : null;
                if (jad_jwVar3 != null && jad_jwVar3.jad_er) {
                    if ((jad_jwVar3.jad_cp + j10) - (jad_jwVar3.jad_dq ? 0 : jad_jwVar3.jad_bo) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        jad_jwVar.jad_an(jad_jwVar3, (int) j10);
                        jad_anVar.jad_bo -= j10;
                        this.jad_bo += j10;
                        return;
                    }
                }
                int i11 = (int) j10;
                if (i11 > 0 && i11 <= i10) {
                    if (i11 >= 1024) {
                        jad_an = jad_jwVar.jad_bo();
                    } else {
                        jad_an = jad_kx.jad_an();
                        System.arraycopy((Object) jad_jwVar.jad_an, jad_jwVar.jad_bo, (Object) jad_an.jad_an, 0, i11);
                    }
                    jad_an.jad_cp = jad_an.jad_bo + i11;
                    jad_jwVar.jad_bo += i11;
                    jad_jwVar.jad_jt.jad_an(jad_an);
                    jad_anVar.jad_an = jad_an;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            jad_jw jad_jwVar4 = jad_anVar.jad_an;
            long j11 = jad_jwVar4.jad_cp - jad_jwVar4.jad_bo;
            jad_anVar.jad_an = jad_jwVar4.jad_an();
            jad_jw jad_jwVar5 = this.jad_an;
            if (jad_jwVar5 == null) {
                this.jad_an = jad_jwVar4;
                jad_jwVar4.jad_jt = jad_jwVar4;
                jad_jwVar4.jad_fs = jad_jwVar4;
            } else {
                jad_jw jad_an2 = jad_jwVar5.jad_jt.jad_an(jad_jwVar4);
                jad_jw jad_jwVar6 = jad_an2.jad_jt;
                if (jad_jwVar6 == jad_an2) {
                    throw new IllegalStateException();
                }
                if (jad_jwVar6.jad_er) {
                    int i12 = jad_an2.jad_cp - jad_an2.jad_bo;
                    if (i12 <= (8192 - jad_jwVar6.jad_cp) + (jad_jwVar6.jad_dq ? 0 : jad_jwVar6.jad_bo)) {
                        jad_an2.jad_an(jad_jwVar6, i12);
                        jad_an2.jad_an();
                        jad_kx.jad_an(jad_an2);
                    }
                }
            }
            jad_anVar.jad_bo -= j11;
            this.jad_bo += j11;
            j10 -= j11;
        }
    }

    public jad_an jad_cp(int i10) {
        jad_jw jad_an = jad_an(4);
        byte[] bArr = jad_an.jad_an;
        int i11 = jad_an.jad_cp;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        jad_an.jad_cp = i14 + 1;
        this.jad_bo += 4;
        return this;
    }

    public byte[] jad_cp(long j10) {
        jad_ob.jad_an(this.jad_bo, 0L, j10);
        if (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        int i10 = (int) j10;
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int jad_an = jad_an(bArr, i11, i10 - i11);
            if (jad_an == -1) {
                throw new EOFException();
            }
            i11 += jad_an;
        }
        return bArr;
    }

    public void jad_dq(long j10) {
        while (j10 > 0) {
            if (this.jad_an == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j10, r0.jad_cp - r0.jad_bo);
            long j11 = min;
            this.jad_bo -= j11;
            j10 -= j11;
            jad_jw jad_jwVar = this.jad_an;
            int i10 = jad_jwVar.jad_bo + min;
            jad_jwVar.jad_bo = i10;
            if (i10 == jad_jwVar.jad_cp) {
                this.jad_an = jad_jwVar.jad_an();
                jad_kx.jad_an(jad_jwVar);
            }
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), jad_jwVar.jad_cp - jad_jwVar.jad_bo);
        byteBuffer.put(jad_jwVar.jad_an, jad_jwVar.jad_bo, min);
        int i10 = jad_jwVar.jad_bo + min;
        jad_jwVar.jad_bo = i10;
        this.jad_bo -= min;
        if (i10 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        }
        return min;
    }

    public String toString() {
        long j10 = this.jad_bo;
        if (j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            int i10 = (int) j10;
            return (i10 == 0 ? jad_cp.jad_er : new jad_ly(this, i10)).toString();
        }
        StringBuilder jad_an = jad_pc.jad_an("size > Integer.MAX_VALUE: ");
        jad_an.append(this.jad_bo);
        throw new IllegalArgumentException(jad_an.toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            jad_jw jad_an = jad_an(1);
            int min = Math.min(i10, 8192 - jad_an.jad_cp);
            byteBuffer.get(jad_an.jad_an, jad_an.jad_cp, min);
            i10 -= min;
            jad_an.jad_cp += min;
        }
        this.jad_bo += remaining;
        return remaining;
    }
}
