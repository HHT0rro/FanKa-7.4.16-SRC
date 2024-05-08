package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.location.DPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static double f9652a = 3.141592653589793d;

    /* renamed from: b, reason: collision with root package name */
    private static final List<DPoint> f9653b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return b(dPoint);
    }

    private static DPoint b(DPoint dPoint) {
        try {
            if (!b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] a10 = com.autonavi.util.a.a(dPoint.getLongitude(), dPoint.getLatitude());
            return new DPoint(a10[1], a10[0]);
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static DPoint c(double d10, double d11) {
        double d12 = ((long) (d10 * 100000.0d)) % 36000000;
        double d13 = ((long) (d11 * 100000.0d)) % 36000000;
        return new DPoint(((int) (((-b(r11, r2)) + d13) + (d13 <= ShadowDrawableWrapper.COS_45 ? -1 : 1))) / 100000.0d, ((int) (((-a((int) ((-a(d12, d13)) + d12), (int) ((-b(d12, d13)) + d13))) + d12) + (d12 > ShadowDrawableWrapper.COS_45 ? 1 : -1))) / 100000.0d);
    }

    private static DPoint d(double d10, double d11) {
        DPoint dPoint = new DPoint();
        double d12 = (d10 * d10) + (d11 * d11);
        double cos = (Math.cos(b(d10) + Math.atan2(d11, d10)) * (a(d11) + Math.sqrt(d12))) + 0.0065d;
        double sin = (Math.sin(b(d10) + Math.atan2(d11, d10)) * (a(d11) + Math.sqrt(d12))) + 0.006d;
        dPoint.setLongitude(c(cos));
        dPoint.setLatitude(c(sin));
        return dPoint;
    }

    private static boolean e(double d10, double d11) {
        return b.a(new DPoint(d10, d11), f9653b);
    }

    private static DPoint f(double d10, double d11) {
        DPoint g3 = g(d10, d11);
        return new DPoint((d10 * 2.0d) - g3.getLatitude(), (d11 * 2.0d) - g3.getLongitude());
    }

    private static DPoint g(double d10, double d11) {
        double d12 = d11 - 105.0d;
        double d13 = d10 - 35.0d;
        double h10 = h(d12, d13);
        double i10 = i(d12, d13);
        double d14 = (d10 / 180.0d) * f9652a;
        double sin = Math.sin(d14);
        double d15 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d15);
        return new DPoint(d10 + ((h10 * 180.0d) / ((6335552.717000426d / (d15 * sqrt)) * f9652a)), d11 + ((i10 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d14)) * f9652a)));
    }

    private static double h(double d10, double d11) {
        double d12 = d10 * 2.0d;
        return (-100.0d) + d12 + (d11 * 3.0d) + (d11 * 0.2d * d11) + (0.1d * d10 * d11) + (Math.sqrt(Math.abs(d10)) * 0.2d) + ((((Math.sin((d10 * 6.0d) * f9652a) * 20.0d) + (Math.sin(d12 * f9652a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f9652a * d11) * 20.0d) + (Math.sin((d11 / 3.0d) * f9652a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * f9652a) * 160.0d) + (Math.sin((d11 * f9652a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double i(double d10, double d11) {
        double d12 = d10 * 0.1d;
        return d10 + 300.0d + (d11 * 2.0d) + (d12 * d10) + (d12 * d11) + (Math.sqrt(Math.abs(d10)) * 0.1d) + ((((Math.sin((6.0d * d10) * f9652a) * 20.0d) + (Math.sin((d10 * 2.0d) * f9652a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f9652a * d10) * 20.0d) + (Math.sin((d10 / 3.0d) * f9652a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 12.0d) * f9652a) * 150.0d) + (Math.sin((d10 / 30.0d) * f9652a) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static double a(double d10, double d11) {
        return (Math.cos(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.sin(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return c(dPoint);
                }
                if (!e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return dPoint;
                }
                DPoint c4 = c(dPoint);
                return f(c4.getLatitude(), c4.getLongitude());
            } catch (Throwable th) {
                b.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            return !b.a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : a(context, c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static double c(double d10) {
        return new BigDecimal(d10).setScale(8, 4).doubleValue();
    }

    private static double a(double d10) {
        return Math.sin(d10 * 3000.0d * (f9652a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d10, double d11) {
        return (Math.sin(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.cos(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    private static DPoint a(double d10, double d11, double d12, double d13) {
        DPoint dPoint = new DPoint();
        double d14 = d10 - d12;
        double d15 = d11 - d13;
        DPoint d16 = d(d14, d15);
        dPoint.setLongitude(c((d10 + d14) - d16.getLongitude()));
        dPoint.setLatitude(c((d11 + d15) - d16.getLatitude()));
        return dPoint;
    }

    private static double b(double d10) {
        return Math.cos(d10 * 3000.0d * (f9652a / 180.0d)) * 3.0E-6d;
    }

    private static DPoint c(DPoint dPoint) {
        DPoint dPoint2 = null;
        double d10 = 0.006401062d;
        double d11 = 0.0060424805d;
        for (int i10 = 0; i10 < 2; i10++) {
            dPoint2 = a(dPoint.getLongitude(), dPoint.getLatitude(), d10, d11);
            d10 = dPoint.getLongitude() - dPoint2.getLongitude();
            d11 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }
}
