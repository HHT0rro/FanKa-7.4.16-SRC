package java.util.logging;

import com.android.internal.content.NativeLibraryHelper;
import com.huawei.flexiblelayout.card.FLPNode;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.WeakHashMap;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LogManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
    private static final int MAX_ITERATIONS = 400;
    private WeakHashMap<Object, LoggerContext> contextsMap;
    private final Permission controlPermission;
    private boolean deathImminent;
    private volatile boolean initializationDone;
    private boolean initializedCalled;
    private boolean initializedGlobalHandlers;
    private final Map<Object, Integer> listenerMap;
    private final ReferenceQueue<Logger> loggerRefQueue;
    private volatile Properties props;
    private volatile boolean readPrimordialConfiguration;
    private volatile Logger rootLogger;
    private final LoggerContext systemContext;
    private final LoggerContext userContext;
    private static final Level defaultLevel = Level.INFO;
    private static final LogManager manager = (LogManager) AccessController.doPrivileged(new PrivilegedAction<LogManager>() { // from class: java.util.logging.LogManager.1
        @Override // java.security.PrivilegedAction
        public LogManager run() {
            LogManager mgr = null;
            String cname = null;
            try {
                cname = System.getProperty("java.util.logging.manager");
                if (cname != null) {
                    mgr = (LogManager) LogManager.getClassInstance(cname).newInstance();
                }
            } catch (Exception ex) {
                System.err.println("Could not load Logmanager \"" + cname + "\"");
                ex.printStackTrace();
            }
            if (mgr == null) {
                return new LogManager();
            }
            return mgr;
        }
    });
    private static LoggingMXBean loggingMXBean = null;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Cleaner extends Thread {
        private Cleaner() {
            setContextClassLoader(null);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            LogManager unused = LogManager.manager;
            synchronized (LogManager.this) {
                LogManager.this.deathImminent = true;
                LogManager.this.initializedGlobalHandlers = true;
            }
            LogManager.this.reset();
        }
    }

    protected LogManager() {
        this(checkSubclassPermissions());
    }

    private LogManager(Void r42) {
        this.props = new Properties();
        this.listenerMap = new HashMap();
        this.systemContext = new SystemLoggerContext();
        byte b4 = 0;
        this.userContext = new LoggerContext();
        this.initializedGlobalHandlers = true;
        this.initializedCalled = false;
        this.initializationDone = false;
        this.contextsMap = null;
        this.loggerRefQueue = new ReferenceQueue<>();
        this.controlPermission = new LoggingPermission("control", null);
        try {
            Runtime.getRuntime().addShutdownHook(new Cleaner());
        } catch (IllegalStateException e2) {
        }
    }

    private static Void checkSubclassPermissions() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("shutdownHooks"));
            sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            return null;
        }
        return null;
    }

    final void ensureLogManagerInitialized() {
        if (this.initializationDone || this != manager) {
            return;
        }
        synchronized (this) {
            boolean isRecursiveInitialization = this.initializedCalled;
            if (!isRecursiveInitialization && !this.initializationDone) {
                this.initializedCalled = true;
                try {
                    AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: java.util.logging.LogManager.2
                        static final /* synthetic */ boolean $assertionsDisabled = false;

                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            owner.readPrimordialConfiguration();
                            LogManager logManager = owner;
                            LogManager logManager2 = owner;
                            Objects.requireNonNull(logManager2);
                            logManager.rootLogger = new RootLogger();
                            LogManager logManager3 = owner;
                            logManager3.addLogger(logManager3.rootLogger);
                            if (!owner.rootLogger.isLevelInitialized()) {
                                owner.rootLogger.setLevel(LogManager.defaultLevel);
                            }
                            Logger global = Logger.global;
                            owner.addLogger(global);
                            return null;
                        }
                    });
                } finally {
                    this.initializationDone = true;
                }
            }
        }
    }

    public static LogManager getLogManager() {
        LogManager logManager = manager;
        if (logManager != null) {
            logManager.ensureLogManagerInitialized();
        }
        return logManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readPrimordialConfiguration() {
        if (!this.readPrimordialConfiguration) {
            synchronized (this) {
                if (!this.readPrimordialConfiguration) {
                    if (System.out == null) {
                        return;
                    }
                    this.readPrimordialConfiguration = true;
                    try {
                        AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.util.logging.LogManager.3
                            @Override // java.security.PrivilegedExceptionAction
                            public Void run() throws Exception {
                                LogManager.this.readConfiguration();
                                PlatformLogger.redirectPlatformLoggers();
                                return null;
                            }
                        });
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }

    @Deprecated
    public void addPropertyChangeListener(PropertyChangeListener l10) throws SecurityException {
        PropertyChangeListener listener = (PropertyChangeListener) Objects.requireNonNull(l10);
        checkPermission();
        synchronized (this.listenerMap) {
            Integer value = this.listenerMap.get(listener);
            int i10 = 1;
            if (value != null) {
                i10 = 1 + value.intValue();
            }
            this.listenerMap.put(listener, Integer.valueOf(i10));
        }
    }

    @Deprecated
    public void removePropertyChangeListener(PropertyChangeListener l10) throws SecurityException {
        checkPermission();
        if (l10 != null) {
            synchronized (this.listenerMap) {
                Integer value = this.listenerMap.get(l10);
                if (value != null) {
                    int i10 = value.intValue();
                    if (i10 == 1) {
                        this.listenerMap.remove(l10);
                    } else {
                        this.listenerMap.put(l10, Integer.valueOf(i10 - 1));
                    }
                }
            }
        }
    }

    private LoggerContext getUserContext() {
        return this.userContext;
    }

    final LoggerContext getSystemContext() {
        return this.systemContext;
    }

    private List<LoggerContext> contexts() {
        List<LoggerContext> cxs = new ArrayList<>();
        cxs.add(getSystemContext());
        cxs.add(getUserContext());
        return cxs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger demandLogger(String name, String resourceBundleName, Class<?> caller) {
        Logger result = getLogger(name);
        if (result == null) {
            Logger newLogger = new Logger(name, resourceBundleName, caller, this, false);
            while (!addLogger(newLogger)) {
                result = getLogger(name);
                if (result != null) {
                }
            }
            return newLogger;
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger demandSystemLogger(String name, String resourceBundleName) {
        Logger logger;
        final Logger sysLogger = getSystemContext().demandLogger(name, resourceBundleName);
        do {
            if (addLogger(sysLogger)) {
                logger = sysLogger;
            } else {
                logger = getLogger(name);
            }
        } while (logger == null);
        if (logger != sysLogger && sysLogger.accessCheckedHandlers().length == 0) {
            final Logger l10 = logger;
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.logging.LogManager.4
                @Override // java.security.PrivilegedAction
                public Void run() {
                    for (Handler hdl : l10.accessCheckedHandlers()) {
                        sysLogger.addHandler(hdl);
                    }
                    return null;
                }
            });
        }
        return sysLogger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class getClassInstance(String cname) throws ClassNotFoundException {
        try {
            return ClassLoader.getSystemClassLoader().loadClass(cname);
        } catch (ClassNotFoundException e2) {
            return Thread.currentThread().getContextClassLoader().loadClass(cname);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class LoggerContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Hashtable<String, LoggerWeakRef> namedLoggers;
        private final LogNode root;

        private LoggerContext() {
            this.namedLoggers = new Hashtable<>();
            this.root = new LogNode(null, this);
        }

        final boolean requiresDefaultLoggers() {
            boolean requiresDefaultLoggers = getOwner() == LogManager.manager;
            if (requiresDefaultLoggers) {
                getOwner().ensureLogManagerInitialized();
            }
            return requiresDefaultLoggers;
        }

        final LogManager getOwner() {
            return LogManager.this;
        }

        final Logger getRootLogger() {
            return getOwner().rootLogger;
        }

        final Logger getGlobalLogger() {
            Logger global = Logger.global;
            return global;
        }

        Logger demandLogger(String name, String resourceBundleName) {
            LogManager owner = getOwner();
            return owner.demandLogger(name, resourceBundleName, null);
        }

        private void ensureInitialized() {
            if (requiresDefaultLoggers()) {
                ensureDefaultLogger(getRootLogger());
                ensureDefaultLogger(getGlobalLogger());
            }
        }

        synchronized Logger findLogger(String name) {
            ensureInitialized();
            LoggerWeakRef ref = this.namedLoggers.get(name);
            if (ref == null) {
                return null;
            }
            Logger logger = ref.get();
            if (logger == null) {
                ref.dispose();
            }
            return logger;
        }

        private void ensureAllDefaultLoggers(Logger logger) {
            if (requiresDefaultLoggers()) {
                String name = logger.getName();
                if (!name.isEmpty()) {
                    ensureDefaultLogger(getRootLogger());
                    if (!Logger.GLOBAL_LOGGER_NAME.equals(name)) {
                        ensureDefaultLogger(getGlobalLogger());
                    }
                }
            }
        }

        private void ensureDefaultLogger(Logger logger) {
            if (!requiresDefaultLoggers() || logger == null) {
                return;
            }
            if ((logger == Logger.global || logger == LogManager.this.rootLogger) && !this.namedLoggers.containsKey(logger.getName())) {
                addLocalLogger(logger, false);
            }
        }

        boolean addLocalLogger(Logger logger) {
            return addLocalLogger(logger, requiresDefaultLoggers());
        }

        synchronized boolean addLocalLogger(Logger logger, boolean addDefaultLoggersIfNeeded) {
            if (addDefaultLoggersIfNeeded) {
                ensureAllDefaultLoggers(logger);
            }
            String name = logger.getName();
            if (name == null) {
                throw new NullPointerException();
            }
            LoggerWeakRef ref = this.namedLoggers.get(name);
            if (ref != null) {
                if (!ref.refersTo(null)) {
                    return false;
                }
                ref.dispose();
            }
            LogManager owner = getOwner();
            logger.setLogManager(owner);
            Objects.requireNonNull(owner);
            LoggerWeakRef ref2 = new LoggerWeakRef(logger);
            this.namedLoggers.put(name, ref2);
            Level level = owner.getLevelProperty(name + ".level", null);
            if (level != null && !logger.isLevelInitialized()) {
                LogManager.doSetLevel(logger, level);
            }
            processParentHandlers(logger, name);
            LogNode node = getNode(name);
            node.loggerRef = ref2;
            Logger parent = null;
            for (LogNode nodep = node.parent; nodep != null; nodep = nodep.parent) {
                LoggerWeakRef nodeRef = nodep.loggerRef;
                if (nodeRef != null && (parent = nodeRef.get()) != null) {
                    break;
                }
            }
            if (parent != null) {
                LogManager.doSetParent(logger, parent);
            }
            node.walkAndSetParent(logger);
            ref2.setNode(node);
            return true;
        }

        synchronized void removeLoggerRef(String name, LoggerWeakRef ref) {
            this.namedLoggers.remove(name, ref);
        }

        synchronized Enumeration<String> getLoggerNames() {
            ensureInitialized();
            return this.namedLoggers.keys();
        }

        private void processParentHandlers(final Logger logger, final String name) {
            final LogManager owner = getOwner();
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.util.logging.LogManager.LoggerContext.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    if (logger != owner.rootLogger) {
                        boolean useParent = owner.getBooleanProperty(name + ".useParentHandlers", true);
                        if (!useParent) {
                            logger.setUseParentHandlers(false);
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
            });
            int ix = 1;
            while (true) {
                int ix2 = name.indexOf(".", ix);
                if (ix2 >= 0) {
                    String pname = name.substring(0, ix2);
                    if (owner.getProperty(pname + ".level") != null || owner.getProperty(pname + ".handlers") != null) {
                        demandLogger(pname, null);
                    }
                    ix = ix2 + 1;
                } else {
                    return;
                }
            }
        }

        LogNode getNode(String name) {
            String head;
            if (name == null || name.equals("")) {
                LogNode node = this.root;
                return node;
            }
            LogNode node2 = this.root;
            while (name.length() > 0) {
                int ix = name.indexOf(".");
                if (ix > 0) {
                    head = name.substring(0, ix);
                    name = name.substring(ix + 1);
                } else {
                    head = name;
                    name = "";
                }
                if (node2.children == null) {
                    node2.children = new HashMap<>();
                }
                LogNode child = node2.children.get(head);
                if (child == null) {
                    child = new LogNode(node2, this);
                    node2.children.put(head, child);
                }
                node2 = child;
            }
            return node2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class SystemLoggerContext extends LoggerContext {
        SystemLoggerContext() {
            super();
        }

        @Override // java.util.logging.LogManager.LoggerContext
        Logger demandLogger(String name, String resourceBundleName) {
            Logger result = findLogger(name);
            if (result == null) {
                Logger newLogger = new Logger(name, resourceBundleName, null, getOwner(), true);
                do {
                    if (addLocalLogger(newLogger)) {
                        result = newLogger;
                    } else {
                        result = findLogger(name);
                    }
                } while (result == null);
            }
            return result;
        }
    }

    private void loadLoggerHandlers(final Logger logger, String name, final String handlersPropertyName) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: java.util.logging.LogManager.5
            @Override // java.security.PrivilegedAction
            public Object run() {
                String[] names = LogManager.this.parseClassNames(handlersPropertyName);
                for (String word : names) {
                    try {
                        Class<?> clz = LogManager.getClassInstance(word);
                        Handler hdl = (Handler) clz.newInstance();
                        String levs = LogManager.this.getProperty(word + ".level");
                        if (levs != null) {
                            Level l10 = Level.findLevel(levs);
                            if (l10 != null) {
                                hdl.setLevel(l10);
                            } else {
                                System.err.println("Can't set level for " + word);
                            }
                        }
                        logger.addHandler(hdl);
                    } catch (Exception ex) {
                        System.err.println("Can't load log handler \"" + word + "\"");
                        System.err.println("" + ((Object) ex));
                        ex.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class LoggerWeakRef extends WeakReference<Logger> {
        private boolean disposed;
        private String name;
        private LogNode node;
        private WeakReference<Logger> parentRef;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LoggerWeakRef(Logger logger) {
            super(logger, LogManager.this.loggerRefQueue);
            this.disposed = false;
            this.name = logger.getName();
        }

        void dispose() {
            synchronized (this) {
                if (this.disposed) {
                    return;
                }
                this.disposed = true;
                LogNode n10 = this.node;
                if (n10 != null) {
                    synchronized (n10.context) {
                        n10.context.removeLoggerRef(this.name, this);
                        this.name = null;
                        if (n10.loggerRef == this) {
                            n10.loggerRef = null;
                        }
                        this.node = null;
                    }
                }
                WeakReference<Logger> weakReference = this.parentRef;
                if (weakReference != null) {
                    Logger parent = weakReference.get();
                    if (parent != null) {
                        parent.removeChildLogger(this);
                    }
                    this.parentRef = null;
                }
            }
        }

        void setNode(LogNode node) {
            this.node = node;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setParentRef(WeakReference<Logger> parentRef) {
            this.parentRef = parentRef;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void drainLoggerRefQueueBounded() {
        ReferenceQueue<Logger> referenceQueue;
        LoggerWeakRef ref;
        for (int i10 = 0; i10 < 400 && (referenceQueue = this.loggerRefQueue) != null && (ref = (LoggerWeakRef) referenceQueue.poll()) != null; i10++) {
            ref.dispose();
        }
    }

    public boolean addLogger(Logger logger) {
        String name = logger.getName();
        if (name == null) {
            throw new NullPointerException();
        }
        drainLoggerRefQueueBounded();
        LoggerContext cx = getUserContext();
        if (cx.addLocalLogger(logger)) {
            loadLoggerHandlers(logger, name, name + ".handlers");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doSetLevel(final Logger logger, final Level level) {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            logger.setLevel(level);
        } else {
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: java.util.logging.LogManager.6
                @Override // java.security.PrivilegedAction
                public Object run() {
                    Logger.this.setLevel(level);
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doSetParent(final Logger logger, final Logger parent) {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            logger.setParent(parent);
        } else {
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: java.util.logging.LogManager.7
                @Override // java.security.PrivilegedAction
                public Object run() {
                    Logger.this.setParent(parent);
                    return null;
                }
            });
        }
    }

    public Logger getLogger(String name) {
        return getUserContext().findLogger(name);
    }

    public Enumeration<String> getLoggerNames() {
        return getUserContext().getLoggerNames();
    }

    public void readConfiguration() throws IOException, SecurityException {
        InputStream in;
        checkPermission();
        String cname = System.getProperty("java.util.logging.config.class");
        if (cname != null) {
            try {
                getClassInstance(cname).newInstance();
                return;
            } catch (Exception ex) {
                System.err.println("Logging configuration class \"" + cname + "\" failed");
                System.err.println("" + ((Object) ex));
            }
        }
        String fname = System.getProperty("java.util.logging.config.file");
        if (fname == null) {
            String fname2 = System.getProperty("java.home");
            if (fname2 == null) {
                throw new Error("Can't find java.home ??");
            }
            File f10 = new File(fname2, NativeLibraryHelper.LIB_DIR_NAME);
            fname = new File(f10, "logging.properties").getCanonicalPath();
        }
        try {
            in = new FileInputStream(fname);
        } catch (Exception e2) {
            in = LogManager.class.getResourceAsStream("logging.properties");
            if (in == null) {
                throw e2;
            }
        }
        BufferedInputStream bin = new BufferedInputStream(in);
        try {
            readConfiguration(bin);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void reset() throws SecurityException {
        checkPermission();
        synchronized (this) {
            this.props = new Properties();
            this.initializedGlobalHandlers = true;
        }
        for (LoggerContext cx : contexts()) {
            Enumeration<String> enum_ = cx.getLoggerNames();
            while (enum_.hasMoreElements()) {
                String name = enum_.nextElement();
                Logger logger = cx.findLogger(name);
                if (logger != null) {
                    resetLogger(logger);
                }
            }
        }
    }

    private void resetLogger(Logger logger) {
        Handler[] targets = logger.getHandlers();
        for (Handler h10 : targets) {
            logger.removeHandler(h10);
            try {
                h10.close();
            } catch (Exception e2) {
            }
        }
        String name = logger.getName();
        if (name != null && name.equals("")) {
            logger.setLevel(defaultLevel);
        } else {
            logger.setLevel(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] parseClassNames(String propertyName) {
        String hands = getProperty(propertyName);
        if (hands == null) {
            return new String[0];
        }
        String hands2 = hands.trim();
        int ix = 0;
        List<String> result = new ArrayList<>();
        while (ix < hands2.length()) {
            int end = ix;
            while (end < hands2.length() && !Character.isWhitespace(hands2.charAt(end)) && hands2.charAt(end) != ',') {
                end++;
            }
            String word = hands2.substring(ix, end);
            ix = end + 1;
            String word2 = word.trim();
            if (word2.length() != 0) {
                result.add(word2);
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    public void readConfiguration(InputStream ins) throws IOException, SecurityException {
        checkPermission();
        reset();
        this.props.load(ins);
        String[] names = parseClassNames(FLPNode.KEY_CONFIG);
        for (String word : names) {
            try {
                getClassInstance(word).newInstance();
            } catch (Exception ex) {
                System.err.println("Can't load config class \"" + word + "\"");
                System.err.println("" + ((Object) ex));
            }
        }
        setLevelsOnExistingLoggers();
        Map<Object, Integer> listeners = null;
        synchronized (this.listenerMap) {
            if (!this.listenerMap.isEmpty()) {
                listeners = new HashMap<>((Map<? extends Object, ? extends Integer>) this.listenerMap);
            }
        }
        if (listeners != null) {
            Object ev = Beans.newPropertyChangeEvent(LogManager.class, null, null, null);
            for (Map.Entry<Object, Integer> entry : listeners.entrySet()) {
                Object listener = entry.getKey();
                int count = entry.getValue().intValue();
                for (int i10 = 0; i10 < count; i10++) {
                    Beans.invokePropertyChange(listener, ev);
                }
            }
        }
        synchronized (this) {
            this.initializedGlobalHandlers = false;
        }
    }

    public String getProperty(String name) {
        return this.props.getProperty(name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStringProperty(String name, String defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        return val.trim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getIntProperty(String name, int defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(val.trim());
        } catch (Exception e2) {
            return defaultValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getBooleanProperty(String name, boolean defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        String val2 = val.toLowerCase();
        if (val2.equals("true") || val2.equals("1")) {
            return true;
        }
        if (val2.equals("false") || val2.equals("0")) {
            return false;
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Level getLevelProperty(String name, Level defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        Level l10 = Level.findLevel(val.trim());
        return l10 != null ? l10 : defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Filter getFilterProperty(String name, Filter defaultValue) {
        String val = getProperty(name);
        if (val != null) {
            try {
                return (Filter) getClassInstance(val).newInstance();
            } catch (Exception e2) {
            }
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Formatter getFormatterProperty(String name, Formatter defaultValue) {
        String val = getProperty(name);
        if (val != null) {
            try {
                return (Formatter) getClassInstance(val).newInstance();
            } catch (Exception e2) {
            }
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initializeGlobalHandlers() {
        if (this.initializedGlobalHandlers) {
            return;
        }
        this.initializedGlobalHandlers = true;
        if (this.deathImminent) {
            return;
        }
        loadLoggerHandlers(this.rootLogger, null, "handlers");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(this.controlPermission);
        }
    }

    public void checkAccess() throws SecurityException {
        checkPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class LogNode {
        HashMap<String, LogNode> children;
        final LoggerContext context;
        LoggerWeakRef loggerRef;
        LogNode parent;

        LogNode(LogNode parent, LoggerContext context) {
            this.parent = parent;
            this.context = context;
        }

        void walkAndSetParent(Logger parent) {
            HashMap<String, LogNode> hashMap = this.children;
            if (hashMap == null) {
                return;
            }
            for (LogNode node : hashMap.values()) {
                LoggerWeakRef ref = node.loggerRef;
                Logger logger = ref == null ? null : ref.get();
                if (logger == null) {
                    node.walkAndSetParent(parent);
                } else {
                    LogManager.doSetParent(logger, parent);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private final class RootLogger extends Logger {
        private RootLogger() {
            super("", null, null, LogManager.this, true);
        }

        @Override // java.util.logging.Logger
        public void log(LogRecord record) {
            LogManager.this.initializeGlobalHandlers();
            super.log(record);
        }

        @Override // java.util.logging.Logger
        public void addHandler(Handler h10) {
            LogManager.this.initializeGlobalHandlers();
            super.addHandler(h10);
        }

        @Override // java.util.logging.Logger
        public void removeHandler(Handler h10) {
            LogManager.this.initializeGlobalHandlers();
            super.removeHandler(h10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.util.logging.Logger
        public Handler[] accessCheckedHandlers() {
            LogManager.this.initializeGlobalHandlers();
            return super.accessCheckedHandlers();
        }
    }

    private synchronized void setLevelsOnExistingLoggers() {
        Enumeration<?> enum_ = this.props.propertyNames();
        while (enum_.hasMoreElements()) {
            String key = (String) enum_.nextElement();
            if (key.endsWith(".level")) {
                int ix = key.length() - 6;
                String name = key.substring(0, ix);
                Level level = getLevelProperty(key, null);
                if (level == null) {
                    System.err.println("Bad level value for property: " + key);
                } else {
                    for (LoggerContext cx : contexts()) {
                        Logger l10 = cx.findLogger(name);
                        if (l10 != null) {
                            l10.setLevel(level);
                        }
                    }
                }
            }
        }
    }

    public static synchronized LoggingMXBean getLoggingMXBean() {
        LoggingMXBean loggingMXBean2;
        synchronized (LogManager.class) {
            if (loggingMXBean == null) {
                loggingMXBean = new Logging();
            }
            loggingMXBean2 = loggingMXBean;
        }
        return loggingMXBean2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Beans {
        private static final Class<?> propertyChangeEventClass;
        private static final Class<?> propertyChangeListenerClass;
        private static final Method propertyChangeMethod;
        private static final Constructor<?> propertyEventCtor;

        private Beans() {
        }

        static {
            Class<?> cls = getClass("java.beans.PropertyChangeListener");
            propertyChangeListenerClass = cls;
            Class<?> cls2 = getClass("java.beans.PropertyChangeEvent");
            propertyChangeEventClass = cls2;
            propertyChangeMethod = getMethod(cls, "propertyChange", cls2);
            propertyEventCtor = getConstructor(cls2, Object.class, String.class, Object.class, Object.class);
        }

        private static Class<?> getClass(String name) {
            try {
                return Class.forName(name, true, Beans.class.getClassLoader());
            } catch (ClassNotFoundException e2) {
                return null;
            }
        }

        private static Constructor<?> getConstructor(Class<?> c4, Class<?>... types) {
            if (c4 == null) {
                return null;
            }
            try {
                return c4.getDeclaredConstructor(types);
            } catch (NoSuchMethodException x10) {
                throw new AssertionError(x10);
            }
        }

        private static Method getMethod(Class<?> c4, String name, Class<?>... types) {
            if (c4 == null) {
                return null;
            }
            try {
                return c4.getMethod(name, types);
            } catch (NoSuchMethodException e2) {
                throw new AssertionError(e2);
            }
        }

        static boolean isBeansPresent() {
            return (propertyChangeListenerClass == null || propertyChangeEventClass == null) ? false : true;
        }

        static Object newPropertyChangeEvent(Object source, String prop, Object oldValue, Object newValue) {
            try {
                return propertyEventCtor.newInstance(source, prop, oldValue, newValue);
            } catch (IllegalAccessException | InstantiationException x10) {
                throw new AssertionError(x10);
            } catch (InvocationTargetException x11) {
                Throwable cause = x11.getCause();
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new AssertionError(x11);
            }
        }

        static void invokePropertyChange(Object listener, Object ev) {
            try {
                propertyChangeMethod.invoke(listener, ev);
            } catch (IllegalAccessException x10) {
                throw new AssertionError(x10);
            } catch (InvocationTargetException x11) {
                Throwable cause = x11.getCause();
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new AssertionError(x11);
            }
        }
    }
}
