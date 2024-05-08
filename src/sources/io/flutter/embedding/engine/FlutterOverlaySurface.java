package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterOverlaySurface {

    /* renamed from: id, reason: collision with root package name */
    private final int f49947id;

    @NonNull
    private final Surface surface;

    public FlutterOverlaySurface(int i10, @NonNull Surface surface) {
        this.f49947id = i10;
        this.surface = surface;
    }

    public int getId() {
        return this.f49947id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
