package com.huawei.appgallery.agd.pageframe.api;

import android.content.Context;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.koushikdutta.quack.JavaScriptObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IAgdDownload {
    DownloadStatus getStatus(Context context, FLImmutableMap fLImmutableMap, JavaScriptObject javaScriptObject);
}
