package com.huawei.jslite.type.jstojava;

import android.os.RemoteException;
import com.huawei.jslite.JSContext;
import com.huawei.jslite.type.CoerceJavaScriptToJava;
import com.koushikdutta.quack.JavaScriptObject;
import com.koushikdutta.quack.QuackContext;
import com.koushikdutta.quack.QuackJavaScriptObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CaptureVariablesCoercion implements CoerceJavaScriptToJava {
    private static final String TAG = "CaptureVarsCoercion";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$coerce$0(QuackContext quackContext, JavaScriptObject javaScriptObject, Object obj, Method method, Object[] objArr) throws Throwable {
        return quackContext.coerceJavaScriptToJava(method.getReturnType(), javaScriptObject.call(JavaScriptObject.coerceArgs(quackContext, method, objArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$coerce$1(JSContext jSContext, Map map, JavaScriptObject javaScriptObject, InvocationHandler invocationHandler, Object obj, Method method, Object[] objArr) throws Throwable {
        if (jSContext.isClose()) {
            for (Class<?> cls : method.getExceptionTypes()) {
                if (RemoteException.class.isAssignableFrom(cls)) {
                    throw new RemoteException("attempted to call a closed JavaScriptObject");
                }
            }
            return null;
        }
        Map<String, Object> map2 = jSContext.get();
        for (Map.Entry entry : map.entrySet()) {
            javaScriptObject.quackContext.getGlobalObject().set((String) entry.getKey(), entry.getValue());
        }
        Object invoke = invocationHandler.invoke(obj, method, objArr);
        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
            javaScriptObject.quackContext.getGlobalObject().set(entry2.getKey(), entry2.getValue());
        }
        return invoke;
    }

    @Override // com.huawei.jslite.type.CoerceJavaScriptToJava
    public Object coerce(Class<?> cls, Object obj) {
        final JavaScriptObject javaScriptObject;
        final QuackContext quackContext;
        final JSContext from;
        final InvocationHandler createInvocationHandler;
        if (!cls.isInterface() || !(obj instanceof JavaScriptObject) || (from = JSContext.from((quackContext = (javaScriptObject = (JavaScriptObject) obj).quackContext))) == null) {
            return null;
        }
        final Map<String, Object> map = from.get();
        if (QuackContext.getLambdaMethod(cls) != null) {
            createInvocationHandler = javaScriptObject.getWrappedInvocationHandler(new InvocationHandler() { // from class: com.huawei.jslite.type.jstojava.b
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj2, Method method, Object[] objArr) {
                    Object lambda$coerce$0;
                    lambda$coerce$0 = CaptureVariablesCoercion.lambda$coerce$0(QuackContext.this, javaScriptObject, obj2, method, objArr);
                    return lambda$coerce$0;
                }
            });
        } else {
            createInvocationHandler = javaScriptObject.createInvocationHandler();
        }
        return Proxy.newProxyInstance(QuackJavaScriptObject.class.getClassLoader(), new Class[]{QuackJavaScriptObject.class, cls}, new InvocationHandler() { // from class: com.huawei.jslite.type.jstojava.a
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                Object lambda$coerce$1;
                lambda$coerce$1 = CaptureVariablesCoercion.lambda$coerce$1(JSContext.this, map, javaScriptObject, createInvocationHandler, obj2, method, objArr);
                return lambda$coerce$1;
            }
        });
    }
}
