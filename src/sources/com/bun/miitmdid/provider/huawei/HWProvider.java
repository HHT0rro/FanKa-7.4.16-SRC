package com.bun.miitmdid.provider.huawei;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class HWProvider extends BaseProvider {
    public static final String TAG = "SDK call Huawei: ";
    public Context context;

    public HWProvider(Context context) {
        this.context = context;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 61, 1598952044283L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 62, 1598952044284L})).booleanValue();
    }
}
