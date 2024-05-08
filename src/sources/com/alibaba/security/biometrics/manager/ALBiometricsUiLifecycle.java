package com.alibaba.security.biometrics.manager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsUiLifecycle {
    private static volatile ALBiometricsUiLifecycle instance;
    private boolean isModelLoadingActivityActive = false;

    private ALBiometricsUiLifecycle() {
    }

    public static ALBiometricsUiLifecycle getInstance() {
        if (instance == null) {
            synchronized (ALBiometricsUiLifecycle.class) {
                if (instance == null) {
                    instance = new ALBiometricsUiLifecycle();
                }
            }
        }
        return instance;
    }

    public boolean isALModelLoadingActivityActive() {
        return this.isModelLoadingActivityActive;
    }

    public void setModelLoadingActivityActive(boolean z10) {
        this.isModelLoadingActivityActive = z10;
    }
}
