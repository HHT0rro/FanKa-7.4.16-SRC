package com.alimm.tanx.core.ad.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.ad.listener.bean.IClickBean;
import com.alimm.tanx.core.ad.listener.bean.IMaterialBean;
import com.alimm.tanx.core.ad.listener.bean.IMonitorBean;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.utils.MD5Utils;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BidInfo extends BaseBean implements IBidInfo {

    @JSONField(name = "ad_source")
    public String adSource;

    @JSONField(name = "adv_logo")
    public String advLogo;

    @JSONField(name = "bid_price")
    public long bidPrice;

    @JSONField(name = "click_through_url")
    public String clickThroughUrl;

    @JSONField(name = "click_tracking_url")
    public List<String> clickTrackUrl;

    @JSONField(name = ExposeManager.UtArgsNames.creativeId)
    public String creativeId;

    @JSONField(name = "materials")
    public CreativeItem creativeItem;

    @JSONField(name = "deeplink_url")
    public String deepLinkUrl;

    @JSONField(name = "event_track")
    public List<NewTrackItem> eventTrack;

    /* renamed from: id, reason: collision with root package name */
    @JSONField(name = "id")
    public int f4178id;

    @JSONField(name = "impression_tracking_url")
    public List<String> impTrackUrl;

    @JSONField(name = ExposeManager.UtArgsNames.interactType)
    public Integer[] interactType;

    @JSONField(name = "open_type")
    public int openType;

    @JSONField(serialize = false)
    public String rawJsonStr;

    @JSONField(name = "end_time")
    public long releaseEndTime;

    @JSONField(name = "begin_time")
    public long releaseStartTime;

    @JSONField(name = ExposeManager.UtArgsNames.sessionId)
    public String sessionId;

    @JSONField(name = "sub_materials")
    public String subMaterials;

    @JSONField(name = "template_conf")
    public TemplateConfig templateConf;

    @JSONField(name = "template_height")
    public String templateHeight;

    @JSONField(name = ExposeManager.UtArgsNames.templateId)
    public String templateId;

    @JSONField(name = "template_width")
    public String templateWidth;

    @JSONField(name = "winnotice_url")
    public String winNoticeUrl;
    public final tanxc_do clickBean = new tanxc_do();
    public final tanxc_if monitorBean = new tanxc_if();

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getAdSource() {
        return this.adSource;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getAdvLogo() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getAdvLogo();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getBidPrice() {
        return this.bidPrice;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public IClickBean getClickBean() {
        return this.clickBean;
    }

    public String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public List<String> getClickTrackUrl() {
        return this.clickTrackUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeId() {
        return this.creativeId;
    }

    public CreativeItem getCreativeItem() {
        return this.creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeMd5() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getImageMd5();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeName() {
        CreativeItem creativeItem = this.creativeItem;
        return (creativeItem == null || TextUtils.isEmpty(creativeItem.getImageUrl())) ? "" : MD5Utils.getMD5String(this.creativeItem.getImageUrl());
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativePath() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getImageUrl();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeType() {
        return "splash";
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public List<NewTrackItem> getEventTrack() {
        return this.eventTrack;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getId() {
        return this.f4178id;
    }

    public List<String> getImpTrackUrl() {
        return this.impTrackUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public Integer[] getInteractType() {
        return this.interactType;
    }

    public boolean getInteractType2FeedSlide() {
        return getInteractType(3);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getInteractType2Int() {
        Integer[] numArr = this.interactType;
        if (numArr == null || numArr.length <= 0) {
            return -1;
        }
        return numArr[0].intValue();
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public boolean getInteractType2Shake() {
        return getInteractType(1);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public IMaterialBean getMaterialBean() {
        return this.creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public IMonitorBean getMonitorBean() {
        return this.monitorBean;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getOpenType() {
        return this.openType;
    }

    public String getRawJsonStr() {
        return this.rawJsonStr;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getReleaseEndTime() {
        return this.releaseEndTime;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getReleaseStartTime() {
        return this.releaseStartTime;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getSessionId() {
        return this.sessionId;
    }

    public String getSubMaterials() {
        return this.subMaterials;
    }

    public TemplateConfig getTemplateConf() {
        return this.templateConf;
    }

    public String getTemplateHeight() {
        return this.templateHeight;
    }

    public int getTemplateHeight2Int() {
        int i10;
        try {
            i10 = Integer.parseInt(this.templateHeight);
        } catch (Exception unused) {
            i10 = 9;
        }
        if (i10 <= 0) {
            return 9;
        }
        return i10;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateWidth() {
        return this.templateWidth;
    }

    public int getTemplateWidth2Int() {
        int i10;
        try {
            i10 = Integer.parseInt(this.templateWidth);
        } catch (Exception unused) {
            i10 = 16;
        }
        if (i10 <= 0) {
            return 16;
        }
        return i10;
    }

    public String getWinNoticeUrl() {
        return this.winNoticeUrl;
    }

    public void setAdSource(String str) {
        this.adSource = str;
    }

    public void setAdvLogo(String str) {
        this.advLogo = str;
    }

    public void setBidPrice(long j10) {
        this.bidPrice = j10;
    }

    public void setClickThroughUrl(String str) {
        this.clickThroughUrl = str;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(str);
        }
    }

    public void setClickTrackUrl(List<String> list) {
        this.clickTrackUrl = list;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_if(list);
        }
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setCreativeItem(CreativeItem creativeItem) {
        this.creativeItem = creativeItem;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_if(str);
        }
    }

    public void setEventTrack(List<NewTrackItem> list) {
        this.eventTrack = list;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_for(list);
        }
    }

    public void setId(int i10) {
        this.f4178id = i10;
    }

    public void setImpTrackUrl(List<String> list) {
        this.impTrackUrl = list;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(list);
        }
    }

    public void setInteractType(Integer[] numArr) {
        this.interactType = numArr;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(numArr);
        }
    }

    public void setOpenType(int i10) {
        this.openType = i10;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(i10);
        }
    }

    public void setRawJsonStr(String str) {
        this.rawJsonStr = str;
    }

    public void setReleaseEndTime(long j10) {
        this.releaseEndTime = j10;
    }

    public void setReleaseStartTime(long j10) {
        this.releaseStartTime = j10;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSubMaterials(String str) {
        this.subMaterials = str;
    }

    public void setTemplateConf(TemplateConfig templateConfig) {
        this.templateConf = templateConfig;
    }

    public void setTemplateHeight(String str) {
        this.templateHeight = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateWidth(String str) {
        this.templateWidth = str;
    }

    public void setWinNoticeUrl(String str) {
        this.winNoticeUrl = str;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(str);
        }
    }

    public boolean getInteractType(int i10) {
        return getInteractType() != null && getInteractType().length > 0 && Arrays.binarySearch(getInteractType(), Integer.valueOf(i10)) >= 0;
    }
}
