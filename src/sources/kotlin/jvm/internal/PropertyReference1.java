package kotlin.jvm.internal;

import kotlin.reflect.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.reflect.l {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.b computeReflected() {
        return v.h(this);
    }

    public abstract /* synthetic */ Object get(Object obj);

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.l) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((kotlin.reflect.l) getReflected()).getGetter();
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
