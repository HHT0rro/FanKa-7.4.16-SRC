package com.koushikdutta.quack;

import com.huawei.jslite.JavaObjectV2;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JSValue implements QuackJavaObject {
    public QuackContext quack;
    public Object value;

    public JSValue(QuackContext quackContext, Object obj) {
        this.quack = quackContext;
        this.value = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterator lambda$asIterable$0(final JSValue jSValue, final JSValue jSValue2, final Class cls) {
        return new Iterator() { // from class: com.koushikdutta.quack.JSValue.1
            public JSValue current;

            private void maybeNext() {
                if (this.current != null) {
                    return;
                }
                this.current = jSValue.apply(jSValue2, new Object[0]);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                maybeNext();
                return !((Boolean) this.current.get("done").getObject()).booleanValue();
            }

            @Override // java.util.Iterator
            public Object next() {
                maybeNext();
                if (!((Boolean) this.current.get("done").getObject()).booleanValue()) {
                    Object as = this.current.get("value").as(cls);
                    this.current = null;
                    return as;
                }
                throw new NoSuchElementException("end of iterator");
            }
        };
    }

    private QuackObject quackify() {
        Object obj = this.value;
        if (obj instanceof QuackObject) {
            return (QuackObject) obj;
        }
        return new JavaObjectV2(this.quack, this.value);
    }

    public JSValue apply(Object obj, Object... objArr) {
        return new JSValue(this.quack, quackify().callMethod(obj, objArr));
    }

    public <T> T as(Class<T> cls) {
        return (T) this.quack.coerceJavaScriptToJava(cls, this.value);
    }

    public <T> Iterable<T> asIterable(final Class<T> cls) {
        final JSValue apply = get(this.quack.evaluateForJavaScriptObject("Symbol").asJSValue().get("iterator")).apply(this, new Object[0]);
        final JSValue jSValue = apply.get("next");
        return new Iterable() { // from class: com.koushikdutta.quack.a
            @Override // java.lang.Iterable
            /* renamed from: iterator */
            public final Iterator iterator2() {
                Iterator lambda$asIterable$0;
                lambda$asIterable$0 = JSValue.this.lambda$asIterable$0(jSValue, apply, cls);
                return lambda$asIterable$0;
            }
        };
    }

    public JSValue construct(Object... objArr) {
        return new JSValue(this.quack, quackify().construct(objArr));
    }

    public JSValue get(Object obj) {
        return new JSValue(this.quack, quackify().get(obj));
    }

    @Override // com.koushikdutta.quack.QuackJavaObject
    public Object getObject() {
        return this.value;
    }

    public boolean has(Object obj) {
        return quackify().has(obj);
    }

    public boolean isByteBuffer() {
        return this.value instanceof ByteBuffer;
    }

    public boolean isJavaScriptObject() {
        return this.value instanceof JavaScriptObject;
    }

    public boolean isNullOrUndefined() {
        return this.value == null;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public boolean set(Object obj, Object obj2) {
        return quackify().set(obj, obj2);
    }

    public String toString() {
        Object obj = this.value;
        return obj == null ? "null" : obj.toString();
    }
}
