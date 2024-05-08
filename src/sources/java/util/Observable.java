package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(since = "9")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Observable {
    private boolean changed = false;
    private Vector<Observer> obs = new Vector<>();

    public synchronized void addObserver(Observer o10) {
        if (o10 == null) {
            throw new NullPointerException();
        }
        if (!this.obs.contains(o10)) {
            this.obs.addElement(o10);
        }
    }

    public synchronized void deleteObserver(Observer o10) {
        this.obs.removeElement(o10);
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object arg) {
        synchronized (this) {
            if (hasChanged()) {
                Object[] arrLocal = this.obs.toArray();
                clearChanged();
                for (int i10 = arrLocal.length - 1; i10 >= 0; i10--) {
                    ((Observer) arrLocal[i10]).update(this, arg);
                }
            }
        }
    }

    public synchronized void deleteObservers() {
        this.obs.removeAllElements();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void setChanged() {
        this.changed = true;
    }

    protected synchronized void clearChanged() {
        this.changed = false;
    }

    public synchronized boolean hasChanged() {
        return this.changed;
    }

    public synchronized int countObservers() {
        return this.obs.size();
    }
}
