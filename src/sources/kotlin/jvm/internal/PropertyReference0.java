package kotlin.jvm.internal;

import kotlin.reflect.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.k {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.b computeReflected() {
        return v.g(this);
    }

    public abstract /* synthetic */ Object get();

    @Override // kotlin.reflect.k
    public Object getDelegate() {
        return ((kotlin.reflect.k) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public k.a getGetter() {
        return ((kotlin.reflect.k) getReflected()).getGetter();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
