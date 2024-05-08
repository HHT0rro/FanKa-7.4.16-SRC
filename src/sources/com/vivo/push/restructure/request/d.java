package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.i;
import com.vivo.push.util.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: RequestManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, b> f46352a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f46353b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f46354c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f46355d;

    /* compiled from: RequestManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static d f46356a = new d(0);
    }

    public /* synthetic */ d(byte b4) {
        this();
    }

    private synchronized Integer b() {
        Integer valueOf;
        if (this.f46353b == null) {
            this.f46353b = 0;
        }
        if (this.f46353b.intValue() < 0 || this.f46353b.intValue() >= Integer.MAX_VALUE) {
            this.f46353b = 0;
        }
        valueOf = Integer.valueOf(this.f46353b.intValue() + 1);
        this.f46353b = valueOf;
        return new Integer(valueOf.intValue());
    }

    private d() {
        this.f46352a = new ConcurrentHashMap();
        this.f46353b = null;
        HandlerThread handlerThread = new HandlerThread("request_timer_task——thread");
        this.f46354c = handlerThread;
        handlerThread.start();
        this.f46355d = new e(this, this.f46354c.getLooper());
    }

    public static d a() {
        return a.f46356a;
    }

    public final void a(b bVar) {
        Integer b4 = b();
        int a10 = a(bVar.a().a(b4.intValue()));
        if (a10 != 0) {
            if (bVar.b() != null) {
                bVar.b().a(a10);
            }
        } else {
            if (bVar.c() <= 0 || bVar.b() == null) {
                return;
            }
            this.f46352a.put(b4, bVar);
            this.f46355d.sendEmptyMessageDelayed(b4.intValue(), bVar.c());
        }
    }

    public final void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.request.a.a h10;
        int b4;
        com.vivo.push.restructure.request.a.a.a aVar2;
        if (aVar == null || !aVar.g() || (b4 = (h10 = aVar.h()).b()) <= 0) {
            return;
        }
        this.f46355d.removeMessages(b4);
        b remove = this.f46352a.remove(Integer.valueOf(b4));
        if (remove == null || remove.b() == null || remove.a() == null) {
            return;
        }
        if (h10.c() == 0) {
            try {
                aVar2 = new com.vivo.push.restructure.request.a.a.a(aVar.i());
            } catch (JSONException e2) {
                e2.printStackTrace();
                aVar2 = null;
            }
            if (aVar2 != null) {
                remove.b().a((c) remove.a().a(aVar2));
                return;
            } else {
                remove.b().a(8003);
                return;
            }
        }
        remove.b().a(h10.c());
    }

    private static int a(Intent intent) {
        Context b4 = com.vivo.push.restructure.a.a().b();
        if (b4 == null) {
            return JosStatusCodes.RNT_CODE_NO_JOS_INFO;
        }
        i a10 = i.a(b4, "com.vivo.vms.aidlservice");
        if (a10.a() && !"com.vivo.pushservice".equals(b4.getPackageName())) {
            if (a10.a(intent.getExtras())) {
                return 0;
            }
            u.b("RequestManager", "send command error by aidl");
            u.c(b4, "send command error by aidl");
        }
        String k10 = com.vivo.push.restructure.a.a().e().k();
        if (TextUtils.isEmpty(k10)) {
            return JosStatusCodes.RTN_CODE_NO_SUPPORT_JOS;
        }
        Intent intent2 = new Intent("com.vivo.pushservice.action.METHOD");
        intent2.setPackage(k10);
        intent2.setClassName(k10, "com.vivo.push.sdk.service.PushService");
        try {
            com.vivo.push.a.a.a(b4, intent2);
        } catch (Exception e2) {
            u.a("RequestManager", "CommandBridge startService exception: ", e2);
        }
        return 0;
    }
}
