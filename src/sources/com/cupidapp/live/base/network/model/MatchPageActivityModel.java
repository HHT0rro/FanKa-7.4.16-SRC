package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MatchPageActivityModel {

    @Nullable
    private final String activityId;

    @Nullable
    private final ImageModel activityImage;

    @Nullable
    private final String activityUrl;

    public MatchPageActivityModel(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel) {
        this.activityId = str;
        this.activityUrl = str2;
        this.activityImage = imageModel;
    }

    public static /* synthetic */ MatchPageActivityModel copy$default(MatchPageActivityModel matchPageActivityModel, String str, String str2, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchPageActivityModel.activityId;
        }
        if ((i10 & 2) != 0) {
            str2 = matchPageActivityModel.activityUrl;
        }
        if ((i10 & 4) != 0) {
            imageModel = matchPageActivityModel.activityImage;
        }
        return matchPageActivityModel.copy(str, str2, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.activityId;
    }

    @Nullable
    public final String component2() {
        return this.activityUrl;
    }

    @Nullable
    public final ImageModel component3() {
        return this.activityImage;
    }

    @NotNull
    public final MatchPageActivityModel copy(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel) {
        return new MatchPageActivityModel(str, str2, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchPageActivityModel)) {
            return false;
        }
        MatchPageActivityModel matchPageActivityModel = (MatchPageActivityModel) obj;
        return s.d(this.activityId, matchPageActivityModel.activityId) && s.d(this.activityUrl, matchPageActivityModel.activityUrl) && s.d(this.activityImage, matchPageActivityModel.activityImage);
    }

    @Nullable
    public final String getActivityId() {
        return this.activityId;
    }

    @Nullable
    public final ImageModel getActivityImage() {
        return this.activityImage;
    }

    @Nullable
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    public int hashCode() {
        String str = this.activityId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.activityUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.activityImage;
        return hashCode2 + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MatchPageActivityModel(activityId=" + this.activityId + ", activityUrl=" + this.activityUrl + ", activityImage=" + ((Object) this.activityImage) + ")";
    }
}
