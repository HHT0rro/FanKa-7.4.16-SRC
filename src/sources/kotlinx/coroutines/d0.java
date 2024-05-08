package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final List<c0> f51181a = SequencesKt___SequencesKt.u(SequencesKt__SequencesKt.c(ServiceLoader.load(c0.class, c0.class.getClassLoader()).iterator2()));

    public static final void a(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        Iterator<c0> iterator2 = f51181a.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().m(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            Result.Companion companion = Result.Companion;
            kotlin.a.a(th, new DiagnosticCoroutineContextException(coroutineContext));
            Result.m3565constructorimpl(kotlin.p.f51048a);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            Result.m3565constructorimpl(kotlin.e.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
