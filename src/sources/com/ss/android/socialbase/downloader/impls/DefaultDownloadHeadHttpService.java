package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultDownloadHeadHttpService implements IDownloadHeadHttpService {
    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService
    public IDownloadHeadHttpConnection downloadWithConnection(String str, List<HttpHeader> list) throws IOException {
        OkHttpClient downloadClient = DownloadComponentManager.getDownloadClient();
        if (downloadClient != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (HttpHeader httpHeader : list) {
                    head.addHeader(httpHeader.getName(), DownloadUtils.getEncodedStr(httpHeader.getValue()));
                }
            }
            final Call newCall = downloadClient.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (DownloadExpSwitchCode.isSwitchEnable(2097152)) {
                    execute.close();
                }
                return new IDownloadHeadHttpConnection() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService.1
                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public void cancel() {
                        Call call = newCall;
                        if (call == null || call.isCanceled()) {
                            return;
                        }
                        newCall.cancel();
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public int getResponseCode() throws IOException {
                        return execute.code();
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public String getResponseHeaderField(String str2) {
                        return execute.header(str2);
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
