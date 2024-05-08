package com.jd.ad.sdk.jad_oz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_mz<A, B> {
    public final com.jd.ad.sdk.jad_gp.jad_hu<jad_bo<A>, B> jad_an;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an extends com.jd.ad.sdk.jad_gp.jad_hu<jad_bo<A>, B> {
        public jad_an(jad_mz jad_mzVar, long j10) {
            super(j10);
        }

        @Override // com.jd.ad.sdk.jad_gp.jad_hu
        public void jad_an(@NonNull Object obj, @Nullable Object obj2) {
            jad_bo jad_boVar = (jad_bo) obj;
            jad_boVar.getClass();
            Queue<jad_bo<?>> queue = jad_bo.jad_dq;
            synchronized (queue) {
                ((ArrayDeque) queue).offer(jad_boVar);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_bo<A> {
        public static final Queue<jad_bo<?>> jad_dq;
        public int jad_an;
        public int jad_bo;
        public A jad_cp;

        static {
            char[] cArr = com.jd.ad.sdk.jad_gp.jad_ly.jad_an;
            jad_dq = new ArrayDeque(0);
        }

        public static <A> jad_bo<A> jad_an(A a10, int i10, int i11) {
            jad_bo<A> jad_boVar;
            Queue<jad_bo<?>> queue = jad_dq;
            synchronized (queue) {
                jad_boVar = (jad_bo) ((ArrayDeque) queue).poll();
            }
            if (jad_boVar == null) {
                jad_boVar = new jad_bo<>();
            }
            jad_boVar.jad_cp = a10;
            jad_boVar.jad_bo = i10;
            jad_boVar.jad_an = i11;
            return jad_boVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_bo)) {
                return false;
            }
            jad_bo jad_boVar = (jad_bo) obj;
            return this.jad_bo == jad_boVar.jad_bo && this.jad_an == jad_boVar.jad_an && this.jad_cp.equals(jad_boVar.jad_cp);
        }

        public int hashCode() {
            return this.jad_cp.hashCode() + (((this.jad_an * 31) + this.jad_bo) * 31);
        }
    }

    public jad_mz(long j10) {
        this.jad_an = new jad_an(this, j10);
    }
}
