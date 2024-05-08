package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class AbstractAdglAnimation {
    public static final int DEFAULT_DURATION = 250;
    public static final int INTERPOLATOR_ACCELERATE = 1;
    public static final int INTERPOLATOR_ACCELERATE_DECELERATE = 3;
    public static final int INTERPOLATOR_BOUNCE = 4;
    public static final int INTERPOLATOR_DECELERATE = 2;
    public static final int INTERPOLATOR_DOUBLE_RAISE = 6;
    public static final int INTERPOLATOR_LINEAR = 0;
    public static final int INTERPOLATOR_OVERSHOOT = 5;
    public static final int INVALIDE_VALUE = -9999;
    public int duration = 300;
    public boolean isOver = false;
    public long startTime = -1;
    public long offsetTime = 0;

    public abstract void doAnimation(Object obj);

    public boolean isOver() {
        return this.isOver;
    }

    public boolean isValid() {
        return true;
    }
}
