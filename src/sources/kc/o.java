package kc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.push.f6;
import com.xiaomi.push.fl;
import com.xiaomi.push.g3;
import com.xiaomi.push.h6;
import com.xiaomi.push.i3;
import com.xiaomi.push.n7;
import com.xiaomi.push.r1;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.u1;
import com.xiaomi.push.u4;
import com.xiaomi.push.u5;
import com.xiaomi.push.v1;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import kc.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o extends x.a implements v1.a {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f50845a;

    /* renamed from: b, reason: collision with root package name */
    public long f50846b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements v1.b {
        @Override // com.xiaomi.push.v1.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(39));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", u5.b(Build.MODEL + com.huawei.openalliance.ad.constant.u.bD + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(n7.a()));
            String builder = buildUpon.toString();
            fc.c.m("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String h10 = com.xiaomi.push.j0.h(n7.b(), url);
                h6.g(url.getHost() + com.huawei.openalliance.ad.constant.u.bD + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return h10;
            } catch (IOException e2) {
                h6.g(url.getHost() + com.huawei.openalliance.ad.constant.u.bD + port, -1, e2);
                throw e2;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b extends v1 {
        public b(Context context, u1 u1Var, v1.b bVar, String str) {
            super(context, u1Var, bVar, str);
        }

        @Override // com.xiaomi.push.v1
        public String f(ArrayList<String> arrayList, String str, String str2, boolean z10) {
            try {
                if (f6.f().k()) {
                    str2 = x.f();
                }
                return super.f(arrayList, str, str2, z10);
            } catch (IOException e2) {
                h6.d(0, fl.GSLB_ERR.a(), 1, null, com.xiaomi.push.j0.p(v1.f48422j) ? 1 : 0);
                throw e2;
            }
        }
    }

    public o(XMPushService xMPushService) {
        this.f50845a = xMPushService;
    }

    public static void d(XMPushService xMPushService) {
        o oVar = new o(xMPushService);
        x.h().k(oVar);
        synchronized (v1.class) {
            v1.k(oVar);
            v1.j(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.v1.a
    public v1 a(Context context, u1 u1Var, v1.b bVar, String str) {
        return new b(context, u1Var, bVar, str);
    }

    @Override // kc.x.a
    public void b(g3 g3Var) {
    }

    @Override // kc.x.a
    public void c(i3 i3Var) {
        r1 p10;
        if (i3Var.p() && i3Var.n() && System.currentTimeMillis() - this.f50846b > 3600000) {
            fc.c.i("fetch bucket :" + i3Var.n());
            this.f50846b = System.currentTimeMillis();
            v1 c4 = v1.c();
            c4.i();
            c4.r();
            u4 e2 = this.f50845a.e();
            if (e2 == null || (p10 = c4.p(e2.c().l())) == null) {
                return;
            }
            ArrayList<String> c10 = p10.c();
            boolean z10 = true;
            Iterator<String> iterator2 = c10.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                } else if (iterator2.next().equals(e2.d())) {
                    z10 = false;
                    break;
                }
            }
            if (!z10 || c10.isEmpty()) {
                return;
            }
            fc.c.i("bucket changed, force reconnect");
            this.f50845a.r(0, null);
            this.f50845a.F(false);
        }
    }
}
