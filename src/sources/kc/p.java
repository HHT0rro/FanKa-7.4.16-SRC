package kc;

import android.content.Context;
import com.xiaomi.push.a4;
import com.xiaomi.push.hq;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.l6;
import com.xiaomi.push.o6;
import com.xiaomi.push.s3;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.x3;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p implements a4 {
    @Override // com.xiaomi.push.a4
    public void a(Context context, HashMap<String, String> hashMap) {
        ip ipVar = new ip();
        ipVar.b(x3.b(context).d());
        ipVar.d(x3.b(context).n());
        ipVar.c(ia.AwakeAppResponse.f329a);
        ipVar.a(m.a());
        ipVar.f468a = hashMap;
        byte[] c4 = o6.c(com.xiaomi.push.service.j0.d(ipVar.c(), ipVar.b(), ipVar, hq.Notification));
        if (!(context instanceof XMPushService)) {
            fc.c.i("MoleInfo : context is not correct in pushLayer " + ipVar.a());
            return;
        }
        fc.c.i("MoleInfo : send data directly in pushLayer " + ipVar.a());
        ((XMPushService) context).E(context.getPackageName(), c4, true);
    }

    @Override // com.xiaomi.push.a4
    public void b(Context context, HashMap<String, String> hashMap) {
        fc.c.i("MoleInfo：\u3000" + s3.e(hashMap));
    }

    @Override // com.xiaomi.push.a4
    public void c(Context context, HashMap<String, String> hashMap) {
        l6 a10 = l6.a(context);
        if (a10 != null) {
            a10.f("category_awake_app", "wake_up_app", 1L, s3.c(hashMap));
        }
    }
}
