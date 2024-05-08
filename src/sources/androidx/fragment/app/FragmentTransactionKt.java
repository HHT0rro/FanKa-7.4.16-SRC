package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.d;
import kotlin.jvm.internal.s;

/* compiled from: FragmentTransaction.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, @IdRes int i10, String str, Bundle bundle) {
        s.i(add, "$this$add");
        s.o(4, "F");
        FragmentTransaction add2 = add.add(i10, Fragment.class, bundle, str);
        s.h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i10, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        s.i(add, "$this$add");
        s.o(4, "F");
        FragmentTransaction add2 = add.add(i10, Fragment.class, bundle, str);
        s.h(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction replace, @IdRes int i10, String str, Bundle bundle) {
        s.i(replace, "$this$replace");
        s.o(4, "F");
        FragmentTransaction replace2 = replace.replace(i10, Fragment.class, bundle, str);
        s.h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i10, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        s.i(replace, "$this$replace");
        s.o(4, "F");
        FragmentTransaction replace2 = replace.replace(i10, Fragment.class, bundle, str);
        s.h(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, String tag, Bundle bundle) {
        s.i(add, "$this$add");
        s.i(tag, "tag");
        s.o(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        s.h(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        s.i(add, "$this$add");
        s.i(tag, "tag");
        s.o(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        s.h(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
