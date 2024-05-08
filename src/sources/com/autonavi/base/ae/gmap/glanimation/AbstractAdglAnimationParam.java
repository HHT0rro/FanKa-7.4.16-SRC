package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class AbstractAdglAnimationParam {
    public float mult;
    public float normalizedTime;
    public int interpolationType = 0;
    public float factor = 1.0f;
    public boolean hasCheckedParam = false;
    public boolean needToCaculate = false;
    public boolean hasFromValue = false;
    public boolean hasToValue = false;

    public static float bounce(float f10) {
        return f10 * f10 * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i10, float f10) {
        this.interpolationType = i10;
        this.factor = f10;
    }

    public void setNormalizedTime(float f10) {
        double pow;
        float bounce;
        float f11;
        this.normalizedTime = f10;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                pow = Math.pow(f10, this.factor * 2.0f);
                f10 = (float) pow;
                break;
            case 2:
                if (this.factor != 1.0f) {
                    f10 = (float) (1.0d - Math.pow(1.0f - f10, r0 * 2.0f));
                    break;
                } else {
                    float f12 = 1.0f - f10;
                    f10 = 1.0f - (f12 * f12);
                    break;
                }
            case 3:
                pow = (Math.cos((f10 + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                f10 = (float) pow;
                break;
            case 4:
                float f13 = f10 * 1.1226f;
                if (f13 >= 0.3535f) {
                    if (f13 < 0.7408f) {
                        bounce = bounce(f13 - 0.54719f);
                        f11 = 0.7f;
                    } else if (f13 < 0.9644f) {
                        bounce = bounce(f13 - 0.8526f);
                        f11 = 0.9f;
                    } else {
                        bounce = bounce(f13 - 1.0435f);
                        f11 = 0.95f;
                    }
                    f10 = bounce + f11;
                    break;
                } else {
                    f10 = bounce(f13);
                    break;
                }
            case 5:
                float f14 = f10 - 1.0f;
                f10 = (f14 * f14 * ((f14 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f10 >= 0.0f) {
                    if (f10 >= 0.25f) {
                        if (f10 >= 0.5f) {
                            if (f10 >= 0.75f) {
                                if (f10 <= 1.0f) {
                                    f10 = 4.0f - (f10 * 4.0f);
                                    break;
                                }
                            } else {
                                f10 = (f10 * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f10 = 2.0f - (f10 * 4.0f);
                            break;
                        }
                    } else {
                        f10 *= 4.0f;
                        break;
                    }
                }
            default:
                f10 = 0.0f;
                break;
        }
        this.mult = f10;
    }
}
