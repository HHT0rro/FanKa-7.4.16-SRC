package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MiniProfileUserTagModel implements Serializable {

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final String bubbleText;

    @Nullable
    private final String color;

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String text;

    public MiniProfileUserTagModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.icon = imageModel;
        this.color = str;
        this.text = str2;
        this.backgroundColor = str3;
        this.bubbleText = str4;
    }

    public static /* synthetic */ MiniProfileUserTagModel copy$default(MiniProfileUserTagModel miniProfileUserTagModel, ImageModel imageModel, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = miniProfileUserTagModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = miniProfileUserTagModel.color;
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = miniProfileUserTagModel.text;
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            str3 = miniProfileUserTagModel.backgroundColor;
        }
        String str7 = str3;
        if ((i10 & 16) != 0) {
            str4 = miniProfileUserTagModel.bubbleText;
        }
        return miniProfileUserTagModel.copy(imageModel, str5, str6, str7, str4);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.color;
    }

    @Nullable
    public final String component3() {
        return this.text;
    }

    @Nullable
    public final String component4() {
        return this.backgroundColor;
    }

    @Nullable
    public final String component5() {
        return this.bubbleText;
    }

    @NotNull
    public final MiniProfileUserTagModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new MiniProfileUserTagModel(imageModel, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniProfileUserTagModel)) {
            return false;
        }
        MiniProfileUserTagModel miniProfileUserTagModel = (MiniProfileUserTagModel) obj;
        return s.d(this.icon, miniProfileUserTagModel.icon) && s.d(this.color, miniProfileUserTagModel.color) && s.d(this.text, miniProfileUserTagModel.text) && s.d(this.backgroundColor, miniProfileUserTagModel.backgroundColor) && s.d(this.bubbleText, miniProfileUserTagModel.bubbleText);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBubbleText() {
        return this.bubbleText;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.color;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.text;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.bubbleText;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "MiniProfileUserTagModel(icon=" + ((Object) imageModel) + ", color=" + this.color + ", text=" + this.text + ", backgroundColor=" + this.backgroundColor + ", bubbleText=" + this.bubbleText + ")";
    }
}
