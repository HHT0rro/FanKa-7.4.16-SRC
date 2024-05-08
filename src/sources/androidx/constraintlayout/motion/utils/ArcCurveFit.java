package androidx.constraintlayout.motion.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    public Arc[] mArcs;
    private final double[] mTime;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        public boolean linear;
        public double mArcDistance;
        public double mArcVelocity;
        public double mEllipseA;
        public double mEllipseB;
        public double mEllipseCenterX;
        public double mEllipseCenterY;
        public double[] mLut;
        public double mOneOverDeltaTime;
        public double mTime1;
        public double mTime2;
        public double mTmpCosAngle;
        public double mTmpSinAngle;
        public boolean mVertical;
        public double mX1;
        public double mX2;
        public double mY1;
        public double mY2;

        public Arc(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            this.linear = false;
            this.mVertical = i10 == 1;
            this.mTime1 = d10;
            this.mTime2 = d11;
            this.mOneOverDeltaTime = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.linear = true;
            }
            double d16 = d14 - d12;
            double d17 = d15 - d13;
            if (!this.linear && Math.abs(d16) >= 0.001d && Math.abs(d17) >= 0.001d) {
                this.mLut = new double[101];
                boolean z10 = this.mVertical;
                this.mEllipseA = d16 * (z10 ? -1 : 1);
                this.mEllipseB = d17 * (z10 ? 1 : -1);
                this.mEllipseCenterX = z10 ? d14 : d12;
                this.mEllipseCenterY = z10 ? d13 : d15;
                buildTable(d12, d13, d14, d15);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d12;
            this.mX2 = d14;
            this.mY1 = d13;
            this.mY2 = d15;
            double hypot = Math.hypot(d17, d16);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d18 = this.mTime2;
            double d19 = this.mTime1;
            this.mEllipseCenterX = d16 / (d18 - d19);
            this.mEllipseCenterY = d17 / (d18 - d19);
        }

        private void buildTable(double d10, double d11, double d12, double d13) {
            double d14;
            double d15 = d12 - d10;
            double d16 = d11 - d13;
            int i10 = 0;
            double d17 = ShadowDrawableWrapper.COS_45;
            double d18 = ShadowDrawableWrapper.COS_45;
            double d19 = ShadowDrawableWrapper.COS_45;
            while (true) {
                if (i10 >= ourPercent.length) {
                    break;
                }
                double d20 = d17;
                double radians = Math.toRadians((i10 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d15;
                double cos = Math.cos(radians) * d16;
                if (i10 > 0) {
                    d14 = Math.hypot(sin - d18, cos - d19) + d20;
                    ourPercent[i10] = d14;
                } else {
                    d14 = d20;
                }
                i10++;
                d19 = cos;
                d17 = d14;
                d18 = sin;
            }
            double d21 = d17;
            this.mArcDistance = d21;
            int i11 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] / d21;
                i11++;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= this.mLut.length) {
                    return;
                }
                double length = i12 / (r1.length - 1);
                int binarySearch = Arrays.binarySearch(ourPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i12] = binarySearch / (ourPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i12] = 0.0d;
                } else {
                    int i13 = -binarySearch;
                    int i14 = i13 - 2;
                    double[] dArr2 = ourPercent;
                    this.mLut[i12] = (i14 + ((length - dArr2[i14]) / (dArr2[i13 - 1] - dArr2[i14]))) / (dArr2.length - 1);
                }
                i12++;
            }
        }

        public double getDX() {
            double d10 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d10, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d10 = -d10;
            }
            return d10 * hypot;
        }

        public double getDY() {
            double d10 = this.mEllipseA * this.mTmpCosAngle;
            double d11 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d10, d11);
            return this.mVertical ? (-d11) * hypot : d11 * hypot;
        }

        public double getLinearDX(double d10) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d10) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d10) {
            double d11 = (d10 - this.mTime1) * this.mOneOverDeltaTime;
            double d12 = this.mX1;
            return d12 + (d11 * (this.mX2 - d12));
        }

        public double getLinearY(double d10) {
            double d11 = (d10 - this.mTime1) * this.mOneOverDeltaTime;
            double d12 = this.mY1;
            return d12 + (d11 * (this.mY2 - d12));
        }

        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        public double lookup(double d10) {
            if (d10 <= ShadowDrawableWrapper.COS_45) {
                return ShadowDrawableWrapper.COS_45;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d10 * (dArr.length - 1);
            int i10 = (int) length;
            return dArr[i10] + ((length - i10) * (dArr[i10 + 1] - dArr[i10]));
        }

        public void setPoint(double d10) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d10 : d10 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i10 >= arcArr.length) {
                return;
            }
            int i13 = iArr[i10];
            if (i13 == 0) {
                i12 = 3;
            } else if (i13 == 1) {
                i11 = 1;
                i12 = 1;
            } else if (i13 == 2) {
                i11 = 2;
                i12 = 2;
            } else if (i13 == 3) {
                i11 = i11 == 1 ? 2 : 1;
                i12 = i11;
            }
            int i14 = i10 + 1;
            arcArr[i10] = new Arc(i12, dArr[i10], dArr[i14], dArr2[i10][0], dArr2[i10][1], dArr2[i14][0], dArr2[i14][1]);
            i10 = i14;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d10, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d10 < arcArr[0].mTime1) {
            d10 = arcArr[0].mTime1;
        }
        if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        int i10 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i10 >= arcArr2.length) {
                return;
            }
            if (d10 <= arcArr2[i10].mTime2) {
                if (arcArr2[i10].linear) {
                    dArr[0] = arcArr2[i10].getLinearX(d10);
                    dArr[1] = this.mArcs[i10].getLinearY(d10);
                    return;
                } else {
                    arcArr2[i10].setPoint(d10);
                    dArr[0] = this.mArcs[i10].getX();
                    dArr[1] = this.mArcs[i10].getY();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d10, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d10 < arcArr[0].mTime1) {
            d10 = arcArr[0].mTime1;
        } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        int i10 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i10 >= arcArr2.length) {
                return;
            }
            if (d10 <= arcArr2[i10].mTime2) {
                if (arcArr2[i10].linear) {
                    dArr[0] = arcArr2[i10].getLinearDX(d10);
                    dArr[1] = this.mArcs[i10].getLinearDY(d10);
                    return;
                } else {
                    arcArr2[i10].setPoint(d10);
                    dArr[0] = this.mArcs[i10].getDX();
                    dArr[1] = this.mArcs[i10].getDY();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d10, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        if (d10 < arcArr[0].mTime1) {
            d10 = arcArr[0].mTime1;
        } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        int i10 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i10 >= arcArr2.length) {
                return;
            }
            if (d10 <= arcArr2[i10].mTime2) {
                if (arcArr2[i10].linear) {
                    fArr[0] = (float) arcArr2[i10].getLinearX(d10);
                    fArr[1] = (float) this.mArcs[i10].getLinearY(d10);
                    return;
                } else {
                    arcArr2[i10].setPoint(d10);
                    fArr[0] = (float) this.mArcs[i10].getX();
                    fArr[1] = (float) this.mArcs[i10].getY();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d10, int i10) {
        Arc[] arcArr = this.mArcs;
        int i11 = 0;
        if (d10 < arcArr[0].mTime1) {
            d10 = arcArr[0].mTime1;
        }
        if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i11 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d10 <= arcArr2[i11].mTime2) {
                if (arcArr2[i11].linear) {
                    if (i10 == 0) {
                        return arcArr2[i11].getLinearDX(d10);
                    }
                    return arcArr2[i11].getLinearDY(d10);
                }
                arcArr2[i11].setPoint(d10);
                if (i10 == 0) {
                    return this.mArcs[i11].getDX();
                }
                return this.mArcs[i11].getDY();
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d10, int i10) {
        Arc[] arcArr = this.mArcs;
        int i11 = 0;
        if (d10 < arcArr[0].mTime1) {
            d10 = arcArr[0].mTime1;
        } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i11 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d10 <= arcArr2[i11].mTime2) {
                if (arcArr2[i11].linear) {
                    if (i10 == 0) {
                        return arcArr2[i11].getLinearX(d10);
                    }
                    return arcArr2[i11].getLinearY(d10);
                }
                arcArr2[i11].setPoint(d10);
                if (i10 == 0) {
                    return this.mArcs[i11].getX();
                }
                return this.mArcs[i11].getY();
            }
            i11++;
        }
    }
}
