package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(@NonNull String str);

    void clearFragmentResultListener(@NonNull String str);

    void setFragmentResult(@NonNull String str, @NonNull Bundle bundle);

    void setFragmentResultListener(@NonNull String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull FragmentResultListener fragmentResultListener);
}
