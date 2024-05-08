package x;

import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c implements i, j {
    @Override // x.j
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // x.i, x.j
    public final boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }

    @Override // x.i
    public final Object b(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }
}
