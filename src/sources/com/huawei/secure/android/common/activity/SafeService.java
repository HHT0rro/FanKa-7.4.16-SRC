package com.huawei.secure.android.common.activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import com.huawei.secure.android.common.intent.SafeIntent;
import ra.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class SafeService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public static final String f34764b = SafeService.class.getSimpleName();

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i10) {
        try {
            return super.bindService(intent, serviceConnection, i10);
        } catch (Exception e2) {
            a.e(f34764b, "bindService: " + e2.getMessage(), true);
            return false;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
        } catch (Exception e2) {
            a.e(f34764b, "onCreate: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e2) {
            a.e(f34764b, "onDestroy: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        try {
            super.onRebind(new SafeIntent(intent));
        } catch (Exception e2) {
            a.e(f34764b, "onRebind: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Service
    @Deprecated
    public void onStart(Intent intent, int i10) {
        if (wa.a.a(intent)) {
            a.c(f34764b, "onStart : hasIntentBomb");
        }
        try {
            super.onStart(new SafeIntent(intent), i10);
        } catch (Exception e2) {
            a.e(f34764b, "onStart: " + e2.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (wa.a.a(intent)) {
            a.c(f34764b, "onStartCommand : hasIntentBomb");
        }
        try {
            return super.onStartCommand(new SafeIntent(intent), i10, i11);
        } catch (Exception e2) {
            a.e(f34764b, "onStartCommand: " + e2.getMessage(), true);
            return 0;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        try {
            return super.onUnbind(new SafeIntent(intent));
        } catch (Exception e2) {
            a.e(f34764b, "onUnbind: " + e2.getMessage(), true);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e2) {
            a.e(f34764b, "startActivities: " + e2.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception e2) {
            a.e(f34764b, "startActivity: " + e2.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startForegroundService(Intent intent) {
        try {
            return super.startForegroundService(new SafeIntent(intent));
        } catch (Exception e2) {
            a.e(f34764b, "startForegroundService: " + e2.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        try {
            return super.startService(intent);
        } catch (Exception e2) {
            a.e(f34764b, "startService: " + e2.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        try {
            return super.stopService(intent);
        } catch (Exception e2) {
            a.e(f34764b, "stopService: " + e2.getMessage(), true);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (Exception e2) {
            a.e(f34764b, "unbindService: " + e2.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Exception e2) {
            a.e(f34764b, "unregisterReceiver: " + e2.getMessage(), true);
        }
    }
}
