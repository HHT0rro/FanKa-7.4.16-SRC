package jdk.internal.ref;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class CleanerFactory {
    private static final java.lang.ref.Cleaner commonCleaner = java.lang.ref.Cleaner.createSystemCleaner();

    public static java.lang.ref.Cleaner cleaner() {
        return commonCleaner;
    }
}
