package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String NR;
    public long NS;
    public long NT;
    public long NU;
    public String NV;

    public final b A(long j10) {
        this.NS = j10;
        return this;
    }

    public final b B(long j10) {
        this.NT = j10;
        return this;
    }

    public final b am(String str) {
        this.NR = str;
        return this;
    }

    public final b an(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b ao(String str) {
        this.NV = str;
        return this;
    }

    public final b aw(int i10) {
        this.NU = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ax, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i10) {
        this.errorCode = i10;
        return this;
    }
}
