package com.autonavi.base.ae.gmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController = new GLEngineIDController();
    private int engineIDIndex = 10000;

    private GLEngineIDController() {
    }

    public static GLEngineIDController getController() {
        return sController;
    }

    public synchronized int generate() {
        int i10;
        i10 = this.engineIDIndex + 1;
        this.engineIDIndex = i10;
        return i10;
    }
}
