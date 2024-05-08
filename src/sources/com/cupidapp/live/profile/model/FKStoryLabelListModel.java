package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelListModel implements Serializable {

    @Nullable
    private final ImageModel icon;

    @NotNull
    private final List<FKStoryLabelItemModel> labelList;

    @NotNull
    private final String title;

    public FKStoryLabelListModel(@NotNull String title, @Nullable ImageModel imageModel, @NotNull List<FKStoryLabelItemModel> labelList) {
        s.i(title, "title");
        s.i(labelList, "labelList");
        this.title = title;
        this.icon = imageModel;
        this.labelList = labelList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKStoryLabelListModel copy$default(FKStoryLabelListModel fKStoryLabelListModel, String str, ImageModel imageModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKStoryLabelListModel.title;
        }
        if ((i10 & 2) != 0) {
            imageModel = fKStoryLabelListModel.icon;
        }
        if ((i10 & 4) != 0) {
            list = fKStoryLabelListModel.labelList;
        }
        return fKStoryLabelListModel.copy(str, imageModel, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final ImageModel component2() {
        return this.icon;
    }

    @NotNull
    public final List<FKStoryLabelItemModel> component3() {
        return this.labelList;
    }

    @NotNull
    public final FKStoryLabelListModel copy(@NotNull String title, @Nullable ImageModel imageModel, @NotNull List<FKStoryLabelItemModel> labelList) {
        s.i(title, "title");
        s.i(labelList, "labelList");
        return new FKStoryLabelListModel(title, imageModel, labelList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKStoryLabelListModel)) {
            return false;
        }
        FKStoryLabelListModel fKStoryLabelListModel = (FKStoryLabelListModel) obj;
        return s.d(this.title, fKStoryLabelListModel.title) && s.d(this.icon, fKStoryLabelListModel.icon) && s.d(this.labelList, fKStoryLabelListModel.labelList);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final List<FKStoryLabelItemModel> getLabelList() {
        return this.labelList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        ImageModel imageModel = this.icon;
        return ((hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.labelList.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKStoryLabelListModel(title=" + this.title + ", icon=" + ((Object) this.icon) + ", labelList=" + ((Object) this.labelList) + ")";
    }
}
