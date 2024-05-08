package org.apache.commons.lang3;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SerializationUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes;
        private final ClassLoader classLoader;

        static {
            HashMap hashMap = new HashMap();
            primitiveTypes = hashMap;
            hashMap.put("byte", Byte.TYPE);
            hashMap.put("short", Short.TYPE);
            hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, Integer.TYPE);
            hashMap.put("long", Long.TYPE);
            hashMap.put("float", Float.TYPE);
            hashMap.put("double", Double.TYPE);
            hashMap.put("boolean", Boolean.TYPE);
            hashMap.put("char", Character.TYPE);
            hashMap.put("void", Void.TYPE);
        }

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.classLoader = classLoader;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException unused) {
                    return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
                }
            } catch (ClassNotFoundException e2) {
                Class<?> cls = primitiveTypes.get(name);
                if (cls != null) {
                    return cls;
                }
                throw e2;
            }
        }
    }

    public static <T extends Serializable> T clone(T t2) {
        if (t2 == null) {
            return null;
        }
        try {
            ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t2)), t2.getClass().getClassLoader());
            try {
                T t10 = (T) classLoaderAwareObjectInputStream.readObject();
                classLoaderAwareObjectInputStream.close();
                return t10;
            } catch (Throwable th) {
                try {
                    classLoaderAwareObjectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new SerializationException("IOException while reading or closing cloned object data", e2);
        } catch (ClassNotFoundException e10) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", e10);
        }
    }

    public static <T> T deserialize(InputStream inputStream) {
        Validate.isTrue(inputStream != null, "The InputStream must not be null", new Object[0]);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                T t2 = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t2;
            } catch (Throwable th) {
                try {
                    objectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | ClassNotFoundException e2) {
            throw new SerializationException(e2);
        }
    }

    public static <T extends Serializable> T roundtrip(T t2) {
        return (T) deserialize(serialize(t2));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Validate.isTrue(outputStream != null, "The OutputStream must not be null", new Object[0]);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public static <T> T deserialize(byte[] bArr) {
        Validate.isTrue(bArr != null, "The byte[] must not be null", new Object[0]);
        return (T) deserialize(new ByteArrayInputStream(bArr));
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
