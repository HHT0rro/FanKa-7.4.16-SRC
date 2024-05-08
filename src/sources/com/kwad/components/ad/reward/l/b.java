package com.kwad.components.ad.reward.l;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean xC = false;
    public String xD;
    public String xE;

    private boolean jw() {
        return this.xC;
    }

    private void jx() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.xC));
    }

    public boolean isCompleted() {
        return jw();
    }

    public final void js() {
        if (this.xC) {
            return;
        }
        this.xC = true;
        jx();
    }

    public final void jt() {
        if (this.xC) {
            this.xC = false;
            jx();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String ju() {
        return this.xD;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String jv() {
        return this.xE;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xC = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "selfCompleted", this.xC);
        return jSONObject;
    }
}
