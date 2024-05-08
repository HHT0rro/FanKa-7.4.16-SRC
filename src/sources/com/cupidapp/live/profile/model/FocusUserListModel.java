package com.cupidapp.live.profile.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FocusUserListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FocusUserListModel {

    @Nullable
    private final List<User> list;

    @Nullable
    private final List<User> rcmdList;

    public FocusUserListModel(@Nullable List<User> list, @Nullable List<User> list2) {
        this.list = list;
        this.rcmdList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FocusUserListModel copy$default(FocusUserListModel focusUserListModel, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = focusUserListModel.list;
        }
        if ((i10 & 2) != 0) {
            list2 = focusUserListModel.rcmdList;
        }
        return focusUserListModel.copy(list, list2);
    }

    @Nullable
    public final List<User> component1() {
        return this.list;
    }

    @Nullable
    public final List<User> component2() {
        return this.rcmdList;
    }

    @NotNull
    public final FocusUserListModel copy(@Nullable List<User> list, @Nullable List<User> list2) {
        return new FocusUserListModel(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FocusUserListModel)) {
            return false;
        }
        FocusUserListModel focusUserListModel = (FocusUserListModel) obj;
        return s.d(this.list, focusUserListModel.list) && s.d(this.rcmdList, focusUserListModel.rcmdList);
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final List<User> getRcmdList() {
        return this.rcmdList;
    }

    public int hashCode() {
        List<User> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<User> list2 = this.rcmdList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FocusUserListModel(list=" + ((Object) this.list) + ", rcmdList=" + ((Object) this.rcmdList) + ")";
    }
}
