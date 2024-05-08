package java.lang;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import dalvik.annotation.optimization.FastNative;
import dalvik.system.ClassExt;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.invoke.TypeDescriptor;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.RecordComponents;
import libcore.reflect.Types;
import libcore.util.BasicLruCache;
import libcore.util.CollectionUtils;
import libcore.util.EmptyArray;
import org.apache.commons.io.IOUtils;
import sun.invoke.util.Wrapper;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Class<T> implements Serializable, GenericDeclaration, Type, AnnotatedElement, TypeDescriptor.OfField<Class<?>> {
    private static final int ANNOTATION = 8192;
    private static final int ENUM = 16384;
    private static final int FINALIZABLE = Integer.MIN_VALUE;
    private static final int SYNTHETIC = 4096;
    private static final long serialVersionUID = 3206093459760846163L;
    private transient int accessFlags;
    private transient int classFlags;
    private transient ClassLoader classLoader;
    private transient int classSize;
    private transient int clinitThreadId;
    private transient Class<?> componentType;
    private transient short copiedMethodsOffset;
    private transient Object dexCache;
    private transient int dexClassDefIndex;
    private volatile transient int dexTypeIndex;
    private transient ClassExt extData;
    private transient long iFields;
    private transient Object[] ifTable;
    private transient long methods;
    private transient String name;
    private transient int numReferenceInstanceFields;
    private transient int numReferenceStaticFields;
    private transient int objectSize;
    private transient int objectSizeAllocFastPath;
    private transient int primitiveType;
    private transient int referenceInstanceOffsets;
    private transient long sFields;
    private transient int status;
    private transient Class<? super T> superClass;
    private transient short virtualMethodsOffset;
    private transient Object vtable;

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public static native Class<?> classForName(String str, boolean z10, ClassLoader classLoader) throws ClassNotFoundException;

    @FastNative
    private native Constructor<T> getDeclaredConstructorInternal(Class<?>[] clsArr);

    @FastNative
    private native Constructor<?>[] getDeclaredConstructorsInternal(boolean z10);

    @FastNative
    private native Method getDeclaredMethodInternal(String str, Class<?>[] clsArr);

    @FastNative
    private native Constructor<?> getEnclosingConstructorNative();

    @FastNative
    private native Method getEnclosingMethodNative();

    @FastNative
    private native int getInnerClassFlags(int i10);

    @FastNative
    private native String getInnerClassName();

    @FastNative
    private native Class<?>[] getInterfacesInternal();

    @FastNative
    private native String getNameNative();

    @FastNative
    private native Class<?> getNestHostFromAnnotation();

    @FastNative
    private native Class<?>[] getNestMembersFromAnnotation();

    @FastNative
    private native Class<?>[] getPermittedSubclassesFromAnnotation();

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public static native Class<?> getPrimitiveClass(String str);

    @FastNative
    private native Field[] getPublicDeclaredFields();

    @FastNative
    private native Field getPublicFieldRecursive(String str);

    @FastNative
    private native String[] getSignatureAnnotation();

    @FastNative
    private native boolean isDeclaredAnnotationPresent(Class<? extends Annotation> cls);

    @FastNative
    private native boolean isRecord0();

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public native ClassExt ensureExtDataPresent();

    @Override // java.lang.reflect.AnnotatedElement
    @FastNative
    public native <A extends Annotation> A getDeclaredAnnotation(Class<A> cls);

    @Override // java.lang.reflect.AnnotatedElement
    @FastNative
    public native Annotation[] getDeclaredAnnotations();

    @FastNative
    public native Class<?>[] getDeclaredClasses();

    @FastNative
    public native Field getDeclaredField(String str) throws NoSuchFieldException;

    @FastNative
    public native Field[] getDeclaredFields();

    @FastNative
    public native Field[] getDeclaredFieldsUnchecked(boolean z10);

    @FastNative
    public native Method[] getDeclaredMethodsUnchecked(boolean z10);

    @FastNative
    public native Class<?> getDeclaringClass();

    @FastNative
    public native Class<?> getEnclosingClass();

    @FastNative
    public native <T2> T2[] getRecordAnnotationElement(String str, Class<T2[]> cls);

    @FastNative
    public native boolean isAnonymousClass();

    @FastNative
    @Deprecated(since = "9")
    public native T newInstance() throws InstantiationException, IllegalAccessException;

    private Class() {
    }

    private Class(ClassLoader loader, Class<?> arrayComponentType) {
        this.classLoader = loader;
        this.componentType = arrayComponentType;
    }

    public String toString() {
        return (isInterface() ? "interface " : isPrimitive() ? "" : "class ") + getName();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1 A[LOOP:2: B:20:0x009f->B:21:0x00a1, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toGenericString() {
        /*
            r9 = this;
            boolean r0 = r9.isPrimitive()
            if (r0 == 0) goto Lb
            java.lang.String r0 = r9.toString()
            return r0
        Lb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r9
            r2 = 0
            boolean r3 = r9.isArray()
            if (r3 == 0) goto L2c
        L18:
            int r2 = r2 + 1
            java.lang.Class r1 = r1.getComponentType()
            boolean r3 = r1.isArray()
            if (r3 != 0) goto L18
            java.lang.String r3 = r1.getName()
            r0.append(r3)
            goto L75
        L2c:
            int r3 = r9.getModifiers()
            int r4 = java.lang.reflect.Modifier.classModifiers()
            r3 = r3 & r4
            r4 = 32
            if (r3 == 0) goto L43
            java.lang.String r5 = java.lang.reflect.Modifier.toString(r3)
            r0.append(r5)
            r0.append(r4)
        L43:
            boolean r5 = r9.isAnnotation()
            if (r5 == 0) goto L4e
            r5 = 64
            r0.append(r5)
        L4e:
            boolean r5 = r9.isInterface()
            if (r5 == 0) goto L5a
            java.lang.String r5 = "interface"
            r0.append(r5)
            goto L6b
        L5a:
            boolean r5 = r9.isEnum()
            if (r5 == 0) goto L66
            java.lang.String r5 = "enum"
            r0.append(r5)
            goto L6b
        L66:
            java.lang.String r5 = "class"
            r0.append(r5)
        L6b:
            r0.append(r4)
            java.lang.String r4 = r9.getName()
            r0.append(r4)
        L75:
            java.lang.reflect.TypeVariable[] r3 = r1.getTypeParameters()
            int r4 = r3.length
            if (r4 <= 0) goto L9e
            java.util.StringJoiner r4 = new java.util.StringJoiner
            java.lang.String r5 = "<"
            java.lang.String r6 = ">"
            java.lang.String r7 = ","
            r4.<init>(r7, r5, r6)
            int r5 = r3.length
            r6 = 0
        L89:
            if (r6 >= r5) goto L97
            r7 = r3[r6]
            java.lang.String r8 = r7.getTypeName()
            r4.add(r8)
            int r6 = r6 + 1
            goto L89
        L97:
            java.lang.String r5 = r4.toString()
            r0.append(r5)
        L9e:
            r4 = 0
        L9f:
            if (r4 >= r2) goto La9
            java.lang.String r5 = "[]"
            r0.append(r5)
            int r4 = r4 + 1
            goto L9f
        La9:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Class.toGenericString():java.lang.String");
    }

    @CallerSensitive
    public static Class<?> forName(String className) throws ClassNotFoundException {
        Class<?> caller = Reflection.getCallerClass();
        return forName(className, true, ClassLoader.getClassLoader(caller));
    }

    @CallerSensitive
    public static Class<?> forName(String name, boolean initialize, ClassLoader loader) throws ClassNotFoundException {
        if (loader == null) {
            loader = BootClassLoader.getInstance();
        }
        try {
            Class<?> result = classForName(name, initialize, loader);
            return result;
        } catch (ClassNotFoundException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof LinkageError) {
                throw ((LinkageError) cause);
            }
            throw e2;
        }
    }

    public boolean isInstance(Object obj) {
        if (obj == null) {
            return false;
        }
        return isAssignableFrom(obj.getClass());
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        if (r6.isInterface() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0045, code lost:
    
        r6 = r6.superClass;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0047, code lost:
    
        if (r6 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0049, code lost:
    
        if (r6 != r5) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004c, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isAssignableFrom(java.lang.Class<?> r6) {
        /*
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L4
            return r0
        L4:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r5 != r1) goto Le
            boolean r1 = r6.isPrimitive()
            r0 = r0 ^ r1
            return r0
        Le:
            boolean r1 = r5.isArray()
            r2 = 0
            if (r1 == 0) goto L28
            boolean r1 = r6.isArray()
            if (r1 == 0) goto L26
            java.lang.Class<?> r1 = r5.componentType
            java.lang.Class<?> r3 = r6.componentType
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 == 0) goto L26
            goto L27
        L26:
            r0 = r2
        L27:
            return r0
        L28:
            boolean r1 = r5.isInterface()
            if (r1 == 0) goto L3f
            java.lang.Object[] r1 = r6.ifTable
            if (r1 == 0) goto L3e
            r3 = 0
        L33:
            int r4 = r1.length
            if (r3 >= r4) goto L3e
            r4 = r1[r3]
            if (r4 != r5) goto L3b
            return r0
        L3b:
            int r3 = r3 + 2
            goto L33
        L3e:
            return r2
        L3f:
            boolean r1 = r6.isInterface()
            if (r1 != 0) goto L4c
        L45:
            java.lang.Class<? super T> r6 = r6.superClass
            if (r6 == 0) goto L4c
            if (r6 != r5) goto L45
            return r0
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Class.isAssignableFrom(java.lang.Class):boolean");
    }

    public boolean isInterface() {
        return (this.accessFlags & 512) != 0;
    }

    @Override // java.lang.invoke.TypeDescriptor.OfField
    public boolean isArray() {
        return getComponentType() != null;
    }

    @Override // java.lang.invoke.TypeDescriptor.OfField
    public boolean isPrimitive() {
        return (this.primitiveType & 65535) != 0;
    }

    public boolean isFinalizable() {
        return (getModifiers() & Integer.MIN_VALUE) != 0;
    }

    public boolean isAnnotation() {
        return (getModifiers() & 8192) != 0;
    }

    public boolean isSynthetic() {
        return (getModifiers() & 4096) != 0;
    }

    public String getName() {
        String name = this.name;
        if (name == null) {
            String name2 = getNameNative();
            this.name = name2;
            return name2;
        }
        return name;
    }

    public ClassLoader getClassLoader() {
        if (isPrimitive()) {
            return null;
        }
        ClassLoader classLoader = this.classLoader;
        return classLoader == null ? BootClassLoader.getInstance() : classLoader;
    }

    @Override // java.lang.reflect.GenericDeclaration
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        String annotationSignature = getSignatureAttribute();
        if (annotationSignature == null) {
            return EmptyArray.TYPE_VARIABLE;
        }
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, annotationSignature);
        return parser.formalTypeParameters;
    }

    public Class<? super T> getSuperclass() {
        if (isInterface()) {
            return null;
        }
        return this.superClass;
    }

    public Type getGenericSuperclass() {
        Type genericSuperclass = getSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        String annotationSignature = getSignatureAttribute();
        if (annotationSignature != null) {
            GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
            parser.parseForClass(this, annotationSignature);
            genericSuperclass = parser.superclassType;
        }
        return Types.getType(genericSuperclass);
    }

    public Package getPackage() {
        String packageName;
        ClassLoader loader = getClassLoader();
        if (loader == null || (packageName = getPackageName()) == null) {
            return null;
        }
        return loader.getPackage(packageName);
    }

    public String getPackageName() {
        Class cls = this;
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            return "java.lang";
        }
        String cn2 = cls.getName();
        int dot = cn2.lastIndexOf(46);
        return dot != -1 ? cn2.substring(0, dot).intern() : "";
    }

    public Class<?>[] getInterfaces() {
        if (isArray()) {
            return new Class[]{Cloneable.class, Serializable.class};
        }
        Class<?>[] ifaces = getInterfacesInternal();
        if (ifaces == null) {
            return EmptyArray.CLASS;
        }
        return ifaces;
    }

    public Type[] getGenericInterfaces() {
        Type[] result;
        synchronized (Caches.genericInterfaces) {
            result = (Type[]) Caches.genericInterfaces.get(this);
            if (result == null) {
                String annotationSignature = getSignatureAttribute();
                if (annotationSignature == null) {
                    result = getInterfaces();
                } else {
                    GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
                    parser.parseForClass(this, annotationSignature);
                    result = Types.getTypeArray(parser.interfaceTypes, false);
                }
                Caches.genericInterfaces.put(this, result);
            }
        }
        return result.length == 0 ? result : (Type[]) result.clone();
    }

    public Class<?> getComponentType() {
        return this.componentType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfField
    public Class<?> componentType() {
        if (isArray()) {
            return this.componentType;
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfField
    public Class<?> arrayType() {
        return Array.newInstance((Class<?>) this, 0).getClass();
    }

    @Override // java.lang.invoke.TypeDescriptor
    public String descriptorString() {
        if (isPrimitive()) {
            return Wrapper.forPrimitiveType((Class<?>) this).basicTypeString();
        }
        if (isArray()) {
            return "[" + this.componentType.descriptorString();
        }
        String name = getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
        return new StringBuilder(name.length() + 2).append('L').append(name).append(';').toString();
    }

    public int getModifiers() {
        if (isArray()) {
            int componentModifiers = getComponentType().getModifiers();
            if ((componentModifiers & 512) != 0) {
                componentModifiers &= -521;
            }
            return componentModifiers | DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO;
        }
        int modifiers = getInnerClassFlags(this.accessFlags & 65535);
        return modifiers & 65535;
    }

    public Object[] getSigners() {
        return null;
    }

    public Method getEnclosingMethod() {
        if (classNameImpliesTopLevel()) {
            return null;
        }
        return getEnclosingMethodNative();
    }

    public Constructor<?> getEnclosingConstructor() {
        if (classNameImpliesTopLevel()) {
            return null;
        }
        return getEnclosingConstructorNative();
    }

    private boolean classNameImpliesTopLevel() {
        return !getName().contains("$");
    }

    public String getSimpleName() {
        if (isArray()) {
            return getComponentType().getSimpleName() + "[]";
        }
        if (isAnonymousClass()) {
            return "";
        }
        if (isMemberClass() || isLocalClass()) {
            return getInnerClassName();
        }
        String simpleName = getName();
        int dot = simpleName.lastIndexOf(".");
        if (dot > 0) {
            return simpleName.substring(simpleName.lastIndexOf(".") + 1);
        }
        return simpleName;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        if (isArray()) {
            Class<T> cls = this;
            int dimensions = 0;
            do {
                dimensions++;
                try {
                    cls = cls.getComponentType();
                } catch (Throwable th) {
                }
            } while (cls.isArray());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            for (int i10 = 0; i10 < dimensions; i10++) {
                sb2.append("[]");
            }
            return sb2.toString();
        }
        return getName();
    }

    public String getCanonicalName() {
        if (isArray()) {
            String canonicalName = getComponentType().getCanonicalName();
            if (canonicalName != null) {
                return canonicalName + "[]";
            }
            return null;
        }
        if (isLocalOrAnonymousClass()) {
            return null;
        }
        Class<?> enclosingClass = getEnclosingClass();
        if (enclosingClass == null) {
            return getName();
        }
        String enclosingName = enclosingClass.getCanonicalName();
        if (enclosingName == null) {
            return null;
        }
        return enclosingName + "." + getSimpleName();
    }

    public boolean isLocalClass() {
        return ((getEnclosingMethod() == null && getEnclosingConstructor() == null) || isAnonymousClass()) ? false : true;
    }

    public boolean isMemberClass() {
        return (isLocalOrAnonymousClass() || getDeclaringClass() == null) ? false : true;
    }

    private boolean isTopLevelClass() {
        return !isLocalOrAnonymousClass() && getDeclaringClass() == null;
    }

    private boolean isLocalOrAnonymousClass() {
        return isLocalClass() || isAnonymousClass();
    }

    @CallerSensitive
    public Class<?>[] getClasses() {
        List<Class<?>> result = new ArrayList<>();
        for (Class cls = this; cls != null; cls = cls.superClass) {
            for (Class<?> member : cls.getDeclaredClasses()) {
                if (Modifier.isPublic(member.getModifiers())) {
                    result.add(member);
                }
            }
        }
        return (Class[]) result.toArray(new Class[result.size()]);
    }

    @CallerSensitive
    public Field[] getFields() throws SecurityException {
        List<Field> fields = new ArrayList<>();
        getPublicFieldsRecursive(fields);
        return (Field[]) fields.toArray(new Field[fields.size()]);
    }

    private void getPublicFieldsRecursive(List<Field> result) {
        for (Class cls = this; cls != null; cls = cls.superClass) {
            Collections.addAll(result, cls.getPublicDeclaredFields());
        }
        Object[] iftable = this.ifTable;
        if (iftable != null) {
            for (int i10 = 0; i10 < iftable.length; i10 += 2) {
                Collections.addAll(result, ((Class) iftable[i10]).getPublicDeclaredFields());
            }
        }
    }

    @CallerSensitive
    public Method[] getMethods() throws SecurityException {
        List<Method> methods = new ArrayList<>();
        getPublicMethodsInternal(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        return (Method[]) methods.toArray(new Method[methods.size()]);
    }

    private void getPublicMethodsInternal(List<Method> result) {
        Collections.addAll(result, getDeclaredMethodsUnchecked(true));
        if (!isInterface()) {
            for (Class<?> c4 = this.superClass; c4 != null; c4 = c4.superClass) {
                Collections.addAll(result, c4.getDeclaredMethodsUnchecked(true));
            }
        }
        Object[] iftable = this.ifTable;
        if (iftable != null) {
            for (int i10 = 0; i10 < iftable.length; i10 += 2) {
                Class<?> ifc = (Class) iftable[i10];
                Collections.addAll(result, ifc.getDeclaredMethodsUnchecked(true));
            }
        }
    }

    @CallerSensitive
    public Constructor<?>[] getConstructors() throws SecurityException {
        return getDeclaredConstructorsInternal(true);
    }

    public Field getField(String name) throws NoSuchFieldException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        Field result = getPublicFieldRecursive(name);
        if (result == null) {
            throw new NoSuchFieldException(name);
        }
        return result;
    }

    @CallerSensitive
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getMethod(name, parameterTypes, true);
    }

    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getConstructor0(parameterTypes, 0);
    }

    @CallerSensitive
    public RecordComponent[] getRecordComponents() {
        if (!isRecord()) {
            return null;
        }
        return getRecordComponents0();
    }

    public Method[] getDeclaredMethods() throws SecurityException {
        Method[] result = getDeclaredMethodsUnchecked(false);
        for (Method m10 : result) {
            m10.getReturnType();
            m10.getParameterTypes();
        }
        return result;
    }

    public Constructor<?>[] getDeclaredConstructors() throws SecurityException {
        return getDeclaredConstructorsInternal(false);
    }

    @CallerSensitive
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getMethod(name, parameterTypes, false);
    }

    private Method getMethod(String name, Class<?>[] parameterTypes, boolean recursivePublicMethods) throws NoSuchMethodException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        if (parameterTypes == null) {
            parameterTypes = EmptyArray.CLASS;
        }
        for (Class<?> c4 : parameterTypes) {
            if (c4 == null) {
                throw new NoSuchMethodException("parameter type is null");
            }
        }
        Method result = recursivePublicMethods ? getPublicMethodRecursive(name, parameterTypes) : getDeclaredMethodInternal(name, parameterTypes);
        if (result == null || (recursivePublicMethods && !Modifier.isPublic(result.getAccessFlags()))) {
            throw new NoSuchMethodException(getName() + "." + name + " " + Arrays.toString(parameterTypes));
        }
        return result;
    }

    private Method getPublicMethodRecursive(String name, Class<?>[] parameterTypes) {
        for (Class<T> cls = this; cls != null; cls = cls.getSuperclass()) {
            Method result = cls.getDeclaredMethodInternal(name, parameterTypes);
            if (result != null && Modifier.isPublic(result.getAccessFlags())) {
                return result;
            }
        }
        return findInterfaceMethod(name, parameterTypes);
    }

    public Method getInstanceMethod(String name, Class<?>[] parameterTypes) throws NoSuchMethodException, IllegalAccessException {
        for (Class<T> cls = this; cls != null; cls = cls.getSuperclass()) {
            Method result = cls.getDeclaredMethodInternal(name, parameterTypes);
            if (result != null && !Modifier.isStatic(result.getModifiers())) {
                return result;
            }
        }
        return findInterfaceMethod(name, parameterTypes);
    }

    private Method findInterfaceMethod(String name, Class<?>[] parameterTypes) {
        Object[] iftable = this.ifTable;
        if (iftable != null) {
            for (int i10 = iftable.length - 2; i10 >= 0; i10 -= 2) {
                Class<?> ifc = (Class) iftable[i10];
                Method result = ifc.getPublicMethodRecursive(name, parameterTypes);
                if (result != null && Modifier.isPublic(result.getAccessFlags())) {
                    return result;
                }
            }
            return null;
        }
        return null;
    }

    @CallerSensitive
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getConstructor0(parameterTypes, 1);
    }

    @CallerSensitive
    public InputStream getResourceAsStream(String name) {
        String name2 = resolveName(name);
        ClassLoader cl = getClassLoader();
        if (cl == null) {
            return ClassLoader.getSystemResourceAsStream(name2);
        }
        return cl.getResourceAsStream(name2);
    }

    @CallerSensitive
    public URL getResource(String name) {
        String name2 = resolveName(name);
        ClassLoader cl = getClassLoader();
        if (cl == null) {
            return ClassLoader.getSystemResource(name2);
        }
        return cl.getResource(name2);
    }

    public ProtectionDomain getProtectionDomain() {
        return null;
    }

    private String resolveName(String name) {
        if (!name.startsWith("/")) {
            Class cls = this;
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            String baseName = cls.getPackageName();
            if (baseName != null && !baseName.isEmpty()) {
                return baseName.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + name;
            }
            return name;
        }
        return name.substring(1);
    }

    private Constructor<T> getConstructor0(Class<?>[] parameterTypes, int which) throws NoSuchMethodException {
        if (parameterTypes == null) {
            parameterTypes = EmptyArray.CLASS;
        }
        for (Class<?> c4 : parameterTypes) {
            if (c4 == null) {
                throw new NoSuchMethodException("parameter type is null");
            }
        }
        Constructor<T> result = getDeclaredConstructorInternal(parameterTypes);
        if (result == null || (which == 0 && !Modifier.isPublic(result.getAccessFlags()))) {
            throw new NoSuchMethodException(getName() + ".<init> " + Arrays.toString(parameterTypes));
        }
        return result;
    }

    private RecordComponent[] getRecordComponents0() {
        RecordComponents libcoreComponents = new RecordComponents(this);
        String[] names = libcoreComponents.getNames();
        Class<?>[] types = libcoreComponents.getTypes();
        if (names == null || types == null) {
            return new RecordComponent[0];
        }
        int size = Math.min(names.length, types.length);
        RecordComponent[] components = new RecordComponent[size];
        for (int i10 = 0; i10 < size; i10++) {
            String name = names[i10];
            Class<?> type = types[i10];
            components[i10] = new RecordComponent(this, name, type, libcoreComponents, i10);
        }
        return components;
    }

    public boolean desiredAssertionStatus() {
        return false;
    }

    public boolean isEnum() {
        return (getModifiers() & 16384) != 0 && getSuperclass() == Enum.class;
    }

    public boolean isRecord() {
        return getSuperclass() == Record.class && (getModifiers() & 16) != 0 && isRecord0();
    }

    public T[] getEnumConstants() {
        T[] enumConstantsShared = getEnumConstantsShared();
        if (enumConstantsShared != null) {
            return (T[]) ((Object[]) enumConstantsShared.clone());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] getEnumConstantsShared() {
        if (isEnum()) {
            return (T[]) Enum.getSharedConstants(this);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T cast(Object obj) {
        if (obj != 0 && !isInstance(obj)) {
            throw new ClassCastException(cannotCastMsg(obj));
        }
        return obj;
    }

    private String cannotCastMsg(Object obj) {
        return "Cannot cast " + obj.getClass().getName() + " to " + getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        if (clazz.isAssignableFrom(this)) {
            return this;
        }
        throw new ClassCastException(toString() + " cannot be cast to " + clazz.getName());
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Objects.requireNonNull(cls);
        A a10 = (A) getDeclaredAnnotation(cls);
        if (a10 != null) {
            return a10;
        }
        if (cls.isDeclaredAnnotationPresent(Inherited.class)) {
            for (Class<? super T> superclass = getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                A a11 = (A) superclass.getDeclaredAnnotation(cls);
                if (a11 != null) {
                    return a11;
                }
            }
            return null;
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        if (annotationClass == null) {
            throw new NullPointerException("annotationClass == null");
        }
        if (isDeclaredAnnotationPresent(annotationClass)) {
            return true;
        }
        if (annotationClass.isDeclaredAnnotationPresent(Inherited.class)) {
            for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
                if (sup.isDeclaredAnnotationPresent(annotationClass)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        Class<? super T> superclass;
        A[] aArr = (A[]) super.getAnnotationsByType(cls);
        if (aArr.length != 0) {
            return aArr;
        }
        if (cls.isDeclaredAnnotationPresent(Inherited.class) && (superclass = getSuperclass()) != null) {
            return (A[]) superclass.getAnnotationsByType(cls);
        }
        return (A[]) ((Annotation[]) Array.newInstance((Class<?>) cls, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        Objects.requireNonNull(cls);
        return (A[]) super.getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        HashMap<Class<?>, Annotation> map = new HashMap<>();
        for (Annotation declaredAnnotation : getDeclaredAnnotations()) {
            map.put(declaredAnnotation.annotationType(), declaredAnnotation);
        }
        for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
            for (Annotation declaredAnnotation2 : sup.getDeclaredAnnotations()) {
                Class<? extends Annotation> clazz = declaredAnnotation2.annotationType();
                if (!map.containsKey(clazz) && clazz.isDeclaredAnnotationPresent(Inherited.class)) {
                    map.put(clazz, declaredAnnotation2);
                }
            }
        }
        Collection<Annotation> coll = map.values();
        return (Annotation[]) coll.toArray(new Annotation[coll.size()]);
    }

    private String getSignatureAttribute() {
        String[] annotation = getSignatureAnnotation();
        if (annotation == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (String s2 : annotation) {
            result.append(s2);
        }
        return result.toString();
    }

    public boolean isProxy() {
        return (this.accessFlags & 262144) != 0;
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Class<?> getNestHost() {
        if (isPrimitive() || isArray() || Void.TYPE.equals(this)) {
            return this;
        }
        Class host = getNestHostFromAnnotation();
        if (host == null) {
            return this;
        }
        return nestHostHasMember(host, this) ? host : this;
    }

    private static boolean nestHostHasMember(Class<?> host, Class<?> member) {
        if (host.equals(member)) {
            return true;
        }
        return nestMembersIncludeMember(host.getNestMembersFromAnnotation(), member);
    }

    private static boolean nestMembersIncludeMember(Class<?>[] members, Class<?> member) {
        if (members == null) {
            return false;
        }
        for (Class<?> cls : members) {
            if (member.equals(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNestmateOf(Class<?> c4) {
        if (this == c4) {
            return true;
        }
        return (isPrimitive() || isArray() || c4.isPrimitive() || c4.isArray() || getNestHost() != c4.getNestHost()) ? false : true;
    }

    public Class<?>[] getNestMembers() {
        if (isPrimitive() || isArray() || Void.TYPE.equals(this)) {
            return new Class[]{this};
        }
        Class host = getNestHostFromAnnotation();
        if (host != null && !host.equals(this)) {
            if (host.isPrimitive() || host.isArray() || Void.TYPE.equals(host)) {
                return new Class[]{this};
            }
            return host.getNestMembers(this);
        }
        return getNestMembers(this);
    }

    private Class<?>[] getNestMembers(Class<?> originatingMember) {
        Class[] members = getNestMembersFromAnnotation();
        if (members == null) {
            return new Class[]{originatingMember};
        }
        if (originatingMember != this && !nestMembersIncludeMember(members, originatingMember)) {
            return new Class[]{originatingMember};
        }
        Class[] result = new Class[members.length + 1];
        result[0] = this;
        int idx = 1;
        for (Class m10 : members) {
            if (m10 != null && equals(m10.getNestHostFromAnnotation())) {
                result[idx] = m10;
                idx++;
            }
        }
        if (idx < result.length) {
            Class[] tmp = new Class[idx];
            for (int i10 = 0; i10 < tmp.length; i10++) {
                tmp[i10] = result[i10];
            }
            return tmp;
        }
        return result;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class Caches {
        private static final BasicLruCache<Class, Type[]> genericInterfaces = new BasicLruCache<>(8);

        private Caches() {
        }
    }

    public Class<?>[] getPermittedSubclasses() {
        Class<?>[] subClasses;
        if (isArray() || isPrimitive() || Modifier.isFinal(getModifiers()) || (subClasses = getPermittedSubclassesFromAnnotation()) == null) {
            return null;
        }
        int directSubClassCount = getDirectSubClassCount(subClasses);
        if (directSubClassCount >= subClasses.length) {
            return subClasses;
        }
        Class[] tmp = new Class[directSubClassCount];
        int idx = 0;
        for (Class<?> c4 : subClasses) {
            if (isDirectSubType(c4)) {
                tmp[idx] = c4;
                idx++;
            }
        }
        return tmp;
    }

    private int getDirectSubClassCount(Class<?>[] subClasses) {
        int result = 0;
        for (Class<?> c4 : subClasses) {
            if (isDirectSubType(c4)) {
                result++;
            }
        }
        return result;
    }

    private boolean isDirectSubType(Class<?> c4) {
        if (!isInterface()) {
            return c4.getSuperclass() == this;
        }
        for (Class<?> i10 : c4.getInterfaces()) {
            if (i10 == this) {
                return true;
            }
        }
        return false;
    }

    public boolean isSealed() {
        return (isArray() || isPrimitive() || getPermittedSubclasses() == null) ? false : true;
    }
}
