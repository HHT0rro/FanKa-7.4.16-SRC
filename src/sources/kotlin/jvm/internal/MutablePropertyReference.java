package kotlin.jvm.internal;

import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class MutablePropertyReference extends PropertyReference {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    @NotNull
    public abstract /* synthetic */ j.a getGetter();

    @NotNull
    public abstract /* synthetic */ kotlin.reflect.f getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
