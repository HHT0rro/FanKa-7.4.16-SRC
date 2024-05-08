package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.s;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConcurrentWeakMap.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {

    /* renamed from: a */
    @NotNull
    public static final f0 f51202a = new f0("REHASH");

    /* renamed from: b */
    @NotNull
    public static final g f51203b = new g(null);

    /* renamed from: c */
    @NotNull
    public static final g f51204c = new g(Boolean.TRUE);

    public static final g d(Object obj) {
        if (obj == null) {
            return f51203b;
        }
        return s.d(obj, Boolean.TRUE) ? f51204c : new g(obj);
    }

    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
