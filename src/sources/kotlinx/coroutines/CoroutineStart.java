package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineStart.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51120a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f51120a = iArr;
        }
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T> void invoke(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        int i10 = a.f51120a[ordinal()];
        if (i10 == 1) {
            ee.a.c(function1, continuation);
            return;
        }
        if (i10 == 2) {
            kotlin.coroutines.d.a(function1, continuation);
        } else if (i10 == 3) {
            ee.b.a(function1, continuation);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    public final <R, T> void invoke(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r10, @NotNull Continuation<? super T> continuation) {
        int i10 = a.f51120a[ordinal()];
        if (i10 == 1) {
            ee.a.e(function2, r10, continuation, null, 4, null);
            return;
        }
        if (i10 == 2) {
            kotlin.coroutines.d.b(function2, r10, continuation);
        } else if (i10 == 3) {
            ee.b.b(function2, r10, continuation);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
