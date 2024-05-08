package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.ad.listener.bean.IMonitorBean;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import java.util.List;

/* compiled from: MonitorBean.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if implements IMonitorBean {
    public List<String> tanxc_do;
    public List<? extends ITrackItem> tanxc_for;
    public List<String> tanxc_if;
    public String tanxc_int;

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public List<String> getClickTrackUrl() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public List<? extends ITrackItem> getEventTrack() {
        return this.tanxc_for;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public List<String> getImpTrackUrl() {
        return this.tanxc_do;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public String getWinNoticeUrl() {
        return this.tanxc_int;
    }

    public void tanxc_do(List<String> list) {
        this.tanxc_do = list;
    }

    public void tanxc_for(List<? extends ITrackItem> list) {
        this.tanxc_for = list;
    }

    public void tanxc_if(List<String> list) {
        this.tanxc_if = list;
    }

    public void tanxc_do(String str) {
        this.tanxc_int = str;
    }
}
