package cn.shuzilm.core;

import android.content.Context;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Main {
    public static final int DU_ASYNCHRONOUS = 1;
    public static final int DU_SYNCHRONOUS = 0;
    public static final Lock mLock = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f1707a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1708b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Context f1709c = null;

    /* renamed from: d, reason: collision with root package name */
    private static DUConnection f1710d = new DUConnection();

    /* renamed from: e, reason: collision with root package name */
    private static int f1711e = 0;

    public static void exitService() {
        try {
            f1709c.unbindService(f1710d);
        } catch (Exception unused) {
        }
    }

    public static void getDeviceLabel(int i10, Listener listener) {
        DUHelper.f2c071(i10, listener);
    }

    public static void getHMSOpenAnmsID(Context context, Listener listener) {
        DUHelper.ZVTFJRA(context, listener, 1);
    }

    public static void getNetCode(Context context, Listener listener) {
        DUHelper.m(context, 2, listener);
    }

    public static String getNetErrorCode(Context context) {
        return DUHelper.n(context);
    }

    public static void getNewQueryID(Context context, String str, String str2, int i10, Listener listener) {
        DUHelper.getQueryID(context, str, str2, i10, listener, 3);
    }

    public static void getOpenAnmsID(Context context, Listener listener) {
        DUHelper.ZVTFJRA(context, listener, 0);
    }

    public static String getQueryID(Context context, String str, String str2) {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            if (Looper.myLooper() != null) {
                return DUHelper.getQueryID(context, str, str2);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void getQueryID(Context context, String str, String str2, int i10, Listener listener) {
        DUHelper.getQueryID(context, str, str2, i10, listener, 2);
    }

    public static String getQueryIDInProcess(String str, String str2, DUListener dUListener) {
        if (!f1708b) {
            return "";
        }
        try {
            f1707a.execute(new z(str, str2, dUListener));
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getSpecificID(Context context, String str) {
        return DUHelper.Q3VzdG(context, str);
    }

    public static void init(Context context, String str) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (Looper.myLooper() != null) {
            DUHelper.init(context, str);
        }
    }

    public static void initService(Context context, String str) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (Looper.myLooper() != null) {
            try {
                f1708b = true;
                f1709c = context;
                mLock.lock();
                DUHelper.startService(context, f1710d, str, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Map onEvent(Context context, String str, String str2, int i10, Listener listener) {
        try {
            return DUHelper.onEvent(context, str, str2, i10, listener);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void onEventInPorcess(String str, String str2, String str3, DUListener dUListener) {
        if (f1708b) {
            try {
                f1707a.execute(new y(str, str2, str3, dUListener));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int setConfig(String str, String str2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!f1708b) {
            return DUHelper.setConfig(str, str2);
        }
        f1707a.execute(new x(str, str2));
        return f1711e;
    }

    public static int setData(String str, String str2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!f1708b) {
            return DUHelper.setData(str, str2);
        }
        f1707a.execute(new w(str, str2));
        return f1711e;
    }
}
