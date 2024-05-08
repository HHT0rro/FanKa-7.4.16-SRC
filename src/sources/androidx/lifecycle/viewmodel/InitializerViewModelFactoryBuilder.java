package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.reflect.c;
import org.jetbrains.annotations.NotNull;
import xd.a;

/* compiled from: InitializerViewModelFactory.kt */
@ViewModelFactoryDsl
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class InitializerViewModelFactoryBuilder {

    @NotNull
    private final List<ViewModelInitializer<?>> initializers = new ArrayList();

    public final <T extends ViewModel> void addInitializer(@NotNull c<T> clazz, @NotNull Function1<? super CreationExtras, ? extends T> initializer) {
        s.i(clazz, "clazz");
        s.i(initializer, "initializer");
        this.initializers.add(new ViewModelInitializer<>(a.a(clazz), initializer));
    }

    @NotNull
    public final ViewModelProvider.Factory build() {
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.initializers.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
