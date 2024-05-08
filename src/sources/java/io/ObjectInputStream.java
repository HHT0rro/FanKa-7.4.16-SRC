package java.io;

import com.baidu.mobads.sdk.api.IAdInterListener;
import dalvik.system.VMStack;
import java.io.ObjectStreamClass;
import java.lang.invoke.MethodHandle;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import jdk.internal.misc.JavaObjectInputStreamAccess;
import jdk.internal.misc.SharedSecrets;
import sun.reflect.misc.ReflectUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int NULL_HANDLE = -1;
    private static final HashMap<String, Class<?>> primClasses;
    private static final Object unsharedMarker = new Object();
    private final BlockDataInputStream bin;
    private boolean closed;
    private SerialCallbackContext curContext;
    private int depth;
    private final boolean enableOverride;
    private boolean enableResolve;
    private final HandleTable handles;
    private byte[] primVals;
    private final ValidationList vlist;
    private int passHandle = -1;
    private boolean defaultDataEnd = false;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class GetField {
        public abstract boolean defaulted(String str) throws IOException;

        public abstract byte get(String str, byte b4) throws IOException;

        public abstract char get(String str, char c4) throws IOException;

        public abstract double get(String str, double d10) throws IOException;

        public abstract float get(String str, float f10) throws IOException;

        public abstract int get(String str, int i10) throws IOException;

        public abstract long get(String str, long j10) throws IOException;

        public abstract Object get(String str, Object obj) throws IOException;

        public abstract short get(String str, short s2) throws IOException;

        public abstract boolean get(String str, boolean z10) throws IOException;

        public abstract ObjectStreamClass getObjectStreamClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void bytesToDoubles(byte[] bArr, int i10, double[] dArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void bytesToFloats(byte[] bArr, int i10, float[] fArr, int i11, int i12);

    static {
        HashMap<String, Class<?>> hashMap = new HashMap<>(8, 1.0f);
        primClasses = hashMap;
        hashMap.put("boolean", Boolean.TYPE);
        hashMap.put("byte", Byte.TYPE);
        hashMap.put("char", Character.TYPE);
        hashMap.put("short", Short.TYPE);
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, Integer.TYPE);
        hashMap.put("long", Long.TYPE);
        hashMap.put("float", Float.TYPE);
        hashMap.put("double", Double.TYPE);
        hashMap.put("void", Void.TYPE);
        SharedSecrets.setJavaObjectInputStreamAccess(new JavaObjectInputStreamAccess() { // from class: java.io.ObjectInputStream$$ExternalSyntheticLambda0
            @Override // jdk.internal.misc.JavaObjectInputStreamAccess
            public final void checkArray(ObjectInputStream objectInputStream, Class cls, int i10) {
                objectInputStream.checkArray(cls, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Caches {
        static final ConcurrentMap<ObjectStreamClass.WeakClassKey, Boolean> subclassAudits = new ConcurrentHashMap();
        static final ReferenceQueue<Class<?>> subclassAuditsQueue = new ReferenceQueue<>();

        private Caches() {
        }
    }

    public ObjectInputStream(InputStream in) throws IOException {
        verifySubclass();
        BlockDataInputStream blockDataInputStream = new BlockDataInputStream(in);
        this.bin = blockDataInputStream;
        this.handles = new HandleTable(10);
        this.vlist = new ValidationList();
        this.enableOverride = false;
        readStreamHeader();
        blockDataInputStream.setBlockDataMode(true);
    }

    protected ObjectInputStream() throws IOException, SecurityException {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
        this.bin = null;
        this.handles = null;
        this.vlist = null;
        this.enableOverride = true;
    }

    @Override // java.io.ObjectInput
    public final Object readObject() throws IOException, ClassNotFoundException {
        if (this.enableOverride) {
            return readObjectOverride();
        }
        int outerHandle = this.passHandle;
        try {
            Object obj = readObject0(false);
            this.handles.markDependency(outerHandle, this.passHandle);
            ClassNotFoundException ex = this.handles.lookupException(this.passHandle);
            if (ex != null) {
                throw ex;
            }
            if (this.depth == 0) {
                this.vlist.doCallbacks();
            }
            return obj;
        } finally {
            this.passHandle = outerHandle;
            if (this.closed && this.depth == 0) {
                clear();
            }
        }
    }

    protected Object readObjectOverride() throws IOException, ClassNotFoundException {
        return null;
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        int outerHandle = this.passHandle;
        try {
            Object obj = readObject0(true);
            this.handles.markDependency(outerHandle, this.passHandle);
            ClassNotFoundException ex = this.handles.lookupException(this.passHandle);
            if (ex != null) {
                throw ex;
            }
            if (this.depth == 0) {
                this.vlist.doCallbacks();
            }
            return obj;
        } finally {
            this.passHandle = outerHandle;
            if (this.closed && this.depth == 0) {
                clear();
            }
        }
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        SerialCallbackContext ctx = this.curContext;
        if (ctx == null) {
            throw new NotActiveException("not in call to readObject");
        }
        Object curObj = ctx.getObj();
        ObjectStreamClass curDesc = ctx.getDesc();
        this.bin.setBlockDataMode(false);
        defaultReadFields(curObj, curDesc);
        this.bin.setBlockDataMode(true);
        if (!curDesc.hasWriteObjectData()) {
            this.defaultDataEnd = true;
        }
        ClassNotFoundException ex = this.handles.lookupException(this.passHandle);
        if (ex != null) {
            throw ex;
        }
    }

    public GetField readFields() throws IOException, ClassNotFoundException {
        SerialCallbackContext ctx = this.curContext;
        if (ctx == null) {
            throw new NotActiveException("not in call to readObject");
        }
        ctx.getObj();
        ObjectStreamClass curDesc = ctx.getDesc();
        this.bin.setBlockDataMode(false);
        GetFieldImpl getField = new GetFieldImpl(curDesc);
        getField.readFields();
        this.bin.setBlockDataMode(true);
        if (!curDesc.hasWriteObjectData()) {
            this.defaultDataEnd = true;
        }
        return getField;
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        if (this.depth == 0) {
            throw new NotActiveException("stream inactive");
        }
        this.vlist.register(obj, prio);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        String name = desc.getName();
        try {
            return Class.forName(name, false, latestUserDefinedLoader());
        } catch (ClassNotFoundException ex) {
            Class<?> cl = primClasses.get(name);
            if (cl != null) {
                return cl;
            }
            throw ex;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        ClassLoader latestLoader = latestUserDefinedLoader();
        ClassLoader nonPublicLoader = null;
        boolean hasNonPublicInterface = false;
        Class<?>[] classObjs = new Class[interfaces.length];
        for (int i10 = 0; i10 < interfaces.length; i10++) {
            Class<?> cl = Class.forName(interfaces[i10], false, latestLoader);
            if ((cl.getModifiers() & 1) == 0) {
                if (hasNonPublicInterface) {
                    if (nonPublicLoader != cl.getClassLoader()) {
                        throw new IllegalAccessError("conflicting non-public interface class loaders");
                    }
                } else {
                    nonPublicLoader = cl.getClassLoader();
                    hasNonPublicInterface = true;
                }
            }
            classObjs[i10] = cl;
        }
        try {
            return Proxy.getProxyClass(hasNonPublicInterface ? nonPublicLoader : latestLoader, classObjs);
        } catch (IllegalArgumentException e2) {
            throw new ClassNotFoundException(null, e2);
        }
    }

    protected Object resolveObject(Object obj) throws IOException {
        return obj;
    }

    protected boolean enableResolveObject(boolean enable) throws SecurityException {
        SecurityManager sm;
        if (enable == this.enableResolve) {
            return enable;
        }
        if (enable && (sm = System.getSecurityManager()) != null) {
            sm.checkPermission(SUBSTITUTION_PERMISSION);
        }
        this.enableResolve = enable;
        return !enable;
    }

    protected void readStreamHeader() throws IOException, StreamCorruptedException {
        short s02 = this.bin.readShort();
        short s12 = this.bin.readShort();
        if (s02 != -21267 || s12 != 5) {
            throw new StreamCorruptedException(String.format("invalid stream header: %04X%04X", Short.valueOf(s02), Short.valueOf(s12)));
        }
    }

    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass desc = new ObjectStreamClass();
        desc.readNonProxy(this);
        return desc;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.bin.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        if (buf == null) {
            throw new NullPointerException();
        }
        int endoff = off + len;
        if (off < 0 || len < 0 || endoff > buf.length || endoff < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.bin.read(buf, off, len, false);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.bin.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        if (this.depth == 0) {
            clear();
        }
        this.bin.close();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.bin.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.bin.readByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.bin.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.bin.readChar();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.bin.readShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.bin.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.bin.readInt();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.bin.readLong();
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.bin.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.bin.readDouble();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] buf) throws IOException {
        this.bin.readFully(buf, 0, buf.length, false);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] buf, int off, int len) throws IOException {
        int endoff = off + len;
        if (off < 0 || len < 0 || endoff > buf.length || endoff < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.bin.readFully(buf, off, len, false);
    }

    @Override // java.io.DataInput
    public int skipBytes(int len) throws IOException {
        return this.bin.skipBytes(len);
    }

    @Override // java.io.DataInput
    @Deprecated
    public String readLine() throws IOException {
        return this.bin.readLine();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.bin.readUTF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkArray(Class<?> arrayType, int arrayLength) throws InvalidClassException {
        if (!arrayType.isArray()) {
            throw new IllegalArgumentException("not an array type");
        }
        if (arrayLength < 0) {
            throw new NegativeArraySizeException();
        }
    }

    private void verifySubclass() {
        SecurityManager sm;
        Class<?> cl = getClass();
        if (cl == ObjectInputStream.class || (sm = System.getSecurityManager()) == null) {
            return;
        }
        ObjectStreamClass.processQueue(Caches.subclassAuditsQueue, Caches.subclassAudits);
        ObjectStreamClass.WeakClassKey key = new ObjectStreamClass.WeakClassKey(cl, Caches.subclassAuditsQueue);
        Boolean result = Caches.subclassAudits.get(key);
        if (result == null) {
            result = Boolean.valueOf(auditSubclass(cl));
            Caches.subclassAudits.putIfAbsent(key, result);
        }
        if (result.booleanValue()) {
            return;
        }
        sm.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
    }

    private static boolean auditSubclass(final Class<?> subcl) {
        Boolean result = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: java.io.ObjectInputStream.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                for (Class<?> cl = Class.this; cl != ObjectInputStream.class; cl = cl.getSuperclass()) {
                    try {
                        cl.getDeclaredMethod("readUnshared", null);
                        return Boolean.FALSE;
                    } catch (NoSuchMethodException e2) {
                        try {
                            cl.getDeclaredMethod("readFields", null);
                            return Boolean.FALSE;
                        } catch (NoSuchMethodException e10) {
                        }
                    }
                }
                return Boolean.TRUE;
            }
        });
        return result.booleanValue();
    }

    private void clear() {
        this.handles.clear();
        this.vlist.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object readObject0(boolean unshared) throws IOException {
        byte tc2;
        boolean oldMode = this.bin.getBlockDataMode();
        if (oldMode) {
            int remain = this.bin.currentBlockRemaining();
            if (remain > 0) {
                throw new OptionalDataException(remain);
            }
            if (this.defaultDataEnd) {
                throw new OptionalDataException(true);
            }
            this.bin.setBlockDataMode(false);
        }
        while (true) {
            tc2 = this.bin.peekByte();
            if (tc2 != 121) {
                break;
            }
            this.bin.readByte();
            handleReset();
        }
        this.depth++;
        try {
            switch (tc2) {
                case 112:
                    return readNull();
                case 113:
                    return readHandle(unshared);
                case 114:
                case 125:
                    return readClassDesc(unshared);
                case 115:
                    return checkResolve(readOrdinaryObject(unshared));
                case 116:
                case 124:
                    return checkResolve(readString(unshared));
                case 117:
                    return checkResolve(readArray(unshared));
                case 118:
                    return readClass(unshared);
                case 119:
                case 122:
                    if (!oldMode) {
                        throw new StreamCorruptedException("unexpected block data");
                    }
                    this.bin.setBlockDataMode(true);
                    this.bin.peek();
                    throw new OptionalDataException(this.bin.currentBlockRemaining());
                case 120:
                    if (oldMode) {
                        throw new OptionalDataException(true);
                    }
                    throw new StreamCorruptedException("unexpected end of block data");
                case 121:
                default:
                    throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc2)));
                case 123:
                    IOException ex = readFatalException();
                    throw new WriteAbortedException("writing aborted", ex);
                case 126:
                    return checkResolve(readEnum(unshared));
            }
        } finally {
            this.depth--;
            this.bin.setBlockDataMode(oldMode);
        }
    }

    private Object checkResolve(Object obj) throws IOException {
        if (!this.enableResolve || this.handles.lookupException(this.passHandle) != null) {
            return obj;
        }
        Object rep = resolveObject(obj);
        if (rep != obj) {
            this.handles.setObject(this.passHandle, rep);
        }
        return rep;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String readTypeString() throws IOException {
        int oldHandle = this.passHandle;
        try {
            byte tc2 = this.bin.peekByte();
            switch (tc2) {
                case 112:
                    return (String) readNull();
                case 113:
                    return (String) readHandle(false);
                case 116:
                case 124:
                    return readString(false);
                default:
                    throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc2)));
            }
        } finally {
            this.passHandle = oldHandle;
        }
    }

    private Object readNull() throws IOException {
        if (this.bin.readByte() != 112) {
            throw new InternalError();
        }
        this.passHandle = -1;
        return null;
    }

    private Object readHandle(boolean unshared) throws IOException {
        if (this.bin.readByte() != 113) {
            throw new InternalError();
        }
        int readInt = this.bin.readInt() - ObjectStreamConstants.baseWireHandle;
        this.passHandle = readInt;
        if (readInt < 0 || readInt >= this.handles.size()) {
            throw new StreamCorruptedException(String.format("invalid handle value: %08X", Integer.valueOf(this.passHandle + ObjectStreamConstants.baseWireHandle)));
        }
        if (unshared) {
            throw new InvalidObjectException("cannot read back reference as unshared");
        }
        Object obj = this.handles.lookupObject(this.passHandle);
        if (obj == unsharedMarker) {
            throw new InvalidObjectException("cannot read back reference to unshared object");
        }
        return obj;
    }

    private Class<?> readClass(boolean unshared) throws IOException {
        if (this.bin.readByte() != 118) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        Class<?> cl = desc.forClass();
        this.passHandle = this.handles.assign(unshared ? unsharedMarker : cl);
        ClassNotFoundException resolveEx = desc.getResolveException();
        if (resolveEx != null) {
            this.handles.markException(this.passHandle, resolveEx);
        }
        this.handles.finish(this.passHandle);
        return cl;
    }

    private ObjectStreamClass readClassDesc(boolean unshared) throws IOException {
        byte tc2 = this.bin.peekByte();
        switch (tc2) {
            case 112:
                ObjectStreamClass descriptor = (ObjectStreamClass) readNull();
                return descriptor;
            case 113:
                ObjectStreamClass descriptor2 = (ObjectStreamClass) readHandle(unshared);
                return descriptor2;
            case 114:
                ObjectStreamClass descriptor3 = readNonProxyDesc(unshared);
                return descriptor3;
            case 125:
                ObjectStreamClass descriptor4 = readProxyDesc(unshared);
                return descriptor4;
            default:
                throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc2)));
        }
    }

    private boolean isCustomSubclass() {
        return getClass().getClassLoader() != ObjectInputStream.class.getClassLoader();
    }

    private ObjectStreamClass readProxyDesc(boolean unshared) throws IOException {
        if (this.bin.readByte() != 125) {
            throw new InternalError();
        }
        ObjectStreamClass desc = new ObjectStreamClass();
        int descHandle = this.handles.assign(unshared ? unsharedMarker : desc);
        this.passHandle = -1;
        int numIfaces = this.bin.readInt();
        String[] ifaces = new String[numIfaces];
        for (int i10 = 0; i10 < numIfaces; i10++) {
            ifaces[i10] = this.bin.readUTF();
        }
        Class<?> cl = null;
        ClassNotFoundException resolveEx = null;
        this.bin.setBlockDataMode(true);
        try {
            Class<?> resolveProxyClass = resolveProxyClass(ifaces);
            cl = resolveProxyClass;
            if (resolveProxyClass == null) {
                resolveEx = new ClassNotFoundException("null class");
            } else {
                if (!Proxy.isProxyClass(cl)) {
                    throw new InvalidClassException("Not a proxy");
                }
                ReflectUtil.checkProxyPackageAccess(getClass().getClassLoader(), cl.getInterfaces());
            }
        } catch (ClassNotFoundException ex) {
            resolveEx = ex;
        }
        skipCustomData();
        desc.initProxy(cl, resolveEx, readClassDesc(false));
        this.handles.finish(descHandle);
        this.passHandle = descHandle;
        return desc;
    }

    private ObjectStreamClass readNonProxyDesc(boolean unshared) throws IOException {
        if (this.bin.readByte() != 114) {
            throw new InternalError();
        }
        ObjectStreamClass desc = new ObjectStreamClass();
        int descHandle = this.handles.assign(unshared ? unsharedMarker : desc);
        this.passHandle = -1;
        try {
            ObjectStreamClass readDesc = readClassDescriptor();
            Class<?> cl = null;
            ClassNotFoundException resolveEx = null;
            this.bin.setBlockDataMode(true);
            boolean checksRequired = isCustomSubclass();
            try {
                Class<?> resolveClass = resolveClass(readDesc);
                cl = resolveClass;
                if (resolveClass == null) {
                    resolveEx = new ClassNotFoundException("null class");
                } else if (checksRequired) {
                    ReflectUtil.checkPackageAccess(cl);
                }
            } catch (ClassNotFoundException ex) {
                resolveEx = ex;
            }
            skipCustomData();
            desc.initNonProxy(readDesc, cl, resolveEx, readClassDesc(false));
            this.handles.finish(descHandle);
            this.passHandle = descHandle;
            return desc;
        } catch (ClassNotFoundException ex2) {
            throw ((IOException) new InvalidClassException("failed to read class descriptor").initCause(ex2));
        }
    }

    private String readString(boolean unshared) throws IOException {
        String str;
        byte tc2 = this.bin.readByte();
        switch (tc2) {
            case 116:
                str = this.bin.readUTF();
                break;
            case 124:
                str = this.bin.readLongUTF();
                break;
            default:
                throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc2)));
        }
        int assign = this.handles.assign(unshared ? unsharedMarker : str);
        this.passHandle = assign;
        this.handles.finish(assign);
        return str;
    }

    private Object readArray(boolean unshared) throws IOException {
        if (this.bin.readByte() != 117) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        int len = this.bin.readInt();
        Object array = null;
        Class<?> ccl = null;
        Class<?> cl = desc.forClass();
        if (cl != null) {
            ccl = cl.getComponentType();
            array = Array.newInstance(ccl, len);
        }
        int arrayHandle = this.handles.assign(unshared ? unsharedMarker : array);
        ClassNotFoundException resolveEx = desc.getResolveException();
        if (resolveEx != null) {
            this.handles.markException(arrayHandle, resolveEx);
        }
        if (ccl == null) {
            for (int i10 = 0; i10 < len; i10++) {
                readObject0(false);
            }
        } else if (ccl.isPrimitive()) {
            if (ccl == Integer.TYPE) {
                this.bin.readInts((int[]) array, 0, len);
            } else if (ccl == Byte.TYPE) {
                this.bin.readFully((byte[]) array, 0, len, true);
            } else if (ccl == Long.TYPE) {
                this.bin.readLongs((long[]) array, 0, len);
            } else if (ccl == Float.TYPE) {
                this.bin.readFloats((float[]) array, 0, len);
            } else if (ccl == Double.TYPE) {
                this.bin.readDoubles((double[]) array, 0, len);
            } else if (ccl == Short.TYPE) {
                this.bin.readShorts((short[]) array, 0, len);
            } else if (ccl == Character.TYPE) {
                this.bin.readChars((char[]) array, 0, len);
            } else if (ccl == Boolean.TYPE) {
                this.bin.readBooleans((boolean[]) array, 0, len);
            } else {
                throw new InternalError();
            }
        } else {
            Object[] oa2 = (Object[]) array;
            for (int i11 = 0; i11 < len; i11++) {
                oa2[i11] = readObject0(false);
                this.handles.markDependency(arrayHandle, this.passHandle);
            }
        }
        this.handles.finish(arrayHandle);
        this.passHandle = arrayHandle;
        return array;
    }

    private Enum<?> readEnum(boolean unshared) throws IOException {
        if (this.bin.readByte() != 126) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        if (!desc.isEnum()) {
            throw new InvalidClassException("non-enum class: " + ((Object) desc));
        }
        int enumHandle = this.handles.assign(unshared ? unsharedMarker : null);
        ClassNotFoundException resolveEx = desc.getResolveException();
        if (resolveEx != null) {
            this.handles.markException(enumHandle, resolveEx);
        }
        String name = readString(false);
        Enum<?> result = null;
        Class<?> cl = desc.forClass();
        if (cl != null) {
            try {
                Enum<?> en = Enum.valueOf(cl, name);
                result = en;
                if (!unshared) {
                    this.handles.setObject(enumHandle, result);
                }
            } catch (IllegalArgumentException ex) {
                throw ((IOException) new InvalidObjectException("enum constant " + name + " does not exist in " + ((Object) cl)).initCause(ex));
            }
        }
        this.handles.finish(enumHandle);
        this.passHandle = enumHandle;
        return result;
    }

    private Object readOrdinaryObject(boolean unshared) throws IOException {
        if (this.bin.readByte() != 115) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        desc.checkDeserialize();
        Class<?> cl = desc.forClass();
        if (cl == String.class || cl == Class.class || cl == ObjectStreamClass.class) {
            throw new InvalidClassException("invalid class descriptor");
        }
        try {
            Object obj = desc.isInstantiable() ? desc.newInstance() : null;
            this.passHandle = this.handles.assign(unshared ? unsharedMarker : obj);
            ClassNotFoundException resolveEx = desc.getResolveException();
            if (resolveEx != null) {
                this.handles.markException(this.passHandle, resolveEx);
            }
            boolean isRecord = desc.isRecord();
            if (isRecord) {
                obj = readRecord(desc);
                if (!unshared) {
                    this.handles.setObject(this.passHandle, obj);
                }
            } else if (desc.isExternalizable()) {
                readExternalData((Externalizable) obj, desc);
            } else {
                readSerialData(obj, desc);
            }
            this.handles.finish(this.passHandle);
            if (obj != null && this.handles.lookupException(this.passHandle) == null && desc.hasReadResolveMethod()) {
                Object rep = desc.invokeReadResolve(obj);
                if (unshared && rep.getClass().isArray()) {
                    rep = cloneArray(rep);
                }
                if (rep != obj) {
                    Object obj2 = rep;
                    this.handles.setObject(this.passHandle, rep);
                    return obj2;
                }
                return obj;
            }
            return obj;
        } catch (Exception ex) {
            throw ((IOException) new InvalidClassException(desc.forClass().getName(), "unable to create instance").initCause(ex));
        }
    }

    private void readExternalData(Externalizable obj, ObjectStreamClass desc) throws IOException {
        SerialCallbackContext oldContext = this.curContext;
        if (oldContext != null) {
            oldContext.check();
        }
        this.curContext = null;
        try {
            boolean blocked = desc.hasBlockExternalData();
            if (blocked) {
                this.bin.setBlockDataMode(true);
            }
            if (obj != null) {
                try {
                    obj.readExternal(this);
                } catch (ClassNotFoundException ex) {
                    this.handles.markException(this.passHandle, ex);
                }
            }
            if (blocked) {
                skipCustomData();
            }
        } finally {
            if (oldContext != null) {
                oldContext.check();
            }
            this.curContext = oldContext;
        }
    }

    private Object readRecord(ObjectStreamClass desc) throws IOException {
        ObjectStreamClass.ClassDataSlot[] slots = desc.getClassDataLayout();
        if (slots.length != 1) {
            for (int i10 = 0; i10 < slots.length - 1; i10++) {
                if (slots[i10].hasData) {
                    new FieldValues(slots[i10].desc, true);
                }
            }
        }
        FieldValues fieldValues = new FieldValues(desc, true);
        MethodHandle ctrMH = ObjectStreamClass.RecordSupport.deserializationCtr(desc);
        try {
            return (Object) ctrMH.invokeExact(fieldValues.primValues, fieldValues.objValues);
        } catch (Error e2) {
            throw e2;
        } catch (Exception e10) {
            InvalidObjectException ioe = new InvalidObjectException(e10.getMessage());
            ioe.initCause(e10);
            throw ioe;
        } catch (Throwable t2) {
            ObjectStreamException ose = new InvalidObjectException("ReflectiveOperationException during deserialization");
            ose.initCause(t2);
            throw ose;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (r4 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r8.curContext = r4;
        r8.defaultDataEnd = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r4.check();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r4 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readSerialData(java.lang.Object r9, java.io.ObjectStreamClass r10) throws java.io.IOException {
        /*
            r8 = this;
            java.io.ObjectStreamClass$ClassDataSlot[] r0 = r10.getClassDataLayout()
            r1 = 0
        L5:
            int r2 = r0.length
            if (r1 >= r2) goto L9d
            r2 = r0[r1]
            java.io.ObjectStreamClass r2 = r2.desc
            r3 = r0[r1]
            boolean r3 = r3.hasData
            if (r3 == 0) goto L84
            r3 = 0
            if (r9 == 0) goto L70
            java.io.ObjectInputStream$HandleTable r4 = r8.handles
            int r5 = r8.passHandle
            java.lang.ClassNotFoundException r4 = r4.lookupException(r5)
            if (r4 == 0) goto L20
            goto L70
        L20:
            boolean r4 = r2.hasReadObjectMethod()
            if (r4 == 0) goto L6c
            java.io.SerialCallbackContext r4 = r8.curContext
            if (r4 == 0) goto L2d
            r4.check()
        L2d:
            java.io.SerialCallbackContext r5 = new java.io.SerialCallbackContext     // Catch: java.lang.Throwable -> L45 java.lang.ClassNotFoundException -> L47
            r5.<init>(r9, r2)     // Catch: java.lang.Throwable -> L45 java.lang.ClassNotFoundException -> L47
            r8.curContext = r5     // Catch: java.lang.Throwable -> L45 java.lang.ClassNotFoundException -> L47
            java.io.ObjectInputStream$BlockDataInputStream r5 = r8.bin     // Catch: java.lang.Throwable -> L45 java.lang.ClassNotFoundException -> L47
            r6 = 1
            r5.setBlockDataMode(r6)     // Catch: java.lang.Throwable -> L45 java.lang.ClassNotFoundException -> L47
            r2.invokeReadObject(r9, r8)     // Catch: java.lang.Throwable -> L45 java.lang.ClassNotFoundException -> L47
            java.io.SerialCallbackContext r5 = r8.curContext
            r5.setUsed()
            if (r4 == 0) goto L59
            goto L56
        L45:
            r3 = move-exception
            goto L5f
        L47:
            r5 = move-exception
            java.io.ObjectInputStream$HandleTable r6 = r8.handles     // Catch: java.lang.Throwable -> L45
            int r7 = r8.passHandle     // Catch: java.lang.Throwable -> L45
            r6.markException(r7, r5)     // Catch: java.lang.Throwable -> L45
            java.io.SerialCallbackContext r5 = r8.curContext
            r5.setUsed()
            if (r4 == 0) goto L59
        L56:
            r4.check()
        L59:
            r8.curContext = r4
            r8.defaultDataEnd = r3
            goto L74
        L5f:
            java.io.SerialCallbackContext r5 = r8.curContext
            r5.setUsed()
            if (r4 == 0) goto L69
            r4.check()
        L69:
            r8.curContext = r4
            throw r3
        L6c:
            r8.defaultReadFields(r9, r2)
            goto L74
        L70:
            r4 = 0
            r8.defaultReadFields(r4, r2)
        L74:
            boolean r4 = r2.hasWriteObjectData()
            if (r4 == 0) goto L7e
            r8.skipCustomData()
            goto L99
        L7e:
            java.io.ObjectInputStream$BlockDataInputStream r4 = r8.bin
            r4.setBlockDataMode(r3)
            goto L99
        L84:
            if (r9 == 0) goto L99
            boolean r3 = r2.hasReadObjectNoDataMethod()
            if (r3 == 0) goto L99
            java.io.ObjectInputStream$HandleTable r3 = r8.handles
            int r4 = r8.passHandle
            java.lang.ClassNotFoundException r3 = r3.lookupException(r4)
            if (r3 != 0) goto L99
            r2.invokeReadObjectNoData(r9)
        L99:
            int r1 = r1 + 1
            goto L5
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.readSerialData(java.lang.Object, java.io.ObjectStreamClass):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        r3.bin.readByte();
        r3.passHandle = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipCustomData() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.passHandle
        L2:
            java.io.ObjectInputStream$BlockDataInputStream r1 = r3.bin
            boolean r1 = r1.getBlockDataMode()
            r2 = 0
            if (r1 == 0) goto L15
            java.io.ObjectInputStream$BlockDataInputStream r1 = r3.bin
            r1.skipBlockData()
            java.io.ObjectInputStream$BlockDataInputStream r1 = r3.bin
            r1.setBlockDataMode(r2)
        L15:
            java.io.ObjectInputStream$BlockDataInputStream r1 = r3.bin
            byte r1 = r1.peekByte()
            switch(r1) {
                case 119: goto L2a;
                case 120: goto L22;
                case 121: goto L1e;
                case 122: goto L2a;
                default: goto L1e;
            }
        L1e:
            r3.readObject0(r2)
            goto L2
        L22:
            java.io.ObjectInputStream$BlockDataInputStream r1 = r3.bin
            r1.readByte()
            r3.passHandle = r0
            return
        L2a:
            java.io.ObjectInputStream$BlockDataInputStream r1 = r3.bin
            r2 = 1
            r1.setBlockDataMode(r2)
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.skipCustomData():void");
    }

    private void defaultReadFields(Object obj, ObjectStreamClass desc) throws IOException {
        Class<?> cl = desc.forClass();
        if (cl != null && obj != null && !cl.isInstance(obj)) {
            throw new ClassCastException();
        }
        int primDataSize = desc.getPrimDataSize();
        byte[] bArr = this.primVals;
        if (bArr == null || bArr.length < primDataSize) {
            this.primVals = new byte[primDataSize];
        }
        this.bin.readFully(this.primVals, 0, primDataSize, false);
        if (obj != null) {
            desc.setPrimFieldValues(obj, this.primVals);
        }
        int objHandle = this.passHandle;
        ObjectStreamField[] fields = desc.getFields(false);
        Object[] objVals = new Object[desc.getNumObjFields()];
        int numPrimFields = fields.length - objVals.length;
        for (int i10 = 0; i10 < objVals.length; i10++) {
            ObjectStreamField f10 = fields[numPrimFields + i10];
            objVals[i10] = readObject0(f10.isUnshared());
            if (f10.getField() != null) {
                this.handles.markDependency(objHandle, this.passHandle);
            }
        }
        if (obj != null) {
            desc.setObjFieldValues(obj, objVals);
        }
        this.passHandle = objHandle;
    }

    private IOException readFatalException() throws IOException {
        if (this.bin.readByte() != 123) {
            throw new InternalError();
        }
        clear();
        IOException e2 = (IOException) readObject0(false);
        clear();
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReset() throws StreamCorruptedException {
        if (this.depth > 0) {
            throw new StreamCorruptedException("unexpected reset; recursion depth: " + this.depth);
        }
        clear();
    }

    private static ClassLoader latestUserDefinedLoader() {
        return VMStack.getClosestUserClassLoader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class FieldValues extends GetField {
        private final ObjectStreamClass desc;
        private final int[] objHandles;
        final Object[] objValues;
        final byte[] primValues;

        FieldValues(ObjectStreamClass desc, boolean recordDependencies) throws IOException {
            this.desc = desc;
            int primDataSize = desc.getPrimDataSize();
            byte[] bArr = primDataSize > 0 ? new byte[primDataSize] : null;
            this.primValues = bArr;
            if (primDataSize > 0) {
                ObjectInputStream.this.bin.readFully(bArr, 0, primDataSize, false);
            }
            int numObjFields = desc.getNumObjFields();
            Object[] objArr = numObjFields > 0 ? new Object[numObjFields] : null;
            this.objValues = objArr;
            this.objHandles = numObjFields > 0 ? new int[numObjFields] : null;
            if (numObjFields > 0) {
                int objHandle = ObjectInputStream.this.passHandle;
                ObjectStreamField[] fields = desc.getFields(false);
                int numPrimFields = fields.length - objArr.length;
                int i10 = 0;
                while (true) {
                    Object[] objArr2 = this.objValues;
                    if (i10 < objArr2.length) {
                        ObjectStreamField f10 = fields[numPrimFields + i10];
                        objArr2[i10] = ObjectInputStream.this.readObject0(f10.isUnshared());
                        this.objHandles[i10] = ObjectInputStream.this.passHandle;
                        if (recordDependencies && f10.getField() != null) {
                            ObjectInputStream.this.handles.markDependency(objHandle, ObjectInputStream.this.passHandle);
                        }
                        i10++;
                    } else {
                        ObjectInputStream.this.passHandle = objHandle;
                        return;
                    }
                }
            }
        }

        @Override // java.io.ObjectInputStream.GetField
        public ObjectStreamClass getObjectStreamClass() {
            return this.desc;
        }

        @Override // java.io.ObjectInputStream.GetField
        public boolean defaulted(String name) {
            return getFieldOffset(name, null) < 0;
        }

        @Override // java.io.ObjectInputStream.GetField
        public boolean get(String name, boolean val) {
            int off = getFieldOffset(name, Boolean.TYPE);
            return off >= 0 ? Bits.getBoolean(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public byte get(String name, byte val) {
            int off = getFieldOffset(name, Byte.TYPE);
            return off >= 0 ? this.primValues[off] : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public char get(String name, char val) {
            int off = getFieldOffset(name, Character.TYPE);
            return off >= 0 ? Bits.getChar(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public short get(String name, short val) {
            int off = getFieldOffset(name, Short.TYPE);
            return off >= 0 ? Bits.getShort(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public int get(String name, int val) {
            int off = getFieldOffset(name, Integer.TYPE);
            return off >= 0 ? Bits.getInt(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public float get(String name, float val) {
            int off = getFieldOffset(name, Float.TYPE);
            return off >= 0 ? Bits.getFloat(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public long get(String name, long val) {
            int off = getFieldOffset(name, Long.TYPE);
            return off >= 0 ? Bits.getLong(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public double get(String name, double val) {
            int off = getFieldOffset(name, Double.TYPE);
            return off >= 0 ? Bits.getDouble(this.primValues, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public Object get(String name, Object val) {
            int off = getFieldOffset(name, Object.class);
            if (off >= 0) {
                int objHandle = this.objHandles[off];
                ObjectInputStream.this.handles.markDependency(ObjectInputStream.this.passHandle, objHandle);
                if (ObjectInputStream.this.handles.lookupException(objHandle) == null) {
                    return this.objValues[off];
                }
                return null;
            }
            return val;
        }

        private int getFieldOffset(String name, Class<?> type) {
            ObjectStreamField field = this.desc.getField(name, type);
            if (field != null) {
                return field.getOffset();
            }
            if (this.desc.getLocalDesc().getField(name, type) != null) {
                return -1;
            }
            throw new IllegalArgumentException("no such field " + name + " with type " + ((Object) type));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class GetFieldImpl extends GetField {
        private final ObjectStreamClass desc;
        private final int[] objHandles;
        private final Object[] objVals;
        private final byte[] primVals;

        GetFieldImpl(ObjectStreamClass desc) {
            this.desc = desc;
            this.primVals = new byte[desc.getPrimDataSize()];
            Object[] objArr = new Object[desc.getNumObjFields()];
            this.objVals = objArr;
            this.objHandles = new int[objArr.length];
        }

        @Override // java.io.ObjectInputStream.GetField
        public ObjectStreamClass getObjectStreamClass() {
            return this.desc;
        }

        @Override // java.io.ObjectInputStream.GetField
        public boolean defaulted(String name) throws IOException {
            return getFieldOffset(name, null) < 0;
        }

        @Override // java.io.ObjectInputStream.GetField
        public boolean get(String name, boolean val) throws IOException {
            int off = getFieldOffset(name, Boolean.TYPE);
            return off >= 0 ? Bits.getBoolean(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public byte get(String name, byte val) throws IOException {
            int off = getFieldOffset(name, Byte.TYPE);
            return off >= 0 ? this.primVals[off] : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public char get(String name, char val) throws IOException {
            int off = getFieldOffset(name, Character.TYPE);
            return off >= 0 ? Bits.getChar(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public short get(String name, short val) throws IOException {
            int off = getFieldOffset(name, Short.TYPE);
            return off >= 0 ? Bits.getShort(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public int get(String name, int val) throws IOException {
            int off = getFieldOffset(name, Integer.TYPE);
            return off >= 0 ? Bits.getInt(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public float get(String name, float val) throws IOException {
            int off = getFieldOffset(name, Float.TYPE);
            return off >= 0 ? Bits.getFloat(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public long get(String name, long val) throws IOException {
            int off = getFieldOffset(name, Long.TYPE);
            return off >= 0 ? Bits.getLong(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public double get(String name, double val) throws IOException {
            int off = getFieldOffset(name, Double.TYPE);
            return off >= 0 ? Bits.getDouble(this.primVals, off) : val;
        }

        @Override // java.io.ObjectInputStream.GetField
        public Object get(String name, Object val) throws IOException {
            int off = getFieldOffset(name, Object.class);
            if (off >= 0) {
                int objHandle = this.objHandles[off];
                ObjectInputStream.this.handles.markDependency(ObjectInputStream.this.passHandle, objHandle);
                if (ObjectInputStream.this.handles.lookupException(objHandle) == null) {
                    return this.objVals[off];
                }
                return null;
            }
            return val;
        }

        void readFields() throws IOException {
            BlockDataInputStream blockDataInputStream = ObjectInputStream.this.bin;
            byte[] bArr = this.primVals;
            blockDataInputStream.readFully(bArr, 0, bArr.length, false);
            int oldHandle = ObjectInputStream.this.passHandle;
            ObjectStreamField[] fields = this.desc.getFields(false);
            int numPrimFields = fields.length - this.objVals.length;
            int i10 = 0;
            while (true) {
                Object[] objArr = this.objVals;
                if (i10 < objArr.length) {
                    objArr[i10] = ObjectInputStream.this.readObject0(fields[numPrimFields + i10].isUnshared());
                    this.objHandles[i10] = ObjectInputStream.this.passHandle;
                    i10++;
                } else {
                    ObjectInputStream.this.passHandle = oldHandle;
                    return;
                }
            }
        }

        private int getFieldOffset(String name, Class<?> type) {
            ObjectStreamField field = this.desc.getField(name, type);
            if (field != null) {
                return field.getOffset();
            }
            if (this.desc.getLocalDesc().getField(name, type) != null) {
                return -1;
            }
            throw new IllegalArgumentException("no such field " + name + " with type " + ((Object) type));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ValidationList {
        private Callback list;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class Callback {
            final AccessControlContext acc;
            Callback next;
            final ObjectInputValidation obj;
            final int priority;

            Callback(ObjectInputValidation obj, int priority, Callback next, AccessControlContext acc) {
                this.obj = obj;
                this.priority = priority;
                this.next = next;
                this.acc = acc;
            }
        }

        ValidationList() {
        }

        void register(ObjectInputValidation obj, int priority) throws InvalidObjectException {
            if (obj == null) {
                throw new InvalidObjectException("null callback");
            }
            Callback prev = null;
            Callback cur = this.list;
            while (cur != null && priority < cur.priority) {
                prev = cur;
                cur = cur.next;
            }
            AccessControlContext acc = AccessController.getContext();
            if (prev != null) {
                prev.next = new Callback(obj, priority, cur, acc);
            } else {
                this.list = new Callback(obj, priority, this.list, acc);
            }
        }

        void doCallbacks() throws InvalidObjectException {
            while (this.list != null) {
                try {
                    AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.io.ObjectInputStream.ValidationList.1
                        @Override // java.security.PrivilegedExceptionAction
                        public Void run() throws InvalidObjectException {
                            ValidationList.this.list.obj.validateObject();
                            return null;
                        }
                    }, this.list.acc);
                    this.list = this.list.next;
                } catch (PrivilegedActionException ex) {
                    this.list = null;
                    throw ((InvalidObjectException) ex.getException());
                }
            }
        }

        public void clear() {
            this.list = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PeekInputStream extends InputStream {
        private final InputStream in;
        private int peekb = -1;
        private long totalBytesRead = 0;

        PeekInputStream(InputStream in) {
            this.in = in;
        }

        int peek() throws IOException {
            int i10 = this.peekb;
            if (i10 >= 0) {
                return i10;
            }
            int read = this.in.read();
            this.peekb = read;
            this.totalBytesRead += read >= 0 ? 1L : 0L;
            return read;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.peekb >= 0) {
                int v2 = this.peekb;
                this.peekb = -1;
                return v2;
            }
            int nbytes = this.in.read();
            this.totalBytesRead += nbytes >= 0 ? 1L : 0L;
            return nbytes;
        }

        @Override // java.io.InputStream
        public int read(byte[] b4, int off, int len) throws IOException {
            if (len == 0) {
                return 0;
            }
            int i10 = this.peekb;
            if (i10 < 0) {
                int nbytes = this.in.read(b4, off, len);
                this.totalBytesRead += nbytes >= 0 ? nbytes : 0L;
                return nbytes;
            }
            b4[off] = (byte) i10;
            this.peekb = -1;
            int nbytes2 = this.in.read(b4, off + 1, len - 1);
            this.totalBytesRead += nbytes2 >= 0 ? nbytes2 : 0L;
            if (nbytes2 >= 0) {
                return nbytes2 + 1;
            }
            return 1;
        }

        void readFully(byte[] b4, int off, int len) throws IOException {
            int n10 = 0;
            while (n10 < len) {
                int count = read(b4, off + n10, len - n10);
                if (count < 0) {
                    throw new EOFException();
                }
                n10 += count;
            }
        }

        @Override // java.io.InputStream
        public long skip(long n10) throws IOException {
            if (n10 <= 0) {
                return 0L;
            }
            int skipped = 0;
            if (this.peekb >= 0) {
                this.peekb = -1;
                skipped = 0 + 1;
                n10--;
            }
            long n11 = skipped + this.in.skip(n10);
            this.totalBytesRead += n11;
            return n11;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.in.available() + (this.peekb >= 0 ? 1 : 0);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.in.close();
        }

        public long getBytesRead() {
            return this.totalBytesRead;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class BlockDataInputStream extends InputStream implements DataInput {
        private static final int CHAR_BUF_SIZE = 256;
        private static final int HEADER_BLOCKED = -2;
        private static final int MAX_BLOCK_SIZE = 1024;
        private static final int MAX_HEADER_SIZE = 5;
        private final PeekInputStream in;
        private final byte[] buf = new byte[1024];
        private final byte[] hbuf = new byte[5];
        private final char[] cbuf = new char[256];
        private boolean blkmode = false;
        private int pos = 0;
        private int end = -1;
        private int unread = 0;
        private final DataInputStream din = new DataInputStream(this);

        BlockDataInputStream(InputStream in) {
            this.in = new PeekInputStream(in);
        }

        boolean setBlockDataMode(boolean newmode) throws IOException {
            boolean z10 = this.blkmode;
            if (z10 == newmode) {
                return z10;
            }
            if (newmode) {
                this.pos = 0;
                this.end = 0;
                this.unread = 0;
            } else if (this.pos < this.end) {
                throw new IllegalStateException("unread block data");
            }
            this.blkmode = newmode;
            return !newmode;
        }

        boolean getBlockDataMode() {
            return this.blkmode;
        }

        void skipBlockData() throws IOException {
            if (!this.blkmode) {
                throw new IllegalStateException("not in block data mode");
            }
            while (this.end >= 0) {
                refill();
            }
        }

        private int readBlockHeader(boolean canBlock) throws IOException {
            if (ObjectInputStream.this.defaultDataEnd) {
                return -1;
            }
            while (true) {
                int avail = canBlock ? Integer.MAX_VALUE : this.in.available();
                if (avail == 0) {
                    return -2;
                }
                try {
                    int tc2 = this.in.peek();
                    switch (tc2) {
                        case 119:
                            if (avail < 2) {
                                return -2;
                            }
                            this.in.readFully(this.hbuf, 0, 2);
                            return this.hbuf[1] & 255;
                        case 120:
                        default:
                            if (tc2 >= 0 && (tc2 < 112 || tc2 > 126)) {
                                throw new StreamCorruptedException(String.format("invalid type code: %02X", Integer.valueOf(tc2)));
                            }
                            return -1;
                        case 121:
                            this.in.read();
                            ObjectInputStream.this.handleReset();
                        case 122:
                            if (avail < 5) {
                                return -2;
                            }
                            this.in.readFully(this.hbuf, 0, 5);
                            int len = Bits.getInt(this.hbuf, 1);
                            if (len < 0) {
                                throw new StreamCorruptedException("illegal block data header length: " + len);
                            }
                            return len;
                    }
                } catch (EOFException e2) {
                    throw new StreamCorruptedException("unexpected EOF while reading block data header");
                }
            }
        }

        private void refill() throws IOException {
            do {
                try {
                    this.pos = 0;
                    int i10 = this.unread;
                    if (i10 > 0) {
                        int n10 = this.in.read(this.buf, 0, Math.min(i10, 1024));
                        if (n10 >= 0) {
                            this.end = n10;
                            this.unread -= n10;
                        } else {
                            throw new StreamCorruptedException("unexpected EOF in middle of data block");
                        }
                    } else {
                        int n11 = readBlockHeader(true);
                        if (n11 >= 0) {
                            this.end = 0;
                            this.unread = n11;
                        } else {
                            this.end = -1;
                            this.unread = 0;
                        }
                    }
                } catch (IOException ex) {
                    this.pos = 0;
                    this.end = -1;
                    this.unread = 0;
                    throw ex;
                }
            } while (this.pos == this.end);
        }

        int currentBlockRemaining() {
            if (this.blkmode) {
                int i10 = this.end;
                if (i10 >= 0) {
                    return (i10 - this.pos) + this.unread;
                }
                return 0;
            }
            throw new IllegalStateException();
        }

        int peek() throws IOException {
            if (this.blkmode) {
                if (this.pos == this.end) {
                    refill();
                }
                if (this.end >= 0) {
                    return this.buf[this.pos] & 255;
                }
                return -1;
            }
            return this.in.peek();
        }

        byte peekByte() throws IOException {
            int val = peek();
            if (val < 0) {
                throw new EOFException();
            }
            return (byte) val;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.blkmode) {
                if (this.pos == this.end) {
                    refill();
                }
                if (this.end < 0) {
                    return -1;
                }
                byte[] bArr = this.buf;
                int i10 = this.pos;
                this.pos = i10 + 1;
                return bArr[i10] & 255;
            }
            return this.in.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] b4, int off, int len) throws IOException {
            return read(b4, off, len, false);
        }

        @Override // java.io.InputStream
        public long skip(long len) throws IOException {
            long remain = len;
            while (remain > 0) {
                if (this.blkmode) {
                    if (this.pos == this.end) {
                        refill();
                    }
                    if (this.end < 0) {
                        break;
                    }
                    int nread = (int) Math.min(remain, r2 - this.pos);
                    remain -= nread;
                    this.pos += nread;
                } else {
                    int nread2 = this.in.read(this.buf, 0, (int) Math.min(remain, 1024L));
                    if (nread2 < 0) {
                        break;
                    }
                    remain -= nread2;
                }
            }
            return len - remain;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            switch(r0) {
                case -2: goto L15;
                case -1: goto L13;
                default: goto L12;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        
            r3.pos = 0;
            r3.end = 0;
            r3.unread = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        
            r3.pos = 0;
            r3.end = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        
            if (r3.unread == 0) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        
            r0 = readBlockHeader(false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        
            if (r0 != 0) goto L25;
         */
        @Override // java.io.InputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int available() throws java.io.IOException {
            /*
                r3 = this;
                boolean r0 = r3.blkmode
                if (r0 == 0) goto L44
                int r0 = r3.pos
                int r1 = r3.end
                r2 = 0
                if (r0 != r1) goto L28
                int r0 = r3.unread
                if (r0 != 0) goto L28
            Lf:
                int r0 = r3.readBlockHeader(r2)
                r1 = r0
                if (r0 != 0) goto L17
                goto Lf
            L17:
                switch(r1) {
                    case -2: goto L27;
                    case -1: goto L21;
                    default: goto L1a;
                }
            L1a:
                r3.pos = r2
                r3.end = r2
                r3.unread = r1
                goto L28
            L21:
                r3.pos = r2
                r0 = -1
                r3.end = r0
                goto L28
            L27:
            L28:
                int r0 = r3.unread
                if (r0 <= 0) goto L39
                java.io.ObjectInputStream$PeekInputStream r0 = r3.in
                int r0 = r0.available()
                int r1 = r3.unread
                int r0 = java.lang.Math.min(r0, r1)
                goto L3a
            L39:
                r0 = r2
            L3a:
                int r1 = r3.end
                if (r1 < 0) goto L43
                int r2 = r3.pos
                int r1 = r1 - r2
                int r2 = r1 + r0
            L43:
                return r2
            L44:
                java.io.ObjectInputStream$PeekInputStream r0 = r3.in
                int r0 = r0.available()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.available():int");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.blkmode) {
                this.pos = 0;
                this.end = -1;
                this.unread = 0;
            }
            this.in.close();
        }

        int read(byte[] b4, int off, int len, boolean copy) throws IOException {
            if (len == 0) {
                return 0;
            }
            if (this.blkmode) {
                if (this.pos == this.end) {
                    refill();
                }
                int i10 = this.end;
                if (i10 < 0) {
                    return -1;
                }
                int nread = Math.min(len, i10 - this.pos);
                System.arraycopy((Object) this.buf, this.pos, (Object) b4, off, nread);
                this.pos += nread;
                return nread;
            }
            if (copy) {
                int nread2 = this.in.read(this.buf, 0, Math.min(len, 1024));
                if (nread2 > 0) {
                    System.arraycopy((Object) this.buf, 0, (Object) b4, off, nread2);
                }
                return nread2;
            }
            return this.in.read(b4, off, len);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] b4) throws IOException {
            readFully(b4, 0, b4.length, false);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] b4, int off, int len) throws IOException {
            readFully(b4, off, len, false);
        }

        public void readFully(byte[] b4, int off, int len, boolean copy) throws IOException {
            while (len > 0) {
                int n10 = read(b4, off, len, copy);
                if (n10 < 0) {
                    throw new EOFException();
                }
                off += n10;
                len -= n10;
            }
        }

        @Override // java.io.DataInput
        public int skipBytes(int n10) throws IOException {
            return this.din.skipBytes(n10);
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            int v2 = read();
            if (v2 >= 0) {
                return v2 != 0;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int v2 = read();
            if (v2 < 0) {
                throw new EOFException();
            }
            return (byte) v2;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            int v2 = read();
            if (v2 < 0) {
                throw new EOFException();
            }
            return v2;
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 2);
            } else if (this.end - this.pos < 2) {
                return this.din.readChar();
            }
            char v2 = Bits.getChar(this.buf, this.pos);
            this.pos += 2;
            return v2;
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 2);
            } else if (this.end - this.pos < 2) {
                return this.din.readShort();
            }
            short v2 = Bits.getShort(this.buf, this.pos);
            this.pos += 2;
            return v2;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 2);
            } else if (this.end - this.pos < 2) {
                return this.din.readUnsignedShort();
            }
            int v2 = Bits.getShort(this.buf, this.pos) & 65535;
            this.pos += 2;
            return v2;
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 4);
            } else if (this.end - this.pos < 4) {
                return this.din.readInt();
            }
            int v2 = Bits.getInt(this.buf, this.pos);
            this.pos += 4;
            return v2;
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 4);
            } else if (this.end - this.pos < 4) {
                return this.din.readFloat();
            }
            float v2 = Bits.getFloat(this.buf, this.pos);
            this.pos += 4;
            return v2;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 8);
            } else if (this.end - this.pos < 8) {
                return this.din.readLong();
            }
            long v2 = Bits.getLong(this.buf, this.pos);
            this.pos += 8;
            return v2;
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 8);
            } else if (this.end - this.pos < 8) {
                return this.din.readDouble();
            }
            double v2 = Bits.getDouble(this.buf, this.pos);
            this.pos += 8;
            return v2;
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            return readUTFBody(readUnsignedShort());
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return this.din.readLine();
        }

        void readBooleans(boolean[] v2, int off, int len) throws IOException {
            int stop;
            int endoff = off + len;
            while (off < endoff) {
                if (this.blkmode) {
                    int off2 = this.end;
                    int i10 = this.pos;
                    if (off2 - i10 < 1) {
                        v2[off] = this.din.readBoolean();
                        off++;
                    } else {
                        stop = Math.min(endoff, (off2 + off) - i10);
                    }
                } else {
                    int span = Math.min(endoff - off, 1024);
                    this.in.readFully(this.buf, 0, span);
                    stop = off + span;
                    this.pos = 0;
                }
                while (off < stop) {
                    byte[] bArr = this.buf;
                    int i11 = this.pos;
                    this.pos = i11 + 1;
                    v2[off] = Bits.getBoolean(bArr, i11);
                    off++;
                }
            }
        }

        void readChars(char[] v2, int off, int len) throws IOException {
            int stop;
            int endoff = off + len;
            while (off < endoff) {
                if (this.blkmode) {
                    int off2 = this.end;
                    int i10 = this.pos;
                    if (off2 - i10 < 2) {
                        v2[off] = this.din.readChar();
                        off++;
                    } else {
                        stop = Math.min(endoff, ((off2 - i10) >> 1) + off);
                    }
                } else {
                    int span = Math.min(endoff - off, 512);
                    this.in.readFully(this.buf, 0, span << 1);
                    stop = off + span;
                    this.pos = 0;
                }
                while (off < stop) {
                    v2[off] = Bits.getChar(this.buf, this.pos);
                    this.pos += 2;
                    off++;
                }
            }
        }

        void readShorts(short[] v2, int off, int len) throws IOException {
            int stop;
            int endoff = off + len;
            while (off < endoff) {
                if (this.blkmode) {
                    int off2 = this.end;
                    int i10 = this.pos;
                    if (off2 - i10 < 2) {
                        v2[off] = this.din.readShort();
                        off++;
                    } else {
                        stop = Math.min(endoff, ((off2 - i10) >> 1) + off);
                    }
                } else {
                    int span = Math.min(endoff - off, 512);
                    this.in.readFully(this.buf, 0, span << 1);
                    stop = off + span;
                    this.pos = 0;
                }
                while (off < stop) {
                    v2[off] = Bits.getShort(this.buf, this.pos);
                    this.pos += 2;
                    off++;
                }
            }
        }

        void readInts(int[] v2, int off, int len) throws IOException {
            int stop;
            int endoff = off + len;
            while (off < endoff) {
                if (this.blkmode) {
                    int off2 = this.end;
                    int i10 = this.pos;
                    if (off2 - i10 < 4) {
                        v2[off] = this.din.readInt();
                        off++;
                    } else {
                        stop = Math.min(endoff, ((off2 - i10) >> 2) + off);
                    }
                } else {
                    int span = Math.min(endoff - off, 256);
                    this.in.readFully(this.buf, 0, span << 2);
                    stop = off + span;
                    this.pos = 0;
                }
                while (off < stop) {
                    v2[off] = Bits.getInt(this.buf, this.pos);
                    this.pos += 4;
                    off++;
                }
            }
        }

        void readFloats(float[] v2, int off, int len) throws IOException {
            int span;
            int endoff = off + len;
            while (off < endoff) {
                if (!this.blkmode) {
                    span = Math.min(endoff - off, 256);
                    this.in.readFully(this.buf, 0, span << 2);
                    this.pos = 0;
                } else {
                    int span2 = this.end;
                    int i10 = this.pos;
                    if (span2 - i10 < 4) {
                        v2[off] = this.din.readFloat();
                        off++;
                    } else {
                        span = Math.min(endoff - off, (span2 - i10) >> 2);
                    }
                }
                ObjectInputStream.bytesToFloats(this.buf, this.pos, v2, off, span);
                off += span;
                this.pos += span << 2;
            }
        }

        void readLongs(long[] v2, int off, int len) throws IOException {
            int stop;
            int endoff = off + len;
            while (off < endoff) {
                if (this.blkmode) {
                    int off2 = this.end;
                    int i10 = this.pos;
                    if (off2 - i10 < 8) {
                        v2[off] = this.din.readLong();
                        off++;
                    } else {
                        stop = Math.min(endoff, ((off2 - i10) >> 3) + off);
                    }
                } else {
                    int span = Math.min(endoff - off, 128);
                    this.in.readFully(this.buf, 0, span << 3);
                    stop = off + span;
                    this.pos = 0;
                }
                while (off < stop) {
                    v2[off] = Bits.getLong(this.buf, this.pos);
                    this.pos += 8;
                    off++;
                }
            }
        }

        void readDoubles(double[] v2, int off, int len) throws IOException {
            int span;
            int endoff = off + len;
            while (off < endoff) {
                if (!this.blkmode) {
                    span = Math.min(endoff - off, 128);
                    this.in.readFully(this.buf, 0, span << 3);
                    this.pos = 0;
                } else {
                    int span2 = this.end;
                    int i10 = this.pos;
                    if (span2 - i10 < 8) {
                        v2[off] = this.din.readDouble();
                        off++;
                    } else {
                        span = Math.min(endoff - off, (span2 - i10) >> 3);
                    }
                }
                ObjectInputStream.bytesToDoubles(this.buf, this.pos, v2, off, span);
                off += span;
                this.pos += span << 3;
            }
        }

        String readLongUTF() throws IOException {
            return readUTFBody(readLong());
        }

        private String readUTFBody(long utflen) throws IOException {
            StringBuilder sbuf = new StringBuilder();
            if (!this.blkmode) {
                this.pos = 0;
                this.end = 0;
            }
            while (utflen > 0) {
                int i10 = this.end;
                int i11 = this.pos;
                int avail = i10 - i11;
                if (avail >= 3 || avail == utflen) {
                    utflen -= readUTFSpan(sbuf, utflen);
                } else if (this.blkmode) {
                    utflen -= readUTFChar(sbuf, utflen);
                } else {
                    if (avail > 0) {
                        byte[] bArr = this.buf;
                        System.arraycopy((Object) bArr, i11, (Object) bArr, 0, avail);
                    }
                    this.pos = 0;
                    int min = (int) Math.min(1024L, utflen);
                    this.end = min;
                    this.in.readFully(this.buf, avail, min - avail);
                }
            }
            return sbuf.toString();
        }

        /* JADX WARN: Code restructure failed: missing block: B:78:0x0070, code lost:
        
            throw new java.io.UTFDataFormatException();
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0033. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private long readUTFSpan(java.lang.StringBuilder r17, long r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 284
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readUTFSpan(java.lang.StringBuilder, long):long");
        }

        private int readUTFChar(StringBuilder sbuf, long utflen) throws IOException {
            int b12 = readByte() & 255;
            switch (b12 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    sbuf.append((char) b12);
                    return 1;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    throw new UTFDataFormatException();
                case 12:
                case 13:
                    if (utflen < 2) {
                        throw new UTFDataFormatException();
                    }
                    int b22 = readByte();
                    if ((b22 & 192) != 128) {
                        throw new UTFDataFormatException();
                    }
                    sbuf.append((char) (((b12 & 31) << 6) | ((b22 & 63) << 0)));
                    return 2;
                case 14:
                    if (utflen < 3) {
                        if (utflen == 2) {
                            readByte();
                        }
                        throw new UTFDataFormatException();
                    }
                    int b23 = readByte();
                    int b32 = readByte();
                    if ((b23 & 192) != 128 || (b32 & 192) != 128) {
                        throw new UTFDataFormatException();
                    }
                    sbuf.append((char) (((b12 & 15) << 12) | ((b23 & 63) << 6) | ((b32 & 63) << 0)));
                    return 3;
            }
        }

        long getBytesRead() {
            return this.in.getBytesRead();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HandleTable {
        private static final byte STATUS_EXCEPTION = 3;
        private static final byte STATUS_OK = 1;
        private static final byte STATUS_UNKNOWN = 2;
        HandleList[] deps;
        Object[] entries;
        int lowDep = -1;
        int size = 0;
        byte[] status;

        HandleTable(int initialCapacity) {
            this.status = new byte[initialCapacity];
            this.entries = new Object[initialCapacity];
            this.deps = new HandleList[initialCapacity];
        }

        int assign(Object obj) {
            if (this.size >= this.entries.length) {
                grow();
            }
            byte[] bArr = this.status;
            int i10 = this.size;
            bArr[i10] = 2;
            this.entries[i10] = obj;
            this.size = i10 + 1;
            return i10;
        }

        void markDependency(int dependent, int target) {
            if (dependent == -1 || target == -1) {
                return;
            }
            byte[] bArr = this.status;
            switch (bArr[dependent]) {
                case 2:
                    switch (bArr[target]) {
                        case 1:
                            return;
                        case 2:
                            HandleList[] handleListArr = this.deps;
                            if (handleListArr[target] == null) {
                                handleListArr[target] = new HandleList();
                            }
                            this.deps[target].add(dependent);
                            int i10 = this.lowDep;
                            if (i10 < 0 || i10 > target) {
                                this.lowDep = target;
                                return;
                            }
                            return;
                        case 3:
                            markException(dependent, (ClassNotFoundException) this.entries[target]);
                            return;
                        default:
                            throw new InternalError();
                    }
                case 3:
                    return;
                default:
                    throw new InternalError();
            }
        }

        void markException(int handle, ClassNotFoundException ex) {
            byte[] bArr = this.status;
            switch (bArr[handle]) {
                case 2:
                    bArr[handle] = 3;
                    this.entries[handle] = ex;
                    HandleList dlist = this.deps[handle];
                    if (dlist != null) {
                        int ndeps = dlist.size();
                        for (int i10 = 0; i10 < ndeps; i10++) {
                            markException(dlist.get(i10), ex);
                        }
                        this.deps[handle] = null;
                        return;
                    }
                    return;
                case 3:
                    return;
                default:
                    throw new InternalError();
            }
        }

        void finish(int handle) {
            int end;
            int end2 = this.lowDep;
            if (end2 < 0) {
                end = handle + 1;
            } else if (end2 >= handle) {
                end = this.size;
                this.lowDep = -1;
            } else {
                return;
            }
            for (int i10 = handle; i10 < end; i10++) {
                byte[] bArr = this.status;
                switch (bArr[i10]) {
                    case 1:
                    case 3:
                        break;
                    case 2:
                        bArr[i10] = 1;
                        this.deps[i10] = null;
                        break;
                    default:
                        throw new InternalError();
                }
            }
        }

        void setObject(int handle, Object obj) {
            switch (this.status[handle]) {
                case 1:
                case 2:
                    this.entries[handle] = obj;
                    return;
                case 3:
                    return;
                default:
                    throw new InternalError();
            }
        }

        Object lookupObject(int handle) {
            if (handle == -1 || this.status[handle] == 3) {
                return null;
            }
            return this.entries[handle];
        }

        ClassNotFoundException lookupException(int handle) {
            if (handle == -1 || this.status[handle] != 3) {
                return null;
            }
            return (ClassNotFoundException) this.entries[handle];
        }

        void clear() {
            Arrays.fill(this.status, 0, this.size, (byte) 0);
            Arrays.fill(this.entries, 0, this.size, (Object) null);
            Arrays.fill(this.deps, 0, this.size, (Object) null);
            this.lowDep = -1;
            this.size = 0;
        }

        int size() {
            return this.size;
        }

        private void grow() {
            int newCapacity = (this.entries.length << 1) + 1;
            byte[] newStatus = new byte[newCapacity];
            Object[] newEntries = new Object[newCapacity];
            HandleList[] newDeps = new HandleList[newCapacity];
            System.arraycopy((Object) this.status, 0, (Object) newStatus, 0, this.size);
            System.arraycopy(this.entries, 0, newEntries, 0, this.size);
            System.arraycopy(this.deps, 0, newDeps, 0, this.size);
            this.status = newStatus;
            this.entries = newEntries;
            this.deps = newDeps;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class HandleList {
            private int[] list = new int[4];
            private int size = 0;

            public void add(int handle) {
                int i10 = this.size;
                int[] iArr = this.list;
                if (i10 >= iArr.length) {
                    int[] newList = new int[iArr.length << 1];
                    System.arraycopy((Object) iArr, 0, (Object) newList, 0, iArr.length);
                    this.list = newList;
                }
                int[] newList2 = this.list;
                int i11 = this.size;
                this.size = i11 + 1;
                newList2[i11] = handle;
            }

            public int get(int index) {
                if (index >= this.size) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                return this.list[index];
            }

            public int size() {
                return this.size;
            }
        }
    }

    private static Object cloneArray(Object array) {
        if (array instanceof Object[]) {
            return ((Object[]) array).clone();
        }
        if (array instanceof boolean[]) {
            return ((boolean[]) array).clone();
        }
        if (array instanceof byte[]) {
            return ((byte[]) array).clone();
        }
        if (array instanceof char[]) {
            return ((char[]) array).clone();
        }
        if (array instanceof double[]) {
            return ((double[]) array).clone();
        }
        if (array instanceof float[]) {
            return ((float[]) array).clone();
        }
        if (array instanceof int[]) {
            return ((int[]) array).clone();
        }
        if (array instanceof long[]) {
            return ((long[]) array).clone();
        }
        if (array instanceof short[]) {
            return ((short[]) array).clone();
        }
        throw new AssertionError();
    }
}
