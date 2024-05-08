package androidx.activity;

import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PipHintTracker.kt */
@RequiresApi(19)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Api19Impl {

    @NotNull
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    public final boolean isAttachedToWindow(@NotNull View view) {
        s.i(view, "view");
        return view.isAttachedToWindow();
    }
}
