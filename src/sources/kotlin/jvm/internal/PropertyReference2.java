package kotlin.jvm.internal;

import kotlin.reflect.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class PropertyReference2 extends PropertyReference implements kotlin.reflect.m {
    public PropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.b computeReflected() {
        return v.i(this);
    }

    public abstract /* synthetic */ Object get(Object obj, Object obj2);

    @Override // kotlin.reflect.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.m) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public Object mo1743invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public PropertyReference2(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public m.a getGetter() {
        return ((kotlin.reflect.m) getReflected()).getGetter();
    }
}
