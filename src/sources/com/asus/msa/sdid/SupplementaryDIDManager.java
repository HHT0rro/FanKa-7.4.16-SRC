package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public Context mContext;
    public IDidAidlInterface mDidService;
    public IDIDBinderStatusListener mListener;
    public boolean isBinded = false;
    public ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.asus.msa.sdid.SupplementaryDIDManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean unused = SupplementaryDIDManager.DEBUG;
            SupplementaryDIDManager.this.mDidService = IDidAidlInterface.Stub.asInterface(iBinder);
            SupplementaryDIDManager.this.notifyAllListeners(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SupplementaryDIDManager.this.notifyAllListeners(false);
        }
    };

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllListeners(boolean z10) {
        try {
            if (z10) {
                this.mListener.onSuccess(this.mDidService);
            } else {
                this.mListener.onError();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.getMessage();
            }
        }
    }

    public void deInit() {
        ServiceConnection serviceConnection;
        Context context;
        try {
            if (!this.isBinded || (serviceConnection = this.mServiceConnection) == null || (context = this.mContext) == null) {
                return;
            }
            this.isBinded = false;
            context.unbindService(serviceConnection);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public void init(IDIDBinderStatusListener iDIDBinderStatusListener) {
        try {
            this.mListener = iDIDBinderStatusListener;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
        } catch (Exception unused) {
            notifyAllListeners(false);
        }
    }

    public void showLog(boolean z10) {
        DEBUG = z10;
    }
}
