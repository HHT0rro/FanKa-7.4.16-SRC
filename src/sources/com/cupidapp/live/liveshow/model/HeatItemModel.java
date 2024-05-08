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
public final class HeatItemModel implements Serializable {

    @NotNull
    private final String desc;

    @Nullable
    private final ImageModel image;

    @NotNull
    private final String title;

    public HeatItemModel(@NotNull String desc, @NotNull String title, @Nullable ImageModel imageModel) {
        s.i(desc, "desc");
        s.i(title, "title");
        this.desc = desc;
        this.title = title;
        this.image = imageModel;
    }

    public static /* synthetic */ HeatItemModel copy$default(HeatItemModel heatItemModel, String str, String str2, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = heatItemModel.desc;
        }
        if ((i10 & 2) != 0) {
            str2 = heatItemModel.title;
        }
        if ((i10 & 4) != 0) {
            imageModel = heatItemModel.image;
        }
        return heatItemModel.copy(str, str2, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.desc;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final ImageModel component3() {
        return this.image;
    }

    @NotNull
    public final HeatItemModel copy(@NotNull String desc, @NotNull String title, @Nullable ImageModel imageModel) {
        s.i(desc, "desc");
        s.i(title, "title");
        return new HeatItemModel(desc, title, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeatItemModel)) {
            return false;
        }
        HeatItemModel heatItemModel = (HeatItemModel) obj;
        return s.d(this.desc, heatItemModel.desc) && s.d(this.title, heatItemModel.title) && s.d(this.image, heatItemModel.image);
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.desc.hashCode() * 31) + this.title.hashCode()) * 31;
        ImageModel imageModel = this.image;
        return hashCode + (imageModel == null ? 0 : imageModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "HeatItemModel(desc=" + this.desc + ", title=" + this.title + ", image=" + ((Object) this.image) + ")";
    }
}
