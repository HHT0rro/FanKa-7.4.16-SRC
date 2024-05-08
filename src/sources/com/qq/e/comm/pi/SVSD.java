package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface SVSD {
    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    int onStartCommand(Intent intent, int i10, int i11);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i10);

    boolean onUnbind(Intent intent);
}
