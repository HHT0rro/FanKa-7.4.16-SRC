package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ContentProviderControlSurface {
    void attachToContentProvider(@NonNull ContentProvider contentProvider, @NonNull Lifecycle lifecycle);

    void detachFromContentProvider();
}
