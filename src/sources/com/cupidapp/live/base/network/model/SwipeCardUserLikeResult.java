package com.cupidapp.live.base.network.model;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.profile.model.User;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SwipeCardUserLikeResult {

    @Nullable
    private final AlohaOrNopeGuideModel alohaOrNopeGuide;

    @Nullable
    private final Integer alohaOrNopeResidueNum;

    @Nullable
    private final DailyLikeGuideModel dailyLikePopInfo;
    private final boolean jumpDailyLike;

    @Nullable
    private final Boolean newUserCompleteFlag;

    @Nullable
    private final Map<String, Object> recommendContext;

    @NotNull
    private final User user;

    @Nullable
    private final AppDialogModel window;

    public SwipeCardUserLikeResult(@NotNull User user, @Nullable AppDialogModel appDialogModel, @Nullable Boolean bool, @Nullable Map<String, ? extends Object> map, boolean z10, @Nullable DailyLikeGuideModel dailyLikeGuideModel, @Nullable Integer num, @Nullable AlohaOrNopeGuideModel alohaOrNopeGuideModel) {
        s.i(user, "user");
        this.user = user;
        this.window = appDialogModel;
        this.newUserCompleteFlag = bool;
        this.recommendContext = map;
        this.jumpDailyLike = z10;
        this.dailyLikePopInfo = dailyLikeGuideModel;
        this.alohaOrNopeResidueNum = num;
        this.alohaOrNopeGuide = alohaOrNopeGuideModel;
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final AppDialogModel component2() {
        return this.window;
    }

    @Nullable
    public final Boolean component3() {
        return this.newUserCompleteFlag;
    }

    @Nullable
    public final Map<String, Object> component4() {
        return this.recommendContext;
    }

    public final boolean component5() {
        return this.jumpDailyLike;
    }

    @Nullable
    public final DailyLikeGuideModel component6() {
        return this.dailyLikePopInfo;
    }

    @Nullable
    public final Integer component7() {
        return this.alohaOrNopeResidueNum;
    }

    @Nullable
    public final AlohaOrNopeGuideModel component8() {
        return this.alohaOrNopeGuide;
    }

    @NotNull
    public final SwipeCardUserLikeResult copy(@NotNull User user, @Nullable AppDialogModel appDialogModel, @Nullable Boolean bool, @Nullable Map<String, ? extends Object> map, boolean z10, @Nullable DailyLikeGuideModel dailyLikeGuideModel, @Nullable Integer num, @Nullable AlohaOrNopeGuideModel alohaOrNopeGuideModel) {
        s.i(user, "user");
        return new SwipeCardUserLikeResult(user, appDialogModel, bool, map, z10, dailyLikeGuideModel, num, alohaOrNopeGuideModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwipeCardUserLikeResult)) {
            return false;
        }
        SwipeCardUserLikeResult swipeCardUserLikeResult = (SwipeCardUserLikeResult) obj;
        return s.d(this.user, swipeCardUserLikeResult.user) && s.d(this.window, swipeCardUserLikeResult.window) && s.d(this.newUserCompleteFlag, swipeCardUserLikeResult.newUserCompleteFlag) && s.d(this.recommendContext, swipeCardUserLikeResult.recommendContext) && this.jumpDailyLike == swipeCardUserLikeResult.jumpDailyLike && s.d(this.dailyLikePopInfo, swipeCardUserLikeResult.dailyLikePopInfo) && s.d(this.alohaOrNopeResidueNum, swipeCardUserLikeResult.alohaOrNopeResidueNum) && s.d(this.alohaOrNopeGuide, swipeCardUserLikeResult.alohaOrNopeGuide);
    }

    @Nullable
    public final AlohaOrNopeGuideModel getAlohaOrNopeGuide() {
        return this.alohaOrNopeGuide;
    }

    @Nullable
    public final Integer getAlohaOrNopeResidueNum() {
        return this.alohaOrNopeResidueNum;
    }

    @Nullable
    public final DailyLikeGuideModel getDailyLikePopInfo() {
        return this.dailyLikePopInfo;
    }

    public final boolean getJumpDailyLike() {
        return this.jumpDailyLike;
    }

    @Nullable
    public final Boolean getNewUserCompleteFlag() {
        return this.newUserCompleteFlag;
    }

    @Nullable
    public final Map<String, Object> getRecommendContext() {
        return this.recommendContext;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final AppDialogModel getWindow() {
        return this.window;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        AppDialogModel appDialogModel = this.window;
        int hashCode2 = (hashCode + (appDialogModel == null ? 0 : appDialogModel.hashCode())) * 31;
        Boolean bool = this.newUserCompleteFlag;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Map<String, Object> map = this.recommendContext;
        int hashCode4 = (hashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        boolean z10 = this.jumpDailyLike;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode4 + i10) * 31;
        DailyLikeGuideModel dailyLikeGuideModel = this.dailyLikePopInfo;
        int hashCode5 = (i11 + (dailyLikeGuideModel == null ? 0 : dailyLikeGuideModel.hashCode())) * 31;
        Integer num = this.alohaOrNopeResidueNum;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        AlohaOrNopeGuideModel alohaOrNopeGuideModel = this.alohaOrNopeGuide;
        return hashCode6 + (alohaOrNopeGuideModel != null ? alohaOrNopeGuideModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        AppDialogModel appDialogModel = this.window;
        Boolean bool = this.newUserCompleteFlag;
        Map<String, Object> map = this.recommendContext;
        return "SwipeCardUserLikeResult(user=" + ((Object) user) + ", window=" + ((Object) appDialogModel) + ", newUserCompleteFlag=" + ((Object) bool) + ", recommendContext=" + ((Object) map) + ", jumpDailyLike=" + this.jumpDailyLike + ", dailyLikePopInfo=" + ((Object) this.dailyLikePopInfo) + ", alohaOrNopeResidueNum=" + ((Object) this.alohaOrNopeResidueNum) + ", alohaOrNopeGuide=" + ((Object) this.alohaOrNopeGuide) + ")";
    }

    public /* synthetic */ SwipeCardUserLikeResult(User user, AppDialogModel appDialogModel, Boolean bool, Map map, boolean z10, DailyLikeGuideModel dailyLikeGuideModel, Integer num, AlohaOrNopeGuideModel alohaOrNopeGuideModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, appDialogModel, bool, map, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? null : dailyLikeGuideModel, num, alohaOrNopeGuideModel);
    }
}
