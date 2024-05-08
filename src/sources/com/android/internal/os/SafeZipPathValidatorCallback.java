package com.android.internal.os;

import dalvik.system.ZipPathValidator;
import java.io.File;
import java.util.zip.ZipException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SafeZipPathValidatorCallback implements ZipPathValidator.Callback {
    public static final long VALIDATE_ZIP_PATH_FOR_PATH_TRAVERSAL = 242716250;

    @Override // dalvik.system.ZipPathValidator.Callback
    public void onZipEntryAccess(String path) throws ZipException {
        if (path.startsWith("/")) {
            throw new ZipException("Invalid zip entry path: " + path);
        }
        if (path.contains("..")) {
            for (File file = new File(path); file != null; file = file.getParentFile()) {
                if (file.getName().equals("..")) {
                    throw new ZipException("Invalid zip entry path: " + path);
                }
            }
        }
    }
}
