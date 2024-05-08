package com.danlan.android.cognition.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CameraCollector extends SubCollector {
    private Context mcontext;

    public CameraCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("SUJXYEBOQVNAcFFTUUxWVQ=="), hasCameraSupport());
            safeJSONObject.put(StringFog.decrypt("SUJXYEBOQVNAZUhCUks="), hasCameraFlash());
            safeJSONObject.put(StringFog.decrypt("QkJJRlNCZ05UTVA="), getNumberOfCameras());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("QkJJRlNC"), safeJSONObject);
        collectDone();
    }

    public final int getNumberOfCameras() {
        try {
            return Camera.getNumberOfCameras();
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                return ((CameraManager) this.mcontext.getSystemService(StringFog.decrypt("QkJJRlNC"))).getCameraIdList().length;
            } catch (CameraAccessException e10) {
                e10.printStackTrace();
                return 0;
            }
        }
    }

    public final boolean hasCameraFlash() {
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            return packageManager.hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9ARU5EUUUPR09FUEk="));
        }
        return false;
    }

    public final boolean hasCameraSupport() {
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            return packageManager.hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9ARU5EUUU="));
        }
        return false;
    }
}
