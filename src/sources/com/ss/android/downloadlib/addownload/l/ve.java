package com.ss.android.downloadlib.addownload.l;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.sy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ve implements w {
    @Override // com.ss.android.downloadlib.addownload.l.w
    public boolean m(com.ss.android.downloadad.api.m.dk dkVar, int i10, e eVar) {
        DownloadInfo dk;
        if (dkVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(dkVar.ch())) {
            dk = com.ss.android.downloadlib.e.m((Context) null).m(dkVar.ch(), null, true);
        } else {
            dk = com.ss.android.downloadlib.e.m((Context) null).dk(dkVar.m());
        }
        return sy.m(dkVar, dk, i10, eVar, false, null);
    }
}
