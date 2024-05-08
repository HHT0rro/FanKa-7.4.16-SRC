package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class np implements DownloadStatusController {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11198m;

    public np(Bridge bridge) {
        this.f11198m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.f11198m.call(222102, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.f11198m.call(222101, a.c(0).a(), Void.class);
    }
}
