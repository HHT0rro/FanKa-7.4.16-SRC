package com.bun.miitmdid.provider.oppo;

import XI.XI.K0.XI;
import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class OppoProvider extends BaseProvider {
    public static final String TAG = "SDK call Oppo: ";
    public Context context;

    public OppoProvider(Context context) {
        XI.xo(context);
        this.context = context;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 83, 1598952044305L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 84, 1598952044306L})).booleanValue();
    }
}
