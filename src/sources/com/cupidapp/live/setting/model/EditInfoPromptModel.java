package com.cupidapp.live.setting.model;

import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserInfoUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditInfoPromptModel {

    @Nullable
    private final Integer infoProgress;
    private final boolean showStoryLabel;

    @Nullable
    private final List<FKStoryLabelItemModel> storyLabelList;

    public EditInfoPromptModel(@Nullable Integer num, boolean z10, @Nullable List<FKStoryLabelItemModel> list) {
        this.infoProgress = num;
        this.showStoryLabel = z10;
        this.storyLabelList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EditInfoPromptModel copy$default(EditInfoPromptModel editInfoPromptModel, Integer num, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = editInfoPromptModel.infoProgress;
        }
        if ((i10 & 2) != 0) {
            z10 = editInfoPromptModel.showStoryLabel;
        }
        if ((i10 & 4) != 0) {
            list = editInfoPromptModel.storyLabelList;
        }
        return editInfoPromptModel.copy(num, z10, list);
    }

    @Nullable
    public final Integer component1() {
        return this.infoProgress;
    }

    public final boolean component2() {
        return this.showStoryLabel;
    }

    @Nullable
    public final List<FKStoryLabelItemModel> component3() {
        return this.storyLabelList;
    }

    @NotNull
    public final EditInfoPromptModel copy(@Nullable Integer num, boolean z10, @Nullable List<FKStoryLabelItemModel> list) {
        return new EditInfoPromptModel(num, z10, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditInfoPromptModel)) {
            return false;
        }
        EditInfoPromptModel editInfoPromptModel = (EditInfoPromptModel) obj;
        return s.d(this.infoProgress, editInfoPromptModel.infoProgress) && this.showStoryLabel == editInfoPromptModel.showStoryLabel && s.d(this.storyLabelList, editInfoPromptModel.storyLabelList);
    }

    @Nullable
    public final Integer getInfoProgress() {
        return this.infoProgress;
    }

    public final boolean getShowStoryLabel() {
        return this.showStoryLabel;
    }

    @Nullable
    public final List<FKStoryLabelItemModel> getStoryLabelList() {
        return this.storyLabelList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.infoProgress;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        boolean z10 = this.showStoryLabel;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        List<FKStoryLabelItemModel> list = this.storyLabelList;
        return i11 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isNotShowEditTips() {
        Integer num = this.infoProgress;
        return num == null || (num != null && num.intValue() == 100);
    }

    @NotNull
    public String toString() {
        Integer num = this.infoProgress;
        return "EditInfoPromptModel(infoProgress=" + ((Object) num) + ", showStoryLabel=" + this.showStoryLabel + ", storyLabelList=" + ((Object) this.storyLabelList) + ")";
    }

    public /* synthetic */ EditInfoPromptModel(Integer num, boolean z10, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i10 & 2) != 0 ? false : z10, list);
    }
}
