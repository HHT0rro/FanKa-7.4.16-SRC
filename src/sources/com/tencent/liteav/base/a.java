package com.tencent.liteav.base;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final a f42741a = new a();

    private a() {
    }

    public static Callable a() {
        return f42741a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String[] privateDataDirectorySuffixInternal;
        privateDataDirectorySuffixInternal = PathUtils.setPrivateDataDirectorySuffixInternal();
        return privateDataDirectorySuffixInternal;
    }
}
