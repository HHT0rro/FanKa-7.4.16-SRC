package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int Om;
    public String aog;
    public String aon;
    public int status;
    public String url;

    public static b AQ() {
        return new b();
    }

    public final b cG(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b ck(int i10) {
        this.status = i10;
        return this;
    }

    public final b cl(int i10) {
        this.Om = i10;
        return this;
    }
}
