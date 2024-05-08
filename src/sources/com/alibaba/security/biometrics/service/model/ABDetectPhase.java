package com.alibaba.security.biometrics.service.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ABDetectPhase {
    INIT(0),
    ADJUST_BEGIN(1),
    ADJUST_END(2),
    ACTION_BEGIN(3),
    ACTION_END(4),
    FACE_DETECT(100),
    FINISH(10000);

    private int value;

    ABDetectPhase(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
