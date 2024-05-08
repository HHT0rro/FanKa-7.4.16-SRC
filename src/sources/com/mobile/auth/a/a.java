package com.mobile.auth.a;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.c.e;
import com.mobile.auth.d.f;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static c f36667a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f36668b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f36669c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f36670d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static final String f36671e = "a";

    public static void a(int i10, int i11, int i12, c cVar) {
        try {
            f36669c = i10;
            f36670d = i11;
            f36668b = i12;
            f36667a = cVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(Context context, String str, String str2, b bVar) {
        try {
            a(f36671e, "called requestPreAuthCode()   appId：" + str + ",appSecret:" + str2);
            a(context, str, str2, "qhx", bVar);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3, b bVar) {
        try {
            if (bVar == null) {
                f36667a = null;
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!f.b(context)) {
                    bVar.a("{\"result\":80003,\"msg\":\"网络无连接\"}");
                    f36667a = null;
                    return;
                } else if (f.c(context)) {
                    new com.mobile.auth.d.a().a(context, str, str2, str3, bVar);
                    return;
                } else if (f.d(context)) {
                    new com.mobile.auth.d.a().b(context, str, str2, str3, bVar);
                    return;
                } else {
                    bVar.a("{\"result\":80004,\"msg\":\"移动网络未开启\"}");
                    f36667a = null;
                    return;
                }
            }
            bVar.a("{\"result\":80106,\"msg\":\"请求参数异常\"}");
            f36667a = null;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            if (f36667a != null) {
                try {
                    f36667a.a("CT_" + str, str2);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        try {
            if (f36667a != null) {
                try {
                    f36667a.a("CT_" + str, str2, th);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
            }
        }
    }

    public static void b(Context context, String str, String str2, b bVar) {
        if (bVar != null) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("reqId", str2);
                    bVar.a(jSONObject.toString());
                    a(f36671e, "callback result : " + jSONObject.toString());
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                        return;
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                        return;
                    }
                }
            } catch (Exception unused) {
                bVar.a(str);
                a(f36671e, "Exception callback result : " + str);
            }
            f36667a = null;
            e.a(context, str2);
        }
    }
}
