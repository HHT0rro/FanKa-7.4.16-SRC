package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> awM = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> Ea() {
        return this.awM;
    }

    public static b dW(String str) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            c.printStackTraceOnly(e2);
        }
        return bVar;
    }

    @NonNull
    public final Set<String> Eb() {
        return this.awM.h();
    }

    public final void a(b bVar) {
        this.awM.clear();
        if (bVar != null) {
            this.awM.putAll(bVar.Ea());
        }
    }

    @NonNull
    public final List<String> dV(String str) {
        List<String> list = this.awM.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.awM.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, t.h(jSONObject.optJSONArray(next)));
            }
        }
        this.awM.clear();
        this.awM.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.awM;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.h()) {
            t.putValue(jSONObject, str, t.O(map.get(str)));
        }
        return jSONObject;
    }
}
