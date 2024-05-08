package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class HiddenLifecycleReference {

    @NonNull
    private final Lifecycle lifecycle;

    public HiddenLifecycleReference(@NonNull Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }
}
