package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MetaData implements Serializable {
    private static final long serialVersionUID = 5884097861234973073L;
    private String adSign;
    private List<AdSource> adSources;
    private ApkInfo apkInfo;
    private String appPromotionChannel__;
    private String cta__;
    private String description__;
    private List<ImageInfo> icon__;
    private List<ImageInfo> imageInfo__;

    @com.huawei.openalliance.ad.annotations.a
    private String intent__;
    private String label__;
    private String marketAppId__;
    private MediaFile mediaFile;
    private List<MediaFile> mediaFiles;
    private List<TextState> textStateList;
    private String title__;
    private VideoInfo videoInfo__;
    private long minEffectiveShowTime__ = 500;
    private int minEffectiveShowRatio__ = 50;
    private long duration = 0;

    public List<ImageInfo> B() {
        return this.icon__;
    }

    public long C() {
        return this.minEffectiveShowTime__;
    }

    public String Code() {
        return this.cta__;
    }

    public void Code(List<AdSource> list) {
        this.adSources = list;
    }

    public String D() {
        return this.appPromotionChannel__;
    }

    public String F() {
        return this.label__;
    }

    public String I() {
        return this.title__;
    }

    public String L() {
        return this.marketAppId__;
    }

    public int S() {
        return this.minEffectiveShowRatio__;
    }

    public VideoInfo V() {
        return this.videoInfo__;
    }

    public String Z() {
        return this.description__;
    }

    public String a() {
        return this.intent__;
    }

    public List<ImageInfo> b() {
        return this.imageInfo__;
    }

    public ApkInfo c() {
        return this.apkInfo;
    }

    public String d() {
        return this.adSign;
    }

    public MediaFile e() {
        return this.mediaFile;
    }

    public List<TextState> f() {
        return this.textStateList;
    }

    public List<MediaFile> g() {
        return this.mediaFiles;
    }

    public long h() {
        return this.duration;
    }

    public List<AdSource> i() {
        return this.adSources;
    }

    public List<String> j() {
        ArrayList arrayList = new ArrayList();
        VideoInfo videoInfo = this.videoInfo__;
        if (videoInfo != null) {
            arrayList.add(videoInfo.V());
        }
        return arrayList;
    }

    public List<String> k() {
        ArrayList arrayList = new ArrayList();
        if (!aa.Code(this.imageInfo__)) {
            Iterator<ImageInfo> iterator2 = this.imageInfo__.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().F());
            }
        }
        return arrayList;
    }
}
