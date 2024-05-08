package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Looper;
import com.alibaba.security.common.track.interfaces.ITrackUpload;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.http.HttpRequestManager;
import com.alibaba.security.realidentity.http.IHttpCallback;
import com.alibaba.security.realidentity.track.RPTrackHttpModel;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TrackUpload.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gz implements ITrackUpload {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3791a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f3792b = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.gz.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "rpsdk-trackUpload");
        }
    });

    public gz(Context context) {
        this.f3791a = context;
    }

    @Override // com.alibaba.security.common.track.interfaces.ITrackUpload
    public final void upload(final List<TrackLog> list) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.f3792b.execute(new Runnable() { // from class: com.alibaba.security.realidentity.build.gz.2
                @Override // java.lang.Runnable
                public final void run() {
                    gz.this.a((List<TrackLog>) list);
                }
            });
        } else {
            a(list);
        }
    }

    private static ClientInfo a(String str) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientType(GrsBaseInfo.CountryCodeSource.APP);
        clientInfo.setAppInfo(hj.a(str));
        clientInfo.setDeviceInfo(hj.a());
        clientInfo.setNetWorkInfo(hj.b(str));
        return clientInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<TrackLog> list) {
        RPTrackHttpModel rPTrackHttpModel = new RPTrackHttpModel();
        String str = j.a.f3944a.f3895e;
        rPTrackHttpModel.setClientInfo(a(str));
        rPTrackHttpModel.setVerifyToken(str);
        rPTrackHttpModel.setWirelessLogs(list);
        HttpRequestManager.getInstance().asyncRequest(this.f3791a, a.f3003i, JsonUtils.toJSON(rPTrackHttpModel), (IHttpCallback) null, false, true);
    }
}
