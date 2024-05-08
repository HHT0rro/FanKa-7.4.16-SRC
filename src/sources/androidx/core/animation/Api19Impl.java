package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Animator.kt */
@RequiresApi(19)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class Api19Impl {

    @NotNull
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    @DoNotInline
    public static final void addPauseListener(@NotNull Animator animator, @NotNull Animator.AnimatorPauseListener listener) {
        s.i(animator, "animator");
        s.i(listener, "listener");
        animator.addPauseListener(listener);
    }
}
