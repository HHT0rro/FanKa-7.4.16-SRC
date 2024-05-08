package com.huawei.flexiblelayout.script.vm;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.huawei.jslite.JSContext;
import com.huawei.jslite.type.CoerceJavaScriptToJava;
import com.koushikdutta.quack.JavaScriptObject;
import com.koushikdutta.quack.QuackContext;
import com.koushikdutta.quack.QuackJavaScriptObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VMCoercion implements CoerceJavaScriptToJava {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28492a = "VMCoercion";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(QuackContext quackContext, Class cls, JavaScriptObject javaScriptObject, Object obj, Method method, Object[] objArr) throws Throwable {
        Object callProperty;
        Object[] coerceArgs = JavaScriptObject.coerceArgs(quackContext, method, objArr);
        if (QuackContext.getLambdaMethod(cls) != null) {
            callProperty = javaScriptObject.call(coerceArgs);
        } else {
            callProperty = javaScriptObject.callProperty(method.getName(), coerceArgs);
        }
        return quackContext.coerceJavaScriptToJava(method.getReturnType(), callProperty);
    }

    @Override // com.huawei.jslite.type.CoerceJavaScriptToJava
    public Object coerce(final Class<?> cls, Object obj) {
        final JavaScriptObject javaScriptObject;
        final QuackContext quackContext;
        final JSContext from;
        if (!cls.isInterface() || !(obj instanceof JavaScriptObject) || (from = JSContext.from((quackContext = (javaScriptObject = (JavaScriptObject) obj).quackContext))) == null) {
            return null;
        }
        VMRevisionHelper.b(javaScriptObject);
        final InvocationHandler wrappedInvocationHandler = javaScriptObject.getWrappedInvocationHandler(new InvocationHandler() { // from class: com.huawei.flexiblelayout.script.vm.b
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                Object a10;
                a10 = VMCoercion.a(QuackContext.this, cls, javaScriptObject, obj2, method, objArr);
                return a10;
            }
        });
        return Proxy.newProxyInstance(QuackJavaScriptObject.class.getClassLoader(), new Class[]{QuackJavaScriptObject.class, cls}, new InvocationHandler() { // from class: com.huawei.flexiblelayout.script.vm.a
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                Object a10;
                a10 = VMCoercion.this.a(from, javaScriptObject, wrappedInvocationHandler, obj2, method, objArr);
                return a10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object a(JSContext jSContext, JavaScriptObject javaScriptObject, InvocationHandler invocationHandler, Object obj, Method method, Object[] objArr) throws Throwable {
        if (jSContext.isClose()) {
            a(method, "attempted to call a closed JavaScriptObject");
            return null;
        }
        JavaScriptObject a10 = a(javaScriptObject, method.getName());
        if (a10 != null && !VMRevisionHelper.a(javaScriptObject, a10)) {
            a(method, "attempted to call a reused JavaScriptObject");
            return null;
        }
        return invocationHandler.invoke(obj, method, objArr);
    }

    private void a(Method method, String str) throws RemoteException {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (RemoteException.class.isAssignableFrom(cls)) {
                throw new RemoteException(str);
            }
        }
    }

    private JavaScriptObject a(@NonNull JavaScriptObject javaScriptObject, @NonNull String str) {
        if (javaScriptObject.isFunction()) {
            return javaScriptObject.getFunctionThis();
        }
        Object obj = javaScriptObject.get(str);
        if (!(obj instanceof JavaScriptObject)) {
            return null;
        }
        JavaScriptObject javaScriptObject2 = (JavaScriptObject) obj;
        if (javaScriptObject2.isFunction()) {
            return javaScriptObject2.getFunctionThis();
        }
        return null;
    }
}
