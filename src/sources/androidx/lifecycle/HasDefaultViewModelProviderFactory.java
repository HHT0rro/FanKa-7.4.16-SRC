package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import org.jetbrains.annotations.NotNull;

/* compiled from: HasDefaultViewModelProviderFactory.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface HasDefaultViewModelProviderFactory {
    @NotNull
    CreationExtras getDefaultViewModelCreationExtras();

    @NotNull
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
