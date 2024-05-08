package com.alimm.tanx.core.view.player.cache.videocache;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileCache;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator;
import com.alimm.tanx.core.view.player.cache.videocache.file.Md5FileNameGenerator;
import com.alimm.tanx.core.view.player.cache.videocache.file.TotalCountLruDiskUsage;
import com.alimm.tanx.core.view.player.cache.videocache.file.TotalSizeLruDiskUsage;
import com.alimm.tanx.core.view.player.cache.videocache.headers.EmptyHeadersInjector;
import com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector;
import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpProxyCacheServer {
    public static final Logger LOG = LoggerFactory.getLogger("HttpProxyCacheServer");
    public static final String PROXY_HOST = "127.0.0.1";
    public final Object clientsLock;
    public final Map<String, HttpProxyCacheServerClients> clientsMap;
    public final Config config;
    public final Pinger pinger;
    public final int port;
    public final ServerSocket serverSocket;
    public final ExecutorService socketProcessor;
    public final Thread waitConnectionThread;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Builder {
        public static final long DEFAULT_MAX_SIZE = 536870912;
        public File cacheRoot;
        public DiskUsage diskUsage = new TotalSizeLruDiskUsage(DEFAULT_MAX_SIZE);
        public FileNameGenerator fileNameGenerator = new Md5FileNameGenerator();
        public HeaderInjector headerInjector = new EmptyHeadersInjector();
        public final SourceInfoStorage sourceInfoStorage;

        public Builder(Context context) {
            this.sourceInfoStorage = SourceInfoStorageFactory.newSourceInfoStorage(context);
            this.cacheRoot = StorageUtils.getIndividualCacheDirectory(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Config buildConfig() {
            return new Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
        }

        public HttpProxyCacheServer build() {
            return new HttpProxyCacheServer(buildConfig());
        }

        public Builder cacheDirectory(File file) {
            this.cacheRoot = (File) Preconditions.checkNotNull(file);
            return this;
        }

        public Builder diskUsage(DiskUsage diskUsage) {
            this.diskUsage = (DiskUsage) Preconditions.checkNotNull(diskUsage);
            return this;
        }

        public Builder fileNameGenerator(FileNameGenerator fileNameGenerator) {
            this.fileNameGenerator = (FileNameGenerator) Preconditions.checkNotNull(fileNameGenerator);
            return this;
        }

        public Builder headerInjector(HeaderInjector headerInjector) {
            this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
            return this;
        }

        public Builder maxCacheFilesCount(int i10) {
            this.diskUsage = new TotalCountLruDiskUsage(i10);
            return this;
        }

        public Builder maxCacheSize(long j10) {
            this.diskUsage = new TotalSizeLruDiskUsage(j10);
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class SocketProcessorRunnable implements Runnable {
        public final Socket socket;

        public SocketProcessorRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpProxyCacheServer.this.processSocket(this.socket);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class WaitRequestsRunnable implements Runnable {
        public final CountDownLatch startSignal;

        public WaitRequestsRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            HttpProxyCacheServer.this.waitForRequest();
        }
    }

    private String appendToProxyUrl(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", PROXY_HOST, Integer.valueOf(this.port), ProxyCacheUtils.encode(str));
    }

    private void closeSocket(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket", e2));
        }
    }

    private void closeSocketInput(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            LOG.debug("Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    private void closeSocketOutput(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e2) {
            LOG.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e2.getMessage());
        }
    }

    private HttpProxyCacheServerClients getClients(String str) throws ProxyCacheException {
        HttpProxyCacheServerClients httpProxyCacheServerClients;
        synchronized (this.clientsLock) {
            httpProxyCacheServerClients = this.clientsMap.get(str);
            if (httpProxyCacheServerClients == null) {
                httpProxyCacheServerClients = new HttpProxyCacheServerClients(str, this.config);
                this.clientsMap.put(str, httpProxyCacheServerClients);
            }
        }
        return httpProxyCacheServerClients;
    }

    private int getClientsCount() {
        int i10;
        synchronized (this.clientsLock) {
            Iterator<HttpProxyCacheServerClients> iterator2 = this.clientsMap.values().iterator2();
            i10 = 0;
            while (iterator2.hasNext()) {
                i10 += iterator2.next().getClientsCount();
            }
        }
        return i10;
    }

    private boolean isAlive() {
        return this.pinger.ping(3, 70);
    }

    private void onError(Throwable th) {
        LOG.error("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSocket(Socket socket) {
        try {
            try {
                GetRequest read = GetRequest.read(socket.getInputStream());
                Logger logger = LOG;
                logger.debug("Request to cache proxy:" + ((Object) read));
                String decode = ProxyCacheUtils.decode(read.uri);
                logger.info("此时的url为：" + decode);
                if (this.pinger.isPingRequest(decode)) {
                    this.pinger.responseToPing(socket);
                } else {
                    getClients(decode).processRequest(read, socket);
                }
                releaseSocket(socket);
                logger.debug("Opened connections: " + getClientsCount());
            } catch (ProxyCacheException e2) {
                e = e2;
                onError(new ProxyCacheException("Error processing request", e));
                releaseSocket(socket);
                LOG.debug("Opened connections: " + getClientsCount());
            } catch (SocketException unused) {
                Logger logger2 = LOG;
                logger2.debug("Closing socket… Socket is closed by client.");
                releaseSocket(socket);
                logger2.debug("Opened connections: " + getClientsCount());
            } catch (IOException e10) {
                e = e10;
                onError(new ProxyCacheException("Error processing request", e));
                releaseSocket(socket);
                LOG.debug("Opened connections: " + getClientsCount());
            }
        } catch (Throwable th) {
            releaseSocket(socket);
            LOG.debug("Opened connections: " + getClientsCount());
            throw th;
        }
    }

    private void releaseSocket(Socket socket) {
        closeSocketInput(socket);
        closeSocketOutput(socket);
        closeSocket(socket);
    }

    private void shutdownClients() {
        synchronized (this.clientsLock) {
            Iterator<HttpProxyCacheServerClients> iterator2 = this.clientsMap.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().shutdown();
            }
            this.clientsMap.clear();
        }
    }

    private void touchFileSafely(File file) {
        try {
            this.config.diskUsage.touch(file);
        } catch (IOException e2) {
            LOG.error("Error touching file " + ((Object) file), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForRequest() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.serverSocket.accept();
                LOG.info("Accept new socket " + ((Object) accept));
                this.socketProcessor.submit(new SocketProcessorRunnable(accept));
            } catch (IOException e2) {
                onError(new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    public File getCacheFile(String str) {
        Config config = this.config;
        return new File(config.cacheRoot, config.fileNameGenerator.generate(str));
    }

    public File getCacheRoot() {
        return this.config.cacheRoot;
    }

    public String getProxyUrl(String str) {
        return getProxyUrl(str, true);
    }

    public File getTempCacheFile(String str) {
        return new File(this.config.cacheRoot, this.config.fileNameGenerator.generate(str) + FileCache.TEMP_POSTFIX);
    }

    public boolean isCached(String str) {
        Preconditions.checkNotNull(str, "Url can't be null!");
        return getCacheFile(str).exists();
    }

    public void registerCacheListener(CacheListener cacheListener, String str) {
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).registerCacheListener(cacheListener);
            } catch (ProxyCacheException e2) {
                LOG.warn("Error registering cache listener", e2);
            }
        }
    }

    public void shutdown() {
        LOG.info("Shutdown proxy server");
        shutdownClients();
        this.config.sourceInfoStorage.release();
        this.waitConnectionThread.interrupt();
        try {
            if (this.serverSocket.isClosed()) {
                return;
            }
            this.serverSocket.close();
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error shutting down proxy server", e2));
        }
    }

    public void unregisterCacheListener(CacheListener cacheListener, String str) {
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).unregisterCacheListener(cacheListener);
            } catch (ProxyCacheException e2) {
                LOG.warn("Error registering cache listener", e2);
            }
        }
    }

    public HttpProxyCacheServer(Context context) {
        this(new Builder(context).buildConfig());
    }

    public String getProxyUrl(String str, boolean z10) {
        if (!z10 || !isCached(str)) {
            return isAlive() ? appendToProxyUrl(str) : str;
        }
        File cacheFile = getCacheFile(str);
        touchFileSafely(cacheFile);
        return Uri.fromFile(cacheFile).toString();
    }

    public HttpProxyCacheServer(Config config) {
        this.clientsLock = new Object();
        this.socketProcessor = Executors.newFixedThreadPool(8);
        this.clientsMap = new ConcurrentHashMap();
        this.config = (Config) Preconditions.checkNotNull(config);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(PROXY_HOST));
            this.serverSocket = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            IgnoreHostProxySelector.install(PROXY_HOST, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new WaitRequestsRunnable(countDownLatch));
            this.waitConnectionThread = thread;
            thread.start();
            countDownLatch.await();
            this.pinger = new Pinger(PROXY_HOST, localPort);
            LogUtils.d("Proxy cache server started. Is it alive? " + isAlive(), new String[0]);
        } catch (IOException | InterruptedException e2) {
            this.socketProcessor.shutdown();
            LogUtils.e("Error starting local proxy server", e2);
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    public void unregisterCacheListener(CacheListener cacheListener) {
        Preconditions.checkNotNull(cacheListener);
        synchronized (this.clientsLock) {
            Iterator<HttpProxyCacheServerClients> iterator2 = this.clientsMap.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().unregisterCacheListener(cacheListener);
            }
        }
    }
}
