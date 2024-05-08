package com.huawei.quickcard.base.annotation;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickAbilityInvocationHandler implements InvocationHandler {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33289b = "QuickAbilityInvocationH";

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f33290c = {"toString", TTDownloadField.TT_HASHCODE, "equals"};

    /* renamed from: a, reason: collision with root package name */
    private final Object f33291a;

    public QuickAbilityInvocationHandler(Object obj) {
        this.f33291a = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        CardLogUtils.d(f33289b, "invoke method " + method.getName());
        String name = method.getName();
        boolean z10 = false;
        for (String str : f33290c) {
            if (str.equals(name)) {
                return method.invoke(this.f33291a, objArr);
            }
        }
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        int length = declaredAnnotations.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (declaredAnnotations[i10] instanceof QuickMethod) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            return method.invoke(this.f33291a, objArr);
        }
        CardLogUtils.e(f33289b, "Error: Method [" + method.getName() + "] not found.");
        throw new NoSuchMethodException(method.getName());
    }
}
