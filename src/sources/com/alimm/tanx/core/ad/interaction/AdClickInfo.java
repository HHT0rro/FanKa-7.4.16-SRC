package com.alimm.tanx.core.ad.interaction;

import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdClickInfo implements NotConfused {
    public AdUtConstants adUtConstants;
    public BidInfo bidInfo;
    public String clickThroughUrl;
    public String deepLinkUrl;
    public String reqId;
    public TanxAdSlot tanxAdSlot;
    public Map<String, String> utArgs = new HashMap();

    public AdClickInfo(TanxAdSlot tanxAdSlot, String str, BidInfo bidInfo, AdUtConstants adUtConstants) {
        this.tanxAdSlot = tanxAdSlot;
        this.reqId = str;
        this.bidInfo = bidInfo;
        this.adUtConstants = adUtConstants;
    }

    public AdUtConstants getAdUtConstants() {
        return this.adUtConstants;
    }

    public BidInfo getBidInfo() {
        return this.bidInfo;
    }

    public String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public String getReqId() {
        return this.reqId;
    }

    public TanxAdSlot getTanxAdSlot() {
        return this.tanxAdSlot;
    }

    public Map<String, String> getUtArgs() {
        return this.utArgs;
    }

    public void setAdUtConstants(AdUtConstants adUtConstants) {
        this.adUtConstants = adUtConstants;
    }

    public void setBidInfo(BidInfo bidInfo) {
        this.bidInfo = bidInfo;
    }

    public void setClickThroughUrl(String str) {
        this.clickThroughUrl = str;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setTanxAdSlot(TanxAdSlot tanxAdSlot) {
        this.tanxAdSlot = tanxAdSlot;
    }

    public void setUtArgs(Map<String, String> map) {
        this.utArgs = map;
    }

    public AdClickInfo(TanxAdSlot tanxAdSlot, String str, BidInfo bidInfo, AdUtConstants adUtConstants, String str2, String str3) {
        this.tanxAdSlot = tanxAdSlot;
        this.reqId = str;
        this.bidInfo = bidInfo;
        this.adUtConstants = adUtConstants;
        this.clickThroughUrl = str2;
        this.deepLinkUrl = str3;
    }
}
