package com.huawei.appmarket.service.externalservice.distribution.download.response;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class QueryTaskResponse extends BaseIPCResponse {
    public static final Parcelable.Creator<QueryTaskResponse> CREATOR = new AutoParcelable.AutoCreator(QueryTaskResponse.class);

    @EnableAutoParcel(1)
    private HashMap<String, TaskInfo> mTaskList = new HashMap<>();

    public HashMap<String, TaskInfo> getTaskList() {
        return this.mTaskList;
    }

    public void setTaskList(HashMap<String, TaskInfo> hashMap) {
        this.mTaskList = hashMap;
    }
}
