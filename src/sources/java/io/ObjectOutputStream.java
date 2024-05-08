package java.io;

import java.io.ObjectStreamClass;
import java.lang.ref.ReferenceQueue;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import sun.reflect.misc.ReflectUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean extendedDebugInfo = false;
    private final BlockDataOutputStream bout;
    private SerialCallbackContext curContext;
    private PutFieldImpl curPut;
    private final DebugTraceInfoStack debugInfoStack;
    private int depth;
    private final boolean enableOverride;
    private boolean enableReplace;
    private final HandleTable handles;
    private byte[] primVals;
    private int protocol = 2;
    private final ReplaceTable subs;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class PutField {
        public abstract void put(String str, byte b4);

        public abstract void put(String str, char c4);

        public abstract void put(String str, double d10);

        public abstract void put(String str, float f10);

        public abstract void put(String str, int i10);

        public abstract void put(String str, long j10);

        public abstract void put(String str, Object obj);

        public abstract void put(String str, short s2);

        public abstract void put(String str, boolean z10);

        @Deprecated
        public abstract void write(ObjectOutput objectOutput) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void doublesToBytes(double[] dArr, int i10, byte[] bArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void floatsToBytes(float[] fArr, int i10, byte[] bArr, int i11, int i12);

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

    public ObjectOutputStream(OutputStream out) throws IOException {
        verifySubclass();
        BlockDataOutputStream blockDataOutputStream = new BlockDataOutputStream(out);
        this.bout = blockDataOutputStream;
        this.handles = new HandleTable(10, 3.0f);
        this.subs = new ReplaceTable(10, 3.0f);
        this.enableOverride = false;
        writeStreamHeader();
        blockDataOutputStream.setBlockDataMode(true);
        this.debugInfoStack = null;
    }

    protected ObjectOutputStream() throws IOException, SecurityException {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
        this.bout = null;
        this.handles = null;
        this.subs = null;
        this.enableOverride = true;
        this.debugInfoStack = null;
    }

    public void useProtocolVersion(int version) throws IOException {
        if (this.handles.size() != 0) {
            throw new IllegalStateException("stream non-empty");
        }
        switch (version) {
            case 1:
            case 2:
                this.protocol = version;
                return;
            default:
                throw new IllegalArgumentException("unknown version: " + version);
        }
    }

    @Override // java.io.ObjectOutput
    public final void writeObject(Object obj) throws IOException {
        if (this.enableOverride) {
            writeObjectOverride(obj);
            return;
        }
        try {
            writeObject0(obj, false);
        } catch (IOException ex) {
            if (this.depth == 0) {
                try {
                    writeFatalException(ex);
                } catch (IOException e2) {
                }
            }
            throw ex;
        }
    }

    protected void writeObjectOverride(Object obj) throws IOException {
        if (!this.enableOverride) {
            throw new IOException();
        }
    }

    public void writeUnshared(Object obj) throws IOException {
        try {
            writeObject0(obj, true);
        } catch (IOException ex) {
            if (this.depth == 0) {
                writeFatalException(ex);
            }
            throw ex;
        }
    }

    public void defaultWriteObject() throws IOException {
        SerialCallbackContext ctx = this.curContext;
        if (ctx == null) {
            throw new NotActiveException("not in call to writeObject");
        }
        Object curObj = ctx.getObj();
        ObjectStreamClass curDesc = ctx.getDesc();
        this.bout.setBlockDataMode(false);
        defaultWriteFields(curObj, curDesc);
        this.bout.setBlockDataMode(true);
    }

    public PutField putFields() throws IOException {
        if (this.curPut == null) {
            SerialCallbackContext ctx = this.curContext;
            if (ctx == null) {
                throw new NotActiveException("not in call to writeObject");
            }
            ctx.getObj();
            ObjectStreamClass curDesc = ctx.getDesc();
            this.curPut = new PutFieldImpl(curDesc);
        }
        return this.curPut;
    }

    public void writeFields() throws IOException {
        if (this.curPut == null) {
            throw new NotActiveException("no current PutField object");
        }
        this.bout.setBlockDataMode(false);
        this.curPut.writeFields();
        this.bout.setBlockDataMode(true);
    }

    public void reset() throws IOException {
        if (this.depth != 0) {
            throw new IOException("stream active");
        }
        this.bout.setBlockDataMode(false);
        this.bout.writeByte(121);
        clear();
        this.bout.setBlockDataMode(true);
    }

    protected void annotateClass(Class<?> cl) throws IOException {
    }

    protected void annotateProxyClass(Class<?> cl) throws IOException {
    }

    protected Object replaceObject(Object obj) throws IOException {
        return obj;
    }

    protected boolean enableReplaceObject(boolean enable) throws SecurityException {
        SecurityManager sm;
        if (enable == this.enableReplace) {
            return enable;
        }
        if (enable && (sm = System.getSecurityManager()) != null) {
            sm.checkPermission(SUBSTITUTION_PERMISSION);
        }
        this.enableReplace = enable;
        return !enable;
    }

    protected void writeStreamHeader() throws IOException {
        this.bout.writeShort(-21267);
        this.bout.writeShort(5);
    }

    protected void writeClassDescriptor(ObjectStreamClass desc) throws IOException {
        desc.writeNonProxy(this);
    }

    @Override // java.io.OutputStream
    public void write(int val) throws IOException {
        this.bout.write(val);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf) throws IOException {
        this.bout.write(buf, 0, buf.length, false);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        if (buf == null) {
            throw new NullPointerException();
        }
        int endoff = off + len;
        if (off < 0 || len < 0 || endoff > buf.length || endoff < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.bout.write(buf, off, len, false);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.bout.flush();
    }

    protected void drain() throws IOException {
        this.bout.drain();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.bout.close();
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean val) throws IOException {
        this.bout.writeBoolean(val);
    }

    @Override // java.io.DataOutput
    public void writeByte(int val) throws IOException {
        this.bout.writeByte(val);
    }

    @Override // java.io.DataOutput
    public void writeShort(int val) throws IOException {
        this.bout.writeShort(val);
    }

    @Override // java.io.DataOutput
    public void writeChar(int val) throws IOException {
        this.bout.writeChar(val);
    }

    @Override // java.io.DataOutput
    public void writeInt(int val) throws IOException {
        this.bout.writeInt(val);
    }

    @Override // java.io.DataOutput
    public void writeLong(long val) throws IOException {
        this.bout.writeLong(val);
    }

    @Override // java.io.DataOutput
    public void writeFloat(float val) throws IOException {
        this.bout.writeFloat(val);
    }

    @Override // java.io.DataOutput
    public void writeDouble(double val) throws IOException {
        this.bout.writeDouble(val);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        this.bout.writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        this.bout.writeChars(str);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        this.bout.writeUTF(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getProtocolVersion() {
        return this.protocol;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTypeString(String str) throws IOException {
        if (str == null) {
            writeNull();
            return;
        }
        int handle = this.handles.lookup(str);
        if (handle != -1) {
            writeHandle(handle);
        } else {
            writeString(str, false);
        }
    }

    private void verifySubclass() {
        SecurityManager sm;
        Class<?> cl = getClass();
        if (cl == ObjectOutputStream.class || (sm = System.getSecurityManager()) == null) {
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
        Boolean result = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: java.io.ObjectOutputStream.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                for (Class<?> cl = Class.this; cl != ObjectOutputStream.class; cl = cl.getSuperclass()) {
                    try {
                        cl.getDeclaredMethod("writeUnshared", Object.class);
                        return Boolean.FALSE;
                    } catch (NoSuchMethodException e2) {
                        try {
                            cl.getDeclaredMethod("putFields", null);
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
        this.subs.clear();
        this.handles.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeObject0(Object obj, boolean unshared) throws IOException {
        int h10;
        Class<?> repCl;
        int h11;
        boolean oldMode = this.bout.setBlockDataMode(false);
        this.depth++;
        try {
            Object lookup = this.subs.lookup(obj);
            Object obj2 = lookup;
            if (lookup == null) {
                writeNull();
                return;
            }
            if (!unshared && (h11 = this.handles.lookup(obj2)) != -1) {
                writeHandle(h11);
                return;
            }
            Class<?> cl = obj2.getClass();
            ObjectStreamClass desc = ObjectStreamClass.lookup(cl, true);
            if (desc.hasWriteReplaceMethod()) {
                Object invokeWriteReplace = desc.invokeWriteReplace(obj2);
                obj2 = invokeWriteReplace;
                if (invokeWriteReplace != null && (repCl = obj2.getClass()) != cl) {
                    cl = repCl;
                    desc = ObjectStreamClass.lookup(cl, true);
                }
            }
            if (this.enableReplace) {
                Object rep = replaceObject(obj2);
                if (rep != obj2 && rep != null) {
                    cl = rep.getClass();
                    desc = ObjectStreamClass.lookup(cl, true);
                }
                obj2 = rep;
            }
            if (obj2 != obj2) {
                this.subs.assign(obj2, obj2);
                if (obj2 == null) {
                    writeNull();
                    return;
                } else if (!unshared && (h10 = this.handles.lookup(obj2)) != -1) {
                    writeHandle(h10);
                    return;
                }
            }
            if (obj2 instanceof Class) {
                writeClass((Class) obj2, unshared);
            } else if (obj2 instanceof ObjectStreamClass) {
                writeClassDesc((ObjectStreamClass) obj2, unshared);
            } else if (obj2 instanceof String) {
                writeString((String) obj2, unshared);
            } else if (cl.isArray()) {
                writeArray(obj2, desc, unshared);
            } else if (obj2 instanceof Enum) {
                writeEnum((Enum) obj2, desc, unshared);
            } else {
                if (!(obj2 instanceof Serializable)) {
                    throw new NotSerializableException(cl.getName());
                }
                writeOrdinaryObject(obj2, desc, unshared);
            }
        } finally {
            this.depth--;
            this.bout.setBlockDataMode(oldMode);
        }
    }

    private void writeNull() throws IOException {
        this.bout.writeByte(112);
    }

    private void writeHandle(int handle) throws IOException {
        this.bout.writeByte(113);
        this.bout.writeInt(ObjectStreamConstants.baseWireHandle + handle);
    }

    private void writeClass(Class<?> cl, boolean unshared) throws IOException {
        this.bout.writeByte(118);
        writeClassDesc(ObjectStreamClass.lookup(cl, true), false);
        this.handles.assign(unshared ? null : cl);
    }

    private void writeClassDesc(ObjectStreamClass desc, boolean unshared) throws IOException {
        int handle;
        if (desc == null) {
            writeNull();
            return;
        }
        if (!unshared && (handle = this.handles.lookup(desc)) != -1) {
            writeHandle(handle);
        } else if (desc.isProxy()) {
            writeProxyDesc(desc, unshared);
        } else {
            writeNonProxyDesc(desc, unshared);
        }
    }

    private boolean isCustomSubclass() {
        return getClass().getClassLoader() != ObjectOutputStream.class.getClassLoader();
    }

    private void writeProxyDesc(ObjectStreamClass desc, boolean unshared) throws IOException {
        this.bout.writeByte(125);
        this.handles.assign(unshared ? null : desc);
        Class<?> cl = desc.forClass();
        Class<?>[] ifaces = cl.getInterfaces();
        this.bout.writeInt(ifaces.length);
        for (Class<?> cls : ifaces) {
            this.bout.writeUTF(cls.getName());
        }
        this.bout.setBlockDataMode(true);
        if (cl != null && isCustomSubclass()) {
            ReflectUtil.checkPackageAccess(cl);
        }
        annotateProxyClass(cl);
        this.bout.setBlockDataMode(false);
        this.bout.writeByte(120);
        writeClassDesc(desc.getSuperDesc(), false);
    }

    private void writeNonProxyDesc(ObjectStreamClass desc, boolean unshared) throws IOException {
        this.bout.writeByte(114);
        this.handles.assign(unshared ? null : desc);
        if (this.protocol == 1) {
            desc.writeNonProxy(this);
        } else {
            writeClassDescriptor(desc);
        }
        Class<?> cl = desc.forClass();
        this.bout.setBlockDataMode(true);
        if (cl != null && isCustomSubclass()) {
            ReflectUtil.checkPackageAccess(cl);
        }
        annotateClass(cl);
        this.bout.setBlockDataMode(false);
        this.bout.writeByte(120);
        writeClassDesc(desc.getSuperDesc(), false);
    }

    private void writeString(String str, boolean unshared) throws IOException {
        this.handles.assign(unshared ? null : str);
        long utflen = this.bout.getUTFLength(str);
        if (utflen <= 65535) {
            this.bout.writeByte(116);
            this.bout.writeUTF(str, utflen);
        } else {
            this.bout.writeByte(124);
            this.bout.writeLongUTF(str, utflen);
        }
    }

    private void writeArray(Object array, ObjectStreamClass desc, boolean unshared) throws IOException {
        this.bout.writeByte(117);
        writeClassDesc(desc, false);
        this.handles.assign(unshared ? null : array);
        Class<?> ccl = desc.forClass().getComponentType();
        if (ccl.isPrimitive()) {
            if (ccl == Integer.TYPE) {
                int[] ia2 = (int[]) array;
                this.bout.writeInt(ia2.length);
                this.bout.writeInts(ia2, 0, ia2.length);
                return;
            }
            if (ccl == Byte.TYPE) {
                byte[] ba2 = (byte[]) array;
                this.bout.writeInt(ba2.length);
                this.bout.write(ba2, 0, ba2.length, true);
                return;
            }
            if (ccl == Long.TYPE) {
                long[] ja2 = (long[]) array;
                this.bout.writeInt(ja2.length);
                this.bout.writeLongs(ja2, 0, ja2.length);
                return;
            }
            if (ccl == Float.TYPE) {
                float[] fa2 = (float[]) array;
                this.bout.writeInt(fa2.length);
                this.bout.writeFloats(fa2, 0, fa2.length);
                return;
            }
            if (ccl == Double.TYPE) {
                double[] da2 = (double[]) array;
                this.bout.writeInt(da2.length);
                this.bout.writeDoubles(da2, 0, da2.length);
                return;
            }
            if (ccl == Short.TYPE) {
                short[] sa2 = (short[]) array;
                this.bout.writeInt(sa2.length);
                this.bout.writeShorts(sa2, 0, sa2.length);
                return;
            } else if (ccl == Character.TYPE) {
                char[] ca2 = (char[]) array;
                this.bout.writeInt(ca2.length);
                this.bout.writeChars(ca2, 0, ca2.length);
                return;
            } else {
                if (ccl == Boolean.TYPE) {
                    boolean[] za2 = (boolean[]) array;
                    this.bout.writeInt(za2.length);
                    this.bout.writeBooleans(za2, 0, za2.length);
                    return;
                }
                throw new InternalError();
            }
        }
        Object[] objs = (Object[]) array;
        int len = objs.length;
        this.bout.writeInt(len);
        for (Object obj : objs) {
            try {
                writeObject0(obj, false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeEnum(Enum<?> en, ObjectStreamClass desc, boolean unshared) throws IOException {
        this.bout.writeByte(126);
        ObjectStreamClass sdesc = desc.getSuperDesc();
        writeClassDesc(sdesc.forClass() == Enum.class ? desc : sdesc, false);
        this.handles.assign(unshared ? null : en);
        writeString(en.name(), false);
    }

    private void writeOrdinaryObject(Object obj, ObjectStreamClass desc, boolean unshared) throws IOException {
        desc.checkSerialize();
        this.bout.writeByte(115);
        writeClassDesc(desc, false);
        this.handles.assign(unshared ? null : obj);
        if (desc.isRecord()) {
            writeRecordData(obj, desc);
        } else if (desc.isExternalizable() && !desc.isProxy()) {
            writeExternalData((Externalizable) obj);
        } else {
            writeSerialData(obj, desc);
        }
    }

    private void writeExternalData(Externalizable obj) throws IOException {
        PutFieldImpl oldPut = this.curPut;
        this.curPut = null;
        SerialCallbackContext oldContext = this.curContext;
        try {
            this.curContext = null;
            if (this.protocol == 1) {
                obj.writeExternal(this);
            } else {
                this.bout.setBlockDataMode(true);
                obj.writeExternal(this);
                this.bout.setBlockDataMode(false);
                this.bout.writeByte(120);
            }
            this.curContext = oldContext;
            this.curPut = oldPut;
        } catch (Throwable th) {
            this.curContext = oldContext;
            throw th;
        }
    }

    private void writeRecordData(Object obj, ObjectStreamClass desc) throws IOException {
        ObjectStreamClass.ClassDataSlot[] slots = desc.getClassDataLayout();
        if (slots.length != 1) {
            throw new InvalidClassException("expected a single record slot length, but found: " + slots.length);
        }
        defaultWriteFields(obj, desc);
    }

    private void writeSerialData(Object obj, ObjectStreamClass desc) throws IOException {
        ObjectStreamClass.ClassDataSlot[] slots = desc.getClassDataLayout();
        for (ObjectStreamClass.ClassDataSlot classDataSlot : slots) {
            ObjectStreamClass slotDesc = classDataSlot.desc;
            if (slotDesc.hasWriteObjectMethod()) {
                PutFieldImpl oldPut = this.curPut;
                this.curPut = null;
                SerialCallbackContext oldContext = this.curContext;
                try {
                    this.curContext = new SerialCallbackContext(obj, slotDesc);
                    this.bout.setBlockDataMode(true);
                    slotDesc.invokeWriteObject(obj, this);
                    this.bout.setBlockDataMode(false);
                    this.bout.writeByte(120);
                    this.curContext.setUsed();
                    this.curContext = oldContext;
                    this.curPut = oldPut;
                } catch (Throwable th) {
                    this.curContext.setUsed();
                    this.curContext = oldContext;
                    throw th;
                }
            } else {
                defaultWriteFields(obj, slotDesc);
            }
        }
    }

    private void defaultWriteFields(Object obj, ObjectStreamClass desc) throws IOException {
        Class<?> cl = desc.forClass();
        if (cl != null && obj != null && !cl.isInstance(obj)) {
            throw new ClassCastException();
        }
        desc.checkDefaultSerialize();
        int primDataSize = desc.getPrimDataSize();
        byte[] bArr = this.primVals;
        if (bArr == null || bArr.length < primDataSize) {
            this.primVals = new byte[primDataSize];
        }
        desc.getPrimFieldValues(obj, this.primVals);
        this.bout.write(this.primVals, 0, primDataSize, false);
        ObjectStreamField[] fields = desc.getFields(false);
        Object[] objVals = new Object[desc.getNumObjFields()];
        int numPrimFields = fields.length - objVals.length;
        desc.getObjFieldValues(obj, objVals);
        for (int i10 = 0; i10 < objVals.length; i10++) {
            writeObject0(objVals[i10], fields[numPrimFields + i10].isUnshared());
        }
    }

    private void writeFatalException(IOException ex) throws IOException {
        clear();
        boolean oldMode = this.bout.setBlockDataMode(false);
        try {
            this.bout.writeByte(123);
            writeObject0(ex, false);
            clear();
        } finally {
            this.bout.setBlockDataMode(oldMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class PutFieldImpl extends PutField {
        private final ObjectStreamClass desc;
        private final Object[] objVals;
        private final byte[] primVals;

        PutFieldImpl(ObjectStreamClass desc) {
            this.desc = desc;
            this.primVals = new byte[desc.getPrimDataSize()];
            this.objVals = new Object[desc.getNumObjFields()];
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, boolean val) {
            Bits.putBoolean(this.primVals, getFieldOffset(name, Boolean.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, byte val) {
            this.primVals[getFieldOffset(name, Byte.TYPE)] = val;
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, char val) {
            Bits.putChar(this.primVals, getFieldOffset(name, Character.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, short val) {
            Bits.putShort(this.primVals, getFieldOffset(name, Short.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, int val) {
            Bits.putInt(this.primVals, getFieldOffset(name, Integer.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, float val) {
            Bits.putFloat(this.primVals, getFieldOffset(name, Float.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, long val) {
            Bits.putLong(this.primVals, getFieldOffset(name, Long.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, double val) {
            Bits.putDouble(this.primVals, getFieldOffset(name, Double.TYPE), val);
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void put(String name, Object val) {
            this.objVals[getFieldOffset(name, Object.class)] = val;
        }

        @Override // java.io.ObjectOutputStream.PutField
        public void write(ObjectOutput out) throws IOException {
            if (ObjectOutputStream.this != out) {
                throw new IllegalArgumentException("wrong stream");
            }
            byte[] bArr = this.primVals;
            out.write(bArr, 0, bArr.length);
            ObjectStreamField[] fields = this.desc.getFields(false);
            int numPrimFields = fields.length - this.objVals.length;
            for (int i10 = 0; i10 < this.objVals.length; i10++) {
                if (fields[numPrimFields + i10].isUnshared()) {
                    throw new IOException("cannot write unshared object");
                }
                out.writeObject(this.objVals[i10]);
            }
        }

        void writeFields() throws IOException {
            BlockDataOutputStream blockDataOutputStream = ObjectOutputStream.this.bout;
            byte[] bArr = this.primVals;
            blockDataOutputStream.write(bArr, 0, bArr.length, false);
            ObjectStreamField[] fields = this.desc.getFields(false);
            int numPrimFields = fields.length - this.objVals.length;
            int i10 = 0;
            while (true) {
                Object[] objArr = this.objVals;
                if (i10 < objArr.length) {
                    ObjectOutputStream.this.writeObject0(objArr[i10], fields[numPrimFields + i10].isUnshared());
                    i10++;
                } else {
                    return;
                }
            }
        }

        private int getFieldOffset(String name, Class<?> type) {
            ObjectStreamField field = this.desc.getField(name, type);
            if (field == null) {
                throw new IllegalArgumentException("no such field " + name + " with type " + ((Object) type));
            }
            return field.getOffset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class BlockDataOutputStream extends OutputStream implements DataOutput {
        private static final int CHAR_BUF_SIZE = 256;
        private static final int MAX_BLOCK_SIZE = 1024;
        private static final int MAX_HEADER_SIZE = 5;
        private final OutputStream out;
        private boolean warnOnceWhenWriting;
        private final byte[] buf = new byte[1024];
        private final byte[] hbuf = new byte[5];
        private final char[] cbuf = new char[256];
        private boolean blkmode = false;
        private int pos = 0;
        private final DataOutputStream dout = new DataOutputStream(this);

        BlockDataOutputStream(OutputStream out) {
            this.out = out;
        }

        boolean setBlockDataMode(boolean mode) throws IOException {
            boolean z10 = this.blkmode;
            if (z10 == mode) {
                return z10;
            }
            drain();
            this.blkmode = mode;
            return !mode;
        }

        boolean getBlockDataMode() {
            return this.blkmode;
        }

        private void warnIfClosed() {
            if (this.warnOnceWhenWriting) {
                System.logW("The app is relying on undefined behavior. Attempting to write to a closed ObjectOutputStream could produce corrupt output in a future release of Android.", new IOException("Stream Closed"));
                this.warnOnceWhenWriting = false;
            }
        }

        @Override // java.io.OutputStream
        public void write(int b4) throws IOException {
            if (this.pos >= 1024) {
                drain();
            }
            byte[] bArr = this.buf;
            int i10 = this.pos;
            this.pos = i10 + 1;
            bArr[i10] = (byte) b4;
        }

        @Override // java.io.OutputStream
        public void write(byte[] b4) throws IOException {
            write(b4, 0, b4.length, false);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b4, int off, int len) throws IOException {
            write(b4, off, len, false);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            drain();
            this.out.flush();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flush();
            this.out.close();
            this.warnOnceWhenWriting = true;
        }

        void write(byte[] b4, int off, int len, boolean copy) throws IOException {
            if (!copy && !this.blkmode) {
                drain();
                this.out.write(b4, off, len);
                warnIfClosed();
                return;
            }
            while (len > 0) {
                if (this.pos >= 1024) {
                    drain();
                }
                if (len >= 1024 && !copy && this.pos == 0) {
                    writeBlockHeader(1024);
                    this.out.write(b4, off, 1024);
                    off += 1024;
                    len -= 1024;
                } else {
                    int wlen = Math.min(len, 1024 - this.pos);
                    System.arraycopy((Object) b4, off, (Object) this.buf, this.pos, wlen);
                    this.pos += wlen;
                    off += wlen;
                    len -= wlen;
                }
            }
            warnIfClosed();
        }

        void drain() throws IOException {
            int i10 = this.pos;
            if (i10 == 0) {
                return;
            }
            if (this.blkmode) {
                writeBlockHeader(i10);
            }
            this.out.write(this.buf, 0, this.pos);
            this.pos = 0;
            warnIfClosed();
        }

        private void writeBlockHeader(int len) throws IOException {
            if (len <= 255) {
                byte[] bArr = this.hbuf;
                bArr[0] = ObjectStreamConstants.TC_BLOCKDATA;
                bArr[1] = (byte) len;
                this.out.write(bArr, 0, 2);
            } else {
                byte[] bArr2 = this.hbuf;
                bArr2[0] = ObjectStreamConstants.TC_BLOCKDATALONG;
                Bits.putInt(bArr2, 1, len);
                this.out.write(this.hbuf, 0, 5);
            }
            warnIfClosed();
        }

        @Override // java.io.DataOutput
        public void writeBoolean(boolean v2) throws IOException {
            if (this.pos >= 1024) {
                drain();
            }
            byte[] bArr = this.buf;
            int i10 = this.pos;
            this.pos = i10 + 1;
            Bits.putBoolean(bArr, i10, v2);
        }

        @Override // java.io.DataOutput
        public void writeByte(int v2) throws IOException {
            if (this.pos >= 1024) {
                drain();
            }
            byte[] bArr = this.buf;
            int i10 = this.pos;
            this.pos = i10 + 1;
            bArr[i10] = (byte) v2;
        }

        @Override // java.io.DataOutput
        public void writeChar(int v2) throws IOException {
            int i10 = this.pos;
            if (i10 + 2 <= 1024) {
                Bits.putChar(this.buf, i10, (char) v2);
                this.pos += 2;
            } else {
                this.dout.writeChar(v2);
            }
        }

        @Override // java.io.DataOutput
        public void writeShort(int v2) throws IOException {
            int i10 = this.pos;
            if (i10 + 2 <= 1024) {
                Bits.putShort(this.buf, i10, (short) v2);
                this.pos += 2;
            } else {
                this.dout.writeShort(v2);
            }
        }

        @Override // java.io.DataOutput
        public void writeInt(int v2) throws IOException {
            int i10 = this.pos;
            if (i10 + 4 <= 1024) {
                Bits.putInt(this.buf, i10, v2);
                this.pos += 4;
            } else {
                this.dout.writeInt(v2);
            }
        }

        @Override // java.io.DataOutput
        public void writeFloat(float v2) throws IOException {
            int i10 = this.pos;
            if (i10 + 4 <= 1024) {
                Bits.putFloat(this.buf, i10, v2);
                this.pos += 4;
            } else {
                this.dout.writeFloat(v2);
            }
        }

        @Override // java.io.DataOutput
        public void writeLong(long v2) throws IOException {
            int i10 = this.pos;
            if (i10 + 8 <= 1024) {
                Bits.putLong(this.buf, i10, v2);
                this.pos += 8;
            } else {
                this.dout.writeLong(v2);
            }
        }

        @Override // java.io.DataOutput
        public void writeDouble(double v2) throws IOException {
            int i10 = this.pos;
            if (i10 + 8 <= 1024) {
                Bits.putDouble(this.buf, i10, v2);
                this.pos += 8;
            } else {
                this.dout.writeDouble(v2);
            }
        }

        @Override // java.io.DataOutput
        public void writeBytes(String s2) throws IOException {
            int endoff = s2.length();
            int cpos = 0;
            int csize = 0;
            int off = 0;
            while (off < endoff) {
                if (cpos >= csize) {
                    cpos = 0;
                    csize = Math.min(endoff - off, 256);
                    s2.getChars(off, off + csize, this.cbuf, 0);
                }
                if (this.pos >= 1024) {
                    drain();
                }
                int n10 = Math.min(csize - cpos, 1024 - this.pos);
                int stop = this.pos + n10;
                while (true) {
                    int i10 = this.pos;
                    if (i10 < stop) {
                        byte[] bArr = this.buf;
                        this.pos = i10 + 1;
                        bArr[i10] = (byte) this.cbuf[cpos];
                        cpos++;
                    }
                }
                off += n10;
            }
        }

        @Override // java.io.DataOutput
        public void writeChars(String s2) throws IOException {
            int endoff = s2.length();
            int off = 0;
            while (off < endoff) {
                int csize = Math.min(endoff - off, 256);
                s2.getChars(off, off + csize, this.cbuf, 0);
                writeChars(this.cbuf, 0, csize);
                off += csize;
            }
        }

        @Override // java.io.DataOutput
        public void writeUTF(String s2) throws IOException {
            writeUTF(s2, getUTFLength(s2));
        }

        void writeBooleans(boolean[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                if (this.pos >= 1024) {
                    drain();
                }
                int stop = Math.min(endoff, (1024 - this.pos) + off);
                while (off < stop) {
                    byte[] bArr = this.buf;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    Bits.putBoolean(bArr, i10, v2[off]);
                    off++;
                }
            }
        }

        void writeChars(char[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                int i10 = this.pos;
                if (i10 <= 1022) {
                    int avail = (1024 - i10) >> 1;
                    int stop = Math.min(endoff, off + avail);
                    while (off < stop) {
                        Bits.putChar(this.buf, this.pos, v2[off]);
                        this.pos += 2;
                        off++;
                    }
                } else {
                    this.dout.writeChar(v2[off]);
                    off++;
                }
            }
        }

        void writeShorts(short[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                int i10 = this.pos;
                if (i10 <= 1022) {
                    int avail = (1024 - i10) >> 1;
                    int stop = Math.min(endoff, off + avail);
                    while (off < stop) {
                        Bits.putShort(this.buf, this.pos, v2[off]);
                        this.pos += 2;
                        off++;
                    }
                } else {
                    this.dout.writeShort(v2[off]);
                    off++;
                }
            }
        }

        void writeInts(int[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                int i10 = this.pos;
                if (i10 <= 1020) {
                    int avail = (1024 - i10) >> 2;
                    int stop = Math.min(endoff, off + avail);
                    while (off < stop) {
                        Bits.putInt(this.buf, this.pos, v2[off]);
                        this.pos += 4;
                        off++;
                    }
                } else {
                    this.dout.writeInt(v2[off]);
                    off++;
                }
            }
        }

        void writeFloats(float[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                int i10 = this.pos;
                if (i10 <= 1020) {
                    int avail = (1024 - i10) >> 2;
                    int chunklen = Math.min(endoff - off, avail);
                    ObjectOutputStream.floatsToBytes(v2, off, this.buf, this.pos, chunklen);
                    off += chunklen;
                    this.pos += chunklen << 2;
                } else {
                    this.dout.writeFloat(v2[off]);
                    off++;
                }
            }
        }

        void writeLongs(long[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                int i10 = this.pos;
                if (i10 <= 1016) {
                    int avail = (1024 - i10) >> 3;
                    int stop = Math.min(endoff, off + avail);
                    while (off < stop) {
                        Bits.putLong(this.buf, this.pos, v2[off]);
                        this.pos += 8;
                        off++;
                    }
                } else {
                    this.dout.writeLong(v2[off]);
                    off++;
                }
            }
        }

        void writeDoubles(double[] v2, int off, int len) throws IOException {
            int endoff = off + len;
            while (off < endoff) {
                int i10 = this.pos;
                if (i10 <= 1016) {
                    int avail = (1024 - i10) >> 3;
                    int chunklen = Math.min(endoff - off, avail);
                    ObjectOutputStream.doublesToBytes(v2, off, this.buf, this.pos, chunklen);
                    off += chunklen;
                    this.pos += chunklen << 3;
                } else {
                    this.dout.writeDouble(v2[off]);
                    off++;
                }
            }
        }

        long getUTFLength(String s2) {
            long j10;
            int len = s2.length();
            long utflen = 0;
            int off = 0;
            while (off < len) {
                int csize = Math.min(len - off, 256);
                s2.getChars(off, off + csize, this.cbuf, 0);
                for (int cpos = 0; cpos < csize; cpos++) {
                    char c4 = this.cbuf[cpos];
                    if (c4 >= 1 && c4 <= 127) {
                        j10 = 1;
                    } else if (c4 > 2047) {
                        j10 = 3;
                    } else {
                        j10 = 2;
                    }
                    utflen += j10;
                }
                off += csize;
            }
            return utflen;
        }

        void writeUTF(String s2, long utflen) throws IOException {
            if (utflen > 65535) {
                throw new UTFDataFormatException();
            }
            writeShort((int) utflen);
            if (utflen == s2.length()) {
                writeBytes(s2);
            } else {
                writeUTFBody(s2);
            }
        }

        void writeLongUTF(String s2) throws IOException {
            writeLongUTF(s2, getUTFLength(s2));
        }

        void writeLongUTF(String s2, long utflen) throws IOException {
            writeLong(utflen);
            if (utflen == s2.length()) {
                writeBytes(s2);
            } else {
                writeUTFBody(s2);
            }
        }

        private void writeUTFBody(String s2) throws IOException {
            int len = s2.length();
            int off = 0;
            while (off < len) {
                int csize = Math.min(len - off, 256);
                s2.getChars(off, off + csize, this.cbuf, 0);
                for (int cpos = 0; cpos < csize; cpos++) {
                    char c4 = this.cbuf[cpos];
                    int i10 = this.pos;
                    if (i10 <= 1021) {
                        if (c4 <= 127 && c4 != 0) {
                            byte[] bArr = this.buf;
                            this.pos = i10 + 1;
                            bArr[i10] = (byte) c4;
                        } else if (c4 > 2047) {
                            byte[] bArr2 = this.buf;
                            bArr2[i10 + 2] = (byte) (((c4 >> 0) & 63) | 128);
                            bArr2[i10 + 1] = (byte) (((c4 >> 6) & 63) | 128);
                            bArr2[i10 + 0] = (byte) (((c4 >> '\f') & 15) | 224);
                            this.pos = i10 + 3;
                        } else {
                            byte[] bArr3 = this.buf;
                            bArr3[i10 + 1] = (byte) (((c4 >> 0) & 63) | 128);
                            bArr3[i10 + 0] = (byte) (((c4 >> 6) & 31) | 192);
                            this.pos = i10 + 2;
                        }
                    } else if (c4 <= 127 && c4 != 0) {
                        write(c4);
                    } else if (c4 > 2047) {
                        write(((c4 >> '\f') & 15) | 224);
                        write(((c4 >> 6) & 63) | 128);
                        write(((c4 >> 0) & 63) | 128);
                    } else {
                        write(((c4 >> 6) & 31) | 192);
                        write(((c4 >> 0) & 63) | 128);
                    }
                }
                off += csize;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HandleTable {
        private final float loadFactor;
        private int[] next;
        private Object[] objs;
        private int size;
        private int[] spine;
        private int threshold;

        HandleTable(int initialCapacity, float loadFactor) {
            this.loadFactor = loadFactor;
            this.spine = new int[initialCapacity];
            this.next = new int[initialCapacity];
            this.objs = new Object[initialCapacity];
            this.threshold = (int) (initialCapacity * loadFactor);
            clear();
        }

        int assign(Object obj) {
            if (this.size >= this.next.length) {
                growEntries();
            }
            if (this.size >= this.threshold) {
                growSpine();
            }
            insert(obj, this.size);
            int i10 = this.size;
            this.size = i10 + 1;
            return i10;
        }

        int lookup(Object obj) {
            if (this.size == 0) {
                return -1;
            }
            int hash = hash(obj);
            int[] iArr = this.spine;
            int index = hash % iArr.length;
            int i10 = iArr[index];
            while (i10 >= 0) {
                if (this.objs[i10] != obj) {
                    i10 = this.next[i10];
                } else {
                    return i10;
                }
            }
            return -1;
        }

        void clear() {
            Arrays.fill(this.spine, -1);
            Arrays.fill(this.objs, 0, this.size, (Object) null);
            this.size = 0;
        }

        int size() {
            return this.size;
        }

        private void insert(Object obj, int handle) {
            int hash = hash(obj);
            int[] iArr = this.spine;
            int index = hash % iArr.length;
            this.objs[handle] = obj;
            this.next[handle] = iArr[index];
            iArr[index] = handle;
        }

        private void growSpine() {
            int[] iArr = new int[(this.spine.length << 1) + 1];
            this.spine = iArr;
            this.threshold = (int) (iArr.length * this.loadFactor);
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < this.size; i10++) {
                insert(this.objs[i10], i10);
            }
        }

        private void growEntries() {
            int[] iArr = this.next;
            int newLength = (iArr.length << 1) + 1;
            int[] newNext = new int[newLength];
            System.arraycopy((Object) iArr, 0, (Object) newNext, 0, this.size);
            this.next = newNext;
            Object[] newObjs = new Object[newLength];
            System.arraycopy(this.objs, 0, newObjs, 0, this.size);
            this.objs = newObjs;
        }

        private int hash(Object obj) {
            return System.identityHashCode(obj) & Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReplaceTable {
        private final HandleTable htab;
        private Object[] reps;

        ReplaceTable(int initialCapacity, float loadFactor) {
            this.htab = new HandleTable(initialCapacity, loadFactor);
            this.reps = new Object[initialCapacity];
        }

        void assign(Object obj, Object rep) {
            int index = this.htab.assign(obj);
            while (true) {
                Object[] objArr = this.reps;
                if (index >= objArr.length) {
                    grow();
                } else {
                    objArr[index] = rep;
                    return;
                }
            }
        }

        Object lookup(Object obj) {
            int index = this.htab.lookup(obj);
            return index >= 0 ? this.reps[index] : obj;
        }

        void clear() {
            Arrays.fill(this.reps, 0, this.htab.size(), (Object) null);
            this.htab.clear();
        }

        int size() {
            return this.htab.size();
        }

        private void grow() {
            Object[] objArr = this.reps;
            Object[] newReps = new Object[(objArr.length << 1) + 1];
            System.arraycopy(objArr, 0, newReps, 0, objArr.length);
            this.reps = newReps;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class DebugTraceInfoStack {
        private final List<String> stack = new ArrayList();

        DebugTraceInfoStack() {
        }

        void clear() {
            this.stack.clear();
        }

        void pop() {
            this.stack.remove(r0.size() - 1);
        }

        void push(String entry) {
            this.stack.add("\t- " + entry);
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder();
            if (!this.stack.isEmpty()) {
                int i10 = this.stack.size();
                while (i10 > 0) {
                    buffer.append(this.stack.get(i10 - 1) + (i10 != 1 ? "\n" : ""));
                    i10--;
                }
            }
            return buffer.toString();
        }
    }
}
