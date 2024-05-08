package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aoA;
    public String aoB;

    public static b AN() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bB, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cB(String str) {
        this.aoA = str;
        return this;
    }

    public final b cC(String str) {
        this.aoB = str;
        return this;
    }
}
