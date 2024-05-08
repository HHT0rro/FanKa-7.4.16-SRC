package com.cupidapp.live.base.share.fragment;

import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.SharePlatform;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareBottomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareModel implements Serializable {

    @Nullable
    private final Map<ShareOperateType, Object> customShareTypes;

    @Nullable
    private final String feedId;

    @Nullable
    private final FollowPrefer followPrefer;

    @Nullable
    private final List<SharePlatform> notShowPlatformTypes;

    @Nullable
    private final List<ShareOperateType> operateTypes;

    @Nullable
    private final String postStatisticsSource;

    @NotNull
    private final SensorPosition sensorPosition;

    @Nullable
    private final ShareBuilder shareBuilder;

    @Nullable
    private final String snapWebContentImageUrl;

    @Nullable
    private final Boolean superLikedByMe;

    @Nullable
    private final String userId;

    public ShareModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareModel(@Nullable String str, @Nullable String str2, @Nullable ShareBuilder shareBuilder, @Nullable FollowPrefer followPrefer, @Nullable List<? extends ShareOperateType> list, @NotNull SensorPosition sensorPosition, @Nullable Boolean bool, @Nullable String str3, @Nullable List<? extends SharePlatform> list2, @Nullable String str4, @Nullable Map<ShareOperateType, ? extends Object> map) {
        s.i(sensorPosition, "sensorPosition");
        this.userId = str;
        this.feedId = str2;
        this.shareBuilder = shareBuilder;
        this.followPrefer = followPrefer;
        this.operateTypes = list;
        this.sensorPosition = sensorPosition;
        this.superLikedByMe = bool;
        this.snapWebContentImageUrl = str3;
        this.notShowPlatformTypes = list2;
        this.postStatisticsSource = str4;
        this.customShareTypes = map;
    }

    @Nullable
    public final Map<ShareOperateType, Object> getCustomShareTypes() {
        return this.customShareTypes;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    public final FollowPrefer getFollowPrefer() {
        return this.followPrefer;
    }

    @Nullable
    public final List<SharePlatform> getNotShowPlatformTypes() {
        return this.notShowPlatformTypes;
    }

    @Nullable
    public final List<ShareOperateType> getOperateTypes() {
        return this.operateTypes;
    }

    @Nullable
    public final String getPostStatisticsSource() {
        return this.postStatisticsSource;
    }

    @NotNull
    public final SensorPosition getSensorPosition() {
        return this.sensorPosition;
    }

    @Nullable
    public final ShareBuilder getShareBuilder() {
        return this.shareBuilder;
    }

    @Nullable
    public final String getSnapWebContentImageUrl() {
        return this.snapWebContentImageUrl;
    }

    @Nullable
    public final Boolean getSuperLikedByMe() {
        return this.superLikedByMe;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public /* synthetic */ ShareModel(String str, String str2, ShareBuilder shareBuilder, FollowPrefer followPrefer, List list, SensorPosition sensorPosition, Boolean bool, String str3, List list2, String str4, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : shareBuilder, (i10 & 8) != 0 ? null : followPrefer, (i10 & 16) != 0 ? null : list, (i10 & 32) != 0 ? SensorPosition.Unknown : sensorPosition, (i10 & 64) != 0 ? null : bool, (i10 & 128) != 0 ? null : str3, (i10 & 256) != 0 ? null : list2, (i10 & 512) != 0 ? null : str4, (i10 & 1024) == 0 ? map : null);
    }
}
