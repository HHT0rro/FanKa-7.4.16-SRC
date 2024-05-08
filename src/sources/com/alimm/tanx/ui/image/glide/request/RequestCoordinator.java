package com.alimm.tanx.ui.image.glide.request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface RequestCoordinator {
    boolean canNotifyStatusChanged(Request request);

    boolean canSetImage(Request request);

    boolean isAnyResourceSet();

    void onRequestSuccess(Request request);
}
