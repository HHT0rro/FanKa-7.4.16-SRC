package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aoM;
    public int apD;
    public int apE;
    public long apF;
    public int apt;
    public String apu;
    public int retryCount;
    public int status;

    public static b Bp() {
        return new b();
    }

    public final b ae(long j10) {
        this.apF = j10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bS, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cZ(String str) {
        this.apu = str;
        return this;
    }

    public final b cs(int i10) {
        this.status = i10;
        return this;
    }

    public final b ct(int i10) {
        this.aoM = i10;
        return this;
    }

    public final b cu(int i10) {
        this.retryCount = i10;
        return this;
    }

    public final b cv(int i10) {
        this.apt = i10;
        return this;
    }

    public final b cw(int i10) {
        this.apD = i10;
        return this;
    }

    public final b cx(int i10) {
        this.apE = i10;
        return this;
    }
}
