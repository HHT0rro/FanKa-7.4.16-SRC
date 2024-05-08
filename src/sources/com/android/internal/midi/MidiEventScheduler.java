package com.android.internal.midi;

import android.media.midi.MidiReceiver;
import com.android.internal.midi.EventScheduler;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MidiEventScheduler extends EventScheduler {
    private static final int POOL_EVENT_SIZE = 16;
    private static final String TAG = "MidiEventScheduler";
    private MidiReceiver mReceiver = new SchedulingReceiver();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class SchedulingReceiver extends MidiReceiver {
        private SchedulingReceiver() {
        }

        @Override // android.media.midi.MidiReceiver
        public void onSend(byte[] msg, int offset, int count, long timestamp) throws IOException {
            MidiEvent event = MidiEventScheduler.this.createScheduledEvent(msg, offset, count, timestamp);
            if (event != null) {
                MidiEventScheduler.this.add(event);
            }
        }

        @Override // android.media.midi.MidiReceiver
        public void onFlush() {
            MidiEventScheduler.this.flush();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class MidiEvent extends EventScheduler.SchedulableEvent {
        public int count;
        public byte[] data;

        private MidiEvent(int count) {
            super(0L);
            this.count = 0;
            this.data = new byte[count];
        }

        private MidiEvent(byte[] msg, int offset, int count, long timestamp) {
            super(timestamp);
            this.count = 0;
            byte[] bArr = new byte[count];
            this.data = bArr;
            System.arraycopy((Object) msg, offset, (Object) bArr, 0, count);
            this.count = count;
        }

        public String toString() {
            String text = "Event: ";
            for (int i10 = 0; i10 < this.count; i10++) {
                text = text + ((int) this.data[i10]) + ", ";
            }
            return text;
        }
    }

    public MidiEvent createScheduledEvent(byte[] msg, int offset, int count, long timestamp) {
        MidiEvent event;
        int i10 = 16;
        if (count > 16) {
            return new MidiEvent(msg, offset, count, timestamp);
        }
        MidiEvent event2 = (MidiEvent) removeEventfromPool();
        if (event2 != null) {
            event = event2;
        } else {
            event = new MidiEvent(i10);
        }
        System.arraycopy((Object) msg, offset, (Object) event.data, 0, count);
        event.count = count;
        event.setTimestamp(timestamp);
        return event;
    }

    @Override // com.android.internal.midi.EventScheduler
    public void addEventToPool(EventScheduler.SchedulableEvent event) {
        if (event instanceof MidiEvent) {
            MidiEvent midiEvent = (MidiEvent) event;
            if (midiEvent.data.length == 16) {
                super.addEventToPool(event);
            }
        }
    }

    public MidiReceiver getReceiver() {
        return this.mReceiver;
    }
}
