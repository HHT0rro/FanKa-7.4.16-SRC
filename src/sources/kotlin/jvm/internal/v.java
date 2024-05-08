package kotlin.jvm.internal;

/* compiled from: Reflection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final w f51035a;

    /* renamed from: b, reason: collision with root package name */
    public static final kotlin.reflect.c[] f51036b;

    static {
        w wVar = null;
        try {
            wVar = (w) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (wVar == null) {
            wVar = new w();
        }
        f51035a = wVar;
        f51036b = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        return f51035a.a(functionReference);
    }

    public static kotlin.reflect.c b(Class cls) {
        return f51035a.b(cls);
    }

    public static kotlin.reflect.d c(Class cls) {
        return f51035a.c(cls, "");
    }

    public static kotlin.reflect.g d(MutablePropertyReference0 mutablePropertyReference0) {
        return f51035a.d(mutablePropertyReference0);
    }

    public static kotlin.reflect.h e(MutablePropertyReference1 mutablePropertyReference1) {
        return f51035a.e(mutablePropertyReference1);
    }

    public static kotlin.reflect.i f(MutablePropertyReference2 mutablePropertyReference2) {
        return f51035a.f(mutablePropertyReference2);
    }

    public static kotlin.reflect.k g(PropertyReference0 propertyReference0) {
        return f51035a.g(propertyReference0);
    }

    public static kotlin.reflect.l h(PropertyReference1 propertyReference1) {
        return f51035a.h(propertyReference1);
    }

    public static kotlin.reflect.m i(PropertyReference2 propertyReference2) {
        return f51035a.i(propertyReference2);
    }

    public static String j(q qVar) {
        return f51035a.j(qVar);
    }

    public static String k(Lambda lambda) {
        return f51035a.k(lambda);
    }
}
