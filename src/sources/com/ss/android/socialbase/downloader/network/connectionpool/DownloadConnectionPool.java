package com.ss.android.socialbase.downloader.network.connectionpool;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadConnectionPool {
    public static final int MAX_HOLD_CONNECTION = 3;
    private static final String TAG = "DownloadConnectionPool";
    private final Map<String, FakeDownloadHttpConnection> mCachedDownloadConnections;
    private final Map<String, FakeDownloadHeadHttpConnection> mCachedHeadConnections;
    public int maxCacheSize;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class InstanceHolder {
        private static final DownloadConnectionPool INSTANCE = new DownloadConnectionPool();

        private InstanceHolder() {
        }
    }

    public static DownloadConnectionPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public FakeDownloadHttpConnection getCachedDownloadConnection(String str, List<HttpHeader> list) {
        FakeDownloadHttpConnection remove;
        synchronized (this.mCachedDownloadConnections) {
            remove = this.mCachedDownloadConnections.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (DownloadUtils.isHeaderEqual(remove.getRequestHeaders(), list)) {
            try {
                remove.joinExecute();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (remove.isValid() && remove.isSuccessful()) {
                return remove;
            }
        }
        try {
            remove.end();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public FakeDownloadHeadHttpConnection getCachedHeadConnection(String str, List<HttpHeader> list) {
        FakeDownloadHeadHttpConnection remove;
        synchronized (this.mCachedHeadConnections) {
            remove = this.mCachedHeadConnections.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (DownloadUtils.isHeaderEqual(remove.getRequestHeaders(), list)) {
            try {
                remove.joinExecute();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (remove.isValid() && remove.isSuccessful()) {
                return remove;
            }
        }
        try {
            remove.cancel();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean isDownloadConnectionExist(String str) {
        FakeDownloadHttpConnection fakeDownloadHttpConnection = this.mCachedDownloadConnections.get(str);
        if (fakeDownloadHttpConnection == null) {
            return false;
        }
        if (fakeDownloadHttpConnection.isRequesting()) {
            return true;
        }
        return fakeDownloadHttpConnection.isValid() && fakeDownloadHttpConnection.isSuccessful();
    }

    public boolean isHeadConnectionExist(String str) {
        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = this.mCachedHeadConnections.get(str);
        if (fakeDownloadHeadHttpConnection == null) {
            return false;
        }
        if (fakeDownloadHeadHttpConnection.isRequesting()) {
            return true;
        }
        return fakeDownloadHeadHttpConnection.isValid() && fakeDownloadHeadHttpConnection.isSuccessful();
    }

    public void putCachedDownloadConnections(String str, FakeDownloadHttpConnection fakeDownloadHttpConnection) {
        FakeDownloadHttpConnection fakeDownloadHttpConnection2;
        Map.Entry<String, FakeDownloadHttpConnection> next;
        synchronized (this.mCachedDownloadConnections) {
            if (this.mCachedDownloadConnections.size() == this.maxCacheSize) {
                Iterator<Map.Entry<String, FakeDownloadHttpConnection>> iterator2 = this.mCachedDownloadConnections.entrySet().iterator2();
                if (iterator2.hasNext() && (next = iterator2.next()) != null) {
                    fakeDownloadHttpConnection2 = this.mCachedDownloadConnections.remove(next.getKey());
                    this.mCachedDownloadConnections.put(str, fakeDownloadHttpConnection);
                }
            }
            fakeDownloadHttpConnection2 = null;
            this.mCachedDownloadConnections.put(str, fakeDownloadHttpConnection);
        }
        if (fakeDownloadHttpConnection2 != null) {
            try {
                fakeDownloadHttpConnection2.end();
            } catch (Throwable unused) {
            }
        }
        Logger.i(TAG, "mCachedConnections size = " + this.mCachedDownloadConnections.size() + ", max size = " + this.maxCacheSize);
    }

    public void putCachedHeadConnections(String str, FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection) {
        synchronized (this.mCachedHeadConnections) {
            this.mCachedHeadConnections.put(str, fakeDownloadHeadHttpConnection);
        }
    }

    public void releaseDownloadConnection(String str) {
        FakeDownloadHttpConnection remove;
        synchronized (this.mCachedDownloadConnections) {
            remove = this.mCachedDownloadConnections.remove(str);
        }
        if (remove != null) {
            try {
                remove.end();
            } catch (Throwable unused) {
            }
        }
    }

    public void releaseHeadConnection(String str) {
        FakeDownloadHeadHttpConnection remove;
        synchronized (this.mCachedHeadConnections) {
            remove = this.mCachedHeadConnections.remove(str);
        }
        if (remove != null) {
            remove.cancel();
        }
    }

    public void setMaxCachedDownloadConnectionSize(int i10) {
        this.maxCacheSize = i10;
    }

    private DownloadConnectionPool() {
        this.mCachedHeadConnections = new HashMap();
        this.mCachedDownloadConnections = new LinkedHashMap(3);
        this.maxCacheSize = 3;
    }
}
