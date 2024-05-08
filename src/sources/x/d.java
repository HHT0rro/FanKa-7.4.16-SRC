package x;

import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d implements i, j {
    @Override // x.j
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // x.i, x.j
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    @Override // x.i
    public final Object b(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }
}
