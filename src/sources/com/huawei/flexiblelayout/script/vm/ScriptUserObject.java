package com.huawei.flexiblelayout.script.vm;

import com.huawei.jslite.JSContext;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ScriptUserObject {

    /* renamed from: a, reason: collision with root package name */
    private final JavaScriptObject f28489a;

    public ScriptUserObject(JavaScriptObject javaScriptObject, Map<String, Object> map) {
        this.f28489a = javaScriptObject;
        VMRevisionHelper.b(javaScriptObject);
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    setVariant(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Object callFunction(String str, Object... objArr) {
        if (getVariant(str) instanceof JavaScriptObject) {
            return this.f28489a.callProperty(str, objArr);
        }
        return null;
    }

    public Object evaluateThis(String str) {
        return JSContext.from(this.f28489a.quackContext).evaluate(str, this.f28489a);
    }

    public Object getVariant(String str) {
        return this.f28489a.get(str);
    }

    public void reset() {
        VMRevisionHelper.b(this.f28489a);
    }

    public void setVariant(String str, Object obj) {
        this.f28489a.set(str, obj);
    }

    public <T> T evaluateThis(String str, Class<T> cls) {
        return (T) JSContext.from(this.f28489a.quackContext).evaluate(str, this.f28489a, cls);
    }
}
