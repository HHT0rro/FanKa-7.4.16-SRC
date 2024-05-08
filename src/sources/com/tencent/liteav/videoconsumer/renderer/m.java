package com.tencent.liteav.videoconsumer.renderer;

import android.view.TextureView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final k f44115a;

    /* renamed from: b, reason: collision with root package name */
    private final TextureView f44116b;

    private m(k kVar, TextureView textureView) {
        this.f44115a = kVar;
        this.f44116b = textureView;
    }

    public static Runnable a(k kVar, TextureView textureView) {
        return new m(kVar, textureView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44115a.a(this.f44116b);
    }
}
