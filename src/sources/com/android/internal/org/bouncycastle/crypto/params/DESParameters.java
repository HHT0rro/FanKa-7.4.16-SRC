package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.midi.MidiConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    private static byte[] DES_weak_keys = {1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, 14, 14, 14, 14, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_MIDI_TIME_CODE, MidiConstants.STATUS_MIDI_TIME_CODE, MidiConstants.STATUS_MIDI_TIME_CODE, MidiConstants.STATUS_MIDI_TIME_CODE, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, MidiConstants.STATUS_PITCH_BEND, 31, MidiConstants.STATUS_PITCH_BEND, 14, MidiConstants.STATUS_MIDI_TIME_CODE, 14, MidiConstants.STATUS_MIDI_TIME_CODE, 1, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 31, -2, 31, -2, 14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 1, 14, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_MIDI_TIME_CODE, -2, MidiConstants.STATUS_MIDI_TIME_CODE, -2, -2, 1, -2, 1, -2, 1, -2, 1, MidiConstants.STATUS_PITCH_BEND, 31, MidiConstants.STATUS_PITCH_BEND, 31, MidiConstants.STATUS_MIDI_TIME_CODE, 14, MidiConstants.STATUS_MIDI_TIME_CODE, 14, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 1, -2, 31, -2, 31, -2, 14, -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, -2, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_MIDI_TIME_CODE, -2, MidiConstants.STATUS_MIDI_TIME_CODE};
    private static final int N_DES_WEAK_KEYS = 16;

    public DESParameters(byte[] key) {
        super(key);
        if (isWeakKey(key, 0)) {
            throw new IllegalArgumentException("attempt to create weak DES key");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isWeakKey(byte[] r6, int r7) {
        /*
            int r0 = r6.length
            int r0 = r0 - r7
            r1 = 8
            if (r0 < r1) goto L26
            r0 = 0
        L7:
            r2 = 16
            if (r0 >= r2) goto L24
            r2 = 0
        Lc:
            if (r2 >= r1) goto L22
            int r3 = r2 + r7
            r3 = r6[r3]
            byte[] r4 = com.android.internal.org.bouncycastle.crypto.params.DESParameters.DES_weak_keys
            int r5 = r0 * 8
            int r5 = r5 + r2
            r4 = r4[r5]
            if (r3 == r4) goto L1f
        L1c:
            int r0 = r0 + 1
            goto L7
        L1f:
            int r2 = r2 + 1
            goto Lc
        L22:
            r1 = 1
            return r1
        L24:
            r0 = 0
            return r0
        L26:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "key material too short."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.org.bouncycastle.crypto.params.DESParameters.isWeakKey(byte[], int):boolean");
    }

    public static void setOddParity(byte[] bytes) {
        for (int i10 = 0; i10 < bytes.length; i10++) {
            int b4 = bytes[i10];
            bytes[i10] = (byte) ((b4 & 254) | (((((((((b4 >> 1) ^ (b4 >> 2)) ^ (b4 >> 3)) ^ (b4 >> 4)) ^ (b4 >> 5)) ^ (b4 >> 6)) ^ (b4 >> 7)) ^ 1) & 1));
        }
    }
}
