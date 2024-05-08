package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultIdGenerator implements IDownloadIdGenerator {
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public int generate(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String md5Hex = DownloadUtils.md5Hex(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(md5Hex)) {
            return 0;
        }
        return md5Hex.hashCode();
    }
}
