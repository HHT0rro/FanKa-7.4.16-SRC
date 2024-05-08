package com.wangmai.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OAIDService implements ServiceConnection {
    public final RemoteCaller caller;
    public final Context context;
    public final IGetter getter;

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
        this.getter = iGetter;
        this.caller = remoteCaller;
    }

    public static void bind(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller) {
        new OAIDService(context, iGetter, remoteCaller).bind(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        OAIDLog.print("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String callRemoteInterface = this.caller.callRemoteInterface(iBinder);
                if (callRemoteInterface != null && callRemoteInterface.length() != 0) {
                    OAIDLog.print("OAID/AAID acquire success: " + callRemoteInterface);
                    this.getter.onOAIDGetComplete(callRemoteInterface);
                    try {
                        this.context.unbindService(this);
                        OAIDLog.print("Service has been unbound: " + componentName.getClassName());
                        return;
                    } catch (Exception e2) {
                        OAIDLog.print(e2);
                        return;
                    }
                }
                throw new OAIDException("OAID/AAID acquire failed");
            } catch (Exception e10) {
                OAIDLog.print(e10);
                this.getter.onOAIDGetError(e10);
                try {
                    this.context.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e11) {
                    OAIDLog.print(e11);
                }
            }
        } catch (Throwable th) {
            try {
                this.context.unbindService(this);
                OAIDLog.print("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e12) {
                OAIDLog.print(e12);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.print("Service has been disconnected: " + componentName.getClassName());
    }

    private void bind(Intent intent) {
        try {
            if (this.context.bindService(intent, this, 1)) {
                OAIDLog.print("Service has been bound: " + ((Object) intent));
                return;
            }
            throw new OAIDException("Service binding failed");
        } catch (Exception e2) {
            this.getter.onOAIDGetError(e2);
        }
    }
}
