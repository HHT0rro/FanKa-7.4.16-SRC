package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f1762b;

    public e(String str, Context context) {
        this.f1761a = str;
        this.f1762b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        try {
            DUHelper.setConfig("f_pkg", this.f1761a);
            Context context = this.f1762b;
            jSONObject = DUHelper.f1690l;
            DUHelper.onIEvent(context, jSONObject.toString(), null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
    }
}
