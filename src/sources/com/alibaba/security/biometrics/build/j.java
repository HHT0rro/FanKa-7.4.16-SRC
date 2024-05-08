package com.alibaba.security.biometrics.build;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: IPageComponent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface j {
    void a(ALBiometricsActivityParentView aLBiometricsActivityParentView);

    boolean a();

    boolean a(int i10, KeyEvent keyEvent);

    boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener);

    boolean b();

    boolean c();
}
