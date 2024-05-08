package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewModelInitializer<T extends ViewModel> {

    @NotNull
    private final Class<T> clazz;

    @NotNull
    private final Function1<CreationExtras, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelInitializer(@NotNull Class<T> clazz, @NotNull Function1<? super CreationExtras, ? extends T> initializer) {
        s.i(clazz, "clazz");
        s.i(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    @NotNull
    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    @NotNull
    public final Function1<CreationExtras, T> getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
