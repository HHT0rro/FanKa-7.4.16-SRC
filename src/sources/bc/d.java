package bc;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public Context f1466b;

    /* renamed from: c, reason: collision with root package name */
    public String f1467c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f1468d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f1469e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f1470f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f1471g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f1472h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f1473i = "";

    /* renamed from: j, reason: collision with root package name */
    public HashMap<String, String> f1474j = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f1475k = false;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f1476l = false;

    public String a(boolean z10) {
        if (z10) {
            return s(this.f1467c);
        }
        return this.f1467c;
    }

    public Context c() {
        return this.f1466b;
    }

    public Object clone() {
        try {
            d dVar = (d) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : dVar.f1474j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            dVar.f1474j = hashMap;
            return dVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String d(boolean z10) {
        if (this.f1474j.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.f1474j.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
                return "";
            }
        }
        if (z10) {
            return s(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String e(boolean z10) {
        if (z10) {
            return s(this.f1469e);
        }
        return this.f1469e;
    }

    public synchronized boolean g() {
        return this.f1476l;
    }

    public String h(boolean z10) {
        if (z10) {
            return s(this.f1471g);
        }
        return this.f1471g;
    }

    public String i(boolean z10) {
        if (z10) {
            return s(this.f1468d);
        }
        return this.f1468d;
    }

    public String j(boolean z10) {
        if (z10) {
            return s(this.f1472h);
        }
        return this.f1472h;
    }

    public synchronized boolean k() {
        return this.f1475k;
    }

    public String l(boolean z10) {
        if (z10) {
            return s(this.f1470f);
        }
        return this.f1470f;
    }

    public void m(String str) {
        this.f1467c = str;
    }

    public void n(Context context) {
        this.f1466b = context.getApplicationContext();
    }

    public void o(String str) {
        this.f1469e = str;
    }

    public synchronized void p(boolean z10) {
        this.f1476l = z10;
    }

    public synchronized void q(boolean z10) {
        this.f1475k = z10;
    }

    public void r(String str) {
        this.f1470f = str;
    }

    public final String s(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public boolean t() {
        return (this.f1466b == null || TextUtils.isEmpty(this.f1467c) || TextUtils.isEmpty(this.f1469e) || TextUtils.isEmpty(this.f1470f)) ? false : true;
    }
}
