package com.huawei.flexiblelayout.script.vm;

import com.huawei.flexiblelayout.script.IScriptContext;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ScriptVM {

    /* renamed from: a, reason: collision with root package name */
    private final IScriptContext f28490a;

    /* renamed from: b, reason: collision with root package name */
    private JavaScriptObject f28491b;

    public ScriptVM(IScriptContext iScriptContext, String str) throws IllegalArgumentException {
        this.f28490a = iScriptContext;
        JavaScriptObject javaScriptObject = (JavaScriptObject) iScriptContext.evaluate(str, JavaScriptObject.class);
        this.f28491b = javaScriptObject;
        if (javaScriptObject == null) {
            throw new IllegalArgumentException("Illegal userScript");
        }
    }

    public Object callFunction(String str, Object... objArr) {
        return this.f28491b.callProperty(str, objArr);
    }

    public ScriptUserObject createObject(Map<String, Object> map) {
        JavaScriptObject javaScriptObject = (JavaScriptObject) callFunction("createObject", new Object[0]);
        if (javaScriptObject == null) {
            return null;
        }
        return new ScriptUserObject(javaScriptObject, map);
    }
}
