package com.cupidapp.live.setting.model;

import androidx.annotation.DrawableRes;
import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGameModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserFunctionEntranceUiModel {

    @Nullable
    private final String entranceType;

    @Nullable
    private final ImageModel iconModel;

    @Nullable
    private final Integer iconResId;
    private final boolean mosaic;
    private final boolean redDot;

    @Nullable
    private final String remains;
    private final boolean showAvatar;

    @Nullable
    private final String title;

    @Nullable
    private final String trackName;

    @Nullable
    private final String url;

    public UserFunctionEntranceUiModel(@Nullable ImageModel imageModel, @DrawableRes @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z10, boolean z11, boolean z12, @Nullable String str5) {
        this.iconModel = imageModel;
        this.iconResId = num;
        this.title = str;
        this.url = str2;
        this.trackName = str3;
        this.remains = str4;
        this.mosaic = z10;
        this.showAvatar = z11;
        this.redDot = z12;
        this.entranceType = str5;
    }

    @Nullable
    public final String getEntranceType() {
        return this.entranceType;
    }

    @Nullable
    public final ImageModel getIconModel() {
        return this.iconModel;
    }

    @Nullable
    public final Integer getIconResId() {
        return this.iconResId;
    }

    public final boolean getMosaic() {
        return this.mosaic;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    @Nullable
    public final String getRemains() {
        return this.remains;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ UserFunctionEntranceUiModel(ImageModel imageModel, Integer num, String str, String str2, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : imageModel, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : str4, z10, z11, (i10 & 256) != 0 ? false : z12, str5);
    }
}
