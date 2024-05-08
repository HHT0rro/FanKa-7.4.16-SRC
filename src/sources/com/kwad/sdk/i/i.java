package com.kwad.sdk.i;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i implements b {
    public String aJn;
    public String aJo;
    public String aJp;
    public long aJq = System.currentTimeMillis();
    public double aor;

    public static i Jl() {
        return new i();
    }

    public final i fV(String str) {
        this.aJn = str;
        return this;
    }

    public final i fW(String str) {
        this.aJo = str;
        return this;
    }

    public final i fX(String str) {
        this.aJp = str;
        return this;
    }

    public final i n(double d10) {
        this.aor = d10;
        return this;
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "ratio", Double.valueOf(this.aor));
        c.a(jSONObject, "ratio_count", Double.valueOf(j.o(this.aor)));
        c.putValue(jSONObject, "log_build_time_ms", this.aJq);
        c.putValue(jSONObject, "log_level", this.aJn);
        c.putValue(jSONObject, "log_tag", this.aJo);
        c.putValue(jSONObject, "log_content", this.aJp);
        return jSONObject;
    }
}
