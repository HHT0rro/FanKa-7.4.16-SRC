package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EquityModel {

    @Nullable
    private final String description;

    @Nullable
    private final String entranceType;

    @NotNull
    private final ImageModel icon;
    private final boolean redDot;

    @NotNull
    private final String title;

    @Nullable
    private final String trackName;

    @Nullable
    private final String url;

    public EquityModel(@NotNull ImageModel icon, @NotNull String title, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, @Nullable String str4) {
        s.i(icon, "icon");
        s.i(title, "title");
        this.icon = icon;
        this.title = title;
        this.trackName = str;
        this.url = str2;
        this.entranceType = str3;
        this.redDot = z10;
        this.description = str4;
    }

    public static /* synthetic */ EquityModel copy$default(EquityModel equityModel, ImageModel imageModel, String str, String str2, String str3, String str4, boolean z10, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = equityModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = equityModel.title;
        }
        String str6 = str;
        if ((i10 & 4) != 0) {
            str2 = equityModel.trackName;
        }
        String str7 = str2;
        if ((i10 & 8) != 0) {
            str3 = equityModel.url;
        }
        String str8 = str3;
        if ((i10 & 16) != 0) {
            str4 = equityModel.entranceType;
        }
        String str9 = str4;
        if ((i10 & 32) != 0) {
            z10 = equityModel.redDot;
        }
        boolean z11 = z10;
        if ((i10 & 64) != 0) {
            str5 = equityModel.description;
        }
        return equityModel.copy(imageModel, str6, str7, str8, str9, z11, str5);
    }

    @NotNull
    public final ImageModel component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.trackName;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final String component5() {
        return this.entranceType;
    }

    public final boolean component6() {
        return this.redDot;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @NotNull
    public final EquityModel copy(@NotNull ImageModel icon, @NotNull String title, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, @Nullable String str4) {
        s.i(icon, "icon");
        s.i(title, "title");
        return new EquityModel(icon, title, str, str2, str3, z10, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EquityModel)) {
            return false;
        }
        EquityModel equityModel = (EquityModel) obj;
        return s.d(this.icon, equityModel.icon) && s.d(this.title, equityModel.title) && s.d(this.trackName, equityModel.trackName) && s.d(this.url, equityModel.url) && s.d(this.entranceType, equityModel.entranceType) && this.redDot == equityModel.redDot && s.d(this.description, equityModel.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getEntranceType() {
        return this.entranceType;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    @NotNull
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.icon.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.trackName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.entranceType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z10 = this.redDot;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode4 + i10) * 31;
        String str4 = this.description;
        return i11 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "EquityModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", trackName=" + this.trackName + ", url=" + this.url + ", entranceType=" + this.entranceType + ", redDot=" + this.redDot + ", description=" + this.description + ")";
    }
}
