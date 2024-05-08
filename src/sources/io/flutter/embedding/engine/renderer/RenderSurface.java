package io.flutter.embedding.engine.renderer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface RenderSurface {
    void attachToRenderer(@NonNull FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    @Nullable
    FlutterRenderer getAttachedRenderer();

    void pause();

    void resume();
}
