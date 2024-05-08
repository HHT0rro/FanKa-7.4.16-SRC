package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.alibaba.security.common.track.model.TrackConstants;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ic implements io {
    private static final String Code = "OmPresent";
    private iz I;
    private ik V;
    private boolean Z;
    private boolean B = true;
    private boolean C = false;
    private boolean S = false;
    private boolean F = false;
    private boolean D = false;

    @Override // com.huawei.hms.ads.iz
    public void B() {
        iz izVar = this.I;
        if (izVar == null) {
            return;
        }
        izVar.B();
    }

    @Override // com.huawei.hms.ads.iz
    public void C() {
        iz izVar = this.I;
        if (izVar == null) {
            return;
        }
        izVar.C();
    }

    public ik Code() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(float f10) {
        if (gl.Code()) {
            gl.Code(Code, "onProgress, isAllowRepeat= %s, isVideoComplete= %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        }
        if (this.B || !this.C) {
            ik ikVar = this.V;
            if (ikVar instanceof in) {
                ((in) ikVar).Code(f10);
            }
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(float f10, boolean z10) {
        gl.V(Code, "start");
        if (!this.B && this.C) {
            gl.I(Code, "start: Video completed");
            return;
        }
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).Code(f10, z10);
        }
    }

    @Override // com.huawei.hms.ads.io
    public void Code(Context context, AdContentData adContentData, hy hyVar, boolean z10) {
        if ((adContentData != null ? adContentData.ae() : null) == null) {
            gl.V(Code, "om is null, no initialization is required");
            return;
        }
        if (this.F) {
            return;
        }
        gl.V(Code, "init omPresent");
        this.I = ie.Code(context, adContentData, hyVar, z10);
        ik Code2 = ij.Code(adContentData);
        this.V = Code2;
        Code2.Code(this.I);
        this.Z = z10;
        this.F = true;
        this.D = false;
        this.S = false;
    }

    @Override // com.huawei.hms.ads.iz
    public void Code(View view) {
        if (this.Z) {
            return;
        }
        iz izVar = this.I;
        if (izVar == null) {
            gl.V(Code, "AdSessionAgent is null");
        } else {
            izVar.Code(view);
        }
    }

    @Override // com.huawei.hms.ads.iz
    public void Code(View view, iy iyVar, String str) {
        iz izVar = this.I;
        if (izVar == null) {
            return;
        }
        izVar.Code(view, iyVar, str);
    }

    @Override // com.huawei.hms.ads.iz
    public void Code(ix ixVar, String str) {
        iz izVar = this.I;
        if (izVar == null) {
            return;
        }
        izVar.Code(ixVar, str);
    }

    @Override // com.huawei.hms.ads.je
    public void Code(ji jiVar) {
        gl.V(Code, "load vastPropertiesWrapper");
        if (this.B || !this.S) {
            ik ikVar = this.V;
            if (ikVar instanceof Cif) {
                ((Cif) ikVar).Code(jiVar);
            }
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(jk jkVar) {
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).Code(jkVar);
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(jl jlVar) {
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).Code(jlVar);
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(jn jnVar) {
        if (!this.B && this.C) {
            gl.I(Code, "loaded: Video completed");
            return;
        }
        if (this.D) {
            if (gl.Code()) {
                gl.Code(Code, "Already loaded");
            }
        } else {
            ik ikVar = this.V;
            if (ikVar instanceof in) {
                ((in) ikVar).Code(jnVar);
            }
            this.D = true;
        }
    }

    @Override // com.huawei.hms.ads.io
    public void Code(boolean z10) {
        this.B = z10;
    }

    @Override // com.huawei.hms.ads.je
    public void D() {
        gl.V(Code, "impressionOccurred");
        if (this.S) {
            return;
        }
        ik ikVar = this.V;
        if (ikVar instanceof Cif) {
            ((Cif) ikVar).D();
            this.S = true;
        }
        ik ikVar2 = this.V;
        if (ikVar2 instanceof in) {
            ((in) ikVar2).B();
            this.S = true;
        }
    }

    @Override // com.huawei.hms.ads.iz
    public String F() {
        iz izVar = this.I;
        if (izVar == null) {
            return null;
        }
        return izVar.F();
    }

    @Override // com.huawei.hms.ads.io
    public void I() {
        gl.V(Code, "release");
        if (this.F) {
            this.B = true;
            this.C = false;
            this.S = false;
            ik ikVar = this.V;
            if (ikVar != null) {
                ikVar.V();
            }
            iz izVar = this.I;
            if (izVar != null) {
                izVar.B();
            }
            this.F = false;
        }
    }

    @Override // com.huawei.hms.ads.iz
    public void I(View view) {
        iz izVar = this.I;
        if (izVar == null) {
            return;
        }
        izVar.I(view);
    }

    @Override // com.huawei.hms.ads.je
    public void L() {
        gl.V(Code, TrackConstants.Method.LOAD);
        if (this.B || !this.S) {
            ik ikVar = this.V;
            if (ikVar instanceof Cif) {
                ((Cif) ikVar).L();
            }
        }
    }

    @Override // com.huawei.hms.ads.iz
    public iv S() {
        iz izVar = this.I;
        if (izVar == null) {
            return null;
        }
        return izVar.S();
    }

    @Override // com.huawei.hms.ads.io
    public iz V() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.jj
    public void V(float f10) {
        if (!this.B && this.C) {
            gl.I(Code, "volumeChange: Video completed");
            return;
        }
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).V(f10);
        }
    }

    @Override // com.huawei.hms.ads.iz
    public void V(View view) {
        iz izVar = this.I;
        if (izVar == null) {
            return;
        }
        izVar.V(view);
    }

    @Override // com.huawei.hms.ads.jj
    public void V(boolean z10) {
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).V(z10);
        }
    }

    @Override // com.huawei.hms.ads.iz
    public void Z() {
        iz izVar = this.I;
        if (izVar == null) {
            gl.V(Code, "AdSessionAgent is null");
        } else {
            izVar.Z();
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void a() {
        gl.V(Code, "complete");
        if (this.B || !this.C) {
            ik ikVar = this.V;
            if (ikVar instanceof in) {
                ((in) ikVar).a();
                this.C = true;
            }
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void b() {
        if (this.B || !this.C) {
            ik ikVar = this.V;
            if (ikVar instanceof in) {
                ((in) ikVar).b();
            }
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void c() {
        if (this.B || !this.C) {
            ik ikVar = this.V;
            if (ikVar instanceof in) {
                ((in) ikVar).c();
            }
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void d() {
        gl.V(Code, "skipped");
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).d();
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void e() {
        gl.V(Code, "pause");
        if (!this.B && this.C) {
            gl.I(Code, "pause: Video completed");
            return;
        }
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).e();
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void f() {
        gl.V(Code, "resume");
        if (!this.B && this.C) {
            gl.I(Code, "resume: Video completed");
            return;
        }
        ik ikVar = this.V;
        if (ikVar instanceof in) {
            ((in) ikVar).f();
        }
    }
}
