package com.koushikdutta.quack;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JavaScriptObject implements QuackObject, QuackJavaScriptObject {
    public final long context;
    public final long pointer;
    public final QuackContext quackContext;

    public JavaScriptObject(QuackContext quackContext, long j10, long j11) {
        this.quackContext = quackContext;
        this.context = j10;
        this.pointer = j11;
    }

    public static Object[] coerceArgs(QuackContext quackContext, Method method, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return objArr;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (objArr.length == parameterTypes.length) {
            int length = parameterTypes.length;
            if (method.isVarArgs()) {
                length--;
            }
            for (int i10 = 0; i10 < length; i10++) {
                objArr[i10] = quackContext.coerceJavaToJavaScript(parameterTypes[i10], objArr[i10]);
            }
            if (!method.isVarArgs()) {
                return objArr;
            }
            Class<?> componentType = method.getParameterTypes()[length].getComponentType();
            ArrayList arrayList = new ArrayList(Arrays.asList(objArr).subList(0, length));
            Object obj = objArr[length];
            for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
                arrayList.add(quackContext.coerceJavaScriptToJava(componentType, Array.get(obj, i11)));
            }
            return arrayList.toArray();
        }
        throw new AssertionError((Object) "JavaScript.createInvocationHandler different args count?");
    }

    private String getTypeName() {
        Object obj;
        Object obj2 = get("constructor");
        if (!(obj2 instanceof JavaScriptObject) || (obj = ((JavaScriptObject) obj2).get("name")) == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$createInvocationHandler$1(Object obj, Method method, Object[] objArr) throws Throwable {
        Method interfaceMethod = QuackContext.getInterfaceMethod(method);
        QuackMethodCoercion quackMethodCoercion = this.quackContext.JavaToJavascriptMethodCoercions.get(interfaceMethod);
        if (quackMethodCoercion != null) {
            return quackMethodCoercion.invoke(interfaceMethod, this, objArr);
        }
        QuackProperty quackProperty = (QuackProperty) method.getAnnotation(QuackProperty.class);
        if (quackProperty != null) {
            if (objArr != null && objArr.length != 0) {
                set(quackProperty.name(), this.quackContext.coerceJavaScriptToJava(method.getParameterTypes()[0], objArr[0]));
                return null;
            }
            return this.quackContext.coerceJavaScriptToJava(method.getReturnType(), get(quackProperty.name()));
        }
        String name = method.getName();
        QuackMethodName quackMethodName = (QuackMethodName) method.getAnnotation(QuackMethodName.class);
        if (quackMethodName != null) {
            name = quackMethodName.name();
        }
        return this.quackContext.coerceJavaScriptToJava(method.getReturnType(), callProperty(name, coerceArgs(this.quackContext, method, objArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getWrappedInvocationHandler$0(InvocationHandler invocationHandler, Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == QuackJavaScriptObject.class) {
            return method.invoke(this, objArr);
        }
        return invocationHandler.invoke(obj, method, objArr);
    }

    public JSValue asJSValue() {
        return new JSValue(this.quackContext, this);
    }

    public Object call(Object... objArr) {
        this.quackContext.coerceJavaArgsToJavaScript(objArr);
        QuackContext quackContext = this.quackContext;
        return quackContext.coerceJavaScriptToJava(null, quackContext.call(this.pointer, objArr));
    }

    @Override // com.koushikdutta.quack.QuackObject
    public Object callMethod(Object obj, Object... objArr) {
        this.quackContext.coerceJavaArgsToJavaScript(objArr);
        QuackContext quackContext = this.quackContext;
        return quackContext.coerceJavaScriptToJava(null, quackContext.callMethod(this.pointer, quackContext.coerceJavaToJavaScript(obj), objArr));
    }

    public Object callProperty(Object obj, Object... objArr) {
        this.quackContext.coerceJavaArgsToJavaScript(objArr);
        QuackContext quackContext = this.quackContext;
        return quackContext.coerceJavaScriptToJava(null, quackContext.callProperty(this.pointer, obj, objArr));
    }

    public <T> T constructCoerced(Class<T> cls, Object... objArr) {
        this.quackContext.coerceJavaArgsToJavaScript(objArr);
        QuackContext quackContext = this.quackContext;
        return (T) quackContext.coerceJavaScriptToJava(cls, quackContext.callConstructor(this.pointer, objArr));
    }

    public InvocationHandler createInvocationHandler() {
        return getWrappedInvocationHandler(new InvocationHandler() { // from class: com.koushikdutta.quack.h
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object lambda$createInvocationHandler$1;
                lambda$createInvocationHandler$1 = JavaScriptObject.this.lambda$createInvocationHandler$1(obj, method, objArr);
                return lambda$createInvocationHandler$1;
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        QuackContext quackContext = this.quackContext;
        if (quackContext != null) {
            quackContext.finalizeJavaScriptObject(this.pointer);
        }
    }

    public Object get(String str) {
        QuackContext quackContext = this.quackContext;
        return quackContext.coerceJavaScriptToJava(null, quackContext.getKeyString(this.pointer, str));
    }

    public JavaScriptObject getFunctionThis() {
        QuackContext quackContext = this.quackContext;
        return (JavaScriptObject) quackContext.coerceJavaScriptToJava(null, quackContext.getFunctionThis(this.pointer));
    }

    @Override // com.koushikdutta.quack.QuackJavaScriptObject
    public JavaScriptObject getJavaScriptObject() {
        return this;
    }

    @Override // com.koushikdutta.quack.QuackJavaScriptObject
    public long getNativeContext() {
        return this.context;
    }

    @Override // com.koushikdutta.quack.QuackJavaScriptObject
    public long getNativePointer() {
        return this.pointer;
    }

    public InvocationHandler getWrappedInvocationHandler(final InvocationHandler invocationHandler) {
        return this.quackContext.getWrappedInvocationHandler(this, new InvocationHandler() { // from class: com.koushikdutta.quack.i
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object lambda$getWrappedInvocationHandler$0;
                lambda$getWrappedInvocationHandler$0 = JavaScriptObject.this.lambda$getWrappedInvocationHandler$0(invocationHandler, obj, method, objArr);
                return lambda$getWrappedInvocationHandler$0;
            }
        });
    }

    @Override // com.koushikdutta.quack.QuackObject
    public /* synthetic */ boolean has(Object obj) {
        return m0.d(this, obj);
    }

    public boolean isArray() {
        return "Array".equals(getTypeName());
    }

    public boolean isFunction() {
        return "Function".equals(getTypeName());
    }

    public <T> T proxyInterface(Class<T> cls, Class... clsArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QuackJavaScriptObject.class);
        arrayList.add(cls);
        if (clsArr != null) {
            Collections.addAll(arrayList, clsArr);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), (Class[]) arrayList.toArray(new Class[0]), createInvocationHandler());
    }

    public boolean set(String str, Object obj) {
        return this.quackContext.setKeyString(this.pointer, str, obj);
    }

    public String stringify() {
        return this.quackContext.stringify(this.pointer);
    }

    public String toString() {
        Object callProperty = callProperty("toString", new Object[0]);
        if (callProperty == null) {
            return null;
        }
        return callProperty.toString();
    }

    public String typeof() {
        return (String) this.quackContext.evaluateForJavaScriptObject("(function(f) { return typeof f; })").call(this);
    }

    @Override // com.koushikdutta.quack.QuackObject
    public JavaScriptObject construct(Object... objArr) {
        return (JavaScriptObject) constructCoerced(JavaScriptObject.class, objArr);
    }

    public Object get(int i10) {
        QuackContext quackContext = this.quackContext;
        return quackContext.coerceJavaScriptToJava(null, quackContext.getKeyInteger(this.pointer, i10));
    }

    public boolean set(int i10, Object obj) {
        return this.quackContext.setKeyInteger(this.pointer, i10, obj);
    }

    @Override // com.koushikdutta.quack.QuackObject
    public Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (Integer.valueOf(number.intValue()).equals(number)) {
                return get(number.intValue());
            }
        }
        QuackContext quackContext = this.quackContext;
        return quackContext.coerceJavaScriptToJava(null, quackContext.getKeyObject(this.pointer, quackContext.coerceJavaToJavaScript(obj)));
    }

    @Override // com.koushikdutta.quack.QuackObject
    public boolean set(Object obj, Object obj2) {
        if (obj instanceof String) {
            return set((String) obj, obj2);
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number.doubleValue() == number.intValue()) {
                return set(number.intValue(), obj2);
            }
        }
        return this.quackContext.setKeyObject(this.pointer, obj, obj2);
    }
}
