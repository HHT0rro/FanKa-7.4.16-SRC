package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Bugly {
    public static final String SDK_IS_DEV = "false";

    /* renamed from: a, reason: collision with root package name */
    private static boolean f38999a = false;
    public static Context applicationContext = null;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f39000b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};

    /* renamed from: c, reason: collision with root package name */
    private static String[] f39001c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
            if (b4 == null) {
                return null;
            }
            if (TextUtils.isEmpty(b4.f39104l)) {
                p a10 = p.a();
                if (a10 == null) {
                    return b4.f39104l;
                }
                Map<String, byte[]> a11 = a10.a(MetricsProto.MetricsEvent.DIALOG_ZEN_TIMEPICKER, (o) null, true);
                if (a11 != null && (bArr = a11.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return b4.f39104l;
        }
    }

    public static void init(Context context, String str, boolean z10) {
        init(context, str, z10, null);
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
        }
        return isDev.booleanValue();
    }

    public static synchronized void init(Context context, String str, boolean z10, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (f38999a) {
                return;
            }
            f38999a = true;
            Context a10 = z.a(context);
            applicationContext = a10;
            if (a10 == null) {
                String str2 = x.f40235a;
                return;
            }
            if (isDev()) {
                f39000b = f39001c;
            }
            for (String str3 : f39000b) {
                try {
                    if (str3.equals("BuglyCrashModule")) {
                        b.a(CrashModule.getInstance());
                    } else if (!str3.equals("BuglyBetaModule") && !str3.equals("BuglyRqdModule")) {
                        str3.equals("BuglyFeedbackModule");
                    }
                } catch (Throwable th) {
                    x.b(th);
                }
            }
            b.f39029a = enable;
            b.a(applicationContext, str, z10, buglyStrategy);
        }
    }
}
