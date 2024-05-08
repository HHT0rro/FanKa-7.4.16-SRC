package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IMonitorBean {
    List<String> getClickTrackUrl();

    List<? extends ITrackItem> getEventTrack();

    List<String> getImpTrackUrl();

    String getWinNoticeUrl();
}
