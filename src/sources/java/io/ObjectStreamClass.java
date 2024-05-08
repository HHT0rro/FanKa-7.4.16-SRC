package java.io;

import com.android.internal.logging.nano.MetricsProto;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.RecordComponent;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.IntFunction;
import org.apache.commons.io.IOUtils;
import sun.misc.Unsafe;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import sun.reflect.misc.ReflectUtil;
import ta.b;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ObjectStreamClass implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_SDK_TARGET_FOR_CLINIT_UIDGEN_WORKAROUND = 23;
    public static final ObjectStreamField[] NO_FIELDS;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = -6120832682080437368L;
    public static DefaultSUIDCompatibilityListener suidCompatibilityListener = new DefaultSUIDCompatibilityListener() { // from class: java.io.ObjectStreamClass$$ExternalSyntheticLambda1
        @Override // java.io.ObjectStreamClass.DefaultSUIDCompatibilityListener
        public final void warnDefaultSUIDTargetVersionDependent(Class cls, long j10) {
            System.logW("Class " + cls.getCanonicalName() + " relies on its default SUID which is dependent on the app's targetSdkVersion. To avoid problems during upgrade add the following to class " + cls.getCanonicalName() + "\n    private static final long serialVersionUID = " + j10 + "L;");
        }
    };
    private MethodHandle canonicalCtr;
    private Class<?> cl;
    private Constructor<?> cons;
    private volatile ClassDataSlot[] dataLayout;
    private ExceptionInfo defaultSerializeEx;
    private MethodHandle deserializationCtr;
    private DeserializationConstructorsCache deserializationCtrs;
    private ExceptionInfo deserializeEx;
    private boolean externalizable;
    private FieldReflector fieldRefl;
    private ObjectStreamField[] fields;
    private boolean hasBlockExternalData = true;
    private boolean hasWriteObjectData;
    private boolean initialized;
    private boolean isEnum;
    private boolean isProxy;
    private boolean isRecord;
    private ObjectStreamClass localDesc;
    private String name;
    private int numObjFields;
    private int primDataSize;
    private Method readObjectMethod;
    private Method readObjectNoDataMethod;
    private Method readResolveMethod;
    private ClassNotFoundException resolveEx;
    private boolean serializable;
    private ExceptionInfo serializeEx;
    private volatile Long suid;
    private ObjectStreamClass superDesc;
    private Method writeObjectMethod;
    private Method writeReplaceMethod;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface DefaultSUIDCompatibilityListener {
        void warnDefaultSUIDTargetVersionDependent(Class<?> cls, long j10);
    }

    private static native boolean hasStaticInitializer(Class<?> cls, boolean z10);

    static {
        ObjectStreamField[] objectStreamFieldArr = new ObjectStreamField[0];
        NO_FIELDS = objectStreamFieldArr;
        serialPersistentFields = objectStreamFieldArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Caches {
        static final ConcurrentMap<WeakClassKey, Reference<?>> localDescs = new ConcurrentHashMap();
        static final ConcurrentMap<FieldReflectorKey, Reference<?>> reflectors = new ConcurrentHashMap();
        private static final ReferenceQueue<Class<?>> localDescsQueue = new ReferenceQueue<>();
        private static final ReferenceQueue<Class<?>> reflectorsQueue = new ReferenceQueue<>();

        private Caches() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ExceptionInfo {
        private final String className;
        private final String message;

        ExceptionInfo(String cn2, String msg) {
            this.className = cn2;
            this.message = msg;
        }

        InvalidClassException newInvalidClassException() {
            return new InvalidClassException(this.className, this.message);
        }
    }

    public static ObjectStreamClass lookup(Class<?> cl) {
        return lookup(cl, false);
    }

    public static ObjectStreamClass lookupAny(Class<?> cl) {
        return lookup(cl, true);
    }

    public String getName() {
        return this.name;
    }

    public long getSerialVersionUID() {
        if (this.suid == null) {
            if (this.isRecord) {
                return 0L;
            }
            this.suid = (Long) AccessController.doPrivileged(new PrivilegedAction<Long>() { // from class: java.io.ObjectStreamClass.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Long run() {
                    return Long.valueOf(ObjectStreamClass.computeDefaultSUID(ObjectStreamClass.this.cl));
                }
            });
        }
        return this.suid.longValue();
    }

    @CallerSensitive
    public Class<?> forClass() {
        if (this.cl == null) {
            return null;
        }
        requireInitialized();
        if (System.getSecurityManager() != null) {
            Class<?> caller = Reflection.getCallerClass();
            if (ReflectUtil.needsPackageAccessCheck(caller.getClassLoader(), this.cl.getClassLoader())) {
                ReflectUtil.checkPackageAccess(this.cl);
            }
        }
        Class<?> caller2 = this.cl;
        return caller2;
    }

    public ObjectStreamField[] getFields() {
        return getFields(true);
    }

    public ObjectStreamField getField(String name) {
        return getField(name, null);
    }

    public String toString() {
        return this.name + ": static final long serialVersionUID = " + getSerialVersionUID() + "L;";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectStreamClass lookup(Class<?> cl, boolean all) {
        if (!all && !Serializable.class.isAssignableFrom(cl)) {
            return null;
        }
        processQueue(Caches.localDescsQueue, Caches.localDescs);
        WeakClassKey key = new WeakClassKey(cl, Caches.localDescsQueue);
        Reference<?> ref = Caches.localDescs.get(key);
        Object entry = null;
        if (ref != null) {
            entry = ref.get();
        }
        EntryFuture future = null;
        if (entry == null) {
            EntryFuture newEntry = new EntryFuture();
            Reference<?> newRef = new SoftReference<>(newEntry);
            do {
                if (ref != null) {
                    Caches.localDescs.remove(key, ref);
                }
                ref = Caches.localDescs.putIfAbsent(key, newRef);
                if (ref != null) {
                    entry = ref.get();
                }
                if (ref == null) {
                    break;
                }
            } while (entry == null);
            if (entry == null) {
                future = newEntry;
            }
        }
        if (entry instanceof ObjectStreamClass) {
            return (ObjectStreamClass) entry;
        }
        if (entry instanceof EntryFuture) {
            future = (EntryFuture) entry;
            if (future.getOwner() == Thread.currentThread()) {
                entry = null;
            } else {
                entry = future.get();
            }
        }
        if (entry == null) {
            try {
                Object entry2 = new ObjectStreamClass(cl);
                entry = entry2;
            } catch (Throwable th) {
                entry = th;
            }
            if (future.set(entry)) {
                Caches.localDescs.put(key, new SoftReference(entry));
            } else {
                entry = future.get();
            }
        }
        if (entry instanceof ObjectStreamClass) {
            return (ObjectStreamClass) entry;
        }
        if (entry instanceof RuntimeException) {
            throw ((RuntimeException) entry);
        }
        if (entry instanceof Error) {
            throw ((Error) entry);
        }
        throw new InternalError("unexpected entry: " + entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EntryFuture {
        private static final Object unset = new Object();
        private Object entry;
        private final Thread owner;

        private EntryFuture() {
            this.owner = Thread.currentThread();
            this.entry = unset;
        }

        synchronized boolean set(Object entry) {
            if (this.entry != unset) {
                return false;
            }
            this.entry = entry;
            notifyAll();
            return true;
        }

        synchronized Object get() {
            boolean interrupted = false;
            while (this.entry == unset) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    interrupted = true;
                }
            }
            if (interrupted) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.io.ObjectStreamClass.EntryFuture.1
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        Thread.currentThread().interrupt();
                        return null;
                    }
                });
            }
            return this.entry;
        }

        Thread getOwner() {
            return this.owner;
        }
    }

    private ObjectStreamClass(final Class<?> cl) {
        this.cl = cl;
        this.name = cl.getName();
        this.isProxy = Proxy.isProxyClass(cl);
        this.isEnum = Enum.class.isAssignableFrom(cl);
        this.isRecord = cl.isRecord();
        this.serializable = Serializable.class.isAssignableFrom(cl);
        this.externalizable = Externalizable.class.isAssignableFrom(cl);
        Class<?> superCl = cl.getSuperclass();
        this.superDesc = superCl != null ? lookup(superCl, false) : null;
        this.localDesc = this;
        if (this.serializable) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.io.ObjectStreamClass.2
                @Override // java.security.PrivilegedAction
                public Void run() {
                    if (ObjectStreamClass.this.isEnum) {
                        ObjectStreamClass.this.suid = 0L;
                        ObjectStreamClass.this.fields = ObjectStreamClass.NO_FIELDS;
                        return null;
                    }
                    if (cl.isArray()) {
                        ObjectStreamClass.this.fields = ObjectStreamClass.NO_FIELDS;
                        return null;
                    }
                    ObjectStreamClass.this.suid = ObjectStreamClass.getDeclaredSUID(cl);
                    try {
                        ObjectStreamClass.this.fields = ObjectStreamClass.getSerialFields(cl);
                        ObjectStreamClass.this.computeFieldOffsets();
                    } catch (InvalidClassException e2) {
                        ObjectStreamClass objectStreamClass = ObjectStreamClass.this;
                        ExceptionInfo exceptionInfo = new ExceptionInfo(e2.classname, e2.getMessage());
                        objectStreamClass.deserializeEx = exceptionInfo;
                        objectStreamClass.serializeEx = exceptionInfo;
                        ObjectStreamClass.this.fields = ObjectStreamClass.NO_FIELDS;
                    }
                    if (ObjectStreamClass.this.isRecord) {
                        ObjectStreamClass.this.canonicalCtr = ObjectStreamClass.canonicalRecordCtr(cl);
                        ObjectStreamClass.this.deserializationCtrs = new DeserializationConstructorsCache();
                    } else if (ObjectStreamClass.this.externalizable) {
                        ObjectStreamClass.this.cons = ObjectStreamClass.getExternalizableConstructor(cl);
                    } else {
                        ObjectStreamClass.this.cons = ObjectStreamClass.getSerializableConstructor(cl);
                        ObjectStreamClass.this.writeObjectMethod = ObjectStreamClass.getPrivateMethod(cl, "writeObject", new Class[]{ObjectOutputStream.class}, Void.TYPE);
                        ObjectStreamClass.this.readObjectMethod = ObjectStreamClass.getPrivateMethod(cl, "readObject", new Class[]{ObjectInputStream.class}, Void.TYPE);
                        ObjectStreamClass.this.readObjectNoDataMethod = ObjectStreamClass.getPrivateMethod(cl, "readObjectNoData", null, Void.TYPE);
                        ObjectStreamClass objectStreamClass2 = ObjectStreamClass.this;
                        objectStreamClass2.hasWriteObjectData = objectStreamClass2.writeObjectMethod != null;
                    }
                    ObjectStreamClass.this.writeReplaceMethod = ObjectStreamClass.getInheritableMethod(cl, "writeReplace", null, Object.class);
                    ObjectStreamClass.this.readResolveMethod = ObjectStreamClass.getInheritableMethod(cl, "readResolve", null, Object.class);
                    return null;
                }
            });
        } else {
            this.suid = 0L;
            this.fields = NO_FIELDS;
        }
        try {
            this.fieldRefl = getReflector(this.fields, this);
            if (this.deserializeEx == null) {
                if (this.isEnum) {
                    this.deserializeEx = new ExceptionInfo(this.name, "enum type");
                } else if (this.cons == null && !this.isRecord) {
                    this.deserializeEx = new ExceptionInfo(this.name, "no valid constructor");
                }
            }
            if (this.isRecord && this.canonicalCtr == null) {
                this.deserializeEx = new ExceptionInfo(this.name, "record canonical constructor not found");
            } else {
                int i10 = 0;
                while (true) {
                    ObjectStreamField[] objectStreamFieldArr = this.fields;
                    if (i10 >= objectStreamFieldArr.length) {
                        break;
                    }
                    if (objectStreamFieldArr[i10].getField() == null) {
                        this.defaultSerializeEx = new ExceptionInfo(this.name, "unmatched serializable field(s) declared");
                    }
                    i10++;
                }
            }
            this.initialized = true;
        } catch (InvalidClassException ex) {
            throw new InternalError(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamClass() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initProxy(Class<?> cl, ClassNotFoundException resolveEx, ObjectStreamClass superDesc) throws InvalidClassException {
        ObjectStreamClass osc = null;
        if (cl != null) {
            osc = lookup(cl, true);
            if (!osc.isProxy) {
                throw new InvalidClassException("cannot bind proxy descriptor to a non-proxy class");
            }
        }
        this.cl = cl;
        this.resolveEx = resolveEx;
        this.superDesc = superDesc;
        this.isProxy = true;
        this.serializable = true;
        this.suid = 0L;
        ObjectStreamField[] objectStreamFieldArr = NO_FIELDS;
        this.fields = objectStreamFieldArr;
        if (osc != null) {
            this.localDesc = osc;
            this.name = osc.name;
            this.externalizable = osc.externalizable;
            this.writeReplaceMethod = osc.writeReplaceMethod;
            this.readResolveMethod = osc.readResolveMethod;
            this.deserializeEx = osc.deserializeEx;
            this.cons = osc.cons;
        }
        this.fieldRefl = getReflector(objectStreamFieldArr, this.localDesc);
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initNonProxy(ObjectStreamClass model, Class<?> cl, ClassNotFoundException resolveEx, ObjectStreamClass superDesc) throws InvalidClassException {
        boolean z10;
        String str;
        long suid = Long.valueOf(model.getSerialVersionUID()).longValue();
        ObjectStreamClass osc = null;
        if (cl != null) {
            osc = lookup(cl, true);
            if (osc.isProxy) {
                throw new InvalidClassException("cannot bind non-proxy descriptor to a proxy class");
            }
            boolean z11 = model.isEnum;
            if (z11 != osc.isEnum) {
                if (z11) {
                    str = "cannot bind enum descriptor to a non-enum class";
                } else {
                    str = "cannot bind non-enum descriptor to an enum class";
                }
                throw new InvalidClassException(str);
            }
            if (model.serializable == osc.serializable && !cl.isArray() && !cl.isRecord() && suid != osc.getSerialVersionUID()) {
                throw new InvalidClassException(osc.name, "local class incompatible: stream classdesc serialVersionUID = " + suid + ", local class serialVersionUID = " + osc.getSerialVersionUID());
            }
            if (!classNamesEqual(model.name, osc.name)) {
                throw new InvalidClassException(osc.name, "local class name incompatible with stream class name \"" + model.name + "\"");
            }
            if (!model.isEnum) {
                boolean z12 = model.serializable;
                boolean z13 = osc.serializable;
                if (z12 == z13 && model.externalizable != osc.externalizable) {
                    throw new InvalidClassException(osc.name, "Serializable incompatible with Externalizable");
                }
                if (z12 != z13 || (z10 = model.externalizable) != osc.externalizable || (!z12 && !z10)) {
                    this.deserializeEx = new ExceptionInfo(osc.name, "class invalid for deserialization");
                }
            }
        }
        this.cl = cl;
        this.resolveEx = resolveEx;
        this.superDesc = superDesc;
        this.name = model.name;
        this.suid = Long.valueOf(suid);
        this.isProxy = false;
        this.isEnum = model.isEnum;
        this.serializable = model.serializable;
        this.externalizable = model.externalizable;
        this.hasBlockExternalData = model.hasBlockExternalData;
        this.hasWriteObjectData = model.hasWriteObjectData;
        ObjectStreamField[] objectStreamFieldArr = model.fields;
        this.fields = objectStreamFieldArr;
        this.primDataSize = model.primDataSize;
        this.numObjFields = model.numObjFields;
        if (osc != null) {
            this.localDesc = osc;
            this.isRecord = osc.isRecord;
            this.canonicalCtr = osc.canonicalCtr;
            this.deserializationCtrs = osc.deserializationCtrs;
            this.writeObjectMethod = osc.writeObjectMethod;
            this.readObjectMethod = osc.readObjectMethod;
            this.readObjectNoDataMethod = osc.readObjectNoDataMethod;
            this.writeReplaceMethod = osc.writeReplaceMethod;
            this.readResolveMethod = osc.readResolveMethod;
            if (this.deserializeEx == null) {
                this.deserializeEx = osc.deserializeEx;
            }
            this.cons = osc.cons;
        }
        FieldReflector reflector = getReflector(objectStreamFieldArr, this.localDesc);
        this.fieldRefl = reflector;
        this.fields = reflector.getFields();
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readNonProxy(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.suid = Long.valueOf(in.readLong());
        this.isProxy = false;
        byte flags = in.readByte();
        this.hasWriteObjectData = (flags & 1) != 0;
        this.hasBlockExternalData = (flags & 8) != 0;
        boolean z10 = (flags & 4) != 0;
        this.externalizable = z10;
        boolean sflag = (flags & 2) != 0;
        if (z10 && sflag) {
            throw new InvalidClassException(this.name, "serializable and externalizable flags conflict");
        }
        this.serializable = z10 || sflag;
        boolean z11 = (flags & 16) != 0;
        this.isEnum = z11;
        if (z11 && this.suid.longValue() != 0) {
            throw new InvalidClassException(this.name, "enum descriptor has non-zero serialVersionUID: " + ((Object) this.suid));
        }
        int numFields = in.readShort();
        if (this.isEnum && numFields != 0) {
            throw new InvalidClassException(this.name, "enum descriptor has non-zero field count: " + numFields);
        }
        this.fields = numFields > 0 ? new ObjectStreamField[numFields] : NO_FIELDS;
        for (int i10 = 0; i10 < numFields; i10++) {
            char tcode = (char) in.readByte();
            String fname = in.readUTF();
            String signature = (tcode == 'L' || tcode == '[') ? in.readTypeString() : new String(new char[]{tcode});
            try {
                this.fields[i10] = new ObjectStreamField(fname, signature, false);
            } catch (RuntimeException e2) {
                throw ((IOException) new InvalidClassException(this.name, "invalid descriptor for field " + fname).initCause(e2));
            }
        }
        computeFieldOffsets();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeNonProxy(ObjectOutputStream out) throws IOException {
        out.writeUTF(this.name);
        out.writeLong(getSerialVersionUID());
        byte flags = 0;
        if (this.externalizable) {
            flags = (byte) (0 | 4);
            int protocol = out.getProtocolVersion();
            if (protocol != 1) {
                flags = (byte) (flags | 8);
            }
        } else if (this.serializable) {
            flags = (byte) (0 | 2);
        }
        if (this.hasWriteObjectData) {
            flags = (byte) (flags | 1);
        }
        if (this.isEnum) {
            flags = (byte) (flags | 16);
        }
        out.writeByte(flags);
        out.writeShort(this.fields.length);
        int i10 = 0;
        while (true) {
            ObjectStreamField[] objectStreamFieldArr = this.fields;
            if (i10 < objectStreamFieldArr.length) {
                ObjectStreamField f10 = objectStreamFieldArr[i10];
                out.writeByte(f10.getTypeCode());
                out.writeUTF(f10.getName());
                if (!f10.isPrimitive()) {
                    out.writeTypeString(f10.getTypeString());
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassNotFoundException getResolveException() {
        return this.resolveEx;
    }

    private final void requireInitialized() {
        if (!this.initialized) {
            throw new InternalError("Unexpected call when not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkDeserialize() throws InvalidClassException {
        requireInitialized();
        ExceptionInfo exceptionInfo = this.deserializeEx;
        if (exceptionInfo != null) {
            throw exceptionInfo.newInvalidClassException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkSerialize() throws InvalidClassException {
        requireInitialized();
        ExceptionInfo exceptionInfo = this.serializeEx;
        if (exceptionInfo != null) {
            throw exceptionInfo.newInvalidClassException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkDefaultSerialize() throws InvalidClassException {
        requireInitialized();
        ExceptionInfo exceptionInfo = this.defaultSerializeEx;
        if (exceptionInfo != null) {
            throw exceptionInfo.newInvalidClassException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamClass getSuperDesc() {
        requireInitialized();
        return this.superDesc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamClass getLocalDesc() {
        requireInitialized();
        return this.localDesc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamField[] getFields(boolean copy) {
        ObjectStreamField[] objectStreamFieldArr = this.fields;
        return copy ? (ObjectStreamField[]) objectStreamFieldArr.clone() : objectStreamFieldArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamField getField(String name, Class<?> type) {
        ObjectStreamField f10;
        int i10 = 0;
        while (true) {
            ObjectStreamField[] objectStreamFieldArr = this.fields;
            if (i10 < objectStreamFieldArr.length) {
                f10 = objectStreamFieldArr[i10];
                if (f10.getName().equals(name)) {
                    if (type == null || (type == Object.class && !f10.isPrimitive())) {
                        break;
                    }
                    Class<?> ftype = f10.getType();
                    if (ftype != null && type.isAssignableFrom(ftype)) {
                        return f10;
                    }
                }
                i10++;
            } else {
                return null;
            }
        }
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isProxy() {
        requireInitialized();
        return this.isProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnum() {
        requireInitialized();
        return this.isEnum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRecord() {
        requireInitialized();
        return this.isRecord;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExternalizable() {
        requireInitialized();
        return this.externalizable;
    }

    boolean isSerializable() {
        requireInitialized();
        return this.serializable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasBlockExternalData() {
        requireInitialized();
        return this.hasBlockExternalData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasWriteObjectData() {
        requireInitialized();
        return this.hasWriteObjectData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInstantiable() {
        requireInitialized();
        return this.cons != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasWriteObjectMethod() {
        requireInitialized();
        return this.writeObjectMethod != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadObjectMethod() {
        requireInitialized();
        return this.readObjectMethod != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadObjectNoDataMethod() {
        requireInitialized();
        return this.readObjectNoDataMethod != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasWriteReplaceMethod() {
        requireInitialized();
        return this.writeReplaceMethod != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadResolveMethod() {
        requireInitialized();
        return this.readResolveMethod != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object newInstance() throws InstantiationException, InvocationTargetException, UnsupportedOperationException {
        requireInitialized();
        Constructor<?> constructor = this.cons;
        if (constructor != null) {
            try {
                return constructor.newInstance(new Object[0]);
            } catch (IllegalAccessException ex) {
                throw new InternalError(ex);
            }
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeWriteObject(Object obj, ObjectOutputStream out) throws IOException, UnsupportedOperationException {
        requireInitialized();
        Method method = this.writeObjectMethod;
        if (method != null) {
            try {
                method.invoke(obj, out);
                return;
            } catch (IllegalAccessException ex) {
                throw new InternalError(ex);
            } catch (InvocationTargetException ex2) {
                Throwable th = ex2.getTargetException();
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throwMiscException(th);
                return;
            }
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeReadObject(Object obj, ObjectInputStream in) throws ClassNotFoundException, IOException, UnsupportedOperationException {
        requireInitialized();
        Method method = this.readObjectMethod;
        if (method != null) {
            try {
                method.invoke(obj, in);
                return;
            } catch (IllegalAccessException ex) {
                throw new InternalError(ex);
            } catch (InvocationTargetException ex2) {
                Throwable th = ex2.getTargetException();
                if (th instanceof ClassNotFoundException) {
                    throw ((ClassNotFoundException) th);
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throwMiscException(th);
                return;
            }
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeReadObjectNoData(Object obj) throws IOException, UnsupportedOperationException {
        requireInitialized();
        Method method = this.readObjectNoDataMethod;
        if (method != null) {
            try {
                method.invoke(obj, null);
                return;
            } catch (IllegalAccessException ex) {
                throw new InternalError(ex);
            } catch (InvocationTargetException ex2) {
                Throwable th = ex2.getTargetException();
                if (th instanceof ObjectStreamException) {
                    throw ((ObjectStreamException) th);
                }
                throwMiscException(th);
                return;
            }
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object invokeWriteReplace(Object obj) throws IOException, UnsupportedOperationException {
        requireInitialized();
        Method method = this.writeReplaceMethod;
        if (method != null) {
            try {
                return method.invoke(obj, null);
            } catch (IllegalAccessException ex) {
                throw new InternalError(ex);
            } catch (InvocationTargetException ex2) {
                Throwable th = ex2.getTargetException();
                if (th instanceof ObjectStreamException) {
                    throw ((ObjectStreamException) th);
                }
                throwMiscException(th);
                throw new InternalError(th);
            }
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object invokeReadResolve(Object obj) throws IOException, UnsupportedOperationException {
        requireInitialized();
        Method method = this.readResolveMethod;
        if (method != null) {
            try {
                return method.invoke(obj, null);
            } catch (IllegalAccessException ex) {
                throw new InternalError(ex);
            } catch (InvocationTargetException ex2) {
                Throwable th = ex2.getTargetException();
                if (th instanceof ObjectStreamException) {
                    throw ((ObjectStreamException) th);
                }
                throwMiscException(th);
                throw new InternalError(th);
            }
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ClassDataSlot {
        final ObjectStreamClass desc;
        final boolean hasData;

        ClassDataSlot(ObjectStreamClass desc, boolean hasData) {
            this.desc = desc;
            this.hasData = hasData;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassDataSlot[] getClassDataLayout() throws InvalidClassException {
        if (this.dataLayout == null) {
            this.dataLayout = getClassDataLayout0();
        }
        return this.dataLayout;
    }

    private ClassDataSlot[] getClassDataLayout0() throws InvalidClassException {
        ArrayList<ClassDataSlot> slots = new ArrayList<>();
        Class<?> start = this.cl;
        Class<?> end = this.cl;
        while (end != null && Serializable.class.isAssignableFrom(end)) {
            end = end.getSuperclass();
        }
        HashSet<String> oscNames = new HashSet<>(3);
        for (ObjectStreamClass d10 = this; d10 != null; d10 = d10.superDesc) {
            if (oscNames.contains(d10.name)) {
                throw new InvalidClassException("Circular reference.");
            }
            oscNames.add(d10.name);
            Class<?> cls = d10.cl;
            String searchName = cls != null ? cls.getName() : d10.name;
            Class<?> match = null;
            Class<?> c4 = start;
            while (true) {
                if (c4 == end) {
                    break;
                }
                if (!searchName.equals(c4.getName())) {
                    c4 = c4.getSuperclass();
                } else {
                    match = c4;
                    break;
                }
            }
            if (match != null) {
                for (Class<?> c10 = start; c10 != match; c10 = c10.getSuperclass()) {
                    slots.add(new ClassDataSlot(lookup(c10, true), false));
                }
                start = match.getSuperclass();
            }
            slots.add(new ClassDataSlot(d10.getVariantFor(match), true));
        }
        for (Class<?> c11 = start; c11 != end; c11 = c11.getSuperclass()) {
            slots.add(new ClassDataSlot(lookup(c11, true), false));
        }
        Collections.reverse(slots);
        return (ClassDataSlot[]) slots.toArray(new ClassDataSlot[slots.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPrimDataSize() {
        return this.primDataSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumObjFields() {
        return this.numObjFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getPrimFieldValues(Object obj, byte[] buf) {
        this.fieldRefl.getPrimFieldValues(obj, buf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPrimFieldValues(Object obj, byte[] buf) {
        this.fieldRefl.setPrimFieldValues(obj, buf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getObjFieldValues(Object obj, Object[] vals) {
        this.fieldRefl.getObjFieldValues(obj, vals);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setObjFieldValues(Object obj, Object[] vals) {
        this.fieldRefl.setObjFieldValues(obj, vals);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void computeFieldOffsets() throws InvalidClassException {
        this.primDataSize = 0;
        this.numObjFields = 0;
        int firstObjIndex = -1;
        int i10 = 0;
        while (true) {
            ObjectStreamField[] objectStreamFieldArr = this.fields;
            if (i10 < objectStreamFieldArr.length) {
                ObjectStreamField f10 = objectStreamFieldArr[i10];
                switch (f10.getTypeCode()) {
                    case 'B':
                    case 'Z':
                        int i11 = this.primDataSize;
                        this.primDataSize = i11 + 1;
                        f10.setOffset(i11);
                        break;
                    case 'C':
                    case 'S':
                        f10.setOffset(this.primDataSize);
                        this.primDataSize += 2;
                        break;
                    case 'D':
                    case 'J':
                        f10.setOffset(this.primDataSize);
                        this.primDataSize += 8;
                        break;
                    case 'F':
                    case 'I':
                        f10.setOffset(this.primDataSize);
                        this.primDataSize += 4;
                        break;
                    case 'L':
                    case '[':
                        int i12 = this.numObjFields;
                        this.numObjFields = i12 + 1;
                        f10.setOffset(i12);
                        if (firstObjIndex != -1) {
                            break;
                        } else {
                            firstObjIndex = i10;
                            break;
                        }
                    default:
                        throw new InternalError();
                }
                i10++;
            } else {
                if (firstObjIndex != -1 && this.numObjFields + firstObjIndex != objectStreamFieldArr.length) {
                    throw new InvalidClassException(this.name, "illegal field order");
                }
                return;
            }
        }
    }

    private ObjectStreamClass getVariantFor(Class<?> cl) throws InvalidClassException {
        if (this.cl == cl) {
            return this;
        }
        ObjectStreamClass desc = new ObjectStreamClass();
        if (this.isProxy) {
            desc.initProxy(cl, null, this.superDesc);
        } else {
            desc.initNonProxy(this, cl, null, this.superDesc);
        }
        return desc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<?> getExternalizableConstructor(Class<?> cl) {
        try {
            Constructor<?> cons = cl.getDeclaredConstructor(null);
            cons.setAccessible(true);
            if ((1 & cons.getModifiers()) == 0) {
                return null;
            }
            return cons;
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<?> getSerializableConstructor(Class<?> cl) {
        Class<?> initCl = cl;
        while (Serializable.class.isAssignableFrom(initCl)) {
            Class<? super Object> superclass = initCl.getSuperclass();
            initCl = superclass;
            if (superclass == null) {
                return null;
            }
        }
        try {
            Constructor<?> cons = initCl.getDeclaredConstructor(null);
            int mods = cons.getModifiers();
            if ((mods & 2) == 0 && ((mods & 5) != 0 || packageEquals(cl, initCl))) {
                if (cons.getDeclaringClass() != cl) {
                    cons = cons.serializationCopy(cons.getDeclaringClass(), cl);
                }
                cons.setAccessible(true);
                return cons;
            }
            return null;
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MethodHandle canonicalRecordCtr(final Class<?> cls) {
        PrivilegedAction<MethodHandle> pa2 = new PrivilegedAction() { // from class: java.io.ObjectStreamClass$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ObjectStreamClass.lambda$canonicalRecordCtr$1(Class.this);
            }
        };
        return (MethodHandle) AccessController.doPrivileged(pa2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MethodHandle lambda$canonicalRecordCtr$1(Class cls) {
        Class<?>[] paramTypes = (Class[]) Arrays.stream(cls.getRecordComponents()).map(new Function() { // from class: java.io.ObjectStreamClass$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((RecordComponent) obj).getType();
            }
        }).toArray(new IntFunction() { // from class: java.io.ObjectStreamClass$$ExternalSyntheticLambda3
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return ObjectStreamClass.lambda$canonicalRecordCtr$0(i10);
            }
        });
        try {
            Constructor<?> ctr = cls.getDeclaredConstructor(paramTypes);
            ctr.setAccessible(true);
            return MethodHandles.lookup().unreflectConstructor(ctr);
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Class[] lambda$canonicalRecordCtr$0(int x$0) {
        return new Class[x$0];
    }

    MethodHandle getRecordConstructor() {
        return this.canonicalCtr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getInheritableMethod(Class<?> cl, String name, Class<?>[] argTypes, Class<?> returnType) {
        Method meth = null;
        Class<?> defCl = cl;
        while (true) {
            if (defCl == null) {
                break;
            }
            try {
                meth = defCl.getDeclaredMethod(name, argTypes);
                break;
            } catch (NoSuchMethodException e2) {
                defCl = defCl.getSuperclass();
            }
        }
        if (meth == null || meth.getReturnType() != returnType) {
            return null;
        }
        meth.setAccessible(true);
        int mods = meth.getModifiers();
        if ((mods & 1032) != 0) {
            return null;
        }
        if ((mods & 5) != 0) {
            return meth;
        }
        if ((mods & 2) != 0) {
            if (cl == defCl) {
                return meth;
            }
            return null;
        }
        if (packageEquals(cl, defCl)) {
            return meth;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getPrivateMethod(Class<?> cl, String name, Class<?>[] argTypes, Class<?> returnType) {
        try {
            Method meth = cl.getDeclaredMethod(name, argTypes);
            meth.setAccessible(true);
            int mods = meth.getModifiers();
            if (meth.getReturnType() != returnType || (mods & 8) != 0 || (mods & 2) == 0) {
                return null;
            }
            return meth;
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    private static boolean packageEquals(Class<?> cl1, Class<?> cl2) {
        return cl1.getClassLoader() == cl2.getClassLoader() && getPackageName(cl1).equals(getPackageName(cl2));
    }

    private static String getPackageName(Class<?> cl) {
        String s2 = cl.getName();
        int i10 = s2.lastIndexOf(91);
        if (i10 >= 0) {
            s2 = s2.substring(i10 + 2);
        }
        int i11 = s2.lastIndexOf(46);
        return i11 >= 0 ? s2.substring(0, i11) : "";
    }

    private static boolean classNamesEqual(String name1, String name2) {
        return name1.substring(name1.lastIndexOf(46) + 1).equals(name2.substring(name2.lastIndexOf(46) + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getClassSignature(Class<?> cl) {
        StringBuilder sbuf = new StringBuilder();
        while (cl.isArray()) {
            sbuf.append('[');
            cl = cl.getComponentType();
        }
        if (cl.isPrimitive()) {
            if (cl == Integer.TYPE) {
                sbuf.append('I');
            } else if (cl == Byte.TYPE) {
                sbuf.append('B');
            } else if (cl == Long.TYPE) {
                sbuf.append('J');
            } else if (cl == Float.TYPE) {
                sbuf.append('F');
            } else if (cl == Double.TYPE) {
                sbuf.append('D');
            } else if (cl == Short.TYPE) {
                sbuf.append('S');
            } else if (cl == Character.TYPE) {
                sbuf.append('C');
            } else if (cl == Boolean.TYPE) {
                sbuf.append('Z');
            } else if (cl == Void.TYPE) {
                sbuf.append('V');
            } else {
                throw new InternalError();
            }
        } else {
            sbuf.append('L' + cl.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX) + ';');
        }
        return sbuf.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getMethodSignature(Class<?>[] paramTypes, Class<?> retType) {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append('(');
        for (Class<?> cls : paramTypes) {
            sbuf.append(getClassSignature(cls));
        }
        sbuf.append(')');
        sbuf.append(getClassSignature(retType));
        return sbuf.toString();
    }

    private static void throwMiscException(Throwable th) throws IOException {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        IOException ex = new IOException("unexpected exception type");
        ex.initCause(th);
        throw ex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ObjectStreamField[] getSerialFields(Class<?> cl) throws InvalidClassException {
        ObjectStreamField[] fields;
        if (cl.isRecord()) {
            ObjectStreamField[] fields2 = getDefaultSerialFields(cl);
            Arrays.sort(fields2);
            return fields2;
        }
        if (Serializable.class.isAssignableFrom(cl) && !Externalizable.class.isAssignableFrom(cl) && !Proxy.isProxyClass(cl) && !cl.isInterface()) {
            ObjectStreamField[] fields3 = getDeclaredSerialFields(cl);
            if (fields3 != null) {
                fields = fields3;
            } else {
                fields = getDefaultSerialFields(cl);
            }
            Arrays.sort(fields);
            return fields;
        }
        return NO_FIELDS;
    }

    private static ObjectStreamField[] getDeclaredSerialFields(Class<?> cl) throws InvalidClassException {
        ObjectStreamField[] serialPersistentFields2 = null;
        try {
            Field f10 = cl.getDeclaredField("serialPersistentFields");
            if ((f10.getModifiers() & 26) == 26) {
                f10.setAccessible(true);
                serialPersistentFields2 = (ObjectStreamField[]) f10.get(null);
            }
        } catch (Exception e2) {
        }
        if (serialPersistentFields2 == null) {
            return null;
        }
        if (serialPersistentFields2.length == 0) {
            return NO_FIELDS;
        }
        ObjectStreamField[] boundFields = new ObjectStreamField[serialPersistentFields2.length];
        Set<String> fieldNames = new HashSet<>(serialPersistentFields2.length);
        for (int i10 = 0; i10 < serialPersistentFields2.length; i10++) {
            ObjectStreamField spf = serialPersistentFields2[i10];
            String fname = spf.getName();
            if (fieldNames.contains(fname)) {
                throw new InvalidClassException("multiple serializable fields named " + fname);
            }
            fieldNames.add(fname);
            try {
                Field f11 = cl.getDeclaredField(fname);
                if (f11.getType() == spf.getType() && (f11.getModifiers() & 8) == 0) {
                    boundFields[i10] = new ObjectStreamField(f11, spf.isUnshared(), true);
                }
            } catch (NoSuchFieldException e10) {
            }
            if (boundFields[i10] == null) {
                boundFields[i10] = new ObjectStreamField(fname, spf.getType(), spf.isUnshared());
            }
        }
        return boundFields;
    }

    private static ObjectStreamField[] getDefaultSerialFields(Class<?> cl) {
        Field[] clFields = cl.getDeclaredFields();
        ArrayList<ObjectStreamField> list = new ArrayList<>();
        for (int i10 = 0; i10 < clFields.length; i10++) {
            if ((clFields[i10].getModifiers() & 136) == 0) {
                list.add(new ObjectStreamField(clFields[i10], false, true));
            }
        }
        int size = list.size();
        return size == 0 ? NO_FIELDS : (ObjectStreamField[]) list.toArray(new ObjectStreamField[size]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Long getDeclaredSUID(Class<?> cl) {
        try {
            Field f10 = cl.getDeclaredField("serialVersionUID");
            if ((f10.getModifiers() & 24) == 24) {
                f10.setAccessible(true);
                return Long.valueOf(f10.getLong(null));
            }
        } catch (Exception e2) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long computeDefaultSUID(Class<?> cl) {
        MemberSignature[] methSigs;
        int classMods;
        int i10;
        if (!Serializable.class.isAssignableFrom(cl) || Proxy.isProxyClass(cl)) {
            return 0L;
        }
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            DataOutputStream dout = new DataOutputStream(bout);
            dout.writeUTF(cl.getName());
            int classMods2 = cl.getModifiers() & MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_MILLIS_SINCE_LAST_LAUNCH;
            Method[] methods = cl.getDeclaredMethods();
            if ((classMods2 & 512) != 0) {
                if (methods.length > 0) {
                    i10 = classMods2 | 1024;
                } else {
                    i10 = classMods2 & (-1025);
                }
                classMods2 = i10;
            }
            dout.writeInt(classMods2);
            if (!cl.isArray()) {
                Class<?>[] interfaces = cl.getInterfaces();
                String[] ifaceNames = new String[interfaces.length];
                for (int i11 = 0; i11 < interfaces.length; i11++) {
                    ifaceNames[i11] = interfaces[i11].getName();
                }
                Arrays.sort(ifaceNames);
                for (String str : ifaceNames) {
                    dout.writeUTF(str);
                }
            }
            Field[] fields = cl.getDeclaredFields();
            MemberSignature[] fieldSigs = new MemberSignature[fields.length];
            for (int i12 = 0; i12 < fields.length; i12++) {
                fieldSigs[i12] = new MemberSignature(fields[i12]);
            }
            Arrays.sort(fieldSigs, new Comparator<MemberSignature>() { // from class: java.io.ObjectStreamClass.3
                @Override // java.util.Comparator
                public int compare(MemberSignature ms1, MemberSignature ms2) {
                    return ms1.name.compareTo(ms2.name);
                }
            });
            for (MemberSignature sig : fieldSigs) {
                int mods = sig.member.getModifiers() & 223;
                if ((mods & 2) == 0 || (mods & 136) == 0) {
                    dout.writeUTF(sig.name);
                    dout.writeInt(mods);
                    dout.writeUTF(sig.signature);
                }
            }
            boolean inheritStaticInitializer = VMRuntime.getRuntime().getTargetSdkVersion() <= 23;
            boolean warnIncompatibleSUIDChange = false;
            if (hasStaticInitializer(cl, inheritStaticInitializer)) {
                if (inheritStaticInitializer && !hasStaticInitializer(cl, false)) {
                    warnIncompatibleSUIDChange = true;
                }
                dout.writeUTF("<clinit>");
                dout.writeInt(8);
                dout.writeUTF("()V");
            }
            Constructor<?>[] cons = cl.getDeclaredConstructors();
            MemberSignature[] consSigs = new MemberSignature[cons.length];
            for (int i13 = 0; i13 < cons.length; i13++) {
                consSigs[i13] = new MemberSignature(cons[i13]);
            }
            Arrays.sort(consSigs, new Comparator<MemberSignature>() { // from class: java.io.ObjectStreamClass.4
                @Override // java.util.Comparator
                public int compare(MemberSignature ms1, MemberSignature ms2) {
                    return ms1.signature.compareTo(ms2.signature);
                }
            });
            int i14 = 0;
            while (i14 < consSigs.length) {
                MemberSignature sig2 = consSigs[i14];
                int mods2 = sig2.member.getModifiers() & 3391;
                if ((mods2 & 2) != 0) {
                    classMods = classMods2;
                } else {
                    dout.writeUTF("<init>");
                    dout.writeInt(mods2);
                    classMods = classMods2;
                    dout.writeUTF(sig2.signature.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
                }
                i14++;
                classMods2 = classMods;
            }
            MemberSignature[] methSigs2 = new MemberSignature[methods.length];
            for (int i15 = 0; i15 < methods.length; i15++) {
                methSigs2[i15] = new MemberSignature(methods[i15]);
            }
            Arrays.sort(methSigs2, new Comparator<MemberSignature>() { // from class: java.io.ObjectStreamClass.5
                @Override // java.util.Comparator
                public int compare(MemberSignature ms1, MemberSignature ms2) {
                    int comp = ms1.name.compareTo(ms2.name);
                    if (comp == 0) {
                        return ms1.signature.compareTo(ms2.signature);
                    }
                    return comp;
                }
            });
            int i16 = 0;
            while (i16 < methSigs2.length) {
                MemberSignature sig3 = methSigs2[i16];
                int mods3 = sig3.member.getModifiers() & 3391;
                if ((mods3 & 2) != 0) {
                    methSigs = methSigs2;
                } else {
                    dout.writeUTF(sig3.name);
                    dout.writeInt(mods3);
                    methSigs = methSigs2;
                    dout.writeUTF(sig3.signature.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
                }
                i16++;
                methSigs2 = methSigs;
            }
            dout.flush();
            MessageDigest md2 = MessageDigest.getInstance(b.f53790a);
            byte[] hashBytes = md2.digest(bout.toByteArray());
            long hash = 0;
            char c4 = '\b';
            int i17 = Math.min(hashBytes.length, 8) - 1;
            while (i17 >= 0) {
                hash = (hash << c4) | (hashBytes[i17] & 255);
                i17--;
                dout = dout;
                md2 = md2;
                c4 = '\b';
            }
            if (warnIncompatibleSUIDChange) {
                suidCompatibilityListener.warnDefaultSUIDTargetVersionDependent(cl, hash);
            }
            return hash;
        } catch (IOException ex) {
            throw new InternalError(ex);
        } catch (NoSuchAlgorithmException ex2) {
            throw new SecurityException(ex2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class MemberSignature {
        public final Member member;
        public final String name;
        public final String signature;

        public MemberSignature(Field field) {
            this.member = field;
            this.name = field.getName();
            this.signature = ObjectStreamClass.getClassSignature(field.getType());
        }

        public MemberSignature(Constructor<?> cons) {
            this.member = cons;
            this.name = cons.getName();
            this.signature = ObjectStreamClass.getMethodSignature(cons.getParameterTypes(), Void.TYPE);
        }

        public MemberSignature(Method meth) {
            this.member = meth;
            this.name = meth.getName();
            this.signature = ObjectStreamClass.getMethodSignature(meth.getParameterTypes(), meth.getReturnType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FieldReflector {
        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private final ObjectStreamField[] fields;
        private final int numPrimFields;
        private final int[] offsets;
        private final long[] readKeys;
        private final char[] typeCodes;
        private final Class<?>[] types;
        private final long[] writeKeys;

        FieldReflector(ObjectStreamField[] fields) {
            long key;
            this.fields = fields;
            int nfields = fields.length;
            this.readKeys = new long[nfields];
            this.writeKeys = new long[nfields];
            this.offsets = new int[nfields];
            this.typeCodes = new char[nfields];
            ArrayList<Class<?>> typeList = new ArrayList<>();
            Set<Long> usedKeys = new HashSet<>();
            for (int i10 = 0; i10 < nfields; i10++) {
                ObjectStreamField f10 = fields[i10];
                Field rf = f10.getField();
                if (rf == null) {
                    key = -1;
                } else {
                    key = unsafe.objectFieldOffset(rf);
                }
                this.readKeys[i10] = key;
                this.writeKeys[i10] = usedKeys.add(Long.valueOf(key)) ? key : -1L;
                this.offsets[i10] = f10.getOffset();
                this.typeCodes[i10] = f10.getTypeCode();
                if (!f10.isPrimitive()) {
                    typeList.add(rf != null ? rf.getType() : null);
                }
            }
            int i11 = typeList.size();
            Class<?>[] clsArr = (Class[]) typeList.toArray(new Class[i11]);
            this.types = clsArr;
            this.numPrimFields = nfields - clsArr.length;
        }

        ObjectStreamField[] getFields() {
            return this.fields;
        }

        void getPrimFieldValues(Object obj, byte[] buf) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i10 = 0; i10 < this.numPrimFields; i10++) {
                long key = this.readKeys[i10];
                int off = this.offsets[i10];
                switch (this.typeCodes[i10]) {
                    case 'B':
                        buf[off] = unsafe.getByte(obj, key);
                        break;
                    case 'C':
                        Bits.putChar(buf, off, unsafe.getChar(obj, key));
                        break;
                    case 'D':
                        Bits.putDouble(buf, off, unsafe.getDouble(obj, key));
                        break;
                    case 'F':
                        Bits.putFloat(buf, off, unsafe.getFloat(obj, key));
                        break;
                    case 'I':
                        Bits.putInt(buf, off, unsafe.getInt(obj, key));
                        break;
                    case 'J':
                        Bits.putLong(buf, off, unsafe.getLong(obj, key));
                        break;
                    case 'S':
                        Bits.putShort(buf, off, unsafe.getShort(obj, key));
                        break;
                    case 'Z':
                        Bits.putBoolean(buf, off, unsafe.getBoolean(obj, key));
                        break;
                    default:
                        throw new InternalError();
                }
            }
        }

        void setPrimFieldValues(Object obj, byte[] buf) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i10 = 0; i10 < this.numPrimFields; i10++) {
                long key = this.writeKeys[i10];
                if (key != -1) {
                    int off = this.offsets[i10];
                    switch (this.typeCodes[i10]) {
                        case 'B':
                            unsafe.putByte(obj, key, buf[off]);
                            break;
                        case 'C':
                            unsafe.putChar(obj, key, Bits.getChar(buf, off));
                            break;
                        case 'D':
                            unsafe.putDouble(obj, key, Bits.getDouble(buf, off));
                            break;
                        case 'F':
                            unsafe.putFloat(obj, key, Bits.getFloat(buf, off));
                            break;
                        case 'I':
                            unsafe.putInt(obj, key, Bits.getInt(buf, off));
                            break;
                        case 'J':
                            unsafe.putLong(obj, key, Bits.getLong(buf, off));
                            break;
                        case 'S':
                            unsafe.putShort(obj, key, Bits.getShort(buf, off));
                            break;
                        case 'Z':
                            unsafe.putBoolean(obj, key, Bits.getBoolean(buf, off));
                            break;
                        default:
                            throw new InternalError();
                    }
                }
            }
        }

        void getObjFieldValues(Object obj, Object[] vals) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i10 = this.numPrimFields; i10 < this.fields.length; i10++) {
                switch (this.typeCodes[i10]) {
                    case 'L':
                    case '[':
                        vals[this.offsets[i10]] = unsafe.getObject(obj, this.readKeys[i10]);
                    default:
                        throw new InternalError();
                }
            }
        }

        void setObjFieldValues(Object obj, Object[] vals) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i10 = this.numPrimFields; i10 < this.fields.length; i10++) {
                long key = this.writeKeys[i10];
                if (key != -1) {
                    switch (this.typeCodes[i10]) {
                        case 'L':
                        case '[':
                            Object val = vals[this.offsets[i10]];
                            if (val != null && !this.types[i10 - this.numPrimFields].isInstance(val)) {
                                Field f10 = this.fields[i10].getField();
                                throw new ClassCastException("cannot assign instance of " + val.getClass().getName() + " to field " + f10.getDeclaringClass().getName() + "." + f10.getName() + " of type " + f10.getType().getName() + " in instance of " + obj.getClass().getName());
                            }
                            unsafe.putObject(obj, key, val);
                            break;
                            break;
                        default:
                            throw new InternalError();
                    }
                }
            }
        }
    }

    private static FieldReflector getReflector(ObjectStreamField[] fields, ObjectStreamClass localDesc) throws InvalidClassException {
        Class<?> cl;
        if (localDesc == null || fields.length <= 0) {
            cl = null;
        } else {
            cl = localDesc.cl;
        }
        processQueue(Caches.reflectorsQueue, Caches.reflectors);
        FieldReflectorKey key = new FieldReflectorKey(cl, fields, Caches.reflectorsQueue);
        Reference<?> ref = Caches.reflectors.get(key);
        Object entry = null;
        if (ref != null) {
            entry = ref.get();
        }
        EntryFuture future = null;
        if (entry == null) {
            EntryFuture newEntry = new EntryFuture();
            Reference<?> newRef = new SoftReference<>(newEntry);
            do {
                if (ref != null) {
                    Caches.reflectors.remove(key, ref);
                }
                ref = Caches.reflectors.putIfAbsent(key, newRef);
                if (ref != null) {
                    entry = ref.get();
                }
                if (ref == null) {
                    break;
                }
            } while (entry == null);
            if (entry == null) {
                future = newEntry;
            }
        }
        if (entry instanceof FieldReflector) {
            return (FieldReflector) entry;
        }
        if (entry instanceof EntryFuture) {
            entry = ((EntryFuture) entry).get();
        } else if (entry == null) {
            try {
                Object entry2 = new FieldReflector(matchFields(fields, localDesc));
                entry = entry2;
            } catch (Throwable th) {
                entry = th;
            }
            future.set(entry);
            Caches.reflectors.put(key, new SoftReference(entry));
        }
        if (entry instanceof FieldReflector) {
            return (FieldReflector) entry;
        }
        if (entry instanceof InvalidClassException) {
            throw ((InvalidClassException) entry);
        }
        if (entry instanceof RuntimeException) {
            throw ((RuntimeException) entry);
        }
        if (entry instanceof Error) {
            throw ((Error) entry);
        }
        throw new InternalError("unexpected entry: " + entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FieldReflectorKey extends WeakReference<Class<?>> {
        private final int hash;
        private final boolean nullClass;
        private final String sigs;

        FieldReflectorKey(Class<?> cl, ObjectStreamField[] fields, ReferenceQueue<Class<?>> queue) {
            super(cl, queue);
            this.nullClass = cl == null;
            StringBuilder sbuf = new StringBuilder();
            for (ObjectStreamField f10 : fields) {
                sbuf.append(f10.getName()).append(f10.getSignature());
            }
            String sb2 = sbuf.toString();
            this.sigs = sb2;
            this.hash = System.identityHashCode(cl) + sb2.hashCode();
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            Class<?> referent;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldReflectorKey)) {
                return false;
            }
            FieldReflectorKey other = (FieldReflectorKey) obj;
            if (!this.nullClass ? !((referent = get()) == null || referent != other.get()) : other.nullClass) {
                if (this.sigs.equals(other.sigs)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static ObjectStreamField[] matchFields(ObjectStreamField[] fields, ObjectStreamClass localDesc) throws InvalidClassException {
        ObjectStreamField[] localFields = localDesc != null ? localDesc.fields : NO_FIELDS;
        ObjectStreamField[] matches = new ObjectStreamField[fields.length];
        for (int i10 = 0; i10 < fields.length; i10++) {
            ObjectStreamField f10 = fields[i10];
            ObjectStreamField m10 = null;
            for (ObjectStreamField lf : localFields) {
                if (f10.getName().equals(lf.getName()) && f10.getSignature().equals(lf.getSignature())) {
                    if (lf.getField() != null) {
                        m10 = new ObjectStreamField(lf.getField(), lf.isUnshared(), false);
                    } else {
                        m10 = new ObjectStreamField(lf.getName(), lf.getSignature(), lf.isUnshared());
                    }
                }
            }
            if (m10 == null) {
                m10 = new ObjectStreamField(f10.getName(), f10.getSignature(), false);
            }
            m10.setOffset(f10.getOffset());
            matches[i10] = m10;
        }
        return matches;
    }

    private static long getConstructorId(Class<?> clazz) {
        int targetSdkVersion = VMRuntime.getRuntime().getTargetSdkVersion();
        if (targetSdkVersion > 0 && targetSdkVersion <= 24) {
            System.logE("WARNING: ObjectStreamClass.getConstructorId(Class<?>) is private API andwill be removed in a future Android release.");
            return 1189998819991197253L;
        }
        throw new UnsupportedOperationException("ObjectStreamClass.getConstructorId(Class<?>) is not supported on SDK " + targetSdkVersion);
    }

    private static Object newInstance(Class<?> clazz, long constructorId) {
        int targetSdkVersion = VMRuntime.getRuntime().getTargetSdkVersion();
        if (targetSdkVersion > 0 && targetSdkVersion <= 24) {
            System.logE("WARNING: ObjectStreamClass.newInstance(Class<?>, long) is private API andwill be removed in a future Android release.");
            return Unsafe.getUnsafe().allocateInstance(clazz);
        }
        throw new UnsupportedOperationException("ObjectStreamClass.newInstance(Class<?>, long) is not supported on SDK " + targetSdkVersion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void processQueue(ReferenceQueue<Class<?>> queue, ConcurrentMap<? extends WeakReference<Class<?>>, ?> map) {
        while (true) {
            Reference<? extends Class<?>> ref = queue.poll();
            if (ref != null) {
                map.remove(ref);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class WeakClassKey extends WeakReference<Class<?>> {
        private final int hash;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WeakClassKey(Class<?> cl, ReferenceQueue<Class<?>> refQueue) {
            super(cl, refQueue);
            this.hash = System.identityHashCode(cl);
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WeakClassKey)) {
                return false;
            }
            Object referent = get();
            return referent != null && referent == ((WeakClassKey) obj).get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DeserializationConstructorsCache extends ConcurrentHashMap<Key, MethodHandle> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MAX_SIZE = 10;
        private Key.Impl first;
        private Key.Impl last;

        DeserializationConstructorsCache() {
            super(2);
        }

        MethodHandle get(ObjectStreamField[] fields) {
            return get(new Key.Lookup(fields));
        }

        synchronized MethodHandle putIfAbsentAndGet(ObjectStreamField[] fields, MethodHandle mh) {
            Key.Impl key = new Key.Impl(fields);
            MethodHandle oldMh = putIfAbsent(key, mh);
            if (oldMh != null) {
                return oldMh;
            }
            Key.Impl impl = this.last;
            if (impl == null) {
                this.first = key;
                this.last = key;
            } else {
                impl.next = key;
                this.last = key;
            }
            if (size() > 10) {
                remove(this.first);
                Key.Impl impl2 = this.first.next;
                this.first = impl2;
                if (impl2 == null) {
                    this.last = null;
                }
            }
            return mh;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static abstract class Key {
            abstract String fieldName(int i10);

            abstract Class<?> fieldType(int i10);

            abstract int length();

            Key() {
            }

            public final int hashCode() {
                int n10 = length();
                int h10 = 0;
                for (int i10 = 0; i10 < n10; i10++) {
                    h10 = (h10 * 31) + fieldType(i10).hashCode();
                }
                for (int i11 = 0; i11 < n10; i11++) {
                    h10 = (h10 * 31) + fieldName(i11).hashCode();
                }
                return h10;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof Key)) {
                    return false;
                }
                Key other = (Key) obj;
                int n10 = length();
                if (n10 != other.length()) {
                    return false;
                }
                for (int i10 = 0; i10 < n10; i10++) {
                    if (fieldType(i10) != other.fieldType(i10)) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < n10; i11++) {
                    if (!fieldName(i11).equals(other.fieldName(i11))) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public static final class Lookup extends Key {
                final ObjectStreamField[] fields;

                Lookup(ObjectStreamField[] fields) {
                    this.fields = fields;
                }

                @Override // java.io.ObjectStreamClass.DeserializationConstructorsCache.Key
                int length() {
                    return this.fields.length;
                }

                @Override // java.io.ObjectStreamClass.DeserializationConstructorsCache.Key
                String fieldName(int i10) {
                    return this.fields[i10].getName();
                }

                @Override // java.io.ObjectStreamClass.DeserializationConstructorsCache.Key
                Class<?> fieldType(int i10) {
                    return this.fields[i10].getType();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public static final class Impl extends Key {
                final String[] fieldNames;
                final Class<?>[] fieldTypes;
                Impl next;

                Impl(ObjectStreamField[] fields) {
                    this.fieldNames = new String[fields.length];
                    this.fieldTypes = new Class[fields.length];
                    for (int i10 = 0; i10 < fields.length; i10++) {
                        this.fieldNames[i10] = fields[i10].getName();
                        this.fieldTypes[i10] = fields[i10].getType();
                    }
                }

                @Override // java.io.ObjectStreamClass.DeserializationConstructorsCache.Key
                int length() {
                    return this.fieldNames.length;
                }

                @Override // java.io.ObjectStreamClass.DeserializationConstructorsCache.Key
                String fieldName(int i10) {
                    return this.fieldNames[i10];
                }

                @Override // java.io.ObjectStreamClass.DeserializationConstructorsCache.Key
                Class<?> fieldType(int i10) {
                    return this.fieldTypes[i10];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class RecordSupport {
        private static final Map<Class<?>, MethodHandle> PRIM_VALUE_EXTRACTORS;

        RecordSupport() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static MethodHandle deserializationCtr(ObjectStreamClass desc) {
            MethodHandle mh = desc.deserializationCtr;
            if (mh != null) {
                return mh;
            }
            MethodHandle mh2 = desc.deserializationCtrs.get(desc.getFields(false));
            if (mh2 != null) {
                desc.deserializationCtr = mh2;
                return mh2;
            }
            try {
                final Class<?> cls = desc.forClass();
                Objects.requireNonNull(cls);
                PrivilegedExceptionAction<RecordComponent[]> pa2 = new PrivilegedExceptionAction() { // from class: java.io.ObjectStreamClass$RecordSupport$$ExternalSyntheticLambda0
                    @Override // java.security.PrivilegedExceptionAction
                    public final Object run() {
                        return Class.this.getRecordComponents();
                    }
                };
                RecordComponent[] recordComponents = (RecordComponent[]) AccessController.doPrivileged(pa2);
                MethodHandle mh3 = desc.getRecordConstructor();
                MethodHandle mh4 = mh3.asType(mh3.type().changeReturnType(Object.class));
                MethodHandle mh5 = MethodHandles.dropArguments(mh4, mh4.type().parameterCount(), (Class<?>[]) new Class[]{byte[].class, Object[].class});
                for (int i10 = recordComponents.length - 1; i10 >= 0; i10--) {
                    String name = recordComponents[i10].getName();
                    Class<?> type = recordComponents[i10].getType();
                    MethodHandle combiner = streamFieldExtractor(name, type, desc);
                    mh5 = MethodHandles.foldArguments(mh5, i10, combiner);
                }
                MethodHandle putIfAbsentAndGet = desc.deserializationCtrs.putIfAbsentAndGet(desc.getFields(false), mh5);
                desc.deserializationCtr = putIfAbsentAndGet;
                return putIfAbsentAndGet;
            } catch (PrivilegedActionException e2) {
                throw new InternalError(e2.getCause());
            }
        }

        private static int numberPrimValues(ObjectStreamClass desc) {
            ObjectStreamField[] fields = desc.getFields();
            int primValueCount = 0;
            for (int i10 = 0; i10 < fields.length && fields[i10].isPrimitive(); i10++) {
                primValueCount++;
            }
            return primValueCount;
        }

        private static MethodHandle streamFieldExtractor(String pName, Class<?> pType, ObjectStreamClass desc) {
            ObjectStreamField[] fields = desc.getFields(false);
            for (int i10 = 0; i10 < fields.length; i10++) {
                ObjectStreamField f10 = fields[i10];
                String fName = f10.getName();
                if (fName.equals(pName)) {
                    Class<?> fType = f10.getField().getType();
                    if (!pType.isAssignableFrom(fType)) {
                        throw new InternalError(fName + " unassignable, pType:" + ((Object) pType) + ", fType:" + ((Object) fType));
                    }
                    if (f10.isPrimitive()) {
                        MethodHandle mh = PRIM_VALUE_EXTRACTORS.get(fType);
                        if (mh == null) {
                            throw new InternalError("Unexpected type: " + ((Object) fType));
                        }
                        MethodHandle mh2 = MethodHandles.dropArguments(MethodHandles.insertArguments(mh, 1, Integer.valueOf(f10.getOffset())), 1, (Class<?>[]) new Class[]{Object[].class});
                        if (pType != fType) {
                            return mh2.asType(mh2.type().changeReturnType(pType));
                        }
                        return mh2;
                    }
                    MethodHandle mh3 = MethodHandles.dropArguments(MethodHandles.insertArguments(MethodHandles.arrayElementGetter(Object[].class), 1, Integer.valueOf(i10 - numberPrimValues(desc))), 0, (Class<?>[]) new Class[]{byte[].class});
                    if (pType != Object.class) {
                        return mh3.asType(mh3.type().changeReturnType(pType));
                    }
                    return mh3;
                }
            }
            return MethodHandles.empty(MethodType.methodType(pType, byte[].class, Object[].class));
        }

        static {
            MethodHandles.Lookup lkp = MethodHandles.lookup();
            try {
                PRIM_VALUE_EXTRACTORS = Map.of(Byte.TYPE, MethodHandles.arrayElementGetter(byte[].class), Short.TYPE, lkp.findStatic(Bits.class, "getShort", MethodType.methodType(Short.TYPE, byte[].class, Integer.TYPE)), Integer.TYPE, lkp.findStatic(Bits.class, "getInt", MethodType.methodType(Integer.TYPE, byte[].class, Integer.TYPE)), Long.TYPE, lkp.findStatic(Bits.class, "getLong", MethodType.methodType(Long.TYPE, byte[].class, Integer.TYPE)), Float.TYPE, lkp.findStatic(Bits.class, "getFloat", MethodType.methodType(Float.TYPE, byte[].class, Integer.TYPE)), Double.TYPE, lkp.findStatic(Bits.class, "getDouble", MethodType.methodType(Double.TYPE, byte[].class, Integer.TYPE)), Character.TYPE, lkp.findStatic(Bits.class, "getChar", MethodType.methodType(Character.TYPE, byte[].class, Integer.TYPE)), Boolean.TYPE, lkp.findStatic(Bits.class, "getBoolean", MethodType.methodType(Boolean.TYPE, byte[].class, Integer.TYPE)));
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                throw new InternalError("Can't lookup Bits.getXXX", e2);
            }
        }
    }
}
