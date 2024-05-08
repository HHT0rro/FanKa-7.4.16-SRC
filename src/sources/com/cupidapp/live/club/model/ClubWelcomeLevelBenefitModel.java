package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubWelcomeLevelBenefitModel {

    @Nullable
    private final String desc;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String title;

    public ClubWelcomeLevelBenefitModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        this.image = imageModel;
        this.title = str;
        this.desc = str2;
    }

    public static /* synthetic */ ClubWelcomeLevelBenefitModel copy$default(ClubWelcomeLevelBenefitModel clubWelcomeLevelBenefitModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = clubWelcomeLevelBenefitModel.image;
        }
        if ((i10 & 2) != 0) {
            str = clubWelcomeLevelBenefitModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = clubWelcomeLevelBenefitModel.desc;
        }
        return clubWelcomeLevelBenefitModel.copy(imageModel, str, str2);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.desc;
    }

    @NotNull
    public final ClubWelcomeLevelBenefitModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        return new ClubWelcomeLevelBenefitModel(imageModel, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubWelcomeLevelBenefitModel)) {
            return false;
        }
        ClubWelcomeLevelBenefitModel clubWelcomeLevelBenefitModel = (ClubWelcomeLevelBenefitModel) obj;
        return s.d(this.image, clubWelcomeLevelBenefitModel.image) && s.d(this.title, clubWelcomeLevelBenefitModel.title) && s.d(this.desc, clubWelcomeLevelBenefitModel.desc);
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.desc;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        return "ClubWelcomeLevelBenefitModel(image=" + ((Object) imageModel) + ", title=" + this.title + ", desc=" + this.desc + ")";
    }
}
