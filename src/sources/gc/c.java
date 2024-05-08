package gc;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends d {

    /* renamed from: h, reason: collision with root package name */
    public int f49445h;

    /* renamed from: i, reason: collision with root package name */
    public long f49446i = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f49447j = -1;

    public static c e() {
        return new c();
    }

    @Override // gc.d
    public JSONObject c() {
        try {
            JSONObject c4 = super.c();
            if (c4 == null) {
                return null;
            }
            c4.put("code", this.f49445h);
            c4.put("perfCounts", this.f49446i);
            c4.put("perfLatencies", this.f49447j);
            return c4;
        } catch (JSONException e2) {
            fc.c.k(e2);
            return null;
        }
    }

    @Override // gc.d
    public String d() {
        return super.d();
    }
}
