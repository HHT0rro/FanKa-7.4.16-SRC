package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class MediaContentModel implements Serializable {

    @Nullable
    private String addPlaceMethod;

    @Nullable
    private String description;

    @Nullable
    private HashTagSimpleModel hashTag;

    @Nullable
    private Location location;

    @Nullable
    private List<ReplaceAtModel> replaceAtList;

    @Nullable
    private String title;

    @Nullable
    private String webTitle;
    private boolean closeFriendOnly = true;

    @NotNull
    private String publishMethod = "其他";

    @NotNull
    private SensorPosition publishPosition = SensorPosition.Unknown;

    @Nullable
    public final String getAddPlaceMethod() {
        return this.addPlaceMethod;
    }

    public final boolean getCloseFriendOnly() {
        return this.closeFriendOnly;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final HashTagSimpleModel getHashTag() {
        return this.hashTag;
    }

    @Nullable
    public final Location getLocation() {
        return this.location;
    }

    @NotNull
    public final String getPublishMethod() {
        return this.publishMethod;
    }

    @NotNull
    public final SensorPosition getPublishPosition() {
        return this.publishPosition;
    }

    @Nullable
    public final List<ReplaceAtModel> getReplaceAtList() {
        return this.replaceAtList;
    }

    @Nullable
    public final String getReplaceAtListStr() {
        List<ReplaceAtModel> list = this.replaceAtList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return GsonUtil.f12000a.b().toJson(this.replaceAtList);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getWebTitle() {
        return this.webTitle;
    }

    public final void setAddPlaceMethod(@Nullable String str) {
        this.addPlaceMethod = str;
    }

    public final void setCloseFriendOnly(boolean z10) {
        this.closeFriendOnly = z10;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setHashTag(@Nullable HashTagSimpleModel hashTagSimpleModel) {
        this.hashTag = hashTagSimpleModel;
    }

    public final void setLocation(@Nullable Location location) {
        this.location = location;
    }

    public final void setPublishMethod(@NotNull String str) {
        s.i(str, "<set-?>");
        this.publishMethod = str;
    }

    public final void setPublishPosition(@NotNull SensorPosition sensorPosition) {
        s.i(sensorPosition, "<set-?>");
        this.publishPosition = sensorPosition;
    }

    public final void setReplaceAtList(@Nullable List<ReplaceAtModel> list) {
        this.replaceAtList = list;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setWebTitle(@Nullable String str) {
        this.webTitle = str;
    }
}
