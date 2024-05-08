package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public String adSource;
    public String aow;
    public boolean aox;
    public boolean aoy;
    public String aoz;

    public static b AM() {
        return new b();
    }

    public final b bk(boolean z10) {
        this.aox = z10;
        return this;
    }

    public final b cA(String str) {
        this.adSource = str;
        return this;
    }

    public final b ci(int i10) {
        this.adNum = i10;
        return this;
    }

    public final b cy(String str) {
        this.aow = str;
        return this;
    }

    public final b cz(String str) {
        this.aoz = str;
        return this;
    }
}
