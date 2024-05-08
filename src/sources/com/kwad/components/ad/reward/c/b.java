package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int rm = 1;
    public static int rn = 3;
    public int ro;
    public int rp;

    public b() {
        this.ro = STATUS_NONE;
    }

    public final void M(int i10) {
        this.rp = i10;
    }

    public final int gO() {
        return this.rp;
    }

    public final int getType() {
        return this.ro;
    }

    public b(int i10) {
        this.ro = 1;
    }
}
