package com.cupidapp.live.chat.service;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubEntranceModel {

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String welcomePageUrl;

    public ClubEntranceModel(@Nullable String str, @Nullable ImageModel imageModel) {
        this.welcomePageUrl = str;
        this.icon = imageModel;
    }

    public static /* synthetic */ ClubEntranceModel copy$default(ClubEntranceModel clubEntranceModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubEntranceModel.welcomePageUrl;
        }
        if ((i10 & 2) != 0) {
            imageModel = clubEntranceModel.icon;
        }
        return clubEntranceModel.copy(str, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.welcomePageUrl;
    }

    @Nullable
    public final ImageModel component2() {
        return this.icon;
    }

    @NotNull
    public final ClubEntranceModel copy(@Nullable String str, @Nullable ImageModel imageModel) {
        return new ClubEntranceModel(str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubEntranceModel)) {
            return false;
        }
        ClubEntranceModel clubEntranceModel = (ClubEntranceModel) obj;
        return s.d(this.welcomePageUrl, clubEntranceModel.welcomePageUrl) && s.d(this.icon, clubEntranceModel.icon);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getWelcomePageUrl() {
        return this.welcomePageUrl;
    }

    public int hashCode() {
        String str = this.welcomePageUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.icon;
        return hashCode + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClubEntranceModel(welcomePageUrl=" + this.welcomePageUrl + ", icon=" + ((Object) this.icon) + ")";
    }
}
