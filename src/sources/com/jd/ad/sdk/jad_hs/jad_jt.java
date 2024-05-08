package com.jd.ad.sdk.jad_hs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_fs;
import com.jd.ad.sdk.jad_rc.jad_sf;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jt {
    public static int jad_an(@NonNull List<jad_fs> list, @Nullable InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new jad_sf(inputStream, jad_boVar, 65536);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                int jad_an = list.get(i10).jad_an(inputStream, jad_boVar);
                if (jad_an != -1) {
                    return jad_an;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    @NonNull
    public static jad_fs.jad_bo jad_bo(@NonNull List<jad_fs> list, @Nullable InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        if (inputStream == null) {
            return jad_fs.jad_bo.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new jad_sf(inputStream, jad_boVar, 65536);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                jad_fs.jad_bo jad_an = list.get(i10).jad_an(inputStream);
                inputStream.reset();
                if (jad_an != jad_fs.jad_bo.UNKNOWN) {
                    return jad_an;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return jad_fs.jad_bo.UNKNOWN;
    }

    @NonNull
    public static jad_fs.jad_bo jad_an(@NonNull List<jad_fs> list, @Nullable ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return jad_fs.jad_bo.UNKNOWN;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            jad_fs.jad_bo jad_an = list.get(i10).jad_an(byteBuffer);
            if (jad_an != jad_fs.jad_bo.UNKNOWN) {
                return jad_an;
            }
        }
        return jad_fs.jad_bo.UNKNOWN;
    }
}
