package com.alimm.tanx.ui.ad;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxCoreManager;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxSdkManager extends ITanxCoreManager {
    ITanxAdLoader createAdLoader(Context context);

    ITanxAdLoader createNewAdLoader(Context context);

    @Override // com.alimm.tanx.core.ad.ITanxCoreManager
    ITanxRequestLoader createRequestLoader(Context context);
}
