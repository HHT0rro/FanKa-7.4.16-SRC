package com.huawei.appmarket.service.externalservice.distribution.download.response;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskInfo extends AutoParcelable {
    public static final Parcelable.Creator<TaskInfo> CREATOR = new AutoParcelable.AutoCreator(TaskInfo.class);

    @EnableAutoParcel(1)
    private int mAppStatusType;

    @EnableAutoParcel(3)
    private int mProgress;

    @EnableAutoParcel(2)
    private int mStatus;

    public int getAppStatusType() {
        return this.mAppStatusType;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setAppStatusType(int i10) {
        this.mAppStatusType = i10;
    }

    public void setProgress(int i10) {
        this.mProgress = i10;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }
}
