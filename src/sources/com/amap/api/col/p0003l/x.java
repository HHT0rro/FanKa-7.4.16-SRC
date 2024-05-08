package com.amap.api.col.p0003l;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: FeatureManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Boolean> f6967a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f6968b;

    /* compiled from: FeatureManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static x f6969a = new x(0);
    }

    public /* synthetic */ x(byte b4) {
        this();
    }

    public static x a() {
        return a.f6969a;
    }

    private void c() {
        this.f6967a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> map = this.f6967a;
        Boolean bool = Boolean.FALSE;
        map.put("feature_gltf", bool);
        this.f6967a.put("feature_terrain", bool);
    }

    public final boolean b() {
        return this.f6968b.get();
    }

    private x() {
        this.f6967a = new ConcurrentHashMap();
        this.f6968b = new AtomicBoolean(false);
        c();
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mvt_able");
        fk.a(optString, true);
        this.f6967a.put("feature_mvt", Boolean.valueOf(fk.a(optString, true)));
        this.f6967a.put("feature_gltf", Boolean.valueOf(fk.a(jSONObject.optString("gltf_able"), false)));
        this.f6967a.put("feature_terrain", Boolean.valueOf(fk.a(jSONObject.optString("terrain_able"), false)));
        this.f6968b.set(true);
    }

    public final boolean a(String str) {
        if (this.f6967a.containsKey(str)) {
            return this.f6967a.get(str).booleanValue();
        }
        return false;
    }
}
