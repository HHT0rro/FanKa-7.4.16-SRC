package com.kwad.sdk.core.b.a;

import com.huawei.openalliance.ad.constant.bg;
import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ix implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        a2(spikeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return b2(spikeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong(bg.e.f32291h);
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = spikeInfo.endTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, bg.e.f32291h, j10);
        }
        int i10 = spikeInfo.soldStock;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "soldStock", i10);
        }
        int i11 = spikeInfo.originalStock;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalStock", i11);
        }
        return jSONObject;
    }
}
