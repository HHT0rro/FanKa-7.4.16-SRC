package io.flutter.embedding.engine.plugins.contentprovider;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ContentProviderAware {
    void onAttachedToContentProvider(@NonNull ContentProviderPluginBinding contentProviderPluginBinding);

    void onDetachedFromContentProvider();
}
