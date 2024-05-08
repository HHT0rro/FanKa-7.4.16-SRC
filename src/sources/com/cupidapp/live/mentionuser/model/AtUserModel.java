package com.cupidapp.live.mentionuser.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AtUserModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AtUserModel implements Serializable {

    @Nullable
    private final List<User> atList;

    @Nullable
    private final List<User> rcmdList;

    public AtUserModel(@Nullable List<User> list, @Nullable List<User> list2) {
        this.atList = list;
        this.rcmdList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AtUserModel copy$default(AtUserModel atUserModel, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = atUserModel.atList;
        }
        if ((i10 & 2) != 0) {
            list2 = atUserModel.rcmdList;
        }
        return atUserModel.copy(list, list2);
    }

    @Nullable
    public final List<User> component1() {
        return this.atList;
    }

    @Nullable
    public final List<User> component2() {
        return this.rcmdList;
    }

    @NotNull
    public final AtUserModel copy(@Nullable List<User> list, @Nullable List<User> list2) {
        return new AtUserModel(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AtUserModel)) {
            return false;
        }
        AtUserModel atUserModel = (AtUserModel) obj;
        return s.d(this.atList, atUserModel.atList) && s.d(this.rcmdList, atUserModel.rcmdList);
    }

    @Nullable
    public final List<User> getAtList() {
        return this.atList;
    }

    @Nullable
    public final List<User> getRcmdList() {
        return this.rcmdList;
    }

    public int hashCode() {
        List<User> list = this.atList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<User> list2 = this.rcmdList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AtUserModel(atList=" + ((Object) this.atList) + ", rcmdList=" + ((Object) this.rcmdList) + ")";
    }
}
