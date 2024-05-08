package com.mobile.auth.c;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36717a = "e";

    /* renamed from: b, reason: collision with root package name */
    private static int f36718b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, b> f36719c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static List<String> f36720d = new ArrayList();

    public static synchronized b a(String str) {
        b bVar;
        synchronized (e.class) {
            try {
                bVar = f36719c.containsKey(str) ? f36719c.get(str) : null;
                if (bVar == null) {
                    bVar = new b(str);
                    f36719c.put(str, bVar);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    return new b(str);
                } catch (Throwable th2) {
                    try {
                        ExceptionProcessor.processException(th2);
                        return null;
                    } catch (Throwable th3) {
                        ExceptionProcessor.processException(th3);
                        return null;
                    }
                }
            }
        }
        return bVar;
    }

    public static /* synthetic */ void a(Context context) {
        try {
            b(context);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(final Context context, String str) {
        try {
            synchronized (e.class) {
                if (f36719c.containsKey(str)) {
                    f36720d.add(f36719c.get(str).toString());
                    f36719c.remove(str);
                }
                if (f36718b != 1 && !f36720d.isEmpty()) {
                    f36718b = 1;
                    new Timer().schedule(new TimerTask() { // from class: com.mobile.auth.c.e.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            try {
                                e.a(context);
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }
                    }, 8000L);
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                }
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        int i10 = -1;
        String str4 = "";
        try {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    i10 = jSONObject.getInt("result");
                    str4 = jSONObject.optString("msg");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i10 == 0) {
                a(str).a(i10).f(str4);
            } else {
                a(str).a(i10).f(str4).e(str3);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (e.class) {
                arrayList.addAll(f36720d);
                f36718b = 0;
                f36720d.clear();
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.a(context, arrayList);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                }
            }
        }
    }

    public static void b(Context context, String str) {
        try {
            d.a(context, str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
