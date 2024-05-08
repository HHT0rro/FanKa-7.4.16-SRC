package android.view.inspector;

import java.util.Set;
import java.util.function.IntFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface PropertyMapper {
    int mapBoolean(String str, int i10);

    int mapByte(String str, int i10);

    int mapChar(String str, int i10);

    int mapColor(String str, int i10);

    int mapDouble(String str, int i10);

    int mapFloat(String str, int i10);

    int mapGravity(String str, int i10);

    int mapInt(String str, int i10);

    int mapIntEnum(String str, int i10, IntFunction<String> intFunction);

    int mapIntFlag(String str, int i10, IntFunction<Set<String>> intFunction);

    int mapLong(String str, int i10);

    int mapObject(String str, int i10);

    int mapResourceId(String str, int i10);

    int mapShort(String str, int i10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class PropertyConflictException extends RuntimeException {
        public PropertyConflictException(String name, String newPropertyType, String existingPropertyType) {
            super(String.format("Attempted to map property \"%s\" as type %s, but it is already mapped as %s.", name, newPropertyType, existingPropertyType));
        }
    }
}
