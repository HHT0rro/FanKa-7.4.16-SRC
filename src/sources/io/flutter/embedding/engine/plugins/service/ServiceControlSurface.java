package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServiceControlSurface {
    void attachToService(@NonNull Service service, @Nullable Lifecycle lifecycle, boolean z10);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
