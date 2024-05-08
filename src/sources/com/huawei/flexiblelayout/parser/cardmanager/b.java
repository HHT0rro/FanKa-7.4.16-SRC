package com.huawei.flexiblelayout.parser.cardmanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboCardRegistry.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static final String f28326e = "ComboCardRegistry";

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f28327a;

    /* renamed from: b, reason: collision with root package name */
    private final CardLayoutParser f28328b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, CardInfo> f28329c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Object f28330d = new Object();

    public b(@NonNull FLEngine fLEngine) {
        this.f28327a = fLEngine;
        this.f28328b = new CardLayoutParser(fLEngine);
    }

    public CardInfo a(String str) {
        CardInfo cardInfo;
        synchronized (this.f28330d) {
            cardInfo = this.f28329c.get(str);
        }
        return cardInfo;
    }

    public void b(String str) throws ParseException {
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    a(new JSONObject(str));
                    return;
                } catch (JSONException e2) {
                    Log.e(f28326e, "Failed to new JSONObject or JSONArray from the 'layout'.");
                    throw new ParseException("Failed to new JSONObject or JSONArray from the 'layout'.", e2);
                }
            } catch (JSONException unused) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    a(jSONArray.optJSONObject(i10));
                }
                return;
            }
        }
        Log.e(f28326e, "layout must not be empty.");
        throw new ParseException("layout must not be empty.");
    }

    private void a(JSONObject jSONObject) throws ParseException {
        if (jSONObject != null) {
            this.f28327a.registerNodeSpec(this.f28328b.parseObject(jSONObject));
        }
    }

    public void a(String str, String str2) throws ParseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                a(str, new JSONObject(str2));
                return;
            } catch (JSONException e2) {
                Log.e(f28326e, "Failed to new JSONObject from the 'layout'.");
                throw new ParseException("Failed to new JSONObject from the 'layout'.", e2);
            }
        }
        Log.e(f28326e, "name or layout must not be empty.");
        throw new ParseException("name or layout must not be empty.");
    }

    private void a(@NonNull String str, @NonNull JSONObject jSONObject) throws ParseException {
        FLayoutSpec.FNodeSpec parseObject = this.f28328b.parseObject(jSONObject);
        String[] a10 = c.a(str);
        if (!TextUtils.isEmpty(a10[1])) {
            CardInfo build = CardInfo.Builder.fromUri(a10[1]).setName(a10[0]).setType("combo").build();
            if (str.equals(build.getQualifiedName())) {
                a(build);
            } else {
                Log.w(f28326e, "Incorrect format of name: '" + str + "'.");
            }
        }
        parseObject.name(str);
        this.f28327a.registerNodeSpec(parseObject);
    }

    private void a(CardInfo cardInfo) {
        synchronized (this.f28330d) {
            CardInfo cardInfo2 = this.f28329c.get(cardInfo.getName());
            if (cardInfo2 == null || cardInfo.getVer() > cardInfo2.getVer()) {
                cardInfo.a(null);
                this.f28329c.put(cardInfo.getName(), cardInfo);
            }
        }
    }
}
