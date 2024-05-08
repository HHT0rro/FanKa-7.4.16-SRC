package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileEntry implements Serializable {
    public static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    public FileEntry(File file) {
        this(null, file);
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        return fileEntryArr != null ? fileEntryArr : EMPTY_ENTRIES;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    public boolean refresh(File file) {
        boolean z10 = this.exists;
        long j10 = this.lastModified;
        boolean z11 = this.directory;
        long j11 = this.length;
        this.name = file.getName();
        boolean exists = file.exists();
        this.exists = exists;
        this.directory = exists ? file.isDirectory() : false;
        long j12 = 0;
        this.lastModified = this.exists ? file.lastModified() : 0L;
        if (this.exists && !this.directory) {
            j12 = file.length();
        }
        this.length = j12;
        return (this.exists == z10 && this.lastModified == j10 && this.directory == z11 && j12 == j11) ? false : true;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z10) {
        this.directory = z10;
    }

    public void setExists(boolean z10) {
        this.exists = z10;
    }

    public void setLastModified(long j10) {
        this.lastModified = j10;
    }

    public void setLength(long j10) {
        this.length = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public FileEntry(FileEntry fileEntry, File file) {
        if (file != null) {
            this.file = file;
            this.parent = fileEntry;
            this.name = file.getName();
            return;
        }
        throw new IllegalArgumentException("File is missing");
    }
}
