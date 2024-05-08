package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cm;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cb implements cm.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ by f10010a;

    public cb(by byVar) {
        this.f10010a = byVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cm.a
    public void a(String str) {
        try {
            this.f10010a.b();
            this.f10010a.a(str);
        } catch (Throwable th) {
            bs.a().a(th);
        }
    }
}
