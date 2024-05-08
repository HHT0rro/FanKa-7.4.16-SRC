package com.huawei.appmarket.service.externalservice.distribution.download.response;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskOperationResponse extends BaseIPCResponse {
    public static final Parcelable.Creator<TaskOperationResponse> CREATOR = new AutoParcelable.AutoCreator(TaskOperationResponse.class);
    public static final int OPERATION_RESULT_FAILED = -1;
    public static final int OPERATION_RESULT_SUCCESS = 0;

    @EnableAutoParcel(1)
    private int mResult;

    @EnableAutoParcel(2)
    private String mUrl;

    public int getResult() {
        return this.mResult;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setResult(int i10) {
        this.mResult = i10;
    }
}
