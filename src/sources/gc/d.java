package gc;

import com.huawei.openalliance.ad.constant.bg;
import com.vivo.push.PushClientConstants;
import com.xiaomi.push.g7;
import com.xiaomi.push.t0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f49448a;

    /* renamed from: b, reason: collision with root package name */
    public String f49449b;

    /* renamed from: c, reason: collision with root package name */
    public int f49450c;

    /* renamed from: d, reason: collision with root package name */
    public String f49451d = t0.a();

    /* renamed from: e, reason: collision with root package name */
    public String f49452e = g7.c();

    /* renamed from: f, reason: collision with root package name */
    public String f49453f;

    /* renamed from: g, reason: collision with root package name */
    public String f49454g;

    public void a(String str) {
        this.f49453f = str;
    }

    public void b(String str) {
        this.f49454g = str;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.f49448a);
            jSONObject.put("reportType", this.f49450c);
            jSONObject.put("clientInterfaceId", this.f49449b);
            jSONObject.put("os", this.f49451d);
            jSONObject.put("miuiVersion", this.f49452e);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.f49453f);
            jSONObject.put(bg.e.Code, this.f49454g);
            return jSONObject;
        } catch (JSONException e2) {
            fc.c.k(e2);
            return null;
        }
    }

    public String d() {
        JSONObject c4 = c();
        return c4 == null ? "" : c4.toString();
    }
}
