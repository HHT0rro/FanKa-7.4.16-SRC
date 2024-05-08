package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public long posId;
    public String templateId;
    public String templateVersion;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.ea(adTemplate);
        this.llsid = e.dN(adTemplate);
        this.posId = e.dJ(adTemplate);
        AdMatrixInfo.MatrixTemplate aT = d.aT(adTemplate);
        if (aT != null) {
            this.templateId = aT.templateId;
            this.templateVersion = aT.templateVersion;
        }
        return this;
    }

    public a setErrorCode(int i10) {
        this.errorCode = i10;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j10) {
        this.llsid = j10;
        return this;
    }

    public a setPosId(long j10) {
        this.posId = j10;
        return this;
    }
}
