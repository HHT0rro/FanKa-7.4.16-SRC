package com.tencent.liteav.beauty;

import android.util.SparseBooleanArray;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final C0637a[] f42925a;

    /* renamed from: b, reason: collision with root package name */
    private static final SparseBooleanArray f42926b = new SparseBooleanArray();

    /* renamed from: com.tencent.liteav.beauty.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0637a {

        /* renamed from: a, reason: collision with root package name */
        public final l.a f42927a;

        /* renamed from: b, reason: collision with root package name */
        public final int f42928b;

        /* renamed from: c, reason: collision with root package name */
        public final String f42929c;

        public /* synthetic */ C0637a(l.a aVar, int i10, String str, byte b4) {
            this(aVar, i10, str);
        }

        private C0637a(l.a aVar, int i10, String str) {
            this.f42927a = aVar;
            this.f42928b = i10;
            this.f42929c = str;
        }
    }

    static {
        byte b4 = 0;
        f42925a = new C0637a[]{new C0637a(l.a.FACE_SLIM, 1206, "reportFaceSlimDua", b4), new C0637a(l.a.EYE_SCALE, 1205, "reportEyeScaleDua", b4), new C0637a(l.a.FACE_V_SHAPE, 1214, "reportFaceVDua", b4), new C0637a(l.a.FACE_SHORT, 1216, "reportFaceShortDua", b4), new C0637a(l.a.CHIN_SCALE, 1215, "reportChinDua", b4), new C0637a(l.a.NOSE_SLIM, 1217, "reportNoseSlimDua", b4), new C0637a(l.a.FOREHEAD, MetricsProto.MetricsEvent.FINGERPRINT_AUTHENTICATE_SIDECAR, "reportForeheadDua", b4), new C0637a(l.a.EYE_DISTANCE, MetricsProto.MetricsEvent.DIALOG_ENABLE_ADB, "reportEyeDistanceDua", b4), new C0637a(l.a.EYE_ANGLE, MetricsProto.MetricsEvent.DIALOG_CLEAR_ADB_KEYS, "reportEyeAngleDua", b4), new C0637a(l.a.MOUTH_SHAPE, MetricsProto.MetricsEvent.DEVELOPMENT_QS_TILE_CONFIG, "reportMouthShapeDua", b4), new C0637a(l.a.NOSE_WING, MetricsProto.MetricsEvent.DIALOG_LOG_PERSIST, "reportNoseWingDua", b4), new C0637a(l.a.NOSE_POSITION, MetricsProto.MetricsEvent.ACTION_ZEN_ALLOW_ALARMS, "reportNosePositionDua", b4), new C0637a(l.a.LIPS_THICKNESS, MetricsProto.MetricsEvent.ACTION_ZEN_ALLOW_MEDIA, "reportLipsThicknessDua", b4), new C0637a(l.a.BASIC3, 1213, "reportFaceBeautyDua", b4), new C0637a(l.a.EYE_LIGHTEN, MetricsProto.MetricsEvent.AUTOFILL_SAVE_EXPLICITLY_TRIGGERED, "reportEyeLightenDua", b4), new C0637a(l.a.TOOTH_WHITEN, 1230, "reportToothWhitenDua", b4), new C0637a(l.a.REMOVE_WRINKLES, 1218, "reportWrinkleRemoveDua", b4), new C0637a(l.a.REMOVE_POUNCH, MetricsProto.MetricsEvent.DIALOG_ENABLE_DEVELOPMENT_OPTIONS, "reportPounchRemoveDua", b4), new C0637a(l.a.REMOVE_SMILE_LINES, MetricsProto.MetricsEvent.DIALOG_ENABLE_OEM_UNLOCKING, "reportSmileLinesRemoveDua", b4)};
    }

    public static void a(IVideoReporter iVideoReporter) {
        f42926b.clear();
        a(iVideoReporter, 1201, "reportSDKInit!");
    }

    public static void b(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1202, "reportBeautyDua");
    }

    public static void c(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1203, "reportWhiteDua");
    }

    public static void d(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1210, "reportSharpDua");
    }

    public static void e(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1204, "reportRuddyDua");
    }

    public static void f(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1208, "reportFilterImageDua");
    }

    public static void g(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1211, "reportTemplateDua");
    }

    public static void h(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1212, "reportWarterMarkDua");
    }

    public static void a(IVideoReporter iVideoReporter, l.a aVar) {
        for (C0637a c0637a : f42925a) {
            if (c0637a.f42927a == aVar) {
                a(iVideoReporter, c0637a.f42928b, c0637a.f42929c);
                return;
            }
        }
    }

    private static synchronized void a(IVideoReporter iVideoReporter, int i10, String str) {
        synchronized (a.class) {
            SparseBooleanArray sparseBooleanArray = f42926b;
            if (sparseBooleanArray.get(i10)) {
                return;
            }
            sparseBooleanArray.put(i10, true);
            LiteavLog.i("ReportDauManager", "report DAU eventId: %d", Integer.valueOf(i10));
            if (iVideoReporter != null) {
                iVideoReporter.notifyEvent(h.b.EVT_VIDEO_PREPROCESS_COSMETIC_FIRST_USE, (Object) null, "report DAU eventId:" + i10 + " errorInfo:" + str);
            }
        }
    }
}
