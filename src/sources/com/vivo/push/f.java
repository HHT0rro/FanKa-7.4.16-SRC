package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class f implements c.a<e> {
    private static e b(String str) {
        try {
            return new e(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e2) {
            com.vivo.push.util.u.a(8101, e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ e a(String str) {
        return b(str);
    }
}
