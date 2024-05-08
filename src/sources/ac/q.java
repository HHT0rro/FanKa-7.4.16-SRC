package ac;

import android.content.Context;
import java.net.InetAddress;
import java.security.Security;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class q {

    /* renamed from: c, reason: collision with root package name */
    public static volatile q f774c;

    /* renamed from: a, reason: collision with root package name */
    public Context f775a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f776b = Executors.newSingleThreadExecutor();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(q.p());
                if (allByName == null || allByName.length <= 0) {
                    b0.f732a = false;
                    return;
                }
                i.f752a = allByName[q.a(allByName.length)].getHostAddress();
                l.b(q.this.f775a, "auth400", s.b(i.f752a.getBytes()));
                b0.f732a = true;
            } catch (Exception e2) {
                b0.f733b = false;
                b0.f732a = false;
                q.s();
                e2.printStackTrace();
            }
        }
    }

    public static /* synthetic */ int a(int i10) {
        return Math.abs(new Random().nextInt() % i10);
    }

    public static q b() {
        if (f774c == null) {
            synchronized (q.class) {
                if (f774c == null) {
                    f774c = new q();
                }
            }
        }
        return f774c;
    }

    public static String d(Context context, String str, String str2) {
        return c.b(context, str, str2);
    }

    public static void e(p pVar, String str) {
        h.i(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", "CU");
            pVar.onResult(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void f(boolean z10) {
        h.e(z10);
    }

    public static boolean g(Context context) {
        return d.a(context) && d.c(context);
    }

    public static boolean h(Context context, String str, String str2, String str3) {
        return c.d(context, str, str2, str3);
    }

    public static boolean i(String str) {
        if (!str.equalsIgnoreCase("ali.wosms.cn") && !str.equalsIgnoreCase("msv6.wosms.cn") && !str.equalsIgnoreCase("m.zzx.cnklog.com")) {
            return false;
        }
        b.f731e = str;
        return true;
    }

    public static String j() {
        return b.a();
    }

    public static void k(Context context) {
        d.b(context);
    }

    public static String l() {
        return b.b();
    }

    public static void m(Context context) {
        d.d(context);
    }

    public static String n() {
        if (Security.getProvider("BC") == null) {
            return "Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) is null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Security.getProvider("BC").getVersion());
        return sb2.toString();
    }

    public static boolean o(Context context) {
        int k10 = j.k(context);
        return k10 == 0 || k10 == 1;
    }

    public static String p() {
        return b.f731e;
    }

    public static void q(Context context) {
        c.c(context);
    }

    public static String r() {
        return "auth.wosms.cn";
    }

    public static String s() {
        b.f731e = "msv6.wosms.cn";
        return "msv6.wosms.cn";
    }

    public static void t() {
        e.a().i();
    }
}
