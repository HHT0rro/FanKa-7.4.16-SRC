package com.alimm.tanx.ui;

import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel;
import com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl;
import com.alimm.tanx.core.view.player.core.TanxPlayer;
import com.alimm.tanx.ui.image.GlideSourceCodeImageLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxThirdInstanceBuilder extends TanxCoreInstanceConfig {
    public TanxThirdInstanceBuilder() {
        setSplashModel(new SplashAdModel());
        setNetWork(new OkHttpNetWorkImpl());
        setTanxUserTracker(new tanxu_for(this));
        setTanxPlayer(new TanxPlayer());
        setImageLoader(new GlideSourceCodeImageLoader());
    }
}
