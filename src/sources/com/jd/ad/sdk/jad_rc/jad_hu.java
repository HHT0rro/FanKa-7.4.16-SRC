package com.jd.ad.sdk.jad_rc;

import android.util.Log;
import androidx.annotation.NonNull;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser;
import com.jd.ad.sdk.jad_hs.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_hu implements com.jd.ad.sdk.jad_hs.jad_fs {
    public static final byte[] jad_an = ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    public static final int[] jad_bo = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an implements jad_cp {
        public final ByteBuffer jad_an;

        public jad_an(ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i10) {
            int min = Math.min(i10, this.jad_an.remaining());
            if (min == 0) {
                return -1;
            }
            this.jad_an.get(bArr, 0, min);
            return min;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public long jad_an(long j10) {
            int min = (int) Math.min(this.jad_an.remaining(), j10);
            ByteBuffer byteBuffer = this.jad_an;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public short jad_an() {
            if (this.jad_an.remaining() >= 1) {
                return (short) (this.jad_an.get() & 255);
            }
            throw new jad_cp.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_bo {
        public final ByteBuffer jad_an;

        public jad_bo(byte[] bArr, int i10) {
            this.jad_an = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        public short jad_an(int i10) {
            if (this.jad_an.remaining() - i10 >= 2) {
                return this.jad_an.getShort(i10);
            }
            return (short) -1;
        }

        public int jad_bo(int i10) {
            if (this.jad_an.remaining() - i10 >= 4) {
                return this.jad_an.getInt(i10);
            }
            return -1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_cp {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class jad_an extends IOException {
            public jad_an() {
                super("Unexpectedly reached end of a file");
            }
        }

        int jad_an(byte[] bArr, int i10);

        long jad_an(long j10);

        short jad_an();

        int jad_bo();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_dq implements jad_cp {
        public final InputStream jad_an;

        public jad_dq(InputStream inputStream) {
            this.jad_an = inputStream;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i10) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10 && (i12 = this.jad_an.read(bArr, i11, i10 - i11)) != -1) {
                i11 += i12;
            }
            if (i11 == 0 && i12 == -1) {
                throw new jad_cp.jad_an();
            }
            return i11;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public long jad_an(long j10) {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.jad_an.skip(j11);
                if (skip <= 0) {
                    if (this.jad_an.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public short jad_an() {
            int read = this.jad_an.read();
            if (read != -1) {
                return (short) read;
            }
            throw new jad_cp.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }
    }

    public final int jad_an(jad_cp jad_cpVar, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        try {
            int jad_bo2 = jad_cpVar.jad_bo();
            if (!((jad_bo2 & 65496) == 65496 || jad_bo2 == 19789 || jad_bo2 == 18761)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + jad_bo2);
                }
                return -1;
            }
            int jad_bo3 = jad_bo(jad_cpVar);
            if (jad_bo3 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) jad_boVar.jad_an(jad_bo3, byte[].class);
            try {
                return jad_an(jad_cpVar, bArr, jad_bo3);
            } finally {
                jad_boVar.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
            }
        } catch (jad_cp.jad_an unused) {
            return -1;
        }
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    public int jad_an(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        Objects.requireNonNull(inputStream, "Argument must not be null");
        jad_dq jad_dqVar = new jad_dq(inputStream);
        Objects.requireNonNull(jad_boVar, "Argument must not be null");
        return jad_an(jad_dqVar, jad_boVar);
    }

    public final boolean jad_an(byte[] bArr, int i10) {
        boolean z10 = bArr != null && i10 > jad_an.length;
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = jad_an;
                if (i11 >= bArr2.length) {
                    break;
                }
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
        return z10;
    }

    public final int jad_bo(jad_cp jad_cpVar) {
        short jad_an2;
        int jad_bo2;
        long j10;
        long jad_an3;
        do {
            short jad_an4 = jad_cpVar.jad_an();
            if (jad_an4 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) jad_an4));
                }
                return -1;
            }
            jad_an2 = jad_cpVar.jad_an();
            if (jad_an2 == 218) {
                return -1;
            }
            if (jad_an2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            jad_bo2 = jad_cpVar.jad_bo() - 2;
            if (jad_an2 == 225) {
                return jad_bo2;
            }
            j10 = jad_bo2;
            jad_an3 = jad_cpVar.jad_an(j10);
        } while (jad_an3 == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Logger.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) jad_an2) + ", wanted to skip: " + jad_bo2 + ", but actually skipped: " + jad_an3);
        }
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    public int jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        Objects.requireNonNull(byteBuffer, "Argument must not be null");
        jad_an jad_anVar = new jad_an(byteBuffer);
        Objects.requireNonNull(jad_boVar, "Argument must not be null");
        return jad_an(jad_anVar, jad_boVar);
    }

    @NonNull
    public final jad_fs.jad_bo jad_an(jad_cp jad_cpVar) {
        try {
            int jad_bo2 = jad_cpVar.jad_bo();
            if (jad_bo2 == 65496) {
                return jad_fs.jad_bo.JPEG;
            }
            int jad_an2 = (jad_bo2 << 8) | jad_cpVar.jad_an();
            if (jad_an2 == 4671814) {
                return jad_fs.jad_bo.GIF;
            }
            int jad_an3 = (jad_an2 << 8) | jad_cpVar.jad_an();
            if (jad_an3 == -1991225785) {
                jad_cpVar.jad_an(21L);
                try {
                    return jad_cpVar.jad_an() >= 3 ? jad_fs.jad_bo.PNG_A : jad_fs.jad_bo.PNG;
                } catch (jad_cp.jad_an unused) {
                    return jad_fs.jad_bo.PNG;
                }
            }
            if (jad_an3 == 1380533830) {
                jad_cpVar.jad_an(4L);
                if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) != 1464156752) {
                    return jad_fs.jad_bo.UNKNOWN;
                }
                int jad_bo3 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                if ((jad_bo3 & (-256)) != 1448097792) {
                    return jad_fs.jad_bo.UNKNOWN;
                }
                int i10 = jad_bo3 & 255;
                if (i10 == 88) {
                    jad_cpVar.jad_an(4L);
                    short jad_an4 = jad_cpVar.jad_an();
                    return (jad_an4 & 2) != 0 ? jad_fs.jad_bo.ANIMATED_WEBP : (jad_an4 & 16) != 0 ? jad_fs.jad_bo.WEBP_A : jad_fs.jad_bo.WEBP;
                }
                if (i10 != 76) {
                    return jad_fs.jad_bo.WEBP;
                }
                jad_cpVar.jad_an(4L);
                return (jad_cpVar.jad_an() & 8) != 0 ? jad_fs.jad_bo.WEBP_A : jad_fs.jad_bo.WEBP;
            }
            boolean z10 = false;
            if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) == 1718909296) {
                int jad_bo4 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                if (jad_bo4 != 1635150182 && jad_bo4 != 1635150195) {
                    jad_cpVar.jad_an(4L);
                    int i11 = jad_an3 - 16;
                    if (i11 % 4 == 0) {
                        int i12 = 0;
                        while (i12 < 5 && i11 > 0) {
                            int jad_bo5 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                            if (jad_bo5 != 1635150182 && jad_bo5 != 1635150195) {
                                i12++;
                                i11 -= 4;
                            }
                        }
                    }
                }
                z10 = true;
                break;
            }
            return z10 ? jad_fs.jad_bo.AVIF : jad_fs.jad_bo.UNKNOWN;
        } catch (jad_cp.jad_an unused2) {
            return jad_fs.jad_bo.UNKNOWN;
        }
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    @NonNull
    public jad_fs.jad_bo jad_an(@NonNull InputStream inputStream) {
        Objects.requireNonNull(inputStream, "Argument must not be null");
        return jad_an(new jad_dq(inputStream));
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    @NonNull
    public jad_fs.jad_bo jad_an(@NonNull ByteBuffer byteBuffer) {
        Objects.requireNonNull(byteBuffer, "Argument must not be null");
        return jad_an(new jad_an(byteBuffer));
    }

    public final int jad_an(jad_cp jad_cpVar, byte[] bArr, int i10) {
        ByteOrder byteOrder;
        int jad_an2 = jad_cpVar.jad_an(bArr, i10);
        int i11 = 1;
        if (jad_an2 != i10) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Logger.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + jad_an2);
            }
            return -1;
        }
        if (jad_an(bArr, i10)) {
            jad_bo jad_boVar = new jad_bo(bArr, i10);
            short jad_an3 = jad_boVar.jad_an(6);
            if (jad_an3 != 18761) {
                if (jad_an3 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) jad_an3));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            jad_boVar.jad_an.order(byteOrder);
            int jad_bo2 = jad_boVar.jad_bo(10) + 6;
            short jad_an4 = jad_boVar.jad_an(jad_bo2);
            int i12 = 0;
            while (i12 < jad_an4) {
                int i13 = (i12 * 12) + jad_bo2 + 2;
                short jad_an5 = jad_boVar.jad_an(i13);
                if (jad_an5 == 274) {
                    short jad_an6 = jad_boVar.jad_an(i13 + 2);
                    if (jad_an6 >= i11 && jad_an6 <= 12) {
                        int jad_bo3 = jad_boVar.jad_bo(i13 + 4);
                        if (jad_bo3 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Object[] objArr = new Object[i11];
                                objArr[0] = "Got tagIndex=" + i12 + " tagType=" + ((int) jad_an5) + " formatCode=" + ((int) jad_an6) + " componentCount=" + jad_bo3;
                                Logger.d("DfltImageHeaderParser", objArr);
                            }
                            int i14 = jad_bo3 + jad_bo[jad_an6];
                            if (i14 <= 4) {
                                int i15 = i13 + 8;
                                if (i15 < 0 || i15 > jad_boVar.jad_an.remaining()) {
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Logger.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i15 + " tagType=" + ((int) jad_an5));
                                    }
                                } else {
                                    if (i14 >= 0 && i14 + i15 <= jad_boVar.jad_an.remaining()) {
                                        return jad_boVar.jad_an(i15);
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Logger.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) jad_an5));
                                    }
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Logger.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) jad_an6));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Object[] objArr2 = new Object[i11];
                            objArr2[0] = "Negative tiff component count";
                            Logger.d("DfltImageHeaderParser", objArr2);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Logger.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) jad_an6));
                    }
                }
                i12++;
                i11 = 1;
            }
            return -1;
        }
        if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
            return -1;
        }
        Logger.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        return -1;
    }
}
