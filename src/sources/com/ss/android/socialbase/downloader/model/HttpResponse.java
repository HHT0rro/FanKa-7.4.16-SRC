package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpResponse {
    public final IDownloadHeadHttpConnection connection;
    private long contentLength;
    public final int responseCode;
    private long totalLength;
    public final String url;

    public HttpResponse(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection) throws IOException {
        this.url = str;
        this.responseCode = iDownloadHeadHttpConnection.getResponseCode();
        this.connection = iDownloadHeadHttpConnection;
    }

    public boolean acceptPartial() {
        return DownloadUtils.canAcceptPartial(this.responseCode, this.connection.getResponseHeaderField(DownloadUtils.ACCEPT_RANGES));
    }

    public String getCacheControl() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Cache-Control");
    }

    public long getContentLength() {
        if (this.contentLength <= 0) {
            this.contentLength = DownloadUtils.getContentLength(this.connection);
        }
        return this.contentLength;
    }

    public String getContentRange() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Content-Range");
    }

    public String getContentType() {
        return this.connection.getResponseHeaderField("Content-Type");
    }

    public String getEtag() {
        return this.connection.getResponseHeaderField(DownloadUtils.ETAG);
    }

    public String getLastModified() {
        String respHeadFieldIgnoreCase = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "last-modified");
        return TextUtils.isEmpty(respHeadFieldIgnoreCase) ? DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Last-Modified") : respHeadFieldIgnoreCase;
    }

    public long getMaxAge() {
        return DownloadUtils.parserMaxAge(getCacheControl());
    }

    public long getTotalLength() {
        if (this.totalLength <= 0) {
            if (!isChunked()) {
                String contentRange = getContentRange();
                if (!TextUtils.isEmpty(contentRange)) {
                    this.totalLength = DownloadUtils.parseContentRangeOfInstanceLength(contentRange);
                }
            } else {
                this.totalLength = -1L;
            }
        }
        return this.totalLength;
    }

    public boolean isChunked() {
        if (DownloadExpSwitchCode.isSwitchEnable(8)) {
            return DownloadUtils.isChunkedTask(this.connection);
        }
        return DownloadUtils.isChunkedTask(getContentLength());
    }

    public boolean isResponseDataFromBegin() {
        return DownloadUtils.isResponseDataFromBegin(this.responseCode);
    }
}
