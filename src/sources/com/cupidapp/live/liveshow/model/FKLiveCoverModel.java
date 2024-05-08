package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCoverModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCoverModel {

    @Nullable
    private final ImageModel cover;

    @Nullable
    private final Boolean hasUpload;

    @Nullable
    private final String title;

    public FKLiveCoverModel(@Nullable ImageModel imageModel, @Nullable Boolean bool, @Nullable String str) {
        this.cover = imageModel;
        this.hasUpload = bool;
        this.title = str;
    }

    public static /* synthetic */ FKLiveCoverModel copy$default(FKLiveCoverModel fKLiveCoverModel, ImageModel imageModel, Boolean bool, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = fKLiveCoverModel.cover;
        }
        if ((i10 & 2) != 0) {
            bool = fKLiveCoverModel.hasUpload;
        }
        if ((i10 & 4) != 0) {
            str = fKLiveCoverModel.title;
        }
        return fKLiveCoverModel.copy(imageModel, bool, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.cover;
    }

    @Nullable
    public final Boolean component2() {
        return this.hasUpload;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final FKLiveCoverModel copy(@Nullable ImageModel imageModel, @Nullable Boolean bool, @Nullable String str) {
        return new FKLiveCoverModel(imageModel, bool, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveCoverModel)) {
            return false;
        }
        FKLiveCoverModel fKLiveCoverModel = (FKLiveCoverModel) obj;
        return s.d(this.cover, fKLiveCoverModel.cover) && s.d(this.hasUpload, fKLiveCoverModel.hasUpload) && s.d(this.title, fKLiveCoverModel.title);
    }

    @Nullable
    public final ImageModel getCover() {
        return this.cover;
    }

    @Nullable
    public final Boolean getHasUpload() {
        return this.hasUpload;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ImageModel imageModel = this.cover;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        Boolean bool = this.hasUpload;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.title;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.cover;
        Boolean bool = this.hasUpload;
        return "FKLiveCoverModel(cover=" + ((Object) imageModel) + ", hasUpload=" + ((Object) bool) + ", title=" + this.title + ")";
    }
}
