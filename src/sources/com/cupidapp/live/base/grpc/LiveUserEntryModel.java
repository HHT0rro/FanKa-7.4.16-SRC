package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveUserEntryModel {

    @Nullable
    private final String animation;

    @Nullable
    private final String background;

    @Nullable
    private final String decoration;

    @NotNull
    private final String direction;

    @Nullable
    private final List<BaseLiveShowTagModel> enterAnimationLabels;

    @Nullable
    private final List<BaseLiveShowTagModel> enterDecorationLabels;

    @Nullable
    private final String enterText;

    @Nullable
    private final List<BaseLiveShowTagModel> floatDecorationLabels;

    @Nullable
    private final String message;

    @Nullable
    private final String relationshipType;

    @Nullable
    private final String textColor;

    @Nullable
    private final List<BaseLiveShowTagModel> textEnterLabels;

    @NotNull
    private final String user;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveUserEntryModel(@NotNull String user, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull String direction, @Nullable String str7, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable List<? extends BaseLiveShowTagModel> list2, @Nullable List<? extends BaseLiveShowTagModel> list3, @Nullable List<? extends BaseLiveShowTagModel> list4) {
        kotlin.jvm.internal.s.i(user, "user");
        kotlin.jvm.internal.s.i(direction, "direction");
        this.user = user;
        this.message = str;
        this.relationshipType = str2;
        this.decoration = str3;
        this.textColor = str4;
        this.background = str5;
        this.animation = str6;
        this.direction = direction;
        this.enterText = str7;
        this.textEnterLabels = list;
        this.floatDecorationLabels = list2;
        this.enterAnimationLabels = list3;
        this.enterDecorationLabels = list4;
    }

    private final String component8() {
        return this.direction;
    }

    @NotNull
    public final String component1() {
        return this.user;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component10() {
        return this.textEnterLabels;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component11() {
        return this.floatDecorationLabels;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component12() {
        return this.enterAnimationLabels;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component13() {
        return this.enterDecorationLabels;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final String component3() {
        return this.relationshipType;
    }

    @Nullable
    public final String component4() {
        return this.decoration;
    }

    @Nullable
    public final String component5() {
        return this.textColor;
    }

    @Nullable
    public final String component6() {
        return this.background;
    }

    @Nullable
    public final String component7() {
        return this.animation;
    }

    @Nullable
    public final String component9() {
        return this.enterText;
    }

    @NotNull
    public final LiveUserEntryModel copy(@NotNull String user, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull String direction, @Nullable String str7, @Nullable List<? extends BaseLiveShowTagModel> list, @Nullable List<? extends BaseLiveShowTagModel> list2, @Nullable List<? extends BaseLiveShowTagModel> list3, @Nullable List<? extends BaseLiveShowTagModel> list4) {
        kotlin.jvm.internal.s.i(user, "user");
        kotlin.jvm.internal.s.i(direction, "direction");
        return new LiveUserEntryModel(user, str, str2, str3, str4, str5, str6, direction, str7, list, list2, list3, list4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveUserEntryModel)) {
            return false;
        }
        LiveUserEntryModel liveUserEntryModel = (LiveUserEntryModel) obj;
        return kotlin.jvm.internal.s.d(this.user, liveUserEntryModel.user) && kotlin.jvm.internal.s.d(this.message, liveUserEntryModel.message) && kotlin.jvm.internal.s.d(this.relationshipType, liveUserEntryModel.relationshipType) && kotlin.jvm.internal.s.d(this.decoration, liveUserEntryModel.decoration) && kotlin.jvm.internal.s.d(this.textColor, liveUserEntryModel.textColor) && kotlin.jvm.internal.s.d(this.background, liveUserEntryModel.background) && kotlin.jvm.internal.s.d(this.animation, liveUserEntryModel.animation) && kotlin.jvm.internal.s.d(this.direction, liveUserEntryModel.direction) && kotlin.jvm.internal.s.d(this.enterText, liveUserEntryModel.enterText) && kotlin.jvm.internal.s.d(this.textEnterLabels, liveUserEntryModel.textEnterLabels) && kotlin.jvm.internal.s.d(this.floatDecorationLabels, liveUserEntryModel.floatDecorationLabels) && kotlin.jvm.internal.s.d(this.enterAnimationLabels, liveUserEntryModel.enterAnimationLabels) && kotlin.jvm.internal.s.d(this.enterDecorationLabels, liveUserEntryModel.enterDecorationLabels);
    }

    @Nullable
    public final String getAnimation() {
        return this.animation;
    }

    @Nullable
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    public final String getDecoration() {
        return this.decoration;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getEnterAnimationLabels() {
        return this.enterAnimationLabels;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getEnterDecorationLabels() {
        return this.enterDecorationLabels;
    }

    @Nullable
    public final String getEnterText() {
        return this.enterText;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getFloatDecorationLabels() {
        return this.floatDecorationLabels;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getRelationshipType() {
        return this.relationshipType;
    }

    @Nullable
    public final String getTextColor() {
        return this.textColor;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getTextEnterLabels() {
        return this.textEnterLabels;
    }

    @NotNull
    /* renamed from: getUser, reason: collision with other method in class */
    public final String m2459getUser() {
        return this.user;
    }

    @NotNull
    public final UserEntryDirection getUserEntryDirection() {
        return kotlin.jvm.internal.s.d(this.direction, "R2L") ? UserEntryDirection.R2L : UserEntryDirection.L2R;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.relationshipType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.decoration;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.textColor;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.background;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.animation;
        int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.direction.hashCode()) * 31;
        String str7 = this.enterText;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<BaseLiveShowTagModel> list = this.textEnterLabels;
        int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        List<BaseLiveShowTagModel> list2 = this.floatDecorationLabels;
        int hashCode10 = (hashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<BaseLiveShowTagModel> list3 = this.enterAnimationLabels;
        int hashCode11 = (hashCode10 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<BaseLiveShowTagModel> list4 = this.enterDecorationLabels;
        return hashCode11 + (list4 != null ? list4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveUserEntryModel(user=" + this.user + ", message=" + this.message + ", relationshipType=" + this.relationshipType + ", decoration=" + this.decoration + ", textColor=" + this.textColor + ", background=" + this.background + ", animation=" + this.animation + ", direction=" + this.direction + ", enterText=" + this.enterText + ", textEnterLabels=" + ((Object) this.textEnterLabels) + ", floatDecorationLabels=" + ((Object) this.floatDecorationLabels) + ", enterAnimationLabels=" + ((Object) this.enterAnimationLabels) + ", enterDecorationLabels=" + ((Object) this.enterDecorationLabels) + ")";
    }

    @Nullable
    public final User getUser() {
        return (User) GsonUtil.f12000a.b().fromJson(this.user, User.class);
    }
}
