package com.cupidapp.live.liveshow.model;

import android.graphics.drawable.GradientDrawable;
import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.util.locale.LanguageTag;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AnchorInfoBorderModel implements Serializable {

    @Nullable
    private final String borderColor;

    @Nullable
    private final String borderColorDirection;

    @Nullable
    private final String endBackgroundColor;

    @Nullable
    private final ImageModel leftTopImage;

    @Nullable
    private final ImageModel rightBottomImage;

    @Nullable
    private final String startBackgroundColor;

    public AnchorInfoBorderModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str4) {
        this.borderColor = str;
        this.startBackgroundColor = str2;
        this.endBackgroundColor = str3;
        this.leftTopImage = imageModel;
        this.rightBottomImage = imageModel2;
        this.borderColorDirection = str4;
    }

    public static /* synthetic */ AnchorInfoBorderModel copy$default(AnchorInfoBorderModel anchorInfoBorderModel, String str, String str2, String str3, ImageModel imageModel, ImageModel imageModel2, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = anchorInfoBorderModel.borderColor;
        }
        if ((i10 & 2) != 0) {
            str2 = anchorInfoBorderModel.startBackgroundColor;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = anchorInfoBorderModel.endBackgroundColor;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            imageModel = anchorInfoBorderModel.leftTopImage;
        }
        ImageModel imageModel3 = imageModel;
        if ((i10 & 16) != 0) {
            imageModel2 = anchorInfoBorderModel.rightBottomImage;
        }
        ImageModel imageModel4 = imageModel2;
        if ((i10 & 32) != 0) {
            str4 = anchorInfoBorderModel.borderColorDirection;
        }
        return anchorInfoBorderModel.copy(str, str5, str6, imageModel3, imageModel4, str4);
    }

    @Nullable
    public final String component1() {
        return this.borderColor;
    }

    @Nullable
    public final String component2() {
        return this.startBackgroundColor;
    }

    @Nullable
    public final String component3() {
        return this.endBackgroundColor;
    }

    @Nullable
    public final ImageModel component4() {
        return this.leftTopImage;
    }

    @Nullable
    public final ImageModel component5() {
        return this.rightBottomImage;
    }

    @Nullable
    public final String component6() {
        return this.borderColorDirection;
    }

    @NotNull
    public final AnchorInfoBorderModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str4) {
        return new AnchorInfoBorderModel(str, str2, str3, imageModel, imageModel2, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnchorInfoBorderModel)) {
            return false;
        }
        AnchorInfoBorderModel anchorInfoBorderModel = (AnchorInfoBorderModel) obj;
        return s.d(this.borderColor, anchorInfoBorderModel.borderColor) && s.d(this.startBackgroundColor, anchorInfoBorderModel.startBackgroundColor) && s.d(this.endBackgroundColor, anchorInfoBorderModel.endBackgroundColor) && s.d(this.leftTopImage, anchorInfoBorderModel.leftTopImage) && s.d(this.rightBottomImage, anchorInfoBorderModel.rightBottomImage) && s.d(this.borderColorDirection, anchorInfoBorderModel.borderColorDirection);
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final String getBorderColorDirection() {
        return this.borderColorDirection;
    }

    @Nullable
    public final String getEndBackgroundColor() {
        return this.endBackgroundColor;
    }

    @NotNull
    public final GradientDrawable.Orientation getGradientOrientation() {
        String str = this.borderColorDirection;
        return s.d(str, LanguageTag.PRIVATEUSE) ? GradientDrawable.Orientation.LEFT_RIGHT : s.d(str, "y") ? GradientDrawable.Orientation.TOP_BOTTOM : GradientDrawable.Orientation.TOP_BOTTOM;
    }

    @Nullable
    public final ImageModel getLeftTopImage() {
        return this.leftTopImage;
    }

    @Nullable
    public final ImageModel getRightBottomImage() {
        return this.rightBottomImage;
    }

    @Nullable
    public final String getStartBackgroundColor() {
        return this.startBackgroundColor;
    }

    public int hashCode() {
        String str = this.borderColor;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.startBackgroundColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endBackgroundColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ImageModel imageModel = this.leftTopImage;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.rightBottomImage;
        int hashCode5 = (hashCode4 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str4 = this.borderColorDirection;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.borderColor;
        String str2 = this.startBackgroundColor;
        String str3 = this.endBackgroundColor;
        ImageModel imageModel = this.leftTopImage;
        ImageModel imageModel2 = this.rightBottomImage;
        return "AnchorInfoBorderModel(borderColor=" + str + ", startBackgroundColor=" + str2 + ", endBackgroundColor=" + str3 + ", leftTopImage=" + ((Object) imageModel) + ", rightBottomImage=" + ((Object) imageModel2) + ", borderColorDirection=" + this.borderColorDirection + ")";
    }
}
