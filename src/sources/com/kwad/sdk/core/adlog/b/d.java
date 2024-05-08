package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public int aoM;
    public String aoO;
    public int apG;
    public int retryCount;
    public int status;

    public static d Bq() {
        return new d();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bT, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final d cA(int i10) {
        this.apG = 1;
        return this;
    }

    public final d cB(int i10) {
        this.retryCount = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cC, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i10) {
        super.setErrorCode(i10);
        return this;
    }

    public final d cy(int i10) {
        this.status = i10;
        return this;
    }

    public final d cz(int i10) {
        this.aoM = i10;
        return this;
    }

    public final d da(String str) {
        this.aoO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: db, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
