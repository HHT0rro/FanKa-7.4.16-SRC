package w9;

import android.content.Context;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequestHeader;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appmarket.framework.coreservice.DataHolder;
import com.huawei.appmarket.framework.coreservice.Status;
import com.huawei.appmarket.framework.coreservice.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f<C extends BaseIPCRequest> implements com.huawei.appgallery.coreservice.f {

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f54305c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f54306a;

    /* renamed from: b, reason: collision with root package name */
    public final C f54307b;

    static {
        ArrayList arrayList = new ArrayList();
        f54305c = arrayList;
        arrayList.add("method.cancelTask");
        arrayList.add("method.pauseTask");
        arrayList.add("method.queryTasks");
        arrayList.add("method.registerDownloadCallback");
        arrayList.add("method.resumeTask");
        arrayList.add("method.startDownloadTask");
        arrayList.add("method.unregisterDownloadCallback");
    }

    public f(Context context, C c4) {
        this.f54306a = context;
        this.f54307b = c4;
    }

    @Override // com.huawei.appgallery.coreservice.f
    public final void a(ApiClient apiClient, a.AbstractBinderC0260a abstractBinderC0260a) {
        String str;
        if (this.f54307b == null) {
            c(abstractBinderC0260a, 14);
            return;
        }
        c b4 = b(apiClient);
        if (b4 != null) {
            DataHolder dataHolder = new DataHolder();
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.c(this.f54306a.getPackageName());
            requestHeader.b(this.f54307b.getMediaPkg());
            RequireVersion requireVersion = (RequireVersion) this.f54307b.getClass().getAnnotation(RequireVersion.class);
            if (requireVersion != null) {
                requestHeader.a(requireVersion.value());
            }
            dataHolder.b(requestHeader);
            dataHolder.c(this.f54307b.getMethod());
            dataHolder.a(this.f54307b);
            try {
                b4.a(dataHolder, abstractBinderC0260a);
                return;
            } catch (Exception e2) {
                str = "sync call ex:" + e2.getMessage();
            }
        } else {
            str = "can not find client";
        }
        m.c(NotificationCompat.CATEGORY_TRANSPORT, str);
        c(abstractBinderC0260a, 8);
    }

    public final c b(ApiClient apiClient) {
        if (!(apiClient instanceof a)) {
            apiClient = apiClient.getDelegate();
            if (!(apiClient instanceof a)) {
                return null;
            }
        }
        return ((a) apiClient).a();
    }

    public final void c(com.huawei.appmarket.framework.coreservice.a aVar, int i10) {
        if (aVar != null) {
            try {
                aVar.call(new Status(i10));
            } catch (RemoteException e2) {
                m.b(NotificationCompat.CATEGORY_TRANSPORT, "default failed call failed", e2);
            }
        }
    }
}
