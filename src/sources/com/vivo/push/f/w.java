package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.f.u;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class w implements u.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f46222a;

    public w(v vVar) {
        this.f46222a = vVar;
    }

    @Override // com.vivo.push.f.u.a
    public final void a() {
        long k10 = com.vivo.push.m.a().k();
        if (k10 < 1400 && k10 != 1340) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(k10)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f46222a.f46220b.f()));
        String a10 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a10)) {
            hashMap.put("app_id", a10);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) hashMap);
    }

    @Override // com.vivo.push.f.u.a
    public final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.f46222a.f46220b.f()));
        String a10 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a10)) {
            hashMap.put("remoteAppId", a10);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) hashMap);
    }
}
