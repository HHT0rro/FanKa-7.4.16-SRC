package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Fragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(@NotNull Fragment clearFragmentResult, @NotNull String requestKey) {
        s.i(clearFragmentResult, "$this$clearFragmentResult");
        s.i(requestKey, "requestKey");
        clearFragmentResult.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(@NotNull Fragment clearFragmentResultListener, @NotNull String requestKey) {
        s.i(clearFragmentResultListener, "$this$clearFragmentResultListener");
        s.i(requestKey, "requestKey");
        clearFragmentResultListener.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(@NotNull Fragment setFragmentResult, @NotNull String requestKey, @NotNull Bundle result) {
        s.i(setFragmentResult, "$this$setFragmentResult");
        s.i(requestKey, "requestKey");
        s.i(result, "result");
        setFragmentResult.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(@NotNull Fragment setFragmentResultListener, @NotNull String requestKey, @NotNull final Function2<? super String, ? super Bundle, p> listener) {
        s.i(setFragmentResultListener, "$this$setFragmentResultListener");
        s.i(requestKey, "requestKey");
        s.i(listener, "listener");
        setFragmentResultListener.getParentFragmentManager().setFragmentResultListener(requestKey, setFragmentResultListener, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String p02, @NonNull Bundle p12) {
                s.i(p02, "p0");
                s.i(p12, "p1");
                s.h(Function2.this.mo1743invoke(p02, p12), "invoke(...)");
            }
        });
    }
}
