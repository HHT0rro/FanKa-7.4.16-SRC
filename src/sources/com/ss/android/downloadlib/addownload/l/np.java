package com.ss.android.downloadlib.addownload.l;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.sy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np implements hc {
    @Override // com.ss.android.downloadlib.addownload.l.hc
    public boolean m(com.ss.android.downloadad.api.m.dk dkVar, int i10, e eVar, com.ss.android.downloadlib.addownload.m.ej ejVar) {
        DownloadInfo dk;
        if (dkVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(dkVar.ch())) {
            dk = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).m(dkVar.ch(), null, true);
        } else {
            dk = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).dk(dkVar.m());
        }
        return sy.m(dkVar, dk, i10, eVar, true, ejVar);
    }
}
