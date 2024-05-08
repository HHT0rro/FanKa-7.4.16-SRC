package com.alibaba.security.biometrics.service.model;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsEvents {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnActionEndListener {
        void onActionEnd(ABDetectType aBDetectType, int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnActionStartListener {
        void onActionStart(ABDetectType aBDetectType, int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnAdjustEndListener {
        void onAdjustEnd();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnAdjustStartListener {
        void onAdjustStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnBeforeRetryListener {
        void onBeforeRetry(OnRetryListener onRetryListener, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnCancelListener {
        void onCancel(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnDetectContinueListener {
        void onDetectContinue(ABImageResult aBImageResult);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnDetectStartListener {
        void onDetectStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnFinishListener {
        void onFinish(int i10, Bundle bundle);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnFrameDetectedListener {
        void onFrameDetected(ABDetectFrame aBDetectFrame);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnMessageListener {
        void onMessage(int i10, Bundle bundle);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnRecognizeEndListener {
        void onRecognizeEnd();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnRecognizeStartListener {
        void onRecognizeStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnReflectEndListener {
        void onReflectEnd();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnReflectStartListener {
        void onReflectStart();
    }
}
