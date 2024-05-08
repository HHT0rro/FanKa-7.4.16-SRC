package com.wangmai.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;
import com.wangmai.adIdUtils.oaid.impl.OAIDService;
import com.wangmai.adIdUtils.oaid.lib.android.creator.IdsSupplier;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FreemeImpl implements IOAID {
    public final Context context;

    public FreemeImpl(Context context) {
        this.context = context;
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.wangmai.adIdUtils.oaid.impl.FreemeImpl.1
            @Override // com.wangmai.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IdsSupplier is null");
            }
        });
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return false;
        }
    }
}