package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u extends aa {

    /* compiled from: OnNotificationArrivedReceiveTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a();

        void b();
    }

    public u(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        if (vVar == null) {
            com.vivo.push.util.u.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.f46360a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) vVar;
        Context context = this.f46360a;
        if (!com.vivo.push.util.aa.d(context, context.getPackageName())) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(qVar.f()));
            String a10 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a10)) {
                hashMap.put("remoteAppId", a10);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(qVar.f())));
        com.vivo.push.util.u.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f46360a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(qVar.f()));
            String a11 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a11)) {
                hashMap2.put("remoteAppId", a11);
            }
            xVar2.a(hashMap2);
            com.vivo.push.m.a().a(xVar2);
            return;
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f46360a), qVar.e(), qVar.g())) {
            com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(qVar.f()));
            String a12 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a12)) {
                hashMap3.put("remoteAppId", a12);
            }
            xVar3.a(hashMap3);
            com.vivo.push.m.a().a(xVar3);
            return;
        }
        InsideNotificationItem d10 = qVar.d();
        if (d10 != null) {
            com.vivo.push.util.u.d("OnNotificationArrivedTask", "tragetType is " + d10.getTargetType() + " ; target is " + d10.getTragetContent());
            com.vivo.push.t.c(new v(this, d10, qVar));
            return;
        }
        com.vivo.push.util.u.a("OnNotificationArrivedTask", "notify is null");
        com.vivo.push.util.u.c(this.f46360a, "通知内容为空，" + qVar.f());
        com.vivo.push.util.f.a(qVar.f(), 1027L);
    }
}
