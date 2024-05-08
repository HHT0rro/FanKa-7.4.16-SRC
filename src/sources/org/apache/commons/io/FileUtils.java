package org.apache.commons.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY;
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;
    private static final Charset UTF8;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        ONE_KB_BI = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        ONE_MB_BI = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        ONE_GB_BI = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        ONE_TB_BI = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        ONE_PB_BI = multiply4;
        ONE_EB_BI = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(ONE_EB));
        ONE_ZB = multiply5;
        ONE_YB = valueOf.multiply(multiply5);
        EMPTY_FILE_ARRAY = new File[0];
        UTF8 = Charset.forName("UTF-8");
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        BigInteger bigInteger2 = ONE_EB_BI;
        BigInteger divide = bigInteger.divide(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (divide.compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger2)) + " EB";
        }
        BigInteger bigInteger4 = ONE_PB_BI;
        if (bigInteger.divide(bigInteger4).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger4)) + " PB";
        }
        BigInteger bigInteger5 = ONE_TB_BI;
        if (bigInteger.divide(bigInteger5).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger5)) + " TB";
        }
        BigInteger bigInteger6 = ONE_GB_BI;
        if (bigInteger.divide(bigInteger6).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger6)) + " GB";
        }
        BigInteger bigInteger7 = ONE_MB_BI;
        if (bigInteger.divide(bigInteger7).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger7)) + " MB";
        }
        BigInteger bigInteger8 = ONE_KB_BI;
        if (bigInteger.divide(bigInteger8).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger8)) + " KB";
        }
        return String.valueOf(bigInteger) + " bytes";
    }

    private static void checkDirectory(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IllegalArgumentException(((Object) file) + " is not a directory");
        }
        throw new IllegalArgumentException(((Object) file) + " does not exist");
    }

    public static Checksum checksum(File file, Checksum checksum) throws IOException {
        if (!file.isDirectory()) {
            CheckedInputStream checkedInputStream = null;
            try {
                CheckedInputStream checkedInputStream2 = new CheckedInputStream(new FileInputStream(file), checksum);
                try {
                    IOUtils.copy(checkedInputStream2, new NullOutputStream());
                    IOUtils.closeQuietly((InputStream) checkedInputStream2);
                    return checksum;
                } catch (Throwable th) {
                    th = th;
                    checkedInputStream = checkedInputStream2;
                    IOUtils.closeQuietly((InputStream) checkedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalArgumentException("Checksums can't be computed on directories");
        }
    }

    public static long checksumCRC32(File file) throws IOException {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    public static void cleanDirectory(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e2 = null;
                    for (File file2 : listFiles) {
                        try {
                            forceDelete(file2);
                        } catch (IOException e10) {
                            e2 = e10;
                        }
                    }
                    if (e2 != null) {
                        throw e2;
                    }
                    return;
                }
                throw new IOException("Failed to list contents of " + ((Object) file));
            }
            throw new IllegalArgumentException(((Object) file) + " is not a directory");
        }
        throw new IllegalArgumentException(((Object) file) + " does not exist");
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e2 = null;
                    for (File file2 : listFiles) {
                        try {
                            forceDeleteOnExit(file2);
                        } catch (IOException e10) {
                            e2 = e10;
                        }
                    }
                    if (e2 != null) {
                        throw e2;
                    }
                    return;
                }
                throw new IOException("Failed to list contents of " + ((Object) file));
            }
            throw new IllegalArgumentException(((Object) file) + " is not a directory");
        }
        throw new IllegalArgumentException(((Object) file) + " does not exist");
    }

    public static boolean contentEquals(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        }
        if (file.length() != file2.length()) {
            return false;
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        FileInputStream fileInputStream2 = null;
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    boolean contentEquals = IOUtils.contentEquals(fileInputStream3, fileInputStream);
                    IOUtils.closeQuietly((InputStream) fileInputStream3);
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    return contentEquals;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream3;
                    IOUtils.closeQuietly((InputStream) fileInputStream2);
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static boolean contentEqualsIgnoreEOL(File file, File file2, String str) throws IOException {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (!file.isDirectory() && !file2.isDirectory()) {
            if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
                return true;
            }
            InputStreamReader inputStreamReader3 = null;
            try {
                if (str == null) {
                    InputStreamReader inputStreamReader4 = new InputStreamReader(new FileInputStream(file));
                    try {
                        inputStreamReader2 = new InputStreamReader(new FileInputStream(file2));
                        inputStreamReader3 = inputStreamReader4;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = null;
                        inputStreamReader3 = inputStreamReader4;
                        IOUtils.closeQuietly((Reader) inputStreamReader3);
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        throw th;
                    }
                } else {
                    InputStreamReader inputStreamReader5 = new InputStreamReader(new FileInputStream(file), str);
                    try {
                        inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), str);
                        inputStreamReader3 = inputStreamReader5;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = null;
                        inputStreamReader3 = inputStreamReader5;
                        IOUtils.closeQuietly((Reader) inputStreamReader3);
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        throw th;
                    }
                }
                try {
                    boolean contentEqualsIgnoreEOL = IOUtils.contentEqualsIgnoreEOL(inputStreamReader3, inputStreamReader2);
                    IOUtils.closeQuietly((Reader) inputStreamReader3);
                    IOUtils.closeQuietly((Reader) inputStreamReader2);
                    return contentEqualsIgnoreEOL;
                } catch (Throwable th3) {
                    inputStreamReader = inputStreamReader2;
                    th = th3;
                    IOUtils.closeQuietly((Reader) inputStreamReader3);
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = inputStreamReader3;
            }
        } else {
            throw new IOException("Can't compare directories, only files");
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + ((Object) file2) + "' is not a directory");
        }
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + ((Object) file2) + "' is not a directory");
        }
        copyDirectory(file, new File(file2, file.getName()), true);
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        try {
            FileOutputStream openOutputStream = openOutputStream(file);
            try {
                IOUtils.copy(inputStream, openOutputStream);
                openOutputStream.close();
            } finally {
                IOUtils.closeQuietly((OutputStream) openOutputStream);
            }
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static void copyURLToFile(URL url, File file) throws IOException {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static String decodeUrl(String str) {
        int i10;
        if (str == null || str.indexOf(37) < 0) {
            return str;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        ByteBuffer allocate = ByteBuffer.allocate(length);
        int i11 = 0;
        while (i11 < length) {
            if (str.charAt(i11) == '%') {
                while (true) {
                    i10 = i11 + 3;
                    try {
                        try {
                            allocate.put((byte) Integer.parseInt(str.substring(i11 + 1, i10), 16));
                            if (i10 >= length) {
                                break;
                            }
                            try {
                                if (str.charAt(i10) != '%') {
                                    break;
                                }
                                i11 = i10;
                            } catch (RuntimeException unused) {
                                i11 = i10;
                                if (allocate.position() > 0) {
                                    allocate.flip();
                                    stringBuffer.append(UTF8.decode(allocate).toString());
                                    allocate.clear();
                                }
                                stringBuffer.append(str.charAt(i11));
                                i11++;
                            }
                        } finally {
                            if (allocate.position() > 0) {
                                allocate.flip();
                                stringBuffer.append(UTF8.decode(allocate).toString());
                                allocate.clear();
                            }
                        }
                    } catch (RuntimeException unused2) {
                    }
                }
                i11 = i10;
            }
            stringBuffer.append(str.charAt(i11));
            i11++;
        }
        return stringBuffer.toString();
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + ((Object) file) + ".");
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (isSymlink(file)) {
                return;
            }
            cleanDirectoryOnExit(file);
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean directoryContains(File file, File file2) throws IOException {
        if (file != null) {
            if (file.isDirectory()) {
                if (file2 != null && file.exists() && file2.exists()) {
                    return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
                }
                return false;
            }
            throw new IllegalArgumentException("Not a directory: " + ((Object) file));
        }
        throw new IllegalArgumentException("Directory must not be null");
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z10, List<String> list) throws IOException {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + ((Object) file2) + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + ((Object) file2) + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            doCopyDirectory(file3, file4, fileFilter, z10, list);
                        } else {
                            doCopyFile(file3, file4, z10);
                        }
                    }
                }
                if (z10) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + ((Object) file2) + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + ((Object) file));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream, java.io.FileOutputStream] */
    private static void doCopyFile(File file, File file2, boolean z10) throws IOException {
        FileInputStream fileInputStream;
        ?? r42;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + ((Object) file2) + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r42 = 0;
        }
        try {
            r42 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            r42 = 0;
            fileChannel = r42;
            IOUtils.closeQuietly(fileChannel2);
            IOUtils.closeQuietly((OutputStream) r42);
            IOUtils.closeQuietly(fileChannel);
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
        try {
            fileChannel2 = r42.getChannel();
            long size = fileChannel.size();
            long j10 = 0;
            while (j10 < size) {
                long j11 = size - j10;
                j10 += fileChannel2.transferFrom(fileChannel, j10, j11 > FILE_COPY_BUFFER_SIZE ? 31457280L : j11);
            }
            IOUtils.closeQuietly(fileChannel2);
            IOUtils.closeQuietly((OutputStream) r42);
            IOUtils.closeQuietly(fileChannel);
            IOUtils.closeQuietly((InputStream) fileInputStream);
            if (file.length() == file2.length()) {
                if (z10) {
                    file2.setLastModified(file.lastModified());
                }
            } else {
                throw new IOException("Failed to copy full contents from '" + ((Object) file) + "' to '" + ((Object) file2) + "'");
            }
        } catch (Throwable th4) {
            th = th4;
            IOUtils.closeQuietly(fileChannel2);
            IOUtils.closeQuietly((OutputStream) r42);
            IOUtils.closeQuietly(fileChannel);
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + ((Object) file));
        }
        throw new IOException("Unable to delete file: " + ((Object) file));
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + ((Object) file) + " exists and is not a directory. Unable to create directory.");
        }
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create directory " + ((Object) file));
    }

    public static File getFile(File file, String... strArr) {
        Objects.requireNonNull(file, "directorydirectory must not be null");
        Objects.requireNonNull(strArr, "names must not be null");
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            File file2 = new File(file, strArr[i10]);
            i10++;
            file = file2;
        }
        return file;
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    private static void innerListFiles(Collection<File> collection, File file, IOFileFilter iOFileFilter, boolean z10) {
        File[] listFiles = file.listFiles((FileFilter) iOFileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z10) {
                        collection.add(file2);
                    }
                    innerListFiles(collection, file2, iOFileFilter, z10);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 != null) {
            if (file2.exists()) {
                return isFileNewer(file, file2.lastModified());
            }
            throw new IllegalArgumentException("The reference file '" + ((Object) file2) + "' doesn't exist");
        }
        throw new IllegalArgumentException("No specified reference file");
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 != null) {
            if (file2.exists()) {
                return isFileOlder(file, file2.lastModified());
            }
            throw new IllegalArgumentException("The reference file '" + ((Object) file2) + "' doesn't exist");
        }
        throw new IllegalArgumentException("No specified reference file");
    }

    public static boolean isSymlink(File file) throws IOException {
        Objects.requireNonNull(file, "File must not be null");
        if (FilenameUtils.isSystemWindows()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator2();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator2();
    }

    public static LineIterator lineIterator(File file, String str) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.lineIterator(fileInputStream, str);
        } catch (IOException e2) {
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw e2;
        } catch (RuntimeException e10) {
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw e10;
        }
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), false);
        return linkedList;
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        if (file.isDirectory()) {
            linkedList.add(file);
        }
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), true);
        return linkedList;
    }

    public static void moveDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    if (file.renameTo(file2)) {
                        return;
                    }
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                        copyDirectory(file, file2);
                        deleteDirectory(file);
                        if (file.exists()) {
                            throw new IOException("Failed to delete original directory '" + ((Object) file) + "' after copy to '" + ((Object) file2) + "'");
                        }
                        return;
                    }
                    throw new IOException("Cannot move directory: " + ((Object) file) + " to a subdirectory of itself: " + ((Object) file2));
                }
                throw new FileExistsException("Destination '" + ((Object) file2) + "' already exists");
            }
            throw new IOException("Source '" + ((Object) file) + "' is not a directory");
        }
        throw new FileNotFoundException("Source '" + ((Object) file) + "' does not exist");
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z10) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination directory must not be null");
        if (!file2.exists() && z10) {
            file2.mkdirs();
        }
        if (file2.exists()) {
            if (file2.isDirectory()) {
                moveDirectory(file, new File(file2, file.getName()));
                return;
            }
            throw new IOException("Destination '" + ((Object) file2) + "' is not a directory");
        }
        throw new FileNotFoundException("Destination directory '" + ((Object) file2) + "' does not exist [createDestDir=" + z10 + "]");
    }

    public static void moveFile(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file2.exists()) {
                    if (!file2.isDirectory()) {
                        if (file.renameTo(file2)) {
                            return;
                        }
                        copyFile(file, file2);
                        if (file.delete()) {
                            return;
                        }
                        deleteQuietly(file2);
                        throw new IOException("Failed to delete original file '" + ((Object) file) + "' after copy to '" + ((Object) file2) + "'");
                    }
                    throw new IOException("Destination '" + ((Object) file2) + "' is a directory");
                }
                throw new FileExistsException("Destination '" + ((Object) file2) + "' already exists");
            }
            throw new IOException("Source '" + ((Object) file) + "' is a directory");
        }
        throw new FileNotFoundException("Source '" + ((Object) file) + "' does not exist");
    }

    public static void moveFileToDirectory(File file, File file2, boolean z10) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination directory must not be null");
        if (!file2.exists() && z10) {
            file2.mkdirs();
        }
        if (file2.exists()) {
            if (file2.isDirectory()) {
                moveFile(file, new File(file2, file.getName()));
                return;
            }
            throw new IOException("Destination '" + ((Object) file2) + "' is not a directory");
        }
        throw new FileNotFoundException("Destination directory '" + ((Object) file2) + "' does not exist [createDestDir=" + z10 + "]");
    }

    public static void moveToDirectory(File file, File file2, boolean z10) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file.exists()) {
            if (file.isDirectory()) {
                moveDirectoryToDirectory(file, file2, z10);
                return;
            } else {
                moveFileToDirectory(file, file2, z10);
                return;
            }
        }
        throw new FileNotFoundException("Source '" + ((Object) file) + "' does not exist");
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + ((Object) file) + "' cannot be read");
            }
            throw new IOException("File '" + ((Object) file) + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + ((Object) file) + "' does not exist");
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        return openOutputStream(file, false);
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] byteArray = IOUtils.toByteArray(fileInputStream, file.length());
            IOUtils.closeQuietly((InputStream) fileInputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    public static String readFileToString(File file, Charset charset) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String iOUtils = IOUtils.toString(fileInputStream, Charsets.toCharset(charset));
            IOUtils.closeQuietly((InputStream) fileInputStream);
            return iOUtils;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            List<String> readLines = IOUtils.readLines(fileInputStream, Charsets.toCharset(charset));
            IOUtils.closeQuietly((InputStream) fileInputStream);
            return readLines;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter iOFileFilter) {
        return iOFileFilter == null ? FalseFileFilter.INSTANCE : FileFilterUtils.and(iOFileFilter, DirectoryFileFilter.INSTANCE);
    }

    private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter iOFileFilter) {
        return FileFilterUtils.and(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
    }

    public static long sizeOf(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return sizeOfDirectory(file);
            }
            return file.length();
        }
        throw new IllegalArgumentException(((Object) file) + " does not exist");
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return sizeOfDirectoryAsBigInteger(file);
            }
            return BigInteger.valueOf(file.length());
        }
        throw new IllegalArgumentException(((Object) file) + " does not exist");
    }

    public static long sizeOfDirectory(File file) {
        checkDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        long j10 = 0;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    j10 += sizeOf(file2);
                    if (j10 < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j10;
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        checkDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(BigInteger.valueOf(sizeOf(file2)));
                }
            } catch (IOException unused) {
            }
        }
        return bigInteger;
    }

    public static File toFile(URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)));
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr != null && urlArr.length != 0) {
            File[] fileArr = new File[urlArr.length];
            for (int i10 = 0; i10 < urlArr.length; i10++) {
                URL url = urlArr[i10];
                if (url != null) {
                    if (url.getProtocol().equals("file")) {
                        fileArr[i10] = toFile(url);
                    } else {
                        throw new IllegalArgumentException("URL could not be converted to a File: " + ((Object) url));
                    }
                }
            }
            return fileArr;
        }
        return EMPTY_FILE_ARRAY;
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = "." + strArr[i10];
        }
        return strArr2;
    }

    public static URL[] toURLs(File[] fileArr) throws IOException {
        int length = fileArr.length;
        URL[] urlArr = new URL[length];
        for (int i10 = 0; i10 < length; i10++) {
            urlArr[i10] = fileArr[i10].toURI().toURL();
        }
        return urlArr;
    }

    public static void touch(File file) throws IOException {
        if (!file.exists()) {
            IOUtils.closeQuietly((OutputStream) openOutputStream(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + ((Object) file));
    }

    private static void validateListFilesParameters(File file, IOFileFilter iOFileFilter) {
        if (file.isDirectory()) {
            Objects.requireNonNull(iOFileFilter, "Parameter 'fileFilter' is null");
            return;
        }
        throw new IllegalArgumentException("Parameter 'directory' is not a directory");
    }

    public static boolean waitFor(File file, int i10) {
        int i11 = 0;
        int i12 = 0;
        while (!file.exists()) {
            int i13 = i11 + 1;
            if (i11 >= 10) {
                int i14 = i12 + 1;
                if (i12 > i10) {
                    return false;
                }
                i12 = i14;
                i11 = 0;
            } else {
                i11 = i13;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            } catch (Exception unused2) {
                return true;
            }
        }
        return true;
    }

    public static void write(File file, CharSequence charSequence) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection) throws IOException {
        writeLines(file, str, collection, null, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void copyDirectory(File file, File file2, boolean z10) throws IOException {
        copyDirectory(file, file2, null, z10);
    }

    public static void copyFile(File file, File file2, boolean z10) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new IOException("Destination '" + ((Object) parentFile) + "' directory cannot be created");
                    }
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + ((Object) file2) + "' exists but is read-only");
                    }
                    doCopyFile(file, file2, z10);
                    return;
                }
                throw new IOException("Source '" + ((Object) file) + "' and destination '" + ((Object) file2) + "' are the same");
            }
            throw new IOException("Source '" + ((Object) file) + "' exists but is a directory");
        }
        throw new FileNotFoundException("Source '" + ((Object) file) + "' does not exist");
    }

    public static void copyFileToDirectory(File file, File file2, boolean z10) throws IOException {
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + ((Object) file2) + "' is not a directory");
        }
        copyFile(file, new File(file2, file.getName()), z10);
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z10) {
        return listFiles(file, strArr, z10).iterator2();
    }

    public static FileOutputStream openOutputStream(File file, boolean z10) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + ((Object) file) + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + ((Object) file) + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + ((Object) parentFile) + "' could not be created");
            }
        }
        return new FileOutputStream(file, z10);
    }

    public static void write(File file, CharSequence charSequence, boolean z10) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), z10);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z10) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z10);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z10) throws IOException {
        writeLines(file, str, collection, null, z10);
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        writeStringToFile(file, str, str2, false);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) throws IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyURLToFile(URL url, File file, int i10, int i11) throws IOException {
        URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i10);
        openConnection.setReadTimeout(i11);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws IOException {
        write(file, charSequence, charset, false);
    }

    public static void writeLines(File file, Collection<?> collection) throws IOException {
        writeLines(file, null, collection, null, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset, boolean z10) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z10);
            try {
                IOUtils.write(str, (OutputStream) fileOutputStream, charset);
                fileOutputStream.close();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z10) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    ArrayList arrayList = null;
                    if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                        if (listFiles != null && listFiles.length > 0) {
                            arrayList = new ArrayList(listFiles.length);
                            for (File file3 : listFiles) {
                                arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                            }
                        }
                    }
                    doCopyDirectory(file, file2, fileFilter, z10, arrayList);
                    return;
                }
                throw new IOException("Source '" + ((Object) file) + "' and destination '" + ((Object) file2) + "' are the same");
            }
            throw new IOException("Source '" + ((Object) file) + "' exists but is not a directory");
        }
        throw new FileNotFoundException("Source '" + ((Object) file) + "' does not exist");
    }

    public static String readFileToString(File file, String str) throws IOException {
        return readFileToString(file, Charsets.toCharset(str));
    }

    public static List<String> readLines(File file, String str) throws IOException {
        return readLines(file, Charsets.toCharset(str));
    }

    public static void write(File file, CharSequence charSequence, String str) throws IOException {
        write(file, charSequence, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z10) throws IOException {
        writeLines(file, null, collection, null, z10);
    }

    public static File getFile(String... strArr) {
        Objects.requireNonNull(strArr, "names must not be null");
        File file = null;
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date != null) {
            return isFileNewer(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date != null) {
            return isFileOlder(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, Charset.defaultCharset());
    }

    public static List<String> readLines(File file) throws IOException {
        return readLines(file, Charset.defaultCharset());
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z10) throws IOException {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z10);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) throws IOException {
        writeLines(file, str, collection, str2, false);
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z10) {
        IOFileFilter suffixFileFilter;
        if (strArr == null) {
            suffixFileFilter = TrueFileFilter.INSTANCE;
        } else {
            suffixFileFilter = new SuffixFileFilter(toSuffixes(strArr));
        }
        return listFiles(file, suffixFileFilter, z10 ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2, boolean z10) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z10);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            IOUtils.writeLines(collection, str2, bufferedOutputStream, str);
            bufferedOutputStream.flush();
            fileOutputStream.close();
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static boolean isFileNewer(File file, long j10) {
        if (file != null) {
            return file.exists() && file.lastModified() > j10;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileOlder(File file, long j10) {
        if (file != null) {
            return file.exists() && file.lastModified() < j10;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static LineIterator lineIterator(File file) throws IOException {
        return lineIterator(file, null);
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z10) throws IOException {
        write(file, charSequence, Charsets.toCharset(str), z10);
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z10) throws IOException {
        writeStringToFile(file, str, Charsets.toCharset(str2), z10);
    }

    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    public static void writeStringToFile(File file, String str, boolean z10) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), z10);
    }

    public static void writeLines(File file, Collection<?> collection, String str) throws IOException {
        writeLines(file, null, collection, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z10) throws IOException {
        writeLines(file, null, collection, str, z10);
    }

    public static String byteCountToDisplaySize(long j10) {
        return byteCountToDisplaySize(BigInteger.valueOf(j10));
    }

    public static long copyFile(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return IOUtils.copyLarge(fileInputStream, outputStream);
        } finally {
            fileInputStream.close();
        }
    }
}
