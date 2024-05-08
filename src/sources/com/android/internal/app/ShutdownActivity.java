package com.android.internal.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ShutdownActivity extends Activity {
    private static final String TAG = "ShutdownActivity";
    private boolean mConfirm;
    private boolean mReboot;
    private boolean mUserRequested;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        final String reason;
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.mReboot = "android.intent.action.REBOOT".equals(intent.getAction());
        this.mConfirm = intent.getBooleanExtra("android.intent.extra.KEY_CONFIRM", false);
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.USER_REQUESTED_SHUTDOWN", false);
        this.mUserRequested = booleanExtra;
        if (booleanExtra) {
            reason = "userrequested";
        } else {
            reason = intent.getStringExtra("android.intent.extra.REASON");
        }
        String str = "onCreate(): confirm=" + this.mConfirm;
        String str2 = TAG;
        Slog.i(TAG, str);
        Thread thr = new Thread(str2) { // from class: com.android.internal.app.ShutdownActivity.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                IPowerManager pm = IPowerManager.Stub.asInterface(ServiceManager.getService("power"));
                try {
                    if (ShutdownActivity.this.mReboot) {
                        pm.reboot(ShutdownActivity.this.mConfirm, (String) null, false);
                    } else {
                        pm.shutdown(ShutdownActivity.this.mConfirm, reason, false);
                    }
                } catch (RemoteException e2) {
                }
            }
        };
        thr.start();
        finish();
        try {
            thr.join();
        } catch (InterruptedException e2) {
        }
    }
}
