package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SequencesKt__SequencesKt extends k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements g<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f51062a;

        public a(Iterator it) {
            this.f51062a = it;
        }

        @Override // kotlin.sequences.g
        @NotNull
        public Iterator<T> iterator() {
            return this.f51062a;
        }
    }

    @NotNull
    public static final <T> g<T> c(@NotNull Iterator<? extends T> it) {
        s.i(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> g<T> d(@NotNull g<? extends T> gVar) {
        s.i(gVar, "<this>");
        return gVar instanceof kotlin.sequences.a ? gVar : new kotlin.sequences.a(gVar);
    }

    @NotNull
    public static final <T> g<T> e(@Nullable final T t2, @NotNull Function1<? super T, ? extends T> nextFunction) {
        s.i(nextFunction, "nextFunction");
        if (t2 == null) {
            return d.f51069a;
        }
        return new f(new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final T invoke() {
                return t2;
            }
        }, nextFunction);
    }

    @NotNull
    public static final <T> g<T> f(@NotNull Function0<? extends T> seedFunction, @NotNull Function1<? super T, ? extends T> nextFunction) {
        s.i(seedFunction, "seedFunction");
        s.i(nextFunction, "nextFunction");
        return new f(seedFunction, nextFunction);
    }
}
