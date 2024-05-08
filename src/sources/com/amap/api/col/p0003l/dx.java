package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.amap.api.col.p0003l.fu;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: Util.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dx {

    /* renamed from: a, reason: collision with root package name */
    private static FPoint[] f5391a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};

    /* renamed from: b, reason: collision with root package name */
    private static List<Float> f5392b = new ArrayList(4);

    /* renamed from: c, reason: collision with root package name */
    private static List<Float> f5393c = new ArrayList(4);

    /* renamed from: d, reason: collision with root package name */
    private static int f5394d = 0;

    private static double a(double d10, double d11, double d12, double d13, double d14, double d15) {
        return ((d12 - d10) * (d15 - d11)) - ((d14 - d10) * (d13 - d11));
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = dr.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            gy.b(th, "Util", "fromAsset");
            a(th);
            return null;
        }
    }

    public static void a(Bitmap bitmap) {
    }

    private static boolean a(double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d12 - d10;
        double d18 = d16 - d15;
        double d19 = d13 - d11;
        double d20 = 180.0d - d14;
        double d21 = (d17 * d18) - (d19 * d20);
        if (d21 != ShadowDrawableWrapper.COS_45) {
            double d22 = d11 - d15;
            double d23 = d10 - d14;
            double d24 = ((d20 * d22) - (d18 * d23)) / d21;
            double d25 = ((d22 * d17) - (d23 * d19)) / d21;
            if (d24 >= ShadowDrawableWrapper.COS_45 && d24 <= 1.0d && d25 >= ShadowDrawableWrapper.COS_45 && d25 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(int i10, int i11) {
        return i10 > 0 && i11 > 0;
    }

    public static String b(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb2.append(str);
        sb2.append("data");
        sb2.append(str);
        return sb2.toString();
    }

    public static String c(Context context) {
        String a10 = a(context);
        if (a10 == null) {
            return null;
        }
        File file = new File(a10, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static boolean e(Context context) {
        File file = new File(b(context));
        if (file.exists()) {
            return FileUtil.deleteFile(file);
        }
        return true;
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static boolean b(double d10, double d11, double d12, double d13, double d14, double d15) {
        return Math.abs(a(d10, d11, d12, d13, d14, d15)) < 1.0E-9d && (d10 - d12) * (d10 - d14) <= ShadowDrawableWrapper.COS_45 && (d11 - d13) * (d11 - d15) <= ShadowDrawableWrapper.COS_45;
    }

    private static void c(View view) {
        int i10 = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
            }
        } else {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i10 >= viewGroup.getChildCount()) {
                    return;
                }
                c(viewGroup.getChildAt(i10));
                i10++;
            }
        }
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private static Pair<Float, Boolean> b(IMapConfig iMapConfig, int i10, int i11, int i12, int i13, int i14, int i15) {
        float min;
        iMapConfig.getSZ();
        if (i10 == i12 && i11 == i13) {
            min = iMapConfig.getMaxZoomLevel();
        } else {
            float a10 = (float) a(iMapConfig.getMapZoomScale(), i15, Math.abs(i13 - i11));
            float a11 = (float) a(iMapConfig.getMapZoomScale(), i14, Math.abs(i12 - i10));
            float min2 = Math.min(a11, a10);
            r0 = min2 == a11;
            min = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        return new Pair<>(Float.valueOf(min), Boolean.valueOf(r0));
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static float a(IMapConfig iMapConfig, float f10, float f11) {
        boolean z10;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            z10 = iMapConfig.getAbroadState() != 1;
            r0 = isAbroadEnable;
        } else {
            z10 = false;
        }
        float f12 = f10 >= 0.0f ? f10 : 0.0f;
        if (r0 && z10) {
            if (f12 > 40.0f) {
                return 40.0f;
            }
            return f12;
        }
        if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            if (f12 > 80.0f) {
                return 80.0f;
            }
            return f12;
        }
        if (f10 <= 40.0f) {
            return f12;
        }
        float f13 = f11 <= 15.0f ? 40 : f11 <= 16.0f ? 56 : f11 <= 17.0f ? 66 : f11 <= 18.0f ? 74 : f11 <= 18.0f ? 78 : 80;
        return f12 > f13 ? f13 : f12;
    }

    public static float a(IMapConfig iMapConfig, float f10) {
        if (iMapConfig != null) {
            if (f10 > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            return f10 < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f10;
        }
        if (f10 > 20.0f) {
            return 20.0f;
        }
        if (f10 < 3.0f) {
            return 3.0f;
        }
        return f10;
    }

    private static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
    }

    public static String a(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (String str : strArr) {
            sb2.append(str);
            if (i10 != strArr.length - 1) {
                sb2.append(",");
            }
            i10++;
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i10;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                arrayList.add(list.get(i11));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i12 = 0;
            while (i12 < arrayList.size() && (i10 = i12 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i12)) && circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i10))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i12));
                    arrayList2.add(arrayList.get(i10));
                    if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                        return true;
                    }
                    i12 = i10;
                }
                return true;
            }
        } catch (Throwable th) {
            gy.b(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f10) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f10), (int) (bitmap.getHeight() * f10), true);
    }

    public static String a(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.toString());
        String str = File.separator;
        sb2.append(str);
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    public static String a(int i10) {
        if (i10 < 1000) {
            return i10 + "m";
        }
        return (i10 / 1000) + "km";
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), "utf-8");
        } catch (Throwable th) {
            gy.b(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    private static boolean b(List<LatLng> list, List<LatLng> list2) {
        int i10;
        int i11;
        int i12 = 0;
        while (i12 < list.size() && (i10 = i12 + 1) < list.size()) {
            try {
                int i13 = 0;
                while (i13 < list2.size() && (i11 = i13 + 1) < list2.size()) {
                    boolean a10 = ds.a(list.get(i12), list.get(i10), list2.get(i13), list2.get(i11));
                    if (a10) {
                        return a10;
                    }
                    i13 = i11;
                }
                i12 = i10;
            } catch (Throwable th) {
                gy.b(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00de A[Catch: IOException -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #19 {IOException -> 0x00e2, blocks: (B:86:0x00de, B:96:0x00cd), top: B:83:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r7) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.dx.a(java.io.File):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        int i10 = 0;
        if (list == null || polygonHoleOptions == null) {
            return false;
        }
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            boolean z10 = 0;
            while (i10 < points.size()) {
                try {
                    boolean a10 = a(points.get(i10), list);
                    if (!a10) {
                        return a10;
                    }
                    i10++;
                    z10 = a10;
                } catch (Throwable th) {
                    th = th;
                    i10 = z10;
                    gy.b(th, "PolygonDelegateImp", "isPolygonInPolygon");
                    th.printStackTrace();
                    return i10;
                }
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(View view) {
        StringBuilder sb2 = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb2 = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        String b4 = b(((ViewGroup) view).getChildAt(i10));
                        if (!TextUtils.isEmpty(b4)) {
                            sb2.append("--");
                            sb2.append(b4);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb2.toString();
    }

    public static synchronized int b() {
        int i10;
        synchronized (dx.class) {
            int i11 = f5394d + 1;
            f5394d = i11;
            if (i11 == Integer.MAX_VALUE) {
                f5394d = 0;
            }
            i10 = f5394d;
        }
        return i10;
    }

    public static boolean a(LatLng latLng, List<LatLng> list) {
        boolean z10;
        if (latLng == null || list == null) {
            return false;
        }
        double d10 = latLng.longitude;
        double d11 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z10 = false;
        } else {
            list.add(list.get(0));
            z10 = true;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size() - 1) {
            try {
                double d12 = list.get(i10).longitude;
                double d13 = list.get(i10).latitude;
                i10++;
                double d14 = list.get(i10).longitude;
                double d15 = list.get(i10).latitude;
                double d16 = d11;
                double d17 = d10;
                if (b(d10, d11, d12, d13, d14, d15)) {
                    return true;
                }
                if (Math.abs(d15 - d13) >= 1.0E-9d) {
                    if (b(d12, d13, d17, d16, 180.0d, d16)) {
                        if (d13 <= d15) {
                        }
                        i11++;
                    } else if (b(d14, d15, d17, d16, 180.0d, d16)) {
                        if (d15 > d13) {
                            i11++;
                        }
                    } else if (a(d12, d13, d14, d15, d17, d16, d16)) {
                        i11++;
                    }
                }
                d11 = d16;
                d10 = d17;
            } finally {
                if (z10) {
                    list.remove(list.size() - 1);
                }
            }
        }
        boolean z11 = i11 % 2 != 0;
        if (z10) {
            list.remove(list.size() - 1);
        }
        return z11;
    }

    public static boolean a(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    public static fu a() {
        try {
            if (w.f6966e == null) {
                w.f6966e = new fu.a("3dmap", "9.8.3", w.f6964c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("9.8.3").a();
            }
            return w.f6966e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap a(View view) {
        try {
            c(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            gy.b(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double d10 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(d10 * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static boolean a(Rect rect, int i10, int i11) {
        return rect.contains(i10, i11);
    }

    public static Pair<Float, IPoint> a(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        return a(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> a(IMapConfig iMapConfig, int i10, int i11, int i12, int i13, LatLngBounds latLngBounds, int i14, int i15) {
        LatLng latLng;
        int i16;
        float f10;
        float f11;
        int i17;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i18 = latLongToPixels.x;
        int i19 = latLongToPixels2.x;
        int i20 = i18 - i19;
        int i21 = latLongToPixels2.y;
        int i22 = latLongToPixels.y;
        int i23 = i21 - i22;
        int i24 = i14 - (i10 + i11);
        int i25 = i15 - (i12 + i13);
        if (i20 < 0 && i23 < 0) {
            return null;
        }
        if (i20 <= 0) {
            i20 = 1;
        }
        int i26 = i23 <= 0 ? 1 : i23;
        if (i24 <= 0) {
            i24 = 1;
        }
        if (i25 <= 0) {
            i25 = 1;
        }
        Pair<Float, Boolean> b4 = b(iMapConfig, i18, i22, i19, i21, i24, i25);
        float floatValue = ((Float) b4.first).floatValue();
        boolean booleanValue = ((Boolean) b4.second).booleanValue();
        float a10 = a(iMapConfig.getMapZoomScale(), floatValue, i20);
        float a11 = a(iMapConfig.getMapZoomScale(), floatValue, i26);
        if (floatValue >= iMapConfig.getMaxZoomLevel()) {
            i16 = (int) (latLongToPixels2.x + ((((i11 - i10) + a10) * i20) / (a10 * 2.0f)));
            i17 = latLongToPixels.y;
        } else if (booleanValue) {
            i16 = (int) (latLongToPixels2.x + ((((i14 / 2) - i10) / a10) * i20));
            i17 = latLongToPixels.y;
        } else {
            i16 = (int) (latLongToPixels2.x + ((((i11 - i10) + a10) * i20) / (a10 * 2.0f)));
            f10 = latLongToPixels.y;
            f11 = (((i15 / 2) - i12) / a11) * i26;
            return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i16 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f10 + f11)) + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
        }
        f10 = i17;
        f11 = (((i13 - i12) + a11) * i26) / (a11 * 2.0f);
        return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i16 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f10 + f11)) + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
    }

    private static double a(float f10, double d10, double d11) {
        return 20.0d - (Math.log(d11 / (d10 * f10)) / Math.log(2.0d));
    }

    private static float a(float f10, float f11, double d10) {
        return (float) (d10 / (Math.pow(2.0d, 20.0f - f11) * f10));
    }

    private static float a(float f10, float f11, float f12) {
        return (float) (f12 * Math.pow(2.0d, 20.0f - f11) * f10);
    }

    public static float a(IMapConfig iMapConfig, int i10, int i11, int i12, int i13, int i14, int i15) {
        float sz = iMapConfig.getSZ();
        if (i10 == i12 || i11 == i13) {
            return sz;
        }
        return Math.max((float) a(iMapConfig.getMapZoomScale(), i14, Math.abs(i12 - i10)), (float) a(iMapConfig.getMapZoomScale(), i15, Math.abs(i13 - i11)));
    }

    public static float a(IGLMapState iGLMapState, int i10, int i11, double d10, double d11, int i12) {
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d10, d11, 20, obtain);
        float a10 = a(iGLMapState, i10, i11, ((Point) obtain).x, ((Point) obtain).y, i12);
        obtain.recycle();
        return a10;
    }

    private static float a(IGLMapState iGLMapState, int i10, int i11, int i12, int i13, int i14) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i10, i11, i12, i13, i14);
        }
        return 3.0f;
    }

    public static synchronized int[] a(int i10, int i11, int i12, int i13, IMapConfig iMapConfig, IGLMapState iGLMapState, int i14, int i15) {
        int[] iArr;
        synchronized (dx.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            iArr = new int[]{(int) Math.max(i12 + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), iMapConfig.getAnchorX()), Math.min(i14, i10 - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - r3))), (int) Math.max(i11 + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), iMapConfig.getAnchorY()), Math.min(i15, i13 - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - r4)))};
        }
        return iArr;
    }

    public static byte[] a(byte[] bArr, int i10) {
        return a(bArr, i10, i10, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        r2.setPixel(r5, r6, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r7, int r8, int r9, boolean r10) {
        /*
            int r0 = r7.length     // Catch: java.lang.Throwable -> L40
            r1 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r7, r1, r0)     // Catch: java.lang.Throwable -> L40
            android.graphics.Bitmap$Config r2 = r0.getConfig()     // Catch: java.lang.Throwable -> L40
            r3 = 1
            android.graphics.Bitmap r2 = r0.copy(r2, r3)     // Catch: java.lang.Throwable -> L40
            int r3 = r0.getWidth()     // Catch: java.lang.Throwable -> L40
            int r4 = r0.getHeight()     // Catch: java.lang.Throwable -> L40
            r5 = 0
        L18:
            if (r5 >= r3) goto L31
            r6 = 0
        L1b:
            if (r6 >= r4) goto L2e
            if (r5 == 0) goto L26
            if (r6 != 0) goto L22
            goto L26
        L22:
            r2.setPixel(r5, r6, r8)     // Catch: java.lang.Throwable -> L40
            goto L2b
        L26:
            if (r10 != 0) goto L2b
            r2.setPixel(r5, r6, r9)     // Catch: java.lang.Throwable -> L40
        L2b:
            int r6 = r6 + 1
            goto L1b
        L2e:
            int r5 = r5 + 1
            goto L18
        L31:
            byte[] r8 = b(r2)     // Catch: java.lang.Throwable -> L40
            if (r8 != 0) goto L38
            r8 = r7
        L38:
            a(r2)     // Catch: java.lang.Throwable -> L40
            a(r0)     // Catch: java.lang.Throwable -> L40
            r7 = r8
            goto L44
        L40:
            r8 = move-exception
            r8.printStackTrace()
        L44:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.dx.a(byte[], int, int, boolean):byte[]");
    }

    public static boolean a(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z10 = false;
        for (int i10 = 0; i10 < list.size(); i10++) {
            BaseHoleOptions baseHoleOptions = list.get(i10);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z10 = a(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z10) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z10 = b(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (z10) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z10;
    }

    public static boolean a(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z10 = false;
        for (int i10 = 0; i10 < list.size(); i10++) {
            BaseHoleOptions baseHoleOptions = list.get(i10);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z10 = b(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z10) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z10 = a(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z10;
    }

    private static boolean a(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            gy.b(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    private static boolean a(List<LatLng> list, List<LatLng> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            try {
                if (a(list2.get(i10), list)) {
                    return true;
                }
            } catch (Throwable th) {
                gy.b(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (a(list.get(i11), list2)) {
                return true;
            }
        }
        return b(list, list2);
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d10 = dPoint.f9303x;
        double d11 = dPoint2.f9303x;
        return (float) ((Math.atan2(dPoint2.f9304y - dPoint.f9304y, d11 - d10) / 3.141592653589793d) * 180.0d);
    }

    public static boolean a(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            if (b(list, circleHoleOptions)) {
                return false;
            }
            return a(list, list2, circleHoleOptions.getCenter());
        } catch (Throwable th) {
            gy.b(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private static boolean a(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    Iterator<BaseHoleOptions> iterator2 = list2.iterator2();
                    while (iterator2.hasNext()) {
                        if (a(iterator2.next(), latLng)) {
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                gy.b(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return a(latLng, list);
    }

    public static boolean a(double d10, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z10 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            for (int i10 = 0; i10 < points.size() && (z10 = a(d10, latLng, list, points.get(i10))); i10++) {
            }
        } catch (Throwable th) {
            gy.b(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z10;
    }

    public static boolean a(double d10, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d10 - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            gy.b(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static boolean a(double d10, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            Iterator<BaseHoleOptions> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (a(iterator2.next(), latLng2)) {
                    return false;
                }
            }
        }
        return d10 >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static void a(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getAuthority() != null && parse.getAuthority().startsWith("dualstack-")) {
                return str;
            }
            if (parse.getAuthority() != null && parse.getAuthority().startsWith("restsdk.amap.com")) {
                return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
            }
            return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static Bitmap a(int[] iArr, int i10, int i11) {
        return a(iArr, i10, i11, false);
    }

    public static Bitmap a(int[] iArr, int i10, int i11, boolean z10) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < i10; i13++) {
                    int i14 = (i12 * i10) + i13;
                    int i15 = iArr[i14];
                    int i16 = (i15 & (-16711936)) | ((i15 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i15 >> 16) & 255);
                    if (z10) {
                        iArr2[(((i11 - i12) - 1) * i10) + i13] = i16;
                    } else {
                        iArr2[i14] = i16;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i10, 0, 0, i10, i11);
            return createBitmap;
        } catch (Throwable th) {
            gy.b(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }
}
