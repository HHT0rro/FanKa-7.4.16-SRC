package com.cupidapp.live.visitors.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CornerMarkModel {

    @Nullable
    private final String cornerImgUrlDesc;

    @Nullable
    private final ImageModel offerImg;

    public CornerMarkModel(@Nullable String str, @Nullable ImageModel imageModel) {
        this.cornerImgUrlDesc = str;
        this.offerImg = imageModel;
    }

    public static /* synthetic */ CornerMarkModel copy$default(CornerMarkModel cornerMarkModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cornerMarkModel.cornerImgUrlDesc;
        }
        if ((i10 & 2) != 0) {
            imageModel = cornerMarkModel.offerImg;
        }
        return cornerMarkModel.copy(str, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.cornerImgUrlDesc;
    }

    @Nullable
    public final ImageModel component2() {
        return this.offerImg;
    }

    @NotNull
    public final CornerMarkModel copy(@Nullable String str, @Nullable ImageModel imageModel) {
        return new CornerMarkModel(str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CornerMarkModel)) {
            return false;
        }
        CornerMarkModel cornerMarkModel = (CornerMarkModel) obj;
        return s.d(this.cornerImgUrlDesc, cornerMarkModel.cornerImgUrlDesc) && s.d(this.offerImg, cornerMarkModel.offerImg);
    }

    @Nullable
    public final String getCornerImgUrlDesc() {
        return this.cornerImgUrlDesc;
    }

    @Nullable
    public final ImageModel getOfferImg() {
        return this.offerImg;
    }

    public int hashCode() {
        String str = this.cornerImgUrlDesc;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.offerImg;
        return hashCode + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CornerMarkModel(cornerImgUrlDesc=" + this.cornerImgUrlDesc + ", offerImg=" + ((Object) this.offerImg) + ")";
    }
}
