package rc;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdMonitorExtraParams.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f extends JSONObject {

    /* compiled from: AdMonitorExtraParams.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f53382a;

        /* renamed from: b, reason: collision with root package name */
        public JSONObject f53383b;

        /* renamed from: c, reason: collision with root package name */
        public String f53384c;

        /* renamed from: d, reason: collision with root package name */
        public String f53385d;

        public a b(String str) {
            this.f53384c = str;
            return this;
        }

        public a c(JSONObject jSONObject) {
            this.f53382a = jSONObject;
            return this;
        }

        public f d() {
            return new f(this);
        }

        public a f(String str) {
            this.f53385d = str;
            return this;
        }
    }

    public f(a aVar) {
        try {
            put(ExposeManager.UtArgsNames.pid, aVar.f53385d);
            put("nameSpace", aVar.f53384c);
            put("macroArgs", aVar.f53383b);
            put("utArgs", aVar.f53382a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject a() {
        return optJSONObject("utArgs");
    }

    public JSONObject b() {
        return optJSONObject("macroArgs");
    }

    public f(String str) throws JSONException {
        super(str);
    }
}
