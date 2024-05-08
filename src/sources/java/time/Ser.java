package java.time;

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
    static final byte DURATION_TYPE = 1;
    static final byte INSTANT_TYPE = 2;
    static final byte LOCAL_DATE_TIME_TYPE = 5;
    static final byte LOCAL_DATE_TYPE = 3;
    static final byte LOCAL_TIME_TYPE = 4;
    static final byte MONTH_DAY_TYPE = 13;
    static final byte OFFSET_DATE_TIME_TYPE = 10;
    static final byte OFFSET_TIME_TYPE = 9;
    static final byte PERIOD_TYPE = 14;
    static final byte YEAR_MONTH_TYPE = 12;
    static final byte YEAR_TYPE = 11;
    static final byte ZONE_DATE_TIME_TYPE = 6;
    static final byte ZONE_OFFSET_TYPE = 8;
    static final byte ZONE_REGION_TYPE = 7;
    private static final long serialVersionUID = -7683839454370182990L;
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

    static void writeInternal(byte type, Object object, ObjectOutput out) throws IOException {
        out.writeByte(type);
        switch (type) {
            case 1:
                ((Duration) object).writeExternal(out);
                return;
            case 2:
                ((Instant) object).writeExternal(out);
                return;
            case 3:
                ((LocalDate) object).writeExternal(out);
                return;
            case 4:
                ((LocalTime) object).writeExternal(out);
                return;
            case 5:
                ((LocalDateTime) object).writeExternal(out);
                return;
            case 6:
                ((ZonedDateTime) object).writeExternal(out);
                return;
            case 7:
                ((ZoneRegion) object).writeExternal(out);
                return;
            case 8:
                ((ZoneOffset) object).writeExternal(out);
                return;
            case 9:
                ((OffsetTime) object).writeExternal(out);
                return;
            case 10:
                ((OffsetDateTime) object).writeExternal(out);
                return;
            case 11:
                ((Year) object).writeExternal(out);
                return;
            case 12:
                ((YearMonth) object).writeExternal(out);
                return;
            case 13:
                ((MonthDay) object).writeExternal(out);
                return;
            case 14:
                ((Period) object).writeExternal(out);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Serializable read(ObjectInput in) throws IOException, ClassNotFoundException {
        byte type = in.readByte();
        return readInternal(type, in);
    }

    private static Serializable readInternal(byte type, ObjectInput in) throws IOException, ClassNotFoundException {
        switch (type) {
            case 1:
                return Duration.readExternal(in);
            case 2:
                return Instant.readExternal(in);
            case 3:
                return LocalDate.readExternal(in);
            case 4:
                return LocalTime.readExternal(in);
            case 5:
                return LocalDateTime.readExternal(in);
            case 6:
                return ZonedDateTime.readExternal(in);
            case 7:
                return ZoneRegion.readExternal(in);
            case 8:
                return ZoneOffset.readExternal(in);
            case 9:
                return OffsetTime.readExternal(in);
            case 10:
                return OffsetDateTime.readExternal(in);
            case 11:
                return Year.readExternal(in);
            case 12:
                return YearMonth.readExternal(in);
            case 13:
                return MonthDay.readExternal(in);
            case 14:
                return Period.readExternal(in);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }
}
