package com.kwad.components.core.request.model;

import androidx.annotation.Nullable;
import com.alibaba.security.realidentity.build.aq;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements com.kwad.sdk.core.b {
    public long Sd;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, aq.f3119o, this.photoId);
        t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.Sd);
        return jSONObject;
    }
}
