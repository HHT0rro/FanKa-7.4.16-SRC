package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Object> f4292a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Map<String, Object>> f4293b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    private byte f4294c = 0;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f4295d = new AtomicInteger();

    /* renamed from: e, reason: collision with root package name */
    private x f4296e;

    public z(x xVar) {
        this.f4296e = xVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z10 = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        ThreadLocal<Object> threadLocal = f4292a;
        threadLocal.set(null);
        ThreadLocal<Map<String, Object>> threadLocal2 = f4293b;
        threadLocal2.set(null);
        if (operationType == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String value = operationType.value();
        int incrementAndGet = this.f4295d.incrementAndGet();
        try {
            if (this.f4294c == 0) {
                com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(incrementAndGet, value, objArr);
                if (threadLocal2.get() != null) {
                    eVar.a(threadLocal2.get());
                }
                byte[] bArr = (byte[]) new j(this.f4296e.a(), method, incrementAndGet, value, eVar.a(), z10).a();
                threadLocal2.set(null);
                Object a10 = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, bArr).a();
                if (genericReturnType != Void.TYPE) {
                    threadLocal.set(a10);
                }
            }
            return threadLocal.get();
        } catch (RpcException e2) {
            e2.setOperationType(value);
            throw e2;
        }
    }
}
