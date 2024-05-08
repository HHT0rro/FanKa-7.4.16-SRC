package java.lang;

import com.android.internal.logging.nano.MetricsProto;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Boolean implements Serializable, Comparable<Boolean> {
    private static final long serialVersionUID = -3665804199014368530L;
    private final boolean value;
    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);
    public static final Class<Boolean> TYPE = Class.getPrimitiveClass("boolean");

    @Deprecated(since = "9")
    public Boolean(boolean value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Boolean(String s2) {
        this(parseBoolean(s2));
    }

    public static boolean parseBoolean(String s2) {
        return "true".equalsIgnoreCase(s2);
    }

    public boolean booleanValue() {
        return this.value;
    }

    public static Boolean valueOf(boolean b4) {
        return b4 ? TRUE : FALSE;
    }

    public static Boolean valueOf(String s2) {
        return parseBoolean(s2) ? TRUE : FALSE;
    }

    public static String toString(boolean b4) {
        return b4 ? "true" : "false";
    }

    public String toString() {
        return this.value ? "true" : "false";
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(boolean value) {
        return value ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Boolean) && this.value == ((Boolean) obj).booleanValue();
    }

    public static boolean getBoolean(String name) {
        try {
            boolean result = parseBoolean(System.getProperty(name));
            return result;
        } catch (IllegalArgumentException | NullPointerException e2) {
            return false;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Boolean b4) {
        return compare(this.value, b4.value);
    }

    public static int compare(boolean x10, boolean y10) {
        if (x10 == y10) {
            return 0;
        }
        return x10 ? 1 : -1;
    }

    public static boolean logicalAnd(boolean a10, boolean b4) {
        return a10 && b4;
    }

    public static boolean logicalOr(boolean a10, boolean b4) {
        return a10 || b4;
    }

    public static boolean logicalXor(boolean a10, boolean b4) {
        return a10 ^ b4;
    }
}
