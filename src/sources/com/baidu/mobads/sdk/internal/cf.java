package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cf implements ao.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ by f10017a;

    public cf(by byVar) {
        this.f10017a = byVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        boolean z10;
        z10 = this.f10017a.A;
        if (z10) {
            this.f10017a.A = false;
            this.f10017a.a(false, "remote update Network access failed");
        }
    }
}
