package com.kwad.sdk.core.b.a;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;
import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fu implements com.kwad.sdk.core.d<KGeoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        a2(kGeoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        return b2(kGeoInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble(com.huawei.openalliance.ad.constant.as.at);
        kGeoInfo.longitude = jSONObject.optDouble(com.huawei.openalliance.ad.constant.as.au);
        kGeoInfo.range = jSONObject.optInt(Attributes.Style.RANGE);
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = kGeoInfo.latitude;
        if (d10 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.constant.as.at, d10);
        }
        double d11 = kGeoInfo.longitude;
        if (d11 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.constant.as.au, d11);
        }
        int i10 = kGeoInfo.range;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Attributes.Style.RANGE, i10);
        }
        int i11 = kGeoInfo.rate;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate", i11);
        }
        return jSONObject;
    }
}
