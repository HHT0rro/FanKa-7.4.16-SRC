package com.huawei.flexiblelayout.css;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.log.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSDefinition {
    public static final String INLINE_LINK = "_inline_link_";
    public static final String PAGE_LINK = "_page_link_";

    /* renamed from: f, reason: collision with root package name */
    private static final String f27943f = "CSSDefinition";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, CSSLink> f27944a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, CSSLink> f27945b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, CSSLink> f27946c = new ArrayMap();

    /* renamed from: d, reason: collision with root package name */
    private int f27947d;

    /* renamed from: e, reason: collision with root package name */
    private int f27948e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements ComponentCallbacks {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration configuration) {
            CSSDefinition.this.f27947d = configuration.densityDpi;
            CSSDefinition.this.f27948e = configuration.screenWidthDp;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public CSSDefinition(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f27947d = displayMetrics.densityDpi;
        this.f27948e = Math.round(displayMetrics.widthPixels / displayMetrics.density);
        context.registerComponentCallbacks(new a());
    }

    @Deprecated
    public static CSSDefinition parse(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        CSSDefinition cSSDefinition = new CSSDefinition(com.huawei.flexiblelayout.css.a.b().a());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                c.a(next, optJSONObject, cSSDefinition);
            }
        }
        return cSSDefinition;
    }

    public CSSLink getLink(String str) {
        CSSLink cSSLink = this.f27944a.get(str);
        CSSLink a10 = a(str, this.f27948e, this.f27947d);
        if (a10 == null) {
            return cSSLink;
        }
        if (cSSLink == null) {
            return a10;
        }
        CSSLink.a aVar = new CSSLink.a();
        aVar.a(cSSLink);
        aVar.a(a10);
        return aVar.a();
    }

    public void a(String str, CSSLink cSSLink) {
        this.f27944a.put(str, cSSLink);
    }

    public void a(String str, String str2, CSSLink cSSLink) {
        Integer c4 = d.c(str2);
        if (c4 != null) {
            String str3 = str + "-" + c4.toString();
            cSSLink.a(str3);
            this.f27946c.put(str3, cSSLink);
            return;
        }
        Integer b4 = d.b(str2);
        if (b4 != null) {
            String str4 = str + "-" + b4.toString();
            cSSLink.a(str4);
            this.f27945b.put(str4, cSSLink);
        }
    }

    private CSSLink a(String str, int i10, int i11) {
        for (Map.Entry<Integer, CSSLink> entry : a(str, this.f27946c).entrySet()) {
            if (i10 >= entry.getKey().intValue()) {
                return entry.getValue();
            }
        }
        for (Map.Entry<Integer, CSSLink> entry2 : a(str, this.f27945b).entrySet()) {
            if (i11 >= entry2.getKey().intValue()) {
                return entry2.getValue();
            }
        }
        return null;
    }

    @NonNull
    private Map<Integer, CSSLink> a(String str, Map<String, CSSLink> map) {
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        String str2 = str + "-";
        for (Map.Entry<String, CSSLink> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str2)) {
                try {
                    Integer valueOf = Integer.valueOf(key.substring(str2.length()));
                    if (valueOf != null) {
                        treeMap.put(valueOf, entry.getValue());
                    }
                } catch (Exception e2) {
                    Log.w(f27943f, "getLinkMap, e: " + e2.getMessage());
                }
            }
        }
        return treeMap;
    }
}
