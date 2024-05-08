package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileTaskResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TaskInfoModel implements Serializable {
    private final int doneNum;

    @NotNull
    private final ImageModel icon;

    @Nullable
    private final String title;
    private final int totalNum;

    public TaskInfoModel(int i10, @NotNull ImageModel icon, int i11, @Nullable String str) {
        s.i(icon, "icon");
        this.doneNum = i10;
        this.icon = icon;
        this.totalNum = i11;
        this.title = str;
    }

    public static /* synthetic */ TaskInfoModel copy$default(TaskInfoModel taskInfoModel, int i10, ImageModel imageModel, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = taskInfoModel.doneNum;
        }
        if ((i12 & 2) != 0) {
            imageModel = taskInfoModel.icon;
        }
        if ((i12 & 4) != 0) {
            i11 = taskInfoModel.totalNum;
        }
        if ((i12 & 8) != 0) {
            str = taskInfoModel.title;
        }
        return taskInfoModel.copy(i10, imageModel, i11, str);
    }

    public final int component1() {
        return this.doneNum;
    }

    @NotNull
    public final ImageModel component2() {
        return this.icon;
    }

    public final int component3() {
        return this.totalNum;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final TaskInfoModel copy(int i10, @NotNull ImageModel icon, int i11, @Nullable String str) {
        s.i(icon, "icon");
        return new TaskInfoModel(i10, icon, i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskInfoModel)) {
            return false;
        }
        TaskInfoModel taskInfoModel = (TaskInfoModel) obj;
        return this.doneNum == taskInfoModel.doneNum && s.d(this.icon, taskInfoModel.icon) && this.totalNum == taskInfoModel.totalNum && s.d(this.title, taskInfoModel.title);
    }

    public final int getDoneNum() {
        return this.doneNum;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getTotalNum() {
        return this.totalNum;
    }

    public int hashCode() {
        int hashCode = ((((this.doneNum * 31) + this.icon.hashCode()) * 31) + this.totalNum) * 31;
        String str = this.title;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        int i10 = this.doneNum;
        ImageModel imageModel = this.icon;
        return "TaskInfoModel(doneNum=" + i10 + ", icon=" + ((Object) imageModel) + ", totalNum=" + this.totalNum + ", title=" + this.title + ")";
    }
}
