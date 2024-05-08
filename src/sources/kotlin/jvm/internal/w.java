package kotlin.jvm.internal;

/* compiled from: ReflectionFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w {
    public kotlin.reflect.e a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.c b(Class cls) {
        return new m(cls);
    }

    public kotlin.reflect.d c(Class cls, String str) {
        return new u(cls, str);
    }

    public kotlin.reflect.g d(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.h e(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.i f(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public kotlin.reflect.k g(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.l h(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.m i(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String j(q qVar) {
        String obj = qVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String k(Lambda lambda) {
        return j(lambda);
    }
}
