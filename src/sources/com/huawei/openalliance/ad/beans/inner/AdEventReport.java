package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.v;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdEventReport {
    private String activityName;
    private int adType;
    private int apiVer;
    private Integer clickX;
    private Integer clickY;
    private String contentId;
    private String creativeSize;
    private String customData;
    private String destination;
    private Integer endProgress;
    private Long endTime;
    private Long eventTime;
    private String eventType;
    private List<FeedbackInfo> feedbackInfoList;
    private Integer intentDest;
    private Integer intentFailReason;
    private String isAdContainerSizeMatched;
    private Boolean isReportNow;
    private List<String> keyWords;
    private boolean mute;
    private boolean phyShow;
    private String requestId;
    private Integer screenOrientation;
    private Integer screenX;
    private Integer screenY;
    private Long showDuration;
    private Integer showRatio;
    private String slotId;
    private Integer source;
    private Integer startProgress;
    private long startShowTime;
    private Long startTime;
    private String templateId;
    private String userId;

    /* renamed from: x, reason: collision with root package name */
    private int f32145x;

    /* renamed from: y, reason: collision with root package name */
    private int f32146y;
    private String showId = String.valueOf(v.Code());

    @d
    private boolean isFromExSplash = false;

    public String A() {
        return this.templateId;
    }

    public Integer B() {
        return this.showRatio;
    }

    public void B(Integer num) {
        this.intentDest = num;
    }

    public void B(String str) {
        this.requestId = str;
    }

    public Integer C() {
        return this.source;
    }

    public void C(Integer num) {
        this.intentFailReason = num;
    }

    public void C(String str) {
        this.customData = str;
    }

    public String Code() {
        return this.contentId;
    }

    public void Code(int i10) {
        this.adType = i10;
    }

    public void Code(long j10) {
        this.startShowTime = j10;
    }

    public void Code(Boolean bool) {
        this.isReportNow = bool;
    }

    public void Code(Integer num) {
        this.showRatio = num;
    }

    public void Code(Long l10) {
        this.showDuration = l10;
    }

    public void Code(String str) {
        this.contentId = str;
    }

    public void Code(List<String> list) {
        this.keyWords = list;
    }

    public void Code(boolean z10) {
        this.phyShow = z10;
    }

    public Long D() {
        return this.startTime;
    }

    public void D(Integer num) {
        this.screenX = num;
    }

    public void D(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public String E() {
        return this.slotId;
    }

    public String F() {
        return this.eventType;
    }

    public void F(Integer num) {
        this.clickY = num;
    }

    public void F(String str) {
        this.activityName = str;
    }

    public void I(int i10) {
        this.f32146y = i10;
    }

    public void I(Integer num) {
        this.startProgress = num;
    }

    public void I(Long l10) {
        this.endTime = l10;
    }

    public void I(String str) {
        this.destination = str;
    }

    public void I(boolean z10) {
        this.isFromExSplash = z10;
    }

    public boolean I() {
        return this.phyShow;
    }

    public Long L() {
        return this.endTime;
    }

    public void L(Integer num) {
        this.screenY = num;
    }

    public void L(String str) {
        this.creativeSize = str;
    }

    public void S(Integer num) {
        this.clickX = num;
    }

    public void S(String str) {
        this.userId = str;
    }

    public boolean S() {
        return this.mute;
    }

    public int V() {
        return this.adType;
    }

    public void V(int i10) {
        this.f32145x = i10;
    }

    public void V(Integer num) {
        this.source = num;
    }

    public void V(Long l10) {
        this.startTime = l10;
    }

    public void V(String str) {
        this.eventType = str;
    }

    public void V(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    public void V(boolean z10) {
        this.mute = z10;
    }

    public Long Z() {
        return this.showDuration;
    }

    public void Z(int i10) {
        this.apiVer = i10;
    }

    public void Z(Integer num) {
        this.endProgress = num;
    }

    public void Z(Long l10) {
        this.eventTime = l10;
    }

    public void Z(String str) {
        this.showId = str;
    }

    public Integer a() {
        return this.startProgress;
    }

    public void a(Integer num) {
        this.screenOrientation = num;
    }

    public void a(String str) {
        this.templateId = str;
    }

    public Integer b() {
        return this.endProgress;
    }

    public void b(String str) {
        this.slotId = str;
    }

    public int c() {
        return this.f32145x;
    }

    public int d() {
        return this.f32146y;
    }

    public String e() {
        return this.destination;
    }

    public List<String> f() {
        return this.keyWords;
    }

    public Integer g() {
        return this.intentDest;
    }

    public Integer h() {
        return this.intentFailReason;
    }

    public String i() {
        return this.showId;
    }

    public String j() {
        return this.requestId;
    }

    public String k() {
        return this.customData;
    }

    public String l() {
        return this.userId;
    }

    public String m() {
        return this.activityName;
    }

    public String n() {
        return this.isAdContainerSizeMatched;
    }

    public Integer o() {
        return this.clickX;
    }

    public Integer p() {
        return this.clickY;
    }

    public String q() {
        return this.creativeSize;
    }

    public boolean r() {
        return this.isFromExSplash;
    }

    public Long s() {
        return this.eventTime;
    }

    public Boolean t() {
        return this.isReportNow;
    }

    public Integer u() {
        return this.screenX;
    }

    public Integer v() {
        return this.screenY;
    }

    public Integer w() {
        return this.screenOrientation;
    }

    public long x() {
        return this.startShowTime;
    }

    public List<FeedbackInfo> y() {
        return this.feedbackInfoList;
    }

    public int z() {
        return this.apiVer;
    }
}
