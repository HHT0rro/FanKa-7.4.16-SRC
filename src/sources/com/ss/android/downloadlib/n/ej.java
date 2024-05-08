package com.ss.android.downloadlib.n;

import com.ss.android.socialbase.appdownloader.ej.oa;
import com.ss.android.socialbase.appdownloader.ej.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej implements oa {

    /* renamed from: m, reason: collision with root package name */
    private static volatile ej f38817m;
    private List<oa> dk;

    private ej() {
        ArrayList arrayList = new ArrayList();
        this.dk = arrayList;
        arrayList.add(new dk());
        this.dk.add(new m());
    }

    public static ej m() {
        if (f38817m == null) {
            synchronized (ej.class) {
                if (f38817m == null) {
                    f38817m = new ej();
                }
            }
        }
        return f38817m;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.oa
    public void m(DownloadInfo downloadInfo, w wVar) {
        if (downloadInfo != null && this.dk.size() != 0) {
            m(downloadInfo, 0, wVar);
        } else if (wVar != null) {
            wVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final DownloadInfo downloadInfo, final int i10, final w wVar) {
        if (i10 != this.dk.size() && i10 >= 0) {
            this.dk.get(i10).m(downloadInfo, new w() { // from class: com.ss.android.downloadlib.n.ej.1
                @Override // com.ss.android.socialbase.appdownloader.ej.w
                public void m() {
                    ej.this.m(downloadInfo, i10 + 1, wVar);
                }
            });
        } else {
            wVar.m();
        }
    }
}
