package com.alimm.tanx.ui;

import android.content.Context;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.loader.NewTanxAdLoader;
import com.alimm.tanx.core.ad.loader.TanxRequestLoader;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.ui.ad.ITanxSdkManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxSdkManager extends TanxCoreManager implements ITanxSdkManager {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class SingletonHolder implements NotConfused {
        public static final TanxSdkManager INSTANCE = new TanxSdkManager();
    }

    public static TanxSdkManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override // com.alimm.tanx.ui.ad.ITanxSdkManager
    public ITanxAdLoader createAdLoader(Context context) {
        return new NewTanxAdLoader(context);
    }

    @Override // com.alimm.tanx.ui.ad.ITanxSdkManager
    public ITanxAdLoader createNewAdLoader(Context context) {
        return new NewTanxAdLoader(context);
    }

    @Override // com.alimm.tanx.core.TanxCoreManager, com.alimm.tanx.core.ad.ITanxCoreManager
    public ITanxRequestLoader createRequestLoader(Context context) {
        return new TanxRequestLoader();
    }
}
