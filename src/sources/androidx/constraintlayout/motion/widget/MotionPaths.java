package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;
import java.util.LinkedHashMap;
import sun.util.locale.LanguageTag;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int OFF_HEIGHT = 4;
    public static final int OFF_PATH_ROTATE = 5;
    public static final int OFF_POSITION = 0;
    public static final int OFF_WIDTH = 3;
    public static final int OFF_X = 1;
    public static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    public static String[] names = {"position", LanguageTag.PRIVATEUSE, "y", "width", "height", "pathRotate"};
    public LinkedHashMap<String, ConstraintAttribute> attributes;
    public float height;
    public int mDrawPath;
    public Easing mKeyFrameEasing;
    public int mMode;
    public int mPathMotionArc;
    public float mPathRotate;
    public float mProgress;
    public double[] mTempDelta;
    public double[] mTempValue;
    public float position;
    public float time;
    public float width;

    /* renamed from: x, reason: collision with root package name */
    public float f858x;

    /* renamed from: y, reason: collision with root package name */
    public float f859y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    private static final float xRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        return (((f14 - f12) * f11) - ((f15 - f13) * f10)) + f12;
    }

    private static final float yRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        return ((f14 - f12) * f10) + ((f15 - f13) * f11) + f13;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.h()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z10) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.f858x, motionPaths.f858x) | z10;
        zArr[2] = z10 | diff(this.f859y, motionPaths.f859y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f858x, this.f859y, this.width, this.height, this.mPathRotate};
        int i10 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] < 6) {
                dArr[i10] = fArr[iArr[i11]];
                i10++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.width;
        float f11 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        fArr[i10] = f10;
        fArr[i10 + 1] = f11;
    }

    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f858x;
        float f11 = this.f859y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        fArr[i10] = f10 + (f12 / 2.0f) + 0.0f;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i10) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i10] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        constraintAttribute.getValuesToInterpolate(new float[noOfInterpValues]);
        int i11 = 0;
        while (i11 < noOfInterpValues) {
            dArr[i10] = r1[i11];
            i11++;
            i10++;
        }
        return noOfInterpValues;
    }

    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f858x;
        float f11 = this.f859y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        float f15 = f12 + f10;
        float f16 = f13 + f11;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i13 = i10 + 1;
        fArr[i10] = f10 + 0.0f;
        int i14 = i13 + 1;
        fArr[i13] = f11 + 0.0f;
        int i15 = i14 + 1;
        fArr[i14] = f15 + 0.0f;
        int i16 = i15 + 1;
        fArr[i15] = f11 + 0.0f;
        int i17 = i16 + 1;
        fArr[i16] = f15 + 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = f16 + 0.0f;
        fArr[i18] = f10 + 0.0f;
        fArr[i18 + 1] = f16 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = keyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = keyPosition.mDrawPath;
        float f11 = Float.isNaN(keyPosition.mPercentWidth) ? f10 : keyPosition.mPercentWidth;
        float f12 = Float.isNaN(keyPosition.mPercentHeight) ? f10 : keyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = motionPaths2.height;
        float f16 = motionPaths.height;
        this.position = this.time;
        float f17 = motionPaths.f858x;
        float f18 = motionPaths.f859y;
        float f19 = (motionPaths2.f858x + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (motionPaths2.f859y + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = ((f13 - f14) * f11) / 2.0f;
        this.f858x = (int) ((f17 + (f19 * f10)) - f21);
        float f22 = ((f15 - f16) * f12) / 2.0f;
        this.f859y = (int) ((f18 + (f20 * f10)) - f22);
        this.width = (int) (f14 + r9);
        this.height = (int) (f16 + r12);
        float f23 = Float.isNaN(keyPosition.mPercentX) ? f10 : keyPosition.mPercentX;
        float f24 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f10 = keyPosition.mPercentY;
        }
        float f25 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 2;
        this.f858x = (int) (((motionPaths.f858x + (f23 * f19)) + (f25 * f20)) - f21);
        this.f859y = (int) (((motionPaths.f859y + (f19 * f24)) + (f20 * f10)) - f22);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = keyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = keyPosition.mDrawPath;
        float f11 = Float.isNaN(keyPosition.mPercentWidth) ? f10 : keyPosition.mPercentWidth;
        float f12 = Float.isNaN(keyPosition.mPercentHeight) ? f10 : keyPosition.mPercentHeight;
        float f13 = motionPaths2.width - motionPaths.width;
        float f14 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f10 = keyPosition.mPercentX;
        }
        float f15 = motionPaths.f858x;
        float f16 = motionPaths.width;
        float f17 = motionPaths.f859y;
        float f18 = motionPaths.height;
        float f19 = (motionPaths2.f858x + (motionPaths2.width / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (motionPaths2.f859y + (motionPaths2.height / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = (f13 * f11) / 2.0f;
        this.f858x = (int) ((f15 + f21) - f22);
        float f23 = f10 * f20;
        float f24 = (f14 * f12) / 2.0f;
        this.f859y = (int) ((f17 + f23) - f24);
        this.width = (int) (f16 + r7);
        this.height = (int) (f18 + r8);
        float f25 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f26 = (int) ((motionPaths.f858x + f21) - f22);
        float f27 = (int) ((motionPaths.f859y + f23) - f24);
        this.f858x = f26 + ((-f20) * f25);
        this.f859y = f27 + (f19 * f25);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i10, int i11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = keyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = keyPosition.mDrawPath;
        float f11 = Float.isNaN(keyPosition.mPercentWidth) ? f10 : keyPosition.mPercentWidth;
        float f12 = Float.isNaN(keyPosition.mPercentHeight) ? f10 : keyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = motionPaths2.height;
        float f16 = motionPaths.height;
        this.position = this.time;
        float f17 = motionPaths.f858x;
        float f18 = motionPaths.f859y;
        float f19 = motionPaths2.f858x + (f13 / 2.0f);
        float f20 = motionPaths2.f859y + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f858x = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f859y = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.width = (int) (f14 + f21);
        this.height = (int) (f16 + f22);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f858x = (int) (keyPosition.mPercentX * ((int) (i10 - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f859y = (int) (keyPosition.mPercentY * ((int) (i11 - this.height)));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f10, float f11, float f12, float f13) {
        this.f858x = f10;
        this.f859y = f11;
        this.width = f12;
        this.height = f13;
    }

    public void setDpDt(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f10;
        float f11 = this.f858x;
        float f12 = this.f859y;
        float f13 = this.width;
        float f14 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i10];
            this.mTempDelta = new double[i10];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.mTempValue[iArr[i11]] = dArr[i11];
            this.mTempDelta[iArr[i11]] = dArr2[i11];
        }
        int i12 = 0;
        float f15 = Float.NaN;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        while (true) {
            double[] dArr4 = this.mTempValue;
            if (i12 >= dArr4.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr4[i12]);
            double d10 = ShadowDrawableWrapper.COS_45;
            if (isNaN && (dArr3 == null || dArr3[i12] == ShadowDrawableWrapper.COS_45)) {
                f10 = f11;
            } else {
                if (dArr3 != null) {
                    d10 = dArr3[i12];
                }
                if (!Double.isNaN(this.mTempValue[i12])) {
                    d10 = this.mTempValue[i12] + d10;
                }
                f10 = f11;
                float f20 = (float) d10;
                float f21 = (float) this.mTempDelta[i12];
                if (i12 == 1) {
                    f16 = f21;
                    f11 = f20;
                } else if (i12 == 2) {
                    f12 = f20;
                    f18 = f21;
                } else if (i12 == 3) {
                    f13 = f20;
                    f17 = f21;
                } else if (i12 == 4) {
                    f14 = f20;
                    f19 = f21;
                } else if (i12 == 5) {
                    f11 = f10;
                    f15 = f20;
                }
                i12++;
            }
            f11 = f10;
            i12++;
        }
        float f22 = f11;
        if (Float.isNaN(f15)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            view.setRotation((float) ((Float.isNaN(Float.NaN) ? 0.0f : Float.NaN) + f15 + Math.toDegrees(Math.atan2(f18 + (f19 / 2.0f), f16 + (f17 / 2.0f)))));
        }
        float f23 = f22 + 0.5f;
        int i13 = (int) f23;
        float f24 = f12 + 0.5f;
        int i14 = (int) f24;
        int i15 = (int) (f23 + f13);
        int i16 = (int) (f24 + f14);
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        if ((i17 == view.getMeasuredWidth() && i18 == view.getMeasuredHeight()) ? false : true) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        view.layout(i13, i14, i15, i16);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i10, int i11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i12 = keyPosition.mPositionType;
        if (i12 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i12 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i10, i11, keyPosition, motionPaths, motionPaths2);
        }
    }
}
