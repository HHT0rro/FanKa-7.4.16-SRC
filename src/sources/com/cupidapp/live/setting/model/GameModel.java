package com.cupidapp.live.setting.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGameModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GameModel implements Serializable {

    @Nullable
    private final String description;

    @Nullable
    private final String entranceType;

    @Nullable
    private final ImageModel icon;
    private final boolean mosaic;

    @Nullable
    private final Boolean redDot;

    @Nullable
    private final String remains;
    private final boolean showAvatar;

    @Nullable
    private final String title;

    @Nullable
    private final String trackName;

    @Nullable
    private final String url;

    public GameModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, boolean z10, boolean z11, @Nullable String str6) {
        this.description = str;
        this.icon = imageModel;
        this.title = str2;
        this.url = str3;
        this.redDot = bool;
        this.trackName = str4;
        this.remains = str5;
        this.mosaic = z10;
        this.showAvatar = z11;
        this.entranceType = str6;
    }

    @Nullable
    public final String component1() {
        return this.description;
    }

    @Nullable
    public final String component10() {
        return this.entranceType;
    }

    @Nullable
    public final ImageModel component2() {
        return this.icon;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final Boolean component5() {
        return this.redDot;
    }

    @Nullable
    public final String component6() {
        return this.trackName;
    }

    @Nullable
    public final String component7() {
        return this.remains;
    }

    public final boolean component8() {
        return this.mosaic;
    }

    public final boolean component9() {
        return this.showAvatar;
    }

    @NotNull
    public final GameModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, boolean z10, boolean z11, @Nullable String str6) {
        return new GameModel(str, imageModel, str2, str3, bool, str4, str5, z10, z11, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameModel)) {
            return false;
        }
        GameModel gameModel = (GameModel) obj;
        return s.d(this.description, gameModel.description) && s.d(this.icon, gameModel.icon) && s.d(this.title, gameModel.title) && s.d(this.url, gameModel.url) && s.d(this.redDot, gameModel.redDot) && s.d(this.trackName, gameModel.trackName) && s.d(this.remains, gameModel.remains) && this.mosaic == gameModel.mosaic && this.showAvatar == gameModel.showAvatar && s.d(this.entranceType, gameModel.entranceType);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getEntranceType() {
        return this.entranceType;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    public final boolean getMosaic() {
        return this.mosaic;
    }

    @Nullable
    public final Boolean getRedDot() {
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.description;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.icon;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.redDot;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.trackName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.remains;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z10 = this.mosaic;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode7 + i10) * 31;
        boolean z11 = this.showAvatar;
        int i12 = (i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str6 = this.entranceType;
        return i12 + (str6 != null ? str6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.description;
        ImageModel imageModel = this.icon;
        String str2 = this.title;
        String str3 = this.url;
        Boolean bool = this.redDot;
        return "GameModel(description=" + str + ", icon=" + ((Object) imageModel) + ", title=" + str2 + ", url=" + str3 + ", redDot=" + ((Object) bool) + ", trackName=" + this.trackName + ", remains=" + this.remains + ", mosaic=" + this.mosaic + ", showAvatar=" + this.showAvatar + ", entranceType=" + this.entranceType + ")";
    }

    public /* synthetic */ GameModel(String str, ImageModel imageModel, String str2, String str3, Boolean bool, String str4, String str5, boolean z10, boolean z11, String str6, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageModel, str2, str3, (i10 & 16) != 0 ? Boolean.FALSE : bool, (i10 & 32) != 0 ? null : str4, (i10 & 64) != 0 ? null : str5, z10, z11, str6);
    }
}
