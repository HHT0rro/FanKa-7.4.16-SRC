package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    @NotNull
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(@NotNull ViewModelInitializer<?>... initializers) {
        s.i(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls) {
        return k.a(this, cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
        s.i(modelClass, "modelClass");
        s.i(extras, "extras");
        T t2 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (s.d(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), modelClass)) {
                Object invoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(extras);
                t2 = invoke instanceof ViewModel ? (T) invoke : null;
            }
        }
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
