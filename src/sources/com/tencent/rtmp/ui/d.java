package com.tencent.rtmp.ui;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TXCloudVideoView f45360a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45361b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45362c;

    /* renamed from: d, reason: collision with root package name */
    private final int f45363d;

    /* renamed from: e, reason: collision with root package name */
    private final int f45364e;

    private d(TXCloudVideoView tXCloudVideoView, int i10, int i11, int i12, int i13) {
        this.f45360a = tXCloudVideoView;
        this.f45361b = i10;
        this.f45362c = i11;
        this.f45363d = i12;
        this.f45364e = i13;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView, int i10, int i11, int i12, int i13) {
        return new d(tXCloudVideoView, i10, i11, i12, i13);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f45360a.showFocusViewInternal(this.f45361b, this.f45362c, this.f45363d, this.f45364e);
    }
}
