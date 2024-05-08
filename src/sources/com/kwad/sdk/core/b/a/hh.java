package com.kwad.sdk.core.b.a;

import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hh implements com.kwad.sdk.core.d<PageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PageInfo pageInfo, JSONObject jSONObject) {
        a2(pageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        return b2(pageInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt(MaintKey.PAGE_TYPE);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = pageInfo.pageType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MaintKey.PAGE_TYPE, i10);
        }
        return jSONObject;
    }
}
