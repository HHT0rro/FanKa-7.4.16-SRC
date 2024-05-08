package com.android.internal.midi;

import android.media.midi.MidiReceiver;
import android.media.midi.MidiSender;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class MidiDispatcher extends MidiReceiver {
    private final MidiReceiverFailureHandler mFailureHandler;
    private final CopyOnWriteArrayList<MidiReceiver> mReceivers;
    private final MidiSender mSender;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface MidiReceiverFailureHandler {
        void onReceiverFailure(MidiReceiver midiReceiver, IOException iOException);
    }

    public MidiDispatcher() {
        this(null);
    }

    public MidiDispatcher(MidiReceiverFailureHandler failureHandler) {
        this.mReceivers = new CopyOnWriteArrayList<>();
        this.mSender = new MidiSender() { // from class: com.android.internal.midi.MidiDispatcher.1
            @Override // android.media.midi.MidiSender
            public void onConnect(MidiReceiver receiver) {
                MidiDispatcher.this.mReceivers.add(receiver);
            }

            @Override // android.media.midi.MidiSender
            public void onDisconnect(MidiReceiver receiver) {
                MidiDispatcher.this.mReceivers.remove(receiver);
            }
        };
        this.mFailureHandler = failureHandler;
    }

    public int getReceiverCount() {
        return this.mReceivers.size();
    }

    public MidiSender getSender() {
        return this.mSender;
    }

    @Override // android.media.midi.MidiReceiver
    public void onSend(byte[] msg, int offset, int count, long timestamp) throws IOException {
        Iterator<MidiReceiver> iterator2 = this.mReceivers.iterator2();
        while (iterator2.hasNext()) {
            MidiReceiver receiver = iterator2.next();
            try {
                receiver.send(msg, offset, count, timestamp);
            } catch (IOException e2) {
                this.mReceivers.remove(receiver);
                if (this.mFailureHandler != null) {
                    this.mFailureHandler.onReceiverFailure(receiver, e2);
                }
            }
        }
    }

    @Override // android.media.midi.MidiReceiver
    public void onFlush() throws IOException {
        Iterator<MidiReceiver> iterator2 = this.mReceivers.iterator2();
        while (iterator2.hasNext()) {
            MidiReceiver receiver = iterator2.next();
            try {
                receiver.flush();
            } catch (IOException e2) {
                this.mReceivers.remove(receiver);
                if (this.mFailureHandler != null) {
                    this.mFailureHandler.onReceiverFailure(receiver, e2);
                }
            }
        }
    }
}
