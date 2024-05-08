package com.huawei.dynamicanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface PhysicalModel {
    float getAcceleration();

    float getAcceleration(float f10);

    float getEndPosition();

    float getEstimatedDuration();

    float getMaxAbsX();

    float getPosition();

    float getPosition(float f10);

    float getStartPosition();

    float getStartTime();

    float getStartVelocity();

    float getVelocity();

    float getVelocity(float f10);

    boolean isAtEquilibrium();

    boolean isAtEquilibrium(float f10);

    boolean isAtEquilibrium(float f10, float f11);

    PhysicalModel setEndPosition(float f10);

    PhysicalModel setValueThreshold(float f10);
}
