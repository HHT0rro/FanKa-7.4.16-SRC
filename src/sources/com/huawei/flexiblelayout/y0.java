package com.huawei.flexiblelayout;

import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import java.util.zip.ZipUtils;

/* compiled from: Numbers.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class y0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f28674a = {Double.class, Float.class, Long.class, Integer.class, Short.class, Byte.class};

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f28675b = {Double.TYPE, Float.TYPE, Long.TYPE, Integer.TYPE, Short.TYPE, Byte.TYPE};

    public static int a(Class<?> cls) {
        int i10 = 0;
        while (true) {
            Class<?>[] clsArr = f28674a;
            if (i10 >= clsArr.length) {
                return -1;
            }
            if (cls == clsArr[i10] || cls == f28675b[i10]) {
                break;
            }
            i10++;
        }
        return i10;
    }

    public static int b(Number number, Number number2) throws ExprException {
        int min = Math.min(a(number.getClass()), a(number2.getClass()));
        if (min == 0) {
            return Double.compare(number.doubleValue(), number2.doubleValue());
        }
        if (min == 1) {
            return Float.compare(number.floatValue(), number2.floatValue());
        }
        if (min == 2) {
            return Long.compare(number.longValue(), number2.longValue());
        }
        if (min == 3) {
            return Integer.compare(number.intValue(), number2.intValue());
        }
        if (min == 4) {
            return Short.compare(number.shortValue(), number2.shortValue());
        }
        if (min == 5) {
            return Byte.compare(number.byteValue(), number2.byteValue());
        }
        throw new ExprException("Unsupported type, left: " + ((Object) number.getClass()) + ", right: " + ((Object) number2.getClass()) + ".");
    }

    public static Number c(Number number, Number number2) throws ExprException {
        int min = Math.min(a(number.getClass()), a(number2.getClass()));
        if (min == 0) {
            return Double.valueOf(number.doubleValue() / number2.doubleValue());
        }
        if (min == 1) {
            return Float.valueOf(number.floatValue() / number2.floatValue());
        }
        if (min == 2) {
            return Long.valueOf(number.longValue() / number2.longValue());
        }
        if (min == 3) {
            return Integer.valueOf(number.intValue() / number2.intValue());
        }
        if (min == 4) {
            return Integer.valueOf(number.shortValue() / number2.shortValue());
        }
        if (min == 5) {
            return Integer.valueOf(number.byteValue() / number2.byteValue());
        }
        throw new ExprException("Unsupported type, left: " + ((Object) number.getClass()) + ", right: " + ((Object) number2.getClass()) + ".");
    }

    public static Number d(Number number, Number number2) throws ExprException {
        int min = Math.min(a(number.getClass()), a(number2.getClass()));
        if (min == 0) {
            return Double.valueOf(number.doubleValue() % number2.doubleValue());
        }
        if (min == 1) {
            return Float.valueOf(number.floatValue() % number2.floatValue());
        }
        if (min == 2) {
            return Long.valueOf(number.longValue() % number2.longValue());
        }
        if (min == 3) {
            return Integer.valueOf(number.intValue() % number2.intValue());
        }
        if (min == 4) {
            return Integer.valueOf(number.shortValue() % number2.shortValue());
        }
        if (min == 5) {
            return Integer.valueOf(number.byteValue() % number2.byteValue());
        }
        throw new ExprException("Unsupported type, left: " + ((Object) number.getClass()) + ", right: " + ((Object) number2.getClass()) + ".");
    }

    public static Number e(Number number, Number number2) throws ExprException {
        int min = Math.min(a(number.getClass()), a(number2.getClass()));
        if (min == 0) {
            return Double.valueOf(number.doubleValue() * number2.doubleValue());
        }
        if (min == 1) {
            return Float.valueOf(number.floatValue() * number2.floatValue());
        }
        if (min == 2) {
            return Long.valueOf(number.longValue() * number2.longValue());
        }
        if (min == 3) {
            return Integer.valueOf(number.intValue() * number2.intValue());
        }
        if (min == 4) {
            return Integer.valueOf(number.shortValue() * number2.shortValue());
        }
        if (min == 5) {
            return Integer.valueOf(number.byteValue() * number2.byteValue());
        }
        throw new ExprException("Unsupported type, left: " + ((Object) number.getClass()) + ", right: " + ((Object) number2.getClass()) + ".");
    }

    public static Number f(Number number, Number number2) throws ExprException {
        int min = Math.min(a(number.getClass()), a(number2.getClass()));
        if (min == 0) {
            return Double.valueOf(number.doubleValue() - number2.doubleValue());
        }
        if (min == 1) {
            return Float.valueOf(number.floatValue() - number2.floatValue());
        }
        if (min == 2) {
            return Long.valueOf(number.longValue() - number2.longValue());
        }
        if (min == 3) {
            return Integer.valueOf(number.intValue() - number2.intValue());
        }
        if (min == 4) {
            return Integer.valueOf(number.shortValue() - number2.shortValue());
        }
        if (min == 5) {
            return Integer.valueOf(number.byteValue() - number2.byteValue());
        }
        throw new ExprException("Unsupported type, left: " + ((Object) number.getClass()) + ", right: " + ((Object) number2.getClass()) + ".");
    }

    public static Number a(Number number, Number number2) throws ExprException {
        int min = Math.min(a(number.getClass()), a(number2.getClass()));
        if (min == 0) {
            return Double.valueOf(number.doubleValue() + number2.doubleValue());
        }
        if (min == 1) {
            return Float.valueOf(number.floatValue() + number2.floatValue());
        }
        if (min == 2) {
            return Long.valueOf(number.longValue() + number2.longValue());
        }
        if (min == 3) {
            return Integer.valueOf(number.intValue() + number2.intValue());
        }
        if (min == 4) {
            return Integer.valueOf(number.shortValue() + number2.shortValue());
        }
        if (min == 5) {
            return Integer.valueOf(number.byteValue() + number2.byteValue());
        }
        throw new ExprException("Unsupported type, left: " + ((Object) number.getClass()) + ", right: " + ((Object) number2.getClass()) + ".");
    }

    @Nullable
    public static Number a(String str) {
        try {
            if (str.indexOf(46) != -1) {
                return Double.valueOf(str);
            }
            long parseLong = Long.parseLong(str);
            if (parseLong <= ZipUtils.UPPER_UNIXTIME_BOUND && parseLong >= -2147483648L) {
                return Integer.valueOf((int) parseLong);
            }
            return Long.valueOf(parseLong);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
