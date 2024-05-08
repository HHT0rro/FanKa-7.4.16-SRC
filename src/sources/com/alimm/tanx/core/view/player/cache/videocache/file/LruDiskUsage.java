package com.alimm.tanx.core.view.player.cache.videocache.file;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class LruDiskUsage implements DiskUsage {
    public static final Logger LOG = LoggerFactory.getLogger("LruDiskUsage");
    public final ExecutorService workerThread = Executors.newSingleThreadExecutor();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class TouchCallable implements Callable<Void> {
        public final File file;

        public TouchCallable(File file) {
            this.file = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            LruDiskUsage.this.touchInBackground(this.file);
            return null;
        }
    }

    private long countTotalSize(List<File> list) {
        Iterator<File> iterator2 = list.iterator2();
        long j10 = 0;
        while (iterator2.hasNext()) {
            j10 += iterator2.next().length();
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void touchInBackground(File file) throws IOException {
        Files.setLastModifiedNow(file);
        trim(Files.getLruListFiles(file.getParentFile()));
    }

    private void trim(List<File> list) {
        long countTotalSize = countTotalSize(list);
        int size = list.size();
        for (File file : list) {
            if (!accept(file, countTotalSize, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    countTotalSize -= length;
                    LOG.info("Cache file " + ((Object) file) + " is deleted because it exceeds cache limit");
                } else {
                    LOG.error("Error deleting file " + ((Object) file) + " for trimming cache");
                }
            }
        }
    }

    public abstract boolean accept(File file, long j10, int i10);

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage
    public void touch(File file) throws IOException {
        this.workerThread.submit(new TouchCallable(file));
    }
}
