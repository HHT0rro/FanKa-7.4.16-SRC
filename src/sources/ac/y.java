package ac;

import ac.e;
import android.content.Context;
import android.text.TextUtils;
import com.alicom.tools.networking.RSA;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.Cipher;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y {

    /* renamed from: c, reason: collision with root package name */
    public z f787c;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f786b = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    public ScheduledExecutorService f785a = Executors.newScheduledThreadPool(1);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (y.this) {
                z zVar = y.this.f787c;
                if (zVar != null) {
                    zVar.a(410000, "请求超时");
                    y yVar = y.this;
                    yVar.f787c = null;
                    y.b(yVar);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements a0 {
        public b() {
        }

        @Override // ac.a0
        public final void a(int i10, String str) {
            synchronized (y.this) {
                if (y.this.f787c == null) {
                    return;
                }
                if (i10 == 1) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("code");
                        String optString = jSONObject.optString("msg");
                        String optString2 = jSONObject.optString("data");
                        String optString3 = jSONObject.optString("seq");
                        if (optInt == 100) {
                            String a10 = j.a();
                            String substring = a10.substring(0, 16);
                            String substring2 = a10.substring(16, 32);
                            String str2 = ac.b.f727a ? new String(u.c(s.c(optString2), substring.getBytes(), substring2.getBytes())) : URLDecoder.decode(j.m(optString2, substring, substring2), "UTF-8");
                            if (TextUtils.isEmpty(str2)) {
                                h.c(2, "\nmsg=" + optString + "\ndata=" + optString2 + "\nseq=" + optString3 + "\n");
                                y.this.f787c.b(410002, "数据异常", optString2, optString3);
                            } else {
                                h.c(2, "\nmsg=" + optString + "\ncontent=" + str2 + "\nseq=" + optString3 + "\n");
                                z zVar = y.this.f787c;
                                try {
                                    if (zVar.f800a != null) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("resultCode", 100);
                                        jSONObject2.put("resultMsg", optString);
                                        jSONObject2.put("seq", optString3);
                                        if (TextUtils.isEmpty(str2)) {
                                            jSONObject2.put("resultData", "");
                                        } else {
                                            jSONObject2.put("resultData", new JSONObject(str2));
                                        }
                                        zVar.f800a.onResult(jSONObject2.toString());
                                        zVar.f800a = null;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else {
                            if (optInt == -2 && !TextUtils.isEmpty(i.m())) {
                                optString = optString + "apn is " + i.m();
                            }
                            h.c(2, "\nmsg=" + optString + "\ndata=" + optString2 + "\nseq=" + optString3 + "\n");
                            z zVar2 = y.this.f787c;
                            StringBuilder sb2 = new StringBuilder("code:");
                            sb2.append(optInt);
                            sb2.append("msg:");
                            sb2.append(optString);
                            zVar2.b(410002, sb2.toString(), optString2, optString3);
                        }
                    } catch (Exception e10) {
                        h.c(2, "\nresponse=" + str + "\n");
                        y.this.f787c.b(410002, "异常" + e10.getMessage(), str, "");
                    }
                } else {
                    h.c(2, "\nresponse=" + str + "\n");
                    y.this.f787c.a(410002, str);
                }
                y yVar = y.this;
                yVar.f787c = null;
                y.b(yVar);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f790a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f791b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f792c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a0 f793d;

        public c(long j10, Context context, int i10, a0 a0Var) {
            this.f790a = j10;
            this.f791b = context;
            this.f792c = i10;
            this.f793d = a0Var;
        }

        @Override // ac.e.c
        public final void a(boolean z10, Object obj) {
            if (!z10) {
                this.f793d.a(410003, "无法切换至数据网络");
                return;
            }
            h.g("selectDataChannel:" + (System.currentTimeMillis() - this.f790a));
            y.this.c(this.f791b, this.f792c, obj, this.f793d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f795b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f796c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a0 f797d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f798e;

        public d(int i10, Context context, a0 a0Var, Object obj) {
            this.f795b = i10;
            this.f796c = context;
            this.f797d = a0Var;
            this.f798e = obj;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008b A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:2:0x0000, B:10:0x0014, B:11:0x0040, B:13:0x0085, B:15:0x008b, B:18:0x0096, B:24:0x0082, B:25:0x0021, B:26:0x001f, B:21:0x0074), top: B:1:0x0000, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0096 A[Catch: Exception -> 0x009c, TRY_LEAVE, TryCatch #0 {Exception -> 0x009c, blocks: (B:2:0x0000, B:10:0x0014, B:11:0x0040, B:13:0x0085, B:15:0x008b, B:18:0x0096, B:24:0x0082, B:25:0x0021, B:26:0x001f, B:21:0x0074), top: B:1:0x0000, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r7 = this;
                java.lang.String r0 = ""
                r1 = 0
                ac.b.f727a = r1     // Catch: java.lang.Exception -> L9c
                int r1 = r7.f795b     // Catch: java.lang.Exception -> L9c
                r2 = 2
                r3 = 1
                if (r1 == r2) goto L1f
                r2 = 3
                if (r1 == r2) goto L1f
                r2 = 4
                if (r1 == r2) goto L21
                r2 = 5
                if (r1 == r2) goto L21
                ac.a0 r1 = r7.f797d     // Catch: java.lang.Exception -> L9c
                r2 = 410009(0x64199, float:5.74545E-40)
                java.lang.String r4 = "410009no this type"
                r1.a(r2, r4)     // Catch: java.lang.Exception -> L9c
                goto L40
            L1f:
                ac.b.f727a = r3     // Catch: java.lang.Exception -> L9c
            L21:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9c
                r0.<init>()     // Catch: java.lang.Exception -> L9c
                java.lang.String r1 = ac.i.a()     // Catch: java.lang.Exception -> L9c
                r0.append(r1)     // Catch: java.lang.Exception -> L9c
                android.content.Context r1 = r7.f796c     // Catch: java.lang.Exception -> L9c
                java.lang.String r1 = ac.y.a(r1)     // Catch: java.lang.Exception -> L9c
                java.lang.String r2 = "&"
                java.lang.String r1 = ac.f.a(r1, r2)     // Catch: java.lang.Exception -> L9c
                r0.append(r1)     // Catch: java.lang.Exception -> L9c
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L9c
            L40:
                ac.b0 r1 = new ac.b0     // Catch: java.lang.Exception -> L9c
                r1.<init>()     // Catch: java.lang.Exception -> L9c
                android.content.Context r2 = r7.f796c     // Catch: java.lang.Exception -> L9c
                java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Exception -> L9c
                r4.<init>()     // Catch: java.lang.Exception -> L9c
                java.lang.String r5 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1"
                java.lang.String r6 = "user-agent"
                r4.put(r6, r5)     // Catch: java.lang.Exception -> L9c
                java.lang.String r5 = "netType"
                java.lang.String r6 = "2"
                r4.put(r5, r6)     // Catch: java.lang.Exception -> L9c
                java.lang.String r5 = "os"
                java.lang.String r6 = "android"
                r4.put(r5, r6)     // Catch: java.lang.Exception -> L9c
                java.lang.String r5 = "Accept"
            */
            //  java.lang.String r6 = "*/*"
            /*
                r4.put(r5, r6)     // Catch: java.lang.Exception -> L9c
                java.lang.Object r5 = r7.f798e     // Catch: java.lang.Exception -> L9c
                java.lang.String r0 = r1.b(r2, r0, r4, r5)     // Catch: java.lang.Exception -> L9c
                int r1 = ac.i.q()     // Catch: java.lang.Exception -> L9c
                if (r1 != r3) goto L85
                ac.e r1 = ac.e.a()     // Catch: java.lang.Exception -> L81
                r1.i()     // Catch: java.lang.Exception -> L81
                java.lang.String r1 = "\n  WIFI + 流量 \n call releaseNetwork() \n"
                ac.h.g(r1)     // Catch: java.lang.Exception -> L81
                goto L85
            L81:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Exception -> L9c
            L85:
                boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L9c
                if (r1 == 0) goto L96
                ac.a0 r0 = r7.f797d     // Catch: java.lang.Exception -> L9c
                r1 = 410022(0x641a6, float:5.74563E-40)
                java.lang.String r2 = "网络请求响应为空"
                r0.a(r1, r2)     // Catch: java.lang.Exception -> L9c
                return
            L96:
                ac.a0 r1 = r7.f797d     // Catch: java.lang.Exception -> L9c
                r1.a(r3, r0)     // Catch: java.lang.Exception -> L9c
                return
            L9c:
                r0 = move-exception
                r0.printStackTrace()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ac.y.d.run():void");
        }
    }

    public static String a(Context context) {
        String str;
        String g3;
        String b4;
        String str2 = "";
        try {
            String g10 = i.g();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            String sb3 = sb2.toString();
            String a10 = ac.b.a();
            String packageName = context.getPackageName();
            String x10 = j.x();
            String a11 = j.a();
            String substring = a11.substring(0, 16);
            String substring2 = a11.substring(16, 32);
            if (ac.b.f727a) {
                str = "3.1";
                g3 = s.b(u.b(x10.getBytes("Utf-8"), substring.getBytes(), substring2.getBytes()));
                b4 = s.b(u.a(a11.getBytes(), t.a("045C5DD4890819CEB16B0A66ED62B2FFA29B08F3CBF344A52A3A100ECB271BBEF3A9BC3743E753CA16EF238A1E55B72E95659A70425064D506B48F8EE3442786F7")));
            } else {
                str = "2.1";
                g3 = j.g(x10, substring, substring2);
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(s.c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVc1ecjpc5k7TkabF935iQONDZ0/E5XWPVv9FEsI59XTRW0+BCMK1MODRSWMvHFrPMh9ZilnRr7qXuAKCBEynQEghmpIVvMYhFu48FAI9bKfkI5lKuQK+tc4X0+zTbNrpedNoKXK4C7dDjTETBH6prwWE9j5WsAf0gbjUbIs3FxwIDAQAB")));
                Cipher cipher = Cipher.getInstance(RSA.RSA_ALGORITHM);
                cipher.init(1, generatePublic);
                b4 = s.b(cipher.doFinal(a11.getBytes()));
            }
            String d10 = ac.b.f730d.equalsIgnoreCase("sm3") ? j.d(context, context.getPackageName()) : j.e(context, context.getPackageName(), ac.b.f730d);
            String d11 = i.d();
            if (!TextUtils.isEmpty(d11)) {
                d11 = "0";
            }
            String str3 = d10 + "\n" + g10 + "\n" + str + "\njson\n" + d11 + "\n" + packageName + "\n" + g3 + "\n" + a10 + "\n" + b4 + "\n" + sb3;
            String replaceAll = str3.replaceAll("\n", "");
            String s2 = ac.b.f727a ? j.s(replaceAll) : j.f(replaceAll);
            h.d("unSignDebugInfo=".concat(str3));
            String a12 = s.a(g3);
            String a13 = s.a(b4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("androidMd5", d10);
            jSONObject.put("apiKey", g10);
            jSONObject.put(com.alipay.sdk.cons.c.f4562m, str);
            jSONObject.put("format", "json");
            jSONObject.put("operator", d11);
            jSONObject.put("packName", packageName);
            jSONObject.put("privateIp", a12);
            jSONObject.put(bg.e.Code, a10);
            jSONObject.put("secretKey", a13);
            jSONObject.put("timeStamp", sb3);
            jSONObject.put(CardUriUtils.PARAM_SIGN, s2);
            str2 = jSONObject.toString();
            h.g("getPreCheckParam_CU_Oath: param ok  \n");
            return str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static /* synthetic */ void b(y yVar) {
        try {
            ScheduledExecutorService scheduledExecutorService = yVar.f785a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                yVar.f785a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(Context context, int i10, Object obj, a0 a0Var) {
        synchronized (this) {
            try {
                this.f786b.submit(new d(i10, context, a0Var, obj));
            } catch (Exception e2) {
                a0Var.a(410009, "410009" + e2.getMessage());
            }
        }
    }
}
