package com.kwad.sdk.commercial.f;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aog;
    public String aon;
    public int status;
    public String url;

    public static b AP() {
        return new b();
    }

    public final b cF(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cj(int i10) {
        this.status = i10;
        return this;
    }
}
