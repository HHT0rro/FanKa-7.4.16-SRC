package java.sql;

import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.huawei.openalliance.ad.constant.u;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DriverManager {
    static final SQLPermission SET_LOG_PERMISSION;
    private static final CopyOnWriteArrayList<DriverInfo> registeredDrivers = new CopyOnWriteArrayList<>();
    private static volatile int loginTimeout = 0;
    private static volatile PrintWriter logWriter = null;
    private static volatile PrintStream logStream = null;
    private static final Object logSync = new Object();

    static {
        loadInitialDrivers();
        println("JDBC DriverManager initialized");
        SET_LOG_PERMISSION = new SQLPermission("setLog");
    }

    private DriverManager() {
    }

    public static PrintWriter getLogWriter() {
        return logWriter;
    }

    public static void setLogWriter(PrintWriter out) {
        SecurityManager sec = System.getSecurityManager();
        if (sec != null) {
            sec.checkPermission(SET_LOG_PERMISSION);
        }
        logStream = null;
        logWriter = out;
    }

    @CallerSensitive
    public static Connection getConnection(String url, Properties info) throws SQLException {
        return getConnection(url, info, Reflection.getCallerClass());
    }

    @CallerSensitive
    public static Connection getConnection(String url, String user, String password) throws SQLException {
        Properties info = new Properties();
        if (user != null) {
            info.put(UserData.NAME, user);
        }
        if (password != null) {
            info.put("password", password);
        }
        return getConnection(url, info, Reflection.getCallerClass());
    }

    @CallerSensitive
    public static Connection getConnection(String url) throws SQLException {
        Properties info = new Properties();
        return getConnection(url, info, Reflection.getCallerClass());
    }

    @CallerSensitive
    public static Driver getDriver(String url) throws SQLException {
        println("DriverManager.getDriver(\"" + url + "\")");
        Class<?> callerClass = Reflection.getCallerClass();
        Iterator<DriverInfo> iterator2 = registeredDrivers.iterator2();
        while (iterator2.hasNext()) {
            DriverInfo aDriver = iterator2.next();
            if (isDriverAllowed(aDriver.driver, callerClass)) {
                try {
                    if (aDriver.driver.acceptsURL(url)) {
                        println("getDriver returning " + aDriver.driver.getClass().getName());
                        return aDriver.driver;
                    }
                    continue;
                } catch (SQLException e2) {
                }
            } else {
                println("    skipping: " + aDriver.driver.getClass().getName());
            }
        }
        println("getDriver: no suitable driver");
        throw new SQLException("No suitable driver", "08001");
    }

    public static synchronized void registerDriver(Driver driver) throws SQLException {
        synchronized (DriverManager.class) {
            if (driver != null) {
                registeredDrivers.addIfAbsent(new DriverInfo(driver));
                println("registerDriver: " + ((Object) driver));
            } else {
                throw new NullPointerException();
            }
        }
    }

    @CallerSensitive
    public static synchronized void deregisterDriver(Driver driver) throws SQLException {
        synchronized (DriverManager.class) {
            if (driver == null) {
                return;
            }
            println("DriverManager.deregisterDriver: " + ((Object) driver));
            DriverInfo aDriver = new DriverInfo(driver);
            CopyOnWriteArrayList<DriverInfo> copyOnWriteArrayList = registeredDrivers;
            if (copyOnWriteArrayList.contains(aDriver)) {
                if (isDriverAllowed(driver, Reflection.getCallerClass())) {
                    copyOnWriteArrayList.remove(aDriver);
                } else {
                    throw new SecurityException();
                }
            } else {
                println("    couldn't find driver to unload");
            }
        }
    }

    @CallerSensitive
    public static Enumeration<Driver> getDrivers() {
        Vector<Driver> result = new Vector<>();
        Class<?> callerClass = Reflection.getCallerClass();
        Iterator<DriverInfo> iterator2 = registeredDrivers.iterator2();
        while (iterator2.hasNext()) {
            DriverInfo aDriver = iterator2.next();
            if (isDriverAllowed(aDriver.driver, callerClass)) {
                result.addElement(aDriver.driver);
            } else {
                println("    skipping: " + aDriver.getClass().getName());
            }
        }
        return result.elements();
    }

    public static void setLoginTimeout(int seconds) {
        loginTimeout = seconds;
    }

    public static int getLoginTimeout() {
        return loginTimeout;
    }

    @Deprecated
    public static void setLogStream(PrintStream out) {
        SecurityManager sec = System.getSecurityManager();
        if (sec != null) {
            sec.checkPermission(SET_LOG_PERMISSION);
        }
        logStream = out;
        if (out != null) {
            logWriter = new PrintWriter(out);
        } else {
            logWriter = null;
        }
    }

    @Deprecated
    public static PrintStream getLogStream() {
        return logStream;
    }

    public static void println(String message) {
        synchronized (logSync) {
            if (logWriter != null) {
                logWriter.println(message);
                logWriter.flush();
            }
        }
    }

    private static boolean isDriverAllowed(Driver driver, Class<?> caller) {
        ClassLoader callerCL = caller != null ? caller.getClassLoader() : null;
        return isDriverAllowed(driver, callerCL);
    }

    private static boolean isDriverAllowed(Driver driver, ClassLoader classLoader) {
        if (driver == null) {
            return false;
        }
        Class<?> aClass = null;
        try {
            aClass = Class.forName(driver.getClass().getName(), true, classLoader);
        } catch (Exception e2) {
        }
        boolean result = aClass == driver.getClass();
        return result;
    }

    private static void loadInitialDrivers() {
        String drivers;
        try {
            drivers = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: java.sql.DriverManager.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty("jdbc.drivers");
                }
            });
        } catch (Exception e2) {
            drivers = null;
        }
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.sql.DriverManager.2
            @Override // java.security.PrivilegedAction
            public Void run() {
                ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
                Iterator driversIterator = loadedDrivers.iterator2();
                while (driversIterator.hasNext()) {
                    try {
                        driversIterator.next();
                    } catch (Throwable th) {
                        return null;
                    }
                }
                return null;
            }
        });
        println("DriverManager.initialize: jdbc.drivers = " + drivers);
        if (drivers == null || drivers.equals("")) {
            return;
        }
        String[] driversList = drivers.split(u.bD);
        println("number of Drivers:" + driversList.length);
        for (String aDriver : driversList) {
            try {
                println("DriverManager.Initialize: loading " + aDriver);
                Class.forName(aDriver, true, ClassLoader.getSystemClassLoader());
            } catch (Exception ex) {
                println("DriverManager.Initialize: load failed: " + ((Object) ex));
            }
        }
    }

    private static Connection getConnection(String url, Properties info, Class<?> caller) throws SQLException {
        ClassLoader callerCL = caller != null ? caller.getClassLoader() : null;
        synchronized (DriverManager.class) {
            if (callerCL == null) {
                callerCL = Thread.currentThread().getContextClassLoader();
            }
        }
        if (url == null) {
            throw new SQLException("The url cannot be null", "08001");
        }
        println("DriverManager.getConnection(\"" + url + "\")");
        SQLException reason = null;
        Iterator<DriverInfo> iterator2 = registeredDrivers.iterator2();
        while (iterator2.hasNext()) {
            DriverInfo aDriver = iterator2.next();
            if (isDriverAllowed(aDriver.driver, callerCL)) {
                try {
                    println("    trying " + aDriver.driver.getClass().getName());
                    Connection con = aDriver.driver.connect(url, info);
                    if (con != null) {
                        println("getConnection returning " + aDriver.driver.getClass().getName());
                        return con;
                    }
                    continue;
                } catch (SQLException ex) {
                    if (reason == null) {
                        reason = ex;
                    }
                }
            } else {
                println("    skipping: " + aDriver.getClass().getName());
            }
        }
        if (reason != null) {
            println("getConnection failed: " + ((Object) reason));
            throw reason;
        }
        println("getConnection: no suitable driver found for " + url);
        throw new SQLException("No suitable driver found for " + url, "08001");
    }
}
