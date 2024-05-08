package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface WindowInsetsAnimationControlListenerCompat {
    void onCancelled(@Nullable WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat);

    void onFinished(@NonNull WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat);

    void onReady(@NonNull WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat, int i10);
}
