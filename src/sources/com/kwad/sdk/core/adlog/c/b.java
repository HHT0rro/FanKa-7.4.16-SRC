package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.ac;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private final a aqr = new a();

    public final a Bs() {
        return this.aqr;
    }

    public final b ah(long j10) {
        this.aqr.vz = j10;
        return this;
    }

    public final b b(a.C0516a c0516a) {
        this.aqr.KH = c0516a;
        return this;
    }

    public final b cK(int i10) {
        this.aqr.kl = i10;
        return this;
    }

    public final b cL(int i10) {
        this.aqr.apK = i10;
        return this;
    }

    public final b cM(int i10) {
        this.aqr.apL = i10;
        return this;
    }

    public final b cN(int i10) {
        this.aqr.downloadSource = i10;
        return this;
    }

    public final b cO(int i10) {
        this.aqr.apY = i10;
        return this;
    }

    public final b cP(int i10) {
        this.aqr.aqb = i10;
        return this;
    }

    public final b cQ(int i10) {
        this.aqr.aqc = i10;
        return this;
    }

    public final b cR(int i10) {
        this.aqr.apQ = i10;
        return this;
    }

    public final b cS(int i10) {
        this.aqr.aqi = i10;
        return this;
    }

    public final b cT(int i10) {
        this.aqr.aqm = i10;
        return this;
    }

    public final b cU(int i10) {
        this.aqr.cD(i10);
        return this;
    }

    public final b cV(int i10) {
        this.aqr.aqo = i10;
        return this;
    }

    public final b cW(int i10) {
        this.aqr.KJ = i10;
        return this;
    }

    public final b cX(int i10) {
        this.aqr.aqp = i10;
        return this;
    }

    public final b cY(int i10) {
        this.aqr.KI = i10;
        return this;
    }

    public final b dd(String str) {
        this.aqr.KG = str;
        return this;
    }

    public final b de(String str) {
        this.aqr.apZ = str;
        return this;
    }

    public final b df(String str) {
        this.aqr.aqa = str;
        return this;
    }

    public final b dg(String str) {
        this.aqr.aqk = str;
        return this;
    }

    public final b f(ac.a aVar) {
        this.aqr.kn = aVar;
        return this;
    }

    public final b l(double d10) {
        this.aqr.ko = d10;
        return this;
    }

    public final b v(int i10, int i11) {
        this.aqr.apM = i10 + "," + i11;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        a aVar2 = this.aqr;
        if (aVar2.KH == null) {
            aVar2.KH = new a.C0516a();
        }
        this.aqr.KH.a(adTemplate, str, str2, aVar);
        return this;
    }
}
