package com.cupidapp.live.liveshow.view.tag;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveShowTagView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowTagModel implements Serializable {

    @NotNull
    private final String bgColor;
    private final float bgColorAlpha;

    @Nullable
    private final String borderColor;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f15977id;

    @Nullable
    private final ImageModel leftIcon;

    @Nullable
    private final String name;

    @Nullable
    private final Float percent;

    @Nullable
    private final String percentColor;

    @Nullable
    private final Float percentColorAlpha;

    @Nullable
    private final ImageModel rightIcon;
    private final int style;

    @Nullable
    private final ImageModel taskIcon;

    @NotNull
    private final String text;

    @Nullable
    private final String url;

    public LiveShowTagModel(@NotNull String id2, @Nullable String str, @NotNull String text, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @NotNull String bgColor, float f10, @Nullable String str2, @Nullable Float f11, @Nullable String str3, @Nullable Float f12, int i10, @Nullable String str4) {
        s.i(id2, "id");
        s.i(text, "text");
        s.i(bgColor, "bgColor");
        this.f15977id = id2;
        this.url = str;
        this.text = text;
        this.leftIcon = imageModel;
        this.rightIcon = imageModel2;
        this.taskIcon = imageModel3;
        this.bgColor = bgColor;
        this.bgColorAlpha = f10;
        this.borderColor = str2;
        this.percent = f11;
        this.percentColor = str3;
        this.percentColorAlpha = f12;
        this.style = i10;
        this.name = str4;
    }

    @NotNull
    public final String component1() {
        return this.f15977id;
    }

    @Nullable
    public final Float component10() {
        return this.percent;
    }

    @Nullable
    public final String component11() {
        return this.percentColor;
    }

    @Nullable
    public final Float component12() {
        return this.percentColorAlpha;
    }

    public final int component13() {
        return this.style;
    }

    @Nullable
    public final String component14() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final String component3() {
        return this.text;
    }

    @Nullable
    public final ImageModel component4() {
        return this.leftIcon;
    }

    @Nullable
    public final ImageModel component5() {
        return this.rightIcon;
    }

    @Nullable
    public final ImageModel component6() {
        return this.taskIcon;
    }

    @NotNull
    public final String component7() {
        return this.bgColor;
    }

    public final float component8() {
        return this.bgColorAlpha;
    }

    @Nullable
    public final String component9() {
        return this.borderColor;
    }

    @NotNull
    public final LiveShowTagModel copy(@NotNull String id2, @Nullable String str, @NotNull String text, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @NotNull String bgColor, float f10, @Nullable String str2, @Nullable Float f11, @Nullable String str3, @Nullable Float f12, int i10, @Nullable String str4) {
        s.i(id2, "id");
        s.i(text, "text");
        s.i(bgColor, "bgColor");
        return new LiveShowTagModel(id2, str, text, imageModel, imageModel2, imageModel3, bgColor, f10, str2, f11, str3, f12, i10, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowTagModel)) {
            return false;
        }
        LiveShowTagModel liveShowTagModel = (LiveShowTagModel) obj;
        return s.d(this.f15977id, liveShowTagModel.f15977id) && s.d(this.url, liveShowTagModel.url) && s.d(this.text, liveShowTagModel.text) && s.d(this.leftIcon, liveShowTagModel.leftIcon) && s.d(this.rightIcon, liveShowTagModel.rightIcon) && s.d(this.taskIcon, liveShowTagModel.taskIcon) && s.d(this.bgColor, liveShowTagModel.bgColor) && Float.compare(this.bgColorAlpha, liveShowTagModel.bgColorAlpha) == 0 && s.d(this.borderColor, liveShowTagModel.borderColor) && s.d(this.percent, liveShowTagModel.percent) && s.d(this.percentColor, liveShowTagModel.percentColor) && s.d(this.percentColorAlpha, liveShowTagModel.percentColorAlpha) && this.style == liveShowTagModel.style && s.d(this.name, liveShowTagModel.name);
    }

    @NotNull
    public final String getBgColor() {
        return this.bgColor;
    }

    public final float getBgColorAlpha() {
        return this.bgColorAlpha;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @NotNull
    public final String getId() {
        return this.f15977id;
    }

    @Nullable
    public final ImageModel getLeftIcon() {
        return this.leftIcon;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Float getPercent() {
        return this.percent;
    }

    @Nullable
    public final String getPercentColor() {
        return this.percentColor;
    }

    @Nullable
    public final Float getPercentColorAlpha() {
        return this.percentColorAlpha;
    }

    @Nullable
    public final ImageModel getRightIcon() {
        return this.rightIcon;
    }

    public final int getStyle() {
        return this.style;
    }

    @Nullable
    public final ImageModel getTaskIcon() {
        return this.taskIcon;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.f15977id.hashCode() * 31;
        String str = this.url;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.text.hashCode()) * 31;
        ImageModel imageModel = this.leftIcon;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.rightIcon;
        int hashCode4 = (hashCode3 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        ImageModel imageModel3 = this.taskIcon;
        int hashCode5 = (((((hashCode4 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31) + this.bgColor.hashCode()) * 31) + Float.floatToIntBits(this.bgColorAlpha)) * 31;
        String str2 = this.borderColor;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f10 = this.percent;
        int hashCode7 = (hashCode6 + (f10 == null ? 0 : f10.hashCode())) * 31;
        String str3 = this.percentColor;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f11 = this.percentColorAlpha;
        int hashCode9 = (((hashCode8 + (f11 == null ? 0 : f11.hashCode())) * 31) + this.style) * 31;
        String str4 = this.name;
        return hashCode9 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.f15977id;
        String str2 = this.url;
        String str3 = this.text;
        ImageModel imageModel = this.leftIcon;
        ImageModel imageModel2 = this.rightIcon;
        ImageModel imageModel3 = this.taskIcon;
        String str4 = this.bgColor;
        float f10 = this.bgColorAlpha;
        String str5 = this.borderColor;
        Float f11 = this.percent;
        String str6 = this.percentColor;
        Float f12 = this.percentColorAlpha;
        return "LiveShowTagModel(id=" + str + ", url=" + str2 + ", text=" + str3 + ", leftIcon=" + ((Object) imageModel) + ", rightIcon=" + ((Object) imageModel2) + ", taskIcon=" + ((Object) imageModel3) + ", bgColor=" + str4 + ", bgColorAlpha=" + f10 + ", borderColor=" + str5 + ", percent=" + ((Object) f11) + ", percentColor=" + str6 + ", percentColorAlpha=" + ((Object) f12) + ", style=" + this.style + ", name=" + this.name + ")";
    }
}
