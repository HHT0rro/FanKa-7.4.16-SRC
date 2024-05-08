package android.view.inspector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class StaticInspectionCompanionProvider implements InspectionCompanionProvider {
    private static final String COMPANION_SUFFIX = "$InspectionCompanion";

    @Override // android.view.inspector.InspectionCompanionProvider
    public <T> InspectionCompanion<T> provide(Class<T> cls) {
        String companionName = cls.getName() + COMPANION_SUFFIX;
        try {
            Class<?> loadClass = cls.getClassLoader().loadClass(companionName);
            if (!InspectionCompanion.class.isAssignableFrom(loadClass)) {
                return null;
            }
            return (InspectionCompanion) loadClass.newInstance();
        } catch (ClassNotFoundException e2) {
            return null;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
