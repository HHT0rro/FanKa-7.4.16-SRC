package com.cupidapp.live.liveshow.pk.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkRankModel {

    @Nullable
    private final String credit;

    @Nullable
    private final Integer diamond;

    @Nullable
    private final List<User> list;

    @NotNull
    private final String liveShowId;

    @Nullable
    private final Integer sort;

    public MultiPkRankModel(@NotNull String liveShowId, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable List<User> list) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.credit = str;
        this.diamond = num;
        this.sort = num2;
        this.list = list;
    }

    public static /* synthetic */ MultiPkRankModel copy$default(MultiPkRankModel multiPkRankModel, String str, String str2, Integer num, Integer num2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkRankModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            str2 = multiPkRankModel.credit;
        }
        String str3 = str2;
        if ((i10 & 4) != 0) {
            num = multiPkRankModel.diamond;
        }
        Integer num3 = num;
        if ((i10 & 8) != 0) {
            num2 = multiPkRankModel.sort;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            list = multiPkRankModel.list;
        }
        return multiPkRankModel.copy(str, str3, num3, num4, list);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @Nullable
    public final String component2() {
        return this.credit;
    }

    @Nullable
    public final Integer component3() {
        return this.diamond;
    }

    @Nullable
    public final Integer component4() {
        return this.sort;
    }

    @Nullable
    public final List<User> component5() {
        return this.list;
    }

    @NotNull
    public final MultiPkRankModel copy(@NotNull String liveShowId, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable List<User> list) {
        s.i(liveShowId, "liveShowId");
        return new MultiPkRankModel(liveShowId, str, num, num2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkRankModel)) {
            return false;
        }
        MultiPkRankModel multiPkRankModel = (MultiPkRankModel) obj;
        return s.d(this.liveShowId, multiPkRankModel.liveShowId) && s.d(this.credit, multiPkRankModel.credit) && s.d(this.diamond, multiPkRankModel.diamond) && s.d(this.sort, multiPkRankModel.sort) && s.d(this.list, multiPkRankModel.list);
    }

    @Nullable
    public final String getCredit() {
        return this.credit;
    }

    @Nullable
    public final Integer getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final Integer getSort() {
        return this.sort;
    }

    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        String str = this.credit;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.diamond;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sort;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<User> list = this.list;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MultiPkRankModel(liveShowId=" + this.liveShowId + ", credit=" + this.credit + ", diamond=" + ((Object) this.diamond) + ", sort=" + ((Object) this.sort) + ", list=" + ((Object) this.list) + ")";
    }
}
