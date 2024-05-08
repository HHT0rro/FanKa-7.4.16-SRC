package com.huawei.quickcard;

import com.huawei.quickcard.framework.value.QuickCardValue;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class z0 {

    /* renamed from: c, reason: collision with root package name */
    private static final String f34756c = "normal";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, QuickCardValue>> f34757a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f34758b = new HashMap();

    public void a(String str, String str2, QuickCardValue quickCardValue) {
        Map<String, QuickCardValue> map = this.f34757a.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.f34757a.put(str, map);
        }
        map.put(str2, quickCardValue);
        if ("normal".equals(str)) {
            return;
        }
        this.f34758b.put(str, Boolean.FALSE);
        Map<String, QuickCardValue> map2 = this.f34757a.get("normal");
        if (map2 == null) {
            map2 = new HashMap<>();
            this.f34757a.put("normal", map2);
        }
        if (map2.containsKey(str2)) {
            return;
        }
        map2.put(str2, QuickCardValue.EMPTY);
    }

    public Map<String, Boolean> b() {
        return this.f34758b;
    }

    public Map<String, QuickCardValue> a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Boolean> entry : this.f34758b.entrySet()) {
            Boolean value = entry.getValue();
            if (value != null) {
                Map<String, QuickCardValue> map = this.f34757a.get(entry.getKey());
                if (map != null && !map.isEmpty()) {
                    if (value.booleanValue()) {
                        hashMap.putAll(map);
                    } else {
                        Map<String, QuickCardValue> map2 = this.f34757a.get("normal");
                        for (String str : map.h()) {
                            if (hashMap.get(str) == 0) {
                                QuickCardValue quickCardValue = map2 != null ? map2.get(str) : null;
                                if (quickCardValue == null) {
                                    quickCardValue = QuickCardValue.EMPTY;
                                }
                                hashMap.put(str, quickCardValue);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public Map<String, QuickCardValue> a(String str, boolean z10) {
        this.f34758b.put(str, Boolean.valueOf(z10));
        Map<String, QuickCardValue> map = this.f34757a.get(str);
        if (z10) {
            return map;
        }
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Map<String, QuickCardValue> map2 = this.f34757a.get("normal");
        for (String str2 : map.h()) {
            QuickCardValue quickCardValue = map2.get(str2);
            if (quickCardValue == null) {
                quickCardValue = QuickCardValue.EMPTY;
            }
            hashMap.put(str2, quickCardValue);
        }
        return hashMap;
    }

    public Map<String, QuickCardValue> a(String str) {
        return this.f34757a.get(str);
    }
}
