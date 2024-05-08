package com.kwad.sdk.core.adlog.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String KG;
    public a.C0516a KH;
    public long Li;
    public int Om;

    @NonNull
    public AdTemplate adTemplate;
    public String adnName;
    public int adnType;
    public int aoM;
    public JSONObject apH;
    public int apI;
    public int apJ;
    public int apK;
    public int apL;
    public String apM;
    public int apR;
    public String apS;
    public int apT;
    public int apU;
    public String apW;
    public int apX;
    public int apY;
    public String apZ;
    public String aqa;
    public int aqb;
    public int aqc;
    public long aqd;
    public long aqe;
    public int aqh;
    public int aqi;
    public String aqk;
    public int aqm;
    public int aqn;
    public int aqo;
    public String aqq;
    public int downloadSource;
    public int kl;
    public ac.a kn;
    public double ko;
    public long vz;
    public long apN = -1;
    public int apO = -1;
    public long apP = -1;
    public int apQ = -1;
    public int KI = 0;
    public String apV = "";
    public int aqf = -1;
    public int aqg = -1;
    public int downloadStatus = 0;
    public int aqj = -1;
    public int KF = -1;
    public int aql = -1;
    public int adxResult = -1;
    public int KJ = -1;
    public int aqp = 0;

    public static a Br() {
        return new a();
    }

    public final void a(@Nullable h hVar) {
        if (hVar != null) {
            this.aqq = hVar.EL();
        }
    }

    public final a af(long j10) {
        this.vz = j10;
        return this;
    }

    public final a ag(long j10) {
        this.Li = j10;
        return this;
    }

    public final void cD(int i10) {
        if (i10 == 0) {
            this.aqn = 1;
        } else if (i10 == 1) {
            this.aqn = 2;
        } else {
            if (i10 != 2) {
                return;
            }
            this.aqn = 3;
        }
    }

    public final a cE(int i10) {
        this.kl = i10;
        return this;
    }

    public final a cF(int i10) {
        this.KI = i10;
        return this;
    }

    public final a cG(int i10) {
        this.KJ = i10;
        return this;
    }

    public final a cH(int i10) {
        this.KF = i10;
        return this;
    }

    public final a cI(int i10) {
        this.Om = i10;
        return this;
    }

    public final a cJ(int i10) {
        this.apX = i10;
        return this;
    }

    public final a dc(String str) {
        this.KG = str;
        return this;
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0516a c0516a = this.KH;
        if (c0516a == null) {
            a.C0516a c0516a2 = new a.C0516a();
            this.KH = c0516a2;
            c0516a2.a(adTemplate, null, null, null);
        } else if (c0516a.apk == null) {
            c0516a.a(adTemplate, null, null, null);
        }
    }

    public final a a(a.C0516a c0516a) {
        this.KH = c0516a;
        return this;
    }

    public final a e(ac.a aVar) {
        this.kn = aVar;
        return this;
    }
}
