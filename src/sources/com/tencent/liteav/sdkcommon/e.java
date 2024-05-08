package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f43162a;

    /* renamed from: b, reason: collision with root package name */
    private final String f43163b;

    /* renamed from: c, reason: collision with root package name */
    private final String f43164c;

    private e(DashboardManager dashboardManager, String str, String str2) {
        this.f43162a = dashboardManager;
        this.f43163b = str;
        this.f43164c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new e(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43162a.setStatusInternal(this.f43163b, this.f43164c);
    }
}
