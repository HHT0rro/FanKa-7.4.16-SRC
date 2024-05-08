package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f30032a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f30033b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f30034c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f30032a = grsBaseInfo;
        this.f30033b = context;
    }

    private String e() {
        Set<String> b4 = com.huawei.hms.framework.network.grs.f.b.a(this.f30033b.getPackageName()).b();
        if (b4.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> iterator2 = b4.iterator2();
        while (iterator2.hasNext()) {
            jSONArray.put(iterator2.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.d("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> iterator2 = this.f30034c.iterator2();
        while (iterator2.hasNext()) {
            jSONArray.put(iterator2.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f30033b;
    }

    public void a(String str) {
        this.f30034c.add(str);
    }

    public GrsBaseInfo b() {
        return this.f30032a;
    }

    public String c() {
        return this.f30034c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f30034c;
    }
}
