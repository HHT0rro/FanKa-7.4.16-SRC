package java.time;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesException;
import java.time.zone.ZoneRulesProvider;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ZoneRegion extends ZoneId implements Serializable {
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: id, reason: collision with root package name */
    private final String f50420id;
    private final transient ZoneRules rules;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRegion ofId(String zoneId, boolean checkAvailable) {
        Objects.requireNonNull(zoneId, "zoneId");
        checkName(zoneId);
        ZoneRules rules = null;
        try {
            rules = ZoneRulesProvider.getRules(zoneId, true);
        } catch (ZoneRulesException ex) {
            if (checkAvailable) {
                throw ex;
            }
        }
        return new ZoneRegion(zoneId, rules);
    }

    private static void checkName(String zoneId) {
        int n10 = zoneId.length();
        if (n10 < 2) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + zoneId);
        }
        for (int i10 = 0; i10 < n10; i10++) {
            char c4 = zoneId.charAt(i10);
            if ((c4 < 'a' || c4 > 'z') && ((c4 < 'A' || c4 > 'Z') && ((c4 != '/' || i10 == 0) && ((c4 < '0' || c4 > '9' || i10 == 0) && ((c4 != '~' || i10 == 0) && ((c4 != '.' || i10 == 0) && ((c4 != '_' || i10 == 0) && ((c4 != '+' || i10 == 0) && (c4 != '-' || i10 == 0))))))))) {
                throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + zoneId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRegion(String id2, ZoneRules rules) {
        this.f50420id = id2;
        this.rules = rules;
    }

    @Override // java.time.ZoneId
    public String getId() {
        return this.f50420id;
    }

    @Override // java.time.ZoneId
    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.f50420id, false);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.ZoneId
    public void write(DataOutput out) throws IOException {
        out.writeByte(7);
        writeExternal(out);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeUTF(this.f50420id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneId readExternal(DataInput in) throws IOException {
        String id2 = in.readUTF();
        return ZoneId.of(id2, false);
    }
}
