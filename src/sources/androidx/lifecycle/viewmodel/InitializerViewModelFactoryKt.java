package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, Function1<? super CreationExtras, ? extends VM> initializer) {
        s.i(initializerViewModelFactoryBuilder, "<this>");
        s.i(initializer, "initializer");
        s.o(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(v.b(ViewModel.class), initializer);
    }

    @NotNull
    public static final ViewModelProvider.Factory viewModelFactory(@NotNull Function1<? super InitializerViewModelFactoryBuilder, p> builder) {
        s.i(builder, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        builder.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
