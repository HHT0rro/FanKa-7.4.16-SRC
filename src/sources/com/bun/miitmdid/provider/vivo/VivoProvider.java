package com.bun.miitmdid.provider.vivo;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class VivoProvider extends BaseProvider {
    public static final String TAG = "SDK call Vivo: ";
    public String appID;
    public Context context;

    public VivoProvider(Context context, String str) {
        this.context = context;
        this.appID = str;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 94, 1598952044316L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 95, 1598952044317L})).booleanValue();
    }
}
