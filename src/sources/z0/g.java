package z0;

import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BundleExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {
    @Nullable
    public static final <T extends Serializable> T a(@NotNull Intent intent, @NotNull Class<T> clazz) {
        kotlin.jvm.internal.s.i(intent, "<this>");
        kotlin.jvm.internal.s.i(clazz, "clazz");
        return (T) intent.getSerializableExtra(clazz.getSimpleName());
    }

    @Nullable
    public static final <T extends Serializable> T b(@NotNull Bundle bundle, @NotNull Class<T> clazz) {
        kotlin.jvm.internal.s.i(bundle, "<this>");
        kotlin.jvm.internal.s.i(clazz, "clazz");
        return (T) bundle.getSerializable(clazz.getSimpleName());
    }

    public static final <T extends Serializable> void c(@NotNull Intent intent, @NotNull T model) {
        kotlin.jvm.internal.s.i(intent, "<this>");
        kotlin.jvm.internal.s.i(model, "model");
        intent.putExtra(model.getClass().getSimpleName(), model);
    }

    public static final <T extends Serializable> void d(@NotNull Bundle bundle, @NotNull T model) {
        kotlin.jvm.internal.s.i(bundle, "<this>");
        kotlin.jvm.internal.s.i(model, "model");
        bundle.putSerializable(model.getClass().getSimpleName(), model);
    }
}
