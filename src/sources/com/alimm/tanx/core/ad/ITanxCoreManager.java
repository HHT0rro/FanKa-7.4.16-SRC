package com.alimm.tanx.core.ad;

import android.content.Context;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxCoreManager {
    ITanxRequestLoader createRequestLoader(Context context);

    String getSDKVersion();
}
