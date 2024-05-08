package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46190a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f46191b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f46192c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f46193d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ab f46194e;

    public ad(ab abVar, int i10, List list, List list2, String str) {
        this.f46194e = abVar;
        this.f46190a = i10;
        this.f46191b = list;
        this.f46192c = list2;
        this.f46193d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ab abVar = this.f46194e;
        PushMessageCallback pushMessageCallback = ((aa) abVar).f46183b;
        context = abVar.f46360a;
        pushMessageCallback.onSetAlias(context, this.f46190a, this.f46191b, this.f46192c, this.f46193d);
    }
}
