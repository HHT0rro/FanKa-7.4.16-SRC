package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterResult.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PasterModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f17258id;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final ImageModel largeImage;

    @Nullable
    private final String name;

    public PasterModel(@NotNull String id2, @Nullable String str, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2) {
        s.i(id2, "id");
        this.f17258id = id2;
        this.name = str;
        this.image = imageModel;
        this.largeImage = imageModel2;
    }

    public static /* synthetic */ PasterModel copy$default(PasterModel pasterModel, String str, String str2, ImageModel imageModel, ImageModel imageModel2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pasterModel.f17258id;
        }
        if ((i10 & 2) != 0) {
            str2 = pasterModel.name;
        }
        if ((i10 & 4) != 0) {
            imageModel = pasterModel.image;
        }
        if ((i10 & 8) != 0) {
            imageModel2 = pasterModel.largeImage;
        }
        return pasterModel.copy(str, str2, imageModel, imageModel2);
    }

    @NotNull
    public final String component1() {
        return this.f17258id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final ImageModel component3() {
        return this.image;
    }

    @Nullable
    public final ImageModel component4() {
        return this.largeImage;
    }

    @NotNull
    public final PasterModel copy(@NotNull String id2, @Nullable String str, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2) {
        s.i(id2, "id");
        return new PasterModel(id2, str, imageModel, imageModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PasterModel)) {
            return false;
        }
        PasterModel pasterModel = (PasterModel) obj;
        return s.d(this.f17258id, pasterModel.f17258id) && s.d(this.name, pasterModel.name) && s.d(this.image, pasterModel.image) && s.d(this.largeImage, pasterModel.largeImage);
    }

    @NotNull
    public final String getId() {
        return this.f17258id;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final ImageModel getLargeImage() {
        return this.largeImage;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = this.f17258id.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.largeImage;
        return hashCode3 + (imageModel2 != null ? imageModel2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PasterModel(id=" + this.f17258id + ", name=" + this.name + ", image=" + ((Object) this.image) + ", largeImage=" + ((Object) this.largeImage) + ")";
    }
}
