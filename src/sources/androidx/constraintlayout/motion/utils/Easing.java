package androidx.constraintlayout.motion.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    public String str = "identity";
    public static Easing sDefault = new Easing();
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    public static String[] NAMED_EASING = {"standard", ACCELERATE_NAME, DECELERATE_NAME, "linear"};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new CubicEasing(ACCELERATE);
            case 1:
                return new CubicEasing(DECELERATE);
            case 2:
                return new CubicEasing(LINEAR);
            case 3:
                return new CubicEasing(STANDARD);
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                sb2.append(Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d10) {
        return d10;
    }

    public double getDiff(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: x1, reason: collision with root package name */
        public double f852x1;

        /* renamed from: x2, reason: collision with root package name */
        public double f853x2;
        public double y1;

        /* renamed from: y2, reason: collision with root package name */
        public double f854y2;

        public CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f852x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i10 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i10);
            this.y1 = Double.parseDouble(str.substring(i10, indexOf3).trim());
            int i11 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i11);
            this.f853x2 = Double.parseDouble(str.substring(i11, indexOf4).trim());
            int i12 = indexOf4 + 1;
            this.f854y2 = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        private double getDiffX(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.f852x1;
            double d13 = this.f853x2;
            return (d11 * 3.0d * d11 * d12) + (d11 * 6.0d * d10 * (d13 - d12)) + (3.0d * d10 * d10 * (1.0d - d13));
        }

        private double getDiffY(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.y1;
            double d13 = this.f854y2;
            return (d11 * 3.0d * d11 * d12) + (d11 * 6.0d * d10 * (d13 - d12)) + (3.0d * d10 * d10 * (1.0d - d13));
        }

        private double getX(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f852x1 * d11 * d12 * d10) + (this.f853x2 * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        private double getY(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.y1 * d11 * d12 * d10) + (this.f854y2 * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d10) {
            if (d10 <= ShadowDrawableWrapper.COS_45) {
                return ShadowDrawableWrapper.COS_45;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > error) {
                d11 *= 0.5d;
                d12 = getX(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double x10 = getX(d13);
            double d14 = d12 + d11;
            double x11 = getX(d14);
            double y10 = getY(d13);
            return (((getY(d14) - y10) * (d10 - x10)) / (x11 - x10)) + y10;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > d_error) {
                d11 *= 0.5d;
                d12 = getX(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d12 + d11;
            return (getY(d14) - getY(d13)) / (getX(d14) - getX(d13));
        }

        public void setup(double d10, double d11, double d12, double d13) {
            this.f852x1 = d10;
            this.y1 = d11;
            this.f853x2 = d12;
            this.f854y2 = d13;
        }

        public CubicEasing(double d10, double d11, double d12, double d13) {
            setup(d10, d11, d12, d13);
        }
    }
}
