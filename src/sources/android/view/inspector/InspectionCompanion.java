package android.view.inspector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface InspectionCompanion<T> {
    void mapProperties(PropertyMapper propertyMapper);

    void readProperties(T t2, PropertyReader propertyReader);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class UninitializedPropertyMapException extends RuntimeException {
        public UninitializedPropertyMapException() {
            super("Unable to read properties of an inspectable before mapping their IDs.");
        }
    }
}
