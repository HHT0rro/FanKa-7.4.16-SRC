package com.ss.android.downloadlib.addownload.dk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {
    private final ConcurrentHashMap<Long, DownloadModel> dk;
    private final ConcurrentHashMap<Long, DownloadEventConfig> ej;

    /* renamed from: l, reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadController> f38581l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38582m;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.m.dk> np;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static n f38584m = new n();
    }

    public DownloadController ej(long j10) {
        return this.f38581l.get(Long.valueOf(j10));
    }

    public com.ss.android.downloadad.api.m.dk l(long j10) {
        return this.np.get(Long.valueOf(j10));
    }

    public void n(long j10) {
        this.dk.remove(Long.valueOf(j10));
        this.ej.remove(Long.valueOf(j10));
        this.f38581l.remove(Long.valueOf(j10));
    }

    @NonNull
    public np np(long j10) {
        np npVar = new np();
        npVar.f38586m = j10;
        npVar.dk = m(j10);
        DownloadEventConfig dk = dk(j10);
        npVar.ej = dk;
        if (dk == null) {
            npVar.ej = new com.ss.android.download.api.download.ej();
        }
        DownloadController ej = ej(j10);
        npVar.f38585l = ej;
        if (ej == null) {
            npVar.f38585l = new com.ss.android.download.api.download.dk();
        }
        return npVar;
    }

    private n() {
        this.f38582m = false;
        this.dk = new ConcurrentHashMap<>();
        this.ej = new ConcurrentHashMap<>();
        this.f38581l = new ConcurrentHashMap<>();
        this.np = new ConcurrentHashMap<>();
    }

    public void dk() {
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.addownload.dk.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.f38582m) {
                    return;
                }
                synchronized (n.class) {
                    if (!n.this.f38582m) {
                        n.this.np.putAll(w.m().dk());
                        n.this.f38582m = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.m.dk> ej() {
        return this.np;
    }

    public static n m() {
        return m.f38584m;
    }

    public DownloadEventConfig dk(long j10) {
        return this.ej.get(Long.valueOf(j10));
    }

    public com.ss.android.downloadad.api.m.dk dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.m.dk dkVar : this.np.values()) {
            if (dkVar != null && str.equals(dkVar.m())) {
                return dkVar;
            }
        }
        return null;
    }

    public void m(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.dk.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void dk(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.dk.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void m(long j10, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.ej.put(Long.valueOf(j10), downloadEventConfig);
        }
    }

    public void m(long j10, DownloadController downloadController) {
        if (downloadController != null) {
            this.f38581l.put(Long.valueOf(j10), downloadController);
        }
    }

    public synchronized void m(com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return;
        }
        this.np.put(Long.valueOf(dkVar.dk()), dkVar);
        w.m().m(dkVar);
    }

    public DownloadModel m(long j10) {
        return this.dk.get(Long.valueOf(j10));
    }

    public com.ss.android.downloadad.api.m.dk m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.m.dk dkVar : this.np.values()) {
            if (dkVar != null && str.equals(dkVar.np())) {
                return dkVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.m.dk m(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.m.dk dkVar : this.np.values()) {
            if (dkVar != null && dkVar.x() == downloadInfo.getId()) {
                return dkVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long m10 = ve.m(new JSONObject(downloadInfo.getExtra()), "extra");
                if (m10 != 0) {
                    for (com.ss.android.downloadad.api.m.dk dkVar2 : this.np.values()) {
                        if (dkVar2 != null && dkVar2.dk() == m10) {
                            return dkVar2;
                        }
                    }
                    com.ss.android.downloadlib.np.ej.m().m("getNativeModelByInfo");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.m.dk dkVar3 : this.np.values()) {
            if (dkVar3 != null && TextUtils.equals(dkVar3.m(), downloadInfo.getUrl())) {
                return dkVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.m.dk m(int i10) {
        for (com.ss.android.downloadad.api.m.dk dkVar : this.np.values()) {
            if (dkVar != null && dkVar.x() == i10) {
                return dkVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.m.dk> m(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.m.dk dkVar : this.np.values()) {
                if (dkVar != null && TextUtils.equals(dkVar.m(), str)) {
                    dkVar.dk(str2);
                    hashMap.put(Long.valueOf(dkVar.dk()), dkVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void m(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            long longValue = iterator2.next().longValue();
            arrayList.add(String.valueOf(longValue));
            this.np.remove(Long.valueOf(longValue));
        }
        w.m().m((List<String>) arrayList);
    }
}
