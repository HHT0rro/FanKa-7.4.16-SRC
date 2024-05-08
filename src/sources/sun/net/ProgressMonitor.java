package sun.net;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ProgressMonitor {
    private static ProgressMeteringPolicy meteringPolicy = new DefaultProgressMeteringPolicy();
    private static ProgressMonitor pm = new ProgressMonitor();
    private ArrayList<ProgressSource> progressSourceList = new ArrayList<>();
    private ArrayList<ProgressListener> progressListenerList = new ArrayList<>();

    public static synchronized ProgressMonitor getDefault() {
        ProgressMonitor progressMonitor;
        synchronized (ProgressMonitor.class) {
            progressMonitor = pm;
        }
        return progressMonitor;
    }

    public static synchronized void setDefault(ProgressMonitor m10) {
        synchronized (ProgressMonitor.class) {
            if (m10 != null) {
                pm = m10;
            }
        }
    }

    public static synchronized void setMeteringPolicy(ProgressMeteringPolicy policy) {
        synchronized (ProgressMonitor.class) {
            if (policy != null) {
                meteringPolicy = policy;
            }
        }
    }

    public ArrayList<ProgressSource> getProgressSources() {
        ArrayList<ProgressSource> snapshot = new ArrayList<>();
        try {
            synchronized (this.progressSourceList) {
                Iterator<ProgressSource> iter = this.progressSourceList.iterator2();
                while (iter.hasNext()) {
                    ProgressSource pi = iter.next();
                    snapshot.add((ProgressSource) pi.clone());
                }
            }
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        return snapshot;
    }

    public synchronized int getProgressUpdateThreshold() {
        return meteringPolicy.getProgressUpdateThreshold();
    }

    public boolean shouldMeterInput(URL url, String method) {
        return meteringPolicy.shouldMeterInput(url, method);
    }

    public void registerSource(ProgressSource pi) {
        synchronized (this.progressSourceList) {
            if (this.progressSourceList.contains(pi)) {
                return;
            }
            this.progressSourceList.add(pi);
            if (this.progressListenerList.size() > 0) {
                ArrayList<ProgressListener> listeners = new ArrayList<>();
                synchronized (this.progressListenerList) {
                    Iterator<ProgressListener> iter = this.progressListenerList.iterator2();
                    while (iter.hasNext()) {
                        listeners.add(iter.next());
                    }
                }
                Iterator<ProgressListener> iter2 = listeners.iterator2();
                while (iter2.hasNext()) {
                    ProgressListener pl = iter2.next();
                    ProgressEvent pe = new ProgressEvent(pi, pi.getURL(), pi.getMethod(), pi.getContentType(), pi.getState(), pi.getProgress(), pi.getExpected());
                    pl.progressStart(pe);
                }
            }
        }
    }

    public void unregisterSource(ProgressSource pi) {
        synchronized (this.progressSourceList) {
            if (this.progressSourceList.contains(pi)) {
                pi.close();
                this.progressSourceList.remove(pi);
                if (this.progressListenerList.size() > 0) {
                    ArrayList<ProgressListener> listeners = new ArrayList<>();
                    synchronized (this.progressListenerList) {
                        Iterator<ProgressListener> iter = this.progressListenerList.iterator2();
                        while (iter.hasNext()) {
                            listeners.add(iter.next());
                        }
                    }
                    Iterator<ProgressListener> iter2 = listeners.iterator2();
                    while (iter2.hasNext()) {
                        ProgressListener pl = iter2.next();
                        ProgressEvent pe = new ProgressEvent(pi, pi.getURL(), pi.getMethod(), pi.getContentType(), pi.getState(), pi.getProgress(), pi.getExpected());
                        pl.progressFinish(pe);
                    }
                }
            }
        }
    }

    public void updateProgress(ProgressSource pi) {
        synchronized (this.progressSourceList) {
            if (this.progressSourceList.contains(pi)) {
                if (this.progressListenerList.size() > 0) {
                    ArrayList<ProgressListener> listeners = new ArrayList<>();
                    synchronized (this.progressListenerList) {
                        Iterator<ProgressListener> iter = this.progressListenerList.iterator2();
                        while (iter.hasNext()) {
                            listeners.add(iter.next());
                        }
                    }
                    Iterator<ProgressListener> iter2 = listeners.iterator2();
                    while (iter2.hasNext()) {
                        ProgressListener pl = iter2.next();
                        ProgressEvent pe = new ProgressEvent(pi, pi.getURL(), pi.getMethod(), pi.getContentType(), pi.getState(), pi.getProgress(), pi.getExpected());
                        pl.progressUpdate(pe);
                    }
                }
            }
        }
    }

    public void addProgressListener(ProgressListener l10) {
        synchronized (this.progressListenerList) {
            this.progressListenerList.add(l10);
        }
    }

    public void removeProgressListener(ProgressListener l10) {
        synchronized (this.progressListenerList) {
            this.progressListenerList.remove(l10);
        }
    }
}
