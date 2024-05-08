package com.huawei.qcardsupport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.flexiblelayout.script.vm.ScriptUserObject;
import com.huawei.jslite.type.CoerceJavaScriptToJava;

/* compiled from: VMScriptContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class j implements IScriptContext {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final IScriptContext f33143a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final ScriptUserObject f33144b;

    public j(@NonNull IScriptContext iScriptContext, @NonNull ScriptUserObject scriptUserObject) {
        this.f33143a = iScriptContext;
        this.f33144b = scriptUserObject;
    }

    public void a() {
        this.f33144b.reset();
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public Object callFunction(@NonNull String str, Object... objArr) {
        return this.f33144b.callFunction(str, objArr);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    @Nullable
    public Object evaluate(@NonNull String str) {
        return this.f33144b.evaluateThis(str);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    @Nullable
    public Object get(@NonNull String str) {
        return this.f33144b.getVariant(str);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public boolean isClosed() {
        return this.f33143a.isClosed();
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public void release() {
        this.f33143a.release();
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public void set(@NonNull String str, @Nullable Object obj) {
        this.f33144b.setVariant(str, obj);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public void setCoerceJavaScriptToJava(CoerceJavaScriptToJava coerceJavaScriptToJava) {
        this.f33143a.setCoerceJavaScriptToJava(coerceJavaScriptToJava);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    @Nullable
    public <T> T evaluate(@NonNull String str, Class<T> cls) {
        return (T) this.f33144b.evaluateThis(str, cls);
    }
}
