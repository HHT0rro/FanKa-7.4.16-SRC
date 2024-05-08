package ac;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f736a;

    public static boolean a(Context context) {
        if (f736a) {
            return true;
        }
        Long d10 = k.d(context, "success_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (d10 == null) {
            k.b(context, "success_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        if (currentTimeMillis - d10.longValue() > TTAdConstant.AD_MAX_EVENT_TIME) {
            k.b(context, "success_limit_time", Long.valueOf(currentTimeMillis));
            k.b(context, "success_limit_count", 0L);
            return true;
        }
        Long d11 = k.d(context, "success_limit_count");
        if (d11 != null) {
            return d11.longValue() <= 50;
        }
        k.b(context, "success_limit_count", 0L);
        return true;
    }

    public static void b(Context context) {
        Long d10 = k.d(context, "success_limit_count");
        k.b(context, "success_limit_count", Long.valueOf(d10 == null ? 0L : d10.longValue() + 1));
    }

    public static boolean c(Context context) {
        if (f736a) {
            return true;
        }
        Long d10 = k.d(context, "failed_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (d10 == null) {
            k.b(context, "failed_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        if (currentTimeMillis - d10.longValue() > TTAdConstant.AD_MAX_EVENT_TIME) {
            k.b(context, "failed_limit_time", Long.valueOf(currentTimeMillis));
            k.b(context, "count_limit_count", 0L);
            return true;
        }
        Long d11 = k.d(context, "count_limit_count");
        if (d11 != null) {
            return d11.longValue() <= 50;
        }
        k.b(context, "count_limit_count", 0L);
        return true;
    }

    public static void d(Context context) {
        Long d10 = k.d(context, "count_limit_count");
        k.b(context, "count_limit_count", Long.valueOf(d10 == null ? 0L : d10.longValue() + 1));
    }
}
