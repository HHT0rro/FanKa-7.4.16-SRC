package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f42405a;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f42406b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f42407c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f42408d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f42409e;

    /* renamed from: f, reason: collision with root package name */
    private static Method f42410f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f42411g;

    public static boolean a(Context context, QQToken qQToken) {
        return g.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f42410f.invoke(f42405a, Boolean.TRUE);
            } else {
                f42410f.invoke(f42405a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f42405a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f42406b = cls;
            f42407c = cls.getMethod("reportQQ", Context.class, String.class);
            f42408d = f42406b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f42406b;
            Class<Integer> cls3 = Integer.TYPE;
            f42409e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f42405a;
            Class<Boolean> cls5 = Boolean.TYPE;
            f42410f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f42405a.getMethod("setAutoExceptionCaught", cls5).invoke(f42405a, Boolean.FALSE);
            f42405a.getMethod("setEnableSmartReporting", cls5).invoke(f42405a, Boolean.TRUE);
            f42405a.getMethod("setSendPeriodMinutes", cls3).invoke(f42405a, Integer.valueOf(MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE));
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f42405a.getMethod("setStatSendStrategy", cls6).invoke(f42405a, cls6.getField("PERIOD").get(null));
            f42406b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f42406b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f42411g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            d.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (f42411g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f42407c.invoke(f42406b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f42411g) {
            b(context, qQToken);
            try {
                f42408d.invoke(f42406b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
