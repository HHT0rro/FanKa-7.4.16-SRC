package com.alimm.tanx.core.view.player.cache.videocache;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ProxyCache {
    public static final Logger LOG = LoggerFactory.getLogger("ProxyCache");
    public static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    public final Cache cache;
    public final Source source;
    public volatile Thread sourceReaderThread;
    public volatile boolean stopped;

    /* renamed from: wc, reason: collision with root package name */
    public final Object f4188wc = new Object();
    public final Object stopLock = new Object();
    public volatile int percentsAvailable = -1;
    public final AtomicInteger readSourceErrorsCount = new AtomicInteger();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class SourceReaderRunnable implements Runnable {
        public SourceReaderRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProxyCache.this.readSource();
        }
    }

    public ProxyCache(Source source, Cache cache) {
        this.source = (Source) Preconditions.checkNotNull(source);
        this.cache = (Cache) Preconditions.checkNotNull(cache);
    }

    private void checkReadSourceErrorsCount() throws ProxyCacheException {
        int i10 = this.readSourceErrorsCount.get();
        if (i10 < 1) {
            return;
        }
        this.readSourceErrorsCount.set(0);
        throw new ProxyCacheException("Error reading source " + i10 + " times");
    }

    private void closeSource() {
        try {
            this.source.close();
        } catch (ProxyCacheException e2) {
            onError(new ProxyCacheException("Error closing source " + ((Object) this.source), e2));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.stopped;
    }

    private void notifyNewCacheDataAvailable(long j10, long j11) {
        onCacheAvailable(j10, j11);
        synchronized (this.f4188wc) {
            this.f4188wc.notifyAll();
        }
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readSource() {
        long j10 = -1;
        long j11 = 0;
        try {
            LOG.info("开始读取网络数据");
            j11 = this.cache.available();
            this.source.open(j11);
            j10 = this.source.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.source.read(bArr);
                if (read != -1) {
                    synchronized (this.stopLock) {
                        if (isStopped()) {
                            return;
                        } else {
                            this.cache.append(bArr, read);
                        }
                    }
                    j11 += read;
                    notifyNewCacheDataAvailable(j11, j10);
                } else {
                    tryComplete();
                    onSourceRead();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                Logger logger = LOG;
                logger.info("读取网络数据异常");
                this.readSourceErrorsCount.incrementAndGet();
                onError(th);
                logger.info("读取网络数据结束");
                closeSource();
                notifyNewCacheDataAvailable(j11, j10);
            } finally {
                LOG.info("读取网络数据结束");
                closeSource();
                notifyNewCacheDataAvailable(j11, j10);
            }
        }
    }

    private synchronized void readSourceAsync() throws ProxyCacheException {
        LOG.info("一步读取网络数据");
        boolean z10 = (this.sourceReaderThread == null || this.sourceReaderThread.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.stopped && !this.cache.isCompleted() && !z10) {
            this.sourceReaderThread = new Thread(new SourceReaderRunnable(), "Source reader for " + ((Object) this.source));
            this.sourceReaderThread.start();
        }
    }

    private void tryComplete() throws ProxyCacheException {
        synchronized (this.stopLock) {
            if (!isStopped() && this.cache.available() == this.source.length()) {
                this.cache.complete();
            }
        }
    }

    private void waitForSourceData() throws ProxyCacheException {
        synchronized (this.f4188wc) {
            try {
                try {
                    this.f4188wc.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onCacheAvailable(long j10, long j11) {
        int i10 = (j11 > 0L ? 1 : (j11 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j10) / ((float) j11)) * 100.0f);
        boolean z10 = i10 != this.percentsAvailable;
        if ((j11 >= 0) && z10) {
            onCachePercentsAvailableChanged(i10);
        }
        this.percentsAvailable = i10;
    }

    public void onCachePercentsAvailableChanged(int i10) {
    }

    public final void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            LOG.debug("ProxyCache is interrupted");
        } else {
            LOG.error("ProxyCache error", th);
        }
    }

    public int read(byte[] bArr, long j10, int i10) throws ProxyCacheException {
        ProxyCacheUtils.assertBuffer(bArr, j10, i10);
        while (!this.cache.isCompleted() && this.cache.available() < i10 + j10 && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        LOG.info("开始从缓存中读取数据");
        int read = this.cache.read(bArr, j10, i10);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        return read;
    }

    public void shutdown() {
        synchronized (this.stopLock) {
            LOG.info("Shutdown proxy for " + ((Object) this.source));
            try {
                this.stopped = true;
                if (this.sourceReaderThread != null) {
                    this.sourceReaderThread.interrupt();
                }
                this.cache.close();
            } catch (ProxyCacheException e2) {
                onError(e2);
            }
        }
    }
}
