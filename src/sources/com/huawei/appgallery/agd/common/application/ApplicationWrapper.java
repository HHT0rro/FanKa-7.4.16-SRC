package com.huawei.appgallery.agd.common.application;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ApplicationWrapper {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f27338b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static ApplicationWrapper f27339c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f27340a;

    public ApplicationWrapper(Context context) {
        this.f27340a = context;
    }

    public static ApplicationWrapper getInstance() {
        ApplicationWrapper applicationWrapper;
        synchronized (f27338b) {
            applicationWrapper = f27339c;
        }
        return applicationWrapper;
    }

    public static void init(Context context) {
        synchronized (f27338b) {
            f27339c = new ApplicationWrapper(context);
        }
    }

    public Context getContext() {
        return this.f27340a;
    }
}
