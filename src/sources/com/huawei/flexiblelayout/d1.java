package com.huawei.flexiblelayout;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.DataItem;
import com.huawei.flexiblelayout.parser.FLDataStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FusionDataParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d1 extends b1 {

    /* renamed from: h, reason: collision with root package name */
    private static final String f28023h = "FusionDataParser";

    public d1(@NonNull FLEngine fLEngine) {
        super(fLEngine);
    }

    private void a(DataItem dataItem, String str, JSONObject jSONObject, @NonNull FLDataStream fLDataStream) {
        JSONArray optJSONArray;
        DataItem b4 = b(dataItem, DataItem.nodeIt(str).setData(Jsons.toJson(jSONObject.opt(b().data()))).setStyle(jSONObject.opt(b().style())));
        if (b4 == null || (optJSONArray = jSONObject.optJSONArray(b().children())) == null) {
            return;
        }
        a(dataItem, b4, optJSONArray, fLDataStream);
    }

    @Override // com.huawei.flexiblelayout.b1
    public void b(JSONObject jSONObject, @NonNull FLDataStream fLDataStream) {
        DataItem a10 = a(jSONObject, fLDataStream);
        if (a10 == null) {
            return;
        }
        String b4 = b(jSONObject);
        if (!TextUtils.isEmpty(b4)) {
            a(a10, b4, jSONObject, fLDataStream);
            return;
        }
        String a11 = a(jSONObject);
        if (!TextUtils.isEmpty(a11)) {
            a(a10, a11, jSONObject);
            return;
        }
        fLDataStream.setResult(2);
        Log.w(f28023h, "Ignore, Failed to load node or card, type: " + jSONObject.optString(b().type()) + ".");
    }

    private void a(DataItem dataItem, DataItem dataItem2, JSONArray jSONArray, @NonNull FLDataStream fLDataStream) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                a(dataItem2, optJSONObject, fLDataStream);
            }
        }
        if (dataItem2.getChildList().isEmpty()) {
            return;
        }
        dataItem.addChild(dataItem2);
    }

    private void a(DataItem dataItem, JSONObject jSONObject, @NonNull FLDataStream fLDataStream) {
        String b4 = b(jSONObject);
        if (!TextUtils.isEmpty(b4)) {
            a(dataItem, b4, jSONObject, fLDataStream);
            return;
        }
        String a10 = a(jSONObject);
        if (!TextUtils.isEmpty(a10)) {
            b(dataItem, a10, jSONObject);
            return;
        }
        fLDataStream.setResult(2);
        Log.w(f28023h, "Ignore, Failed to load node or card, type: " + jSONObject.optString(b().type()) + ".");
    }

    public String b(JSONObject jSONObject) {
        String optString = jSONObject.optString(b().type(), "");
        return (!TextUtils.isEmpty(optString) && FLResolverRegistry.isDefinedNode(optString)) ? optString : "";
    }

    private void b(DataItem dataItem, String str, JSONObject jSONObject) {
        Object opt = jSONObject.opt(b().data());
        DataItem style = DataItem.cardIt(str).setData(Jsons.toJson(opt)).setStyle(jSONObject.opt(b().style()));
        if (style == null || style.getType() == null || !FLResolverRegistry.isDefinedCard(style.getType())) {
            return;
        }
        dataItem.addChild(style);
    }
}
