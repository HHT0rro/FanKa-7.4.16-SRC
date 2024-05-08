package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.shuzilm.core.IDUService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DUConnection implements ServiceConnection {
    public static IDUService duService;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            IDUService asInterface = IDUService.Stub.asInterface(iBinder);
            duService = asInterface;
            if (asInterface != null) {
                Main.mLock.unlock();
            }
        } catch (Exception unused) {
            duService = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        duService = null;
    }
}
