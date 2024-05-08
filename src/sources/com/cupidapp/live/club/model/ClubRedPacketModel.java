package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubRedPacketModel {

    @Nullable
    private final String giftId;

    @Nullable
    private final ImageModel giftImage;

    @Nullable
    private final String giftName;
    private boolean isSelected;

    @Nullable
    private final Integer price;

    public ClubRedPacketModel(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable Integer num, boolean z10) {
        this.giftId = str;
        this.giftName = str2;
        this.giftImage = imageModel;
        this.price = num;
        this.isSelected = z10;
    }

    public static /* synthetic */ ClubRedPacketModel copy$default(ClubRedPacketModel clubRedPacketModel, String str, String str2, ImageModel imageModel, Integer num, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubRedPacketModel.giftId;
        }
        if ((i10 & 2) != 0) {
            str2 = clubRedPacketModel.giftName;
        }
        String str3 = str2;
        if ((i10 & 4) != 0) {
            imageModel = clubRedPacketModel.giftImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            num = clubRedPacketModel.price;
        }
        Integer num2 = num;
        if ((i10 & 16) != 0) {
            z10 = clubRedPacketModel.isSelected;
        }
        return clubRedPacketModel.copy(str, str3, imageModel2, num2, z10);
    }

    @Nullable
    public final String component1() {
        return this.giftId;
    }

    @Nullable
    public final String component2() {
        return this.giftName;
    }

    @Nullable
    public final ImageModel component3() {
        return this.giftImage;
    }

    @Nullable
    public final Integer component4() {
        return this.price;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    @NotNull
    public final ClubRedPacketModel copy(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable Integer num, boolean z10) {
        return new ClubRedPacketModel(str, str2, imageModel, num, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubRedPacketModel)) {
            return false;
        }
        ClubRedPacketModel clubRedPacketModel = (ClubRedPacketModel) obj;
        return s.d(this.giftId, clubRedPacketModel.giftId) && s.d(this.giftName, clubRedPacketModel.giftName) && s.d(this.giftImage, clubRedPacketModel.giftImage) && s.d(this.price, clubRedPacketModel.price) && this.isSelected == clubRedPacketModel.isSelected;
    }

    @Nullable
    public final String getGiftId() {
        return this.giftId;
    }

    @Nullable
    public final ImageModel getGiftImage() {
        return this.giftImage;
    }

    @Nullable
    public final String getGiftName() {
        return this.giftName;
    }

    @Nullable
    public final Integer getPrice() {
        return this.price;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.giftId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.giftName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.giftImage;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        Integer num = this.price;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode4 + i10;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @NotNull
    public String toString() {
        String str = this.giftId;
        String str2 = this.giftName;
        ImageModel imageModel = this.giftImage;
        Integer num = this.price;
        return "ClubRedPacketModel(giftId=" + str + ", giftName=" + str2 + ", giftImage=" + ((Object) imageModel) + ", price=" + ((Object) num) + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ ClubRedPacketModel(String str, String str2, ImageModel imageModel, Integer num, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageModel, num, (i10 & 16) != 0 ? false : z10);
    }
}
