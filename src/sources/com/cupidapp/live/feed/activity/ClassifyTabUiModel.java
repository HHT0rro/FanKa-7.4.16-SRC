package com.cupidapp.live.feed.activity;

import com.cupidapp.live.base.view.FKTitleViewModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyDetailListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClassifyTabUiModel {

    @Nullable
    private final List<String> tabIds;

    @Nullable
    private final List<FKTitleViewModel> tabs;

    public ClassifyTabUiModel(@Nullable List<FKTitleViewModel> list, @Nullable List<String> list2) {
        this.tabs = list;
        this.tabIds = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClassifyTabUiModel copy$default(ClassifyTabUiModel classifyTabUiModel, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = classifyTabUiModel.tabs;
        }
        if ((i10 & 2) != 0) {
            list2 = classifyTabUiModel.tabIds;
        }
        return classifyTabUiModel.copy(list, list2);
    }

    @Nullable
    public final List<FKTitleViewModel> component1() {
        return this.tabs;
    }

    @Nullable
    public final List<String> component2() {
        return this.tabIds;
    }

    @NotNull
    public final ClassifyTabUiModel copy(@Nullable List<FKTitleViewModel> list, @Nullable List<String> list2) {
        return new ClassifyTabUiModel(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassifyTabUiModel)) {
            return false;
        }
        ClassifyTabUiModel classifyTabUiModel = (ClassifyTabUiModel) obj;
        return kotlin.jvm.internal.s.d(this.tabs, classifyTabUiModel.tabs) && kotlin.jvm.internal.s.d(this.tabIds, classifyTabUiModel.tabIds);
    }

    @Nullable
    public final List<String> getTabIds() {
        return this.tabIds;
    }

    @Nullable
    public final List<FKTitleViewModel> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        List<FKTitleViewModel> list = this.tabs;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.tabIds;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClassifyTabUiModel(tabs=" + ((Object) this.tabs) + ", tabIds=" + ((Object) this.tabIds) + ")";
    }
}
