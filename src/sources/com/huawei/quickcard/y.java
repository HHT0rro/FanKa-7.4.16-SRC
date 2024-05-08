package com.huawei.quickcard;

import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.watcher.IWatcherCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y {

    /* renamed from: e, reason: collision with root package name */
    private static final String f34741e = "DPWatcher";

    /* renamed from: a, reason: collision with root package name */
    private final IWatcherCallback f34742a;

    /* renamed from: b, reason: collision with root package name */
    private final QuickCardValue f34743b;

    /* renamed from: c, reason: collision with root package name */
    private int f34744c;

    /* renamed from: d, reason: collision with root package name */
    private String f34745d;

    public y(int i10, String str, QuickCardValue quickCardValue, IWatcherCallback iWatcherCallback) {
        this.f34744c = i10;
        this.f34745d = str;
        this.f34743b = quickCardValue;
        this.f34742a = iWatcherCallback;
    }

    public String a() {
        return this.f34745d;
    }

    public int b() {
        return this.f34744c;
    }

    public void c() {
        QuickCardValue quickCardValue;
        IWatcherCallback iWatcherCallback = this.f34742a;
        if (iWatcherCallback == null || (quickCardValue = this.f34743b) == null) {
            return;
        }
        iWatcherCallback.onUpdate(quickCardValue);
    }
}
