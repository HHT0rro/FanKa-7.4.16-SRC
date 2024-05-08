package com.huawei.serverrequest.api.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hmf.taskstream.TaskStream;
import com.huawei.serverrequest.api.service.HttpService;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface DownloadService {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Progress {
        int getProgress();
    }

    TaskStream<Progress> download(@NonNull HttpRequest httpRequest, File file);

    void setDelegate(@Nullable HttpService.BuildHttpClientDelegate buildHttpClientDelegate);
}
