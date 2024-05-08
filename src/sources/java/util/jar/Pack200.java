package java.util.jar;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.util.SortedMap;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Pack200 {
    private static final String PACK_PROVIDER = "java.util.jar.Pack200.Packer";
    private static final String UNPACK_PROVIDER = "java.util.jar.Pack200.Unpacker";
    private static Class<?> packerImpl;
    private static Class<?> unpackerImpl;

    private Pack200() {
    }

    public static synchronized Packer newPacker() {
        Packer packer;
        synchronized (Pack200.class) {
            packer = (Packer) newInstance(PACK_PROVIDER);
        }
        return packer;
    }

    public static Unpacker newUnpacker() {
        return (Unpacker) newInstance(UNPACK_PROVIDER);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Packer {
        public static final String CLASS_ATTRIBUTE_PFX = "pack.class.attribute.";
        public static final String CODE_ATTRIBUTE_PFX = "pack.code.attribute.";
        public static final String DEFLATE_HINT = "pack.deflate.hint";
        public static final String EFFORT = "pack.effort";
        public static final String ERROR = "error";
        public static final String FALSE = "false";
        public static final String FIELD_ATTRIBUTE_PFX = "pack.field.attribute.";
        public static final String KEEP = "keep";
        public static final String KEEP_FILE_ORDER = "pack.keep.file.order";
        public static final String LATEST = "latest";
        public static final String METHOD_ATTRIBUTE_PFX = "pack.method.attribute.";
        public static final String MODIFICATION_TIME = "pack.modification.time";
        public static final String PASS = "pass";
        public static final String PASS_FILE_PFX = "pack.pass.file.";
        public static final String PROGRESS = "pack.progress";
        public static final String SEGMENT_LIMIT = "pack.segment.limit";
        public static final String STRIP = "strip";
        public static final String TRUE = "true";
        public static final String UNKNOWN_ATTRIBUTE = "pack.unknown.attribute";

        void pack(JarFile jarFile, OutputStream outputStream) throws IOException;

        void pack(JarInputStream jarInputStream, OutputStream outputStream) throws IOException;

        SortedMap<String, String> properties();

        @Deprecated
        default void addPropertyChangeListener(PropertyChangeListener listener) {
        }

        @Deprecated
        default void removePropertyChangeListener(PropertyChangeListener listener) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Unpacker {
        public static final String DEFLATE_HINT = "unpack.deflate.hint";
        public static final String FALSE = "false";
        public static final String KEEP = "keep";
        public static final String PROGRESS = "unpack.progress";
        public static final String TRUE = "true";

        SortedMap<String, String> properties();

        void unpack(File file, JarOutputStream jarOutputStream) throws IOException;

        void unpack(InputStream inputStream, JarOutputStream jarOutputStream) throws IOException;

        @Deprecated
        default void addPropertyChangeListener(PropertyChangeListener listener) {
        }

        @Deprecated
        default void removePropertyChangeListener(PropertyChangeListener listener) {
        }
    }

    private static synchronized Object newInstance(String prop) {
        Object newInstance;
        synchronized (Pack200.class) {
            String implName = "(unknown)";
            try {
                try {
                    try {
                        Class<?> impl = PACK_PROVIDER.equals(prop) ? packerImpl : unpackerImpl;
                        if (impl == null && (implName = (String) AccessController.doPrivileged(new GetPropertyAction(prop, ""))) != null && !implName.equals("")) {
                            impl = Class.forName(implName);
                        }
                        newInstance = impl.newInstance();
                    } catch (IllegalAccessException e2) {
                        throw new Error("Cannot access class: " + implName + ":\ncheck property " + prop + " in your properties file.", e2);
                    }
                } catch (ClassNotFoundException e10) {
                    throw new Error("Class not found: " + implName + ":\ncheck property " + prop + " in your properties file.", e10);
                }
            } catch (InstantiationException e11) {
                throw new Error("Could not instantiate: " + implName + ":\ncheck property " + prop + " in your properties file.", e11);
            }
        }
        return newInstance;
    }
}
