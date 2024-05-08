package io.flutter.embedding.engine.plugins.service;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServiceAware {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnModeChangeListener {
        void onMoveToBackground();

        void onMoveToForeground();
    }

    void onAttachedToService(@NonNull ServicePluginBinding servicePluginBinding);

    void onDetachedFromService();
}
