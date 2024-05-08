package r9;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigListRequest;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigListResponse;
import com.huawei.appgallery.agd.core.internalapi.IQueryConfigList;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: r9.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0811a implements IServerCallbackEx {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IQueryConfigList.Callback f53326a;

        public C0811a(IQueryConfigList.Callback callback) {
            this.f53326a = callback;
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onFail(int i10, String str) {
            this.f53326a.onFail(1, "StartUp fail with code: " + i10 + ", msg: " + str);
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onResponse(ResponseBean responseBean) {
            a.c(responseBean, this.f53326a);
        }
    }

    public static void b(String[] strArr, IQueryConfigList.Callback callback) {
        ServerAgent.invokeServerEx(new ConfigListRequest(strArr), new C0811a(callback));
    }

    public static void c(ResponseBean responseBean, @NonNull IQueryConfigList.Callback callback) {
        if (!(responseBean instanceof ConfigListResponse)) {
            callback.onFail(2, "Failed to load the response");
            return;
        }
        ConfigListResponse configListResponse = (ConfigListResponse) responseBean;
        if (configListResponse.getResponseCode() == 0 && configListResponse.getRtnCode_() == 0) {
            callback.onSuccess(configListResponse);
            return;
        }
        callback.onFail(3, "rtnCode: " + configListResponse.getRtnCode_() + ", responseCode: " + configListResponse.getResponseCode() + ", rtnDesc: " + configListResponse.getRtnDesc());
    }
}
