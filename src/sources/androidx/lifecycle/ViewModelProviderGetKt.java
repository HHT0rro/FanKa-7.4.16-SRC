package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModelProvider.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewModelProviderGetKt {
    @NotNull
    public static final CreationExtras defaultCreationExtras(@NotNull ViewModelStoreOwner owner) {
        s.i(owner, "owner");
        if (owner instanceof HasDefaultViewModelProviderFactory) {
            return ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelCreationExtras();
        }
        return CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        s.i(viewModelProvider, "<this>");
        s.o(4, "VM");
        return (VM) viewModelProvider.get(ViewModel.class);
    }
}
