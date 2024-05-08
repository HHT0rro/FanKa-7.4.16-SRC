package com.ss.android.downloadlib.addownload.l;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: m, reason: collision with root package name */
    private static c f38615m;
    private List<w> dk;

    private c() {
        ArrayList arrayList = new ArrayList();
        this.dk = arrayList;
        arrayList.add(new oa());
        this.dk.add(new ve());
        this.dk.add(new n());
        this.dk.add(new m());
    }

    public static c m() {
        if (f38615m == null) {
            synchronized (c.class) {
                if (f38615m == null) {
                    f38615m = new c();
                }
            }
        }
        return f38615m;
    }

    public void m(com.ss.android.downloadad.api.m.dk dkVar, int i10, e eVar) {
        DownloadInfo dk;
        List<w> list = this.dk;
        if (list != null && list.size() != 0 && dkVar != null) {
            if (!TextUtils.isEmpty(dkVar.ch())) {
                dk = com.ss.android.downloadlib.e.m((Context) null).m(dkVar.ch(), null, true);
            } else {
                dk = com.ss.android.downloadlib.e.m((Context) null).dk(dkVar.m());
            }
            if (dk != null && "application/vnd.android.package-archive".equals(dk.getMimeType())) {
                boolean z10 = DownloadSetting.obtain(dkVar.x()).optInt("pause_optimise_switch", 0) == 1;
                for (w wVar : this.dk) {
                    if (z10 || (wVar instanceof ve)) {
                        if (wVar.m(dkVar, i10, eVar)) {
                            return;
                        }
                    }
                }
                eVar.m(dkVar);
                return;
            }
            eVar.m(dkVar);
            return;
        }
        eVar.m(dkVar);
    }
}
