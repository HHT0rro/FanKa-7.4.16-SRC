package java.math;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum RoundingMode {
    UP(0),
    DOWN(1),
    CEILING(2),
    FLOOR(3),
    HALF_UP(4),
    HALF_DOWN(5),
    HALF_EVEN(6),
    UNNECESSARY(7);

    final int oldMode;

    RoundingMode(int oldMode) {
        this.oldMode = oldMode;
    }

    public static RoundingMode valueOf(int rm) {
        switch (rm) {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return CEILING;
            case 3:
                return FLOOR;
            case 4:
                return HALF_UP;
            case 5:
                return HALF_DOWN;
            case 6:
                return HALF_EVEN;
            case 7:
                return UNNECESSARY;
            default:
                throw new IllegalArgumentException("argument out of range");
        }
    }
}
