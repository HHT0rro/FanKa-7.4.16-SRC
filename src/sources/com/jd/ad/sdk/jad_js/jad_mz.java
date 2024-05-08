package com.jd.ad.sdk.jad_js;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ud.jad_cp;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_mz extends Drawable implements Drawable.Callback, Animatable {
    public final Matrix jad_an = new Matrix();
    public com.jd.ad.sdk.jad_js.jad_jt jad_bo;
    public final com.jd.ad.sdk.jad_ve.jad_er jad_cp;
    public float jad_dq;
    public boolean jad_er;
    public boolean jad_fs;
    public final ArrayList<jad_ob> jad_hu;

    @Nullable
    public com.jd.ad.sdk.jad_nw.jad_bo jad_iv;
    public boolean jad_jt;

    @Nullable
    public String jad_jw;

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_bo jad_kx;

    @Nullable
    public com.jd.ad.sdk.jad_nw.jad_an jad_ly;

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_an jad_mz;
    public boolean jad_na;

    @Nullable
    public com.jd.ad.sdk.jad_ra.jad_bo jad_ob;
    public int jad_pc;
    public boolean jad_qd;
    public boolean jad_re;
    public boolean jad_sf;
    public boolean jad_tg;
    public boolean jad_uh;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an implements jad_ob {
        public final /* synthetic */ String jad_an;

        public jad_an(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_bo(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_bo implements jad_ob {
        public final /* synthetic */ int jad_an;
        public final /* synthetic */ int jad_bo;

        public jad_bo(int i10, int i11) {
            this.jad_an = i10;
            this.jad_bo = i11;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an, this.jad_bo);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_cp implements jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_cp(int i10) {
            this.jad_an = i10;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_dq implements jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_dq(float f10) {
            this.jad_an = f10;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_cp(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_er implements jad_ob {
        public final /* synthetic */ com.jd.ad.sdk.jad_ox.jad_er jad_an;
        public final /* synthetic */ Object jad_bo;
        public final /* synthetic */ com.jd.ad.sdk.jad_wf.jad_cp jad_cp;

        public jad_er(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, Object obj, com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
            this.jad_an = jad_erVar;
            this.jad_bo = obj;
            this.jad_cp = jad_cpVar;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an, this.jad_bo, this.jad_cp);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_fs implements ValueAnimator.AnimatorUpdateListener {
        public jad_fs() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            jad_mz jad_mzVar = jad_mz.this;
            com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = jad_mzVar.jad_ob;
            if (jad_boVar != null) {
                jad_boVar.jad_cp(jad_mzVar.jad_cp.jad_cp());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_hu implements jad_ob {
        public jad_hu() {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_jt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_iv implements jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_iv(int i10) {
            this.jad_an = i10;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_cp(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_jt implements jad_ob {
        public jad_jt() {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_fs();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_jw implements jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_jw(float f10) {
            this.jad_an = f10;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_bo(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_kx implements jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_kx(int i10) {
            this.jad_an = i10;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_bo(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_ly implements jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_ly(float f10) {
            this.jad_an = f10;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_js.jad_mz$jad_mz, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class C0365jad_mz implements jad_ob {
        public final /* synthetic */ String jad_an;

        public C0365jad_mz(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_cp(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_na implements jad_ob {
        public final /* synthetic */ String jad_an;

        public jad_na(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_ob {
        void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar);
    }

    public jad_mz() {
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = new com.jd.ad.sdk.jad_ve.jad_er();
        this.jad_cp = jad_erVar;
        this.jad_dq = 1.0f;
        this.jad_er = true;
        this.jad_fs = false;
        this.jad_jt = false;
        this.jad_hu = new ArrayList<>();
        jad_fs jad_fsVar = new jad_fs();
        this.jad_pc = 255;
        this.jad_tg = true;
        this.jad_uh = false;
        jad_erVar.addUpdateListener(jad_fsVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.jad_uh = false;
        if (this.jad_jt) {
            try {
                jad_an(canvas);
            } catch (Throwable unused) {
                com.jd.ad.sdk.jad_ve.jad_dq.jad_an.getClass();
            }
        } else {
            jad_an(canvas);
        }
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.jad_pc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.jad_bo == null) {
            return -1;
        }
        return (int) (this.jad_dq * r0.jad_jw.height());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.jad_bo == null) {
            return -1;
        }
        return (int) (this.jad_dq * r0.jad_jw.width());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jad_uh) {
            return;
        }
        this.jad_uh = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return jad_er();
    }

    public void jad_an(int i10) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_cp(i10));
        } else {
            this.jad_cp.jad_an(i10);
        }
    }

    public void jad_an(int i10, int i11) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_bo(i10, i11));
        } else {
            this.jad_cp.jad_an(i10, i11 + 0.99f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, T t2, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = this.jad_ob;
        if (jad_boVar == null) {
            this.jad_hu.add(new jad_er(jad_erVar, t2, jad_cpVar));
            return;
        }
        boolean z10 = true;
        if (jad_erVar == com.jd.ad.sdk.jad_ox.jad_er.jad_cp) {
            jad_boVar.jad_an((com.jd.ad.sdk.jad_ra.jad_bo) t2, (com.jd.ad.sdk.jad_wf.jad_cp<com.jd.ad.sdk.jad_ra.jad_bo>) jad_cpVar);
        } else {
            com.jd.ad.sdk.jad_ox.jad_fs jad_fsVar = jad_erVar.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_an(t2, jad_cpVar);
            } else {
                ArrayList arrayList = new ArrayList();
                this.jad_ob.jad_an(jad_erVar, 0, arrayList, new com.jd.ad.sdk.jad_ox.jad_er(new String[0]));
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ((com.jd.ad.sdk.jad_ox.jad_er) arrayList.get(i10)).jad_bo.jad_an(t2, jad_cpVar);
                }
                z10 = true ^ arrayList.isEmpty();
            }
        }
        if (z10) {
            invalidateSelf();
            if (t2 == jad_re.jad_gr) {
                jad_cp(this.jad_cp.jad_cp());
            }
        }
    }

    public void jad_an(String str) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_na(str));
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            jad_bo((int) (jad_bo2.jad_bo + jad_bo2.jad_cp));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public final boolean jad_an() {
        return this.jad_er || this.jad_fs;
    }

    public final void jad_bo() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        jad_cp.jad_an jad_anVar = com.jd.ad.sdk.jad_tc.jad_vi.jad_an;
        Rect rect = jad_jtVar.jad_jw;
        com.jd.ad.sdk.jad_ra.jad_er jad_erVar = new com.jd.ad.sdk.jad_ra.jad_er(Collections.emptyList(), jad_jtVar, "__container", -1L, 1, -1L, null, Collections.emptyList(), new com.jd.ad.sdk.jad_py.jad_ly(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false, null, null);
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar2 = this.jad_bo;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = new com.jd.ad.sdk.jad_ra.jad_bo(this, jad_erVar, jad_jtVar2.jad_iv, jad_jtVar2);
        this.jad_ob = jad_boVar;
        if (this.jad_re) {
            jad_boVar.jad_an(true);
        }
    }

    public void jad_bo(String str) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_an(str));
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            int i10 = (int) jad_bo2.jad_bo;
            jad_an(i10, ((int) jad_bo2.jad_cp) + i10);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void jad_cp() {
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
        if (jad_erVar.jad_kx) {
            jad_erVar.cancel();
        }
        this.jad_bo = null;
        this.jad_ob = null;
        this.jad_iv = null;
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar2 = this.jad_cp;
        jad_erVar2.jad_jw = null;
        jad_erVar2.jad_hu = -2.14748365E9f;
        jad_erVar2.jad_iv = 2.14748365E9f;
        invalidateSelf();
    }

    public void jad_cp(String str) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new C0365jad_mz(str));
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            jad_cp((int) jad_bo2.jad_bo);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public com.jd.ad.sdk.jad_js.jad_jt jad_dq() {
        return this.jad_bo;
    }

    public boolean jad_er() {
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
        if (jad_erVar == null) {
            return false;
        }
        return jad_erVar.jad_kx;
    }

    @MainThread
    public void jad_fs() {
        float jad_dq2;
        if (this.jad_ob == null) {
            this.jad_hu.add(new jad_jt());
            return;
        }
        if (jad_an() || this.jad_cp.getRepeatCount() == 0) {
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
            jad_erVar.jad_kx = true;
            boolean jad_fs2 = jad_erVar.jad_fs();
            for (Animator.AnimatorListener animatorListener : jad_erVar.jad_bo) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(jad_erVar, jad_fs2);
                } else {
                    animatorListener.onAnimationStart(jad_erVar);
                }
            }
            jad_erVar.jad_an((int) (jad_erVar.jad_fs() ? jad_erVar.jad_dq() : jad_erVar.jad_er()));
            jad_erVar.jad_er = 0L;
            jad_erVar.jad_jt = 0;
            jad_erVar.jad_jt();
        }
        if (jad_an()) {
            return;
        }
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar2 = this.jad_cp;
        if (jad_erVar2.jad_cp < 0.0f) {
            jad_dq2 = jad_erVar2.jad_er();
        } else {
            jad_dq2 = jad_erVar2.jad_dq();
        }
        jad_an((int) jad_dq2);
        this.jad_cp.jad_bo();
    }

    @MainThread
    public void jad_jt() {
        float jad_dq2;
        if (this.jad_ob == null) {
            this.jad_hu.add(new jad_hu());
            return;
        }
        if (jad_an() || this.jad_cp.getRepeatCount() == 0) {
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
            jad_erVar.jad_kx = true;
            jad_erVar.jad_jt();
            jad_erVar.jad_er = 0L;
            if (jad_erVar.jad_fs() && jad_erVar.jad_fs == jad_erVar.jad_er()) {
                jad_erVar.jad_fs = jad_erVar.jad_dq();
            } else if (!jad_erVar.jad_fs() && jad_erVar.jad_fs == jad_erVar.jad_dq()) {
                jad_erVar.jad_fs = jad_erVar.jad_er();
            }
        }
        if (jad_an()) {
            return;
        }
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar2 = this.jad_cp;
        if (jad_erVar2.jad_cp < 0.0f) {
            jad_dq2 = jad_erVar2.jad_er();
        } else {
            jad_dq2 = jad_erVar2.jad_dq();
        }
        jad_an((int) jad_dq2);
        this.jad_cp.jad_bo();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i10) {
        this.jad_pc = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        jad_fs();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        this.jad_hu.clear();
        this.jad_cp.jad_bo();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void jad_cp(int i10) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_iv(i10));
        } else {
            this.jad_cp.jad_an(i10, (int) r0.jad_iv);
        }
    }

    public void jad_cp(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_dq(f10));
        } else {
            this.jad_cp.jad_an(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f10));
            com.jd.ad.sdk.jad_js.jad_dq.jad_an("Drawable#setProgress");
        }
    }

    public void jad_bo(int i10) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_kx(i10));
            return;
        }
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
        jad_erVar.jad_an(jad_erVar.jad_hu, i10 + 0.99f);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void jad_an(@androidx.annotation.NonNull android.graphics.Canvas r10) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_js.jad_mz.jad_an(android.graphics.Canvas):void");
    }

    public void jad_bo(float f10) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_jw(f10));
        } else {
            jad_cp((int) com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f10));
        }
    }

    public void jad_an(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_ly(f10));
        } else {
            jad_bo((int) com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f10));
        }
    }
}
