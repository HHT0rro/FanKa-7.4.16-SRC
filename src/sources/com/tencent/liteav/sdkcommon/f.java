package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f43165a;

    /* renamed from: b, reason: collision with root package name */
    private final String f43166b;

    /* renamed from: c, reason: collision with root package name */
    private final String f43167c;

    private f(DashboardManager dashboardManager, String str, String str2) {
        this.f43165a = dashboardManager;
        this.f43166b = str;
        this.f43167c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new f(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43165a.appendLogInternal(this.f43166b, this.f43167c);
    }
}
