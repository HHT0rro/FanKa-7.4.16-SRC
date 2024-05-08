package androidx.core.view;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: View.kt */
@RequiresApi(16)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class Api16Impl {

    @NotNull
    public static final Api16Impl INSTANCE = new Api16Impl();

    private Api16Impl() {
    }

    @DoNotInline
    public static final void postOnAnimationDelayed(@NotNull View view, @NotNull Runnable action, long j10) {
        s.i(view, "view");
        s.i(action, "action");
        view.postOnAnimationDelayed(action, j10);
    }
}
