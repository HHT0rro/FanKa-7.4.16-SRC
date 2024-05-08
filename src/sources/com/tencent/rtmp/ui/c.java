package com.tencent.rtmp.ui;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TXCloudVideoView f45359a;

    private c(TXCloudVideoView tXCloudVideoView) {
        this.f45359a = tXCloudVideoView;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView) {
        return new c(tXCloudVideoView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f45359a.hideIndicatorView();
    }
}
