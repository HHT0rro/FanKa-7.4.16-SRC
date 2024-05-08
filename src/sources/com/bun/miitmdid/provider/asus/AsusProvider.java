package com.bun.miitmdid.provider.asus;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AsusProvider extends BaseProvider implements IDIDBinderStatusListener {
    public static final String TAG = "SDK call Asus: ";
    public Context context;
    public final SupplementaryDIDManager supplementaryDIDManager;

    public AsusProvider(Context context) {
        this.context = context;
        this.supplementaryDIDManager = new SupplementaryDIDManager(context);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return (IBinder) Utils.rL(new Object[]{this, 46, 1598952044268L});
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 47, 1598952044269L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 48, 1598952044270L})).booleanValue();
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void onError() {
        Utils.rL(new Object[]{this, 49, 1598952044271L});
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void onSuccess(IDidAidlInterface iDidAidlInterface) {
        Utils.rL(new Object[]{this, iDidAidlInterface, 50, 1598952044272L});
    }

    @Override // com.bun.miitmdid.provider.BaseProvider, com.bun.miitmdid.interfaces.InnerIdProvider
    public void shutDown() {
        Utils.rL(new Object[]{this, 51, 1598952044273L});
    }
}
