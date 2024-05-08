package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String NR;
    public long NS;
    public long NT;
    public String NV;
    public long NW;

    public final d C(long j10) {
        this.NS = j10;
        return this;
    }

    public final d D(long j10) {
        this.NT = j10;
        return this;
    }

    public final d E(long j10) {
        this.NW = j10;
        return this;
    }

    public final d ap(String str) {
        this.NR = str;
        return this;
    }

    public final d aq(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d ar(String str) {
        this.NV = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ay, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i10) {
        this.errorCode = i10;
        return this;
    }
}
