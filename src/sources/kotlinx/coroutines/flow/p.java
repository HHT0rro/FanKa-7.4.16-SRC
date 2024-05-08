package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements c<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f51343b;

        public a(Object obj) {
            this.f51343b = obj;
        }

        @Override // kotlinx.coroutines.flow.c
        @Nullable
        public Object a(@NotNull d<? super T> dVar, @NotNull Continuation<? super kotlin.p> continuation) {
            Object emit = dVar.emit((Object) this.f51343b, continuation);
            return emit == sd.a.d() ? emit : kotlin.p.f51048a;
        }
    }

    @NotNull
    public static final <T> c<T> a(@NotNull Function2<? super kotlinx.coroutines.channels.m<? super T>, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        return new CallbackFlowBuilder(function2, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> c<T> b(@NotNull Function2<? super d<? super T>, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        return new i1(function2);
    }

    @NotNull
    public static final <T> c<T> c(T t2) {
        return new a(t2);
    }
}
