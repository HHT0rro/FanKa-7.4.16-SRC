package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1778b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1779c;

    public p(Context context, String str, String str2) {
        this.f1777a = context;
        this.f1778b = str;
        this.f1779c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        DUHelper dUHelper;
        JSONObject jSONObject;
        DUHelper dUHelper2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            str = DUHelper.f1687i;
            DUHelper.setConfig("apiKey", str);
            dUHelper = DUHelper.f1682d;
            Context context = this.f1777a;
            jSONObject = DUHelper.f1690l;
            dUHelper.a(context, jSONObject, this.f1778b);
            dUHelper2 = DUHelper.f1682d;
            jSONObject2 = DUHelper.f1689k;
            dUHelper2.a(jSONObject2, this.f1779c);
            Context context2 = this.f1777a;
            jSONObject3 = DUHelper.f1690l;
            String jSONObject5 = jSONObject3.toString();
            jSONObject4 = DUHelper.f1689k;
            DUHelper.reportRun(context2, jSONObject5, jSONObject4.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
    }
}
