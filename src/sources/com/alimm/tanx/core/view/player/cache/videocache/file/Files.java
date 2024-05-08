package com.alimm.tanx.core.view.player.cache.videocache.file;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Files {
    public static final Logger LOG = LoggerFactory.getLogger("Files");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class LastModifiedComparator implements Comparator<File> {
        public LastModifiedComparator() {
        }

        private int compareLong(long j10, long j11) {
            if (j10 < j11) {
                return -1;
            }
            return j10 == j11 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }
    }

    public static List<File> getLruListFiles(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new LastModifiedComparator());
        return asList;
    }

    public static void makeDir(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + ((Object) file) + " is not directory!");
        }
        if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static void modify(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            recreateZeroSizeFile(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j10 = length - 1;
        randomAccessFile.seek(j10);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j10);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    public static void recreateZeroSizeFile(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + ((Object) file));
    }

    public static void setLastModifiedNow(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            modify(file);
            if (file.lastModified() < currentTimeMillis) {
                LOG.warn("Last modified date {} is not set for file {}", new Date(file.lastModified()).toString(), file.getAbsolutePath());
            }
        }
    }
}
