package com.jd.ad.sdk.jad_pa;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_ju.jad_cp;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.jad_oz.jad_ob;
import com.jd.ad.sdk.jad_oz.jad_re;
import com.jd.ad.sdk.jad_rc.jad_xk;
import java.io.InputStream;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp implements jad_na<Uri, InputStream> {
    public final Context jad_an;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an implements jad_ob<Uri, InputStream> {
        public final Context jad_an;

        public jad_an(Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_cp(this.jad_an);
        }
    }

    public jad_cp(Context context) {
        this.jad_an = context.getApplicationContext();
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    @Nullable
    public jad_na.jad_an<InputStream> jad_an(@NonNull Uri uri, int i10, int i11, @NonNull jad_jw jad_jwVar) {
        Uri uri2 = uri;
        if (com.jd.ad.sdk.jad_ju.jad_bo.jad_an(i10, i11)) {
            Long l10 = (Long) jad_jwVar.jad_an(jad_xk.jad_dq);
            if (l10 != null && l10.longValue() == -1) {
                com.jd.ad.sdk.jad_fo.jad_bo jad_boVar = new com.jd.ad.sdk.jad_fo.jad_bo(uri2);
                Context context = this.jad_an;
                return new jad_na.jad_an<>(jad_boVar, Collections.emptyList(), com.jd.ad.sdk.jad_ju.jad_cp.jad_an(context, uri2, new jad_cp.jad_bo(context.getContentResolver())));
            }
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        return com.jd.ad.sdk.jad_ju.jad_bo.jad_an(uri) && uri.getPathSegments().contains("video");
    }
}
