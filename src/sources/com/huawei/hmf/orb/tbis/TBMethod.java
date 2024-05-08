package com.huawei.hmf.orb.tbis;

import com.huawei.hmf.orb.tbis.result.TBResultParser;
import com.huawei.hmf.services.internal.ApplicationContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TBMethod {
    private static final TBMethodCache mCache = new TBMethodCache();
    private static volatile List<String> mObjectMethodList = null;
    private NativeTypeBridge mNativeTypeBridge;
    private Class<?> mReturnType;
    private final Method method;
    private final String name;

    private TBMethod(String str, Method method) {
        this.name = str;
        this.method = method;
    }

    private static List<TBMethod> generateTBMethodList(List<MethodBean> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            MethodBean methodBean = list.get(i10);
            arrayList.add(new TBMethod(methodBean.getFinalName(), methodBean.method));
        }
        return arrayList;
    }

    private static List<MethodBean> getMethodList(Class cls) {
        List<String> objectMethodList = getObjectMethodList();
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getMethods()) {
            if (!objectMethodList.contains(method.getName())) {
                arrayList.add(new MethodBean(method));
            }
        }
        return arrayList;
    }

    private static List<String> getObjectMethodList() {
        if (mObjectMethodList == null) {
            synchronized (ApplicationContext.class) {
                if (mObjectMethodList == null) {
                    ArrayList arrayList = new ArrayList();
                    for (Method method : Object.class.getMethods()) {
                        arrayList.add(method.getName());
                    }
                    mObjectMethodList = arrayList;
                }
            }
        }
        return mObjectMethodList;
    }

    private static List<MethodBean> identifyParamSignMethods(List<MethodBean> list) {
        Collections.sort(list, MethodBean.getComparator());
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            MethodBean methodBean = list.get(i10);
            MethodBean methodBean2 = i10 == 0 ? null : list.get(i10 - 1);
            if (methodBean2 != null && methodBean.name.equals(methodBean2.name)) {
                methodBean.isParamSignMethod = true;
                if (methodBean2.isNamed != -1 && methodBean2.paramLength == methodBean.paramLength) {
                    methodBean2.isParamSignMethod = true;
                }
                if (methodBean.paramLength == 0) {
                    methodBean2.isNamed = 0;
                }
            }
            i10++;
        }
        return list;
    }

    public static List<TBMethod> of(Class cls) {
        TBMethodCache tBMethodCache = mCache;
        List<TBMethod> list = tBMethodCache.get(cls);
        return list != null ? list : tBMethodCache.put(cls, generateTBMethodList(identifyParamSignMethods(getMethodList(cls))));
    }

    public Type[] getGenericParameterTypes() {
        Type[] genericParameterTypes = this.method.getGenericParameterTypes();
        this.mNativeTypeBridge = new NativeTypeBridge(genericParameterTypes);
        return genericParameterTypes;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getReturnType() {
        if (this.mReturnType == null) {
            this.mReturnType = this.method.getReturnType();
        }
        return this.mReturnType;
    }

    public Object invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        NativeTypeBridge nativeTypeBridge = this.mNativeTypeBridge;
        if (nativeTypeBridge != null) {
            objArr = nativeTypeBridge.process(objArr);
        }
        Object invoke = this.method.invoke(obj, objArr);
        if (invoke == null) {
            return null;
        }
        return TBResultParser.parser(getReturnType(), invoke).getValue();
    }
}
