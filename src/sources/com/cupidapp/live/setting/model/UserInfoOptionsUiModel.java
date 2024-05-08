package com.cupidapp.live.setting.model;

import androidx.annotation.DrawableRes;
import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGameModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserInfoOptionsUiModel {

    @Nullable
    private final Function0<p> action;

    @Nullable
    private final String content;

    @Nullable
    private ImageModel descriptionImage;

    @Nullable
    private String descriptionText;

    @Nullable
    private final String entranceType;

    @Nullable
    private final ImageModel iconModel;

    @Nullable
    private final Integer iconResId;

    @Nullable
    private final Boolean redDot;

    @Nullable
    private final String remains;

    @Nullable
    private final String title;

    @Nullable
    private final String trackName;

    @Nullable
    private final String url;

    public UserInfoOptionsUiModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public UserInfoOptionsUiModel(@Nullable ImageModel imageModel, @DrawableRes @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel2, @Nullable Boolean bool, @Nullable String str4, @Nullable Function0<p> function0, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.iconModel = imageModel;
        this.iconResId = num;
        this.title = str;
        this.content = str2;
        this.descriptionText = str3;
        this.descriptionImage = imageModel2;
        this.redDot = bool;
        this.url = str4;
        this.action = function0;
        this.entranceType = str5;
        this.trackName = str6;
        this.remains = str7;
    }

    @Nullable
    public final Function0<p> getAction() {
        return this.action;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ImageModel getDescriptionImage() {
        return this.descriptionImage;
    }

    @Nullable
    public final String getDescriptionText() {
        return this.descriptionText;
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

    @Nullable
    public final Boolean getRedDot() {
        return this.redDot;
    }

    @Nullable
    public final String getRemains() {
        return this.remains;
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

    public final void setDescriptionImage(@Nullable ImageModel imageModel) {
        this.descriptionImage = imageModel;
    }

    public final void setDescriptionText(@Nullable String str) {
        this.descriptionText = str;
    }

    public /* synthetic */ UserInfoOptionsUiModel(ImageModel imageModel, Integer num, String str, String str2, String str3, ImageModel imageModel2, Boolean bool, String str4, Function0 function0, String str5, String str6, String str7, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : imageModel, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : imageModel2, (i10 & 64) != 0 ? Boolean.FALSE : bool, (i10 & 128) != 0 ? null : str4, (i10 & 256) != 0 ? null : function0, (i10 & 512) != 0 ? null : str5, (i10 & 1024) != 0 ? null : str6, (i10 & 2048) == 0 ? str7 : null);
    }
}
