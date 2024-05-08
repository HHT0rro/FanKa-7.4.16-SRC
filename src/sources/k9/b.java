package k9;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.base.api.IAppStatusListener;
import com.huawei.appgallery.agd.base.download.AppStatusReceiver;
import com.huawei.appgallery.agd.base.download.PackageReceiver;
import com.huawei.appmarket.service.externalservice.distribution.download.request.QueryTaskIPCRequest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: AppStatusManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b implements IAppStatusListener {

    /* renamed from: e, reason: collision with root package name */
    public static b f50739e;

    /* renamed from: a, reason: collision with root package name */
    public final List<IAppStatusListener> f50740a = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, DownloadStatus> f50743d = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final AppStatusReceiver f50741b = new AppStatusReceiver(this);

    /* renamed from: c, reason: collision with root package name */
    public final PackageReceiver f50742c = new PackageReceiver(this);

    @VisibleForTesting
    public b() {
    }

    public static b d() {
        synchronized (b.class) {
            if (f50739e == null) {
                f50739e = new b();
            }
        }
        return f50739e;
    }

    public void b(@NonNull IAppStatusListener iAppStatusListener) {
        j9.a.f50348d.i("AppStatusManager", "addListener " + ((Object) iAppStatusListener) + ", current size: " + this.f50740a.size());
        if (this.f50740a.isEmpty()) {
            g();
            this.f50741b.b();
            this.f50742c.b();
            Iterator<DownloadStatus> iterator2 = this.f50743d.values().iterator2();
            while (iterator2.hasNext()) {
                iAppStatusListener.onStatusChange(iterator2.next());
            }
        }
        this.f50740a.add(iAppStatusListener);
    }

    @NonNull
    public DownloadStatus c(String str) {
        DownloadStatus downloadStatus = (TextUtils.isEmpty(str) || !this.f50743d.containsKey(str)) ? null : this.f50743d.get(str);
        return downloadStatus == null ? new DownloadStatus(str) : downloadStatus;
    }

    public final void f(@NonNull DownloadStatus downloadStatus) {
        for (IAppStatusListener iAppStatusListener : this.f50740a) {
            if (iAppStatusListener != null) {
                iAppStatusListener.onStatusChange(downloadStatus);
            }
        }
    }

    public final void g() {
        final QueryTaskIPCRequest queryTaskIPCRequest = new QueryTaskIPCRequest();
        new Thread(new Runnable() { // from class: k9.a
            @Override // java.lang.Runnable
            public final void run() {
                AgdManager.queryTasks(QueryTaskIPCRequest.this);
            }
        }).start();
    }

    public void h(@NonNull IAppStatusListener iAppStatusListener) {
        j9.a aVar = j9.a.f50348d;
        aVar.i("AppStatusManager", "removeListener " + ((Object) iAppStatusListener));
        this.f50740a.remove(iAppStatusListener);
        if (this.f50740a.isEmpty()) {
            aVar.i("AppStatusManager", "listener empty, clear");
            this.f50741b.c();
            this.f50742c.c();
            this.f50743d.clear();
            AgdManager.disconnect();
        }
    }

    @Override // com.huawei.appgallery.agd.base.api.IAppStatusListener
    public void onStatusChange(@NonNull DownloadStatus downloadStatus) {
        j9.a aVar = j9.a.f50348d;
        aVar.i("AppStatusManager", "onStatusChange " + ((Object) downloadStatus));
        String str = downloadStatus.packageName;
        if (TextUtils.isEmpty(str)) {
            aVar.i("AppStatusManager", "update packageName null");
            return;
        }
        if (downloadStatus.isInstalled()) {
            this.f50743d.remove(str);
        } else {
            this.f50743d.put(str, downloadStatus);
        }
        f(downloadStatus);
    }
}
