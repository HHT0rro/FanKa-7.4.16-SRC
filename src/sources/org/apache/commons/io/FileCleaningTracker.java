package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileCleaningTracker {
    public Thread reaper;

    /* renamed from: q, reason: collision with root package name */
    public ReferenceQueue<Object> f52395q = new ReferenceQueue<>();
    public final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet());
    public final List<String> deleteFailures = Collections.synchronizedList(new ArrayList());
    public volatile boolean exitWhenFinished = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class Reaper extends Thread {
        public Reaper() {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (FileCleaningTracker.this.exitWhenFinished && FileCleaningTracker.this.trackers.size() <= 0) {
                    return;
                }
                try {
                    Tracker tracker = (Tracker) FileCleaningTracker.this.f52395q.remove();
                    FileCleaningTracker.this.trackers.remove(tracker);
                    if (!tracker.delete()) {
                        FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
                    }
                    tracker.clear();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Tracker extends PhantomReference<Object> {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        public Tracker(String str, FileDeleteStrategy fileDeleteStrategy, Object obj, ReferenceQueue<? super Object> referenceQueue) {
            super(obj, referenceQueue);
            this.path = str;
            this.deleteStrategy = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }

        public String getPath() {
            return this.path;
        }
    }

    private synchronized void addTracker(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (!this.exitWhenFinished) {
            if (this.reaper == null) {
                Reaper reaper = new Reaper();
                this.reaper = reaper;
                reaper.start();
            }
            this.trackers.add(new Tracker(str, fileDeleteStrategy, obj, this.f52395q));
        } else {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
    }

    public synchronized void exitWhenFinished() {
        this.exitWhenFinished = true;
        Thread thread = this.reaper;
        if (thread != null) {
            synchronized (thread) {
                this.reaper.interrupt();
            }
        }
    }

    public List<String> getDeleteFailures() {
        return this.deleteFailures;
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public void track(File file, Object obj) {
        track(file, obj, (FileDeleteStrategy) null);
    }

    public void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        Objects.requireNonNull(file, "The file must not be null");
        addTracker(file.getPath(), obj, fileDeleteStrategy);
    }

    public void track(String str, Object obj) {
        track(str, obj, (FileDeleteStrategy) null);
    }

    public void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        Objects.requireNonNull(str, "The path must not be null");
        addTracker(str, obj, fileDeleteStrategy);
    }
}
