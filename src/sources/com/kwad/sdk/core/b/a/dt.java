package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class dt implements com.kwad.sdk.core.d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        a2(feedErrorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        return b2(feedErrorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = feedErrorInfo.materialType;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", j10);
        }
        long j11 = feedErrorInfo.width;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", j11);
        }
        long j12 = feedErrorInfo.feedType;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "feed_type", j12);
        }
        return jSONObject;
    }
}
