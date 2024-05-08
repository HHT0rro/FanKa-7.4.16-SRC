package com.huawei.flexiblelayout.services.exposure.impl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VisibilityEvent implements FrameEvent {

    /* renamed from: a, reason: collision with root package name */
    public int f28584a;

    /* renamed from: b, reason: collision with root package name */
    public VisibilityListener f28585b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f28586c;

    public void a(int i10, VisibilityListener visibilityListener, boolean z10) {
        this.f28584a = i10;
        this.f28585b = visibilityListener;
        this.f28586c = z10;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.FrameEvent
    public int identifier() {
        return this.f28584a;
    }

    @Override // com.huawei.flexiblelayout.services.exposure.reusable.ReusableObject
    public void reset() {
        a(0, null, false);
    }
}
