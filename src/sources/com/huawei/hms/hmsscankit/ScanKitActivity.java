package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ScanKitActivity extends Activity {
    private static final int REQUEST_SETTING_DETAILS = 1;
    private static final String TAG = "ScanKitActivity";
    public static AlertDialog alertDialog;
    public static a mDialog;
    private boolean hasCameraPermission;
    private OrientationEventListener mOrientationListener;
    private RemoteView remoteView;
    private int lastRotation = Integer.MAX_VALUE;
    private boolean errorReport = false;
    private boolean showGuide = false;

    private void cameraPermissionChange() {
        a aVar = mDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
        AlertDialog alertDialog2 = alertDialog;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            alertDialog.dismiss();
        }
        if (isFinishing()) {
            return;
        }
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSetting() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri fromParts = Uri.fromParts("package", getPackageName(), null);
        o4.a(TAG, "getPackageName ", getPackageName());
        intent.setData(fromParts);
        startActivityForResult(intent, 1);
    }

    private void setActivityUseNotchScreen(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            activity.getWindow().setAttributes(attributes);
        }
    }

    private void startOrientationChangeListener() {
        OrientationEventListener orientationEventListener = new OrientationEventListener(this) { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.7
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i10) {
                try {
                    int rotation = ScanKitActivity.this.getWindowManager().getDefaultDisplay().getRotation();
                    if (Math.abs(ScanKitActivity.this.lastRotation - rotation) == 2) {
                        ScanKitActivity.this.recreate();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onOrientationChanged: currentRotation");
                        sb2.append(rotation);
                    }
                    ScanKitActivity.this.lastRotation = rotation;
                } catch (RuntimeException unused) {
                }
            }
        };
        this.mOrientationListener = orientationEventListener;
        orientationEventListener.enable();
    }

    @Override // android.app.Activity
    public void finish() {
        this.remoteView.onStop();
        w7.f31710c = true;
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.remoteView.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            cameraPermissionChange();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0132  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanKitActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        w7.f31710c = true;
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.remoteView.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.remoteView.onRequestPermissionsResult(i10, strArr, iArr, this);
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.remoteView.onResume();
        w7.f31710c = false;
        if (this.hasCameraPermission || !w7.a((Context) this)) {
            return;
        }
        cameraPermissionChange();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.remoteView.onStart();
        w7.f31710c = false;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (w7.f31710c) {
            return;
        }
        this.remoteView.onStop();
        w7.f31710c = true;
    }
}
