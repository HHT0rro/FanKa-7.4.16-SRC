package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4599a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f4600b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f4601c;

    public d(c cVar, Context context, HashMap hashMap) {
        this.f4601c = cVar;
        this.f4599a = context;
        this.f4600b = hashMap;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() throws Exception {
        String a10;
        a10 = this.f4601c.a(this.f4599a, this.f4600b);
        return a10;
    }
}
