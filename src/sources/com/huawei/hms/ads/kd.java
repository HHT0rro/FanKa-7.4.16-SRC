package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.inter.listeners.b;
import com.huawei.openalliance.ad.utils.c;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class kd extends hn<lo> implements kp<lo> {
    private Context B;
    private SplashView.SplashAdLoadListener C;
    private fr I;
    private b Z;

    public kd(Context context, lo loVar) {
        Code((kd) loVar);
        this.B = context.getApplicationContext();
        this.I = fr.Code(context);
    }

    private void S() {
        gl.I("SplashPresenter", "notifyNotSupport");
        b bVar = this.Z;
        if (bVar != null) {
            bVar.Code(1001);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(dx.Code(1001));
        }
    }

    @Override // com.huawei.hms.ads.kp
    public boolean B() {
        return c.L(this.B);
    }

    @Override // com.huawei.hms.ads.kp
    public void C() {
        gl.Code("SplashPresenter", "notifyAdDismissed");
        b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        com.huawei.openalliance.ad.utils.ax.V(this.B);
    }

    @Override // com.huawei.hms.ads.kp
    public void Code() {
        I().Code(((Integer) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.kd.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(kd.this.I.I());
            }
        }, 1)).intValue());
    }

    @Override // com.huawei.hms.ads.kp
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.C = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.kp
    public void Code(b bVar) {
        this.Z = bVar;
    }

    @Override // com.huawei.hms.ads.kp
    public void Code(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slotid", str);
            jSONObject.put("adType", i10);
            com.huawei.openalliance.ad.ipc.g.V(this.B).Code("rptSplashDismissForExSplash", jSONObject.toString(), null, null);
        } catch (JSONException unused) {
            gl.I("SplashPresenter", "onSplashDismissForExsplash JSONException");
        }
    }

    @Override // com.huawei.hms.ads.kp
    public boolean V() {
        if (com.huawei.openalliance.ad.utils.v.Code(this.B)) {
            return true;
        }
        S();
        C();
        return false;
    }
}
