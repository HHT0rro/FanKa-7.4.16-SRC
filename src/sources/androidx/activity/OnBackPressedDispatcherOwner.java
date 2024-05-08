package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: OnBackPressedDispatcherOwner.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NotNull
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
