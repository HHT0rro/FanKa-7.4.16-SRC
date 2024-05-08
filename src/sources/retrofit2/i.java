package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: Invocation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Method f53430a;

    /* renamed from: b, reason: collision with root package name */
    public final List<?> f53431b;

    public i(Method method, List<?> list) {
        this.f53430a = method;
        this.f53431b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f53430a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f53430a.getDeclaringClass().getName(), this.f53430a.getName(), this.f53431b);
    }
}
