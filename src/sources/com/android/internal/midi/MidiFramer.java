package com.android.internal.midi;

import android.media.midi.MidiReceiver;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MidiFramer extends MidiReceiver {
    public String TAG = "MidiFramer";
    private byte[] mBuffer = new byte[3];
    private int mCount;
    private boolean mInSysEx;
    private int mNeeded;
    private MidiReceiver mReceiver;
    private byte mRunningStatus;

    public MidiFramer(MidiReceiver receiver) {
        this.mReceiver = receiver;
    }

    public static String formatMidiData(byte[] data, int offset, int count) {
        String text = "MIDI+" + offset + " : ";
        for (int i10 = 0; i10 < count; i10++) {
            text = text + String.format("0x%02X, ", Byte.valueOf(data[offset + i10]));
        }
        return text;
    }

    @Override // android.media.midi.MidiReceiver
    public void onSend(byte[] data, int offset, int count, long timestamp) throws IOException {
        int sysExStartOffset;
        int sysExStartOffset2 = this.mInSysEx ? offset : -1;
        int sysExStartOffset3 = sysExStartOffset2;
        int sysExStartOffset4 = offset;
        for (int i10 = 0; i10 < count; i10++) {
            byte currentByte = data[sysExStartOffset4];
            int currentInt = currentByte & 255;
            if (currentInt >= 128) {
                if (currentInt < 240) {
                    this.mRunningStatus = currentByte;
                    this.mCount = 1;
                    this.mNeeded = MidiConstants.getBytesPerMessage(currentByte) - 1;
                } else if (currentInt < 248) {
                    if (currentInt == 240) {
                        this.mInSysEx = true;
                        sysExStartOffset3 = sysExStartOffset4;
                    } else if (currentInt == 247) {
                        if (this.mInSysEx) {
                            this.mReceiver.send(data, sysExStartOffset3, (sysExStartOffset4 - sysExStartOffset3) + 1, timestamp);
                            this.mInSysEx = false;
                            sysExStartOffset3 = -1;
                        }
                    } else {
                        this.mBuffer[0] = currentByte;
                        this.mRunningStatus = (byte) 0;
                        this.mCount = 1;
                        this.mNeeded = MidiConstants.getBytesPerMessage(currentByte) - 1;
                    }
                } else {
                    if (!this.mInSysEx) {
                        sysExStartOffset = sysExStartOffset3;
                    } else {
                        this.mReceiver.send(data, sysExStartOffset3, sysExStartOffset4 - sysExStartOffset3, timestamp);
                        sysExStartOffset = sysExStartOffset4 + 1;
                    }
                    this.mReceiver.send(data, sysExStartOffset4, 1, timestamp);
                    sysExStartOffset3 = sysExStartOffset;
                }
            } else if (this.mInSysEx) {
                continue;
            } else {
                int i11 = this.mNeeded;
                if (i11 <= 0) {
                    break;
                }
                byte[] bArr = this.mBuffer;
                int i12 = this.mCount;
                int i13 = i12 + 1;
                this.mCount = i13;
                bArr[i12] = currentByte;
                int i14 = i11 - 1;
                this.mNeeded = i14;
                if (i14 == 0) {
                    byte b4 = this.mRunningStatus;
                    if (b4 != 0) {
                        bArr[0] = b4;
                    }
                    this.mReceiver.send(bArr, 0, i13, timestamp);
                    this.mNeeded = MidiConstants.getBytesPerMessage(this.mBuffer[0]) - 1;
                    this.mCount = 1;
                }
            }
            sysExStartOffset4++;
        }
        if (sysExStartOffset3 >= 0 && sysExStartOffset3 < sysExStartOffset4) {
            this.mReceiver.send(data, sysExStartOffset3, sysExStartOffset4 - sysExStartOffset3, timestamp);
        }
    }
}
