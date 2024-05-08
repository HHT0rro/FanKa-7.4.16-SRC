package java.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DeleteOnExitHook {
    private static LinkedHashSet<String> files = new LinkedHashSet<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: java.io.DeleteOnExitHook.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                DeleteOnExitHook.runHooks();
            }
        });
    }

    private DeleteOnExitHook() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void add(String file) {
        synchronized (DeleteOnExitHook.class) {
            LinkedHashSet<String> linkedHashSet = files;
            if (linkedHashSet == null) {
                throw new IllegalStateException("Shutdown in progress");
            }
            linkedHashSet.add(file);
        }
    }

    static void runHooks() {
        LinkedHashSet<String> theFiles;
        synchronized (DeleteOnExitHook.class) {
            theFiles = files;
            files = null;
        }
        ArrayList<String> toBeDeleted = new ArrayList<>(theFiles);
        Collections.reverse(toBeDeleted);
        Iterator<String> iterator2 = toBeDeleted.iterator2();
        while (iterator2.hasNext()) {
            String filename = iterator2.next();
            new File(filename).delete();
        }
    }
}
