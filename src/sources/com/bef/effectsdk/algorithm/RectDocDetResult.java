package com.bef.effectsdk.algorithm;

import h0.a;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RectDocDetResult {
    public static final int DETECT_FAIL = -1;
    public static final int DETECT_SUCCESS = 0;
    private RectDocDetRatio rectDocDetRatio;
    private RectDocDetTargetArea rectDocDetTargetArea;
    private int resultStatus = -1;

    @a
    public RectDocDetResult() {
    }

    public RectDocDetRatio getRectDocDetRatio() {
        return this.rectDocDetRatio;
    }

    public RectDocDetTargetArea getRectDocDetTargetArea() {
        return this.rectDocDetTargetArea;
    }

    public int getResultStatus() {
        return this.resultStatus;
    }

    @a
    public RectDocDetResult(RectDocDetTargetArea rectDocDetTargetArea, RectDocDetRatio rectDocDetRatio) {
        this.rectDocDetTargetArea = rectDocDetTargetArea;
        this.rectDocDetRatio = rectDocDetRatio;
    }
}
