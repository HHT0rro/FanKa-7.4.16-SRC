package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NodeSaveImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, m> f46315a = new ConcurrentHashMap();

    @Override // com.vivo.push.restructure.a.a.n
    public final void a(com.vivo.push.restructure.a.a aVar, a aVar2) {
        if (aVar == null) {
            u.a("addToCache error. msg is null");
        } else if (TextUtils.isEmpty(aVar.a())) {
            u.a("addToCache error. messageID is null");
        } else if (aVar2 == null) {
            u.a("addToCache error. firstNode is null");
        }
    }
}
