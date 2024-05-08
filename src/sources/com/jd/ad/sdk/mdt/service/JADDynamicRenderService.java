package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;
import com.jd.ad.sdk.dl.model.JADSlot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface JADDynamicRenderService {
    DynamicRenderView createDynamicView(Context context, @NonNull String str, @NonNull JADSlot jADSlot, DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback);

    void registerAdViewClick(Context context, DynamicRenderView dynamicRenderView, IDynamicInteractionListener iDynamicInteractionListener);
}
