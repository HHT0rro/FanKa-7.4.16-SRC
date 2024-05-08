package javax.crypto.spec;

import com.android.internal.midi.MidiConstants;
import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DESKeySpec implements KeySpec {
    public static final int DES_KEY_LEN = 8;
    private static final byte[][] WEAK_KEYS = {new byte[]{1, 1, 1, 1, 1, 1, 1, 1}, new byte[]{-2, -2, -2, -2, -2, -2, -2, -2}, new byte[]{31, 31, 31, 31, 14, 14, 14, 14}, new byte[]{MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_PITCH_BEND, MidiConstants.STATUS_MIDI_TIME_CODE, MidiConstants.STATUS_MIDI_TIME_CODE, MidiConstants.STATUS_MIDI_TIME_CODE, MidiConstants.STATUS_MIDI_TIME_CODE}, new byte[]{1, -2, 1, -2, 1, -2, 1, -2}, new byte[]{31, MidiConstants.STATUS_PITCH_BEND, 31, MidiConstants.STATUS_PITCH_BEND, 14, MidiConstants.STATUS_MIDI_TIME_CODE, 14, MidiConstants.STATUS_MIDI_TIME_CODE}, new byte[]{1, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 1, MidiConstants.STATUS_MIDI_TIME_CODE}, new byte[]{31, -2, 31, -2, 14, -2, 14, -2}, new byte[]{1, 31, 1, 31, 1, 14, 1, 14}, new byte[]{MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_MIDI_TIME_CODE, -2, MidiConstants.STATUS_MIDI_TIME_CODE, -2}, new byte[]{-2, 1, -2, 1, -2, 1, -2, 1}, new byte[]{MidiConstants.STATUS_PITCH_BEND, 31, MidiConstants.STATUS_PITCH_BEND, 31, MidiConstants.STATUS_MIDI_TIME_CODE, 14, MidiConstants.STATUS_MIDI_TIME_CODE, 14}, new byte[]{MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_PITCH_BEND, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 1, MidiConstants.STATUS_MIDI_TIME_CODE, 1}, new byte[]{-2, 31, -2, 31, -2, 14, -2, 14}, new byte[]{31, 1, 31, 1, 14, 1, 14, 1}, new byte[]{-2, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_PITCH_BEND, -2, MidiConstants.STATUS_MIDI_TIME_CODE, -2, MidiConstants.STATUS_MIDI_TIME_CODE}};
    private byte[] key;

    public DESKeySpec(byte[] key) throws InvalidKeyException {
        this(key, 0);
    }

    public DESKeySpec(byte[] key, int offset) throws InvalidKeyException {
        if (key.length - offset < 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        byte[] bArr = new byte[8];
        this.key = bArr;
        System.arraycopy((Object) key, offset, (Object) bArr, 0, 8);
    }

    public byte[] getKey() {
        return (byte[]) this.key.clone();
    }

    public static boolean isParityAdjusted(byte[] key, int offset) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("null key");
        }
        if (key.length - offset < 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        int i10 = 0;
        while (i10 < 8) {
            int offset2 = offset + 1;
            int k10 = Integer.bitCount(key[offset] & 255);
            if ((k10 & 1) != 0) {
                i10++;
                offset = offset2;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isWeak(byte[] key, int offset) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("null key");
        }
        if (key.length - offset < 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        for (int i10 = 0; i10 < WEAK_KEYS.length; i10++) {
            boolean found = true;
            for (int j10 = 0; j10 < 8 && found; j10++) {
                if (WEAK_KEYS[i10][j10] != key[j10 + offset]) {
                    found = false;
                }
            }
            if (found) {
                return found;
            }
        }
        return false;
    }
}
