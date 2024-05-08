package androidx.window.layout;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;

/* compiled from: ExtensionInterfaceCompat.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ExtensionInterfaceCompat {

    /* compiled from: ExtensionInterfaceCompat.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface ExtensionCallbackInterface {
        void onWindowLayoutChanged(@NotNull Activity activity, @NotNull WindowLayoutInfo windowLayoutInfo);
    }

    void onWindowLayoutChangeListenerAdded(@NotNull Activity activity);

    void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity);

    void setExtensionCallback(@NotNull ExtensionCallbackInterface extensionCallbackInterface);

    boolean validateExtensionInterface();
}
