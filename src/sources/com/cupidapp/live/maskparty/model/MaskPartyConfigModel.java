package com.cupidapp.live.maskparty.model;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyConfigModel {

    @Nullable
    private final String enterButtonSubTitle;

    @NotNull
    private final ImageModel icon;

    @NotNull
    private final List<MaskPartyModel> playTypeInfo;
    private int remains;

    @NotNull
    private final ImageModel secondaryIcon;

    @NotNull
    private final String title;

    public MaskPartyConfigModel(@NotNull String title, @NotNull ImageModel icon, @NotNull ImageModel secondaryIcon, int i10, @NotNull List<MaskPartyModel> playTypeInfo, @Nullable String str) {
        s.i(title, "title");
        s.i(icon, "icon");
        s.i(secondaryIcon, "secondaryIcon");
        s.i(playTypeInfo, "playTypeInfo");
        this.title = title;
        this.icon = icon;
        this.secondaryIcon = secondaryIcon;
        this.remains = i10;
        this.playTypeInfo = playTypeInfo;
        this.enterButtonSubTitle = str;
    }

    public static /* synthetic */ MaskPartyConfigModel copy$default(MaskPartyConfigModel maskPartyConfigModel, String str, ImageModel imageModel, ImageModel imageModel2, int i10, List list, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = maskPartyConfigModel.title;
        }
        if ((i11 & 2) != 0) {
            imageModel = maskPartyConfigModel.icon;
        }
        ImageModel imageModel3 = imageModel;
        if ((i11 & 4) != 0) {
            imageModel2 = maskPartyConfigModel.secondaryIcon;
        }
        ImageModel imageModel4 = imageModel2;
        if ((i11 & 8) != 0) {
            i10 = maskPartyConfigModel.remains;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            list = maskPartyConfigModel.playTypeInfo;
        }
        List list2 = list;
        if ((i11 & 32) != 0) {
            str2 = maskPartyConfigModel.enterButtonSubTitle;
        }
        return maskPartyConfigModel.copy(str, imageModel3, imageModel4, i12, list2, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final ImageModel component2() {
        return this.icon;
    }

    @NotNull
    public final ImageModel component3() {
        return this.secondaryIcon;
    }

    public final int component4() {
        return this.remains;
    }

    @NotNull
    public final List<MaskPartyModel> component5() {
        return this.playTypeInfo;
    }

    @Nullable
    public final String component6() {
        return this.enterButtonSubTitle;
    }

    @NotNull
    public final MaskPartyConfigModel copy(@NotNull String title, @NotNull ImageModel icon, @NotNull ImageModel secondaryIcon, int i10, @NotNull List<MaskPartyModel> playTypeInfo, @Nullable String str) {
        s.i(title, "title");
        s.i(icon, "icon");
        s.i(secondaryIcon, "secondaryIcon");
        s.i(playTypeInfo, "playTypeInfo");
        return new MaskPartyConfigModel(title, icon, secondaryIcon, i10, playTypeInfo, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyConfigModel)) {
            return false;
        }
        MaskPartyConfigModel maskPartyConfigModel = (MaskPartyConfigModel) obj;
        return s.d(this.title, maskPartyConfigModel.title) && s.d(this.icon, maskPartyConfigModel.icon) && s.d(this.secondaryIcon, maskPartyConfigModel.secondaryIcon) && this.remains == maskPartyConfigModel.remains && s.d(this.playTypeInfo, maskPartyConfigModel.playTypeInfo) && s.d(this.enterButtonSubTitle, maskPartyConfigModel.enterButtonSubTitle);
    }

    @NotNull
    public final String formatRemains(@NotNull Context context) {
        s.i(context, "context");
        int i10 = this.remains;
        if (i10 <= -100) {
            String string = context.getString(R$string.unlimit);
            s.h(string, "{\n            context.ge…string.unlimit)\n        }");
            return string;
        }
        String string2 = context.getString(R$string.remain, Integer.valueOf(i10));
        s.h(string2, "{\n            context.ge…emain, remains)\n        }");
        return string2;
    }

    @Nullable
    public final String getEnterButtonSubTitle() {
        return this.enterButtonSubTitle;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final List<MaskPartyModel> getPlayTypeInfo() {
        return this.playTypeInfo;
    }

    public final int getPlusRemains() {
        int i10 = this.remains;
        return i10 >= 0 ? i10 + 1 : i10;
    }

    public final int getRemains() {
        return this.remains;
    }

    @NotNull
    public final ImageModel getSecondaryIcon() {
        return this.secondaryIcon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean hasRemains() {
        int i10 = this.remains;
        return i10 <= -100 || i10 > 0;
    }

    public int hashCode() {
        int hashCode = ((((((((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + this.secondaryIcon.hashCode()) * 31) + this.remains) * 31) + this.playTypeInfo.hashCode()) * 31;
        String str = this.enterButtonSubTitle;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setRemains(int i10) {
        this.remains = i10;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        ImageModel imageModel = this.icon;
        ImageModel imageModel2 = this.secondaryIcon;
        int i10 = this.remains;
        List<MaskPartyModel> list = this.playTypeInfo;
        return "MaskPartyConfigModel(title=" + str + ", icon=" + ((Object) imageModel) + ", secondaryIcon=" + ((Object) imageModel2) + ", remains=" + i10 + ", playTypeInfo=" + ((Object) list) + ", enterButtonSubTitle=" + this.enterButtonSubTitle + ")";
    }
}
