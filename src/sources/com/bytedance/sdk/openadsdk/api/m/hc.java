package com.bytedance.sdk.openadsdk.api.m;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import o0.a;
import o0.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class hc extends com.bytedance.sdk.openadsdk.api.dk implements OnItemClickListener {
    public hc(EventListener eventListener) {
        this.f11074m = eventListener;
    }

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        m(ValueSetConstants.VALUE_ON_ITEM_CLICK, m() ? null : b.b().d(a.b().h(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new ej(downloadModel)).h(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG, new dk(downloadEventConfig)).h(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new m(downloadController)).a()).a());
    }
}
