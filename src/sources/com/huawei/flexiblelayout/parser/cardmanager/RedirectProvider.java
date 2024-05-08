package com.huawei.flexiblelayout.parser.cardmanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.CardProvider;
import com.huawei.flexiblelayout.parser.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RedirectProvider implements CardProvider {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28322d = "RedirectProvider";

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f28323a;

    /* renamed from: c, reason: collision with root package name */
    private final Object f28325c = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f28324b = new HashMap();

    public RedirectProvider(@NonNull FLEngine fLEngine) {
        this.f28323a = fLEngine;
    }

    private void a(@NonNull String str, @NonNull String str2) {
        synchronized (this.f28325c) {
            this.f28324b.put(str, str2);
        }
    }

    public static RedirectProvider create(FLEngine fLEngine) {
        return new RedirectProvider(fLEngine);
    }

    public RedirectProvider addFromJSONObject(@NonNull JSONObject jSONObject) throws ParseException {
        JSONArray optJSONArray;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONArray = jSONObject.optJSONArray(next)) != null) {
                int length = optJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    String optString = optJSONArray.optString(i10);
                    if (!TextUtils.isEmpty(optString)) {
                        a(optString, next);
                    }
                }
            }
        }
        return this;
    }

    public RedirectProvider addFromString(@NonNull String str) throws ParseException {
        try {
            addFromJSONObject(new JSONObject(str));
            return this;
        } catch (JSONException e2) {
            Log.e(f28322d, "Failed to new JSONArray from the 'redirects'.");
            throw new ParseException("Failed to new JSONArray from the 'redirects'.", e2);
        }
    }

    @Nullable
    public String redirect(@NonNull String str) {
        String str2;
        synchronized (this.f28325c) {
            str2 = this.f28324b.get(str);
        }
        return str2;
    }

    @Override // com.huawei.flexiblelayout.parser.CardProvider
    @NonNull
    public String[] schemes() {
        return new String[0];
    }
}
