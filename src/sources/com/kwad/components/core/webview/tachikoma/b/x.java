package com.kwad.components.core.webview.tachikoma.b;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class x extends com.kwad.sdk.core.response.a.a {
    public String aaw;
    public int errorCode;
    public String errorReason;
    public int nE;

    public final boolean isFailed() {
        return TextUtils.equals(com.alipay.sdk.util.e.f4721a, this.aaw);
    }

    public final boolean sR() {
        return TextUtils.equals("start", this.aaw);
    }

    public final boolean sS() {
        return TextUtils.equals("end", this.aaw);
    }

    public final boolean sT() {
        return TextUtils.equals("progress", this.aaw);
    }

    public final int sU() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return 0;
        }
    }
}
