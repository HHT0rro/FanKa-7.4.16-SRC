package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkRankModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkResultModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkAnchorInfoModel implements Serializable {

    @Nullable
    private final String credit;

    @Nullable
    private final Integer diamond;

    @Nullable
    private final List<User> list;

    @NotNull
    private final String liveShowId;

    @Nullable
    private final String pkResult;
    private final boolean showBorder;

    @Nullable
    private final Integer sort;

    @NotNull
    private final String streamId;

    @NotNull
    private final User user;

    public MultiPkAnchorInfoModel(@NotNull String liveShowId, @NotNull String streamId, @NotNull User user, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, boolean z10, @Nullable List<User> list, @Nullable String str2) {
        s.i(liveShowId, "liveShowId");
        s.i(streamId, "streamId");
        s.i(user, "user");
        this.liveShowId = liveShowId;
        this.streamId = streamId;
        this.user = user;
        this.diamond = num;
        this.credit = str;
        this.sort = num2;
        this.showBorder = z10;
        this.list = list;
        this.pkResult = str2;
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @NotNull
    public final String component2() {
        return this.streamId;
    }

    @NotNull
    public final User component3() {
        return this.user;
    }

    @Nullable
    public final Integer component4() {
        return this.diamond;
    }

    @Nullable
    public final String component5() {
        return this.credit;
    }

    @Nullable
    public final Integer component6() {
        return this.sort;
    }

    public final boolean component7() {
        return this.showBorder;
    }

    @Nullable
    public final List<User> component8() {
        return this.list;
    }

    @Nullable
    public final String component9() {
        return this.pkResult;
    }

    @NotNull
    public final MultiPkAnchorInfoModel copy(@NotNull String liveShowId, @NotNull String streamId, @NotNull User user, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, boolean z10, @Nullable List<User> list, @Nullable String str2) {
        s.i(liveShowId, "liveShowId");
        s.i(streamId, "streamId");
        s.i(user, "user");
        return new MultiPkAnchorInfoModel(liveShowId, streamId, user, num, str, num2, z10, list, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkAnchorInfoModel)) {
            return false;
        }
        MultiPkAnchorInfoModel multiPkAnchorInfoModel = (MultiPkAnchorInfoModel) obj;
        return s.d(this.liveShowId, multiPkAnchorInfoModel.liveShowId) && s.d(this.streamId, multiPkAnchorInfoModel.streamId) && s.d(this.user, multiPkAnchorInfoModel.user) && s.d(this.diamond, multiPkAnchorInfoModel.diamond) && s.d(this.credit, multiPkAnchorInfoModel.credit) && s.d(this.sort, multiPkAnchorInfoModel.sort) && this.showBorder == multiPkAnchorInfoModel.showBorder && s.d(this.list, multiPkAnchorInfoModel.list) && s.d(this.pkResult, multiPkAnchorInfoModel.pkResult);
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

    @NotNull
    public final MultiPkAnchorModel getMultiPkAnchorModel() {
        MultiPkAnchorModel multiPkAnchorModel = new MultiPkAnchorModel(this.liveShowId, this.user, null, 4, null);
        multiPkAnchorModel.setPkStreamId(this.streamId);
        return multiPkAnchorModel;
    }

    @NotNull
    public final MultiPkRankModel getMultiPkRankModel() {
        return new MultiPkRankModel(this.liveShowId, this.credit, this.diamond, this.sort, this.list);
    }

    @NotNull
    public final MultiPkResultModel getMultiPkResultModel() {
        return new MultiPkResultModel(this.liveShowId, this.pkResult);
    }

    @Nullable
    public final String getPkResult() {
        return this.pkResult;
    }

    public final boolean getShowBorder() {
        return this.showBorder;
    }

    @Nullable
    public final Integer getSort() {
        return this.sort;
    }

    @NotNull
    public final String getStreamId() {
        return this.streamId;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.liveShowId.hashCode() * 31) + this.streamId.hashCode()) * 31) + this.user.hashCode()) * 31;
        Integer num = this.diamond;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.credit;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.sort;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        boolean z10 = this.showBorder;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode4 + i10) * 31;
        List<User> list = this.list;
        int hashCode5 = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.pkResult;
        return hashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.liveShowId;
        String str2 = this.streamId;
        User user = this.user;
        Integer num = this.diamond;
        String str3 = this.credit;
        Integer num2 = this.sort;
        boolean z10 = this.showBorder;
        List<User> list = this.list;
        return "MultiPkAnchorInfoModel(liveShowId=" + str + ", streamId=" + str2 + ", user=" + ((Object) user) + ", diamond=" + ((Object) num) + ", credit=" + str3 + ", sort=" + ((Object) num2) + ", showBorder=" + z10 + ", list=" + ((Object) list) + ", pkResult=" + this.pkResult + ")";
    }
}
