package com.kwad.sdk.core.b.a;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kt implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt(Attributes.Style.BORDER_RADIUS);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = videoPosition.leftMarginRation;
        if (d10 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMarginRation", d10);
        }
        double d11 = videoPosition.topMarginRation;
        if (d11 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topMarginRation", d11);
        }
        double d12 = videoPosition.widthRation;
        if (d12 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "widthRation", d12);
        }
        double d13 = videoPosition.heightWidthRation;
        if (d13 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "heightWidthRation", d13);
        }
        int i10 = videoPosition.leftMargin;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", i10);
        }
        int i11 = videoPosition.topMargin;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topMargin", i11);
        }
        int i12 = videoPosition.width;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i12);
        }
        int i13 = videoPosition.height;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i13);
        }
        int i14 = videoPosition.borderRadius;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Attributes.Style.BORDER_RADIUS, i14);
        }
        return jSONObject;
    }
}
