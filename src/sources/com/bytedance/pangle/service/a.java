package com.bytedance.pangle.service;

import android.content.Intent;
import android.os.IBinder;
import com.bytedance.pangle.plugin.Plugin;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {
    void attach(Plugin plugin);

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i10, int i11);

    boolean onUnbind(Intent intent);
}
