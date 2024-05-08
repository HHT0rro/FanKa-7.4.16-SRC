package androidx.activity;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements Function0<ViewModelStore> {
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
        s.h(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
