package com.tencent.liteav.videoconsumer.renderer;

import android.view.TextureView;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final k f44112a;

    /* renamed from: b, reason: collision with root package name */
    private final TXCloudVideoView f44113b;

    /* renamed from: c, reason: collision with root package name */
    private final TextureView f44114c;

    private l(k kVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        this.f44112a = kVar;
        this.f44113b = tXCloudVideoView;
        this.f44114c = textureView;
    }

    public static Runnable a(k kVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        return new l(kVar, tXCloudVideoView, textureView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.a(this.f44112a, this.f44113b, this.f44114c);
    }
}
