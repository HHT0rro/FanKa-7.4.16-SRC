package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.beans.metadata.v3.Asset;
import com.huawei.openalliance.ad.beans.metadata.v3.TemplateData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdContentData implements Serializable {
    private static final long serialVersionUID = 5884097865724973073L;
    private String abilityDetailInfoEncode;
    private String adChoiceIcon;
    private String adChoiceUrl;
    private int apiVer;
    private List<Asset> assets;
    private String bannerRefSetting;
    private List<Integer> clickActionList;
    private List<AdvertiserInfo> compliance;
    private String contentDownMethod;
    private List<ContentExt> contentExts;
    private String contentId;
    private String ctrlSwitchs;
    private String customData;
    private DefaultTemplate defaultTemplate;
    private DelayInfo delayInfo;
    private String detailUrl;
    private int displayCount;
    private long endTime;
    private List<ImpEX> ext;
    private List<FeedbackInfo> feedbackInfoList;
    private int height;
    private String hwChannelId;
    private String intentUri;
    private InteractCfg interactCfg;
    private int interactiontype;
    private String isAdContainerSizeMatched;
    private boolean isJssdkInWhiteList;
    private boolean isLast;
    private boolean isVastAd;
    private List<JSFeedbackInfo> jsFeedbackInfos;
    private List<String> keyWords;
    private List<String> keyWordsType;
    private int landingTitleFlag;
    private long lastShowTime;
    private String logo2Pos;
    private String logo2Text;

    @com.huawei.openalliance.ad.annotations.a
    private String metaData;

    @com.huawei.openalliance.ad.annotations.d
    private MetaData metaDataObj;
    private boolean needAppDownload;

    @com.huawei.openalliance.ad.annotations.a
    private List<Om> om;

    @com.huawei.openalliance.ad.annotations.a
    private List<Om> omArgs;
    private int priority;
    private String proDesc;
    private String recordtaskinfo;
    private String requestId;
    private Integer requestType;
    private int rewardAmount;
    private String rewardType;
    private int sequence;
    private String skipText;
    private int skipTextHeight;
    private String skipTextPos;
    private int skipTextSize;
    private String slotId;
    private String splashMediaPath;
    private int splashPreContentFlag;
    private long startShowTime;
    private long startTime;
    private String taskId;
    private String templateContent;
    private TemplateData templateData;
    private int templateId;
    private String templateIdV3;
    private String templateStyle;
    private String uniqueId;
    private int useGaussianBlur;
    private String userId;
    private String webConfig;
    private String whyThisAd;
    private int width;
    private String showId = String.valueOf(com.huawei.openalliance.ad.utils.v.Code());
    private int showAppLogoFlag = 1;
    private int creativeType = 2;
    private int adType = -1;
    private boolean autoDownloadApp = false;
    private boolean directReturnVideoAd = false;
    private int linkedVideoMode = 0;
    private boolean isFromExSplash = false;
    private boolean isSpare = false;
    private int splashSkipBtnDelayTime = -111111;
    private int splashShowTime = -111111;

    public static long J() {
        return serialVersionUID;
    }

    public int A() {
        return this.sequence;
    }

    public String B() {
        return this.showId;
    }

    public void B(int i10) {
        this.templateId = i10;
    }

    public void B(String str) {
        this.taskId = str;
    }

    public void B(List<Integer> list) {
        this.clickActionList = list;
    }

    public void B(boolean z10) {
        this.isFromExSplash = z10;
    }

    public String C() {
        return this.slotId;
    }

    public void C(int i10) {
        this.linkedVideoMode = i10;
    }

    public void C(String str) {
        this.uniqueId = str;
    }

    public void C(List<ContentExt> list) {
        this.contentExts = list;
    }

    public void C(boolean z10) {
        this.isSpare = z10;
    }

    public int Code() {
        return this.adType;
    }

    public void Code(int i10) {
        this.showAppLogoFlag = i10;
    }

    public void Code(long j10) {
        this.lastShowTime = j10;
    }

    public void Code(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    public void Code(InteractCfg interactCfg) {
        this.interactCfg = interactCfg;
    }

    public void Code(MetaData metaData) {
        this.metaDataObj = metaData;
    }

    public void Code(Integer num) {
        this.requestType = num;
    }

    public void Code(String str) {
        this.metaData = str;
        this.metaDataObj = null;
    }

    public void Code(List<Om> list) {
        this.om = list;
    }

    public void Code(boolean z10) {
        this.autoDownloadApp = z10;
    }

    public int D() {
        return this.showAppLogoFlag;
    }

    public void D(int i10) {
        this.useGaussianBlur = i10;
    }

    public void D(String str) {
        this.whyThisAd = str;
    }

    public void D(List<AdvertiserInfo> list) {
        this.compliance = list;
    }

    public String E() {
        return this.requestId;
    }

    public String F() {
        return this.taskId;
    }

    public void F(int i10) {
        this.skipTextHeight = i10;
    }

    public void F(String str) {
        this.requestId = str;
    }

    public void F(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    public void F(boolean z10) {
        this.isVastAd = z10;
    }

    public String G() {
        return this.rewardType;
    }

    public int H() {
        return this.rewardAmount;
    }

    public String I() {
        return this.metaData;
    }

    public void I(int i10) {
        this.height = i10;
    }

    public void I(long j10) {
        this.startTime = j10;
    }

    public void I(String str) {
        this.slotId = str;
    }

    public void I(List<String> list) {
        this.keyWords = list;
    }

    public void I(boolean z10) {
        this.isLast = z10;
    }

    public long K() {
        return this.lastShowTime;
    }

    public long L() {
        return this.endTime;
    }

    public void L(int i10) {
        this.displayCount = i10;
    }

    public void L(String str) {
        this.adChoiceUrl = str;
    }

    public void L(List<FeedbackInfo> list) {
        if (aa.Code(list)) {
            return;
        }
        this.jsFeedbackInfos = new ArrayList();
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null) {
                this.jsFeedbackInfos.add(new JSFeedbackInfo(feedbackInfo));
            }
        }
    }

    public int M() {
        return this.displayCount;
    }

    public int N() {
        return this.splashPreContentFlag;
    }

    public MetaData O() {
        return this.metaDataObj;
    }

    public List<String> P() {
        return this.keyWordsType;
    }

    public int Q() {
        return this.landingTitleFlag;
    }

    public String R() {
        return this.webConfig;
    }

    public String S() {
        return this.contentId;
    }

    public void S(int i10) {
        this.skipTextSize = i10;
    }

    public void S(String str) {
        this.templateContent = str;
    }

    public void S(List<ImpEX> list) {
        this.ext = list;
    }

    public void S(boolean z10) {
        this.isJssdkInWhiteList = z10;
    }

    public String T() {
        return this.uniqueId;
    }

    public String U() {
        return this.isAdContainerSizeMatched;
    }

    public String V() {
        return this.skipText;
    }

    public void V(int i10) {
        this.width = i10;
    }

    public void V(long j10) {
        this.endTime = j10;
    }

    public void V(String str) {
        this.showId = str;
    }

    public void V(List<Om> list) {
        this.omArgs = list;
    }

    public void V(boolean z10) {
        this.needAppDownload = z10;
    }

    public String W() {
        return this.whyThisAd;
    }

    public String X() {
        return this.adChoiceUrl;
    }

    public String Y() {
        return this.adChoiceIcon;
    }

    public MetaData Z() {
        if (this.metaDataObj == null) {
            this.metaDataObj = (MetaData) z.V(this.metaData, MetaData.class, new Class[0]);
        }
        return this.metaDataObj;
    }

    public void Z(int i10) {
        this.priority = i10;
    }

    public void Z(long j10) {
        this.startShowTime = j10;
    }

    public void Z(String str) {
        this.contentId = str;
    }

    public void Z(List<String> list) {
        this.keyWordsType = list;
    }

    public void Z(boolean z10) {
        this.directReturnVideoAd = z10;
    }

    public long a() {
        return this.startTime;
    }

    public void a(int i10) {
        this.creativeType = i10;
    }

    public void a(String str) {
        this.adChoiceIcon = str;
    }

    public int aA() {
        return this.apiVer;
    }

    public String aB() {
        return au.V(this.abilityDetailInfoEncode);
    }

    public String aC() {
        return this.hwChannelId;
    }

    public List<Asset> aD() {
        return this.assets;
    }

    public TemplateData aE() {
        return this.templateData;
    }

    public String aF() {
        return this.templateStyle;
    }

    public List<AdvertiserInfo> aG() {
        return this.compliance;
    }

    public List<JSFeedbackInfo> aH() {
        return this.jsFeedbackInfos;
    }

    public boolean aa() {
        return this.isLast;
    }

    public int ab() {
        return this.skipTextSize;
    }

    public int ac() {
        return this.skipTextHeight;
    }

    public List<Om> ad() {
        return this.om;
    }

    public List<Om> ae() {
        return this.omArgs;
    }

    public String af() {
        return this.contentDownMethod;
    }

    public int ag() {
        return this.useGaussianBlur;
    }

    public String ah() {
        return this.isAdContainerSizeMatched;
    }

    public DelayInfo ai() {
        return this.delayInfo;
    }

    public String aj() {
        return this.bannerRefSetting;
    }

    public boolean ak() {
        return this.isFromExSplash;
    }

    public boolean al() {
        return this.isSpare;
    }

    public int am() {
        return this.splashSkipBtnDelayTime;
    }

    public int an() {
        return this.splashShowTime;
    }

    public String ao() {
        return this.customData;
    }

    public String ap() {
        return this.userId;
    }

    public String aq() {
        return this.proDesc;
    }

    public boolean ar() {
        return this.isJssdkInWhiteList;
    }

    public Integer as() {
        return this.requestType;
    }

    public List<ImpEX> at() {
        return this.ext;
    }

    public List<ContentExt> au() {
        return this.contentExts;
    }

    public InteractCfg av() {
        return this.interactCfg;
    }

    public long aw() {
        return this.startShowTime;
    }

    public List<FeedbackInfo> ax() {
        return this.feedbackInfoList;
    }

    public boolean ay() {
        return this.isVastAd;
    }

    public String az() {
        return this.templateIdV3;
    }

    public int b() {
        return this.width;
    }

    public void b(int i10) {
        this.interactiontype = i10;
    }

    public void b(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public int c() {
        return this.height;
    }

    public void c(int i10) {
        this.splashPreContentFlag = i10;
    }

    public void c(String str) {
        this.splashMediaPath = str;
    }

    public String d() {
        return this.splashMediaPath;
    }

    public void d(int i10) {
        this.adType = i10;
    }

    public void d(String str) {
        this.detailUrl = str;
    }

    public String e() {
        return this.detailUrl;
    }

    public void e(int i10) {
        this.landingTitleFlag = i10;
    }

    public void e(String str) {
        this.intentUri = str;
    }

    public int f() {
        return this.interactiontype;
    }

    public void f(int i10) {
        this.sequence = i10;
    }

    public void f(String str) {
        this.skipText = str;
    }

    public int g() {
        return this.priority;
    }

    public void g(int i10) {
        this.rewardAmount = i10;
    }

    public void g(String str) {
        this.skipTextPos = str;
    }

    public int h() {
        return this.creativeType;
    }

    public void h(int i10) {
        this.apiVer = i10;
    }

    public void h(String str) {
        this.logo2Text = str;
    }

    public String i() {
        return this.intentUri;
    }

    public void i(String str) {
        this.logo2Pos = str;
    }

    public void j() {
        this.displayCount++;
        this.priority = 1;
        this.lastShowTime = com.huawei.openalliance.ad.utils.v.Code();
    }

    public void j(String str) {
        this.contentDownMethod = str;
    }

    public List<String> k() {
        return this.keyWords;
    }

    public void k(String str) {
        this.webConfig = str;
    }

    public String l() {
        return this.skipTextPos;
    }

    public void l(String str) {
        this.ctrlSwitchs = str;
    }

    public List<Integer> m() {
        return this.clickActionList;
    }

    public void m(String str) {
        this.recordtaskinfo = str;
    }

    public String n() {
        return this.logo2Text;
    }

    public void n(String str) {
        this.rewardType = str;
    }

    public String o() {
        return this.logo2Pos;
    }

    public void o(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public VideoInfo p() {
        MetaData Z = Z();
        if (Z != null) {
            return Z.V();
        }
        return null;
    }

    public void p(String str) {
        this.customData = au.S(str);
    }

    public MediaFile q() {
        MetaData Z = Z();
        if (Z != null) {
            return Z.e();
        }
        return null;
    }

    public void q(String str) {
        this.userId = au.S(str);
    }

    public String r() {
        return this.ctrlSwitchs;
    }

    public void r(String str) {
        this.proDesc = str;
    }

    public String s() {
        return this.recordtaskinfo;
    }

    public void s(String str) {
        this.templateIdV3 = str;
    }

    public void t(String str) {
        this.hwChannelId = str;
    }

    public boolean t() {
        return true;
    }

    public AppInfo u() {
        ApkInfo c4;
        MetaData Z = Z();
        if (Z == null || (c4 = Z.c()) == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo(c4);
        appInfo.V(this.uniqueId);
        appInfo.Code(Z.a());
        return appInfo;
    }

    public boolean v() {
        return this.needAppDownload;
    }

    public int w() {
        return this.templateId;
    }

    public String x() {
        return this.templateContent;
    }

    public boolean y() {
        return this.directReturnVideoAd;
    }

    public int z() {
        return this.linkedVideoMode;
    }
}
