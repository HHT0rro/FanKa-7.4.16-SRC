package com.jd.ad.sdk.jad_al;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_kx implements jad_fs, jad_dq {

    @Nullable
    public final jad_fs jad_an;
    public final Object jad_bo;
    public volatile jad_dq jad_cp;
    public volatile jad_dq jad_dq;

    @GuardedBy("requestLock")
    public int jad_er = 3;

    @GuardedBy("requestLock")
    public int jad_fs = 3;

    @GuardedBy("requestLock")
    public boolean jad_jt;

    public jad_kx(Object obj, @Nullable jad_fs jad_fsVar) {
        this.jad_bo = obj;
        this.jad_an = jad_fsVar;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void clear() {
        synchronized (this.jad_bo) {
            this.jad_jt = false;
            this.jad_er = 3;
            this.jad_fs = 3;
            this.jad_dq.clear();
            this.jad_cp.clear();
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean isRunning() {
        boolean z10;
        synchronized (this.jad_bo) {
            z10 = true;
            if (this.jad_er != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public void jad_an(jad_dq jad_dqVar) {
        synchronized (this.jad_bo) {
            if (!jad_dqVar.equals(this.jad_cp)) {
                this.jad_fs = 5;
                return;
            }
            this.jad_er = 5;
            jad_fs jad_fsVar = this.jad_an;
            if (jad_fsVar != null) {
                jad_fsVar.jad_an(this);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs, com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_an() {
        boolean z10;
        synchronized (this.jad_bo) {
            z10 = this.jad_dq.jad_an() || this.jad_cp.jad_an();
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public jad_fs jad_bo() {
        jad_fs jad_bo;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            jad_bo = jad_fsVar != null ? jad_fsVar.jad_bo() : this;
        }
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public boolean jad_bo(jad_dq jad_dqVar) {
        boolean z10;
        boolean z11;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            z10 = false;
            if (jad_fsVar != null && !jad_fsVar.jad_bo(this)) {
                z11 = false;
                if (z11 && (jad_dqVar.equals(this.jad_cp) || this.jad_er != 4)) {
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
        synchronized (this.jad_bo) {
            z10 = this.jad_er == 4;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public boolean jad_cp(jad_dq jad_dqVar) {
        boolean z10;
        boolean z11;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            z10 = false;
            if (jad_fsVar != null && !jad_fsVar.jad_cp(this)) {
                z11 = false;
                if (z11 && jad_dqVar.equals(this.jad_cp) && !jad_an()) {
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
        synchronized (this.jad_bo) {
            if (!jad_er.jad_an(this.jad_fs)) {
                this.jad_fs = 2;
                this.jad_dq.jad_dq();
            }
            if (!jad_er.jad_an(this.jad_er)) {
                this.jad_er = 2;
                this.jad_cp.jad_dq();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_dq(jad_dq jad_dqVar) {
        if (!(jad_dqVar instanceof jad_kx)) {
            return false;
        }
        jad_kx jad_kxVar = (jad_kx) jad_dqVar;
        if (this.jad_cp == null) {
            if (jad_kxVar.jad_cp != null) {
                return false;
            }
        } else if (!this.jad_cp.jad_dq(jad_kxVar.jad_cp)) {
            return false;
        }
        if (this.jad_dq == null) {
            if (jad_kxVar.jad_dq != null) {
                return false;
            }
        } else if (!this.jad_dq.jad_dq(jad_kxVar.jad_dq)) {
            return false;
        }
        return true;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public void jad_er(jad_dq jad_dqVar) {
        synchronized (this.jad_bo) {
            if (jad_dqVar.equals(this.jad_dq)) {
                this.jad_fs = 4;
                return;
            }
            this.jad_er = 4;
            jad_fs jad_fsVar = this.jad_an;
            if (jad_fsVar != null) {
                jad_fsVar.jad_er(this);
            }
            if (!jad_er.jad_an(this.jad_fs)) {
                this.jad_dq.clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public boolean jad_er() {
        boolean z10;
        synchronized (this.jad_bo) {
            z10 = this.jad_er == 3;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_al.jad_dq
    public void jad_fs() {
        synchronized (this.jad_bo) {
            this.jad_jt = true;
            try {
                if (this.jad_er != 4 && this.jad_fs != 1) {
                    this.jad_fs = 1;
                    this.jad_dq.jad_fs();
                }
                if (this.jad_jt && this.jad_er != 1) {
                    this.jad_er = 1;
                    this.jad_cp.jad_fs();
                }
            } finally {
                this.jad_jt = false;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_al.jad_fs
    public boolean jad_fs(jad_dq jad_dqVar) {
        boolean z10;
        boolean z11;
        synchronized (this.jad_bo) {
            jad_fs jad_fsVar = this.jad_an;
            z10 = false;
            if (jad_fsVar != null && !jad_fsVar.jad_fs(this)) {
                z11 = false;
                if (z11 && jad_dqVar.equals(this.jad_cp) && this.jad_er != 2) {
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
}
