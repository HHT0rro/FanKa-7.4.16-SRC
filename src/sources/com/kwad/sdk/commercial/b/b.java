package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aog;
    public String aon;
    public String aoo;
    public int aop;
    public int aoq;
    public int status;
    public String url;

    public static b AL() {
        return new b();
    }

    public final b cf(int i10) {
        this.status = i10;
        return this;
    }

    public final b cg(int i10) {
        this.aop = i10;
        return this;
    }

    public final b ch(int i10) {
        this.aoq = i10;
        return this;
    }

    public final b cw(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aog = url.getHost();
            this.aon = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cx(String str) {
        this.aoo = str;
        return this;
    }
}
