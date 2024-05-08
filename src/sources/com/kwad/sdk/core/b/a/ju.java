package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ju implements com.kwad.sdk.core.d<TKAdLiveShopItemInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        a2(tKAdLiveShopItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        return b2(tKAdLiveShopItemInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKAdLiveShopItemInfo.itemId = jSONObject.optString("itemId");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.itemId)) {
            tKAdLiveShopItemInfo.itemId = "";
        }
        tKAdLiveShopItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.imageUrl)) {
            tKAdLiveShopItemInfo.imageUrl = "";
        }
        tKAdLiveShopItemInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.title)) {
            tKAdLiveShopItemInfo.title = "";
        }
        tKAdLiveShopItemInfo.price = jSONObject.optString("price");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.price)) {
            tKAdLiveShopItemInfo.price = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = tKAdLiveShopItemInfo.itemId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemId", tKAdLiveShopItemInfo.itemId);
        }
        String str2 = tKAdLiveShopItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imageUrl", tKAdLiveShopItemInfo.imageUrl);
        }
        String str3 = tKAdLiveShopItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", tKAdLiveShopItemInfo.title);
        }
        String str4 = tKAdLiveShopItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "price", tKAdLiveShopItemInfo.price);
        }
        return jSONObject;
    }
}
