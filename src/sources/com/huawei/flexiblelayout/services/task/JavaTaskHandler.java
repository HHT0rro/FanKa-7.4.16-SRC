package com.huawei.flexiblelayout.services.task;

import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.primitive.FLMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class JavaTaskHandler implements TaskHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Object f28622a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f28623b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f28624c = false;

    /* renamed from: d, reason: collision with root package name */
    private Exception f28625d;

    /* renamed from: e, reason: collision with root package name */
    private final FLMap f28626e;

    /* renamed from: f, reason: collision with root package name */
    private int f28627f;

    /* renamed from: g, reason: collision with root package name */
    private FLayout f28628g;

    public JavaTaskHandler(FLMap fLMap) {
        this.f28626e = fLMap;
    }

    @Override // com.huawei.flexiblelayout.services.task.TaskHandler
    public final void execute(FLayout fLayout, int i10) {
        this.f28628g = fLayout;
        this.f28627f = i10;
        synchronized (this.f28622a) {
            if (!this.f28623b && !isCompleted()) {
                this.f28623b = true;
                onExecute(fLayout, this.f28626e);
            }
        }
    }

    public void fail(Exception exc) {
        synchronized (this.f28622a) {
            this.f28625d = exc;
            this.f28624c = true;
            this.f28623b = false;
        }
    }

    @Override // com.huawei.flexiblelayout.services.task.TaskHandler
    public Exception getException() {
        Exception exc;
        synchronized (this.f28622a) {
            exc = this.f28625d;
        }
        return exc;
    }

    public int getPosition() {
        return this.f28627f;
    }

    @Override // com.huawei.flexiblelayout.services.task.TaskHandler
    public boolean isCompleted() {
        boolean z10;
        synchronized (this.f28622a) {
            z10 = this.f28624c;
        }
        return z10;
    }

    @Override // com.huawei.flexiblelayout.services.task.TaskHandler
    public boolean isSuccessful() {
        boolean z10;
        synchronized (this.f28622a) {
            z10 = this.f28624c && this.f28625d == null;
        }
        return z10;
    }

    public abstract void onExecute(FLayout fLayout, FLMap fLMap);

    @Override // com.huawei.flexiblelayout.services.task.TaskHandler
    public final void repeat() {
        synchronized (this.f28622a) {
            if (this.f28624c) {
                this.f28624c = false;
                execute(this.f28628g, this.f28627f);
            }
        }
    }

    public void success() {
        synchronized (this.f28622a) {
            this.f28625d = null;
            this.f28624c = true;
            this.f28623b = false;
        }
    }
}
