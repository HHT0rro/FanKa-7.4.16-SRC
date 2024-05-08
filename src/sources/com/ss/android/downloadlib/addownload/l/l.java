package com.ss.android.downloadlib.addownload.l;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {

    /* renamed from: m, reason: collision with root package name */
    private static l f38628m;
    private List<hc> dk;

    private l() {
        ArrayList arrayList = new ArrayList();
        this.dk = arrayList;
        arrayList.add(new np());
        this.dk.add(new dk());
        this.dk.add(new ej());
    }

    public static l m() {
        if (f38628m == null) {
            synchronized (c.class) {
                if (f38628m == null) {
                    f38628m = new l();
                }
            }
        }
        return f38628m;
    }

    public void m(com.ss.android.downloadad.api.m.dk dkVar, int i10, e eVar, com.ss.android.downloadlib.addownload.m.ej ejVar) {
        DownloadInfo dk;
        List<hc> list = this.dk;
        if (list == null || list.size() == 0 || dkVar == null) {
            eVar.m(dkVar);
        }
        if (!TextUtils.isEmpty(dkVar.ch())) {
            dk = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).m(dkVar.ch(), null, true);
        } else {
            dk = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).dk(dkVar.m());
        }
        if (dk == null) {
            dk = Downloader.getInstance(com.ss.android.downloadlib.addownload.c.getContext()).getDownloadInfo(dkVar.x());
        }
        if (dk != null && "application/vnd.android.package-archive".equals(dk.getMimeType())) {
            if (new oa().m(dkVar, i10, eVar)) {
                return;
            }
            Iterator<hc> iterator2 = this.dk.iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().m(dkVar, i10, eVar, ejVar)) {
                    return;
                }
            }
            eVar.m(dkVar);
            return;
        }
        eVar.m(dkVar);
    }
}
