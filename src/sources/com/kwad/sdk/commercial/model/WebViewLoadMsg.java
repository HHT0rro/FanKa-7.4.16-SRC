package com.kwad.sdk.commercial.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WebViewLoadMsg extends a implements Serializable {
    public static final int FAIL = 2;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8132509704708242619L;
    public String costTime;
    public String failReason;
    public String interval;
    public int state;
    public String url;

    public WebViewLoadMsg setCostTime(String str) {
        this.costTime = str;
        return this;
    }

    public WebViewLoadMsg setFailReason(String str) {
        this.failReason = str;
        return this;
    }

    public WebViewLoadMsg setInterval(String str) {
        this.interval = str;
        return this;
    }

    public WebViewLoadMsg setState(int i10) {
        this.state = i10;
        return this;
    }

    public WebViewLoadMsg setUrl(String str) {
        this.url = str;
        return this;
    }
}
