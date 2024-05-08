package com.jd.ad.sdk.jad_oz;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq implements jad_na<File, ByteBuffer> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an implements com.jd.ad.sdk.jad_it.jad_dq<ByteBuffer> {
        public final File jad_an;

        public jad_an(File file) {
            this.jad_an = file;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public Class<ByteBuffer> jad_an() {
            return ByteBuffer.class;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super ByteBuffer> jad_anVar) {
            try {
                jad_anVar.jad_an((jad_dq.jad_an<? super ByteBuffer>) com.jd.ad.sdk.jad_gp.jad_an.jad_an(this.jad_an));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Logger.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                jad_anVar.jad_an((Exception) e2);
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_hs.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_hs.jad_an.LOCAL;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_bo implements jad_ob<File, ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<File, ByteBuffer> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_dq();
        }
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an<ByteBuffer> jad_an(@NonNull File file, int i10, int i11, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        File file2 = file;
        return new jad_na.jad_an<>(new com.jd.ad.sdk.jad_fo.jad_bo(file2), Collections.emptyList(), new jad_an(file2));
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull File file) {
        return true;
    }
}
