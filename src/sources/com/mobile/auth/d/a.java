package com.mobile.auth.d;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import com.mobile.auth.d.e;
import com.mobile.auth.d.i;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.core.MobileNetRequestManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36722a = "a";

    /* renamed from: com.mobile.auth.d.a$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass3 extends i.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f36741a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f36742b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f36743c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f36744d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f36745e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f36746f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.mobile.auth.a.b f36747g;

        public AnonymousClass3(Context context, String str, String str2, String str3, String str4, String str5, com.mobile.auth.a.b bVar) {
            this.f36741a = context;
            this.f36742b = str;
            this.f36743c = str2;
            this.f36744d = str3;
            this.f36745e = str4;
            this.f36746f = str5;
            this.f36747g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (new e().a(this.f36741a, "https://id6.me/auth/preauth.do")) {
                    if (a()) {
                        return;
                    }
                    String a10 = a.a(a.this, this.f36741a, this.f36742b, this.f36743c, this.f36744d, null, this.f36745e, this.f36746f);
                    if (a()) {
                    } else {
                        com.mobile.auth.a.a.b(this.f36741a, a10, this.f36746f, this.f36747g);
                    }
                } else if (a()) {
                } else {
                    com.mobile.auth.a.a.b(this.f36741a, h.a(MobileNetRequestManager.CODE_SWITCH_TIMEOUT, MobileNetRequestManager.MSG_SWITCH_TIMEOUT), this.f36746f, this.f36747g);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static /* synthetic */ String a() {
        try {
            return f36722a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String a(Context context, String str, String str2, Network network) {
        try {
            return c(context, d.a(context, str, network), str2, network);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private String a(Context context, String str, String str2, String str3, Network network, String str4, String str5) {
        try {
            String b4 = b();
            String a10 = g.a(context, str, str2, str3, b4);
            String str6 = f36722a;
            com.mobile.auth.a.a.a(str6, "request params : " + a10);
            String a11 = d.a(context, "https://id6.me/auth/preauth.do", a10, network, str4, str5);
            com.mobile.auth.a.a.a(str6, "request result : " + a11);
            String b10 = b(context, a11, b4, network);
            if (TextUtils.isEmpty(b10)) {
                return "{\"result\":80001,\"msg\":\"请求异常\"}";
            }
            com.mobile.auth.c.e.a(str5, b10, a10);
            return b10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static String a(Context context, List<String> list, String str, Network network) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            try {
                try {
                    list.get(i10);
                    TextUtils.isEmpty(list.get(i10));
                    String a10 = a(context, list.get(i10), str, network);
                    try {
                        JSONObject jSONObject = !TextUtils.isEmpty(a10) ? new JSONObject(a10) : null;
                        if (jSONObject != null && jSONObject.getInt("result") == 0) {
                            return a10;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String a(a aVar, Context context, String str, String str2, String str3, Network network, String str4, String str5) {
        try {
            return aVar.a(context, str, str2, str3, network, str4, str5);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            return com.mobile.auth.b.a.c(str, str2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private void a(final Context context, final String str, final i.a aVar, final int i10, final com.mobile.auth.a.b bVar) {
        try {
            final Future b4 = i.a().b(aVar);
            i.a().a(new Runnable() { // from class: com.mobile.auth.d.a.4
                @Override // java.lang.Runnable
                public void run() {
                    Future future;
                    Future future2;
                    try {
                        try {
                            b4.get(i10, TimeUnit.MILLISECONDS);
                            future2 = b4;
                        } catch (Throwable th) {
                            try {
                                aVar.a(true);
                                if (th instanceof TimeoutException) {
                                    com.mobile.auth.c.e.a(str, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                                    com.mobile.auth.c.e.a(str).h("submitOnTimeoutInterrupted()");
                                    com.mobile.auth.a.a.b(context, "{\"result\":80000,\"msg\":\"请求超时\"}", str, bVar);
                                } else {
                                    com.mobile.auth.c.e.a(str, "{\"result\":80001,\"msg\":\"请求异常\"}", "");
                                    com.mobile.auth.c.e.a(str).h("submitOnTimeoutInterrupted other exception : " + th.getMessage());
                                    com.mobile.auth.a.a.a(a.a(), "submitOnTimeoutInterrupted other exception", th);
                                    com.mobile.auth.a.a.b(context, "{\"result\":80001,\"msg\":\"请求异常\"}", str, bVar);
                                }
                                Future future3 = b4;
                                if (future3 == null || future3.isDone()) {
                                    return;
                                } else {
                                    future = b4;
                                }
                            } catch (Throwable th2) {
                                Future future4 = b4;
                                if (future4 != null && !future4.isDone()) {
                                    b4.cancel(true);
                                }
                                throw th2;
                            }
                        }
                        if (future2 == null || future2.isDone()) {
                            return;
                        }
                        future = b4;
                        future.cancel(true);
                    } catch (Throwable th3) {
                        try {
                            ExceptionProcessor.processException(th3);
                        } catch (Throwable th4) {
                            ExceptionProcessor.processException(th4);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private String b() {
        try {
            String uuid = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(uuid)) {
                return "";
            }
            String replace = uuid.replace("-", "");
            return replace.length() >= 16 ? replace.substring(0, 16) : replace;
        } catch (Throwable th) {
            try {
                com.mobile.auth.a.a.a(f36722a, "generateAesKey error", th);
                return "";
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

    private String b(Context context, String str, String str2, Network network) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if ((optInt == 0 || optInt == 30002) && !TextUtils.isEmpty(optString)) {
                    String a10 = a(optString, str2);
                    if (!TextUtils.isEmpty(a10)) {
                        try {
                            jSONObject.put("data", new JSONObject(a10));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject.put("data", a10);
                        }
                        if (optInt != 30002) {
                            return jSONObject.toString();
                        }
                        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("data");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = jSONObject2.optJSONArray("urls");
                        if (optJSONArray != null) {
                            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                                arrayList.add(optJSONArray.getString(i10));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return a(context, arrayList, str2, network);
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36722a, "decryptResult error", th);
                return null;
            }
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

    private static String c(Context context, String str, String str2, Network network) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if (optInt == 0 && !TextUtils.isEmpty(optString)) {
                    String a10 = a(optString, str2);
                    if (!TextUtils.isEmpty(a10)) {
                        try {
                            jSONObject.put("data", new JSONObject(a10));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject.put("data", a10);
                        }
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                com.mobile.auth.a.a.a(f36722a, "decryptResult error", th);
                return null;
            }
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

    public void a(final Context context, final String str, final String str2, final String str3, final com.mobile.auth.a.b bVar) {
        try {
            int i10 = com.mobile.auth.a.a.f36668b;
            int i11 = i10 <= 0 ? 10000 : i10;
            final String a10 = c.a();
            final String a11 = c.a(context);
            com.mobile.auth.c.e.a(a10).a(str).b(a11).d("preauth").c(f.f(context)).i(context.getPackageName());
            a(context, a10, new i.a() { // from class: com.mobile.auth.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String a12 = a.a(a.this, context, str, str2, str3, null, a11, a10);
                        if (a()) {
                            return;
                        }
                        com.mobile.auth.a.a.b(context, a12, a10, bVar);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, i11, bVar);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void b(final Context context, final String str, final String str2, final String str3, final com.mobile.auth.a.b bVar) {
        try {
            int i10 = com.mobile.auth.a.a.f36668b;
            if (i10 <= 0) {
                i10 = 10000;
            }
            final String a10 = c.a();
            final String a11 = c.a(context);
            com.mobile.auth.c.e.a(a10).a(str).b(a11).d("preauth").c(f.f(context)).i(context.getPackageName());
            e eVar = new e();
            eVar.a(context, new e.a() { // from class: com.mobile.auth.d.a.2

                /* renamed from: i, reason: collision with root package name */
                private boolean f36739i = false;

                /* renamed from: j, reason: collision with root package name */
                private boolean f36740j = false;

                @Override // com.mobile.auth.d.e.a
                public synchronized void a() {
                    try {
                        this.f36739i = true;
                        if (!this.f36740j) {
                            com.mobile.auth.c.e.a(a10, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                            com.mobile.auth.a.a.b(context, "{\"result\":80000,\"msg\":\"请求超时\"}", a10, bVar);
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.d.e.a
                public synchronized void a(int i11, String str4, long j10) {
                    try {
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                    if (!this.f36739i && !this.f36740j) {
                        this.f36740j = true;
                        com.mobile.auth.c.e.a(a10).h("switchToMobile_L  onFail()  expendTime : " + j10).a(i11).f(str4).b(j10);
                        com.mobile.auth.a.a.b(context, h.a(i11, str4), a10, bVar);
                        com.mobile.auth.a.a.a(a.a(), "Switching network failed (L), errorMsg :" + str4 + " , expendTime ：" + j10);
                    }
                }

                @Override // com.mobile.auth.d.e.a
                public void a(Network network, long j10) {
                    try {
                        com.mobile.auth.a.a.a(a.a(), "Switching network successfully (L) , expendTime ：" + j10);
                        if (!this.f36739i && !this.f36740j) {
                            com.mobile.auth.c.e.a(a10).b(j10);
                            String a12 = a.a(a.this, context, str, str2, str3, network, a11, a10);
                            synchronized (this) {
                                if (!this.f36739i && !this.f36740j) {
                                    this.f36740j = true;
                                    com.mobile.auth.a.a.b(context, a12, a10, bVar);
                                }
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
            });
            eVar.a(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
