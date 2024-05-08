package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(@NonNull File file) {
        this.mBaseName = file;
        this.mNewName = new File(file.getPath() + ".new");
        this.mLegacyBackupName = new File(file.getPath() + ".bak");
    }

    private static void rename(@NonNull File file, @NonNull File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to delete file which is a directory ");
            sb2.append((Object) file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Failed to rename ");
        sb3.append((Object) file);
        sb3.append(" to ");
        sb3.append((Object) file2);
    }

    private static boolean sync(@NonNull FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        if (this.mNewName.delete()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to delete new file ");
        sb2.append((Object) this.mNewName);
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        rename(this.mNewName, this.mBaseName);
    }

    @NonNull
    public File getBaseFile() {
        return this.mBaseName;
    }

    @NonNull
    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to delete outdated new file ");
            sb2.append((Object) this.mNewName);
        }
        return new FileInputStream(this.mBaseName);
    }

    @NonNull
    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i10 = 0;
            while (true) {
                int read = openRead.read(bArr, i10, bArr.length - i10);
                if (read <= 0) {
                    return bArr;
                }
                i10 += read;
                int available = openRead.available();
                if (available > bArr.length - i10) {
                    byte[] bArr2 = new byte[available + i10];
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i10);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @NonNull
    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists()) {
            rename(this.mLegacyBackupName, this.mBaseName);
        }
        try {
            return new FileOutputStream(this.mNewName);
        } catch (FileNotFoundException unused) {
            if (this.mNewName.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.mNewName);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Failed to create new file " + ((Object) this.mNewName), e2);
                }
            }
            throw new IOException("Failed to create directory for " + ((Object) this.mNewName));
        }
    }
}
