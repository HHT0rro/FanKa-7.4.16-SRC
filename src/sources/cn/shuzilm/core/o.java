package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1774a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1775b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1776c;

    public o(Context context, String str, String str2) {
        this.f1774a = context;
        this.f1775b = str;
        this.f1776c = str2;
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
            Context context = this.f1774a;
            jSONObject = DUHelper.f1690l;
            dUHelper.a(context, jSONObject, this.f1775b);
            dUHelper2 = DUHelper.f1682d;
            jSONObject2 = DUHelper.f1689k;
            dUHelper2.a(jSONObject2, this.f1776c);
            Context context2 = this.f1774a;
            jSONObject3 = DUHelper.f1690l;
            String jSONObject5 = jSONObject3.toString();
            jSONObject4 = DUHelper.f1689k;
            DUHelper.run(context2, jSONObject5, jSONObject4.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
    }
}
