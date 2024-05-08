package com.alimm.tanx.core.ad.ad.template.rendering.splash.model;

import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ISplashModel extends IModel {
    void sendRequest(boolean z10, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener);

    void sendRequest(boolean z10, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10);
}
