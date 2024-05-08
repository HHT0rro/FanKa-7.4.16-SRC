package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f46211b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f46212c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f46213d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l f46214e;

    public n(l lVar, int i10, List list, List list2, String str) {
        this.f46214e = lVar;
        this.f46210a = i10;
        this.f46211b = list;
        this.f46212c = list2;
        this.f46213d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f46214e;
        PushMessageCallback pushMessageCallback = ((aa) lVar).f46183b;
        context = lVar.f46360a;
        pushMessageCallback.onDelAlias(context, this.f46210a, this.f46211b, this.f46212c, this.f46213d);
    }
}
