package com.alibaba.security.realidentity.build;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.security.common.log.RPLogging;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import sun.util.locale.LanguageTag;

/* compiled from: CameraConfigurationUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hg {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3826a = "CameraConfiguration";

    /* renamed from: c, reason: collision with root package name */
    private static final int f3828c = 153600;

    /* renamed from: d, reason: collision with root package name */
    private static final int f3829d = 1024000;

    /* renamed from: e, reason: collision with root package name */
    private static final int f3830e = 307200;

    /* renamed from: f, reason: collision with root package name */
    private static final int f3831f = 384000;

    /* renamed from: i, reason: collision with root package name */
    private static final float f3834i = 1.5f;

    /* renamed from: j, reason: collision with root package name */
    private static final float f3835j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    private static final double f3836k = 0.15d;

    /* renamed from: l, reason: collision with root package name */
    private static final int f3837l = 10;

    /* renamed from: m, reason: collision with root package name */
    private static final int f3838m = 20;

    /* renamed from: n, reason: collision with root package name */
    private static final int f3839n = 400;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f3827b = Pattern.compile(";");

    /* renamed from: g, reason: collision with root package name */
    private static int f3832g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static int f3833h = -1;

    private hg() {
    }

    public static void a(Camera.Parameters parameters, boolean z10, boolean z11, boolean z12) {
        String str;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!z10) {
            str = null;
        } else if (!z12 && !z11) {
            str = a(supportedFocusModes, "continuous-picture", "continuous-video", Attributes.LayoutDirection.AUTO);
        } else {
            str = a(supportedFocusModes, Attributes.LayoutDirection.AUTO);
        }
        if (!z12 && str == null) {
            str = a(supportedFocusModes, "macro", "edof");
        }
        if (str != null) {
            if (str.equals(parameters.getFocusMode())) {
                RPLogging.i(f3826a, "Focus mode already set to ".concat(str));
            } else {
                parameters.setFocusMode(str);
            }
        }
    }

    public static void b(Camera.Parameters parameters, boolean z10) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z10 ? 0.0f : 1.5f) / exposureCompensationStep);
                float f10 = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    RPLogging.i(f3826a, "Exposure compensation already set to " + max + " / " + f10);
                    return;
                }
                RPLogging.i(f3826a, "Setting exposure compensation to " + max + " / " + f10);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        RPLogging.i(f3826a, "Camera does not support exposure compensation");
    }

    public static void c(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported()) {
            if (parameters.getVideoStabilization()) {
                RPLogging.i(f3826a, "Video stabilization already enabled");
                return;
            } else {
                RPLogging.i(f3826a, "Enabling video stabilization...");
                parameters.setVideoStabilization(true);
                return;
            }
        }
        RPLogging.i(f3826a, "This device does not support video stabilization");
    }

    public static void d(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            RPLogging.i(f3826a, "Barcode scene mode already set");
            return;
        }
        String a10 = a(parameters.getSupportedSceneModes(), "barcode");
        if (a10 != null) {
            parameters.setSceneMode(a10);
        }
    }

    public static void e(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            RPLogging.i(f3826a, "Negative effect already set");
            return;
        }
        String a10 = a(parameters.getSupportedColorEffects(), "negative");
        if (a10 != null) {
            parameters.setColorEffect(a10);
        }
    }

    private static void f(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        RPLogging.i(f3826a, "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> iterator2 = supportedPreviewFpsRange.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            int[] next = iterator2.next();
            int i10 = next[0];
            int i11 = next[1];
            if (i10 >= 10000 && i11 <= 20000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            RPLogging.i(f3826a, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            RPLogging.i(f3826a, "FPS range already set to " + Arrays.toString(iArr));
        } else {
            RPLogging.i(f3826a, "Setting FPS range to " + Arrays.toString(iArr));
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    private static void g(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        RPLogging.i(f3826a, "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> iterator2 = supportedPreviewFpsRange.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            int[] next = iterator2.next();
            int i10 = next[0];
            int i11 = next[1];
            if (i10 >= 10000 && i11 <= 20000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            RPLogging.i(f3826a, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            RPLogging.i(f3826a, "FPS range already set to " + Arrays.toString(iArr));
        } else {
            RPLogging.i(f3826a, "Setting FPS range to " + Arrays.toString(iArr));
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    private static String h(Camera.Parameters parameters) {
        String flatten = parameters.flatten();
        StringBuilder sb2 = new StringBuilder(1000);
        sb2.append("BOARD=");
        sb2.append(Build.BOARD);
        sb2.append('\n');
        sb2.append("BRAND=");
        sb2.append(Build.BRAND);
        sb2.append('\n');
        sb2.append("CPU_ABI=");
        sb2.append(Build.CPU_ABI);
        sb2.append('\n');
        sb2.append("DEVICE=");
        sb2.append(Build.DEVICE);
        sb2.append('\n');
        sb2.append("DISPLAY=");
        sb2.append(Build.DISPLAY);
        sb2.append('\n');
        sb2.append("FINGERPRINT=");
        sb2.append(Build.FINGERPRINT);
        sb2.append('\n');
        sb2.append("HOST=");
        sb2.append(Build.HOST);
        sb2.append('\n');
        sb2.append("ID=");
        sb2.append(Build.ID);
        sb2.append('\n');
        sb2.append("MANUFACTURER=");
        sb2.append(Build.MANUFACTURER);
        sb2.append('\n');
        sb2.append("MODEL=");
        sb2.append(Build.MODEL);
        sb2.append('\n');
        sb2.append("PRODUCT=");
        sb2.append(Build.PRODUCT);
        sb2.append('\n');
        sb2.append("TAGS=");
        sb2.append(Build.TAGS);
        sb2.append('\n');
        sb2.append("TIME=");
        sb2.append(Build.TIME);
        sb2.append('\n');
        sb2.append("TYPE=");
        sb2.append(Build.TYPE);
        sb2.append('\n');
        sb2.append("USER=");
        sb2.append(Build.USER);
        sb2.append('\n');
        sb2.append("VERSION.CODENAME=");
        sb2.append(Build.VERSION.CODENAME);
        sb2.append('\n');
        sb2.append("VERSION.INCREMENTAL=");
        sb2.append(Build.VERSION.INCREMENTAL);
        sb2.append('\n');
        sb2.append("VERSION.RELEASE=");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append('\n');
        sb2.append("VERSION.SDK_INT=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append('\n');
        if (flatten != null) {
            String[] split = f3827b.split(flatten);
            Arrays.sort(split);
            for (String str : split) {
                sb2.append(str);
                sb2.append('\n');
            }
        }
        return sb2.toString();
    }

    private static int c() {
        int i10 = f3832g;
        return i10 > 0 ? i10 : f3830e;
    }

    public static void a(Camera.Parameters parameters, boolean z10) {
        String a10;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z10) {
            a10 = a(supportedFlashModes, "torch", "on");
        } else {
            a10 = a(supportedFlashModes, "off");
        }
        if (a10 != null) {
            if (a10.equals(parameters.getFlashMode())) {
                RPLogging.i(f3826a, "Flash mode already set to ".concat(a10));
            } else {
                RPLogging.i(f3826a, "Setting flash mode to ".concat(a10));
                parameters.setFlashMode(a10);
            }
        }
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            RPLogging.i(f3826a, "Old metering areas: " + ((Object) parameters.getMeteringAreas()));
            List<Camera.Area> a10 = a();
            RPLogging.i(f3826a, "Setting metering area to : " + a((Iterable<Camera.Area>) a10));
            parameters.setMeteringAreas(a10);
            return;
        }
        RPLogging.i(f3826a, "Device does not support metering areas");
    }

    public static void a(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            RPLogging.i(f3826a, "Old focus areas: " + a((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> a10 = a();
            RPLogging.i(f3826a, "Setting focus area to : " + a((Iterable<Camera.Area>) a10));
            parameters.setFocusAreas(a10);
            return;
        }
        RPLogging.i(f3826a, "Device does not support focus areas");
    }

    private static int b() {
        int i10 = f3833h;
        return i10 > 0 ? i10 : f3831f;
    }

    private static Integer b(Camera.Parameters parameters, double d10) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        RPLogging.i(f3826a, "Zoom ratios: ".concat(String.valueOf(zoomRatios)));
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios != null && !zoomRatios.isEmpty() && zoomRatios.size() == maxZoom + 1) {
            double d11 = d10 * 100.0d;
            double d12 = Double.POSITIVE_INFINITY;
            int i10 = 0;
            for (int i11 = 0; i11 < zoomRatios.size(); i11++) {
                double abs = Math.abs(zoomRatios.get(i11).intValue() - d11);
                if (abs < d12) {
                    i10 = i11;
                    d12 = abs;
                }
            }
            RPLogging.i(f3826a, "Chose zoom ratio of " + (zoomRatios.get(i10).intValue() / 100.0d));
            return Integer.valueOf(i10);
        }
        RPLogging.w(f3826a, "Invalid zoom ratios!");
        return null;
    }

    private static List<Camera.Area> a() {
        return Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Point a(Camera.Parameters parameters, int i10) {
        int i11;
        int i12;
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPictureSizes());
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.alibaba.security.realidentity.build.hg.1
            private static int a(Camera.Size size, Camera.Size size2) {
                int i13 = size.height * size.width;
                int i14 = size2.height * size2.width;
                if (i14 < i13) {
                    return -1;
                }
                return i14 > i13 ? 1 : 0;
            }

            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i13 = size3.height * size3.width;
                int i14 = size4.height * size4.width;
                if (i14 < i13) {
                    return -1;
                }
                return i14 > i13 ? 1 : 0;
            }
        });
        for (Camera.Size size : arrayList) {
            int i13 = size.width;
            int i14 = size.height;
            int i15 = i13 * i14;
            int i16 = f3833h;
            if (i16 <= 0) {
                i16 = f3831f;
            }
            if (i15 <= i16 || "LA6-L".equals(Build.MODEL)) {
                return new Point(i13, i14);
            }
        }
        Camera.Size size2 = (Camera.Size) arrayList.get(0);
        if (i10 % 180 == 0) {
            i11 = size2.width;
            i12 = size2.height;
        } else {
            i11 = size2.height;
            i12 = size2.width;
        }
        return new Point(i11, i12);
    }

    private static void a(Camera.Parameters parameters, double d10) {
        Integer num;
        if (parameters.isZoomSupported()) {
            List<Integer> zoomRatios = parameters.getZoomRatios();
            RPLogging.i(f3826a, "Zoom ratios: ".concat(String.valueOf(zoomRatios)));
            int maxZoom = parameters.getMaxZoom();
            if (zoomRatios != null && !zoomRatios.isEmpty() && zoomRatios.size() == maxZoom + 1) {
                double d11 = d10 * 100.0d;
                double d12 = Double.POSITIVE_INFINITY;
                int i10 = 0;
                for (int i11 = 0; i11 < zoomRatios.size(); i11++) {
                    double abs = Math.abs(zoomRatios.get(i11).intValue() - d11);
                    if (abs < d12) {
                        i10 = i11;
                        d12 = abs;
                    }
                }
                RPLogging.i(f3826a, "Chose zoom ratio of " + (zoomRatios.get(i10).intValue() / 100.0d));
                num = Integer.valueOf(i10);
            } else {
                RPLogging.w(f3826a, "Invalid zoom ratios!");
                num = null;
            }
            if (num == null) {
                return;
            }
            if (parameters.getZoom() == num.intValue()) {
                RPLogging.i(f3826a, "Zoom is already set to ".concat(String.valueOf(num)));
                return;
            } else {
                RPLogging.i(f3826a, "Setting zoom to ".concat(String.valueOf(num)));
                parameters.setZoom(num.intValue());
                return;
            }
        }
        RPLogging.i(f3826a, "Zoom is not supported");
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            RPLogging.w(f3826a, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.alibaba.security.realidentity.build.hg.2
            private static int a(Camera.Size size, Camera.Size size2) {
                int i10 = size.height * size.width;
                int i11 = size2.height * size2.width;
                if (i11 < i10) {
                    return -1;
                }
                return i11 > i10 ? 1 : 0;
            }

            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i10 = size3.height * size3.width;
                int i11 = size4.height * size4.width;
                if (i11 < i10) {
                    return -1;
                }
                return i11 > i10 ? 1 : 0;
            }
        });
        if (RPLogging.isEnable()) {
            StringBuilder sb2 = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb2.append(size.width);
                sb2.append(Locale.PRIVATE_USE_EXTENSION);
                sb2.append(size.height);
                sb2.append(' ');
            }
            RPLogging.i(f3826a, "Supported preview sizes: ".concat(String.valueOf(sb2)));
        }
        double d10 = point.x / point.y;
        if (!(d10 < 1.0d)) {
            d10 = 1.0d / d10;
        }
        RPLogging.i(f3826a, "SQY:" + point.x + LanguageTag.PRIVATEUSE + point.y);
        Point point2 = null;
        double d11 = Double.POSITIVE_INFINITY;
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            Camera.Size size2 = (Camera.Size) iterator2.next();
            int i10 = size2.width;
            int i11 = size2.height;
            int i12 = i10 * i11;
            if (i12 >= f3828c && i12 <= f3829d) {
                boolean z10 = i10 > i11;
                int i13 = z10 ? i11 : i10;
                int i14 = z10 ? i10 : i11;
                if (i13 == point.x && i14 == point.y) {
                    return new Point(i10, i11);
                }
                str = str2;
                double abs = Math.abs((i13 / i14) - d10);
                if (abs < d11) {
                    point2 = new Point(i10, i11);
                    d11 = abs;
                }
            } else {
                str = str2;
                iterator2.remove();
            }
            str2 = str;
        }
        String str3 = str2;
        if (point2 != null) {
            return point2;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 != null) {
            return new Point(previewSize2.width, previewSize2.height);
        }
        throw new IllegalStateException(str3);
    }

    private static void a(List<Camera.Size> list) {
        String str = "";
        for (Camera.Size size : list) {
            str = str + size.width + LanguageTag.PRIVATEUSE + size.height + "\n";
        }
    }

    private static String a(Collection<String> collection, String... strArr) {
        if (collection == null) {
            return null;
        }
        for (String str : strArr) {
            if (collection.contains(str)) {
                return str;
            }
        }
        return null;
    }

    private static String a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator<int[]> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(Arrays.toString(iterator2.next()));
            if (iterator2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb2.append((Object) area.rect);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            sb2.append(area.weight);
            sb2.append(' ');
        }
        return sb2.toString();
    }

    private static String a(CharSequence charSequence) {
        StringBuilder sb2 = new StringBuilder(1000);
        sb2.append("BOARD=");
        sb2.append(Build.BOARD);
        sb2.append('\n');
        sb2.append("BRAND=");
        sb2.append(Build.BRAND);
        sb2.append('\n');
        sb2.append("CPU_ABI=");
        sb2.append(Build.CPU_ABI);
        sb2.append('\n');
        sb2.append("DEVICE=");
        sb2.append(Build.DEVICE);
        sb2.append('\n');
        sb2.append("DISPLAY=");
        sb2.append(Build.DISPLAY);
        sb2.append('\n');
        sb2.append("FINGERPRINT=");
        sb2.append(Build.FINGERPRINT);
        sb2.append('\n');
        sb2.append("HOST=");
        sb2.append(Build.HOST);
        sb2.append('\n');
        sb2.append("ID=");
        sb2.append(Build.ID);
        sb2.append('\n');
        sb2.append("MANUFACTURER=");
        sb2.append(Build.MANUFACTURER);
        sb2.append('\n');
        sb2.append("MODEL=");
        sb2.append(Build.MODEL);
        sb2.append('\n');
        sb2.append("PRODUCT=");
        sb2.append(Build.PRODUCT);
        sb2.append('\n');
        sb2.append("TAGS=");
        sb2.append(Build.TAGS);
        sb2.append('\n');
        sb2.append("TIME=");
        sb2.append(Build.TIME);
        sb2.append('\n');
        sb2.append("TYPE=");
        sb2.append(Build.TYPE);
        sb2.append('\n');
        sb2.append("USER=");
        sb2.append(Build.USER);
        sb2.append('\n');
        sb2.append("VERSION.CODENAME=");
        sb2.append(Build.VERSION.CODENAME);
        sb2.append('\n');
        sb2.append("VERSION.INCREMENTAL=");
        sb2.append(Build.VERSION.INCREMENTAL);
        sb2.append('\n');
        sb2.append("VERSION.RELEASE=");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append('\n');
        sb2.append("VERSION.SDK_INT=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append('\n');
        if (charSequence != null) {
            String[] split = f3827b.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb2.append(str);
                sb2.append('\n');
            }
        }
        return sb2.toString();
    }
}
