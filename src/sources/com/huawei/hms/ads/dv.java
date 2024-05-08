package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dv extends ISplashApi.b {

    /* renamed from: l, reason: collision with root package name */
    private hg f29082l;

    /* renamed from: m, reason: collision with root package name */
    private AdContentData f29083m;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<Context> f29084n;

    /* renamed from: o, reason: collision with root package name */
    private Context f29085o;

    public dv(Context context, hg hgVar, AdContentData adContentData) {
        this.f29085o = context.getApplicationContext();
        this.f29084n = new WeakReference<>(context);
        this.f29082l = hgVar;
        this.f29083m = adContentData;
    }

    private int Code(int i10) {
        Integer a10 = com.huawei.openalliance.ad.utils.v.a(this.f29085o);
        if (com.huawei.openalliance.ad.utils.v.I()) {
            return i10;
        }
        if (a10 != null && a10.intValue() >= 30454100) {
            return i10;
        }
        gl.V("SplashProxy", "HMS version is low, interactMode is %s", Integer.valueOf(i10));
        if (i10 == 4) {
            i10 = 1;
        }
        if (i10 == 3) {
            return 2;
        }
        return i10;
    }

    private void Code(Bundle bundle) {
        boolean z10 = bundle.getBoolean(bg.e.f32295l);
        AdEventReport Code = kv.Code(this.f29083m);
        Code.V(z10);
        com.huawei.openalliance.ad.ipc.g.V(this.f29085o).Code(com.huawei.openalliance.ad.constant.q.f32326i, com.huawei.openalliance.ad.utils.z.V(Code), null, null);
    }

    private void I(Bundle bundle) {
        kv.Code(this.f29085o, this.f29083m, com.huawei.openalliance.ad.constant.ae.Z, Long.valueOf(bundle.getLong("startTime")), Long.valueOf(bundle.getLong(bg.e.f32291h)), Integer.valueOf((int) bundle.getLong(bg.e.f32292i)), Integer.valueOf((int) bundle.getLong(bg.e.f32293j)));
    }

    private void V(Bundle bundle) {
        kv.Code(this.f29085o, this.f29083m, com.huawei.openalliance.ad.constant.ae.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    private void Z(Bundle bundle) {
        eo.Code(this.f29085o, bundle.getInt(bg.e.f32296m), bundle.getString("reason"), this.f29083m);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isDestroyed() {
        Context context = this.f29084n.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isDestroyed();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isFinishing() {
        Context context = this.f29084n.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isFinishing();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdDismissed() {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.L();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdFailedToLoad(int i10) {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.I(i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public String notifyAdLoaded() {
        hg hgVar = this.f29082l;
        if (hgVar == null) {
            return null;
        }
        hgVar.Code(this.f29083m);
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdFailToDisplay() {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.l();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdShowEnd(long j10, int i10) {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.Code(this.f29083m, j10, i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onDisplayTimeUp() {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.i();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onEasterEggPrepare() {
        ky.Code(this.f29085o).Code(this.f29083m);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onFeedback(int i10) {
        gl.V("SplashProxy", "onFeedback");
        ey.Code(this.f29085o).Code();
        eo.Code(this.f29085o);
        Intent intent = new Intent();
        intent.setAction(com.huawei.openalliance.ad.constant.u.ag);
        intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(this.f29085o));
        intent.putExtra(com.huawei.openalliance.ad.constant.ax.ah, Code(i10));
        if (!(this.f29085o instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.huawei.openalliance.ad.utils.ay.Code(this.f29085o, intent);
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.B();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoadFailed() {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.Z(this.f29083m);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoaded() {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.S();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onSkipAd(int i10, int i11) {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.Code(i10, i11);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onStartEasterEggFailed(Bundle bundle) {
        ky.Code(this.f29085o).I(this.f29083m, bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean onTouch(int i10, int i11, long j10, String str, int i12) {
        gl.V("SplashProxy", "onTouch");
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            return hgVar.Code(i10, i11, this.f29083m, Long.valueOf(j10), (com.huawei.openalliance.ad.inter.data.m) com.huawei.openalliance.ad.utils.z.V(str, com.huawei.openalliance.ad.inter.data.m.class, new Class[0]), i12);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void removeExSplashBlock() {
        com.huawei.openalliance.ad.utils.ax.V(this.f29085o);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportEvents(String str, Bundle bundle) {
        if (com.huawei.openalliance.ad.utils.au.Code(str)) {
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1888605810:
                if (str.equals(com.huawei.openalliance.ad.constant.ae.B)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1694029870:
                if (str.equals(com.huawei.openalliance.ad.constant.q.f32334q)) {
                    c4 = 1;
                    break;
                }
                break;
            case -493598457:
                if (str.equals(com.huawei.openalliance.ad.constant.ae.Z)) {
                    c4 = 2;
                    break;
                }
                break;
            case 886907255:
                if (str.equals(com.huawei.openalliance.ad.constant.q.f32326i)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                V(bundle);
                return;
            case 1:
                Z(bundle);
                return;
            case 2:
                I(bundle);
                return;
            case 3:
                Code(bundle);
                return;
            default:
                return;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportShowStartEvent() {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.D();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void toShowSpare(int i10) {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.V(i10);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void updatePhyShowStart(long j10) {
        hg hgVar = this.f29082l;
        if (hgVar != null) {
            hgVar.Code(j10);
        }
    }
}
