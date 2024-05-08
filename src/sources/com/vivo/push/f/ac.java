package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f46186b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f46187c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f46188d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ab f46189e;

    public ac(ab abVar, int i10, List list, List list2, String str) {
        this.f46189e = abVar;
        this.f46185a = i10;
        this.f46186b = list;
        this.f46187c = list2;
        this.f46188d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ab abVar = this.f46189e;
        PushMessageCallback pushMessageCallback = ((aa) abVar).f46183b;
        context = abVar.f46360a;
        pushMessageCallback.onSetTags(context, this.f46185a, this.f46186b, this.f46187c, this.f46188d);
    }
}
