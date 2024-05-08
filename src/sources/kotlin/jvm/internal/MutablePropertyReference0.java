package kotlin.jvm.internal;

import kotlin.reflect.g;
import kotlin.reflect.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.g {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.b computeReflected() {
        return v.d(this);
    }

    public abstract /* synthetic */ Object get();

    @Override // kotlin.reflect.k
    public Object getDelegate() {
        return ((kotlin.reflect.g) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(Object obj);

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public k.a getGetter() {
        return ((kotlin.reflect.g) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public g.a getSetter() {
        return ((kotlin.reflect.g) getReflected()).getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
