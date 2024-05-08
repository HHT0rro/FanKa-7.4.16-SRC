package ac;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public p f800a = null;

    public final void a(int i10, String str) {
        b(i10, str, "", "");
    }

    public final void b(int i10, String str, String str2, String str3) {
        try {
            if (this.f800a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i10);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", str2);
            jSONObject.put("seq", str3);
            this.f800a.onResult(jSONObject.toString());
            this.f800a = null;
            if (i10 < 0) {
                g.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
