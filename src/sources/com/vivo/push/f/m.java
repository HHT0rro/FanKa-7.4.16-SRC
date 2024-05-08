package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46205a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f46206b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f46207c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f46208d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l f46209e;

    public m(l lVar, int i10, List list, List list2, String str) {
        this.f46209e = lVar;
        this.f46205a = i10;
        this.f46206b = list;
        this.f46207c = list2;
        this.f46208d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f46209e;
        PushMessageCallback pushMessageCallback = ((aa) lVar).f46183b;
        context = lVar.f46360a;
        pushMessageCallback.onDelTags(context, this.f46205a, this.f46206b, this.f46207c, this.f46208d);
    }
}
