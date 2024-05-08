package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Bundle.kt */
@RequiresApi(18)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class BundleApi18ImplKt {

    @NotNull
    public static final BundleApi18ImplKt INSTANCE = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    @DoNotInline
    public static final void putBinder(@NotNull Bundle bundle, @NotNull String key, @Nullable IBinder iBinder) {
        s.i(bundle, "bundle");
        s.i(key, "key");
        bundle.putBinder(key, iBinder);
    }
}
