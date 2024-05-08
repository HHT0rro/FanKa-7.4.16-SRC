package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface BroadcastReceiverControlSurface {
    void attachToBroadcastReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull Lifecycle lifecycle);

    void detachFromBroadcastReceiver();
}
