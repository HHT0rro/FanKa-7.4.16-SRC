package java.time.chrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Ser implements Externalizable {
    static final byte CHRONO_LOCAL_DATE_TIME_TYPE = 2;
    static final byte CHRONO_PERIOD_TYPE = 9;
    static final byte CHRONO_TYPE = 1;
    static final byte CHRONO_ZONE_DATE_TIME_TYPE = 3;
    static final byte HIJRAH_DATE_TYPE = 6;
    static final byte JAPANESE_DATE_TYPE = 4;
    static final byte JAPANESE_ERA_TYPE = 5;
    static final byte MINGUO_DATE_TYPE = 7;
    static final byte THAIBUDDHIST_DATE_TYPE = 8;
    private static final long serialVersionUID = -6103370247208168577L;
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

    private static void writeInternal(byte type, Object object, ObjectOutput out) throws IOException {
        out.writeByte(type);
        switch (type) {
            case 1:
                ((AbstractChronology) object).writeExternal(out);
                return;
            case 2:
                ((ChronoLocalDateTimeImpl) object).writeExternal(out);
                return;
            case 3:
                ((ChronoZonedDateTimeImpl) object).writeExternal(out);
                return;
            case 4:
                ((JapaneseDate) object).writeExternal(out);
                return;
            case 5:
                ((JapaneseEra) object).writeExternal(out);
                return;
            case 6:
                ((HijrahDate) object).writeExternal(out);
                return;
            case 7:
                ((MinguoDate) object).writeExternal(out);
                return;
            case 8:
                ((ThaiBuddhistDate) object).writeExternal(out);
                return;
            case 9:
                ((ChronoPeriodImpl) object).writeExternal(out);
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

    static Serializable read(ObjectInput in) throws IOException, ClassNotFoundException {
        byte type = in.readByte();
        return readInternal(type, in);
    }

    private static Serializable readInternal(byte type, ObjectInput in) throws IOException, ClassNotFoundException {
        switch (type) {
            case 1:
                return (Serializable) AbstractChronology.readExternal(in);
            case 2:
                return (Serializable) ChronoLocalDateTimeImpl.readExternal(in);
            case 3:
                return (Serializable) ChronoZonedDateTimeImpl.readExternal(in);
            case 4:
                return JapaneseDate.readExternal(in);
            case 5:
                return JapaneseEra.readExternal(in);
            case 6:
                return HijrahDate.readExternal(in);
            case 7:
                return MinguoDate.readExternal(in);
            case 8:
                return ThaiBuddhistDate.readExternal(in);
            case 9:
                return ChronoPeriodImpl.readExternal(in);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }
}
