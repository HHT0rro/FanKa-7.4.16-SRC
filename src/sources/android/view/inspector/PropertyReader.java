package android.view.inspector;

import android.graphics.Color;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface PropertyReader {
    void readBoolean(int i10, boolean z10);

    void readByte(int i10, byte b4);

    void readChar(int i10, char c4);

    void readColor(int i10, int i11);

    void readColor(int i10, long j10);

    void readColor(int i10, Color color);

    void readDouble(int i10, double d10);

    void readFloat(int i10, float f10);

    void readGravity(int i10, int i11);

    void readInt(int i10, int i11);

    void readIntEnum(int i10, int i11);

    void readIntFlag(int i10, int i11);

    void readLong(int i10, long j10);

    void readObject(int i10, Object obj);

    void readResourceId(int i10, int i11);

    void readShort(int i10, short s2);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class PropertyTypeMismatchException extends RuntimeException {
        public PropertyTypeMismatchException(int id2, String expectedPropertyType, String actualPropertyType, String propertyName) {
            super(formatMessage(id2, expectedPropertyType, actualPropertyType, propertyName));
        }

        public PropertyTypeMismatchException(int id2, String expectedPropertyType, String actualPropertyType) {
            super(formatMessage(id2, expectedPropertyType, actualPropertyType, null));
        }

        private static String formatMessage(int id2, String expectedPropertyType, String actualPropertyType, String propertyName) {
            if (propertyName == null) {
                return String.format("Attempted to read property with ID 0x%08X as type %s, but the ID is of type %s.", Integer.valueOf(id2), expectedPropertyType, actualPropertyType);
            }
            return String.format("Attempted to read property \"%s\" with ID 0x%08X as type %s, but the ID is of type %s.", propertyName, Integer.valueOf(id2), expectedPropertyType, actualPropertyType);
        }
    }
}
