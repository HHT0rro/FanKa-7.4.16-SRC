package com.jd.ad.sdk.jad_al;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_bo implements jad_fs, jad_dq {
    public final Object jad_an;

    @Nullable
    public final jad_fs jad_bo;
    public volatile jad_dq jad_cp;
    public volatile jad_dq jad_dq;

    @GuardedBy("requestLock")
    public int jad_er = 3;

    @GuardedBy("requestLock")
    public int jad_fs = 3;

    public jad_bo(Object obj, @Nullable jad_fs jad_fsVar) {
        this.jad_an = obj;
        this.jad_bo = jad_fsVar;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void clear() {
        synchronized (this.jad_an) {
            this.jad_er = 3;
            this.jad_cp.clear();
            if (this.jad_fs != 3) {
                this.jad_fs = 3;
                this.jad_dq.clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean isRunning() {
        boolean z10;
        synchronized (this.jad_an) {
            z10 = true;
            if (this.jad_er != 1 && this.jad_fs != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public void jad_an(jad_dq jad_dqVar) {
        synchronized (this.jad_an) {
            if (jad_dqVar.equals(this.jad_dq)) {
                this.jad_fs = 5;
                jad_fs jad_fsVar = this.jad_bo;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_an(this);
                }
                return;
            }
            this.jad_er = 5;
            if (this.jad_fs != 1) {
                this.jad_fs = 1;
                this.jad_dq.jad_fs();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs, com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_an() {
        boolean z10;
        synchronized (this.jad_an) {
            z10 = this.jad_cp.jad_an() || this.jad_dq.jad_an();
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public jad_fs jad_bo() {
        jad_fs jad_bo;
        synchronized (this.jad_an) {
            jad_fs jad_fsVar = this.jad_bo;
            jad_bo = jad_fsVar != null ? jad_fsVar.jad_bo() : this;
        }
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public boolean jad_bo(jad_dq jad_dqVar) {
        boolean z10;
        boolean z11;
        synchronized (this.jad_an) {
            jad_fs jad_fsVar = this.jad_bo;
            z10 = false;
            if (jad_fsVar != null && !jad_fsVar.jad_bo(this)) {
                z11 = false;
                if (z11 && jad_jt(jad_dqVar)) {
                    z10 = true;
                }
            }
            z11 = true;
            if (z11) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_cp() {
        boolean z10;
        synchronized (this.jad_an) {
            z10 = this.jad_er == 4 || this.jad_fs == 4;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public boolean jad_cp(jad_dq jad_dqVar) {
        boolean z10;
        boolean z11;
        synchronized (this.jad_an) {
            jad_fs jad_fsVar = this.jad_bo;
            z10 = false;
            if (jad_fsVar != null && !jad_fsVar.jad_cp(this)) {
                z11 = false;
                if (z11 && jad_jt(jad_dqVar)) {
                    z10 = true;
                }
            }
            z11 = true;
            if (z11) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void jad_dq() {
        synchronized (this.jad_an) {
            if (this.jad_er == 1) {
                this.jad_er = 2;
                this.jad_cp.jad_dq();
            }
            if (this.jad_fs == 1) {
                this.jad_fs = 2;
                this.jad_dq.jad_dq();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_dq(jad_dq jad_dqVar) {
        if (!(jad_dqVar instanceof jad_bo)) {
            return false;
        }
        jad_bo jad_boVar = (jad_bo) jad_dqVar;
        return this.jad_cp.jad_dq(jad_boVar.jad_cp) && this.jad_dq.jad_dq(jad_boVar.jad_dq);
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public void jad_er(jad_dq jad_dqVar) {
        synchronized (this.jad_an) {
            if (jad_dqVar.equals(this.jad_cp)) {
                this.jad_er = 4;
            } else if (jad_dqVar.equals(this.jad_dq)) {
                this.jad_fs = 4;
            }
            jad_fs jad_fsVar = this.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_er(this);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_er() {
        boolean z10;
        synchronized (this.jad_an) {
            z10 = this.jad_er == 3 && this.jad_fs == 3;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void jad_fs() {
        synchronized (this.jad_an) {
            if (this.jad_er != 1) {
                this.jad_er = 1;
                this.jad_cp.jad_fs();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public boolean jad_fs(jad_dq jad_dqVar) {
        boolean z10;
        boolean z11;
        synchronized (this.jad_an) {
            jad_fs jad_fsVar = this.jad_bo;
            z10 = false;
            if (jad_fsVar != null && !jad_fsVar.jad_fs(this)) {
                z11 = false;
                if (z11 && jad_jt(jad_dqVar)) {
                    z10 = true;
                }
            }
            z11 = true;
            if (z11) {
                z10 = true;
            }
        }
        return z10;
    }

    @GuardedBy("requestLock")
    public final boolean jad_jt(jad_dq jad_dqVar) {
        return jad_dqVar.equals(this.jad_cp) || (this.jad_er == 5 && jad_dqVar.equals(this.jad_dq));
    }
}
