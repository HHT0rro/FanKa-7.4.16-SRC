package androidx.fragment.app;

import android.view.View;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: View.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewKt {
    @NotNull
    public static final <F extends Fragment> F findFragment(@NotNull View findFragment) {
        s.i(findFragment, "$this$findFragment");
        F f10 = (F) FragmentManager.findFragment(findFragment);
        s.h(f10, "FragmentManager.findFragment(this)");
        return f10;
    }
}
