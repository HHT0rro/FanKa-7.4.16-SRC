package com.alibaba.security.biometrics.service;

import com.alibaba.security.biometrics.jni.listener.OnSgProcessListener;
import com.alibaba.security.biometrics.service.build.g;
import com.alibaba.security.biometrics.service.listener.OnLogTrackListener;
import com.alibaba.security.biometrics.service.listener.OnSensorTrackListener;
import com.alibaba.security.biometrics.service.model.ALBiometricsEvents;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ALBiometricsServiceEventListener extends OnSgProcessListener, g, OnLogTrackListener, OnSensorTrackListener, ALBiometricsEvents.OnActionEndListener, ALBiometricsEvents.OnActionStartListener, ALBiometricsEvents.OnAdjustEndListener, ALBiometricsEvents.OnAdjustStartListener, ALBiometricsEvents.OnBeforeRetryListener, ALBiometricsEvents.OnCancelListener, ALBiometricsEvents.OnDetectContinueListener, ALBiometricsEvents.OnDetectStartListener, ALBiometricsEvents.OnFinishListener, ALBiometricsEvents.OnFrameDetectedListener, ALBiometricsEvents.OnMessageListener, ALBiometricsEvents.OnRecognizeEndListener, ALBiometricsEvents.OnRecognizeStartListener, ALBiometricsEvents.OnReflectEndListener, ALBiometricsEvents.OnReflectStartListener {
}
