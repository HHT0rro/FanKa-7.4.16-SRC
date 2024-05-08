package com.wangmai.adIdUtils.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;
import com.wangmai.adIdUtils.oaid.impl.OAIDService;
import com.wangmai.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HuaweiImpl implements IOAID {
    public final Context context;
    public String packageName;

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), AdvertisingIdClient.SETTINGS_AD_ID);
                if (!TextUtils.isEmpty(string)) {
                    OAIDLog.print("Get oaid from global settings: " + string);
                    iGetter.onOAIDGetComplete(string);
                    return;
                }
            } catch (Exception e2) {
                OAIDLog.print(e2);
            }
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.wangmai.adIdUtils.oaid.impl.HuaweiImpl.1
            @Override // com.wangmai.adIdUtils.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (!asInterface.isOaidTrackLimited()) {
                    return asInterface.getOaid();
                }
                throw new OAIDException("User has disabled advertising identifier");
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
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.packageName = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.packageName = "com.huawei.hwid.tv";
            } else {
                this.packageName = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return false;
        }
    }
}
