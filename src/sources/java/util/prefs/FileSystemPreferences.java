package java.util.prefs;

import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileSystemPreferences extends AbstractPreferences {
    private static final int EACCES = 13;
    private static final int EAGAIN = 11;
    private static final String[] EMPTY_STRING_ARRAY;
    private static final int ERROR_CODE = 1;
    private static int INIT_SLEEP_TIME = 0;
    private static final int LOCK_HANDLE = 0;
    private static int MAX_ATTEMPTS = 0;
    private static final int USER_READ_WRITE = 384;
    private static final int USER_RWX = 448;
    private static final int USER_RWX_ALL_RX = 493;
    private static final int USER_RW_ALL_READ = 420;
    private static boolean isSystemRootWritable;
    private static boolean isUserRootWritable;
    static File systemLockFile;
    static Preferences systemRoot;
    private static File systemRootDir;
    private static File systemRootModFile;
    private static long systemRootModTime;
    static File userLockFile;
    private static File userRootDir;
    private static File userRootModFile;
    private static long userRootModTime;
    final List<Change> changeLog;
    private final File dir;
    private final boolean isUserNode;
    private long lastSyncTime;
    NodeCreate nodeCreate;
    private Map<String, String> prefsCache;
    private final File prefsFile;
    private final File tmpFile;
    static Preferences userRoot = null;
    private static int userRootLockHandle = 0;
    private static int systemRootLockHandle = 0;
    private static boolean isUserRootModified = false;
    private static boolean isSystemRootModified = false;

    /* renamed from: -$$Nest$smgetLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ PlatformLogger m3503$$Nest$smgetLogger() {
        return getLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int chmod(String str, int i10);

    private static native int[] lockFile0(String str, int i10, boolean z10);

    private static native int unlockFile0(int i10);

    private static PlatformLogger getLogger() {
        return PlatformLogger.getLogger("java.util.prefs");
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: java.util.prefs.FileSystemPreferences.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                FileSystemPreferences.syncWorld();
            }
        });
        EMPTY_STRING_ARRAY = new String[0];
        INIT_SLEEP_TIME = 50;
        MAX_ATTEMPTS = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized Preferences getUserRoot() {
        Preferences preferences;
        synchronized (FileSystemPreferences.class) {
            if (userRoot == null) {
                setupUserRoot();
                userRoot = new FileSystemPreferences(true);
            }
            preferences = userRoot;
        }
        return preferences;
    }

    private static void setupUserRoot() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.prefs.FileSystemPreferences.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                FileSystemPreferences.userRootDir = new File(System.getProperty("java.util.prefs.userRoot", System.getProperty("user.home")), ".java/.userPrefs");
                if (!FileSystemPreferences.userRootDir.exists()) {
                    if (FileSystemPreferences.userRootDir.mkdirs()) {
                        try {
                            FileSystemPreferences.chmod(FileSystemPreferences.userRootDir.getCanonicalPath(), FileSystemPreferences.USER_RWX);
                        } catch (IOException e2) {
                            FileSystemPreferences.m3503$$Nest$smgetLogger().warning("Could not change permissions on userRoot directory. ");
                        }
                        FileSystemPreferences.m3503$$Nest$smgetLogger().info("Created user preferences directory.");
                    } else {
                        FileSystemPreferences.m3503$$Nest$smgetLogger().warning("Couldn't create user preferences directory. User preferences are unusable.");
                    }
                }
                FileSystemPreferences.isUserRootWritable = FileSystemPreferences.userRootDir.canWrite();
                String USER_NAME = System.getProperty("user.name");
                FileSystemPreferences.userLockFile = new File(FileSystemPreferences.userRootDir, ".user.lock." + USER_NAME);
                FileSystemPreferences.userRootModFile = new File(FileSystemPreferences.userRootDir, ".userRootModFile." + USER_NAME);
                if (!FileSystemPreferences.userRootModFile.exists()) {
                    try {
                        FileSystemPreferences.userRootModFile.createNewFile();
                        int result = FileSystemPreferences.chmod(FileSystemPreferences.userRootModFile.getCanonicalPath(), 384);
                        if (result != 0) {
                            FileSystemPreferences.m3503$$Nest$smgetLogger().warning("Problem creating userRoot mod file. Chmod failed on " + FileSystemPreferences.userRootModFile.getCanonicalPath() + " Unix error code " + result);
                        }
                    } catch (IOException e10) {
                        FileSystemPreferences.m3503$$Nest$smgetLogger().warning(e10.toString());
                    }
                }
                FileSystemPreferences.userRootModTime = FileSystemPreferences.userRootModFile.lastModified();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized Preferences getSystemRoot() {
        Preferences preferences;
        synchronized (FileSystemPreferences.class) {
            if (systemRoot == null) {
                setupSystemRoot();
                systemRoot = new FileSystemPreferences(false);
            }
            preferences = systemRoot;
        }
        return preferences;
    }

    private static void setupSystemRoot() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.prefs.FileSystemPreferences.2
            @Override // java.security.PrivilegedAction
            public Void run() {
                String systemPrefsDirName = System.getProperty("java.util.prefs.systemRoot", "/etc/.java");
                FileSystemPreferences.systemRootDir = new File(systemPrefsDirName, ".systemPrefs");
                if (!FileSystemPreferences.systemRootDir.exists()) {
                    FileSystemPreferences.systemRootDir = new File(System.getProperty("java.home"), ".systemPrefs");
                    if (!FileSystemPreferences.systemRootDir.exists()) {
                        if (FileSystemPreferences.systemRootDir.mkdirs()) {
                            FileSystemPreferences.m3503$$Nest$smgetLogger().info("Created system preferences directory in java.home.");
                            try {
                                FileSystemPreferences.chmod(FileSystemPreferences.systemRootDir.getCanonicalPath(), 493);
                            } catch (IOException e2) {
                            }
                        } else {
                            FileSystemPreferences.m3503$$Nest$smgetLogger().warning("Could not create system preferences directory. System preferences are unusable.");
                        }
                    }
                }
                FileSystemPreferences.isSystemRootWritable = FileSystemPreferences.systemRootDir.canWrite();
                FileSystemPreferences.systemLockFile = new File(FileSystemPreferences.systemRootDir, ".system.lock");
                FileSystemPreferences.systemRootModFile = new File(FileSystemPreferences.systemRootDir, ".systemRootModFile");
                if (!FileSystemPreferences.systemRootModFile.exists() && FileSystemPreferences.isSystemRootWritable) {
                    try {
                        FileSystemPreferences.systemRootModFile.createNewFile();
                        int result = FileSystemPreferences.chmod(FileSystemPreferences.systemRootModFile.getCanonicalPath(), FileSystemPreferences.USER_RW_ALL_READ);
                        if (result != 0) {
                            FileSystemPreferences.m3503$$Nest$smgetLogger().warning("Chmod failed on " + FileSystemPreferences.systemRootModFile.getCanonicalPath() + " Unix error code " + result);
                        }
                    } catch (IOException e10) {
                        FileSystemPreferences.m3503$$Nest$smgetLogger().warning(e10.toString());
                    }
                }
                FileSystemPreferences.systemRootModTime = FileSystemPreferences.systemRootModFile.lastModified();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class Change {
        abstract void replay();

        private Change() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Put extends Change {
        String key;
        String value;

        Put(String key, String value) {
            super();
            this.key = key;
            this.value = value;
        }

        @Override // java.util.prefs.FileSystemPreferences.Change
        void replay() {
            FileSystemPreferences.this.prefsCache.put(this.key, this.value);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Remove extends Change {
        String key;

        Remove(String key) {
            super();
            this.key = key;
        }

        @Override // java.util.prefs.FileSystemPreferences.Change
        void replay() {
            FileSystemPreferences.this.prefsCache.remove(this.key);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class NodeCreate extends Change {
        private NodeCreate() {
            super();
        }

        @Override // java.util.prefs.FileSystemPreferences.Change
        void replay() {
        }
    }

    private void replayChanges() {
        int n10 = this.changeLog.size();
        for (int i10 = 0; i10 < n10; i10++) {
            this.changeLog.get(i10).replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void syncWorld() {
        Preferences userRt;
        Preferences systemRt;
        synchronized (FileSystemPreferences.class) {
            userRt = userRoot;
            systemRt = systemRoot;
        }
        if (userRt != null) {
            try {
                userRt.flush();
            } catch (BackingStoreException e2) {
                getLogger().warning("Couldn't flush user prefs: " + ((Object) e2));
            }
        }
        if (systemRt != null) {
            try {
                systemRt.flush();
            } catch (BackingStoreException e10) {
                getLogger().warning("Couldn't flush system prefs: " + ((Object) e10));
            }
        }
    }

    private FileSystemPreferences(boolean user) {
        super(null, "");
        this.prefsCache = null;
        this.lastSyncTime = 0L;
        this.changeLog = new ArrayList();
        this.nodeCreate = null;
        this.isUserNode = user;
        File file = user ? userRootDir : systemRootDir;
        this.dir = file;
        this.prefsFile = new File(file, "prefs.xml");
        this.tmpFile = new File(file, "prefs.tmp");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemPreferences(String path, File lockFile, boolean isUserNode) {
        super(null, "");
        this.prefsCache = null;
        this.lastSyncTime = 0L;
        ArrayList arrayList = new ArrayList();
        this.changeLog = arrayList;
        this.nodeCreate = null;
        this.isUserNode = isUserNode;
        File file = new File(path);
        this.dir = file;
        this.prefsFile = new File(file, "prefs.xml");
        this.tmpFile = new File(file, "prefs.tmp");
        this.newNode = !file.exists();
        if (this.newNode) {
            this.prefsCache = new TreeMap();
            NodeCreate nodeCreate = new NodeCreate();
            this.nodeCreate = nodeCreate;
            arrayList.add(nodeCreate);
        }
        if (isUserNode) {
            userLockFile = lockFile;
            userRootModFile = new File(lockFile.getParentFile(), lockFile.getName() + ".rootmod");
        } else {
            systemLockFile = lockFile;
            systemRootModFile = new File(lockFile.getParentFile(), lockFile.getName() + ".rootmod");
        }
    }

    private FileSystemPreferences(FileSystemPreferences parent, String name) {
        super(parent, name);
        this.prefsCache = null;
        this.lastSyncTime = 0L;
        ArrayList arrayList = new ArrayList();
        this.changeLog = arrayList;
        this.nodeCreate = null;
        this.isUserNode = parent.isUserNode;
        File file = new File(parent.dir, dirName(name));
        this.dir = file;
        this.prefsFile = new File(file, "prefs.xml");
        this.tmpFile = new File(file, "prefs.tmp");
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.prefs.FileSystemPreferences.4
            @Override // java.security.PrivilegedAction
            public Void run() {
                FileSystemPreferences.this.newNode = !r0.dir.exists();
                return null;
            }
        });
        if (this.newNode) {
            this.prefsCache = new TreeMap();
            NodeCreate nodeCreate = new NodeCreate();
            this.nodeCreate = nodeCreate;
            arrayList.add(nodeCreate);
        }
    }

    @Override // java.util.prefs.AbstractPreferences, java.util.prefs.Preferences
    public boolean isUserNode() {
        return this.isUserNode;
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void putSpi(String key, String value) {
        initCacheIfNecessary();
        this.changeLog.add(new Put(key, value));
        this.prefsCache.put(key, value);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected String getSpi(String key) {
        initCacheIfNecessary();
        return this.prefsCache.get(key);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void removeSpi(String key) {
        initCacheIfNecessary();
        this.changeLog.add(new Remove(key));
        this.prefsCache.remove(key);
    }

    private void initCacheIfNecessary() {
        if (this.prefsCache != null) {
            return;
        }
        try {
            loadCache();
        } catch (Exception e2) {
            this.prefsCache = new TreeMap();
        }
    }

    private void loadCache() throws BackingStoreException {
        Map<String, String> m10 = new TreeMap<>();
        long newLastSyncTime = 0;
        try {
            newLastSyncTime = this.prefsFile.lastModified();
            FileInputStream fis = new FileInputStream(this.prefsFile);
            try {
                XmlSupport.importMap(fis, m10);
                fis.close();
            } finally {
            }
        } catch (Exception e2) {
            if (e2 instanceof InvalidPreferencesFormatException) {
                getLogger().warning("Invalid preferences format in " + this.prefsFile.getPath());
                this.prefsFile.renameTo(new File(this.prefsFile.getParentFile(), "IncorrectFormatPrefs.xml"));
                m10 = new TreeMap<>();
            } else if (e2 instanceof FileNotFoundException) {
                getLogger().warning("Prefs file removed in background " + this.prefsFile.getPath());
            } else {
                getLogger().warning("Exception while reading cache: " + e2.getMessage());
                throw new BackingStoreException(e2);
            }
        }
        this.prefsCache = m10;
        this.lastSyncTime = newLastSyncTime;
    }

    private void writeBackCache() throws BackingStoreException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.util.prefs.FileSystemPreferences.5
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws BackingStoreException {
                    try {
                        if (!FileSystemPreferences.this.dir.exists() && !FileSystemPreferences.this.dir.mkdirs()) {
                            throw new BackingStoreException(((Object) FileSystemPreferences.this.dir) + " create failed.");
                        }
                        FileOutputStream fos = new FileOutputStream(FileSystemPreferences.this.tmpFile);
                        try {
                            XmlSupport.exportMap(fos, FileSystemPreferences.this.prefsCache);
                            fos.close();
                            if (!FileSystemPreferences.this.tmpFile.renameTo(FileSystemPreferences.this.prefsFile)) {
                                throw new BackingStoreException("Can't rename " + ((Object) FileSystemPreferences.this.tmpFile) + " to " + ((Object) FileSystemPreferences.this.prefsFile));
                            }
                            return null;
                        } finally {
                        }
                    } catch (Exception e2) {
                        if (e2 instanceof BackingStoreException) {
                            throw ((BackingStoreException) e2);
                        }
                        throw new BackingStoreException(e2);
                    }
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((BackingStoreException) e2.getException());
        }
    }

    @Override // java.util.prefs.AbstractPreferences
    protected String[] keysSpi() {
        initCacheIfNecessary();
        return (String[]) this.prefsCache.h().toArray(new String[this.prefsCache.size()]);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected String[] childrenNamesSpi() {
        return (String[]) AccessController.doPrivileged(new PrivilegedAction<String[]>() { // from class: java.util.prefs.FileSystemPreferences.6
            @Override // java.security.PrivilegedAction
            public String[] run() {
                List<String> result = new ArrayList<>();
                File[] dirContents = FileSystemPreferences.this.dir.listFiles();
                if (dirContents != null) {
                    for (int i10 = 0; i10 < dirContents.length; i10++) {
                        if (dirContents[i10].isDirectory()) {
                            result.add(FileSystemPreferences.nodeName(dirContents[i10].getName()));
                        }
                    }
                }
                return (String[]) result.toArray(FileSystemPreferences.EMPTY_STRING_ARRAY);
            }
        });
    }

    @Override // java.util.prefs.AbstractPreferences
    protected AbstractPreferences childSpi(String name) {
        return new FileSystemPreferences(this, name);
    }

    @Override // java.util.prefs.AbstractPreferences, java.util.prefs.Preferences
    public void removeNode() throws BackingStoreException {
        synchronized ((isUserNode() ? userLockFile : systemLockFile)) {
            if (!lockFile(false)) {
                throw new BackingStoreException("Couldn't get file lock.");
            }
            try {
                super.removeNode();
            } finally {
                unlockFile();
            }
        }
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void removeNodeSpi() throws BackingStoreException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.util.prefs.FileSystemPreferences.7
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws BackingStoreException {
                    if (FileSystemPreferences.this.changeLog.contains(FileSystemPreferences.this.nodeCreate)) {
                        FileSystemPreferences.this.changeLog.remove(FileSystemPreferences.this.nodeCreate);
                        FileSystemPreferences.this.nodeCreate = null;
                        return null;
                    }
                    if (!FileSystemPreferences.this.dir.exists()) {
                        return null;
                    }
                    FileSystemPreferences.this.prefsFile.delete();
                    FileSystemPreferences.this.tmpFile.delete();
                    File[] junk = FileSystemPreferences.this.dir.listFiles();
                    if (junk.length != 0) {
                        FileSystemPreferences.m3503$$Nest$smgetLogger().warning("Found extraneous files when removing node: " + ((Object) Arrays.asList(junk)));
                        for (File file : junk) {
                            file.delete();
                        }
                    }
                    if (FileSystemPreferences.this.dir.delete()) {
                        return null;
                    }
                    throw new BackingStoreException("Couldn't delete dir: " + ((Object) FileSystemPreferences.this.dir));
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((BackingStoreException) e2.getException());
        }
    }

    @Override // java.util.prefs.AbstractPreferences, java.util.prefs.Preferences
    public synchronized void sync() throws BackingStoreException {
        boolean shared;
        boolean userNode = isUserNode();
        if (userNode) {
            shared = false;
        } else {
            boolean shared2 = isSystemRootWritable;
            shared = !shared2;
        }
        synchronized ((isUserNode() ? userLockFile : systemLockFile)) {
            try {
                if (!lockFile(shared)) {
                    throw new BackingStoreException("Couldn't get file lock.");
                }
                final Long newModTime = (Long) AccessController.doPrivileged(new PrivilegedAction<Long>() { // from class: java.util.prefs.FileSystemPreferences.8
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedAction
                    public Long run() {
                        long nmt;
                        if (FileSystemPreferences.this.isUserNode()) {
                            nmt = FileSystemPreferences.userRootModFile.lastModified();
                            FileSystemPreferences.isUserRootModified = FileSystemPreferences.userRootModTime == nmt;
                        } else {
                            nmt = FileSystemPreferences.systemRootModFile.lastModified();
                            FileSystemPreferences.isSystemRootModified = FileSystemPreferences.systemRootModTime == nmt;
                        }
                        return new Long(nmt);
                    }
                });
                try {
                    super.sync();
                    AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.prefs.FileSystemPreferences.9
                        @Override // java.security.PrivilegedAction
                        public Void run() {
                            if (FileSystemPreferences.this.isUserNode()) {
                                FileSystemPreferences.userRootModTime = newModTime.longValue() + 1000;
                                FileSystemPreferences.userRootModFile.setLastModified(FileSystemPreferences.userRootModTime);
                                return null;
                            }
                            FileSystemPreferences.systemRootModTime = newModTime.longValue() + 1000;
                            FileSystemPreferences.systemRootModFile.setLastModified(FileSystemPreferences.systemRootModTime);
                            return null;
                        }
                    });
                } finally {
                    unlockFile();
                }
            } finally {
                th = th;
                while (true) {
                    try {
                        break;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        }
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void syncSpi() throws BackingStoreException {
        syncSpiPrivileged();
    }

    private void syncSpiPrivileged() throws BackingStoreException {
        if (isRemoved()) {
            throw new IllegalStateException("Node has been removed");
        }
        if (this.prefsCache == null) {
            return;
        }
        if (!isUserNode() ? !isSystemRootModified : !isUserRootModified) {
            long lastModifiedTime = this.prefsFile.lastModified();
            if (lastModifiedTime != this.lastSyncTime) {
                loadCache();
                replayChanges();
                this.lastSyncTime = lastModifiedTime;
            }
        } else if (this.lastSyncTime != 0 && !this.dir.exists()) {
            this.prefsCache = new TreeMap();
            replayChanges();
        }
        if (!this.changeLog.isEmpty()) {
            writeBackCache();
            long lastModifiedTime2 = this.prefsFile.lastModified();
            if (this.lastSyncTime <= lastModifiedTime2) {
                long j10 = 1000 + lastModifiedTime2;
                this.lastSyncTime = j10;
                this.prefsFile.setLastModified(j10);
            }
            this.changeLog.clear();
        }
    }

    @Override // java.util.prefs.AbstractPreferences, java.util.prefs.Preferences
    public void flush() throws BackingStoreException {
        if (isRemoved()) {
            return;
        }
        sync();
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void flushSpi() throws BackingStoreException {
    }

    private static boolean isDirChar(char ch) {
        return (ch <= 31 || ch >= 127 || ch == '/' || ch == '.' || ch == '_') ? false : true;
    }

    private static String dirName(String nodeName) {
        int n10 = nodeName.length();
        for (int i10 = 0; i10 < n10; i10++) {
            if (!isDirChar(nodeName.charAt(i10))) {
                return "_" + Base64.byteArrayToAltBase64(byteArray(nodeName));
            }
        }
        return nodeName;
    }

    private static byte[] byteArray(String s2) {
        int len = s2.length();
        byte[] result = new byte[len * 2];
        int j10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = s2.charAt(i10);
            int j11 = j10 + 1;
            result[j10] = (byte) (c4 >> '\b');
            j10 = j11 + 1;
            result[j11] = (byte) c4;
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String nodeName(String dirName) {
        if (dirName.charAt(0) != '_') {
            return dirName;
        }
        byte[] a10 = Base64.altBase64ToByteArray(dirName.substring(1));
        StringBuffer result = new StringBuffer(a10.length / 2);
        int highByte = 0;
        while (highByte < a10.length) {
            int i10 = highByte + 1;
            int highByte2 = a10[highByte] & 255;
            int i11 = i10 + 1;
            int lowByte = a10[i10] & 255;
            result.append((char) ((highByte2 << 8) | lowByte));
            highByte = i11;
        }
        return result.toString();
    }

    private boolean lockFile(boolean shared) throws SecurityException {
        boolean usernode = isUserNode();
        int errorCode = 0;
        File lockFile = usernode ? userLockFile : systemLockFile;
        long sleepTime = INIT_SLEEP_TIME;
        for (int i10 = 0; i10 < MAX_ATTEMPTS; i10++) {
            int perm = usernode ? 384 : USER_RW_ALL_READ;
            try {
                int[] result = lockFile0(lockFile.getCanonicalPath(), perm, shared);
                errorCode = result[1];
                if (result[0] != 0) {
                    if (usernode) {
                        userRootLockHandle = result[0];
                    } else {
                        systemRootLockHandle = result[0];
                    }
                    return true;
                }
            } catch (IOException e2) {
            }
            try {
                Thread.sleep(sleepTime);
                sleepTime *= 2;
            } catch (InterruptedException e10) {
                checkLockFile0ErrorCode(errorCode);
                Thread.currentThread().interrupt();
                return false;
            }
        }
        checkLockFile0ErrorCode(errorCode);
        return false;
    }

    private void checkLockFile0ErrorCode(int errorCode) throws SecurityException {
        if (errorCode == 13) {
            throw new SecurityException("Could not lock " + (isUserNode() ? "User prefs." : "System prefs.") + " Lock file access denied.");
        }
        if (errorCode != 11) {
            getLogger().warning("Could not lock " + (isUserNode() ? "User prefs. " : "System prefs.") + " Unix error code " + errorCode + ".");
        }
    }

    private void unlockFile() {
        boolean usernode = isUserNode();
        if (usernode) {
            File file = userLockFile;
        } else {
            File file2 = systemLockFile;
        }
        int lockHandle = usernode ? userRootLockHandle : systemRootLockHandle;
        String str = UserData.NAME;
        if (lockHandle == 0) {
            PlatformLogger logger = getLogger();
            StringBuilder append = new StringBuilder().append("Unlock: zero lockHandle for ");
            if (!usernode) {
                str = "system";
            }
            logger.warning(append.append(str).append(" preferences.)").toString());
            return;
        }
        int result = unlockFile0(lockHandle);
        if (result != 0) {
            PlatformLogger logger2 = getLogger();
            StringBuilder append2 = new StringBuilder().append("Could not drop file-lock on ");
            if (!isUserNode()) {
                str = "system";
            }
            logger2.warning(append2.append(str).append(" preferences. Unix error code ").append(result).append(".").toString());
            if (result == 13) {
                throw new SecurityException("Could not unlock" + (isUserNode() ? "User prefs." : "System prefs.") + " Lock file access denied.");
            }
        }
        if (isUserNode()) {
            userRootLockHandle = 0;
        } else {
            systemRootLockHandle = 0;
        }
    }
}
