package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SequenceBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements g<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f51086a;

        public a(Function2 function2) {
            this.f51086a = function2;
        }

        @Override // kotlin.sequences.g
        @NotNull
        public Iterator<T> iterator() {
            return j.a(this.f51086a);
        }
    }

    @NotNull
    public static final <T> Iterator<T> a(@NotNull Function2<? super i<? super T>, ? super Continuation<? super p>, ? extends Object> block) {
        s.i(block, "block");
        h hVar = new h();
        hVar.f(IntrinsicsKt__IntrinsicsJvmKt.b(block, hVar, hVar));
        return hVar;
    }

    @NotNull
    public static final <T> g<T> b(@NotNull Function2<? super i<? super T>, ? super Continuation<? super p>, ? extends Object> block) {
        s.i(block, "block");
        return new a(block);
    }
}
