package com.alimm.tanx.core.view.player.cache.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileCache;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class HttpProxyCacheServerClients {
    public final AtomicInteger clientsCount = new AtomicInteger(0);
    public final Config config;
    public final List<CacheListener> listeners;
    public volatile HttpProxyCache proxyCache;
    public final CacheListener uiCacheListener;
    public final String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class UiListenerHandler extends Handler implements CacheListener {
        public final List<CacheListener> listeners;
        public final String url;

        public UiListenerHandler(String str, List<CacheListener> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.listeners = list;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<CacheListener> iterator2 = this.listeners.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onCacheAvailable((File) message.obj, this.url, message.arg1);
            }
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.CacheListener
        public void onCacheAvailable(File file, String str, int i10) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i10;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    public HttpProxyCacheServerClients(String str, Config config) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.listeners = copyOnWriteArrayList;
        this.url = (String) Preconditions.checkNotNull(str);
        this.config = (Config) Preconditions.checkNotNull(config);
        this.uiCacheListener = new UiListenerHandler(str, copyOnWriteArrayList);
    }

    private synchronized void finishProcessRequest() {
        if (this.clientsCount.decrementAndGet() <= 0) {
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
    }

    private HttpProxyCache newHttpProxyCache() throws ProxyCacheException {
        String str = this.url;
        Config config = this.config;
        HttpProxyCache httpProxyCache = new HttpProxyCache(new HttpUrlSource(str, config.sourceInfoStorage, config.headerInjector), new FileCache(this.config.generateCacheFile(this.url), this.config.diskUsage));
        httpProxyCache.registerCacheListener(this.uiCacheListener);
        return httpProxyCache;
    }

    private synchronized void startProcessRequest() throws ProxyCacheException {
        this.proxyCache = this.proxyCache == null ? newHttpProxyCache() : this.proxyCache;
    }

    public int getClientsCount() {
        return this.clientsCount.get();
    }

    public void processRequest(GetRequest getRequest, Socket socket) throws ProxyCacheException, IOException {
        startProcessRequest();
        try {
            this.clientsCount.incrementAndGet();
            this.proxyCache.processRequest(getRequest, socket);
        } finally {
            finishProcessRequest();
        }
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listeners.add(cacheListener);
    }

    public void shutdown() {
        this.listeners.clear();
        if (this.proxyCache != null) {
            this.proxyCache.registerCacheListener(null);
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
        this.clientsCount.set(0);
    }

    public void unregisterCacheListener(CacheListener cacheListener) {
        this.listeners.remove(cacheListener);
    }
}
