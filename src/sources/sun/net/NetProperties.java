package sun.net;

import com.android.internal.content.NativeLibraryHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Properties;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NetProperties {
    private static Properties props = new Properties();

    static {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.net.NetProperties.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                NetProperties.loadDefaultProperties();
                return null;
            }
        });
    }

    private NetProperties() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadDefaultProperties() {
        String fname = System.getProperty("java.home");
        if (fname == null) {
            throw new Error("Can't find java.home ??");
        }
        try {
            File f10 = new File(fname, NativeLibraryHelper.LIB_DIR_NAME);
            InputStream in = new FileInputStream(new File(f10, "net.properties").getCanonicalPath());
            BufferedInputStream bin = new BufferedInputStream(in);
            props.load(bin);
            bin.close();
        } catch (Exception e2) {
        }
    }

    public static String get(String key) {
        String def = props.getProperty(key);
        try {
            return System.getProperty(key, def);
        } catch (IllegalArgumentException | NullPointerException e2) {
            return null;
        }
    }

    public static Integer getInteger(String key, int defval) {
        String val = null;
        try {
            val = System.getProperty(key, props.getProperty(key));
        } catch (IllegalArgumentException e2) {
        } catch (NullPointerException e10) {
        }
        if (val != null) {
            try {
                return Integer.decode(val);
            } catch (NumberFormatException e11) {
            }
        }
        return new Integer(defval);
    }

    public static Boolean getBoolean(String key) {
        String val = null;
        try {
            val = System.getProperty(key, props.getProperty(key));
        } catch (IllegalArgumentException e2) {
        } catch (NullPointerException e10) {
        }
        if (val != null) {
            try {
                return Boolean.valueOf(val);
            } catch (NumberFormatException e11) {
                return null;
            }
        }
        return null;
    }
}
