package com.android.internal.midi;

import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MidiEventMultiScheduler {
    private MultiLockMidiEventScheduler[] mMidiEventSchedulers;
    private int mNumEventSchedulers;
    private int mNumClosedSchedulers = 0;
    private final Object mMultiLock = new Object();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class MultiLockMidiEventScheduler extends MidiEventScheduler {
        private MultiLockMidiEventScheduler() {
        }

        @Override // com.android.internal.midi.EventScheduler
        public void close() {
            synchronized (MidiEventMultiScheduler.this.mMultiLock) {
                MidiEventMultiScheduler.this.mNumClosedSchedulers++;
            }
            super.close();
        }

        @Override // com.android.internal.midi.EventScheduler
        protected Object getLock() {
            return MidiEventMultiScheduler.this.mMultiLock;
        }

        public boolean isEventBufferEmptyLocked() {
            return this.mEventBuffer.isEmpty();
        }

        public long getLowestTimeLocked() {
            return this.mEventBuffer.firstKey().longValue();
        }
    }

    public MidiEventMultiScheduler(int numSchedulers) {
        this.mNumEventSchedulers = numSchedulers;
        this.mMidiEventSchedulers = new MultiLockMidiEventScheduler[numSchedulers];
        for (int i10 = 0; i10 < numSchedulers; i10++) {
            this.mMidiEventSchedulers[i10] = new MultiLockMidiEventScheduler();
        }
    }

    public boolean waitNextEvent() throws InterruptedException {
        synchronized (this.mMultiLock) {
            while (true) {
                if (this.mNumClosedSchedulers >= this.mNumEventSchedulers) {
                    return false;
                }
                long lowestTime = Long.MAX_VALUE;
                long now = System.nanoTime();
                for (MultiLockMidiEventScheduler eventScheduler : this.mMidiEventSchedulers) {
                    if (!eventScheduler.isEventBufferEmptyLocked()) {
                        lowestTime = Math.min(lowestTime, eventScheduler.getLowestTimeLocked());
                    }
                }
                if (lowestTime <= now) {
                    return true;
                }
                long nanosToWait = lowestTime - now;
                long millisToWait = (nanosToWait / 1000000) + 1;
                if (millisToWait > ZipUtils.UPPER_UNIXTIME_BOUND) {
                    millisToWait = ZipUtils.UPPER_UNIXTIME_BOUND;
                }
                this.mMultiLock.wait(millisToWait);
            }
        }
    }

    public int getNumEventSchedulers() {
        return this.mNumEventSchedulers;
    }

    public MidiEventScheduler getEventScheduler(int index) {
        return this.mMidiEventSchedulers[index];
    }

    public void close() {
        for (MidiEventScheduler eventScheduler : this.mMidiEventSchedulers) {
            eventScheduler.close();
        }
    }
}
