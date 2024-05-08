package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c {
    public static final String A = "ClientBindServiceFailed";
    public static final String B = "BindWaitTimeoutEx";
    public static final String C = "CheckClientExistEx";
    public static final String D = "CheckClientSignEx";
    public static final String E = "GetInstalledAppEx";
    public static final String F = "ParserTidClientKeyEx";
    public static final String G = "GetInstalledAppEx";
    public static final String H = "StartLaunchAppTransEx";
    public static final String I = "CheckLaunchAppExistEx";
    public static final String J = "LogCurrentAppLaunchSwitch";
    public static final String K = "LogCurrentQueryTime";
    public static final String L = "LogCalledPackage";
    public static final String M = "LogBindCalledH5";
    public static final String N = "LogCalledH5";
    public static final String O = "LogHkLoginByIntent";
    public static final String P = "SchemePayWrongHashEx";
    public static final String Q = "LogAppLaunchSwitchEnabled";
    public static final String R = "H5CbUrlEmpty";
    public static final String S = "H5CbEx";
    public static final String T = "tid_context_null";
    public static final String U = "partner";
    public static final String V = "out_trade_no";
    public static final String W = "trade_no";

    /* renamed from: a, reason: collision with root package name */
    public static final String f4431a = "net";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4432b = "biz";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4433c = "cp";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4434d = "auth";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4435e = "third";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4436f = "tid";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4437g = "FormatResultEx";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4438h = "GetApdidEx";

    /* renamed from: i, reason: collision with root package name */
    public static final String f4439i = "GetApdidNull";

    /* renamed from: j, reason: collision with root package name */
    public static final String f4440j = "GetApdidTimeout";

    /* renamed from: k, reason: collision with root package name */
    public static final String f4441k = "GetUtdidEx";

    /* renamed from: l, reason: collision with root package name */
    public static final String f4442l = "GetPackageInfoEx";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4443m = "NotIncludeSignatures";

    /* renamed from: n, reason: collision with root package name */
    public static final String f4444n = "GetInstalledPackagesEx";

    /* renamed from: o, reason: collision with root package name */
    public static final String f4445o = "GetPublicKeyFromSignEx";

    /* renamed from: p, reason: collision with root package name */
    public static final String f4446p = "H5PayNetworkError";

    /* renamed from: q, reason: collision with root package name */
    public static final String f4447q = "H5AuthNetworkError";

    /* renamed from: r, reason: collision with root package name */
    public static final String f4448r = "SSLError";

    /* renamed from: s, reason: collision with root package name */
    public static final String f4449s = "H5PayDataAnalysisError";

    /* renamed from: t, reason: collision with root package name */
    public static final String f4450t = "H5AuthDataAnalysisError";

    /* renamed from: u, reason: collision with root package name */
    public static final String f4451u = "PublicKeyUnmatch";

    /* renamed from: v, reason: collision with root package name */
    public static final String f4452v = "ClientBindFailed";

    /* renamed from: w, reason: collision with root package name */
    public static final String f4453w = "TriDesEncryptError";

    /* renamed from: x, reason: collision with root package name */
    public static final String f4454x = "TriDesDecryptError";

    /* renamed from: y, reason: collision with root package name */
    public static final String f4455y = "ClientBindException";

    /* renamed from: z, reason: collision with root package name */
    public static final String f4456z = "SaveTradeTokenError";
    private String X;
    private String Y;
    private String Z;

    /* renamed from: aa, reason: collision with root package name */
    private String f4457aa;

    /* renamed from: ab, reason: collision with root package name */
    private String f4458ab;

    /* renamed from: ac, reason: collision with root package name */
    private String f4459ac;

    /* renamed from: ad, reason: collision with root package name */
    private String f4460ad;

    /* renamed from: ae, reason: collision with root package name */
    private String f4461ae;
    private String af = "";
    private String ag;

    public c(Context context) {
        context = context != null ? context.getApplicationContext() : context;
        this.X = b();
        this.Z = a(context);
        this.f4457aa = c();
        this.f4458ab = d();
        this.f4459ac = b(context);
        this.f4460ad = "-";
        this.f4461ae = "-";
        this.ag = "-";
    }

    private String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
    }

    private String c(String str) {
        String str2;
        String[] split = str.split("&");
        String str3 = null;
        if (split != null) {
            String str4 = null;
            for (String str5 : split) {
                String[] split2 = str5.split("=");
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase("partner")) {
                        split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(V)) {
                        str3 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(W)) {
                        str4 = split2[1].replace("\"", "");
                    }
                }
            }
            str2 = str3;
            str3 = str4;
        } else {
            str2 = null;
        }
        String b4 = b(str3);
        String b10 = b(str2);
        return String.format("%s,%s,-,%s,-,-,-", b4, b10, b(b10));
    }

    private String d() {
        return String.format("%s,%s,-,-,-", b(com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a()), b(com.alipay.sdk.sys.b.a().e()));
    }

    public boolean a() {
        return TextUtils.isEmpty(this.af);
    }

    public void a(String str, String str2, Throwable th) {
        a(str, str2, a(th));
    }

    private String b() {
        return String.format("123456789,%s", new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    public void a(String str, String str2, Throwable th, String str3) {
        a(str, str2, a(th), str3);
    }

    public void a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!TextUtils.isEmpty(this.af)) {
            str5 = "^";
        }
        this.af += (str5 + String.format("%s,%s,%s,%s", str, str2, b(str3), str4));
    }

    private String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", b(com.alipay.sdk.util.a.d(context)), "android", b(Build.VERSION.RELEASE), b(Build.MODEL), "-", b(com.alipay.sdk.util.a.a(context).a()), b(com.alipay.sdk.util.a.b(context).b()), "gw", b(com.alipay.sdk.util.a.a(context).b()));
    }

    public void a(String str, String str2, String str3) {
        a(str, str2, str3, "-");
    }

    private String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(u.bD);
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + " 》 ");
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    private String c() {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", b("15.6.2"), b("h.a.3.6.2"));
    }

    public String a(String str) {
        if (a()) {
            return "";
        }
        String c4 = c(str);
        this.Y = c4;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.X, c4, this.Z, this.f4457aa, this.f4458ab, this.f4459ac, this.f4460ad, this.f4461ae, this.af, this.ag);
    }

    private String a(Context context) {
        String str;
        String str2;
        String str3 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    str3 = applicationContext.getPackageManager().getPackageInfo(str, 0).versionName;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = "-";
            }
            str2 = str3;
            str3 = str;
        } else {
            str2 = "-";
        }
        return String.format("%s,%s,-,-,-", str3, str2);
    }
}
