package com.alipay.sdk.authjs;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f4516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f4517b;

    public f(d dVar, a aVar) {
        this.f4517b = dVar;
        this.f4516a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        c cVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toastCallBack", "true");
        } catch (JSONException unused) {
        }
        a aVar = new a("callback");
        aVar.a(this.f4516a.b());
        aVar.a(jSONObject);
        cVar = this.f4517b.f4512a;
        cVar.a(aVar);
    }
}
