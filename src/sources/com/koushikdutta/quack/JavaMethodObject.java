package com.koushikdutta.quack;

import com.koushikdutta.quack.QuackMethodObject;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JavaMethodObject implements QuackMethodObject {
    public Method[] methods;
    public Object originalThis;
    public QuackContext quackContext;
    public String target;

    public JavaMethodObject(QuackContext quackContext, Object obj, String str) {
        this.quackContext = quackContext;
        this.originalThis = obj;
        this.target = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Method lambda$callMethod$0(Method[] methodArr, ArrayList arrayList) {
        QuackMethodName quackMethodName;
        Method method = null;
        int i10 = Integer.MAX_VALUE;
        for (Method method2 : methodArr) {
            if (method2.getName().equals(this.target) || ((quackMethodName = (QuackMethodName) method2.getAnnotation(QuackMethodName.class)) != null && quackMethodName.name().equals(this.target))) {
                int abs = Math.abs(arrayList.size() - method2.getParameterTypes().length) * 1000;
                for (int i11 = 0; i11 < Math.min(method2.getParameterTypes().length, arrayList.size()); i11++) {
                    Class<?> cls = (Class) arrayList.get(i11);
                    Class<?> cls2 = method2.getParameterTypes()[i11];
                    if (cls2 == cls) {
                        abs -= 5;
                    }
                    if (QuackContext.isNumberClass(cls2) && QuackContext.isNumberClass(cls)) {
                        abs -= 4;
                    } else if (QuackContext.isBoolClass(cls2) && QuackContext.isBoolClass(cls)) {
                        abs -= 3;
                    } else if ((cls2 == Long.class || cls2 == Long.TYPE) && cls == String.class) {
                        abs -= 2;
                    } else if (cls == null || cls2.isAssignableFrom(cls)) {
                        abs--;
                    }
                }
                if (abs < i10) {
                    method = method2;
                    i10 = abs;
                }
            }
        }
        return method;
    }

    public static <T> T[] toArray(Class<T> cls, ArrayList<T> arrayList) {
        return (T[]) arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, 0));
    }

    @Override // com.koushikdutta.quack.QuackObject
    public Object callMethod(Object obj, Object... objArr) {
        Method memoize;
        if (obj == null || (obj instanceof JavaScriptObject)) {
            obj = this.originalThis;
        }
        if (obj != null) {
            Object coerceJavaScriptToJava = this.quackContext.coerceJavaScriptToJava(Object.class, obj);
            boolean z10 = coerceJavaScriptToJava instanceof Class;
            if (z10 && "forName".equals(this.target)) {
                throw new UnsupportedOperationException("can not call " + this.target);
            }
            final Method[] methods = getMethods(coerceJavaScriptToJava);
            int i10 = 0;
            if (methods.length == 1) {
                memoize = methods[0];
            } else {
                final ArrayList arrayList = new ArrayList();
                for (Object obj2 : objArr) {
                    if (obj2 instanceof JavaObject) {
                        obj2 = ((JavaObject) obj2).getObject();
                    }
                    if (obj2 == null) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(obj2.getClass());
                    }
                }
                memoize = QuackContext.javaObjectMethodCandidates.memoize(new MemoizeFunc() { // from class: com.koushikdutta.quack.b
                    @Override // com.koushikdutta.quack.MemoizeFunc
                    public final Object process() {
                        Method lambda$callMethod$0;
                        lambda$callMethod$0 = JavaMethodObject.this.lambda$callMethod$0(methods, arrayList);
                        return lambda$callMethod$0;
                    }
                }, this.target, z10 ? coerceJavaScriptToJava : coerceJavaScriptToJava.getClass(), arrayList.toArray());
            }
            if (memoize != null) {
                Object obj3 = getThis(coerceJavaScriptToJava, memoize);
                try {
                    Method interfaceMethod = QuackContext.getInterfaceMethod(memoize);
                    QuackMethodCoercion quackMethodCoercion = this.quackContext.JavaScriptToJavaMethodCoercions.get(interfaceMethod);
                    if (quackMethodCoercion != null) {
                        return quackMethodCoercion.invoke(interfaceMethod, obj3, objArr);
                    }
                    int length = memoize.getParameterTypes().length;
                    if (memoize.isVarArgs()) {
                        length--;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    while (i10 < length) {
                        if (i10 < objArr.length) {
                            arrayList2.add(this.quackContext.coerceJavaScriptToJava(memoize.getParameterTypes()[i10], objArr[i10]));
                        } else {
                            arrayList2.add(null);
                        }
                        i10++;
                    }
                    if (memoize.isVarArgs()) {
                        Class<?> componentType = memoize.getParameterTypes()[length].getComponentType();
                        ArrayList arrayList3 = new ArrayList();
                        while (i10 < objArr.length) {
                            arrayList3.add(this.quackContext.coerceJavaScriptToJava(componentType, objArr[i10]));
                            i10++;
                        }
                        arrayList2.add(toArray(componentType, arrayList3));
                    } else if (i10 < objArr.length) {
                        System.err.println("dropping javascript to java arguments on the floor: " + (objArr.length - i10) + " " + memoize.toString());
                    }
                    return this.quackContext.coerceJavaToJavaScript(memoize.invoke(obj3, arrayList2.toArray()));
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (RuntimeException e10) {
                    throw e10;
                } catch (InvocationTargetException e11) {
                    if (!(e11.getTargetException() instanceof RuntimeException)) {
                        if (e11.getTargetException() instanceof Error) {
                            throw ((Error) e11.getTargetException());
                        }
                        throw new RuntimeException(e11.getTargetException());
                    }
                    throw ((RuntimeException) e11.getTargetException());
                }
            }
            throw new UnsupportedOperationException("can not call " + this.target);
        }
        throw new UnsupportedOperationException("can not call " + this.target);
    }

    @Override // com.koushikdutta.quack.QuackObject
    public /* synthetic */ Object construct(Object... objArr) {
        return m0.b(this, objArr);
    }

    @Override // com.koushikdutta.quack.QuackMethodObject, com.koushikdutta.quack.QuackObject
    public /* synthetic */ Object get(Object obj) {
        return QuackMethodObject.CC.a(this, obj);
    }

    public Method[] getMethods(Object obj) {
        Method[] methodArr = this.methods;
        if (methodArr != null) {
            return methodArr;
        }
        Method[] methods = obj.getClass().getMethods();
        this.methods = methods;
        if (!(obj instanceof Class)) {
            return methods;
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, this.methods);
        Collections.addAll(arrayList, ((Class) obj).getMethods());
        Method[] methodArr2 = (Method[]) arrayList.toArray(new Method[0]);
        this.methods = methodArr2;
        return methodArr2;
    }

    public Object getThis(Object obj, Method method) {
        return obj;
    }

    @Override // com.koushikdutta.quack.QuackObject
    public /* synthetic */ boolean has(Object obj) {
        return m0.d(this, obj);
    }

    @Override // com.koushikdutta.quack.QuackObject
    public /* synthetic */ boolean set(Object obj, Object obj2) {
        return m0.e(this, obj, obj2);
    }

    public JavaMethodObject(QuackContext quackContext, Object obj, String str, Method[] methodArr) {
        this(quackContext, obj, str);
        this.methods = methodArr;
    }
}
