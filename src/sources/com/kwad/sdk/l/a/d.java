package com.kwad.sdk.l.a;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends com.kwad.sdk.core.response.a.a {
    public int aMV = 0;
    public int aMW = 0;
    public int aMX = 0;
    public int aMY = 0;
    public int aMZ = 0;
    public int aNa = 0;
    public int aNb = 0;

    public d(Context context) {
        if (context != null) {
            bM(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aMV = jSONObject.optInt("isRoot");
        dVar.aMW = jSONObject.optInt("isXPosed");
        dVar.aMX = jSONObject.optInt("isFrameworkHooked");
        dVar.aMY = jSONObject.optInt("isVirtual");
        dVar.aMZ = jSONObject.optInt("isAdbEnabled");
        dVar.aNa = jSONObject.optInt("isEmulator");
        dVar.aNb = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "isRoot", dVar.aMV);
        t.putValue(jSONObject, "isXPosed", dVar.aMW);
        t.putValue(jSONObject, "isFrameworkHooked", dVar.aMX);
        t.putValue(jSONObject, "isVirtual", dVar.aMY);
        t.putValue(jSONObject, "isAdbEnabled", dVar.aMZ);
        t.putValue(jSONObject, "isEmulator", dVar.aNa);
        t.putValue(jSONObject, "isGroupControl", dVar.aNb);
        return jSONObject;
    }

    private void bM(boolean z10) {
        this.aMZ = bP(z10);
    }

    private static int bP(boolean z10) {
        return z10 ? 1 : 2;
    }

    public final void bJ(boolean z10) {
        this.aMV = bP(z10);
    }

    public final void bK(boolean z10) {
        this.aMW = bP(z10);
    }

    public final void bL(boolean z10) {
        this.aMX = bP(z10);
    }

    public final void bN(boolean z10) {
        this.aNa = bP(z10);
    }

    public final void bO(boolean z10) {
        this.aNb = bP(z10);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b4 = b(this, new JSONObject());
        afterToJson(b4);
        return b4;
    }
}
