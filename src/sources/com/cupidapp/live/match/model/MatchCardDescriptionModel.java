package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchCardDescriptionModel implements Serializable {

    @Nullable
    private final String description;

    @NotNull
    private final ImageModel image;

    @Nullable
    private final String venue;

    public MatchCardDescriptionModel(@NotNull ImageModel image, @Nullable String str, @Nullable String str2) {
        s.i(image, "image");
        this.image = image;
        this.venue = str;
        this.description = str2;
    }

    public static /* synthetic */ MatchCardDescriptionModel copy$default(MatchCardDescriptionModel matchCardDescriptionModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = matchCardDescriptionModel.image;
        }
        if ((i10 & 2) != 0) {
            str = matchCardDescriptionModel.venue;
        }
        if ((i10 & 4) != 0) {
            str2 = matchCardDescriptionModel.description;
        }
        return matchCardDescriptionModel.copy(imageModel, str, str2);
    }

    @NotNull
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.venue;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final MatchCardDescriptionModel copy(@NotNull ImageModel image, @Nullable String str, @Nullable String str2) {
        s.i(image, "image");
        return new MatchCardDescriptionModel(image, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchCardDescriptionModel)) {
            return false;
        }
        MatchCardDescriptionModel matchCardDescriptionModel = (MatchCardDescriptionModel) obj;
        return s.d(this.image, matchCardDescriptionModel.image) && s.d(this.venue, matchCardDescriptionModel.venue) && s.d(this.description, matchCardDescriptionModel.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getVenue() {
        return this.venue;
    }

    public int hashCode() {
        int hashCode = this.image.hashCode() * 31;
        String str = this.venue;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        return "MatchCardDescriptionModel(image=" + ((Object) imageModel) + ", venue=" + this.venue + ", description=" + this.description + ")";
    }

    public /* synthetic */ MatchCardDescriptionModel(ImageModel imageModel, String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageModel, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
