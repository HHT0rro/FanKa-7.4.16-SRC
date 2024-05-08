package java.time.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.time.ZoneOffset;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Ser implements Externalizable {
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    static final byte ZRULES = 1;
    private static final long serialVersionUID = -8885321777449118786L;
    private Serializable object;
    private byte type;

    public Ser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ser(byte type, Serializable object) {
        this.type = type;
        this.object = object;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        writeInternal(this.type, this.object, out);
    }

    static void write(Object object, DataOutput out) throws IOException {
        writeInternal((byte) 1, object, out);
    }

    private static void writeInternal(byte type, Object object, DataOutput out) throws IOException {
        out.writeByte(type);
        switch (type) {
            case 1:
                ((ZoneRules) object).writeExternal(out);
                return;
            case 2:
                ((ZoneOffsetTransition) object).writeExternal(out);
                return;
            case 3:
                ((ZoneOffsetTransitionRule) object).writeExternal(out);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        byte readByte = in.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, in);
    }

    static Serializable read(DataInput in) throws IOException, ClassNotFoundException {
        byte type = in.readByte();
        return readInternal(type, in);
    }

    private static Serializable readInternal(byte type, DataInput in) throws IOException, ClassNotFoundException {
        switch (type) {
            case 1:
                return ZoneRules.readExternal(in);
            case 2:
                return ZoneOffsetTransition.readExternal(in);
            case 3:
                return ZoneOffsetTransitionRule.readExternal(in);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeOffset(ZoneOffset offset, DataOutput out) throws IOException {
        int offsetSecs = offset.getTotalSeconds();
        int offsetByte = offsetSecs % 900 == 0 ? offsetSecs / 900 : 127;
        out.writeByte(offsetByte);
        if (offsetByte == 127) {
            out.writeInt(offsetSecs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readOffset(DataInput in) throws IOException {
        int offsetByte = in.readByte();
        return ZoneOffset.ofTotalSeconds(offsetByte == 127 ? in.readInt() : offsetByte * 900);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeEpochSec(long epochSec, DataOutput out) throws IOException {
        if (epochSec >= -4575744000L && epochSec < 10413792000L && epochSec % 900 == 0) {
            int store = (int) ((4575744000L + epochSec) / 900);
            out.writeByte((store >>> 16) & 255);
            out.writeByte(255 & (store >>> 8));
            out.writeByte(store & 255);
            return;
        }
        out.writeByte(255);
        out.writeLong(epochSec);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long readEpochSec(DataInput in) throws IOException {
        int hiByte = in.readByte() & 255;
        if (hiByte == 255) {
            return in.readLong();
        }
        int midByte = in.readByte() & 255;
        int loByte = 255 & in.readByte();
        long tot = (hiByte << 16) + (midByte << 8) + loByte;
        return (900 * tot) - 4575744000L;
    }
}
