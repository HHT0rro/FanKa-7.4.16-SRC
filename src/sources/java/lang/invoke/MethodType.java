package java.lang.invoke;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.invoke.TypeDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import sun.invoke.util.BytecodeDescriptor;
import sun.invoke.util.Wrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class MethodType implements TypeDescriptor.OfMethod<Class<?>, MethodType>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_JVM_ARITY = 255;
    static final int MAX_MH_ARITY = 254;
    static final int MAX_MH_INVOKER_ARITY = 253;
    private static final long ptypesOffset;
    private static final long rtypeOffset;
    private static final long serialVersionUID = 292;

    @Stable
    private MethodTypeForm form;

    @Stable
    private String methodDescriptor;
    private final Class<?>[] ptypes;
    private final Class<?> rtype;

    @Stable
    private MethodType wrapAlt;
    static final ConcurrentWeakInternSet<MethodType> internTable = new ConcurrentWeakInternSet<>();
    static final Class<?>[] NO_PTYPES = new Class[0];
    private static final MethodType[] objectOnlyTypes = new MethodType[20];
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];

    static {
        try {
            rtypeOffset = MethodHandleStatics.UNSAFE.objectFieldOffset(MethodType.class.getDeclaredField("rtype"));
            ptypesOffset = MethodHandleStatics.UNSAFE.objectFieldOffset(MethodType.class.getDeclaredField("ptypes"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private MethodType(Class<?> rtype, Class<?>[] ptypes, boolean trusted) {
        checkRtype(rtype);
        checkPtypes(ptypes);
        this.rtype = rtype;
        this.ptypes = trusted ? ptypes : (Class[]) Arrays.copyOf(ptypes, ptypes.length);
    }

    private MethodType(Class<?>[] ptypes, Class<?> rtype) {
        this.rtype = rtype;
        this.ptypes = ptypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodTypeForm form() {
        return this.form;
    }

    public Class<?> rtype() {
        return this.rtype;
    }

    public Class<?>[] ptypes() {
        return this.ptypes;
    }

    private static void checkRtype(Class<?> rtype) {
        Objects.requireNonNull(rtype);
    }

    private static void checkPtype(Class<?> ptype) {
        Objects.requireNonNull(ptype);
        if (ptype == Void.TYPE) {
            throw MethodHandleStatics.newIllegalArgumentException("parameter type cannot be void");
        }
    }

    private static int checkPtypes(Class<?>[] ptypes) {
        int slots = 0;
        for (Class<?> ptype : ptypes) {
            checkPtype(ptype);
            if (ptype == Double.TYPE || ptype == Long.TYPE) {
                slots++;
            }
        }
        checkSlotCount(ptypes.length + slots);
        return slots;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkSlotCount(int count) {
        if ((count & 255) != count) {
            throw MethodHandleStatics.newIllegalArgumentException("bad parameter count " + count);
        }
    }

    private static IndexOutOfBoundsException newIndexOutOfBoundsException(Object num) {
        if (num instanceof Integer) {
            num = "bad index: " + num;
        }
        return new IndexOutOfBoundsException(num.toString());
    }

    public static MethodType methodType(Class<?> rtype, Class<?>[] ptypes) {
        return makeImpl(rtype, ptypes, false);
    }

    public static MethodType methodType(Class<?> rtype, List<Class<?>> ptypes) {
        return makeImpl(rtype, listToArray(ptypes), false);
    }

    private static Class<?>[] listToArray(List<Class<?>> ptypes) {
        checkSlotCount(ptypes.size());
        return (Class[]) ptypes.toArray(NO_PTYPES);
    }

    public static MethodType methodType(Class<?> rtype, Class<?> ptype0, Class<?>... ptypes) {
        Class<?>[] ptypes1 = new Class[ptypes.length + 1];
        ptypes1[0] = ptype0;
        System.arraycopy(ptypes, 0, ptypes1, 1, ptypes.length);
        return makeImpl(rtype, ptypes1, true);
    }

    public static MethodType methodType(Class<?> rtype) {
        return makeImpl(rtype, NO_PTYPES, true);
    }

    public static MethodType methodType(Class<?> rtype, Class<?> ptype0) {
        return makeImpl(rtype, new Class[]{ptype0}, true);
    }

    public static MethodType methodType(Class<?> rtype, MethodType ptypes) {
        return makeImpl(rtype, ptypes.ptypes, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MethodType makeImpl(Class<?> rtype, Class<?>[] ptypes, boolean trusted) {
        ConcurrentWeakInternSet<MethodType> concurrentWeakInternSet = internTable;
        MethodType mt = concurrentWeakInternSet.get(new MethodType(ptypes, rtype));
        if (mt != null) {
            return mt;
        }
        if (ptypes.length == 0) {
            ptypes = NO_PTYPES;
            trusted = true;
        }
        MethodType mt2 = new MethodType(rtype, ptypes, trusted);
        mt2.form = MethodTypeForm.findForm(mt2);
        return concurrentWeakInternSet.add(mt2);
    }

    public static MethodType genericMethodType(int i10, boolean z10) {
        MethodType methodType;
        checkSlotCount(i10);
        int i11 = (i10 * 2) + (z10 ? 1 : 0);
        MethodType[] methodTypeArr = objectOnlyTypes;
        if (i11 < methodTypeArr.length && (methodType = methodTypeArr[i11]) != null) {
            return methodType;
        }
        Class[] clsArr = new Class[i10 + (z10 ? 1 : 0)];
        Arrays.fill(clsArr, Object.class);
        if (z10) {
            clsArr[i10] = Object[].class;
        }
        MethodType makeImpl = makeImpl(Object.class, clsArr, true);
        if (i11 < methodTypeArr.length) {
            methodTypeArr[i11] = makeImpl;
        }
        return makeImpl;
    }

    public static MethodType genericMethodType(int objectArgCount) {
        return genericMethodType(objectArgCount, false);
    }

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public MethodType changeParameterType(int num, Class<?> nptype) {
        if (parameterType(num) == nptype) {
            return this;
        }
        checkPtype(nptype);
        Class<?>[] nptypes = (Class[]) this.ptypes.clone();
        nptypes[num] = nptype;
        return makeImpl(this.rtype, nptypes, true);
    }

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public MethodType insertParameterTypes(int num, Class<?>... ptypesToInsert) {
        int len = this.ptypes.length;
        if (num < 0 || num > len) {
            throw newIndexOutOfBoundsException(Integer.valueOf(num));
        }
        int ins = checkPtypes(ptypesToInsert);
        checkSlotCount(parameterSlotCount() + ptypesToInsert.length + ins);
        int ilen = ptypesToInsert.length;
        if (ilen == 0) {
            return this;
        }
        Class<?>[] nptypes = (Class[]) Arrays.copyOfRange(this.ptypes, 0, len + ilen);
        System.arraycopy(nptypes, num, nptypes, num + ilen, len - num);
        System.arraycopy(ptypesToInsert, 0, nptypes, num, ilen);
        return makeImpl(this.rtype, nptypes, true);
    }

    public MethodType appendParameterTypes(Class<?>... ptypesToInsert) {
        return insertParameterTypes(parameterCount(), ptypesToInsert);
    }

    public MethodType insertParameterTypes(int num, List<Class<?>> ptypesToInsert) {
        return insertParameterTypes(num, listToArray(ptypesToInsert));
    }

    public MethodType appendParameterTypes(List<Class<?>> ptypesToInsert) {
        return insertParameterTypes(parameterCount(), ptypesToInsert);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodType replaceParameterTypes(int start, int end, Class<?>... ptypesToInsert) {
        if (start == end) {
            return insertParameterTypes(start, ptypesToInsert);
        }
        int len = this.ptypes.length;
        if (start < 0 || start > end || end > len) {
            throw newIndexOutOfBoundsException("start=" + start + " end=" + end);
        }
        int ilen = ptypesToInsert.length;
        if (ilen == 0) {
            return dropParameterTypes(start, end);
        }
        return dropParameterTypes(start, end).insertParameterTypes(start, ptypesToInsert);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodType asSpreaderType(Class<?> arrayType, int pos, int arrayLength) {
        if (arrayLength == 0) {
            return this;
        }
        if (arrayType == Object[].class) {
            if (isGeneric()) {
                return this;
            }
            if (pos == 0) {
                MethodType res = genericMethodType(arrayLength);
                Class<?> cls = this.rtype;
                if (cls != Object.class) {
                    return res.changeReturnType(cls);
                }
                return res;
            }
        }
        Class<?> elemType = arrayType.getComponentType();
        for (int i10 = pos; i10 < pos + arrayLength; i10++) {
            Class<?>[] clsArr = this.ptypes;
            if (clsArr[i10] != elemType) {
                Class<?>[] fixedPtypes = (Class[]) clsArr.clone();
                Arrays.fill(fixedPtypes, i10, pos + arrayLength, elemType);
                return methodType(this.rtype, fixedPtypes);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> leadingReferenceParameter() {
        Class<?>[] clsArr = this.ptypes;
        if (clsArr.length != 0) {
            Class<?> ptype = clsArr[0];
            if (!ptype.isPrimitive()) {
                return ptype;
            }
        }
        throw MethodHandleStatics.newIllegalArgumentException("no leading reference parameter");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodType asCollectorType(Class<?> arrayType, int pos, int arrayLength) {
        MethodType res;
        if (arrayType == Object[].class) {
            res = genericMethodType(arrayLength);
            Class<?> cls = this.rtype;
            if (cls != Object.class) {
                res = res.changeReturnType(cls);
            }
        } else {
            Class<?> elemType = arrayType.getComponentType();
            res = methodType(this.rtype, (List<Class<?>>) Collections.nCopies(arrayLength, elemType));
        }
        Class<?>[] clsArr = this.ptypes;
        if (clsArr.length == 1) {
            return res;
        }
        if (pos < clsArr.length - 1) {
            res = res.insertParameterTypes(arrayLength, (Class<?>[]) Arrays.copyOfRange(clsArr, pos + 1, clsArr.length));
        }
        return res.insertParameterTypes(0, (Class<?>[]) Arrays.copyOf(this.ptypes, pos));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public MethodType dropParameterTypes(int start, int end) {
        Class<?>[] nptypes;
        Class<?>[] nptypes2 = this.ptypes;
        int len = nptypes2.length;
        if (start < 0 || start > end || end > len) {
            throw newIndexOutOfBoundsException("start=" + start + " end=" + end);
        }
        if (start == end) {
            return this;
        }
        if (start == 0) {
            if (end == len) {
                nptypes = NO_PTYPES;
            } else {
                nptypes = (Class[]) Arrays.copyOfRange(nptypes2, end, len);
            }
        } else if (end == len) {
            nptypes = (Class[]) Arrays.copyOfRange(nptypes2, 0, start);
        } else {
            int tail = len - end;
            nptypes = (Class[]) Arrays.copyOfRange(nptypes2, 0, start + tail);
            System.arraycopy(this.ptypes, end, nptypes, start, tail);
        }
        return makeImpl(this.rtype, nptypes, true);
    }

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public MethodType changeReturnType(Class<?> nrtype) {
        return returnType() == nrtype ? this : makeImpl(nrtype, this.ptypes, true);
    }

    public boolean hasPrimitives() {
        return this.form.hasPrimitives();
    }

    public boolean hasWrappers() {
        return unwrap() != this;
    }

    public MethodType erase() {
        return this.form.erasedType();
    }

    public MethodType generic() {
        return genericMethodType(parameterCount());
    }

    boolean isGeneric() {
        return this == erase() && !hasPrimitives();
    }

    public MethodType wrap() {
        return hasPrimitives() ? wrapWithPrims(this) : this;
    }

    public MethodType unwrap() {
        MethodType noprims = !hasPrimitives() ? this : wrapWithPrims(this);
        return unwrapWithNoPrims(noprims);
    }

    private static MethodType wrapWithPrims(MethodType pt) {
        MethodType wt = pt.wrapAlt;
        if (wt == null) {
            MethodType wt2 = MethodTypeForm.canonicalize(pt, 2, 2);
            pt.wrapAlt = wt2;
            return wt2;
        }
        return wt;
    }

    private static MethodType unwrapWithNoPrims(MethodType wt) {
        MethodType uwt = wt.wrapAlt;
        if (uwt == null) {
            uwt = MethodTypeForm.canonicalize(wt, 3, 3);
            if (uwt == null) {
                uwt = wt;
            }
            wt.wrapAlt = uwt;
        }
        return uwt;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public Class<?> parameterType(int num) {
        return this.ptypes[num];
    }

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public int parameterCount() {
        return this.ptypes.length;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public Class<?> returnType() {
        return this.rtype;
    }

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public List<Class<?>> parameterList() {
        return Collections.unmodifiableList(Arrays.asList((Class[]) this.ptypes.clone()));
    }

    public Class<?> lastParameterType() {
        Class<?>[] clsArr = this.ptypes;
        int len = clsArr.length;
        return len == 0 ? Void.TYPE : clsArr[len - 1];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    public Class<?>[] parameterArray() {
        return (Class[]) this.ptypes.clone();
    }

    public boolean equals(Object x10) {
        return this == x10 || ((x10 instanceof MethodType) && equals((MethodType) x10));
    }

    private boolean equals(MethodType that) {
        return this.rtype == that.rtype && Arrays.equals(this.ptypes, that.ptypes);
    }

    public int hashCode() {
        int hashCode = this.rtype.hashCode() + 31;
        for (Class<?> ptype : this.ptypes) {
            hashCode = (hashCode * 31) + ptype.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i10 = 0; i10 < this.ptypes.length; i10++) {
            if (i10 > 0) {
                sb2.append(",");
            }
            sb2.append(this.ptypes[i10].getSimpleName());
        }
        sb2.append(")");
        sb2.append(this.rtype.getSimpleName());
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean effectivelyIdenticalParameters(int skipPos, List<Class<?>> fullList) {
        int myLen = this.ptypes.length;
        int fullLen = fullList.size();
        if (skipPos > myLen || myLen - skipPos > fullLen) {
            return false;
        }
        List<Class<?>> myList = Arrays.asList(this.ptypes);
        if (skipPos != 0) {
            myList = myList.subList(skipPos, myLen);
            myLen -= skipPos;
        }
        if (fullLen == myLen) {
            return myList.equals(fullList);
        }
        return myList.equals(fullList.subList(0, myLen));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isConvertibleTo(MethodType newType) {
        if (!canConvert(returnType(), newType.returnType())) {
            return false;
        }
        Class<?>[] srcTypes = newType.ptypes;
        Class<?>[] dstTypes = this.ptypes;
        if (srcTypes == dstTypes) {
            return true;
        }
        int argc = srcTypes.length;
        if (argc != dstTypes.length) {
            return false;
        }
        if (argc <= 1) {
            return argc != 1 || canConvert(srcTypes[0], dstTypes[0]);
        }
        return canConvertParameters(srcTypes, dstTypes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean explicitCastEquivalentToAsType(MethodType newType) {
        if (this == newType) {
            return true;
        }
        if (!explicitCastEquivalentToAsType(this.rtype, newType.rtype)) {
            return false;
        }
        Class<?>[] srcTypes = newType.ptypes;
        Class<?>[] dstTypes = this.ptypes;
        if (dstTypes == srcTypes) {
            return true;
        }
        for (int i10 = 0; i10 < dstTypes.length; i10++) {
            if (!explicitCastEquivalentToAsType(srcTypes[i10], dstTypes[i10])) {
                return false;
            }
        }
        return true;
    }

    private static boolean explicitCastEquivalentToAsType(Class<?> src, Class<?> dst) {
        if (src == dst || dst == Object.class || dst == Void.TYPE) {
            return true;
        }
        if (src.isPrimitive()) {
            return canConvert(src, dst);
        }
        if (dst.isPrimitive()) {
            return false;
        }
        return !dst.isInterface() || dst.isAssignableFrom(src);
    }

    private boolean canConvertParameters(Class<?>[] srcTypes, Class<?>[] dstTypes) {
        for (int i10 = 0; i10 < srcTypes.length; i10++) {
            if (!canConvert(srcTypes[i10], dstTypes[i10])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canConvert(Class<?> src, Class<?> dst) {
        if (src == dst || src == Object.class || dst == Object.class) {
            return true;
        }
        if (src.isPrimitive()) {
            if (src == Void.TYPE) {
                return true;
            }
            Wrapper sw = Wrapper.forPrimitiveType(src);
            if (dst.isPrimitive()) {
                return Wrapper.forPrimitiveType(dst).isConvertibleFrom(sw);
            }
            return dst.isAssignableFrom(sw.wrapperType());
        }
        if (!dst.isPrimitive() || dst == Void.TYPE) {
            return true;
        }
        Wrapper dw = Wrapper.forPrimitiveType(dst);
        if (src.isAssignableFrom(dw.wrapperType())) {
            return true;
        }
        if (Wrapper.isWrapperType(src) && dw.isConvertibleFrom(Wrapper.forWrapperType(src))) {
            return true;
        }
        return false;
    }

    int parameterSlotCount() {
        return this.form.parameterSlotCount();
    }

    public static MethodType fromMethodDescriptorString(String descriptor, ClassLoader loader) throws IllegalArgumentException, TypeNotPresentException {
        if (!descriptor.startsWith("(") || descriptor.indexOf(41) < 0 || descriptor.indexOf(46) >= 0) {
            throw MethodHandleStatics.newIllegalArgumentException("not a method descriptor: " + descriptor);
        }
        List<Class<?>> types = BytecodeDescriptor.parseMethod(descriptor, loader);
        Class<?> rtype = types.remove(types.size() - 1);
        checkSlotCount(types.size());
        Class<?>[] ptypes = listToArray(types);
        return makeImpl(rtype, ptypes, true);
    }

    public String toMethodDescriptorString() {
        String desc = this.methodDescriptor;
        if (desc == null) {
            String desc2 = BytecodeDescriptor.unparse(this);
            this.methodDescriptor = desc2;
            return desc2;
        }
        return desc;
    }

    @Override // java.lang.invoke.TypeDescriptor
    public String descriptorString() {
        return toMethodDescriptorString();
    }

    static String toFieldDescriptorString(Class<?> cls) {
        return BytecodeDescriptor.unparse(cls);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeObject(returnType());
        s2.writeObject(parameterArray());
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        Class<?> returnType = (Class) s2.readObject();
        Class<?>[] parameterArray = (Class[]) s2.readObject();
        checkRtype(returnType);
        checkPtypes(parameterArray);
        MethodType_init(returnType, (Class[]) parameterArray.clone());
    }

    private MethodType() {
        this.rtype = null;
        this.ptypes = null;
    }

    private void MethodType_init(Class<?> rtype, Class<?>[] ptypes) {
        checkRtype(rtype);
        checkPtypes(ptypes);
        MethodHandleStatics.UNSAFE.putObject(this, rtypeOffset, rtype);
        MethodHandleStatics.UNSAFE.putObject(this, ptypesOffset, ptypes);
    }

    private Object readResolve() {
        return methodType(this.rtype, this.ptypes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ConcurrentWeakInternSet<T> {
        private final ConcurrentMap<WeakEntry<T>, WeakEntry<T>> map = new ConcurrentHashMap();
        private final ReferenceQueue<T> stale = new ReferenceQueue<>();

        public T get(T elem) {
            T res;
            if (elem == null) {
                throw new NullPointerException();
            }
            expungeStaleElements();
            WeakEntry<T> value = this.map.get(new WeakEntry(elem));
            if (value != null && (res = value.get()) != null) {
                return res;
            }
            return null;
        }

        public T add(T elem) {
            T interned;
            if (elem == null) {
                throw new NullPointerException();
            }
            WeakEntry<T> e2 = new WeakEntry<>(elem, this.stale);
            do {
                expungeStaleElements();
                WeakEntry<T> exist = this.map.putIfAbsent(e2, e2);
                interned = exist == null ? elem : exist.get();
            } while (interned == null);
            return interned;
        }

        private void expungeStaleElements() {
            while (true) {
                Reference<? extends T> reference = this.stale.poll();
                if (reference != null) {
                    this.map.remove(reference);
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class WeakEntry<T> extends WeakReference<T> {
            public final int hashcode;

            public WeakEntry(T key, ReferenceQueue<T> queue) {
                super(key, queue);
                this.hashcode = key.hashCode();
            }

            public WeakEntry(T key) {
                super(key);
                this.hashcode = key.hashCode();
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof WeakEntry)) {
                    return false;
                }
                Object that = ((WeakEntry) obj).get();
                Object mine = get();
                return (that == null || mine == null) ? this == obj : mine.equals(that);
            }

            public int hashCode() {
                return this.hashcode;
            }
        }
    }
}
