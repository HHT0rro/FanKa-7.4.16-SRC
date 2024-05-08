package com.alimm.tanx.core.ad.listener.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NewTrackItem extends BaseBean implements ITrackItem {

    @JSONField(name = "time")
    public int time;

    @JSONField(name = "type")
    public int type;

    @JSONField(name = "url")
    public List<String> url;

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public int getTime() {
        return this.time;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public int getType() {
        return this.type;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public List<String> getUrl() {
        return this.url;
    }

    public void setTime(int i10) {
        this.time = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUrl(List<String> list) {
        this.url = list;
    }
}
