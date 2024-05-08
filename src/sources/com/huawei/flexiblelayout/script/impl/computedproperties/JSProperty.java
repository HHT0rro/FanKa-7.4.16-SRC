package com.huawei.flexiblelayout.script.impl.computedproperties;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.koushikdutta.quack.JavaScriptObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JSProperty {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f28482a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ReadWriteField extends ReadonlyField {
        void set(@Nullable Object obj);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ReadonlyField {
        @Nullable
        Object get();
    }

    public JSProperty(@NonNull JavaScriptObject javaScriptObject) {
        if (javaScriptObject.isFunction()) {
            this.f28482a = javaScriptObject.quackContext.coerceJavaScriptToJava(ReadonlyField.class, javaScriptObject);
        } else {
            this.f28482a = javaScriptObject.quackContext.coerceJavaScriptToJava(ReadWriteField.class, javaScriptObject);
        }
    }

    public boolean a() {
        return this.f28482a instanceof ReadonlyField;
    }

    public boolean b() {
        return this.f28482a instanceof ReadWriteField;
    }

    @Nullable
    public Object get() {
        if (a()) {
            return ((ReadonlyField) this.f28482a).get();
        }
        return null;
    }

    public boolean set(@Nullable Object obj) {
        if (!b()) {
            return false;
        }
        ((ReadWriteField) this.f28482a).set(obj);
        return true;
    }
}
