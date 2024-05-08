package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.reflect.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FragmentViewModelLazy.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FragmentViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment activityViewModels, Function0<? extends ViewModelProvider.Factory> function0) {
        s.i(activityViewModels, "$this$activityViewModels");
        s.o(4, "VM");
        c b4 = v.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, b4, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment activityViewModels, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        s.i(activityViewModels, "$this$activityViewModels");
        s.o(4, "VM");
        c b4 = v.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, b4, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    @MainThread
    @NotNull
    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(@NotNull final Fragment createViewModelLazy, @NotNull c<VM> viewModelClass, @NotNull Function0<? extends ViewModelStore> storeProducer, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        s.i(createViewModelLazy, "$this$createViewModelLazy");
        s.i(viewModelClass, "viewModelClass");
        s.i(storeProducer, "storeProducer");
        if (function0 == null) {
            function0 = new Function0<ViewModelProvider.Factory>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ViewModelProvider.Factory invoke() {
                    return Fragment.this.getDefaultViewModelProviderFactory();
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, function0);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, c cVar, Function0 function0, Function0 function02, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function02 = null;
        }
        return createViewModelLazy(fragment, cVar, function0, function02);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment viewModels, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends ViewModelProvider.Factory> function0) {
        s.i(viewModels, "$this$viewModels");
        s.i(ownerProducer, "ownerProducer");
        s.o(4, "VM");
        return createViewModelLazy(viewModels, v.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(final Fragment viewModels, Function0 ownerProducer, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new Function0<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        s.i(viewModels, "$this$viewModels");
        s.i(ownerProducer, "ownerProducer");
        s.o(4, "VM");
        return createViewModelLazy(viewModels, v.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }
}
