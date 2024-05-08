package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileTaskResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewUserTaskModel implements Serializable {

    @NotNull
    private final String actionName;

    @Nullable
    private final String desc;
    private final int flowStep;

    @NotNull
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String rewardDesc;

    @Nullable
    private final ImageModel rewardIcon;

    @NotNull
    private final String taskId;

    @Nullable
    private final Integer taskType;

    @Nullable
    private final String tips;

    @NotNull
    private final String title;

    @Nullable
    private final String toast;

    public NewUserTaskModel(@NotNull String taskId, @Nullable Integer num, @NotNull String actionName, int i10, @Nullable String str, @NotNull ImageModel icon, @Nullable String str2, @NotNull String title, @Nullable String str3, @Nullable String str4, @Nullable ImageModel imageModel, @Nullable String str5) {
        s.i(taskId, "taskId");
        s.i(actionName, "actionName");
        s.i(icon, "icon");
        s.i(title, "title");
        this.taskId = taskId;
        this.taskType = num;
        this.actionName = actionName;
        this.flowStep = i10;
        this.desc = str;
        this.icon = icon;
        this.tips = str2;
        this.title = title;
        this.toast = str3;
        this.jumpUrl = str4;
        this.rewardIcon = imageModel;
        this.rewardDesc = str5;
    }

    @NotNull
    public final String component1() {
        return this.taskId;
    }

    @Nullable
    public final String component10() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel component11() {
        return this.rewardIcon;
    }

    @Nullable
    public final String component12() {
        return this.rewardDesc;
    }

    @Nullable
    public final Integer component2() {
        return this.taskType;
    }

    @NotNull
    public final String component3() {
        return this.actionName;
    }

    public final int component4() {
        return this.flowStep;
    }

    @Nullable
    public final String component5() {
        return this.desc;
    }

    @NotNull
    public final ImageModel component6() {
        return this.icon;
    }

    @Nullable
    public final String component7() {
        return this.tips;
    }

    @NotNull
    public final String component8() {
        return this.title;
    }

    @Nullable
    public final String component9() {
        return this.toast;
    }

    @NotNull
    public final NewUserTaskModel copy(@NotNull String taskId, @Nullable Integer num, @NotNull String actionName, int i10, @Nullable String str, @NotNull ImageModel icon, @Nullable String str2, @NotNull String title, @Nullable String str3, @Nullable String str4, @Nullable ImageModel imageModel, @Nullable String str5) {
        s.i(taskId, "taskId");
        s.i(actionName, "actionName");
        s.i(icon, "icon");
        s.i(title, "title");
        return new NewUserTaskModel(taskId, num, actionName, i10, str, icon, str2, title, str3, str4, imageModel, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewUserTaskModel)) {
            return false;
        }
        NewUserTaskModel newUserTaskModel = (NewUserTaskModel) obj;
        return s.d(this.taskId, newUserTaskModel.taskId) && s.d(this.taskType, newUserTaskModel.taskType) && s.d(this.actionName, newUserTaskModel.actionName) && this.flowStep == newUserTaskModel.flowStep && s.d(this.desc, newUserTaskModel.desc) && s.d(this.icon, newUserTaskModel.icon) && s.d(this.tips, newUserTaskModel.tips) && s.d(this.title, newUserTaskModel.title) && s.d(this.toast, newUserTaskModel.toast) && s.d(this.jumpUrl, newUserTaskModel.jumpUrl) && s.d(this.rewardIcon, newUserTaskModel.rewardIcon) && s.d(this.rewardDesc, newUserTaskModel.rewardDesc);
    }

    @NotNull
    public final String getActionName() {
        return this.actionName;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public final int getFlowStep() {
        return this.flowStep;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getRewardDesc() {
        return this.rewardDesc;
    }

    @Nullable
    public final ImageModel getRewardIcon() {
        return this.rewardIcon;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    @Nullable
    public final Integer getTaskType() {
        return this.taskType;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getToast() {
        return this.toast;
    }

    public int hashCode() {
        int hashCode = this.taskId.hashCode() * 31;
        Integer num = this.taskType;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.actionName.hashCode()) * 31) + this.flowStep) * 31;
        String str = this.desc;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.icon.hashCode()) * 31;
        String str2 = this.tips;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.title.hashCode()) * 31;
        String str3 = this.toast;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.jumpUrl;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ImageModel imageModel = this.rewardIcon;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str5 = this.rewardDesc;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.taskId;
        Integer num = this.taskType;
        String str2 = this.actionName;
        int i10 = this.flowStep;
        String str3 = this.desc;
        ImageModel imageModel = this.icon;
        String str4 = this.tips;
        String str5 = this.title;
        String str6 = this.toast;
        String str7 = this.jumpUrl;
        ImageModel imageModel2 = this.rewardIcon;
        return "NewUserTaskModel(taskId=" + str + ", taskType=" + ((Object) num) + ", actionName=" + str2 + ", flowStep=" + i10 + ", desc=" + str3 + ", icon=" + ((Object) imageModel) + ", tips=" + str4 + ", title=" + str5 + ", toast=" + str6 + ", jumpUrl=" + str7 + ", rewardIcon=" + ((Object) imageModel2) + ", rewardDesc=" + this.rewardDesc + ")";
    }

    public /* synthetic */ NewUserTaskModel(String str, Integer num, String str2, int i10, String str3, ImageModel imageModel, String str4, String str5, String str6, String str7, ImageModel imageModel2, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : num, str2, i10, str3, imageModel, str4, str5, str6, str7, imageModel2, str8);
    }
}
