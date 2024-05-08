package com.cupidapp.live.profile.holder;

import com.cupidapp.live.club.model.ClubMedalModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserClubMedalViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MedalListModel {

    @NotNull
    private final List<ClubMedalModel> list;

    public MedalListModel(@NotNull List<ClubMedalModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MedalListModel copy$default(MedalListModel medalListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = medalListModel.list;
        }
        return medalListModel.copy(list);
    }

    @NotNull
    public final List<ClubMedalModel> component1() {
        return this.list;
    }

    @NotNull
    public final MedalListModel copy(@NotNull List<ClubMedalModel> list) {
        s.i(list, "list");
        return new MedalListModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MedalListModel) && s.d(this.list, ((MedalListModel) obj).list);
    }

    @NotNull
    public final List<ClubMedalModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "MedalListModel(list=" + ((Object) this.list) + ")";
    }
}
