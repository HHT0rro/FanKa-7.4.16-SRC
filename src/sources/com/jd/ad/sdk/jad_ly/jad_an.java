package com.jd.ad.sdk.jad_ly;

import com.jd.ad.sdk.dl.addata.JADMaterialData;
import java.util.Collections;
import java.util.List;

/* compiled from: JADAdData.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an implements JADMaterialData {
    public int jad_hu;
    public int jad_iv;
    public int jad_jw;
    public int jad_kx;
    public String jad_an = "";
    public String jad_bo = "";
    public List<String> jad_cp = Collections.emptyList();
    public String jad_dq = "";
    public String jad_er = "";
    public String jad_fs = "";
    public String jad_jt = "";

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getDescription() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getDownloadUrl() {
        return this.jad_fs;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getEventInteractionType() {
        return this.jad_iv;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getImageHeight() {
        return this.jad_kx;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public List<String> getImageUrls() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getImageWidth() {
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getMediaSpecSetType() {
        return this.jad_hu;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getMediaStyle() {
        return this.jad_jt;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getResource() {
        return this.jad_dq;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getTitle() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getVideoUrl() {
        return this.jad_er;
    }
}
