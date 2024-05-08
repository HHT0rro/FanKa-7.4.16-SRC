package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainDispatchers.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v f51419a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f51420b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final x1 f51421c;

    static {
        v vVar = new v();
        f51419a = vVar;
        f51420b = g0.e("kotlinx.coroutines.fast.service.loader", true);
        f51421c = vVar.a();
    }

    public final x1 a() {
        List<u> u10;
        u next;
        x1 e2;
        try {
            if (f51420b) {
                u10 = k.f51395a.c();
            } else {
                u10 = SequencesKt___SequencesKt.u(SequencesKt__SequencesKt.c(ServiceLoader.load(u.class, u.class.getClassLoader()).iterator2()));
            }
            Iterator<u> iterator2 = u10.iterator2();
            if (iterator2.hasNext()) {
                next = iterator2.next();
                if (iterator2.hasNext()) {
                    int a10 = next.a();
                    do {
                        u next2 = iterator2.next();
                        int a11 = next2.a();
                        if (a10 < a11) {
                            next = next2;
                            a10 = a11;
                        }
                    } while (iterator2.hasNext());
                }
            } else {
                next = null;
            }
            u uVar = next;
            return (uVar == null || (e2 = w.e(uVar, u10)) == null) ? w.b(null, null, 3, null) : e2;
        } catch (Throwable th) {
            return w.b(th, null, 2, null);
        }
    }
}
