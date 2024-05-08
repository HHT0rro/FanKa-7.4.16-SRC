package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.vivo.push.b.x;
import com.vivo.push.m;
import com.vivo.push.util.u;
import java.util.HashMap;

/* compiled from: ReportImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f46331a;

    public b(com.vivo.push.restructure.b.a aVar) {
        this.f46331a = aVar;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int i10, String str) {
        u.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i10);
        if (i10 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        x xVar = new x(i10);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", str);
        com.vivo.push.restructure.b.a aVar = this.f46331a;
        if (aVar != null) {
            String a10 = aVar.a();
            if (!TextUtils.isEmpty(a10)) {
                hashMap.put("remoteAppId", a10);
            }
        }
        xVar.a(hashMap);
        m.a().a(xVar);
    }
}
