package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IAdInfo {
    int getAdCount();

    List<? extends IBidInfo> getBidInfoList();

    String getDecrypt();

    String getRequestId();

    List<? extends ISeatInfo> getSeatList();

    int getStatus();
}
