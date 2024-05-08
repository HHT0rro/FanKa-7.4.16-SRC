package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.parser.expr.expression.MethodCaller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ObjectMethod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l0 implements MethodCaller.Method {

    /* renamed from: f, reason: collision with root package name */
    private static final List<WeakReference<l0>> f28187f = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    private final Object f28188a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f28189b;

    /* renamed from: c, reason: collision with root package name */
    private final String f28190c;

    /* renamed from: d, reason: collision with root package name */
    private final int f28191d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f28192e;

    private l0(Object obj, Method method, int i10) {
        this.f28188a = obj;
        this.f28189b = method;
        this.f28191d = i10;
        this.f28190c = method.getName();
        this.f28192e = a(method);
    }

    public static boolean a(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length > 0) {
            return o0.class.isAssignableFrom(parameterTypes[0]);
        }
        return false;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.MethodCaller.Method
    public Object invoke(@NonNull o0 o0Var, @NonNull Object... objArr) throws Exception {
        if (this.f28192e) {
            return this.f28189b.invoke(this.f28188a, o0Var, objArr);
        }
        if (this.f28189b.getParameterTypes().length == 0) {
            return this.f28189b.invoke(this.f28188a, new Object[0]);
        }
        return this.f28189b.invoke(this.f28188a, objArr);
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.MethodCaller.Method
    @NonNull
    public String name() {
        return this.f28190c;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.MethodCaller.Method
    public int phase() {
        return this.f28191d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r0 = r6.getClass().getMethods();
        r1 = r0.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r2 >= r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (java.lang.reflect.Modifier.isPublic(r3.getModifiers()) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r4 = (com.huawei.flexiblelayout.k0) r3.getAnnotation(com.huawei.flexiblelayout.k0.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r4 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        if (r7.equals(r4.alias()) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        r7 = new com.huawei.flexiblelayout.l0(r6, r3, r4.phase());
        com.huawei.flexiblelayout.l0.f28187f.add(new java.lang.ref.WeakReference<>(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r7.equals(r3.getName()) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        r7 = new com.huawei.flexiblelayout.l0(r6, r3);
        com.huawei.flexiblelayout.l0.f28187f.add(new java.lang.ref.WeakReference<>(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.flexiblelayout.l0 a(@androidx.annotation.NonNull java.lang.Object r6, @androidx.annotation.NonNull java.lang.String r7) {
        /*
            java.util.List<java.lang.ref.WeakReference<com.huawei.flexiblelayout.l0>> r0 = com.huawei.flexiblelayout.l0.f28187f
            java.util.Iterator r0 = r0.iterator2()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2f
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            com.huawei.flexiblelayout.l0 r2 = (com.huawei.flexiblelayout.l0) r2
            if (r2 != 0) goto L20
            java.util.List<java.lang.ref.WeakReference<com.huawei.flexiblelayout.l0>> r0 = com.huawei.flexiblelayout.l0.f28187f
            r0.remove(r1)
            goto L2f
        L20:
            java.lang.Object r1 = r2.f28188a
            if (r1 != r6) goto L6
            java.lang.String r1 = r2.name()
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L6
            return r2
        L2f:
            java.lang.Class r0 = r6.getClass()
            java.lang.reflect.Method[] r0 = r0.getMethods()
            int r1 = r0.length
            r2 = 0
        L39:
            if (r2 >= r1) goto L8d
            r3 = r0[r2]
            int r4 = r3.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isPublic(r4)
            if (r4 != 0) goto L48
            goto L8a
        L48:
            java.lang.Class<com.huawei.flexiblelayout.k0> r4 = com.huawei.flexiblelayout.k0.class
            java.lang.annotation.Annotation r4 = r3.getAnnotation(r4)
            com.huawei.flexiblelayout.k0 r4 = (com.huawei.flexiblelayout.k0) r4
            if (r4 == 0) goto L70
            java.lang.String r5 = r4.alias()
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L70
            com.huawei.flexiblelayout.l0 r7 = new com.huawei.flexiblelayout.l0
            int r0 = r4.phase()
            r7.<init>(r6, r3, r0)
            java.util.List<java.lang.ref.WeakReference<com.huawei.flexiblelayout.l0>> r6 = com.huawei.flexiblelayout.l0.f28187f
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r7)
            r6.add(r0)
            return r7
        L70:
            java.lang.String r4 = r3.getName()
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L8a
            com.huawei.flexiblelayout.l0 r7 = new com.huawei.flexiblelayout.l0
            r7.<init>(r6, r3)
            java.util.List<java.lang.ref.WeakReference<com.huawei.flexiblelayout.l0>> r6 = com.huawei.flexiblelayout.l0.f28187f
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r7)
            r6.add(r0)
            return r7
        L8a:
            int r2 = r2 + 1
            goto L39
        L8d:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.flexiblelayout.l0.a(java.lang.Object, java.lang.String):com.huawei.flexiblelayout.l0");
    }

    private l0(Object obj, Method method) {
        this(obj, method, 0);
    }
}
