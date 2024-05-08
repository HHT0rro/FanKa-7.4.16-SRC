package e9;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.api.AdsContext;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataResponseBean;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final AdSlot f48942a;

    /* renamed from: b, reason: collision with root package name */
    public final a f48943b;

    /* renamed from: c, reason: collision with root package name */
    public final int f48944c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        void onFail(int i10, String str);

        void onLoadSuccess(@NonNull List<JSONArray> list);
    }

    public d(@NonNull AdSlot adSlot, @NonNull a aVar, @NonNull AdsContext adsContext, @NonNull int i10) {
        this.f48942a = adSlot;
        this.f48943b = aVar;
        this.f48944c = i10;
    }

    public final int a(JSONObject jSONObject) {
        if (!jSONObject.has(CardConstants.KEY_REFS_APP)) {
            return 0;
        }
        try {
            return jSONObject.getJSONObject(CardConstants.KEY_REFS_APP).optInt("ctype");
        } catch (JSONException unused) {
            e.f48945d.e("AdDataLoader", "getCtype failed:JSONException");
            return 0;
        }
    }

    public final void b(@NonNull CardDataResponseBean cardDataResponseBean) {
        Pair create;
        e eVar = e.f48945d;
        StringBuilder b4 = e9.a.b("handleAdResponse: rtnCode: ");
        b4.append(cardDataResponseBean.getRtnCode_());
        b4.append(", responseCode: ");
        b4.append(cardDataResponseBean.getResponseCode());
        b4.append(" rtnDesc: ");
        b4.append(cardDataResponseBean.getRtnDesc());
        eVar.i("AdDataLoader", b4.toString());
        StringBuilder b10 = e9.a.b("handleAdResponse client.queryCardDataV2 originData: ");
        b10.append(cardDataResponseBean.getOriginalData());
        eVar.d("AdDataLoader", b10.toString());
        if (cardDataResponseBean.getResponseCode() != 0) {
            StringBuilder b11 = e9.a.b("response code ");
            b11.append(cardDataResponseBean.getResponseCode());
            create = Pair.create(2005, b11.toString());
        } else if (cardDataResponseBean.getRtnCode_() != 0) {
            StringBuilder b12 = e9.a.b("rtn code ");
            b12.append(cardDataResponseBean.getRtnCode_());
            create = Pair.create(2006, b12.toString());
        } else {
            String originalData = cardDataResponseBean.getOriginalData();
            if (TextUtils.isEmpty(originalData)) {
                create = Pair.create(2007, "originalData empty");
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray optJSONArray = new JSONObject(originalData).optJSONArray(CardConstants.KEY_APP_LAYOUT_DATA);
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                            JSONObject jSONObject = optJSONArray.getJSONObject(i10);
                            JSONArray jSONArray = jSONObject.getJSONArray(CardConstants.KEY_DATA_LIST);
                            jSONObject.remove(CardConstants.KEY_DATA_LIST);
                            if (jSONObject.has("quickCard")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("quickCard");
                                String string = jSONObject2.getString("url");
                                jSONObject.put(CardConstants.KEY_QUICK_URI, string);
                                jSONObject.put("layoutName", jSONObject2.getString(CardConstants.KEY_QUICK_CARD_ID));
                                if (!TextUtils.isEmpty(string) && string.startsWith(CardConstants.KEY_FAST_VIEW)) {
                                    jSONObject.put("layoutName", CardConstants.VALUE_QLAYOUT);
                                }
                            }
                            Context context = ApplicationWrapper.getInstance().getContext();
                            JSONArray jSONArray2 = new JSONArray();
                            JSONArray jSONArray3 = new JSONArray();
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i11);
                                if (c(context, jSONObject3)) {
                                    e.f48945d.i("AdDataLoader", "filter ad");
                                } else {
                                    jSONArray3.put(jSONObject3);
                                }
                            }
                            if (jSONArray3.length() != 0) {
                                JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                                jSONObject4.put(CardConstants.KEY_DATA_LIST, jSONArray3);
                                jSONArray2.put(jSONObject4);
                                arrayList.add(jSONArray2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            this.f48943b.onLoadSuccess(arrayList);
                            create = Pair.create(0, "request template card data success");
                        } else {
                            create = Pair.create(2014, "no valid ad");
                        }
                    }
                    create = Pair.create(2007, "layoutData empty");
                } catch (JSONException unused) {
                    create = Pair.create(2008, "JSONException");
                }
            }
        }
        if (((Integer) create.first).intValue() != 0) {
            e eVar2 = e.f48945d;
            StringBuilder b13 = e9.a.b("resolveOriginalData fail: ");
            b13.append(create.first);
            b13.append(", msg: ");
            e9.a.d(b13, (String) create.second, eVar2, "AdDataLoader");
            this.f48943b.onFail(((Integer) create.first).intValue(), (String) create.second);
            OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_LOAD_FAILURE, this.f48942a.getSlotId());
            return;
        }
        OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_LOAD_SUCCESS, this.f48942a.getSlotId());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(@androidx.annotation.NonNull android.content.Context r18, org.json.JSONObject r19) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.d.c(android.content.Context, org.json.JSONObject):boolean");
    }

    public final Integer d(JSONObject jSONObject) {
        if (jSONObject.has("interactType")) {
            return Integer.valueOf(jSONObject.optInt("interactType"));
        }
        return null;
    }

    public final String e(JSONObject jSONObject) {
        if (!jSONObject.has(CardConstants.KEY_REFS_APP)) {
            return "";
        }
        try {
            return jSONObject.getJSONObject(CardConstants.KEY_REFS_APP).optString("packageName");
        } catch (JSONException unused) {
            e.f48945d.e("AdDataLoader", "getPackageName failed:JSONException");
            return "";
        }
    }
}
