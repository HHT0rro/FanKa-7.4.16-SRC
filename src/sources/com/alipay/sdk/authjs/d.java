package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.authjs.a;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private c f4512a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4513b;

    public d(Context context, c cVar) {
        this.f4513b = context;
        this.f4512a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.EnumC0095a b(a aVar) {
        if (aVar != null && "toast".equals(aVar.d())) {
            c(aVar);
        }
        return a.EnumC0095a.NONE_ERROR;
    }

    private void c(a aVar) {
        JSONObject f10 = aVar.f();
        String optString = f10.optString("content");
        int i10 = f10.optInt("duration") < 2500 ? 0 : 1;
        Toast.makeText(this.f4513b, optString, i10).show();
        new Timer().schedule(new f(this, aVar), i10);
    }

    public void a(String str) {
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(a.f4495d);
            try {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("param");
                JSONObject jSONObject3 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                String string2 = jSONObject.getString(a.f4497f);
                String string3 = jSONObject.getString(a.f4494c);
                a aVar = new a("call");
                aVar.b(string3);
                aVar.c(string2);
                aVar.a(jSONObject3);
                aVar.a(string);
                a(aVar);
            } catch (Exception unused) {
                str2 = string;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    a(str2, a.EnumC0095a.RUNTIME_ERROR, true);
                } catch (JSONException unused2) {
                }
            }
        } catch (Exception unused3) {
        }
    }

    public void a(a aVar) throws JSONException {
        if (aVar == null) {
            return;
        }
        if (TextUtils.isEmpty(aVar.d())) {
            a(aVar.b(), a.EnumC0095a.INVALID_PARAMETER, true);
        } else {
            a(new e(this, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, a.EnumC0095a enumC0095a, boolean z10) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", enumC0095a.ordinal());
        a aVar = new a("callback");
        aVar.a(jSONObject);
        aVar.a(str);
        if (z10) {
            this.f4512a.a(aVar);
        } else {
            a(aVar);
        }
    }

    private static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
