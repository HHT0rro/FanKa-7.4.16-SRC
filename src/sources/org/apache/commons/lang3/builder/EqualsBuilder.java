package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EqualsBuilder implements Builder<Boolean> {
    private static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY = new ThreadLocal<>();
    private List<Class<?>> bypassReflectionClasses;
    private boolean isEquals = true;
    private boolean testTransients = false;
    private boolean testRecursive = false;
    private Class<?> reflectUpToClass = null;
    private String[] excludeFields = null;

    public EqualsBuilder() {
        ArrayList arrayList = new ArrayList();
        this.bypassReflectionClasses = arrayList;
        arrayList.add(String.class);
    }

    private void appendArray(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            setEquals(false);
            return;
        }
        if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
        } else {
            append((Object[]) obj, (Object[]) obj2);
        }
    }

    public static Pair<IDKey, IDKey> getRegisterPair(Object obj, Object obj2) {
        return Pair.of(new IDKey(obj), new IDKey(obj2));
    }

    public static Set<Pair<IDKey, IDKey>> getRegistry() {
        return REGISTRY.get();
    }

    public static boolean isRegistered(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        Pair<IDKey, IDKey> registerPair = getRegisterPair(obj, obj2);
        return registry != null && (registry.contains(registerPair) || registry.contains(Pair.of(registerPair.getRight(), registerPair.getLeft())));
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection<String> collection) {
        return reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    private static void register(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        if (registry == null) {
            registry = new HashSet<>();
            REGISTRY.set(registry);
        }
        registry.add(getRegisterPair(obj, obj2));
    }

    private static void unregister(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        if (registry != null) {
            registry.remove(getRegisterPair(obj, obj2));
            if (registry.isEmpty()) {
                REGISTRY.remove();
            }
        }
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj != null && obj2 != null) {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                appendArray(obj, obj2);
            } else if (this.testRecursive && !ClassUtils.isPrimitiveOrWrapper(cls)) {
                reflectionAppend(obj, obj2);
            } else {
                this.isEquals = obj.equals(obj2);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder appendSuper(boolean z10) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z10;
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r2.isInstance(r6) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0031, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x002d, code lost:
    
        if (r1.isInstance(r7) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.commons.lang3.builder.EqualsBuilder reflectionAppend(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            boolean r0 = r5.isEquals
            if (r0 != 0) goto L5
            return r5
        L5:
            if (r6 != r7) goto L8
            return r5
        L8:
            r0 = 0
            if (r6 == 0) goto L71
            if (r7 != 0) goto Le
            goto L71
        Le:
            java.lang.Class r1 = r6.getClass()
            java.lang.Class r2 = r7.getClass()
            boolean r3 = r1.isInstance(r7)
            if (r3 == 0) goto L23
            boolean r3 = r2.isInstance(r6)
            if (r3 != 0) goto L2f
            goto L31
        L23:
            boolean r3 = r2.isInstance(r6)
            if (r3 == 0) goto L6e
            boolean r3 = r1.isInstance(r7)
            if (r3 != 0) goto L31
        L2f:
            r3 = r1
            goto L32
        L31:
            r3 = r2
        L32:
            boolean r4 = r3.isArray()     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r4 == 0) goto L3c
            r5.append(r6, r7)     // Catch: java.lang.IllegalArgumentException -> L6b
            goto L6a
        L3c:
            java.util.List<java.lang.Class<?>> r4 = r5.bypassReflectionClasses     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r4 == 0) goto L55
            boolean r1 = r4.contains(r1)     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r1 != 0) goto L4e
            java.util.List<java.lang.Class<?>> r1 = r5.bypassReflectionClasses     // Catch: java.lang.IllegalArgumentException -> L6b
            boolean r1 = r1.contains(r2)     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r1 == 0) goto L55
        L4e:
            boolean r6 = r6.equals(r7)     // Catch: java.lang.IllegalArgumentException -> L6b
            r5.isEquals = r6     // Catch: java.lang.IllegalArgumentException -> L6b
            goto L6a
        L55:
            r5.reflectionAppend(r6, r7, r3)     // Catch: java.lang.IllegalArgumentException -> L6b
        L58:
            java.lang.Class r1 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r1 == 0) goto L6a
            java.lang.Class<?> r1 = r5.reflectUpToClass     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r3 == r1) goto L6a
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L6b
            r5.reflectionAppend(r6, r7, r3)     // Catch: java.lang.IllegalArgumentException -> L6b
            goto L58
        L6a:
            return r5
        L6b:
            r5.isEquals = r0
            return r5
        L6e:
            r5.isEquals = r0
            return r5
        L71:
            r5.isEquals = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.builder.EqualsBuilder.reflectionAppend(java.lang.Object, java.lang.Object):org.apache.commons.lang3.builder.EqualsBuilder");
    }

    public void reset() {
        this.isEquals = true;
    }

    public EqualsBuilder setBypassReflectionClasses(List<Class<?>> list) {
        this.bypassReflectionClasses = list;
        return this;
    }

    public void setEquals(boolean z10) {
        this.isEquals = z10;
    }

    public EqualsBuilder setExcludeFields(String... strArr) {
        this.excludeFields = strArr;
        return this;
    }

    public EqualsBuilder setReflectUpToClass(Class<?> cls) {
        this.reflectUpToClass = cls;
        return this;
    }

    public EqualsBuilder setTestRecursive(boolean z10) {
        this.testRecursive = z10;
        return this;
    }

    public EqualsBuilder setTestTransients(boolean z10) {
        this.testTransients = z10;
        return this;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String... strArr) {
        return reflectionEquals(obj, obj2, false, null, strArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Boolean build() {
        return Boolean.valueOf(isEquals());
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z10) {
        return reflectionEquals(obj, obj2, z10, null, new String[0]);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z10, Class<?> cls, String... strArr) {
        return reflectionEquals(obj, obj2, z10, cls, false, strArr);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z10, Class<?> cls, boolean z11, String... strArr) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return new EqualsBuilder().setExcludeFields(strArr).setReflectUpToClass(cls).setTestTransients(z10).setTestRecursive(z11).reflectionAppend(obj, obj2).isEquals();
    }

    public EqualsBuilder append(long j10, long j11) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = j10 == j11;
        return this;
    }

    public EqualsBuilder append(int i10, int i11) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = i10 == i11;
        return this;
    }

    public EqualsBuilder append(short s2, short s10) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = s2 == s10;
        return this;
    }

    public EqualsBuilder append(char c4, char c10) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = c4 == c10;
        return this;
    }

    public EqualsBuilder append(byte b4, byte b10) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = b4 == b10;
        return this;
    }

    public EqualsBuilder append(double d10, double d11) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d10), Double.doubleToLongBits(d11));
    }

    private void reflectionAppend(Object obj, Object obj2, Class<?> cls) {
        if (isRegistered(obj, obj2)) {
            return;
        }
        try {
            register(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i10 = 0; i10 < declaredFields.length && this.isEquals; i10++) {
                Field field = declaredFields[i10];
                if (!ArrayUtils.contains(this.excludeFields, field.getName()) && !field.getName().contains("$") && ((this.testTransients || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(EqualsExclude.class))) {
                    try {
                        append(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            unregister(obj, obj2);
        }
    }

    public EqualsBuilder append(float f10, float f11) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f10), Float.floatToIntBits(f11));
    }

    public EqualsBuilder append(boolean z10, boolean z11) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z10 == z11;
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (!this.isEquals || objArr == objArr2) {
            return this;
        }
        if (objArr != null && objArr2 != null) {
            if (objArr.length != objArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < objArr.length && this.isEquals; i10++) {
                append(objArr[i10], objArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (!this.isEquals || jArr == jArr2) {
            return this;
        }
        if (jArr != null && jArr2 != null) {
            if (jArr.length != jArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < jArr.length && this.isEquals; i10++) {
                append(jArr[i10], jArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (!this.isEquals || iArr == iArr2) {
            return this;
        }
        if (iArr != null && iArr2 != null) {
            if (iArr.length != iArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < iArr.length && this.isEquals; i10++) {
                append(iArr[i10], iArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (!this.isEquals || sArr == sArr2) {
            return this;
        }
        if (sArr != null && sArr2 != null) {
            if (sArr.length != sArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < sArr.length && this.isEquals; i10++) {
                append(sArr[i10], sArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (!this.isEquals || cArr == cArr2) {
            return this;
        }
        if (cArr != null && cArr2 != null) {
            if (cArr.length != cArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < cArr.length && this.isEquals; i10++) {
                append(cArr[i10], cArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (!this.isEquals || bArr == bArr2) {
            return this;
        }
        if (bArr != null && bArr2 != null) {
            if (bArr.length != bArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < bArr.length && this.isEquals; i10++) {
                append(bArr[i10], bArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (!this.isEquals || dArr == dArr2) {
            return this;
        }
        if (dArr != null && dArr2 != null) {
            if (dArr.length != dArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < dArr.length && this.isEquals; i10++) {
                append(dArr[i10], dArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (!this.isEquals || fArr == fArr2) {
            return this;
        }
        if (fArr != null && fArr2 != null) {
            if (fArr.length != fArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < fArr.length && this.isEquals; i10++) {
                append(fArr[i10], fArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (!this.isEquals || zArr == zArr2) {
            return this;
        }
        if (zArr != null && zArr2 != null) {
            if (zArr.length != zArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i10 = 0; i10 < zArr.length && this.isEquals; i10++) {
                append(zArr[i10], zArr2[i10]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }
}
