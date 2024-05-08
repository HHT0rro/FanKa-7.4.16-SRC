package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    public static double f4930a = 3.141592653589793d;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f4933d;

    /* renamed from: e, reason: collision with root package name */
    private static final double[] f4934e = {25.575374d, 120.391111d};

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f4935f = {21.405235d, 121.649046d};

    /* renamed from: g, reason: collision with root package name */
    private static final List<LatLng> f4936g = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    /* renamed from: b, reason: collision with root package name */
    public static double f4931b = 6378245.0d;

    /* renamed from: c, reason: collision with root package name */
    public static double f4932c = 0.006693421622965943d;

    public static LatLng a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!dq.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        DPoint a10 = a(DPoint.obtain(latLng.longitude, latLng.latitude), f4933d);
        LatLng latLng2 = new LatLng(a10.f9304y, a10.f9303x, false);
        a10.recycle();
        return latLng2;
    }

    public static LatLng b(Context context, LatLng latLng) {
        try {
            if (!dq.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            DPoint c4 = c(latLng.longitude, latLng.latitude);
            LatLng a10 = a(context, new LatLng(c4.f9304y, c4.f9303x, false));
            c4.recycle();
            return a10;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static DPoint c(double d10, double d11) {
        double d12 = ((long) (d10 * 100000.0d)) % 36000000;
        double d13 = ((long) (d11 * 100000.0d)) % 36000000;
        return DPoint.obtain(((int) (((-a((int) ((-a(d12, d13)) + d12), (int) ((-b(d12, d13)) + d13))) + d12) + (d12 > ShadowDrawableWrapper.COS_45 ? 1 : -1))) / 100000.0d, ((int) (((-b(r11, r2)) + d13) + (d13 <= ShadowDrawableWrapper.COS_45 ? -1 : 1))) / 100000.0d);
    }

    private static DPoint d(double d10, double d11) {
        DPoint obtain = DPoint.obtain();
        double d12 = (d10 * d10) + (d11 * d11);
        double cos = (Math.cos(b(d10) + Math.atan2(d11, d10)) * (a(d11) + Math.sqrt(d12))) + 0.0065d;
        double sin = (Math.sin(b(d10) + Math.atan2(d11, d10)) * (a(d11) + Math.sqrt(d12))) + 0.006d;
        obtain.f9303x = c(cos);
        obtain.f9304y = c(sin);
        return obtain;
    }

    private static DPoint e(double d10, double d11) {
        DPoint dPoint = null;
        double d12 = 0.006401062d;
        double d13 = 0.0060424805d;
        for (int i10 = 0; i10 < 2; i10++) {
            dPoint = a(d10, d11, d12, d13);
            d12 = d10 - dPoint.f9303x;
            d13 = d11 - dPoint.f9304y;
        }
        return dPoint;
    }

    private static boolean f(double d10, double d11) {
        return dx.a(new LatLng(d10, d11), f4936g);
    }

    private static LatLng g(double d10, double d11) {
        LatLng h10 = h(d10, d11);
        return new LatLng((d10 * 2.0d) - h10.latitude, (d11 * 2.0d) - h10.longitude);
    }

    private static LatLng h(double d10, double d11) {
        double d12 = d11 - 105.0d;
        double d13 = d10 - 35.0d;
        double i10 = i(d12, d13);
        double j10 = j(d12, d13);
        double d14 = (d10 / 180.0d) * f4930a;
        double sin = Math.sin(d14);
        double d15 = 1.0d - ((f4932c * sin) * sin);
        double sqrt = Math.sqrt(d15);
        double d16 = f4931b;
        return new LatLng(d10 + ((i10 * 180.0d) / ((((1.0d - f4932c) * d16) / (d15 * sqrt)) * f4930a)), d11 + ((j10 * 180.0d) / (((d16 / sqrt) * Math.cos(d14)) * f4930a)));
    }

    private static double i(double d10, double d11) {
        double d12 = d10 * 2.0d;
        return (-100.0d) + d12 + (d11 * 3.0d) + (d11 * 0.2d * d11) + (0.1d * d10 * d11) + (Math.sqrt(Math.abs(d10)) * 0.2d) + ((((Math.sin((d10 * 6.0d) * f4930a) * 20.0d) + (Math.sin(d12 * f4930a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f4930a * d11) * 20.0d) + (Math.sin((d11 / 3.0d) * f4930a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * f4930a) * 160.0d) + (Math.sin((d11 * f4930a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double j(double d10, double d11) {
        double d12 = d10 * 0.1d;
        return d10 + 300.0d + (d11 * 2.0d) + (d12 * d10) + (d12 * d11) + (Math.sqrt(Math.abs(d10)) * 0.1d) + ((((Math.sin((6.0d * d10) * f4930a) * 20.0d) + (Math.sin((d10 * 2.0d) * f4930a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f4930a * d10) * 20.0d) + (Math.sin((d10 / 3.0d) * f4930a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 12.0d) * f4930a) * 150.0d) + (Math.sin((d10 / 30.0d) * f4930a) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static DPoint a(DPoint dPoint, boolean z10) {
        try {
            if (!dq.a(dPoint.f9304y, dPoint.f9303x)) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (!z10) {
                dArr = a.a(dPoint.f9303x, dPoint.f9304y);
            }
            dPoint.recycle();
            return DPoint.obtain(dArr[0], dArr[1]);
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    private static double b(double d10, double d11) {
        return (Math.sin(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.cos(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    private static double b(double d10) {
        return Math.cos(d10 * 3000.0d * (f4930a / 180.0d)) * 3.0E-6d;
    }

    private static double c(double d10) {
        return new BigDecimal(d10).setScale(8, 4).doubleValue();
    }

    private static double a(double d10, double d11) {
        return (Math.cos(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.sin(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            try {
                if (dq.a(latLng.latitude, latLng.longitude)) {
                    DPoint e2 = e(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(e2.f9304y, e2.f9303x, false);
                    e2.recycle();
                    return latLng2;
                }
                if (!f(latLng.latitude, latLng.longitude)) {
                    return latLng;
                }
                DPoint e10 = e(latLng.longitude, latLng.latitude);
                return g(e10.f9304y, e10.f9303x);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static double a(double d10) {
        return Math.sin(d10 * 3000.0d * (f4930a / 180.0d)) * 2.0E-5d;
    }

    private static DPoint a(double d10, double d11, double d12, double d13) {
        DPoint obtain = DPoint.obtain();
        double d14 = d10 - d12;
        double d15 = d11 - d13;
        DPoint d16 = d(d14, d15);
        obtain.f9303x = c((d10 + d14) - d16.f9303x);
        obtain.f9304y = c((d11 + d15) - d16.f9304y);
        return obtain;
    }
}
