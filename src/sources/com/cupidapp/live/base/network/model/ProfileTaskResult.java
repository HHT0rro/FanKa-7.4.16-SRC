package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileTaskResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ProfileTaskResult implements Serializable {

    @Nullable
    private final List<NewUserTaskModel> newUserTaskList;

    @Nullable
    private final TaskInfoModel taskInfo;

    public ProfileTaskResult(@Nullable List<NewUserTaskModel> list, @Nullable TaskInfoModel taskInfoModel) {
        this.newUserTaskList = list;
        this.taskInfo = taskInfoModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileTaskResult copy$default(ProfileTaskResult profileTaskResult, List list, TaskInfoModel taskInfoModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = profileTaskResult.newUserTaskList;
        }
        if ((i10 & 2) != 0) {
            taskInfoModel = profileTaskResult.taskInfo;
        }
        return profileTaskResult.copy(list, taskInfoModel);
    }

    @Nullable
    public final List<NewUserTaskModel> component1() {
        return this.newUserTaskList;
    }

    @Nullable
    public final TaskInfoModel component2() {
        return this.taskInfo;
    }

    @NotNull
    public final ProfileTaskResult copy(@Nullable List<NewUserTaskModel> list, @Nullable TaskInfoModel taskInfoModel) {
        return new ProfileTaskResult(list, taskInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileTaskResult)) {
            return false;
        }
        ProfileTaskResult profileTaskResult = (ProfileTaskResult) obj;
        return s.d(this.newUserTaskList, profileTaskResult.newUserTaskList) && s.d(this.taskInfo, profileTaskResult.taskInfo);
    }

    @Nullable
    public final List<NewUserTaskModel> getNewUserTaskList() {
        return this.newUserTaskList;
    }

    @Nullable
    public final TaskInfoModel getTaskInfo() {
        return this.taskInfo;
    }

    public int hashCode() {
        List<NewUserTaskModel> list = this.newUserTaskList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        TaskInfoModel taskInfoModel = this.taskInfo;
        return hashCode + (taskInfoModel != null ? taskInfoModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProfileTaskResult(newUserTaskList=" + ((Object) this.newUserTaskList) + ", taskInfo=" + ((Object) this.taskInfo) + ")";
    }
}
