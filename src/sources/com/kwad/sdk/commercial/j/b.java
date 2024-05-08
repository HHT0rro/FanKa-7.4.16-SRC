package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aoM;
    public String aoN;
    public String aoO;
    public int aoP;
    public int status;

    public static b AX() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bC, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cM(String str) {
        this.aoN = str;
        return this;
    }

    public final b cN(String str) {
        this.aoO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cO, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public final b cn(int i10) {
        this.status = i10;
        return this;
    }

    public final b co(int i10) {
        this.aoM = i10;
        return this;
    }

    public final b cp(int i10) {
        this.aoP = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cq, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i10) {
        super.setErrorCode(i10);
        return this;
    }
}
