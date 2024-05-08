package com.jd.ad.sdk.mdt.service;

import android.view.View;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface JADExposureService {
    ConcurrentHashMap<String, WeakReference<View>> getNativeExposureFeedShakeViewMap();

    void registerExposureView(@NonNull String str);

    void registerNativeExposureFeedShakeView(@NonNull String str, @NonNull View view);

    void setViewExposureCallback(@NonNull String str, int i10, @NonNull View view, @NonNull JADExposureListener jADExposureListener);

    void setViewForceExposure(@NonNull String str);

    void unregisterExposureView(@NonNull String str);

    void unregisterNativeExposureFeedShakeView(@NonNull String str);
}
