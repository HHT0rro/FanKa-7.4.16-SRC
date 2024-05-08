package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ij implements com.kwad.sdk.core.d<AdMatrixInfo.RotateDegreeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        a2(rotateDegreeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        return b2(rotateDegreeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateDegreeInfo.rotateDegree = jSONObject.optInt("rotateDegree");
        rotateDegreeInfo.direction = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = rotateDegreeInfo.rotateDegree;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rotateDegree", i10);
        }
        int i11 = rotateDegreeInfo.direction;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, i11);
        }
        return jSONObject;
    }
}
