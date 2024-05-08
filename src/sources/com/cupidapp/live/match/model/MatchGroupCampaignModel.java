package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchGroupCampaignModel extends MatchRecommendModel {

    @Nullable
    private final String activityId;

    @Nullable
    private final String configKey;

    @Nullable
    private final String desc;

    @Nullable
    private final String groupId;
    private boolean hasSeeContent;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String poiAddress;

    @Nullable
    private final List<String> tags;

    @Nullable
    private final String timeDesc;

    @Nullable
    private final String title;

    public /* synthetic */ MatchGroupCampaignModel(String str, Map map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ImageModel imageModel, String str9, boolean z10, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : map, str2, str3, str4, str5, str6, str7, str8, imageModel, str9, (i10 & 2048) != 0 ? false : z10, list);
    }

    @Nullable
    public final String getActivityId() {
        return this.activityId;
    }

    @Nullable
    public final String getCardId() {
        String str = this.activityId;
        return str == null ? this.configKey : str;
    }

    @Nullable
    public final String getConfigKey() {
        return this.configKey;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getHasSeeContent() {
        return this.hasSeeContent;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getPoiAddress() {
        return this.poiAddress;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getTimeDesc() {
        return this.timeDesc;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final void setHasSeeContent(boolean z10) {
        this.hasSeeContent = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchGroupCampaignModel(@NotNull String type, @Nullable Map<String, ? extends Object> map, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable ImageModel imageModel, @Nullable String str8, boolean z10, @Nullable List<String> list) {
        super(type, map);
        s.i(type, "type");
        this.activityId = str;
        this.groupId = str2;
        this.jumpUrl = str3;
        this.poiAddress = str4;
        this.title = str5;
        this.desc = str6;
        this.timeDesc = str7;
        this.image = imageModel;
        this.configKey = str8;
        this.hasSeeContent = z10;
        this.tags = list;
    }
}
