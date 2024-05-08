package com.jd.ad.sdk.jad_js;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_sf<V> {

    @Nullable
    public final V jad_an;

    @Nullable
    public final Throwable jad_bo;

    public jad_sf(V v2) {
        this.jad_an = v2;
        this.jad_bo = null;
    }

    public jad_sf(Throwable th) {
        this.jad_bo = th;
        this.jad_an = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jad_sf)) {
            return false;
        }
        jad_sf jad_sfVar = (jad_sf) obj;
        V v2 = this.jad_an;
        if (v2 != null && v2.equals(jad_sfVar.jad_an)) {
            return true;
        }
        Throwable th = this.jad_bo;
        if (th == null || jad_sfVar.jad_bo == null) {
            return false;
        }
        return th.toString().equals(this.jad_bo.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.jad_an, this.jad_bo});
    }
}
