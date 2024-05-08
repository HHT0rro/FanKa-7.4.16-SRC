package java.util.prefs;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileSystemPreferencesFactory implements PreferencesFactory {
    @Override // java.util.prefs.PreferencesFactory
    public Preferences userRoot() {
        return FileSystemPreferences.getUserRoot();
    }

    @Override // java.util.prefs.PreferencesFactory
    public Preferences systemRoot() {
        return FileSystemPreferences.getSystemRoot();
    }
}
