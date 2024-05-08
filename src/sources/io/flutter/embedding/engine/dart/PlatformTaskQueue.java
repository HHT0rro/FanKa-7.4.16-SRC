package io.flutter.embedding.engine.dart;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.dart.DartMessenger;
import io.flutter.util.HandlerCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PlatformTaskQueue implements DartMessenger.DartMessengerTaskQueue {

    @NonNull
    private final Handler handler = HandlerCompat.createAsyncHandler(Looper.getMainLooper());

    @Override // io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue
    public void dispatch(@NonNull Runnable runnable) {
        this.handler.post(runnable);
    }
}
