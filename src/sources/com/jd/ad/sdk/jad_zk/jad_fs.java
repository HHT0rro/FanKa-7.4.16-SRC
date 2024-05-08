package com.jd.ad.sdk.jad_zk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_mz;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_fs {
    public final List<jad_an<?>> jad_an = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class jad_an<T> {
        public final Class<T> jad_an;
        public final jad_mz<T> jad_bo;

        public jad_an(@NonNull Class<T> cls, @NonNull jad_mz<T> jad_mzVar) {
            this.jad_an = cls;
            this.jad_bo = jad_mzVar;
        }
    }

    @Nullable
    public synchronized <Z> jad_mz<Z> jad_an(@NonNull Class<Z> cls) {
        int size = this.jad_an.size();
        for (int i10 = 0; i10 < size; i10++) {
            jad_an<?> jad_anVar = this.jad_an.get(i10);
            if (jad_anVar.jad_an.isAssignableFrom(cls)) {
                return (jad_mz<Z>) jad_anVar.jad_bo;
            }
        }
        return null;
    }
}
