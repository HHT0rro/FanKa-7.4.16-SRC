package com.bytedance.sdk.openadsdk.api.m;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import o0.a;
import o0.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class n extends com.bytedance.sdk.openadsdk.api.dk implements IDownloadButtonClickListener {
    public n(EventListener eventListener) {
        this.f11074m = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z10) {
        m(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, m() ? null : b.b().d(a.b().j(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z10).a()).a());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        m(ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
