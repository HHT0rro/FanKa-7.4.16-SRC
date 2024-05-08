package b9;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i implements a9.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1448a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1449b;

    /* renamed from: c, reason: collision with root package name */
    public a9.d f1450c;

    public i(Context context, String str) {
        this.f1448a = context;
        this.f1449b = str;
    }

    public a9.d a() {
        String b4 = m.b(this.f1448a, this.f1449b, "agc_plugin_", "crypto_component");
        if (b4 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(a.b(b4), "utf-8"));
            return new g(new e(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FlexibleDecrypt exception: ");
            sb2.append(e2.getMessage());
            return null;
        }
    }

    @Override // a9.b
    public String decrypt(String str, String str2) {
        if (this.f1450c == null) {
            this.f1450c = a();
        }
        if (this.f1450c == null) {
            this.f1450c = new h(this.f1448a, this.f1449b).a();
        }
        return this.f1450c.decrypt(m.b(this.f1448a, this.f1449b, "agc_plugin_", str), str2);
    }
}
