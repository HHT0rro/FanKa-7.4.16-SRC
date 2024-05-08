package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FeedPageInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -1423277713849754339L;
    public String abParams;
    public int adNum;
    public int callbackType;
    public long convertDuration;
    public int expectedRenderType;
    public String extMsg;
    public long loadDataDuration;
    public int loadStatus;
    public long loadType;
    public List<a> materialInfoList = new ArrayList();
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId;
        public int materialType;
        public String materialUrl;

        public final a d(long j10) {
            this.creativeId = j10;
            return this;
        }

        public final a o(String str) {
            this.materialUrl = str;
            return this;
        }

        public final a u(int i10) {
            this.materialType = i10;
            return this;
        }
    }

    public FeedPageInfo setAbParams(String str) {
        this.abParams = str;
        return this;
    }

    public FeedPageInfo setAdNum(int i10) {
        this.adNum = i10;
        return this;
    }

    public FeedPageInfo setCallbackType(int i10) {
        this.callbackType = i10;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j10) {
        this.convertDuration = j10;
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i10) {
        this.expectedRenderType = i10;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j10) {
        this.loadDataDuration = j10;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i10) {
        this.loadStatus = i10;
        return this;
    }

    public FeedPageInfo setLoadType(long j10) {
        this.loadType = j10;
        return this;
    }

    public FeedPageInfo setMaterialInfoList(List<a> list) {
        this.materialInfoList = list;
        return this;
    }

    public FeedPageInfo setMaterialType(int i10) {
        this.materialType = i10;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    public FeedPageInfo setRenderDuration(long j10) {
        this.renderDuration = j10;
        return this;
    }

    public FeedPageInfo setRenderType(int i10) {
        this.renderType = i10;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j10) {
        this.resourceLoadDuration = j10;
        return this;
    }

    public FeedPageInfo setStatus(int i10) {
        this.status = i10;
        return this;
    }

    public FeedPageInfo setType(int i10) {
        this.type = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorCode(int i10) {
        super.setErrorCode(i10);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setPosId(long j10) {
        return (FeedPageInfo) super.setPosId(j10);
    }
}
