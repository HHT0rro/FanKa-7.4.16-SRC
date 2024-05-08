package com.unicom.online.account.shield;

import ac.a;
import ac.b;
import ac.b0;
import ac.e;
import ac.h;
import ac.i;
import ac.j;
import ac.l;
import ac.n;
import ac.o;
import ac.p;
import ac.q;
import ac.y;
import ac.z;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.ax;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UniAccountHelper {
    private static final int ID_0_STOP_ONCE_SUCCESS = 0;
    private static final int ID_1_STOP_ALL_SEND = 1;
    private static final int LoopMaxNum = 5;
    public static final int SUCCESS = 100;
    private static volatile UniAccountHelper s_instance;
    private Context mContext = null;
    public int loopNum = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Language {
        SIMPLECHINESE(0),
        ENGLISH(1);

        private int value;

        Language(int i10) {
            this.value = i10;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private UniAccountHelper() {
    }

    private void cuGetTokenLoop(int i10, int i11, int i12, ResultListener resultListener) {
        int i13 = this.loopNum;
        if (i13 > 1) {
            return;
        }
        this.loopNum = i10 > 5 ? i13 + 5 : i10 > 1 ? i13 + i10 : i13 + 1;
        culoop(this.loopNum, i11, i12, resultListener);
    }

    private void cuPreGetToken(int i10, final int i11, final String str, final ResultListener resultListener) {
        String str2;
        Context context = this.mContext;
        if (context == null) {
            initFail(resultListener, "sdk未初始化");
            return;
        }
        if (!q.o(context.getApplicationContext())) {
            initFail(resultListener, "数据网络未开启");
        } else if (getUseCacheFlag()) {
            q.b();
            String d10 = q.d(this.mContext, "type".concat(String.valueOf(i11)), str);
            if (o.i(d10).booleanValue()) {
                try {
                    JSONObject jSONObject = new JSONObject(d10);
                    int i12 = jSONObject.getInt("resultCode");
                    long j10 = jSONObject.getJSONObject("resultData").getLong("exp");
                    if (i12 == 100 && j10 > System.currentTimeMillis()) {
                        resultListener.onResult(d10);
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            q.b();
            q.q(this.mContext);
        }
        q.b();
        if (!q.g(this.mContext)) {
            str2 = "操作频繁,请稍后再试";
        } else if (!str.equals("cuPreGetToken")) {
            str2 = "sdk参数错误";
        } else {
            if (i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) {
                q b4 = q.b();
                p pVar = new p() { // from class: com.unicom.online.account.shield.UniAccountHelper.2
                    @Override // ac.p
                    public void onResult(String str3) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            o.h(jSONObject2.optString("seq"));
                            if (jSONObject2.getInt("resultCode") == 100) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("resultData");
                                o.f(jSONObject3.optString("fakeMobile"));
                                o.g(jSONObject3.optString("accessCode"));
                                o.e(jSONObject3.getLong("exp"));
                                o.b(System.currentTimeMillis());
                                String optString = jSONObject2.optString("operator");
                                if (!TextUtils.isEmpty(optString)) {
                                    o.c(optString);
                                }
                                int i13 = i11;
                                if (4 == i13 || 2 == i13) {
                                    jSONObject3.put("fakeMobile", (Object) null);
                                }
                                if (UniAccountHelper.this.getUseCacheFlag()) {
                                    q.b();
                                    q.q(UniAccountHelper.this.mContext);
                                    q.b();
                                    q.h(UniAccountHelper.this.mContext, "type" + i11, str, jSONObject2.toString());
                                }
                                q.b();
                                q.k(UniAccountHelper.this.mContext);
                            } else {
                                q.b();
                                q.m(UniAccountHelper.this.mContext);
                            }
                            resultListener.onResult(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                };
                if (b4.f775a == null || TextUtils.isEmpty(i.g()) || TextUtils.isEmpty(i.i())) {
                    q.e(pVar, "sdk未初始化");
                    return;
                }
                j.o();
                j.v("cuPreGetToken");
                j.q();
                i.b(i10);
                y yVar = new y();
                Context context2 = b4.f775a;
                z zVar = new z();
                yVar.f787c = zVar;
                zVar.f800a = pVar;
                try {
                    yVar.f785a.schedule(new y.a(), i10, TimeUnit.MILLISECONDS);
                    y.b bVar = new y.b();
                    h.g("\n■★■★■★■★■★■★■★■★■★■\nrequestPreCheck()\n■★■★■★■★■★■★■★■★■★■\n");
                    try {
                        int k10 = j.k(context2.getApplicationContext());
                        i.e(k10);
                        h.g("-1=NULL; 0=流量; 1=双开; 2=WIFI; networkType = ".concat(String.valueOf(k10)));
                        if (k10 == 1) {
                            e.a().f(context2, new y.c(System.currentTimeMillis(), context2, i11, bVar));
                            return;
                        } else if (k10 == 0) {
                            yVar.c(context2, i11, null, bVar);
                            return;
                        } else {
                            bVar.a(410004, "数据网络未开启");
                            return;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        bVar.a(410005, "网络判断异常" + e2.getMessage());
                        return;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            str2 = "sdk type 参数错误";
        }
        initFail(resultListener, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void culoop(int i10, final int i11, final int i12, final ResultListener resultListener) {
        if (this.loopNum == 0) {
            return;
        }
        cuPreGetToken(i12, b.f727a ? 3 : 5, "cuPreGetToken", new ResultListener() { // from class: com.unicom.online.account.shield.UniAccountHelper.1
            /* JADX WARN: Removed duplicated region for block: B:16:0x005a A[Catch: JSONException -> 0x0064, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0064, blocks: (B:2:0x0000, B:4:0x0008, B:5:0x0015, B:7:0x002d, B:9:0x0031, B:12:0x003b, B:13:0x003d, B:14:0x0054, B:16:0x005a, B:19:0x0041, B:21:0x0045, B:23:0x004b, B:25:0x0051, B:27:0x000e, B:28:0x0013), top: B:1:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
            @Override // com.unicom.online.account.shield.ResultListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResult(java.lang.String r5) {
                /*
                    r4 = this;
                    com.unicom.online.account.shield.UniAccountHelper r0 = com.unicom.online.account.shield.UniAccountHelper.this     // Catch: org.json.JSONException -> L64
                    int r1 = r0.loopNum     // Catch: org.json.JSONException -> L64
                    r2 = 5
                    r3 = 0
                    if (r1 <= r2) goto Lc
                    r1 = 4
                    r0.loopNum = r1     // Catch: org.json.JSONException -> L64
                    goto L15
                Lc:
                    if (r1 <= 0) goto L13
                    int r1 = r1 + (-1)
                    r0.loopNum = r1     // Catch: org.json.JSONException -> L64
                    goto L15
                L13:
                    r0.loopNum = r3     // Catch: org.json.JSONException -> L64
                L15:
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L64
                    r0.<init>(r5)     // Catch: org.json.JSONException -> L64
                    java.lang.String r1 = "seq"
                    java.lang.String r1 = r0.optString(r1)     // Catch: org.json.JSONException -> L64
                    ac.o.h(r1)     // Catch: org.json.JSONException -> L64
                    java.lang.String r1 = "resultCode"
                    int r0 = r0.getInt(r1)     // Catch: org.json.JSONException -> L64
                    r1 = 100
                    if (r0 != r1) goto L41
                    int r0 = r2     // Catch: org.json.JSONException -> L64
                    if (r0 != 0) goto L3b
                    com.unicom.online.account.shield.UniAccountHelper r0 = com.unicom.online.account.shield.UniAccountHelper.this     // Catch: org.json.JSONException -> L64
                    r0.loopNum = r3     // Catch: org.json.JSONException -> L64
                    com.unicom.online.account.shield.ResultListener r0 = r3     // Catch: org.json.JSONException -> L64
                    r0.onResult(r5)     // Catch: org.json.JSONException -> L64
                    return
                L3b:
                    com.unicom.online.account.shield.ResultListener r0 = r3     // Catch: org.json.JSONException -> L64
                L3d:
                    r0.onResult(r5)     // Catch: org.json.JSONException -> L64
                    goto L54
                L41:
                    int r0 = r2     // Catch: org.json.JSONException -> L64
                    if (r0 != 0) goto L51
                    com.unicom.online.account.shield.UniAccountHelper r0 = com.unicom.online.account.shield.UniAccountHelper.this     // Catch: org.json.JSONException -> L64
                    int r0 = r0.loopNum     // Catch: org.json.JSONException -> L64
                    if (r0 != 0) goto L54
                    com.unicom.online.account.shield.ResultListener r0 = r3     // Catch: org.json.JSONException -> L64
                    r0.onResult(r5)     // Catch: org.json.JSONException -> L64
                    return
                L51:
                    com.unicom.online.account.shield.ResultListener r0 = r3     // Catch: org.json.JSONException -> L64
                    goto L3d
                L54:
                    com.unicom.online.account.shield.UniAccountHelper r5 = com.unicom.online.account.shield.UniAccountHelper.this     // Catch: org.json.JSONException -> L64
                    int r0 = r5.loopNum     // Catch: org.json.JSONException -> L64
                    if (r0 <= 0) goto L63
                    int r1 = r2     // Catch: org.json.JSONException -> L64
                    int r2 = r4     // Catch: org.json.JSONException -> L64
                    com.unicom.online.account.shield.ResultListener r3 = r3     // Catch: org.json.JSONException -> L64
                    com.unicom.online.account.shield.UniAccountHelper.access$000(r5, r0, r1, r2, r3)     // Catch: org.json.JSONException -> L64
                L63:
                    return
                L64:
                    r5 = move-exception
                    r5.printStackTrace()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.shield.UniAccountHelper.AnonymousClass1.onResult(java.lang.String):void");
            }
        });
    }

    public static String getCertFingerType() {
        return b.f730d;
    }

    private String getHostName() {
        q.b();
        return q.p();
    }

    public static UniAccountHelper getInstance() {
        if (s_instance == null) {
            synchronized (UniAccountHelper.class) {
                if (s_instance == null) {
                    s_instance = new UniAccountHelper();
                }
            }
        }
        return s_instance;
    }

    private void initFail(ResultListener resultListener, String str) {
        n.a(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 410021);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            this.loopNum = 0;
            if (resultListener != null) {
                resultListener.onResult(jSONObject.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void sendFail(ResultListener resultListener, int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i10);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", o.a());
            resultListener.onResult(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public UniAccountHelper clearCache() {
        o.d();
        q.b();
        q.q(this.mContext);
        return s_instance;
    }

    public String cuDebugInfo(String str) {
        if (this.mContext == null) {
            return "sdk 未初始化, context 为空";
        }
        q b4 = q.b();
        if (b4.f775a == null) {
            return "sdk 未初始化, context 为空";
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        char c4 = 65535;
        switch (lowerCase.hashCode()) {
            case -1705644026:
                if (lowerCase.equals("testversion")) {
                    c4 = 0;
                    break;
                }
                break;
            case -903629273:
                if (lowerCase.equals(ax.aq)) {
                    c4 = 1;
                    break;
                }
                break;
            case -202146594:
                if (lowerCase.equals("debuginforesult")) {
                    c4 = 2;
                    break;
                }
                break;
            case -197617279:
                if (lowerCase.equals("debuginfo")) {
                    c4 = 3;
                    break;
                }
                break;
            case 107902:
                if (lowerCase.equals("md5")) {
                    c4 = 4;
                    break;
                }
                break;
            case 113945:
                if (lowerCase.equals("sm3")) {
                    c4 = 5;
                    break;
                }
                break;
            case 3528965:
                if (lowerCase.equals("sha1")) {
                    c4 = 6;
                    break;
                }
                break;
            case 93029116:
                if (lowerCase.equals("appid")) {
                    c4 = 7;
                    break;
                }
                break;
            case 667683678:
                if (lowerCase.equals("sdkversion")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 909712337:
                if (lowerCase.equals("packagename")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1183900800:
                if (lowerCase.equals("debuginfoall")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1285324646:
                if (lowerCase.equals("bcproviderversion")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return q.l();
            case 1:
            case 4:
            case 6:
                Context context = b4.f775a;
                return j.e(context, context.getPackageName(), str.toLowerCase());
            case 2:
                return j.b(2);
            case 3:
                return j.b(0);
            case 5:
                Context context2 = b4.f775a;
                return j.d(context2, context2.getPackageName());
            case 7:
                return i.g();
            case '\b':
                return q.j();
            case '\t':
                return b4.f775a.getApplicationContext().getPackageName();
            case '\n':
                return j.b(1);
            case 11:
                return q.n();
            default:
                return "no info";
        }
    }

    public void cuGetToken(int i10, ResultListener resultListener) {
        cuPreGetToken(i10, b.f727a ? 3 : 5, "cuPreGetToken", resultListener);
    }

    public void cuGetTokenLoop(int i10, int i11, ResultListener resultListener) {
        cuGetTokenLoop(i10, 0, i11, resultListener);
    }

    public void cuMobileAuth(int i10, ResultListener resultListener) {
        cuPreGetToken(i10, b.f727a ? 2 : 4, "cuPreGetToken", resultListener);
    }

    public String getSdkVersion() {
        q.b();
        return q.j();
    }

    public boolean getUseCacheFlag() {
        return b.f729c;
    }

    public UniAccountHelper init(Context context, String str) {
        return init(context, str, false);
    }

    public UniAccountHelper init(Context context, String str, boolean z10) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            n.a("初始化参数不能为空");
            return null;
        }
        if (this.mContext != null) {
            n.a("重复初始化");
            return null;
        }
        this.mContext = context.getApplicationContext();
        a.a(context);
        q b4 = q.b();
        j.o();
        j.v("cuPreGetToken");
        j.q();
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(i.g())) {
                b.f728b = true;
                b.f727a = z10;
                b.f729c = true;
                if (b.f727a) {
                    h.g(" MyApplication.enableGuoMi  ");
                }
                b4.f775a = context.getApplicationContext();
                i.f(str);
                i.h(str);
                i.n(j.r(b4.f775a));
                Context context2 = b4.f775a;
                String a10 = l.a(context2, "auth02");
                if (TextUtils.isEmpty(a10)) {
                    a10 = j.l(UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis());
                    l.b(context2, "auth02", a10);
                }
                i.p(a10);
                i.k();
                h.g("backupIp=" + i.f752a);
                b0.f732a = false;
                b0.f733b = false;
                b4.f776b.submit(new q.a());
            } else {
                h.i("不可重复初始化");
            }
            o.f765a = str;
            return s_instance;
        }
        h.i("初始化参数不能为空");
        o.f765a = str;
        return s_instance;
    }

    public UniAccountHelper initHostName(String str) {
        q.b();
        if (q.i(str)) {
            return s_instance;
        }
        n.a("初始化参数错误");
        return null;
    }

    public void releaseNetwork() {
        q.b();
        q.t();
    }

    public UniAccountHelper setCertFingerType(String str) {
        if (!str.equalsIgnoreCase("MD5") && !str.equalsIgnoreCase("SHA1") && !str.equalsIgnoreCase("SHA256") && !str.equalsIgnoreCase("sm3")) {
            return null;
        }
        b.f730d = str.toLowerCase();
        return s_instance;
    }

    public UniAccountHelper setCryptoGM(boolean z10) {
        b.f727a = z10;
        return s_instance;
    }

    public void setDefaultLanguage(Language language) {
        o.f772h = language;
    }

    public void setLogEnable(boolean z10) {
        n.b(z10);
        q.b();
        q.f(z10);
    }

    public UniAccountHelper setUseCacheFlag(boolean z10) {
        b.f729c = z10;
        return s_instance;
    }
}
