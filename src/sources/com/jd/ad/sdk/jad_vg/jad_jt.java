package com.jd.ad.sdk.jad_vg;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_hs.jad_na;
import com.jd.ad.sdk.jad_kv.jad_ly;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_jt {
    public final com.jd.ad.sdk.jad_gr.jad_an jad_an;
    public final Handler jad_bo;
    public final List<jad_bo> jad_cp;
    public final com.jd.ad.sdk.jad_ep.jad_jw jad_dq;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_er;
    public boolean jad_fs;
    public com.jd.ad.sdk.jad_ep.jad_iv<Bitmap> jad_hu;
    public jad_an jad_iv;
    public boolean jad_jt;
    public boolean jad_jw;
    public jad_an jad_kx;
    public Bitmap jad_ly;
    public jad_na<Bitmap> jad_mz;
    public jad_an jad_na;
    public int jad_ob;
    public int jad_pc;
    public int jad_qd;

    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class jad_an extends com.jd.ad.sdk.jad_bm.jad_an<Bitmap> {
        public final Handler jad_dq;
        public final int jad_er;
        public final long jad_fs;
        public Bitmap jad_jt;

        public jad_an(Handler handler, int i10, long j10) {
            this.jad_dq = handler;
            this.jad_er = i10;
            this.jad_fs = j10;
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@Nullable Drawable drawable) {
            this.jad_jt = null;
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@NonNull Object obj, @Nullable com.jd.ad.sdk.jad_en.jad_bo jad_boVar) {
            this.jad_jt = (Bitmap) obj;
            this.jad_dq.sendMessageAtTime(this.jad_dq.obtainMessage(1, this), this.jad_fs);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface jad_bo {
        void jad_an();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_cp implements Handler.Callback {
        public jad_cp() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                jad_jt.this.jad_an((jad_an) message.obj);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            jad_jt.this.jad_dq.jad_an((jad_an) message.obj);
            return false;
        }
    }

    public jad_jt(com.jd.ad.sdk.jad_ep.jad_cp jad_cpVar, com.jd.ad.sdk.jad_gr.jad_an jad_anVar, int i10, int i11, jad_na<Bitmap> jad_naVar, Bitmap bitmap) {
        this(jad_cpVar.jad_an(), com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_cpVar.jad_cp()), jad_anVar, null, jad_an(com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_cpVar.jad_cp()), i10, i11), jad_naVar, bitmap);
    }

    public jad_jt(com.jd.ad.sdk.jad_lw.jad_er jad_erVar, com.jd.ad.sdk.jad_ep.jad_jw jad_jwVar, com.jd.ad.sdk.jad_gr.jad_an jad_anVar, Handler handler, com.jd.ad.sdk.jad_ep.jad_iv<Bitmap> jad_ivVar, jad_na<Bitmap> jad_naVar, Bitmap bitmap) {
        this.jad_cp = new ArrayList();
        this.jad_dq = jad_jwVar;
        Handler handler2 = new Handler(Looper.getMainLooper(), new jad_cp());
        this.jad_er = jad_erVar;
        this.jad_bo = handler2;
        this.jad_hu = jad_ivVar;
        this.jad_an = jad_anVar;
        jad_an(jad_naVar, bitmap);
    }

    public static com.jd.ad.sdk.jad_ep.jad_iv<Bitmap> jad_an(com.jd.ad.sdk.jad_ep.jad_jw jad_jwVar, int i10, int i11) {
        return jad_jwVar.jad_er().jad_bo(new com.jd.ad.sdk.jad_al.jad_hu().jad_an(jad_ly.jad_an).jad_bo(true).jad_an(true).jad_bo(i10, i11));
    }

    public final void jad_an() {
        if (!this.jad_fs || this.jad_jt) {
            return;
        }
        jad_an jad_anVar = this.jad_na;
        if (jad_anVar != null) {
            this.jad_na = null;
            jad_an(jad_anVar);
            return;
        }
        this.jad_jt = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.jad_an.jad_dq();
        this.jad_an.jad_jt();
        this.jad_kx = new jad_an(this.jad_bo, this.jad_an.jad_an(), uptimeMillis);
        this.jad_hu.jad_bo(new com.jd.ad.sdk.jad_al.jad_hu().jad_an(new com.jd.ad.sdk.jad_fo.jad_bo(Double.valueOf(Math.random())))).jad_an(this.jad_an).jad_an((com.jd.ad.sdk.jad_ep.jad_iv<Bitmap>) this.jad_kx);
    }

    @VisibleForTesting
    public void jad_an(jad_an jad_anVar) {
        this.jad_jt = false;
        if (this.jad_jw) {
            this.jad_bo.obtainMessage(2, jad_anVar).sendToTarget();
            return;
        }
        if (!this.jad_fs) {
            this.jad_na = jad_anVar;
            return;
        }
        if (jad_anVar.jad_jt != null) {
            Bitmap bitmap = this.jad_ly;
            if (bitmap != null) {
                this.jad_er.jad_an(bitmap);
                this.jad_ly = null;
            }
            jad_an jad_anVar2 = this.jad_iv;
            this.jad_iv = jad_anVar;
            for (int size = this.jad_cp.size() - 1; size >= 0; size--) {
                this.jad_cp.get(size).jad_an();
            }
            if (jad_anVar2 != null) {
                this.jad_bo.obtainMessage(2, jad_anVar2).sendToTarget();
            }
        }
        jad_an();
    }

    public void jad_an(jad_na<Bitmap> jad_naVar, Bitmap bitmap) {
        Objects.requireNonNull(jad_naVar, "Argument must not be null");
        this.jad_mz = jad_naVar;
        Objects.requireNonNull(bitmap, "Argument must not be null");
        this.jad_ly = bitmap;
        this.jad_hu = this.jad_hu.jad_bo(new com.jd.ad.sdk.jad_al.jad_hu().jad_an(jad_naVar, true));
        this.jad_ob = com.jd.ad.sdk.jad_gp.jad_ly.jad_an(bitmap);
        this.jad_pc = bitmap.getWidth();
        this.jad_qd = bitmap.getHeight();
    }
}
