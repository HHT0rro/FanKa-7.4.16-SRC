package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    public long last_time;
    public CurveFit mCurveFit;
    private String mType;
    public int mWaveShape = 0;
    public int[] mTimePoints = new int[10];
    public float[][] mValues = (float[][]) Array.newInstance((Class<?>) float.class, 10, 3);
    private float[] mCache = new float[3];
    public boolean mContinue = false;
    public float last_cycle = Float.NaN;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setAlpha(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        public String mAttributeName;
        public float[] mCache;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;
        public SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            this.mCurveFit.getPos(f10, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f13 = (float) ((this.last_cycle + ((j11 * 1.0E-9d) * f11)) % 1.0d);
            this.last_cycle = f13;
            this.last_time = j10;
            float calcWave = calcWave(f13);
            this.mContinue = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.mContinue;
                float[] fArr3 = this.mTempValues;
                this.mContinue = z10 | (((double) fArr3[i10]) != ShadowDrawableWrapper.COS_45);
                fArr2[i10] = (fArr3[i10] * calcWave) + f12;
                i10++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f11 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i10) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i11 = noOfInterpValues + 2;
            this.mTempValues = new float[i11];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i12);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i12);
                float[] valueAt2 = this.mWaveProperties.valueAt(i12);
                dArr[i12] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i13 = 0;
                while (true) {
                    if (i13 < this.mTempValues.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                dArr2[i12][noOfInterpValues] = valueAt2[0];
                dArr2[i12][noOfInterpValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }

        public void setPoint(int i10, ConstraintAttribute constraintAttribute, float f10, int i11, float f11) {
            this.mConstraintAttributeList.append(i10, constraintAttribute);
            this.mWaveProperties.append(i10, new float[]{f10, f11});
            this.mWaveShape = Math.max(this.mWaveShape, i11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ElevationSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setElevation(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class PathRotate extends TimeCycleSplineSet {
        public boolean setPathRotate(View view, KeyCache keyCache, float f10, long j10, double d10, double d11) {
            view.setRotation(get(f10, j10, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ProgressSet extends TimeCycleSplineSet {
        public boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f10, j10, view, keyCache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f10, j10, view, keyCache)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RotationSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotation(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RotationXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotationX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RotationYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotationY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ScaleXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setScaleX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ScaleYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setScaleY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = i12 - 1;
                int i14 = iArr2[i13];
                i12 = i13 - 1;
                int i15 = iArr2[i12];
                if (i14 < i15) {
                    int partition = partition(iArr, fArr, i14, i15);
                    int i16 = i12 + 1;
                    iArr2[i12] = partition - 1;
                    int i17 = i16 + 1;
                    iArr2[i16] = i14;
                    int i18 = i17 + 1;
                    iArr2[i17] = i15;
                    i12 = i18 + 1;
                    iArr2[i18] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    swap(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            swap(iArr, fArr, i13, i11);
            return i13;
        }

        private static void swap(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float[] fArr2 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = fArr2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TranslationXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TranslationYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class TranslationZset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationZ(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x009c. Please report as an issue. */
    public static TimeCycleSplineSet makeSpline(String str, long j10) {
        TimeCycleSplineSet rotationXset;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals(Key.TRANSLATION_Z)) {
                    c4 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c4 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c4 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c4 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c4 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals(Key.ELEVATION)) {
                    c4 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                    c4 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals(Key.ALPHA)) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                rotationXset = new RotationXset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 1:
                rotationXset = new RotationYset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 2:
                rotationXset = new TranslationXset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 3:
                rotationXset = new TranslationYset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 4:
                rotationXset = new TranslationZset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 5:
                rotationXset = new ProgressSet();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 6:
                rotationXset = new ScaleXset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 7:
                rotationXset = new ScaleYset();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case '\b':
                rotationXset = new RotationSet();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case '\t':
                rotationXset = new ElevationSet();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case '\n':
                rotationXset = new PathRotate();
                rotationXset.setStartTime(j10);
                return rotationXset;
            case 11:
                rotationXset = new AlphaSet();
                rotationXset.setStartTime(j10);
                return rotationXset;
            default:
                return null;
        }
    }

    public float calcWave(float f10) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f10 * VAL_2PI);
            case 2:
                abs = Math.abs(f10);
                break;
            case 3:
                return (((f10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f10 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f10 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f10 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f10 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f10, long j10, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f10, this.mCache);
        float[] fArr = this.mCache;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f12 = (float) ((this.last_cycle + (((j10 - this.last_time) * 1.0E-9d) * f11)) % 1.0d);
        this.last_cycle = f12;
        keyCache.setFloatValue(view, this.mType, 0, f12);
        this.last_time = j10;
        float f13 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f13) + this.mCache[2];
        this.mContinue = (f13 == 0.0f && f11 == 0.0f) ? false : true;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i10, float f10, float f11, int i11, float f12) {
        int[] iArr = this.mTimePoints;
        int i12 = this.count;
        iArr[i12] = i10;
        float[][] fArr = this.mValues;
        fArr[i12][0] = f10;
        fArr[i12][1] = f11;
        fArr[i12][2] = f12;
        this.mWaveShape = Math.max(this.mWaveShape, i11);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f10, long j10, KeyCache keyCache);

    public void setStartTime(long j10) {
        this.last_time = j10;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i10) {
        int i11;
        int i12 = this.count;
        if (i12 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error no points added to ");
            sb2.append(this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i12 - 1);
        int i13 = 1;
        int i14 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i13 >= iArr.length) {
                break;
            }
            if (iArr[i13] != iArr[i13 - 1]) {
                i14++;
            }
            i13++;
        }
        if (i14 == 0) {
            i14 = 1;
        }
        double[] dArr = new double[i14];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, i14, 3);
        int i15 = 0;
        while (i11 < this.count) {
            if (i11 > 0) {
                int[] iArr2 = this.mTimePoints;
                i11 = iArr2[i11] == iArr2[i11 + (-1)] ? i11 + 1 : 0;
            }
            dArr[i15] = this.mTimePoints[i11] * 0.01d;
            double[] dArr3 = dArr2[i15];
            float[][] fArr = this.mValues;
            dArr3[0] = fArr[i11][0];
            dArr2[i15][1] = fArr[i11][1];
            dArr2[i15][2] = fArr[i11][2];
            i15++;
        }
        this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.count; i10++) {
            str = str + "[" + this.mTimePoints[i10] + " , " + decimalFormat.format(this.mValues[i10]) + "] ";
        }
        return str;
    }
}
