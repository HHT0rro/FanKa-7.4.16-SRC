package com.kwad.sdk.ranger;

import com.ksad.json.annotation.KsJson;
import java.util.List;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends com.kwad.sdk.core.response.a.a {
    public List<String> aNk;
    public List<a> aNl;
    public List<com.kwad.sdk.ranger.a.a> aNm;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aNn;
        public String aNo;
    }

    private boolean dX(int i10) {
        return (KC() || (this.funcSwitch & ((long) i10)) == 0) ? false : true;
    }

    public final boolean KC() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean KD() {
        return dX(4);
    }

    public final boolean KE() {
        return dX(16);
    }
}
