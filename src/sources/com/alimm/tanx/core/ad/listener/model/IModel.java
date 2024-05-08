package com.alimm.tanx.core.ad.listener.model;

import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IModel {
    void cancel();

    void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener);

    void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10);
}
