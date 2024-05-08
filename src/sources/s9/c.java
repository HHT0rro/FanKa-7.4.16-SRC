package s9;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.gcd.DispatchBlock;
import com.huawei.appgallery.agd.common.gcd.DispatchQoS;
import com.huawei.appgallery.agd.common.gcd.DispatchQueue;
import com.huawei.appgallery.agd.common.gcd.DispatchWorkQueue;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.store.mediaparams.MediaParamsRequest;
import com.huawei.appgallery.agd.core.impl.store.mediaparams.MediaParamsResponse;
import com.huawei.appgallery.agd.core.internalapi.IQueryMediaParams;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import s9.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements IServerCallbackEx {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IQueryMediaParams.Callback f53685a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaParamsRequest f53686b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f53687c;

        public a(IQueryMediaParams.Callback callback, MediaParamsRequest mediaParamsRequest, long j10) {
            this.f53685a = callback;
            this.f53686b = mediaParamsRequest;
            this.f53687c = j10;
        }

        public static /* synthetic */ void c(MediaParamsRequest mediaParamsRequest, int i10, String str, long j10) {
            MaintBi.report(new MaintData.Builder(MaintKey.EVENT_LOAD_TEMPLATE).setRequestId(mediaParamsRequest.getRequestId()).setErrorCode(i10).setMsg(str).setTotalTime(System.currentTimeMillis() - j10).build());
        }

        public static /* synthetic */ void d(MediaParamsRequest mediaParamsRequest, ResponseBean responseBean, long j10) {
            MaintBi.report(new MaintData.Builder(MaintKey.EVENT_LOAD_TEMPLATE).setRequestId(mediaParamsRequest.getRequestId()).setResponseCode(responseBean.getResponseCode()).setErrorCode(responseBean.getRtnCode_()).setMsg(responseBean.getRtnDesc()).setTotalTime(System.currentTimeMillis() - j10).build());
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onFail(final int i10, final String str) {
            this.f53685a.onFail(1, "StartUp fail with code: " + i10 + ", msg: " + str);
            DispatchWorkQueue dispatchWorkQueue = DispatchQueue.GLOBAL;
            DispatchQoS dispatchQoS = DispatchQoS.SERIAL;
            final MediaParamsRequest mediaParamsRequest = this.f53686b;
            final long j10 = this.f53687c;
            dispatchWorkQueue.async(dispatchQoS, new DispatchBlock() { // from class: s9.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.c(MediaParamsRequest.this, i10, str, j10);
                }
            });
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onResponse(final ResponseBean responseBean) {
            c.c(responseBean, this.f53685a);
            if (responseBean != null) {
                DispatchWorkQueue dispatchWorkQueue = DispatchQueue.GLOBAL;
                DispatchQoS dispatchQoS = DispatchQoS.SERIAL;
                final MediaParamsRequest mediaParamsRequest = this.f53686b;
                final long j10 = this.f53687c;
                dispatchWorkQueue.async(dispatchQoS, new DispatchBlock() { // from class: s9.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a.d(MediaParamsRequest.this, responseBean, j10);
                    }
                });
                return;
            }
            n9.a.f52175d.w("MediaParamsManager", "queryMediaParams response null");
        }
    }

    public static void b(String str, int i10, @NonNull IQueryMediaParams.Callback callback) {
        MediaParamsRequest mediaParamsRequest = new MediaParamsRequest(str, i10);
        ServerAgent.invokeServerEx(mediaParamsRequest, new a(callback, mediaParamsRequest, System.currentTimeMillis()));
    }

    public static void c(ResponseBean responseBean, @NonNull IQueryMediaParams.Callback callback) {
        if (!(responseBean instanceof MediaParamsResponse)) {
            callback.onFail(2, "Failed to load the response");
            return;
        }
        MediaParamsResponse mediaParamsResponse = (MediaParamsResponse) responseBean;
        if (mediaParamsResponse.getResponseCode() == 0 && mediaParamsResponse.getRtnCode_() == 0) {
            callback.onSuccess(mediaParamsResponse);
            return;
        }
        callback.onFail(3, "rtnCode: " + mediaParamsResponse.getRtnCode_() + ", responseCode: " + mediaParamsResponse.getResponseCode() + ", rtnDesc: " + mediaParamsResponse.getRtnDesc());
    }
}
