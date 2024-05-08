package com.huawei.hms.scankit;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ProviderRemoteView extends LinearLayout {
    public ProviderRemoteView(Context context, boolean z10, boolean z11) {
        super(context);
        a(z10, z11);
    }

    private void a(boolean z10, boolean z11) {
        if (z10) {
            LayoutInflater.from(getContext()).inflate(R.layout.scankit_zxl_capture_customed, this);
        } else if (z11) {
            LayoutInflater.from(getContext()).inflate(R.layout.scankit_zxl_capture, this);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.scankit_zxl_capture_new, this);
        }
    }

    public ProviderRemoteView(Context context, boolean z10) {
        this(context, z10, true);
    }
}
