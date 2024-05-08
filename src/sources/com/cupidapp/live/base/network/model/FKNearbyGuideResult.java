package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKNearbyGuideResult {

    @Nullable
    private final ImageModel avatar;
    private final int avatarShowTime;

    @Nullable
    private final String templateId;

    @Nullable
    private final String text;

    public FKNearbyGuideResult(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, int i10) {
        this.text = str;
        this.templateId = str2;
        this.avatar = imageModel;
        this.avatarShowTime = i10;
    }

    public static /* synthetic */ FKNearbyGuideResult copy$default(FKNearbyGuideResult fKNearbyGuideResult, String str, String str2, ImageModel imageModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fKNearbyGuideResult.text;
        }
        if ((i11 & 2) != 0) {
            str2 = fKNearbyGuideResult.templateId;
        }
        if ((i11 & 4) != 0) {
            imageModel = fKNearbyGuideResult.avatar;
        }
        if ((i11 & 8) != 0) {
            i10 = fKNearbyGuideResult.avatarShowTime;
        }
        return fKNearbyGuideResult.copy(str, str2, imageModel, i10);
    }

    @Nullable
    public final String component1() {
        return this.text;
    }

    @Nullable
    public final String component2() {
        return this.templateId;
    }

    @Nullable
    public final ImageModel component3() {
        return this.avatar;
    }

    public final int component4() {
        return this.avatarShowTime;
    }

    @NotNull
    public final FKNearbyGuideResult copy(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, int i10) {
        return new FKNearbyGuideResult(str, str2, imageModel, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKNearbyGuideResult)) {
            return false;
        }
        FKNearbyGuideResult fKNearbyGuideResult = (FKNearbyGuideResult) obj;
        return s.d(this.text, fKNearbyGuideResult.text) && s.d(this.templateId, fKNearbyGuideResult.templateId) && s.d(this.avatar, fKNearbyGuideResult.avatar) && this.avatarShowTime == fKNearbyGuideResult.avatarShowTime;
    }

    @Nullable
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    public final int getAvatarShowTime() {
        return this.avatarShowTime;
    }

    @Nullable
    public final String getTemplateId() {
        return this.templateId;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.templateId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.avatar;
        return ((hashCode2 + (imageModel != null ? imageModel.hashCode() : 0)) * 31) + this.avatarShowTime;
    }

    @NotNull
    public String toString() {
        String str = this.text;
        String str2 = this.templateId;
        ImageModel imageModel = this.avatar;
        return "FKNearbyGuideResult(text=" + str + ", templateId=" + str2 + ", avatar=" + ((Object) imageModel) + ", avatarShowTime=" + this.avatarShowTime + ")";
    }

    public /* synthetic */ FKNearbyGuideResult(String str, String str2, ImageModel imageModel, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageModel, (i11 & 8) != 0 ? 5 : i10);
    }
}
