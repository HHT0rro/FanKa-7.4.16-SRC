package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AnchorGradeInfoModel implements Serializable {

    @Nullable
    private final ImageModel avatarBadge;
    private final double diffExperience;
    private final boolean fullLevel;
    private final int level;

    @Nullable
    private final ImageModel levelBadgeImage;

    public AnchorGradeInfoModel(int i10, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, double d10, boolean z10) {
        this.level = i10;
        this.levelBadgeImage = imageModel;
        this.avatarBadge = imageModel2;
        this.diffExperience = d10;
        this.fullLevel = z10;
    }

    public static /* synthetic */ AnchorGradeInfoModel copy$default(AnchorGradeInfoModel anchorGradeInfoModel, int i10, ImageModel imageModel, ImageModel imageModel2, double d10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = anchorGradeInfoModel.level;
        }
        if ((i11 & 2) != 0) {
            imageModel = anchorGradeInfoModel.levelBadgeImage;
        }
        ImageModel imageModel3 = imageModel;
        if ((i11 & 4) != 0) {
            imageModel2 = anchorGradeInfoModel.avatarBadge;
        }
        ImageModel imageModel4 = imageModel2;
        if ((i11 & 8) != 0) {
            d10 = anchorGradeInfoModel.diffExperience;
        }
        double d11 = d10;
        if ((i11 & 16) != 0) {
            z10 = anchorGradeInfoModel.fullLevel;
        }
        return anchorGradeInfoModel.copy(i10, imageModel3, imageModel4, d11, z10);
    }

    public final int component1() {
        return this.level;
    }

    @Nullable
    public final ImageModel component2() {
        return this.levelBadgeImage;
    }

    @Nullable
    public final ImageModel component3() {
        return this.avatarBadge;
    }

    public final double component4() {
        return this.diffExperience;
    }

    public final boolean component5() {
        return this.fullLevel;
    }

    @NotNull
    public final AnchorGradeInfoModel copy(int i10, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, double d10, boolean z10) {
        return new AnchorGradeInfoModel(i10, imageModel, imageModel2, d10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnchorGradeInfoModel)) {
            return false;
        }
        AnchorGradeInfoModel anchorGradeInfoModel = (AnchorGradeInfoModel) obj;
        return this.level == anchorGradeInfoModel.level && s.d(this.levelBadgeImage, anchorGradeInfoModel.levelBadgeImage) && s.d(this.avatarBadge, anchorGradeInfoModel.avatarBadge) && Double.compare(this.diffExperience, anchorGradeInfoModel.diffExperience) == 0 && this.fullLevel == anchorGradeInfoModel.fullLevel;
    }

    @Nullable
    public final ImageModel getAvatarBadge() {
        return this.avatarBadge;
    }

    public final double getDiffExperience() {
        return this.diffExperience;
    }

    public final boolean getFullLevel() {
        return this.fullLevel;
    }

    public final int getLevel() {
        return this.level;
    }

    @Nullable
    public final ImageModel getLevelBadgeImage() {
        return this.levelBadgeImage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i10 = this.level * 31;
        ImageModel imageModel = this.levelBadgeImage;
        int hashCode = (i10 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.avatarBadge;
        int hashCode2 = (((hashCode + (imageModel2 != null ? imageModel2.hashCode() : 0)) * 31) + ce.d.a(this.diffExperience)) * 31;
        boolean z10 = this.fullLevel;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        int i10 = this.level;
        ImageModel imageModel = this.levelBadgeImage;
        ImageModel imageModel2 = this.avatarBadge;
        return "AnchorGradeInfoModel(level=" + i10 + ", levelBadgeImage=" + ((Object) imageModel) + ", avatarBadge=" + ((Object) imageModel2) + ", diffExperience=" + this.diffExperience + ", fullLevel=" + this.fullLevel + ")";
    }
}
