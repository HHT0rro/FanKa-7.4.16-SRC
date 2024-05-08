package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1768a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1769b;

    public i(Context context, String str) {
        this.f1768a = context;
        this.f1769b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        try {
            Context context = this.f1768a;
            jSONObject = DUHelper.f1690l;
            DUHelper.dGZvcmRQ(context, jSONObject.toString(), this.f1769b);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
    }
}
