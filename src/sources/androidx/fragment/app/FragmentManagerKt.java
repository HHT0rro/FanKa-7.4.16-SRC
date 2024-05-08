package androidx.fragment.app;

import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FragmentManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FragmentManagerKt {
    public static final void commit(@NotNull FragmentManager commit, boolean z10, @NotNull Function1<? super FragmentTransaction, p> body) {
        s.i(commit, "$this$commit");
        s.i(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        s.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z10) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z10, Function1 body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        s.i(commit, "$this$commit");
        s.i(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        s.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z10) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(@NotNull FragmentManager commitNow, boolean z10, @NotNull Function1<? super FragmentTransaction, p> body) {
        s.i(commitNow, "$this$commitNow");
        s.i(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        s.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z10) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z10, Function1 body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        s.i(commitNow, "$this$commitNow");
        s.i(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        s.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z10) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(@NotNull FragmentManager transaction, boolean z10, boolean z11, @NotNull Function1<? super FragmentTransaction, p> body) {
        s.i(transaction, "$this$transaction");
        s.i(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        s.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z10) {
            if (z11) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z11) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z10, boolean z11, Function1 body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        s.i(transaction, "$this$transaction");
        s.i(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        s.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z10) {
            if (z11) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z11) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
