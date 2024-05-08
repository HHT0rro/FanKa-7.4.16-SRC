package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface c extends CoroutineContext.a {

    @NotNull
    public static final b A0 = b.f50944b;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        @Nullable
        public static <E extends CoroutineContext.a> E a(@NotNull c cVar, @NotNull CoroutineContext.b<E> key) {
            s.i(key, "key");
            if (key instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
                if (!bVar.a(cVar.getKey())) {
                    return null;
                }
                E e2 = (E) bVar.b(cVar);
                if (e2 instanceof CoroutineContext.a) {
                    return e2;
                }
                return null;
            }
            if (c.A0 != key) {
                return null;
            }
            s.g(cVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return cVar;
        }

        @NotNull
        public static CoroutineContext b(@NotNull c cVar, @NotNull CoroutineContext.b<?> key) {
            s.i(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                return c.A0 == key ? EmptyCoroutineContext.INSTANCE : cVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            return (!bVar.a(cVar.getKey()) || bVar.b(cVar) == null) ? cVar : EmptyCoroutineContext.INSTANCE;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b implements CoroutineContext.b<c> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ b f50944b = new b();
    }

    @NotNull
    <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation);

    void releaseInterceptedContinuation(@NotNull Continuation<?> continuation);
}
