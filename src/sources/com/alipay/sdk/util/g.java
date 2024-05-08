package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g implements AlipayResultActivity.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f4732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f4733b;

    public g(e eVar, CountDownLatch countDownLatch) {
        this.f4733b = eVar;
        this.f4732a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.b
    public void a(int i10, String str, String str2) {
        this.f4733b.f4729i = com.alipay.sdk.app.j.a(i10, str, str2);
        this.f4732a.countDown();
    }
}
