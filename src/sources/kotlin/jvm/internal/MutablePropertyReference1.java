package kotlin.jvm.internal;

import kotlin.reflect.h;
import kotlin.reflect.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.h {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.b computeReflected() {
        return v.e(this);
    }

    public abstract /* synthetic */ Object get(Object obj);

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.h) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public abstract /* synthetic */ void set(Object obj, Object obj2);

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((kotlin.reflect.h) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public h.a getSetter() {
        return ((kotlin.reflect.h) getReflected()).getSetter();
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
