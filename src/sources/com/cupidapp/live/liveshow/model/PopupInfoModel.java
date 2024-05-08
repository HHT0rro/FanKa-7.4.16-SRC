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
public final class PopupInfoModel implements Serializable {
    private final boolean autoPopup;

    @NotNull
    private final ImageModel icon;

    @NotNull
    private final String url;

    public PopupInfoModel(@NotNull String url, boolean z10, @NotNull ImageModel icon) {
        s.i(url, "url");
        s.i(icon, "icon");
        this.url = url;
        this.autoPopup = z10;
        this.icon = icon;
    }

    public static /* synthetic */ PopupInfoModel copy$default(PopupInfoModel popupInfoModel, String str, boolean z10, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = popupInfoModel.url;
        }
        if ((i10 & 2) != 0) {
            z10 = popupInfoModel.autoPopup;
        }
        if ((i10 & 4) != 0) {
            imageModel = popupInfoModel.icon;
        }
        return popupInfoModel.copy(str, z10, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    public final boolean component2() {
        return this.autoPopup;
    }

    @NotNull
    public final ImageModel component3() {
        return this.icon;
    }

    @NotNull
    public final PopupInfoModel copy(@NotNull String url, boolean z10, @NotNull ImageModel icon) {
        s.i(url, "url");
        s.i(icon, "icon");
        return new PopupInfoModel(url, z10, icon);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupInfoModel)) {
            return false;
        }
        PopupInfoModel popupInfoModel = (PopupInfoModel) obj;
        return s.d(this.url, popupInfoModel.url) && this.autoPopup == popupInfoModel.autoPopup && s.d(this.icon, popupInfoModel.icon);
    }

    public final boolean getAutoPopup() {
        return this.autoPopup;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        boolean z10 = this.autoPopup;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.icon.hashCode();
    }

    @NotNull
    public String toString() {
        return "PopupInfoModel(url=" + this.url + ", autoPopup=" + this.autoPopup + ", icon=" + ((Object) this.icon) + ")";
    }
}
