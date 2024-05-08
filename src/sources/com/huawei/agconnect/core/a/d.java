package com.huawei.agconnect.core.a;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static Map<Class<?>, c9.a> f27215c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static Map<Class<?>, Object> f27216d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public Map<Class<?>, c9.a> f27217a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map<Class<?>, Object> f27218b = new HashMap();

    public d(List<c9.a> list, Context context) {
        c(list, context);
    }

    public static Constructor a(Class cls, Class... clsArr) {
        boolean z10 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i10 = 0; i10 < clsArr.length; i10++) {
                    z10 = parameterTypes[i10] == clsArr[i10];
                }
                if (z10) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public final void b(String str, Exception exc) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Instantiate shared service ");
        sb2.append(str);
        sb2.append(exc.getLocalizedMessage());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("cause message:");
        sb3.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007a, IllegalAccessException -> 0x007e, TryCatch #2 {IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007a, IllegalAccessException -> 0x007e, TryCatch #2 {IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(java.util.List<c9.a> r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L3
            return
        L3:
            java.util.Iterator r7 = r7.iterator2()
        L7:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L85
            java.lang.Object r0 = r7.next()
            c9.a r0 = (c9.a) r0
            boolean r1 = r0.d()
            if (r1 == 0) goto L28
            java.util.Map<java.lang.Class<?>, c9.a> r1 = com.huawei.agconnect.core.a.d.f27215c
            java.lang.Class r2 = r0.a()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L31
            java.util.Map<java.lang.Class<?>, c9.a> r1 = com.huawei.agconnect.core.a.d.f27215c
            goto L2a
        L28:
            java.util.Map<java.lang.Class<?>, c9.a> r1 = r6.f27217a
        L2a:
            java.lang.Class r2 = r0.a()
            r1.put(r2, r0)
        L31:
            boolean r1 = r0.c()
            if (r1 == 0) goto L7
            java.lang.Class r1 = r0.b()
            if (r1 == 0) goto L7
            java.util.Map<java.lang.Class<?>, java.lang.Object> r1 = com.huawei.agconnect.core.a.d.f27216d
            java.lang.Class r2 = r0.a()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L7
            java.lang.Class r1 = r0.b()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.reflect.Constructor r1 = a(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            if (r1 == 0) goto L64
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            r2[r5] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            goto L6c
        L64:
            java.lang.Class r1 = r0.b()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
        L6c:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = com.huawei.agconnect.core.a.d.f27216d     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Class r0 = r0.a()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            r2.put(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            goto L7
        L76:
            r0 = move-exception
            java.lang.String r1 = "TargetException"
            goto L81
        L7a:
            r0 = move-exception
            java.lang.String r1 = "InstantiationException"
            goto L81
        L7e:
            r0 = move-exception
            java.lang.String r1 = "AccessException"
        L81:
            r6.b(r1, r0)
            goto L7
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.c(java.util.List, android.content.Context):void");
    }
}
