package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.script.impl.computedproperties.ComputedProperty;
import com.huawei.flexiblelayout.script.impl.interactive.ScriptFunction;
import com.huawei.jslite.JSContext;
import com.koushikdutta.quack.JavaScriptObject;

/* compiled from: Computed.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e1 implements ScriptFunction {

    /* renamed from: a, reason: collision with root package name */
    private static final e1 f28119a = new e1();

    private e1() {
    }

    public static e1 a() {
        return f28119a;
    }

    @Override // com.huawei.flexiblelayout.script.impl.interactive.ScriptFunction
    public Object invoke(Object... objArr) {
        if (objArr == null || objArr.length < 1 || !(objArr[0] instanceof JavaScriptObject)) {
            return null;
        }
        return new ComputedProperty((JavaScriptObject) objArr[0]);
    }

    public void a(JSContext jSContext) {
        jSContext.set("computed", jSContext.coerceJavaToJavaScript(ScriptFunction.class, this));
    }
}
