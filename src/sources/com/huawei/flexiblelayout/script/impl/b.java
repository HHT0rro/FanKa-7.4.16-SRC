package com.huawei.flexiblelayout.script.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.common.Debuggable;
import com.huawei.flexiblelayout.e1;
import com.huawei.flexiblelayout.g1;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.jslite.JSContext;
import com.huawei.jslite.type.CoerceJavaScriptToJava;
import com.koushikdutta.quack.JavaScriptObject;
import java.lang.ref.WeakReference;

/* compiled from: ScriptContextImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b implements IScriptContext {

    /* renamed from: e, reason: collision with root package name */
    private static final String f28459e = "ScriptContextImpl";

    /* renamed from: a, reason: collision with root package name */
    private int f28460a = 0;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private String f28461b;

    /* renamed from: c, reason: collision with root package name */
    private final JSContext f28462c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<c> f28463d;

    public b(JSContext jSContext, c cVar) {
        this.f28462c = jSContext;
        Console.a().a(jSContext);
        com.huawei.flexiblelayout.script.impl.interactive.a.a().a(jSContext);
        e1.a().a(jSContext);
        g1.a(jSContext);
        a.a().a(this);
        this.f28463d = new WeakReference<>(cVar);
    }

    public void a(int i10) {
        this.f28460a = i10;
    }

    @Nullable
    public String b() {
        return this.f28461b;
    }

    public int c() {
        return this.f28460a;
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public Object callFunction(@NonNull String str, Object... objArr) {
        Object obj = get(str);
        if (!(obj instanceof JavaScriptObject)) {
            return null;
        }
        JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
        if (javaScriptObject.isFunction()) {
            return javaScriptObject.call(objArr);
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    @Nullable
    public Object evaluate(@NonNull String str) {
        try {
            return this.f28462c.evaluate(str);
        } catch (Exception e2) {
            if (Debuggable.isDebuggable()) {
                Log.e(f28459e, "Exception when evaluating script: ", e2);
                return null;
            }
            Log.e(f28459e, "Exception when evaluating script: " + e2.getMessage());
            return null;
        }
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    @Nullable
    public Object get(@NonNull String str) {
        return this.f28462c.get(str);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public boolean isClosed() {
        return this.f28462c.isClose();
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public void release() {
        c cVar = this.f28463d.get();
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public void set(@NonNull String str, @Nullable Object obj) {
        this.f28462c.set(str, obj);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    public void setCoerceJavaScriptToJava(CoerceJavaScriptToJava coerceJavaScriptToJava) {
        this.f28462c.setCoerceJavaScriptToJava(coerceJavaScriptToJava);
    }

    public void a(@Nullable String str) {
        this.f28461b = str;
    }

    public void a() {
        this.f28462c.close();
    }

    @Override // com.huawei.flexiblelayout.script.IScriptContext
    @Nullable
    public <T> T evaluate(@NonNull String str, Class<T> cls) {
        try {
            return (T) this.f28462c.evaluate(str, cls);
        } catch (Exception e2) {
            if (Debuggable.isDebuggable()) {
                Log.e(f28459e, "Exception when evaluating script with generic type: " + ((Object) cls) + ", err: ", e2);
                return null;
            }
            Log.e(f28459e, "Exception when evaluating script with generic type: " + ((Object) cls) + ", err: " + e2.getMessage());
            return null;
        }
    }
}
