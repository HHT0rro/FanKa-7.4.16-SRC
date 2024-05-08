package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModelProvider.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final /* synthetic */ class k {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    @NotNull
    public static ViewModel a(ViewModelProvider.Factory factory, @NotNull Class modelClass) {
        s.i(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static ViewModel b(ViewModelProvider.Factory factory, @NotNull Class modelClass, @NotNull CreationExtras extras) {
        s.i(modelClass, "modelClass");
        s.i(extras, "extras");
        return factory.create(modelClass);
    }

    @NotNull
    public static ViewModelProvider.Factory c(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
