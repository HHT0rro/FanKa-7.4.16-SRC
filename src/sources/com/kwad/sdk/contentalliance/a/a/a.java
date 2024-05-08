package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.android.internal.org.bouncycastle.cms.CMSAttributeTableGenerator;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    @NonNull
    public static a bD(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, l.em(adTemplate));
    }

    public final String Ba() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CMSAttributeTableGenerator.CONTENT_TYPE, this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e2) {
            c.printStackTrace(e2);
        }
        return jSONObject.toString();
    }

    public a(@NonNull AdTemplate adTemplate, long j10) {
        this.clickTime = -1L;
        this.photoId = e.dW(adTemplate);
        this.clickTime = j10;
        this.adStyle = e.dL(adTemplate);
        this.contentType = e.dM(adTemplate);
    }
}
