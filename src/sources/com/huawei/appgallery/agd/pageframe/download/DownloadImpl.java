package com.huawei.appgallery.agd.pageframe.download;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.appgallery.agd.pageframe.api.IAgdDownload;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.hmf.annotation.ApiDefine;
import com.huawei.hmf.annotation.Singleton;
import com.koushikdutta.quack.JavaScriptObject;
import k9.b;

@ApiDefine(uri = IAgdDownload.class)
@Singleton
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DownloadImpl implements IAgdDownload {
    private static final String REFS_APP = "refs_app";
    private static final String TAG = "DownloadImpl";

    @Override // com.huawei.appgallery.agd.pageframe.api.IAgdDownload
    public DownloadStatus getStatus(Context context, FLImmutableMap fLImmutableMap, JavaScriptObject javaScriptObject) {
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i(TAG, "start getStatus");
        if (context != null && fLImmutableMap != null) {
            FLImmutableMap optMap = fLImmutableMap.optMap("refs_app");
            if (optMap == null) {
                pageFrameLog.i(TAG, "Status : refs_app is null, set data");
            } else {
                fLImmutableMap = optMap;
            }
            String str = (String) fLImmutableMap.get("packageName");
            if (TextUtils.isEmpty(str)) {
                pageFrameLog.e(TAG, "Status : package name is null");
                return null;
            }
            DownloadStatus c4 = b.d().c(str);
            pageFrameLog.i(TAG, "start getStatus, downloadStatus : " + ((Object) c4));
            return c4;
        }
        pageFrameLog.e(TAG, "Status : context or data is null");
        return null;
    }
}
