package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveLabelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveLabelModel {

    @Nullable
    private final String badgeBgColor;

    @Nullable
    private final String badgeName;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final Integer level;

    @NotNull
    private final String type;

    public LiveLabelModel(@NotNull String type, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        s.i(type, "type");
        this.type = type;
        this.level = num;
        this.image = imageModel;
        this.badgeName = str;
        this.badgeBgColor = str2;
    }

    public static /* synthetic */ LiveLabelModel copy$default(LiveLabelModel liveLabelModel, String str, Integer num, ImageModel imageModel, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveLabelModel.type;
        }
        if ((i10 & 2) != 0) {
            num = liveLabelModel.level;
        }
        Integer num2 = num;
        if ((i10 & 4) != 0) {
            imageModel = liveLabelModel.image;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            str2 = liveLabelModel.badgeName;
        }
        String str4 = str2;
        if ((i10 & 16) != 0) {
            str3 = liveLabelModel.badgeBgColor;
        }
        return liveLabelModel.copy(str, num2, imageModel2, str4, str3);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final Integer component2() {
        return this.level;
    }

    @Nullable
    public final ImageModel component3() {
        return this.image;
    }

    @Nullable
    public final String component4() {
        return this.badgeName;
    }

    @Nullable
    public final String component5() {
        return this.badgeBgColor;
    }

    @NotNull
    public final LiveLabelModel copy(@NotNull String type, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        s.i(type, "type");
        return new LiveLabelModel(type, num, imageModel, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveLabelModel)) {
            return false;
        }
        LiveLabelModel liveLabelModel = (LiveLabelModel) obj;
        return s.d(this.type, liveLabelModel.type) && s.d(this.level, liveLabelModel.level) && s.d(this.image, liveLabelModel.image) && s.d(this.badgeName, liveLabelModel.badgeName) && s.d(this.badgeBgColor, liveLabelModel.badgeBgColor);
    }

    @Nullable
    public final String getBadgeBgColor() {
        return this.badgeBgColor;
    }

    @Nullable
    public final String getBadgeName() {
        return this.badgeName;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Integer num = this.level;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.badgeName;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.badgeBgColor;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.type;
        Integer num = this.level;
        ImageModel imageModel = this.image;
        return "LiveLabelModel(type=" + str + ", level=" + ((Object) num) + ", image=" + ((Object) imageModel) + ", badgeName=" + this.badgeName + ", badgeBgColor=" + this.badgeBgColor + ")";
    }

    public /* synthetic */ LiveLabelModel(String str, Integer num, ImageModel imageModel, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : imageModel, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3);
    }
}
