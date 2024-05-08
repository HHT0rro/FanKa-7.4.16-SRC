package com.jd.ad.sdk.jad_ra;

import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_py.jad_jw;
import com.jd.ad.sdk.jad_py.jad_kx;
import com.jd.ad.sdk.jad_py.jad_ly;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_er {
    public final List<com.jd.ad.sdk.jad_qz.jad_cp> jad_an;
    public final com.jd.ad.sdk.jad_js.jad_jt jad_bo;
    public final String jad_cp;
    public final long jad_dq;
    public final int jad_er;
    public final long jad_fs;
    public final List<com.jd.ad.sdk.jad_qz.jad_jt> jad_hu;
    public final jad_ly jad_iv;

    @Nullable
    public final String jad_jt;
    public final int jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final float jad_mz;
    public final float jad_na;
    public final int jad_ob;
    public final int jad_pc;

    @Nullable
    public final jad_jw jad_qd;

    @Nullable
    public final jad_kx jad_re;

    @Nullable
    public final com.jd.ad.sdk.jad_py.jad_bo jad_sf;
    public final List<com.jd.ad.sdk.jad_wf.jad_an<Float>> jad_tg;
    public final int jad_uh;
    public final boolean jad_vi;

    @Nullable
    public final com.jd.ad.sdk.jad_qz.jad_an jad_wj;

    @Nullable
    public final com.jd.ad.sdk.jad_tc.jad_jw jad_xk;

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lcom/jd/ad/sdk/jad_qz/jad_cp;>;Lcom/jd/ad/sdk/jad_js/jad_jt;Ljava/lang/String;JLjava/lang/Object;JLjava/lang/String;Ljava/util/List<Lcom/jd/ad/sdk/jad_qz/jad_jt;>;Lcom/jd/ad/sdk/jad_py/jad_ly;IIIFFIILcom/jd/ad/sdk/jad_py/jad_jw;Lcom/jd/ad/sdk/jad_py/jad_kx;Ljava/util/List<Lcom/jd/ad/sdk/jad_wf/jad_an<Ljava/lang/Float;>;>;Ljava/lang/Object;Lcom/jd/ad/sdk/jad_py/jad_bo;ZLcom/jd/ad/sdk/jad_qz/jad_an;Lcom/jd/ad/sdk/jad_tc/jad_jw;)V */
    public jad_er(List list, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar, String str, long j10, int i10, long j11, @Nullable String str2, List list2, jad_ly jad_lyVar, int i11, int i12, int i13, float f10, float f11, int i14, int i15, @Nullable jad_jw jad_jwVar, @Nullable jad_kx jad_kxVar, List list3, int i16, @Nullable com.jd.ad.sdk.jad_py.jad_bo jad_boVar, boolean z10, @Nullable com.jd.ad.sdk.jad_qz.jad_an jad_anVar, @Nullable com.jd.ad.sdk.jad_tc.jad_jw jad_jwVar2) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = str;
        this.jad_dq = j10;
        this.jad_er = i10;
        this.jad_fs = j11;
        this.jad_jt = str2;
        this.jad_hu = list2;
        this.jad_iv = jad_lyVar;
        this.jad_jw = i11;
        this.jad_kx = i12;
        this.jad_ly = i13;
        this.jad_mz = f10;
        this.jad_na = f11;
        this.jad_ob = i14;
        this.jad_pc = i15;
        this.jad_qd = jad_jwVar;
        this.jad_re = jad_kxVar;
        this.jad_tg = list3;
        this.jad_uh = i16;
        this.jad_sf = jad_boVar;
        this.jad_vi = z10;
        this.jad_wj = jad_anVar;
        this.jad_xk = jad_jwVar2;
    }

    public com.jd.ad.sdk.jad_js.jad_jt jad_an() {
        return this.jad_bo;
    }

    public String jad_an(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.jad_cp);
        sb2.append("\n");
        jad_er jad_an = this.jad_bo.jad_an(this.jad_fs);
        if (jad_an != null) {
            sb2.append("\t\tParents: ");
            sb2.append(jad_an.jad_cp);
            com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
            while (true) {
                jad_an = jad_jtVar.jad_an(jad_an.jad_fs);
                if (jad_an == null) {
                    break;
                }
                sb2.append("->");
                sb2.append(jad_an.jad_cp);
                jad_jtVar = this.jad_bo;
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!this.jad_hu.isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(this.jad_hu.size());
            sb2.append("\n");
        }
        if (this.jad_jw != 0 && this.jad_kx != 0) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.jad_jw), Integer.valueOf(this.jad_kx), Integer.valueOf(this.jad_ly)));
        }
        if (!this.jad_an.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar : this.jad_an) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append((Object) jad_cpVar);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public long jad_bo() {
        return this.jad_dq;
    }

    public List<com.jd.ad.sdk.jad_qz.jad_jt> jad_cp() {
        return this.jad_hu;
    }

    public int jad_dq() {
        return this.jad_uh;
    }

    public String jad_er() {
        return this.jad_cp;
    }

    public long jad_fs() {
        return this.jad_fs;
    }

    public int jad_hu() {
        return this.jad_ly;
    }

    @Nullable
    public jad_jw jad_iv() {
        return this.jad_qd;
    }

    public List<com.jd.ad.sdk.jad_qz.jad_cp> jad_jt() {
        return this.jad_an;
    }

    @Nullable
    public jad_kx jad_jw() {
        return this.jad_re;
    }

    @Nullable
    public com.jd.ad.sdk.jad_py.jad_bo jad_kx() {
        return this.jad_sf;
    }

    public jad_ly jad_ly() {
        return this.jad_iv;
    }

    public String toString() {
        return jad_an("");
    }
}
