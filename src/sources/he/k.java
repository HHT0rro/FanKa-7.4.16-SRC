package he;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SubscriberMethod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final Method f49634a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadMode f49635b;

    /* renamed from: c, reason: collision with root package name */
    public final Class<?> f49636c;

    /* renamed from: d, reason: collision with root package name */
    public final int f49637d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f49638e;

    /* renamed from: f, reason: collision with root package name */
    public String f49639f;

    public k(Method method, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f49634a = method;
        this.f49635b = threadMode;
        this.f49636c = cls;
        this.f49637d = i10;
        this.f49638e = z10;
    }

    public final synchronized void a() {
        if (this.f49639f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f49634a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f49634a.getName());
            sb2.append('(');
            sb2.append(this.f49636c.getName());
            this.f49639f = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        a();
        k kVar = (k) obj;
        kVar.a();
        return this.f49639f.equals(kVar.f49639f);
    }

    public int hashCode() {
        return this.f49634a.hashCode();
    }
}
