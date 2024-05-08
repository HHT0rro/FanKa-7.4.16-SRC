package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.realidentity.utils.FrontLightMode;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.hms.mlsdk.common.MLFrame;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraConfigurationManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aj {

    /* renamed from: g, reason: collision with root package name */
    private static final String f3057g = "aj";

    /* renamed from: a, reason: collision with root package name */
    public final Context f3058a;

    /* renamed from: b, reason: collision with root package name */
    public Point f3059b;

    /* renamed from: c, reason: collision with root package name */
    public Point f3060c;

    /* renamed from: d, reason: collision with root package name */
    public int f3061d = 90;

    /* renamed from: e, reason: collision with root package name */
    public Point f3062e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, Integer> f3063f;

    public aj(Context context) {
        this.f3058a = context;
    }

    private void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.f3058a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f3059b = point;
        this.f3060c = hg.a(parameters, point);
        String str = Build.MODEL;
        if ((!str.contains("HTC") || !str.contains("One")) && !str.contains("GT-N7100") && !str.contains("GT-I9300")) {
            if (str.equals("u8800")) {
                this.f3060c = new Point(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 480);
            } else if (str.equals("MI PAD")) {
                this.f3060c = new Point(2048, 1536);
            }
        } else {
            this.f3060c = new Point(1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH);
        }
        this.f3062e = hg.a(parameters, this.f3061d);
        if (str.contains("ASUS_Z00ADB")) {
            this.f3062e = new Point(1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH);
        }
    }

    public final void a(Camera camera, boolean z10) {
        Integer num;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            RPLogging.w(f3057g, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3058a);
        int i10 = 0;
        a(parameters, FrontLightMode.readPref(defaultSharedPreferences) == FrontLightMode.ON, z10);
        hg.a(parameters, defaultSharedPreferences.getBoolean(hk.f3841a, true), defaultSharedPreferences.getBoolean(hk.f3843c, true), z10);
        if (!z10) {
            if (defaultSharedPreferences.getBoolean(hk.f3844d, false)) {
                hg.e(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(hk.f3845e, true)) {
                hg.d(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(hk.f3846f, true)) {
                hg.c(parameters);
                hg.a(parameters);
                hg.b(parameters);
            }
        }
        try {
            String str = Build.MODEL;
            if (str != null) {
                if (str.contains("M9") && Build.BRAND.contains("Meizu")) {
                    this.f3061d += 90;
                } else {
                    String replace = str.toLowerCase(Locale.US).replace(" ", "");
                    if (replace.contains("nexus5x")) {
                        this.f3061d += 180;
                    }
                    Map<String, Integer> map = this.f3063f;
                    if (map != null && map.containsKey(replace) && (num = this.f3063f.get(replace)) != null) {
                        this.f3061d += num.intValue();
                    }
                    this.f3061d %= 360;
                }
            }
            camera.setDisplayOrientation(this.f3061d);
        } catch (Exception e2) {
            parameters.setRotation(90);
            RPLogging.w(f3057g, "method error" + e2.getLocalizedMessage());
        } catch (NoSuchMethodError e10) {
            parameters.setRotation(90);
            RPLogging.w(f3057g, "method error" + e10.getLocalizedMessage());
        }
        List<Integer> supportedPictureFormats = parameters.getSupportedPictureFormats();
        int i11 = 17;
        if (supportedPictureFormats.contains(256)) {
            i10 = 256;
        } else if (supportedPictureFormats.contains(4)) {
            i10 = 4;
        } else if (supportedPictureFormats.contains(17)) {
            i10 = 17;
        }
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (!supportedPreviewFormats.contains(17)) {
            i11 = supportedPreviewFormats.contains(Integer.valueOf(MLFrame.Property.IMAGE_FORMAT_YV12)) ? MLFrame.Property.IMAGE_FORMAT_YV12 : -1;
        }
        if (i11 >= 0) {
            parameters.setPreviewFormat(i11);
        }
        String str2 = Build.MODEL;
        if (str2.contains("HTC") && str2.contains("801e") && str2.contains("One")) {
            parameters.setZoom(30);
        } else if (str2.contains("GT-I9300")) {
            parameters.setZoom(20);
        }
        parameters.setPictureFormat(i10);
        Point point = this.f3062e;
        parameters.setPictureSize(point.x, point.y);
        Point point2 = this.f3060c;
        parameters.setPreviewSize(point2.x, point2.y);
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point3 = this.f3060c;
            int i12 = point3.x;
            int i13 = previewSize.width;
            if (i12 == i13 && point3.y == previewSize.height) {
                return;
            }
            point3.x = i13;
            point3.y = previewSize.height;
        }
    }

    private static int b(Camera.Parameters parameters) {
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (supportedPreviewFormats.contains(17)) {
            return 17;
        }
        if (supportedPreviewFormats.contains(Integer.valueOf(MLFrame.Property.IMAGE_FORMAT_YV12))) {
            return MLFrame.Property.IMAGE_FORMAT_YV12;
        }
        return -1;
    }

    private Point b() {
        return this.f3059b;
    }

    private void b(Camera camera, boolean z10) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z10, false);
        camera.setParameters(parameters);
    }

    private static int a(Camera.Parameters parameters) {
        List<Integer> supportedPictureFormats = parameters.getSupportedPictureFormats();
        if (supportedPictureFormats.contains(256)) {
            return 256;
        }
        if (supportedPictureFormats.contains(4)) {
            return 4;
        }
        return supportedPictureFormats.contains(17) ? 17 : 0;
    }

    private Point a() {
        return this.f3060c;
    }

    public static boolean a(Camera camera) {
        Camera.Parameters parameters;
        String flashMode;
        return (camera == null || (parameters = camera.getParameters()) == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    private void a(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z10) {
        a(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z10);
    }

    public final void a(Camera.Parameters parameters, boolean z10, boolean z11) {
        hg.a(parameters, z10);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3058a);
        if (z11 || defaultSharedPreferences.getBoolean(hk.f3847g, true)) {
            return;
        }
        hg.b(parameters, z10);
    }

    private void a(Map<String, Integer> map) {
        this.f3063f = map;
    }
}
