package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PersistableBundle.kt */
@RequiresApi(22)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class PersistableBundleApi22ImplKt {

    @NotNull
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @DoNotInline
    public static final void putBoolean(@NotNull PersistableBundle persistableBundle, @Nullable String str, boolean z10) {
        s.i(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(str, z10);
    }

    @DoNotInline
    public static final void putBooleanArray(@NotNull PersistableBundle persistableBundle, @Nullable String str, @NotNull boolean[] value) {
        s.i(persistableBundle, "persistableBundle");
        s.i(value, "value");
        persistableBundle.putBooleanArray(str, value);
    }
}
