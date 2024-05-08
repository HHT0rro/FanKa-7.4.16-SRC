package com.alibaba.security.biometrics;

import android.os.Bundle;
import com.alibaba.security.biometrics.jni.listener.OnSgProcessListener;
import com.alibaba.security.biometrics.service.listener.OnLogTrackListener;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.listener.OnSensorTrackListener;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ALBiometricsEventListener extends OnSgProcessListener, OnLogTrackListener, OnSensorTrackListener {
    void onBeforeRetry(OnRetryListener onRetryListener, String str);

    void onBiometricsFinish(int i10);

    void onBiometricsStart();

    void onBusinessOk();

    void onCancel(int i10, String str);

    void onError(int i10, Bundle bundle);

    void onFinish(int i10, boolean z10);

    void onSuccess(ALBiometricsResult aLBiometricsResult);
}
