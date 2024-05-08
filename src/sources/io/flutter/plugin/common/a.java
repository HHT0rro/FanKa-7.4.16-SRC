package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.plugin.common.BinaryMessenger;

/* compiled from: BinaryMessenger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class a {
    public static void a(BinaryMessenger binaryMessenger) {
        throw new UnsupportedOperationException("disableBufferingIncomingMessages not implemented.");
    }

    public static void b(BinaryMessenger binaryMessenger) {
        throw new UnsupportedOperationException("enableBufferingIncomingMessages not implemented.");
    }

    @UiThread
    public static BinaryMessenger.TaskQueue c(BinaryMessenger binaryMessenger) {
        return binaryMessenger.makeBackgroundTaskQueue(new BinaryMessenger.TaskQueueOptions());
    }

    @UiThread
    public static BinaryMessenger.TaskQueue d(BinaryMessenger binaryMessenger, BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
    }

    @UiThread
    public static void e(BinaryMessenger binaryMessenger, @NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler, @Nullable BinaryMessenger.TaskQueue taskQueue) {
        if (taskQueue == null) {
            binaryMessenger.setMessageHandler(str, binaryMessageHandler);
            return;
        }
        throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
    }
}
