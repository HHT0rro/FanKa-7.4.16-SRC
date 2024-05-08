package com.cupidapp.live.setting.adapter;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelTitleModel {

    @Nullable
    private final ImageModel icon;

    @NotNull
    private final String title;

    public FKStoryLabelTitleModel(@Nullable ImageModel imageModel, @NotNull String title) {
        s.i(title, "title");
        this.icon = imageModel;
        this.title = title;
    }

    public static /* synthetic */ FKStoryLabelTitleModel copy$default(FKStoryLabelTitleModel fKStoryLabelTitleModel, ImageModel imageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = fKStoryLabelTitleModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = fKStoryLabelTitleModel.title;
        }
        return fKStoryLabelTitleModel.copy(imageModel, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final FKStoryLabelTitleModel copy(@Nullable ImageModel imageModel, @NotNull String title) {
        s.i(title, "title");
        return new FKStoryLabelTitleModel(imageModel, title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKStoryLabelTitleModel)) {
            return false;
        }
        FKStoryLabelTitleModel fKStoryLabelTitleModel = (FKStoryLabelTitleModel) obj;
        return s.d(this.icon, fKStoryLabelTitleModel.icon) && s.d(this.title, fKStoryLabelTitleModel.title);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        return ((imageModel == null ? 0 : imageModel.hashCode()) * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "FKStoryLabelTitleModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ")";
    }
}
