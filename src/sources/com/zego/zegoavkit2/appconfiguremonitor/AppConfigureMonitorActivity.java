package com.zego.zegoavkit2.appconfiguremonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import com.huawei.quickcard.base.Attributes;

/* compiled from: AppConfigureMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class AppConfigureMonitorActivity {
    private DisplayManager.DisplayListener display_listener_;
    private Context mContext;
    private long mThis;
    private int task_delay_internal_ = 100;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    public static native void onAppOrientationChanged(long j10, int i10);

    public void StartDisplayListener() {
        this.display_listener_ = new DisplayManager.DisplayListener() { // from class: com.zego.zegoavkit2.appconfiguremonitor.AppConfigureMonitorActivity.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i10) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i10) {
                AppConfigureMonitorActivity.this.mUIHandler.postDelayed(new Runnable() { // from class: com.zego.zegoavkit2.appconfiguremonitor.AppConfigureMonitorActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AppConfigureMonitorActivity.this.UpdateOrientationManual();
                    }
                }, AppConfigureMonitorActivity.this.task_delay_internal_);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i10) {
            }
        };
        ((DisplayManager) this.mContext.getSystemService(Attributes.Style.DISPLAY)).registerDisplayListener(this.display_listener_, this.mUIHandler);
    }

    public void StopDisplayListener() {
        ((DisplayManager) this.mContext.getSystemService(Attributes.Style.DISPLAY)).unregisterDisplayListener(this.display_listener_);
        this.display_listener_ = null;
    }

    public synchronized void UpdateOrientationManual() {
        if (this.mContext != null) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            int i10 = runningAppProcessInfo.importance;
            if (i10 == 100 || i10 == 200) {
                onAppOrientationChanged(this.mThis, ((DisplayManager) this.mContext.getSystemService(Attributes.Style.DISPLAY)).getDisplay(0).getRotation());
            }
        }
    }

    public synchronized int init(Context context) {
        this.mContext = context;
        if (context == null) {
            return -1;
        }
        StartDisplayListener();
        return 0;
    }

    public void setThis(long j10) {
        this.mThis = j10;
    }

    public synchronized int uninit() {
        if (this.mContext == null) {
            return -1;
        }
        StopDisplayListener();
        this.mContext = null;
        return 0;
    }
}
