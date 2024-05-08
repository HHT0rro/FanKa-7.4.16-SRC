package java.util.logging;

import com.alipay.sdk.util.i;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import java.util.logging.LogManager;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Logger {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean anonymous;
    private WeakReference<ClassLoader> callersClassLoaderRef;
    private ResourceBundle catalog;
    private Locale catalogLocale;
    private String catalogName;
    private volatile Filter filter;
    private final CopyOnWriteArrayList<Handler> handlers;
    private final boolean isSystemLogger;
    private ArrayList<LogManager.LoggerWeakRef> kids;
    private volatile Level levelObject;
    private volatile int levelValue;
    private volatile LoggerBundle loggerBundle;
    private volatile LogManager manager;
    private String name;
    private volatile Logger parent;
    private volatile boolean useParentHandlers;
    private static final Handler[] emptyHandlers = new Handler[0];
    private static final int offValue = Level.OFF.intValue();
    static final String SYSTEM_LOGGER_RB_NAME = "sun.util.logging.resources.logging";
    private static final LoggerBundle SYSTEM_BUNDLE = new LoggerBundle(SYSTEM_LOGGER_RB_NAME, null);
    private static final LoggerBundle NO_RESOURCE_BUNDLE = new LoggerBundle(0 == true ? 1 : 0, 0 == true ? 1 : 0);
    private static final Object treeLock = new Object();
    public static final String GLOBAL_LOGGER_NAME = "global";

    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LoggerBundle {
        final String resourceBundleName;
        final ResourceBundle userBundle;

        private LoggerBundle(String resourceBundleName, ResourceBundle bundle) {
            this.resourceBundleName = resourceBundleName;
            this.userBundle = bundle;
        }

        boolean isSystemBundle() {
            return Logger.SYSTEM_LOGGER_RB_NAME.equals(this.resourceBundleName);
        }

        static LoggerBundle get(String name, ResourceBundle bundle) {
            if (name == null && bundle == null) {
                return Logger.NO_RESOURCE_BUNDLE;
            }
            if (Logger.SYSTEM_LOGGER_RB_NAME.equals(name) && bundle == null) {
                return Logger.SYSTEM_BUNDLE;
            }
            return new LoggerBundle(name, bundle);
        }
    }

    public static final Logger getGlobal() {
        LogManager.getLogManager();
        return global;
    }

    protected Logger(String name, String resourceBundleName) {
        this(name, resourceBundleName, null, LogManager.getLogManager(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger(String name, String resourceBundleName, Class<?> caller, LogManager manager, boolean isSystemLogger) {
        this.handlers = new CopyOnWriteArrayList<>();
        this.loggerBundle = NO_RESOURCE_BUNDLE;
        this.useParentHandlers = true;
        this.manager = manager;
        this.isSystemLogger = isSystemLogger;
        setupResourceInfo(resourceBundleName, caller);
        this.name = name;
        this.levelValue = Level.INFO.intValue();
    }

    private void setCallersClassLoaderRef(Class<?> caller) {
        ClassLoader callersClassLoader;
        if (caller != null) {
            callersClassLoader = caller.getClassLoader();
        } else {
            callersClassLoader = null;
        }
        if (callersClassLoader != null) {
            this.callersClassLoaderRef = new WeakReference<>(callersClassLoader);
        }
    }

    private ClassLoader getCallersClassLoader() {
        WeakReference<ClassLoader> weakReference = this.callersClassLoaderRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private Logger(String name) {
        this.handlers = new CopyOnWriteArrayList<>();
        this.loggerBundle = NO_RESOURCE_BUNDLE;
        this.useParentHandlers = true;
        this.name = name;
        this.isSystemLogger = true;
        this.levelValue = Level.INFO.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLogManager(LogManager manager) {
        this.manager = manager;
    }

    private void checkPermission() throws SecurityException {
        if (!this.anonymous) {
            if (this.manager == null) {
                this.manager = LogManager.getLogManager();
            }
            this.manager.checkPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SystemLoggerHelper {
        static boolean disableCallerCheck = getBooleanProperty("sun.util.logging.disableCallerCheck");

        private SystemLoggerHelper() {
        }

        private static boolean getBooleanProperty(final String key) {
            String s2 = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: java.util.logging.Logger.SystemLoggerHelper.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty(String.this);
                }
            });
            return Boolean.valueOf(s2).booleanValue();
        }
    }

    private static Logger demandLogger(String name, String resourceBundleName, Class<?> caller) {
        LogManager manager = LogManager.getLogManager();
        SecurityManager sm = System.getSecurityManager();
        if (sm != null && !SystemLoggerHelper.disableCallerCheck && caller.getClassLoader() == null) {
            return manager.demandSystemLogger(name, resourceBundleName);
        }
        return manager.demandLogger(name, resourceBundleName, caller);
    }

    @CallerSensitive
    public static Logger getLogger(String name) {
        return demandLogger(name, null, Reflection.getCallerClass());
    }

    @CallerSensitive
    public static Logger getLogger(String name, String resourceBundleName) {
        Class<?> callerClass = Reflection.getCallerClass();
        Logger result = demandLogger(name, resourceBundleName, callerClass);
        result.setupResourceInfo(resourceBundleName, callerClass);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Logger getPlatformLogger(String name) {
        LogManager manager = LogManager.getLogManager();
        Logger result = manager.demandSystemLogger(name, SYSTEM_LOGGER_RB_NAME);
        return result;
    }

    public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    @CallerSensitive
    public static Logger getAnonymousLogger(String resourceBundleName) {
        LogManager manager = LogManager.getLogManager();
        manager.drainLoggerRefQueueBounded();
        Logger result = new Logger(null, resourceBundleName, Reflection.getCallerClass(), manager, false);
        result.anonymous = true;
        Logger root = manager.getLogger("");
        result.doSetParent(root);
        return result;
    }

    public ResourceBundle getResourceBundle() {
        return findResourceBundle(getResourceBundleName(), true);
    }

    public String getResourceBundleName() {
        return this.loggerBundle.resourceBundleName;
    }

    public void setFilter(Filter newFilter) throws SecurityException {
        checkPermission();
        this.filter = newFilter;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public void log(LogRecord record) {
        Handler[] loggerHandlers;
        boolean useParentHdls;
        if (!isLoggable(record.getLevel())) {
            return;
        }
        Filter theFilter = this.filter;
        if (theFilter != null && !theFilter.isLoggable(record)) {
            return;
        }
        Logger logger = this;
        while (logger != null) {
            if (this.isSystemLogger) {
                loggerHandlers = logger.accessCheckedHandlers();
            } else {
                loggerHandlers = logger.getHandlers();
            }
            for (Handler handler : loggerHandlers) {
                handler.publish(record);
            }
            if (this.isSystemLogger) {
                useParentHdls = logger.useParentHandlers;
            } else {
                useParentHdls = logger.getUseParentHandlers();
            }
            if (useParentHdls) {
                logger = this.isSystemLogger ? logger.parent : logger.getParent();
            } else {
                return;
            }
        }
    }

    private void doLog(LogRecord lr) {
        lr.setLoggerName(this.name);
        LoggerBundle lb2 = getEffectiveLoggerBundle();
        ResourceBundle bundle = lb2.userBundle;
        String ebname = lb2.resourceBundleName;
        if (ebname != null && bundle != null) {
            lr.setResourceBundleName(ebname);
            lr.setResourceBundle(bundle);
        }
        log(lr);
    }

    public void log(Level level, String msg) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        doLog(lr);
    }

    public void log(Level level, Supplier<String> msgSupplier) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msgSupplier.get());
        doLog(lr);
    }

    public void log(Level level, String msg, Object param1) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        Object[] params = {param1};
        lr.setParameters(params);
        doLog(lr);
    }

    public void log(Level level, String msg, Object[] params) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setParameters(params);
        doLog(lr);
    }

    public void log(Level level, String msg, Throwable thrown) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setThrown(thrown);
        doLog(lr);
    }

    public void log(Level level, Throwable thrown, Supplier<String> msgSupplier) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msgSupplier.get());
        lr.setThrown(thrown);
        doLog(lr);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        doLog(lr);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, Supplier<String> msgSupplier) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msgSupplier.get());
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        doLog(lr);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object param1) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        Object[] params = {param1};
        lr.setParameters(params);
        doLog(lr);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] params) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setParameters(params);
        doLog(lr);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Throwable thrown) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setThrown(thrown);
        doLog(lr);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, Throwable thrown, Supplier<String> msgSupplier) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msgSupplier.get());
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setThrown(thrown);
        doLog(lr);
    }

    private void doLog(LogRecord lr, String rbname) {
        lr.setLoggerName(this.name);
        if (rbname != null) {
            lr.setResourceBundleName(rbname);
            lr.setResourceBundle(findResourceBundle(rbname, false));
        }
        log(lr);
    }

    private void doLog(LogRecord lr, ResourceBundle rb2) {
        lr.setLoggerName(this.name);
        if (rb2 != null) {
            lr.setResourceBundleName(rb2.getBaseBundleName());
            lr.setResourceBundle(rb2);
        }
        log(lr);
    }

    @Deprecated
    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        doLog(lr, bundleName);
    }

    @Deprecated
    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object param1) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        Object[] params = {param1};
        lr.setParameters(params);
        doLog(lr, bundleName);
    }

    @Deprecated
    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object[] params) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setParameters(params);
        doLog(lr, bundleName);
    }

    public void logrb(Level level, String sourceClass, String sourceMethod, ResourceBundle bundle, String msg, Object... params) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        if (params != null && params.length != 0) {
            lr.setParameters(params);
        }
        doLog(lr, bundle);
    }

    @Deprecated
    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Throwable thrown) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setThrown(thrown);
        doLog(lr, bundleName);
    }

    public void logrb(Level level, String sourceClass, String sourceMethod, ResourceBundle bundle, String msg, Throwable thrown) {
        if (!isLoggable(level)) {
            return;
        }
        LogRecord lr = new LogRecord(level, msg);
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setThrown(thrown);
        doLog(lr, bundle);
    }

    public void entering(String sourceClass, String sourceMethod) {
        logp(Level.FINER, sourceClass, sourceMethod, "ENTRY");
    }

    public void entering(String sourceClass, String sourceMethod, Object param1) {
        logp(Level.FINER, sourceClass, sourceMethod, "ENTRY {0}", param1);
    }

    public void entering(String sourceClass, String sourceMethod, Object[] params) {
        String msg = "ENTRY";
        if (params == null) {
            logp(Level.FINER, sourceClass, sourceMethod, "ENTRY");
            return;
        }
        if (isLoggable(Level.FINER)) {
            for (int i10 = 0; i10 < params.length; i10++) {
                msg = msg + " {" + i10 + i.f4738d;
            }
            logp(Level.FINER, sourceClass, sourceMethod, msg, params);
        }
    }

    public void exiting(String sourceClass, String sourceMethod) {
        logp(Level.FINER, sourceClass, sourceMethod, "RETURN");
    }

    public void exiting(String sourceClass, String sourceMethod, Object result) {
        logp(Level.FINER, sourceClass, sourceMethod, "RETURN {0}", result);
    }

    public void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
        if (!isLoggable(Level.FINER)) {
            return;
        }
        LogRecord lr = new LogRecord(Level.FINER, "THROW");
        lr.setSourceClassName(sourceClass);
        lr.setSourceMethodName(sourceMethod);
        lr.setThrown(thrown);
        doLog(lr);
    }

    public void severe(String msg) {
        log(Level.SEVERE, msg);
    }

    public void warning(String msg) {
        log(Level.WARNING, msg);
    }

    public void info(String msg) {
        log(Level.INFO, msg);
    }

    public void config(String msg) {
        log(Level.CONFIG, msg);
    }

    public void fine(String msg) {
        log(Level.FINE, msg);
    }

    public void finer(String msg) {
        log(Level.FINER, msg);
    }

    public void finest(String msg) {
        log(Level.FINEST, msg);
    }

    public void severe(Supplier<String> msgSupplier) {
        log(Level.SEVERE, msgSupplier);
    }

    public void warning(Supplier<String> msgSupplier) {
        log(Level.WARNING, msgSupplier);
    }

    public void info(Supplier<String> msgSupplier) {
        log(Level.INFO, msgSupplier);
    }

    public void config(Supplier<String> msgSupplier) {
        log(Level.CONFIG, msgSupplier);
    }

    public void fine(Supplier<String> msgSupplier) {
        log(Level.FINE, msgSupplier);
    }

    public void finer(Supplier<String> msgSupplier) {
        log(Level.FINER, msgSupplier);
    }

    public void finest(Supplier<String> msgSupplier) {
        log(Level.FINEST, msgSupplier);
    }

    public void setLevel(Level newLevel) throws SecurityException {
        checkPermission();
        synchronized (treeLock) {
            this.levelObject = newLevel;
            updateEffectiveLevel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isLevelInitialized() {
        return this.levelObject != null;
    }

    public Level getLevel() {
        return this.levelObject;
    }

    public boolean isLoggable(Level level) {
        if (level.intValue() < this.levelValue || this.levelValue == offValue) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public void addHandler(Handler handler) throws SecurityException {
        handler.getClass();
        checkPermission();
        this.handlers.add(handler);
    }

    public void removeHandler(Handler handler) throws SecurityException {
        checkPermission();
        if (handler == null) {
            return;
        }
        this.handlers.remove(handler);
    }

    public Handler[] getHandlers() {
        return accessCheckedHandlers();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler[] accessCheckedHandlers() {
        return (Handler[]) this.handlers.toArray(emptyHandlers);
    }

    public void setUseParentHandlers(boolean useParentHandlers) {
        checkPermission();
        this.useParentHandlers = useParentHandlers;
    }

    public boolean getUseParentHandlers() {
        return this.useParentHandlers;
    }

    private static ResourceBundle findSystemResourceBundle(final Locale locale) {
        return (ResourceBundle) AccessController.doPrivileged(new PrivilegedAction<ResourceBundle>() { // from class: java.util.logging.Logger.1
            @Override // java.security.PrivilegedAction
            public ResourceBundle run() {
                try {
                    return ResourceBundle.getBundle(Logger.SYSTEM_LOGGER_RB_NAME, Locale.this, ClassLoader.getSystemClassLoader());
                } catch (MissingResourceException e2) {
                    throw new InternalError(e2.toString());
                }
            }
        });
    }

    private synchronized ResourceBundle findResourceBundle(String name, boolean useCallersClassLoader) {
        ClassLoader callersClassLoader;
        if (name == null) {
            return null;
        }
        Locale currentLocale = Locale.getDefault();
        LoggerBundle lb2 = this.loggerBundle;
        if (lb2.userBundle != null && name.equals(lb2.resourceBundleName)) {
            return lb2.userBundle;
        }
        if (this.catalog != null && currentLocale.equals(this.catalogLocale) && name.equals(this.catalogName)) {
            return this.catalog;
        }
        if (name.equals(SYSTEM_LOGGER_RB_NAME)) {
            ResourceBundle findSystemResourceBundle = findSystemResourceBundle(currentLocale);
            this.catalog = findSystemResourceBundle;
            this.catalogName = name;
            this.catalogLocale = currentLocale;
            return findSystemResourceBundle;
        }
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassLoader.getSystemClassLoader();
        }
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(name, currentLocale, cl);
            this.catalog = bundle;
            this.catalogName = name;
            this.catalogLocale = currentLocale;
            return bundle;
        } catch (MissingResourceException e2) {
            if (!useCallersClassLoader || (callersClassLoader = getCallersClassLoader()) == null || callersClassLoader == cl) {
                return null;
            }
            try {
                ResourceBundle bundle2 = ResourceBundle.getBundle(name, currentLocale, callersClassLoader);
                this.catalog = bundle2;
                this.catalogName = name;
                this.catalogLocale = currentLocale;
                return bundle2;
            } catch (MissingResourceException e10) {
                return null;
            }
        }
    }

    private synchronized void setupResourceInfo(String name, Class<?> callersClass) {
        LoggerBundle lb2 = this.loggerBundle;
        if (lb2.resourceBundleName != null) {
            if (!lb2.resourceBundleName.equals(name)) {
                throw new IllegalArgumentException(lb2.resourceBundleName + " != " + name);
            }
        } else {
            if (name == null) {
                return;
            }
            setCallersClassLoaderRef(callersClass);
            if (this.isSystemLogger && getCallersClassLoader() != null) {
                checkPermission();
            }
            if (findResourceBundle(name, true) == null) {
                this.callersClassLoaderRef = null;
                throw new MissingResourceException("Can't find " + name + " bundle", name, "");
            }
            this.loggerBundle = LoggerBundle.get(name, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[Catch: all -> 0x0034, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0016, B:14:0x0024, B:15:0x002a, B:18:0x002c, B:19:0x0033), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[Catch: all -> 0x0034, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0016, B:14:0x0024, B:15:0x002a, B:18:0x002c, B:19:0x0033), top: B:6:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setResourceBundle(java.util.ResourceBundle r6) {
        /*
            r5 = this;
            r5.checkPermission()
            java.lang.String r0 = r6.getBaseBundleName()
            if (r0 == 0) goto L37
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L37
            monitor-enter(r5)
            java.util.logging.Logger$LoggerBundle r1 = r5.loggerBundle     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = r1.resourceBundleName     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L21
            java.lang.String r2 = r1.resourceBundleName     // Catch: java.lang.Throwable -> L34
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L1f
            goto L21
        L1f:
            r2 = 0
            goto L22
        L21:
            r2 = 1
        L22:
            if (r2 == 0) goto L2c
            java.util.logging.Logger$LoggerBundle r3 = java.util.logging.Logger.LoggerBundle.get(r0, r6)     // Catch: java.lang.Throwable -> L34
            r5.loggerBundle = r3     // Catch: java.lang.Throwable -> L34
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L34
            return
        L2c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "can't replace resource bundle"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L34
            throw r3     // Catch: java.lang.Throwable -> L34
        L34:
            r1 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L34
            throw r1
        L37:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "resource bundle must have a name"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Logger.setResourceBundle(java.util.ResourceBundle):void");
    }

    public Logger getParent() {
        return this.parent;
    }

    public void setParent(Logger parent) {
        if (parent == null) {
            throw new NullPointerException();
        }
        if (this.manager == null) {
            this.manager = LogManager.getLogManager();
        }
        this.manager.checkPermission();
        doSetParent(parent);
    }

    private void doSetParent(Logger newParent) {
        synchronized (treeLock) {
            LogManager.LoggerWeakRef ref = null;
            if (this.parent != null) {
                Iterator<LogManager.LoggerWeakRef> iter = this.parent.kids.iterator2();
                while (true) {
                    if (!iter.hasNext()) {
                        break;
                    }
                    ref = iter.next();
                    Logger kid = ref.get();
                    if (kid == this) {
                        iter.remove();
                        break;
                    }
                    ref = null;
                }
            }
            this.parent = newParent;
            if (this.parent.kids == null) {
                this.parent.kids = new ArrayList<>(2);
            }
            if (ref == null) {
                LogManager logManager = this.manager;
                Objects.requireNonNull(logManager);
                ref = new LogManager.LoggerWeakRef(this);
            }
            ref.setParentRef(new WeakReference<>(this.parent));
            this.parent.kids.add(ref);
            updateEffectiveLevel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void removeChildLogger(LogManager.LoggerWeakRef child) {
        synchronized (treeLock) {
            Iterator<LogManager.LoggerWeakRef> iter = this.kids.iterator2();
            while (iter.hasNext()) {
                LogManager.LoggerWeakRef ref = iter.next();
                if (ref == child) {
                    iter.remove();
                    return;
                }
            }
        }
    }

    private void updateEffectiveLevel() {
        int newLevelValue;
        if (this.levelObject != null) {
            newLevelValue = this.levelObject.intValue();
        } else if (this.parent != null) {
            newLevelValue = this.parent.levelValue;
        } else {
            newLevelValue = Level.INFO.intValue();
        }
        if (this.levelValue == newLevelValue) {
            return;
        }
        this.levelValue = newLevelValue;
        if (this.kids != null) {
            for (int i10 = 0; i10 < this.kids.size(); i10++) {
                LogManager.LoggerWeakRef ref = this.kids.get(i10);
                Logger kid = ref.get();
                if (kid != null) {
                    kid.updateEffectiveLevel();
                }
            }
        }
    }

    private LoggerBundle getEffectiveLoggerBundle() {
        String rbName;
        LoggerBundle lb2 = this.loggerBundle;
        if (lb2.isSystemBundle()) {
            return SYSTEM_BUNDLE;
        }
        ResourceBundle b4 = getResourceBundle();
        if (b4 != null && b4 == lb2.userBundle) {
            return lb2;
        }
        if (b4 != null) {
            String rbName2 = getResourceBundleName();
            return LoggerBundle.get(rbName2, b4);
        }
        Logger target = this.parent;
        while (target != null) {
            LoggerBundle trb = target.loggerBundle;
            if (trb.isSystemBundle()) {
                return SYSTEM_BUNDLE;
            }
            if (trb.userBundle != null) {
                return trb;
            }
            if (this.isSystemLogger) {
                rbName = target.isSystemLogger ? trb.resourceBundleName : null;
            } else {
                rbName = target.getResourceBundleName();
            }
            if (rbName != null) {
                return LoggerBundle.get(rbName, findResourceBundle(rbName, true));
            }
            target = this.isSystemLogger ? target.parent : target.getParent();
        }
        return NO_RESOURCE_BUNDLE;
    }
}
