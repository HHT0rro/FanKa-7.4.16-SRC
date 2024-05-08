package com.kwad.sdk.commercial.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aog;
    public String aoh;
    public String aoi;
    public long aoj;
    public long aok;
    public int aol;
    public int aom;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b AK() {
        return new b();
    }

    public final b ac(long j10) {
        this.downloadTime = j10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bb, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo dQ = e.dQ(adTemplate);
        this.url = e.dT(adTemplate);
        try {
            this.aog = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = dQ.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = dQ.adBaseInfo;
        this.aoh = adBaseInfo.appPackageName;
        this.aoi = adBaseInfo.appName;
        this.aoj = dQ.totalBytes;
        this.aok = dQ.soFarBytes;
        return this;
    }

    public final b cc(int i10) {
        this.status = i10;
        return this;
    }

    public final b cd(int i10) {
        this.aol = i10;
        return this;
    }

    public final b ce(int i10) {
        this.aom = i10;
        return this;
    }
}
