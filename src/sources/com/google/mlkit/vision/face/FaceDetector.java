package com.google.mlkit.vision.face;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.mlkit.vision.common.internal.Detector;
import java.util.List;
import o8.a;
import p7.f;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FaceDetector extends Detector<List<a>> {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    f<List<a>> n(@RecentlyNonNull m8.a aVar);
}
