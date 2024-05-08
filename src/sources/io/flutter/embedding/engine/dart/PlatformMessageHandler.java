package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i10, long j10);

    void handlePlatformMessageResponse(int i10, @Nullable ByteBuffer byteBuffer);
}
