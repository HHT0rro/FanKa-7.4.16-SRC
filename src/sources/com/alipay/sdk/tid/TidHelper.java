package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.data.c;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TidHelper {
    private static void a(Context context) {
        if (context == null) {
            return;
        }
        com.alipay.sdk.sys.b.a().a(context, c.b());
    }

    private static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.packet.b a10 = new com.alipay.sdk.packet.impl.c().a(context);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject(a10.b());
                b a11 = b.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString(b.f4685e);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                    a11.a(optString, string);
                }
                return a(context, a11);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void clearTID(Context context) {
        b.a(context).g();
    }

    public static String getIMEI(Context context) {
        a(context);
        return com.alipay.sdk.util.a.a(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return com.alipay.sdk.util.a.a(context).a();
    }

    public static synchronized String getTIDValue(Context context) {
        String tid;
        synchronized (TidHelper.class) {
            Tid loadOrCreateTID = loadOrCreateTID(context);
            tid = Tid.isEmpty(loadOrCreateTID) ? "" : loadOrCreateTID.getTid();
        }
        return tid;
    }

    public static String getVirtualImei(Context context) {
        a(context);
        return c.b().c();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        return c.b().d();
    }

    public static Tid loadLocalTid(Context context) {
        b a10 = b.a(context);
        if (a10.h()) {
            return null;
        }
        return new Tid(a10.a(), a10.b(), a10.i().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        synchronized (TidHelper.class) {
            com.alipay.sdk.util.c.b("TidHelper", "TidHelper.loadOrCreateTID");
            if (context == null) {
                com.alipay.sdk.app.statistic.a.a(context, "tid", com.alipay.sdk.app.statistic.c.T, "");
            }
            a(context);
            Tid loadTID = loadTID(context);
            if (Tid.isEmpty(loadTID)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return null;
                }
                try {
                    loadTID = b(context);
                } catch (Throwable unused) {
                }
            }
            return loadTID;
        }
    }

    public static Tid loadTID(Context context) {
        a(context);
        Tid a10 = a(context, b.a(context));
        if (a10 == null) {
            com.alipay.sdk.util.c.b("TidHelper.loadTID", "TidHelper:::loadTID > null");
        } else {
            com.alipay.sdk.util.c.b("TidHelper.loadTID", "TidHelper:::loadTID > " + a10.toString());
        }
        return a10;
    }

    public static boolean resetTID(Context context) throws Exception {
        com.alipay.sdk.util.c.b("TidHelper.resetTID", "resetTID");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a(context);
            clearTID(context);
            Tid tid = null;
            try {
                tid = b(context);
            } catch (Throwable unused) {
            }
            return !Tid.isEmpty(tid);
        }
        throw new Exception("不能在主线程中调用此方法");
    }

    private static Tid a(Context context, b bVar) {
        if (bVar == null || bVar.e()) {
            return null;
        }
        return new Tid(bVar.a(), bVar.b(), bVar.i().longValue());
    }
}
