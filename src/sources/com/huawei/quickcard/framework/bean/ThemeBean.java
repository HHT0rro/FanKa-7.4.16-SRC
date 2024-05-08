package com.huawei.quickcard.framework.bean;

import android.view.View;
import com.huawei.quickcard.b2;
import com.huawei.quickcard.framework.value.QuickCardValue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ThemeBean {

    /* renamed from: h, reason: collision with root package name */
    private static final String f33812h = "ThemeBean";

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f33813a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Set<WeakReference<View>>> f33814b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Map<String, Map<String, QuickCardValue>>> f33815c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Map<String, Map<String, Map<String, QuickCardValue>>>> f33816d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Integer, Set<Object>> f33817e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Integer, Map<String, b2>> f33818f;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f33819g;

    public ThemeBean(ThemeBean themeBean) {
        HashSet hashSet = new HashSet();
        this.f33813a = hashSet;
        this.f33814b = new HashMap();
        HashMap hashMap = new HashMap();
        this.f33815c = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f33816d = hashMap2;
        this.f33817e = new HashMap();
        this.f33818f = new HashMap();
        if (themeBean != null) {
            hashSet.addAll(themeBean.getRefs());
            hashMap.putAll(themeBean.getThemeAttrsMap());
            hashMap2.putAll(themeBean.getThemeStylesMap());
            this.f33819g = themeBean.getThemeContent();
        }
    }

    public Set<String> getRefs() {
        return this.f33813a;
    }

    public Map<String, Map<String, Map<String, QuickCardValue>>> getThemeAttrsMap() {
        return this.f33815c;
    }

    public JSONObject getThemeContent() {
        return this.f33819g;
    }

    public Map<String, Map<String, Map<String, Map<String, QuickCardValue>>>> getThemeStylesMap() {
        return this.f33816d;
    }

    public Map<String, Set<WeakReference<View>>> getThemeViewMap() {
        return this.f33814b;
    }

    public Map<Integer, Map<String, b2>> getVirtualViewInfos() {
        return this.f33818f;
    }

    public Map<Integer, Set<Object>> getVirtualViewRefs() {
        return this.f33817e;
    }

    public void resetThemeBean() {
        this.f33814b.clear();
    }

    public void saveView(String str, View view) {
        if (!this.f33813a.isEmpty() && this.f33813a.contains(str)) {
            Set<WeakReference<View>> set = this.f33814b.get(str);
            if (set == null) {
                set = new HashSet<>();
                this.f33814b.put(str, set);
            }
            set.add(new WeakReference<>(view));
        }
    }

    public ThemeBean(JSONObject jSONObject) {
        this.f33813a = new HashSet();
        this.f33814b = new HashMap();
        this.f33815c = new HashMap();
        this.f33816d = new HashMap();
        this.f33817e = new HashMap();
        this.f33818f = new HashMap();
        this.f33819g = jSONObject;
    }
}
