package java.time.chrono;

import java.time.DateTimeException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum IsoEra implements Era {
    BCE,
    CE;

    public static IsoEra of(int isoEra) {
        switch (isoEra) {
            case 0:
                return BCE;
            case 1:
                return CE;
            default:
                throw new DateTimeException("Invalid era: " + isoEra);
        }
    }

    @Override // java.time.chrono.Era
    public int getValue() {
        return ordinal();
    }
}
