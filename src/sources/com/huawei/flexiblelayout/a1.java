package com.huawei.flexiblelayout;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.CardProvider;
import com.huawei.flexiblelayout.parser.DataItem;
import com.huawei.flexiblelayout.parser.DataKeys;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import com.huawei.flexiblelayout.parser.cardmanager.LocalCardProvider;
import com.huawei.flexiblelayout.parser.cardmanager.RedirectProvider;
import com.huawei.flexiblelayout.parser.utils.UriUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DataParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a1 extends b1 {

    /* renamed from: i, reason: collision with root package name */
    private static final String f27713i = "DataParser";

    /* renamed from: h, reason: collision with root package name */
    private final a f27714h;

    /* compiled from: DataParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements com.huawei.flexiblelayout.parser.cardmanager.a {

        /* renamed from: a, reason: collision with root package name */
        private final FLEngine f27715a;

        /* renamed from: b, reason: collision with root package name */
        private final List<CardProvider> f27716b = new ArrayList();

        public a(@NonNull FLEngine fLEngine) {
            this.f27715a = fLEngine;
        }

        public void a(List<CardProvider> list) {
            if (list != null) {
                this.f27716b.addAll(list);
            }
        }

        public String b(@NonNull String str) {
            String scheme = UriUtils.getScheme(str);
            for (CardProvider cardProvider : this.f27716b) {
                if (a(cardProvider.schemes(), scheme) && (cardProvider instanceof RedirectProvider)) {
                    String redirect = ((RedirectProvider) cardProvider).redirect(str);
                    if (!TextUtils.isEmpty(redirect)) {
                        return redirect;
                    }
                }
            }
            return str;
        }

        @Override // com.huawei.flexiblelayout.parser.cardmanager.a
        public CardInfo loadCard(@NonNull String str, @NonNull String str2) {
            if (TextUtils.isEmpty(str2)) {
                return a(str);
            }
            String b4 = b(str2);
            CardInfo build = CardInfo.Builder.fromUri(b4).setName(str).build();
            if (build.isCombo()) {
                return FLResolverRegistry.isDefinedNodeSpec(build.getQualifiedName()) ? build : a(str, b4, true);
            }
            a(str, b4, false);
            if (FLResolverRegistry.isDefinedNodeSpec(str)) {
                return new CardInfo.Builder().setName(str).setType("combo").build();
            }
            return null;
        }

        public CardInfo a(@NonNull String str, @NonNull String str2, boolean z10) {
            String scheme = UriUtils.getScheme(str2);
            for (CardProvider cardProvider : this.f27716b) {
                if (a(cardProvider.schemes(), scheme) && (cardProvider instanceof CardProvider.ICloudCardProvider)) {
                    if (z10) {
                        CardInfo loadCard = ((CardProvider.ICloudCardProvider) cardProvider).loadCard(str, str2);
                        if (loadCard != null) {
                            try {
                                LocalCardProvider.getInstance(this.f27715a).add(loadCard.getQualifiedName(), loadCard.getContent());
                                return loadCard;
                            } catch (ParseException unused) {
                                Log.e(a1.f27713i, "ParserException when parsing combo-layouts.");
                                return loadCard;
                            }
                        }
                    } else {
                        ((CardProvider.ICloudCardProvider) cardProvider).loadCard("", str2, null);
                    }
                }
            }
            return null;
        }

        public CardInfo a(@NonNull String str) {
            return LocalCardProvider.getInstance(this.f27715a).loadCard(str);
        }

        public boolean a(String[] strArr, String str) {
            if (strArr.length == 0) {
                return true;
            }
            for (String str2 : strArr) {
                if (Objects.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public a1(FLEngine fLEngine) {
        super(fLEngine);
        this.f27714h = new a(fLEngine);
    }

    public void b(List<CardProvider> list) {
        if (list != null) {
            this.f27714h.a(list);
        }
    }

    public String c(JSONObject jSONObject) {
        String optString = jSONObject.optString(b().type());
        String optString2 = jSONObject.optString(DataKeys.subType());
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return "";
        }
        String str = optString + "#" + optString2;
        return FLResolverRegistry.isDefinedNodeSpec(str) ? str : "";
    }

    @Override // com.huawei.flexiblelayout.b1
    public void b(JSONObject jSONObject, @NonNull FLDataStream fLDataStream) {
        DataItem a10 = a(jSONObject, fLDataStream);
        if (a10 == null) {
            return;
        }
        String a11 = a(jSONObject);
        if (!TextUtils.isEmpty(a11)) {
            a(a10, a11, jSONObject);
            return;
        }
        String c4 = c(jSONObject);
        if (!TextUtils.isEmpty(c4)) {
            b(a10, c4, jSONObject);
            return;
        }
        String b4 = b(jSONObject);
        if (!TextUtils.isEmpty(b4)) {
            b(a10, b4, jSONObject);
            return;
        }
        fLDataStream.setResult(2);
        Log.w(f27713i, "Ignore, Failed to load combo-layout, type: " + jSONObject.optString(b().type()) + ", subType: " + jSONObject.optString(DataKeys.subType()) + ", uri: " + jSONObject.optString(b().uri()) + ".");
    }

    public String b(JSONObject jSONObject) {
        String optString = jSONObject.optString(b().type());
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        CardInfo loadCard = this.f27714h.loadCard(optString, jSONObject.optString(b().uri()));
        return loadCard != null ? loadCard.getQualifiedName() : "";
    }

    private void b(DataItem dataItem, String str, JSONObject jSONObject) {
        Object opt = jSONObject.opt(b().data());
        if (opt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) opt;
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                DataItem b4 = b(dataItem, DataItem.comboIt(str).setData(Jsons.toJson(jSONArray.opt(i10))));
                if (b4 != null) {
                    dataItem.addChild(b4);
                }
            }
            return;
        }
        if (opt instanceof JSONObject) {
            DataItem b10 = b(dataItem, DataItem.comboIt(str).setData(Jsons.toJson((JSONObject) opt)));
            if (b10 != null) {
                dataItem.addChild(b10);
                return;
            }
            return;
        }
        Log.w(f27713i, "Ignore, Not found data for combo: " + str + ".");
    }
}
