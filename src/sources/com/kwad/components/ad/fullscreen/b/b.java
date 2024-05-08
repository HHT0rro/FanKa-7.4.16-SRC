package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM;
    public int gN;

    public b() {
        this.gM = -1L;
        this.gN = -1;
    }

    public final boolean f(long j10) {
        if (this.gM > 0 && j10 > 0) {
            try {
                return gL.format(new Date(this.gM)).equals(gL.format(new Date(j10)));
            } catch (Exception e2) {
                c.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public final boolean w(int i10) {
        int i11 = this.gN;
        return i11 > 0 && i11 >= i10;
    }

    public b(long j10, int i10) {
        this.gM = j10;
        this.gN = 1;
    }
}
