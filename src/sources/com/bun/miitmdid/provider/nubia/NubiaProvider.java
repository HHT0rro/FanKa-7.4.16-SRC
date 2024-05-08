package com.bun.miitmdid.provider.nubia;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NubiaProvider extends BaseProvider {
    public static final String TAG = "SDK call Nubia: ";
    public Context context;
    public String packagename;

    public NubiaProvider(Context context) {
        this.context = context;
        this.packagename = context.getPackageName();
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 80, 1598952044302L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 81, 1598952044303L})).booleanValue();
    }
}
