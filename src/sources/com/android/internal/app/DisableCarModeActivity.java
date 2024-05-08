package com.android.internal.app;

import android.app.Activity;
import android.app.IUiModeManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DisableCarModeActivity extends Activity {
    private static final String TAG = "DisableCarModeActivity";

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            IUiModeManager uiModeManager = IUiModeManager.Stub.asInterface(ServiceManager.getService("uimode"));
            uiModeManager.disableCarModeByCallingPackage(3, getOpPackageName());
        } catch (RemoteException e2) {
            Log.e(TAG, "Failed to disable car mode", e2);
        }
        finish();
    }
}
