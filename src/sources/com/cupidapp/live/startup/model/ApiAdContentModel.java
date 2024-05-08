package com.cupidapp.live.startup.model;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ApiAdContentModel {

    @Nullable
    private final Integer actionType;

    @Nullable
    private final AppModel app;

    @Nullable
    private final String brand;

    @Nullable
    private final String content;

    @Nullable
    private final String ctatext;

    @Nullable
    private final String deeplink;

    @Nullable
    private final String desc;

    @Nullable
    private final String dsp;

    @Nullable
    private final String html;

    @Nullable
    private final AdImageModel icon;

    @Nullable
    private final List<AdImageModel> imgs;

    @Nullable
    private final Integer interactType;

    @Nullable
    private final String landing;

    @Nullable
    private final MonitorModel monitor;

    @Nullable
    private final String pCode;

    @Nullable
    private final String phone;

    @Nullable
    private final Integer price;

    @Nullable
    private final Integer templateId;

    @Nullable
    private final String title;

    @Nullable
    private final List<AdVideoModel> videos;

    @Nullable
    private final String voiceAdUrl;

    public ApiAdContentModel(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable AdImageModel adImageModel, @Nullable List<AdImageModel> list, @Nullable String str8, @Nullable Integer num2, @Nullable MonitorModel monitorModel, @Nullable String str9, @Nullable Integer num3, @Nullable String str10, @Nullable Integer num4, @Nullable String str11, @Nullable List<AdVideoModel> list2, @Nullable String str12, @Nullable AppModel appModel) {
        this.actionType = num;
        this.brand = str;
        this.content = str2;
        this.ctatext = str3;
        this.deeplink = str4;
        this.desc = str5;
        this.dsp = str6;
        this.html = str7;
        this.icon = adImageModel;
        this.imgs = list;
        this.landing = str8;
        this.interactType = num2;
        this.monitor = monitorModel;
        this.phone = str9;
        this.price = num3;
        this.pCode = str10;
        this.templateId = num4;
        this.title = str11;
        this.videos = list2;
        this.voiceAdUrl = str12;
        this.app = appModel;
    }

    @Nullable
    public final Integer component1() {
        return this.actionType;
    }

    @Nullable
    public final List<AdImageModel> component10() {
        return this.imgs;
    }

    @Nullable
    public final String component11() {
        return this.landing;
    }

    @Nullable
    public final Integer component12() {
        return this.interactType;
    }

    @Nullable
    public final MonitorModel component13() {
        return this.monitor;
    }

    @Nullable
    public final String component14() {
        return this.phone;
    }

    @Nullable
    public final Integer component15() {
        return this.price;
    }

    @Nullable
    public final String component16() {
        return this.pCode;
    }

    @Nullable
    public final Integer component17() {
        return this.templateId;
    }

    @Nullable
    public final String component18() {
        return this.title;
    }

    @Nullable
    public final List<AdVideoModel> component19() {
        return this.videos;
    }

    @Nullable
    public final String component2() {
        return this.brand;
    }

    @Nullable
    public final String component20() {
        return this.voiceAdUrl;
    }

    @Nullable
    public final AppModel component21() {
        return this.app;
    }

    @Nullable
    public final String component3() {
        return this.content;
    }

    @Nullable
    public final String component4() {
        return this.ctatext;
    }

    @Nullable
    public final String component5() {
        return this.deeplink;
    }

    @Nullable
    public final String component6() {
        return this.desc;
    }

    @Nullable
    public final String component7() {
        return this.dsp;
    }

    @Nullable
    public final String component8() {
        return this.html;
    }

    @Nullable
    public final AdImageModel component9() {
        return this.icon;
    }

    @NotNull
    public final ApiAdContentModel copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable AdImageModel adImageModel, @Nullable List<AdImageModel> list, @Nullable String str8, @Nullable Integer num2, @Nullable MonitorModel monitorModel, @Nullable String str9, @Nullable Integer num3, @Nullable String str10, @Nullable Integer num4, @Nullable String str11, @Nullable List<AdVideoModel> list2, @Nullable String str12, @Nullable AppModel appModel) {
        return new ApiAdContentModel(num, str, str2, str3, str4, str5, str6, str7, adImageModel, list, str8, num2, monitorModel, str9, num3, str10, num4, str11, list2, str12, appModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiAdContentModel)) {
            return false;
        }
        ApiAdContentModel apiAdContentModel = (ApiAdContentModel) obj;
        return s.d(this.actionType, apiAdContentModel.actionType) && s.d(this.brand, apiAdContentModel.brand) && s.d(this.content, apiAdContentModel.content) && s.d(this.ctatext, apiAdContentModel.ctatext) && s.d(this.deeplink, apiAdContentModel.deeplink) && s.d(this.desc, apiAdContentModel.desc) && s.d(this.dsp, apiAdContentModel.dsp) && s.d(this.html, apiAdContentModel.html) && s.d(this.icon, apiAdContentModel.icon) && s.d(this.imgs, apiAdContentModel.imgs) && s.d(this.landing, apiAdContentModel.landing) && s.d(this.interactType, apiAdContentModel.interactType) && s.d(this.monitor, apiAdContentModel.monitor) && s.d(this.phone, apiAdContentModel.phone) && s.d(this.price, apiAdContentModel.price) && s.d(this.pCode, apiAdContentModel.pCode) && s.d(this.templateId, apiAdContentModel.templateId) && s.d(this.title, apiAdContentModel.title) && s.d(this.videos, apiAdContentModel.videos) && s.d(this.voiceAdUrl, apiAdContentModel.voiceAdUrl) && s.d(this.app, apiAdContentModel.app);
    }

    @Nullable
    public final Integer getActionType() {
        return this.actionType;
    }

    @Nullable
    public final AppModel getApp() {
        return this.app;
    }

    @Nullable
    public final String getBrand() {
        return this.brand;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getCtatext() {
        return this.ctatext;
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getDsp() {
        return this.dsp;
    }

    @Nullable
    public final String getHtml() {
        return this.html;
    }

    @Nullable
    public final AdImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final List<AdImageModel> getImgs() {
        return this.imgs;
    }

    @Nullable
    public final Integer getInteractType() {
        return this.interactType;
    }

    @Nullable
    public final String getLanding() {
        return this.landing;
    }

    @Nullable
    public final MonitorModel getMonitor() {
        return this.monitor;
    }

    @Nullable
    public final String getPCode() {
        return this.pCode;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final Integer getPrice() {
        return this.price;
    }

    @Nullable
    public final String getRealDeepLink(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("__DOWN_X__", String.valueOf(num));
        linkedHashMap.put("__DOWN_Y__", String.valueOf(num2));
        linkedHashMap.put("__UP_X__", String.valueOf(num3));
        linkedHashMap.put("__UP_Y__", String.valueOf(num4));
        String str = this.deeplink;
        if (str != null) {
            return t.i(str, linkedHashMap);
        }
        return null;
    }

    @Nullable
    public final String getRealLanding(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("__DOWN_X__", String.valueOf(num));
        linkedHashMap.put("__DOWN_Y__", String.valueOf(num2));
        linkedHashMap.put("__UP_X__", String.valueOf(num3));
        linkedHashMap.put("__UP_Y__", String.valueOf(num4));
        String str = this.landing;
        if (str != null) {
            return t.i(str, linkedHashMap);
        }
        return null;
    }

    @Nullable
    public final Integer getTemplateId() {
        return this.templateId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<AdVideoModel> getVideos() {
        return this.videos;
    }

    @Nullable
    public final String getVoiceAdUrl() {
        return this.voiceAdUrl;
    }

    public int hashCode() {
        Integer num = this.actionType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.brand;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ctatext;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deeplink;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.desc;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.dsp;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.html;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        AdImageModel adImageModel = this.icon;
        int hashCode9 = (hashCode8 + (adImageModel == null ? 0 : adImageModel.hashCode())) * 31;
        List<AdImageModel> list = this.imgs;
        int hashCode10 = (hashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        String str8 = this.landing;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num2 = this.interactType;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        MonitorModel monitorModel = this.monitor;
        int hashCode13 = (hashCode12 + (monitorModel == null ? 0 : monitorModel.hashCode())) * 31;
        String str9 = this.phone;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num3 = this.price;
        int hashCode15 = (hashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.pCode;
        int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num4 = this.templateId;
        int hashCode17 = (hashCode16 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str11 = this.title;
        int hashCode18 = (hashCode17 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<AdVideoModel> list2 = this.videos;
        int hashCode19 = (hashCode18 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str12 = this.voiceAdUrl;
        int hashCode20 = (hashCode19 + (str12 == null ? 0 : str12.hashCode())) * 31;
        AppModel appModel = this.app;
        return hashCode20 + (appModel != null ? appModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.actionType;
        String str = this.brand;
        String str2 = this.content;
        String str3 = this.ctatext;
        String str4 = this.deeplink;
        String str5 = this.desc;
        String str6 = this.dsp;
        String str7 = this.html;
        AdImageModel adImageModel = this.icon;
        List<AdImageModel> list = this.imgs;
        String str8 = this.landing;
        Integer num2 = this.interactType;
        MonitorModel monitorModel = this.monitor;
        String str9 = this.phone;
        Integer num3 = this.price;
        String str10 = this.pCode;
        Integer num4 = this.templateId;
        String str11 = this.title;
        List<AdVideoModel> list2 = this.videos;
        return "ApiAdContentModel(actionType=" + ((Object) num) + ", brand=" + str + ", content=" + str2 + ", ctatext=" + str3 + ", deeplink=" + str4 + ", desc=" + str5 + ", dsp=" + str6 + ", html=" + str7 + ", icon=" + ((Object) adImageModel) + ", imgs=" + ((Object) list) + ", landing=" + str8 + ", interactType=" + ((Object) num2) + ", monitor=" + ((Object) monitorModel) + ", phone=" + str9 + ", price=" + ((Object) num3) + ", pCode=" + str10 + ", templateId=" + ((Object) num4) + ", title=" + str11 + ", videos=" + ((Object) list2) + ", voiceAdUrl=" + this.voiceAdUrl + ", app=" + ((Object) this.app) + ")";
    }

    public /* synthetic */ ApiAdContentModel(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, AdImageModel adImageModel, List list, String str8, Integer num2, MonitorModel monitorModel, String str9, Integer num3, String str10, Integer num4, String str11, List list2, String str12, AppModel appModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, str2, str3, str4, str5, str6, str7, adImageModel, list, str8, (i10 & 2048) != 0 ? null : num2, monitorModel, str9, num3, str10, num4, str11, list2, str12, appModel);
    }
}
