package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Bundle.kt */
@RequiresApi(21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class BundleApi21ImplKt {

    @NotNull
    public static final BundleApi21ImplKt INSTANCE = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    @DoNotInline
    public static final void putSize(@NotNull Bundle bundle, @NotNull String key, @Nullable Size size) {
        s.i(bundle, "bundle");
        s.i(key, "key");
        bundle.putSize(key, size);
    }

    @DoNotInline
    public static final void putSizeF(@NotNull Bundle bundle, @NotNull String key, @Nullable SizeF sizeF) {
        s.i(bundle, "bundle");
        s.i(key, "key");
        bundle.putSizeF(key, sizeF);
    }
}
