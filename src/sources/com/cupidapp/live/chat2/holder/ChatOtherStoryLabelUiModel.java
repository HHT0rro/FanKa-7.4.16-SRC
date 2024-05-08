package com.cupidapp.live.chat2.holder;

import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatOtherStoryLabelViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatOtherStoryLabelUiModel {

    @Nullable
    private final Boolean canEdit;

    @Nullable
    private final Boolean insertTop;

    @Nullable
    private final FKStoryLabelItemModel storyLabel;

    public ChatOtherStoryLabelUiModel(@Nullable FKStoryLabelItemModel fKStoryLabelItemModel, @Nullable Boolean bool, @Nullable Boolean bool2) {
        this.storyLabel = fKStoryLabelItemModel;
        this.canEdit = bool;
        this.insertTop = bool2;
    }

    public static /* synthetic */ ChatOtherStoryLabelUiModel copy$default(ChatOtherStoryLabelUiModel chatOtherStoryLabelUiModel, FKStoryLabelItemModel fKStoryLabelItemModel, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKStoryLabelItemModel = chatOtherStoryLabelUiModel.storyLabel;
        }
        if ((i10 & 2) != 0) {
            bool = chatOtherStoryLabelUiModel.canEdit;
        }
        if ((i10 & 4) != 0) {
            bool2 = chatOtherStoryLabelUiModel.insertTop;
        }
        return chatOtherStoryLabelUiModel.copy(fKStoryLabelItemModel, bool, bool2);
    }

    @Nullable
    public final FKStoryLabelItemModel component1() {
        return this.storyLabel;
    }

    @Nullable
    public final Boolean component2() {
        return this.canEdit;
    }

    @Nullable
    public final Boolean component3() {
        return this.insertTop;
    }

    @NotNull
    public final ChatOtherStoryLabelUiModel copy(@Nullable FKStoryLabelItemModel fKStoryLabelItemModel, @Nullable Boolean bool, @Nullable Boolean bool2) {
        return new ChatOtherStoryLabelUiModel(fKStoryLabelItemModel, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatOtherStoryLabelUiModel)) {
            return false;
        }
        ChatOtherStoryLabelUiModel chatOtherStoryLabelUiModel = (ChatOtherStoryLabelUiModel) obj;
        return s.d(this.storyLabel, chatOtherStoryLabelUiModel.storyLabel) && s.d(this.canEdit, chatOtherStoryLabelUiModel.canEdit) && s.d(this.insertTop, chatOtherStoryLabelUiModel.insertTop);
    }

    @Nullable
    public final Boolean getCanEdit() {
        return this.canEdit;
    }

    @Nullable
    public final Boolean getInsertTop() {
        return this.insertTop;
    }

    @Nullable
    public final FKStoryLabelItemModel getStoryLabel() {
        return this.storyLabel;
    }

    public int hashCode() {
        FKStoryLabelItemModel fKStoryLabelItemModel = this.storyLabel;
        int hashCode = (fKStoryLabelItemModel == null ? 0 : fKStoryLabelItemModel.hashCode()) * 31;
        Boolean bool = this.canEdit;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.insertTop;
        return hashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ChatOtherStoryLabelUiModel(storyLabel=" + ((Object) this.storyLabel) + ", canEdit=" + ((Object) this.canEdit) + ", insertTop=" + ((Object) this.insertTop) + ")";
    }
}
