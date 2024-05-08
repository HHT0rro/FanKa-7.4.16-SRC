package java.lang;

import android.system.OsConstants;
import com.huawei.openalliance.ad.constant.u;
import dalvik.annotation.optimization.FastNative;
import dalvik.system.BlockGuard;
import dalvik.system.DelegateLastClassLoader;
import dalvik.system.PathClassLoader;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import libcore.io.Libcore;
import libcore.util.EmptyArray;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Runtime {
    private static final Runtime currentRuntime = new Runtime();
    private static boolean finalizeOnExit;
    private boolean shuttingDown;
    private List<Thread> shutdownHooks = new ArrayList();
    private volatile String[] mLibPaths = null;

    private static native void nativeExit(int i10);

    private native void nativeGc();

    private static native String nativeLoad(String str, ClassLoader classLoader, Class<?> cls);

    @FastNative
    public native long freeMemory();

    @FastNative
    public native long maxMemory();

    @FastNative
    public native long totalMemory();

    public static Runtime getRuntime() {
        return currentRuntime;
    }

    private Runtime() {
    }

    public void exit(int status) {
        Thread[] hooks;
        synchronized (this) {
            if (!this.shuttingDown) {
                this.shuttingDown = true;
                synchronized (this.shutdownHooks) {
                    hooks = new Thread[this.shutdownHooks.size()];
                    this.shutdownHooks.toArray(hooks);
                }
                for (Thread hook : hooks) {
                    hook.start();
                }
                for (Thread hook2 : hooks) {
                    try {
                        hook2.join();
                    } catch (InterruptedException e2) {
                    }
                }
                if (finalizeOnExit) {
                    runFinalization();
                }
                nativeExit(status);
            }
        }
    }

    public void addShutdownHook(Thread hook) {
        if (hook == null) {
            throw new NullPointerException("hook == null");
        }
        if (this.shuttingDown) {
            throw new IllegalStateException("VM already shutting down");
        }
        if (hook.started) {
            throw new IllegalArgumentException("Hook has already been started");
        }
        synchronized (this.shutdownHooks) {
            if (this.shutdownHooks.contains(hook)) {
                throw new IllegalArgumentException("Hook already registered.");
            }
            this.shutdownHooks.add(hook);
        }
    }

    public boolean removeShutdownHook(Thread hook) {
        boolean remove;
        if (hook == null) {
            throw new NullPointerException("hook == null");
        }
        if (this.shuttingDown) {
            throw new IllegalStateException("VM already shutting down");
        }
        synchronized (this.shutdownHooks) {
            remove = this.shutdownHooks.remove(hook);
        }
        return remove;
    }

    public void halt(int status) {
        nativeExit(status);
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        finalizeOnExit = value;
    }

    public Process exec(String command) throws IOException {
        return exec(command, (String[]) null, (File) null);
    }

    public Process exec(String command, String[] envp) throws IOException {
        return exec(command, envp, (File) null);
    }

    public Process exec(String command, String[] envp, File dir) throws IOException {
        if (command.length() == 0) {
            throw new IllegalArgumentException("Empty command");
        }
        StringTokenizer st = new StringTokenizer(command);
        String[] cmdarray = new String[st.countTokens()];
        int i10 = 0;
        while (st.hasMoreTokens()) {
            cmdarray[i10] = st.nextToken();
            i10++;
        }
        return exec(cmdarray, envp, dir);
    }

    public Process exec(String[] cmdarray) throws IOException {
        return exec(cmdarray, (String[]) null, (File) null);
    }

    public Process exec(String[] cmdarray, String[] envp) throws IOException {
        return exec(cmdarray, envp, (File) null);
    }

    public Process exec(String[] cmdarray, String[] envp, File dir) throws IOException {
        return new ProcessBuilder(cmdarray).environment(envp).directory(dir).start();
    }

    public int availableProcessors() {
        return (int) Libcore.os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
    }

    public void gc() {
        BlockGuard.getThreadPolicy().onExplicitGc();
        nativeGc();
    }

    public void runFinalization() {
        VMRuntime.runFinalization(0L);
    }

    @Deprecated(forRemoval = true, since = "9")
    public void traceInstructions(boolean on) {
    }

    @Deprecated(forRemoval = true, since = "9")
    public void traceMethodCalls(boolean on) {
        if (on) {
            throw new UnsupportedOperationException();
        }
    }

    @CallerSensitive
    public void load(String filename) {
        load0(Reflection.getCallerClass(), filename);
    }

    private void checkTargetSdkVersionForLoad(String methodName) {
        int targetSdkVersion = VMRuntime.getRuntime().getTargetSdkVersion();
        if (targetSdkVersion > 24) {
            throw new UnsupportedOperationException(methodName + " is not supported on SDK " + targetSdkVersion);
        }
    }

    void load(String absolutePath, ClassLoader loader) {
        checkTargetSdkVersionForLoad("java.lang.Runtime#load(String, ClassLoader)");
        System.logE("java.lang.Runtime#load(String, ClassLoader) is private and will be removed in a future Android release");
        if (absolutePath == null) {
            throw new NullPointerException("absolutePath == null");
        }
        String error = nativeLoad(absolutePath, loader);
        if (error != null) {
            throw new UnsatisfiedLinkError(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void load0(Class<?> fromClass, String filename) {
        if (!new File(filename).isAbsolute()) {
            throw new UnsatisfiedLinkError("Expecting an absolute path of the library: " + filename);
        }
        if (filename == null) {
            throw new NullPointerException("filename == null");
        }
        String error = nativeLoad(filename, fromClass.getClassLoader());
        if (error != null) {
            throw new UnsatisfiedLinkError(error);
        }
    }

    @CallerSensitive
    public void loadLibrary(String libname) {
        loadLibrary0(Reflection.getCallerClass(), libname);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLibrary0(Class<?> fromClass, String libname) {
        ClassLoader classLoader = ClassLoader.getClassLoader(fromClass);
        loadLibrary0(classLoader, fromClass, libname);
    }

    public void loadLibrary(String libname, ClassLoader classLoader) {
        checkTargetSdkVersionForLoad("java.lang.Runtime#loadLibrary(String, ClassLoader)");
        System.logE("java.lang.Runtime#loadLibrary(String, ClassLoader) is private and will be removed in a future Android release");
        loadLibrary0(classLoader, null, libname);
    }

    void loadLibrary0(ClassLoader loader, String libname) {
        loadLibrary0(loader, null, libname);
    }

    private synchronized void loadLibrary0(ClassLoader loader, Class<?> callerClass, String libname) {
        if (libname.indexOf(File.separatorChar) != -1) {
            throw new UnsatisfiedLinkError("Directory separator should not appear in library name: " + libname);
        }
        if (loader != null && !(loader instanceof BootClassLoader)) {
            String filename = loader.findLibrary(libname);
            if (filename == null && (loader.getClass() == PathClassLoader.class || loader.getClass() == DelegateLastClassLoader.class)) {
                filename = System.mapLibraryName(libname);
            }
            if (filename == null) {
                throw new UnsatisfiedLinkError(((Object) loader) + " couldn't find \"" + System.mapLibraryName(libname) + "\"");
            }
            String error = nativeLoad(filename, loader);
            if (error != null) {
                throw new UnsatisfiedLinkError(error);
            }
            return;
        }
        getLibPaths();
        String error2 = nativeLoad(System.mapLibraryName(libname), loader, callerClass);
        if (error2 != null) {
            throw new UnsatisfiedLinkError(error2);
        }
    }

    private String[] getLibPaths() {
        if (this.mLibPaths == null) {
            synchronized (this) {
                if (this.mLibPaths == null) {
                    this.mLibPaths = initLibPaths();
                }
            }
        }
        return this.mLibPaths;
    }

    private static String[] initLibPaths() {
        String javaLibraryPath = System.getProperty("java.library.path");
        if (javaLibraryPath == null) {
            return EmptyArray.STRING;
        }
        String[] paths = javaLibraryPath.split(u.bD);
        for (int i10 = 0; i10 < paths.length; i10++) {
            if (!paths[i10].endsWith("/")) {
                paths[i10] = paths[i10] + "/";
            }
        }
        return paths;
    }

    private static String nativeLoad(String filename, ClassLoader loader) {
        return nativeLoad(filename, loader, null);
    }

    @Deprecated
    public InputStream getLocalizedInputStream(InputStream in) {
        return in;
    }

    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream out) {
        return out;
    }
}
