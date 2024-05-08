package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hq;
import com.xiaomi.push.id;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import com.xiaomi.push.o6;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48356c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f48357d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48358e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x f48359f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, int i10, String str, List list, String str2) {
        super(i10);
        this.f48359f = xVar;
        this.f48356c = str;
        this.f48357d = list;
        this.f48358e = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        String d10;
        XMPushService xMPushService;
        d10 = this.f48359f.d(this.f48356c);
        ArrayList<ip> b4 = kc.z.b(this.f48357d, this.f48356c, d10, 32768);
        if (b4 == null) {
            fc.c.n("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<ip> iterator2 = b4.iterator2();
        while (iterator2.hasNext()) {
            ip next = iterator2.next();
            next.a("uploadWay", "longXMPushService");
            im d11 = j0.d(this.f48356c, d10, next, hq.Notification);
            if (!TextUtils.isEmpty(this.f48358e) && !TextUtils.equals(this.f48356c, this.f48358e)) {
                if (d11.m3002a() == null) {
                    id idVar = new id();
                    idVar.a("-1");
                    d11.a(idVar);
                }
                d11.m3002a().b("ext_traffic_source_pkg", this.f48358e);
            }
            byte[] c4 = o6.c(d11);
            xMPushService = this.f48359f.f48355a;
            xMPushService.E(this.f48356c, c4, true);
        }
    }
}
