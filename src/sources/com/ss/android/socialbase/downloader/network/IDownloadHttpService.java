package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloadHttpService {
    IDownloadHttpConnection downloadWithConnection(int i10, String str, List<HttpHeader> list) throws IOException;
}
