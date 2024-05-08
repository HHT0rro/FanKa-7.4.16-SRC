package com.hailiang.advlib.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: ICliFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements _factory {

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f27142d;

    /* renamed from: e, reason: collision with root package name */
    public static a f27143e;

    /* renamed from: a, reason: collision with root package name */
    public _factory f27144a = null;

    /* renamed from: b, reason: collision with root package name */
    public Context f27145b;

    /* renamed from: c, reason: collision with root package name */
    public final QMConfig f27146c;

    public a(@NonNull QMConfig qMConfig) {
        this.f27146c = qMConfig;
        this.f27145b = qMConfig.getContext();
        c();
        f27143e = this;
    }

    private boolean a() {
        if (this.f27144a == null) {
            c();
        }
        return this.f27144a != null;
    }

    private void b() {
        _factory _factoryVar = (_factory) com.hailiang.advlib.common.b.c().a(_factory.class, this.f27145b, this.f27146c, "12.426");
        this.f27144a = _factoryVar;
        if (_factoryVar != null) {
            f27142d = true;
        }
    }

    private void c() {
        if (com.hailiang.advlib.common.b.c().b(_factory.class) == null) {
            ed.a.b(this.f27146c);
        }
        b();
    }

    @Override // com.hailiang.advlib.core._factory
    public void appListFromClientNotice() {
        if (a()) {
            this.f27144a.appListFromClientNotice();
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public IMultiAdRequest createNativeMultiAdRequest() {
        return (IMultiAdRequest) com.hailiang.advlib.common.b.c().a(IMultiAdRequest.class, new Object[0]);
    }

    @Override // com.hailiang.advlib.core._factory
    public void notifyMsg(int i10, Bundle bundle) {
        if (a()) {
            this.f27144a.notifyMsg(i10, bundle);
        }
    }

    @Override // com.hailiang.advlib.core._factory, java.lang.Runnable
    public void run() {
        if (a()) {
            this.f27144a.run();
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void setAppList(List<PackageInfo> list) {
        if (a()) {
            this.f27144a.setAppList(list);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void setImageAutoDownload(boolean z10) {
        if (a()) {
            this.f27144a.setImageAutoDownload(z10);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void terminate() {
        if (a()) {
            this.f27144a.terminate();
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void useDebugServer(boolean z10) {
        if (a()) {
            this.f27144a.useDebugServer(z10);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void whenPermDialogReturns(int i10, String[] strArr, int[] iArr) {
        if (a()) {
            this.f27144a.whenPermDialogReturns(i10, strArr, iArr);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void useDebugServer(int i10) {
        if (a()) {
            this.f27144a.useDebugServer(i10);
        }
    }

    public static a a(QMConfig qMConfig) {
        a aVar = f27143e;
        return aVar != null ? aVar : new a(qMConfig);
    }
}
