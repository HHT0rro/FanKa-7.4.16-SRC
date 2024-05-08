package com.wangmai.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.bun.miitmdid.content.StringValues;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;
import com.wangmai.adIdUtils.oaid.impl.OAIDService;
import com.wangmai.adIdUtils.oaid.lib.bun.lib.MsaIdInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MsaImpl implements IOAID {
    public final Context context;

    public MsaImpl(Context context) {
        this.context = context;
    }

    private void startMsaKlService() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.context.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.context.startService(intent);
            } else {
                this.context.startForegroundService(intent);
            }
        } catch (Exception e2) {
            OAIDLog.print(e2);
        }
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        startMsaKlService();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.context.getPackageName());
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.wangmai.adIdUtils.oaid.impl.MsaImpl.1
            @Override // com.wangmai.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupported()) {
                        return asInterface.getOAID();
                    }
                    throw new OAIDException("MsaIdInterface#isSupported return false");
                }
                throw new OAIDException("MsaIdInterface is null");
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
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return false;
        }
    }
}
