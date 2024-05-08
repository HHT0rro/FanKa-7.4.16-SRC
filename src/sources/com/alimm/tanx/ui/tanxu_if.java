package com.alimm.tanx.ui;

import android.app.Application;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.ui.ad.ITanxSdkManager;
import com.alimm.tanx.ui.image.GlideSourceCodeImageLoader;
import nd.a;

/* compiled from: TanxSdkInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxu_if {
    public TanxConfig tanxu_do;

    public void tanxu_do(Application application, TanxConfig tanxConfig) {
        this.tanxu_do = tanxConfig;
        StringBuilder a10 = a.a("initImageLoader");
        a10.append(OrangeManager.getInstance().getOrangeBean().imageSwitch.toString());
        LogUtils.d("ImageManager init", a10.toString());
        if (OrangeManager.getInstance().getAllAppImageSwitch() || OrangeManager.getInstance().getImageSwitch(this.tanxu_do.getAppKey())) {
            LogUtils.d("ImageManager init", "命中appkey重新设置GlideSourceCodeImageLoader");
            ImageManager.setLoader(new GlideSourceCodeImageLoader());
        }
    }

    public ITanxSdkManager tanxu_if() {
        return TanxSdkManager.getInstance();
    }

    public TanxConfig tanxu_do() {
        return this.tanxu_do;
    }
}
