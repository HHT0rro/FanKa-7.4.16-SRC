package b9;

import com.baidu.mobads.sdk.internal.ck;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j implements a9.c {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f1451a;

    public j(InputStream inputStream, String str) {
        this.f1451a = a(inputStream);
        b(str);
    }

    public final JSONObject a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new JSONObject(b.g(inputStream, "UTF-8"));
            } catch (IOException | JSONException unused) {
            }
        }
        return new JSONObject();
    }

    public final void b(String str) {
        try {
            JSONObject d10 = d(str);
            if (d10 == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal(ck.f10046d);
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f1451a.getJSONObject("client").put("app_id", d10.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> keys = d10.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!"package_name".equals(next)) {
                        c(next, d10.get(next), this.f1451a);
                    }
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public final void c(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    public final JSONObject d(String str) throws JSONException {
        JSONArray jSONArray = this.f1451a.getJSONArray("appInfos");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // a9.c
    public String getString(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f1451a;
            for (int i10 = 1; i10 < split.length; i10++) {
                if (i10 == split.length - 1) {
                    str = jSONObject.get(split[i10]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i10]);
            }
        } catch (JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JSONException when reading 'path': ");
            sb2.append(str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f1451a.toString().hashCode() + '}';
    }
}
