package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewModelLazy.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {

    @Nullable
    private VM cached;

    @NotNull
    private final Function0<CreationExtras> extrasProducer;

    @NotNull
    private final Function0<ViewModelProvider.Factory> factoryProducer;

    @NotNull
    private final Function0<ViewModelStore> storeProducer;

    @NotNull
    private final kotlin.reflect.c<VM> viewModelClass;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(@NotNull kotlin.reflect.c<VM> viewModelClass, @NotNull Function0<? extends ViewModelStore> storeProducer, @NotNull Function0<? extends ViewModelProvider.Factory> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        s.i(viewModelClass, "viewModelClass");
        s.i(storeProducer, "storeProducer");
        s.i(factoryProducer, "factoryProducer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull kotlin.reflect.c<VM> viewModelClass, @NotNull Function0<? extends ViewModelStore> storeProducer, @NotNull Function0<? extends ViewModelProvider.Factory> factoryProducer, @NotNull Function0<? extends CreationExtras> extrasProducer) {
        s.i(viewModelClass, "viewModelClass");
        s.i(storeProducer, "storeProducer");
        s.i(factoryProducer, "factoryProducer");
        s.i(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.Lazy
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(xd.a.a(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(kotlin.reflect.c cVar, Function0 function0, Function0 function02, Function0 function03, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, function0, function02, (i10 & 8) != 0 ? new Function0<CreationExtras.Empty>() { // from class: androidx.lifecycle.ViewModelLazy.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras.Empty invoke() {
                return CreationExtras.Empty.INSTANCE;
            }
        } : function03);
    }
}
