package java.lang.reflect;

import dalvik.annotation.optimization.FastNative;
import java.lang.annotation.Annotation;
import java.util.Objects;
import libcore.reflect.AnnotatedElements;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.ListOfTypes;
import libcore.reflect.Types;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Executable extends AccessibleObject implements Member, GenericDeclaration {
    private int accessFlags;
    private long artMethod;
    private Class<?> declaringClass;
    private Class<?> declaringClassOfOverriddenMethod;
    private int dexMethodIndex;
    private volatile transient boolean hasRealParameterData;
    private volatile transient Parameter[] parameters;

    @FastNative
    private native <T extends Annotation> T getAnnotationNative(Class<T> cls);

    @FastNative
    private native Annotation[] getDeclaredAnnotationsNative();

    @FastNative
    private native Annotation[][] getParameterAnnotationsNative();

    @FastNative
    private native Parameter[] getParameters0();

    @FastNative
    private native String[] getSignatureAnnotation();

    @FastNative
    private native boolean isAnnotationPresentNative(Class<? extends Annotation> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public native int compareMethodParametersInternal(Method method);

    public abstract Class<?> getDeclaringClass();

    public abstract Class<?>[] getExceptionTypes();

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public final native String getMethodNameInternal();

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public final native Class<?> getMethodReturnTypeInternal();

    public abstract int getModifiers();

    public abstract String getName();

    public abstract Annotation[][] getParameterAnnotations();

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public final native int getParameterCountInternal();

    public abstract Class<?>[] getParameterTypes();

    /* JADX INFO: Access modifiers changed from: package-private */
    @FastNative
    public final native Class<?>[] getParameterTypesInternal();

    public abstract TypeVariable<?>[] getTypeParameters();

    abstract boolean hasGenericInformation();

    abstract void specificToGenericStringHeader(StringBuilder sb2);

    abstract void specificToStringHeader(StringBuilder sb2);

    public abstract String toGenericString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equalParamTypes(Class<?>[] params1, Class<?>[] params2) {
        if (params1.length != params2.length) {
            return false;
        }
        for (int i10 = 0; i10 < params1.length; i10++) {
            if (params1[i10] != params2[i10]) {
                return false;
            }
        }
        return true;
    }

    void separateWithCommas(Class<?>[] types, StringBuilder sb2) {
        for (int j10 = 0; j10 < types.length; j10++) {
            sb2.append(types[j10].getTypeName());
            if (j10 < types.length - 1) {
                sb2.append(",");
            }
        }
    }

    void printModifiersIfNonzero(StringBuilder sb2, int mask, boolean isDefault) {
        int mod = getModifiers() & mask;
        if (mod != 0 && !isDefault) {
            sb2.append(Modifier.toString(mod)).append(' ');
            return;
        }
        int access_mod = mod & 7;
        if (access_mod != 0) {
            sb2.append(Modifier.toString(access_mod)).append(' ');
        }
        if (isDefault) {
            sb2.append("default ");
        }
        int mod2 = mod & (-8);
        if (mod2 != 0) {
            sb2.append(Modifier.toString(mod2)).append(' ');
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sharedToString(int modifierMask, boolean isDefault, Class<?>[] parameterTypes, Class<?>[] exceptionTypes) {
        try {
            StringBuilder sb2 = new StringBuilder();
            printModifiersIfNonzero(sb2, modifierMask, isDefault);
            specificToStringHeader(sb2);
            sb2.append('(');
            separateWithCommas(parameterTypes, sb2);
            sb2.append(')');
            if (exceptionTypes.length > 0) {
                sb2.append(" throws ");
                separateWithCommas(exceptionTypes, sb2);
            }
            return sb2.toString();
        } catch (Exception e2) {
            return "<" + ((Object) e2) + ">";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sharedToGenericString(int modifierMask, boolean isDefault) {
        String obj;
        try {
            StringBuilder sb2 = new StringBuilder();
            printModifiersIfNonzero(sb2, modifierMask, isDefault);
            TypeVariable<?>[] typeparms = getTypeParameters();
            if (typeparms.length > 0) {
                boolean first = true;
                sb2.append('<');
                for (TypeVariable<?> typeparm : typeparms) {
                    if (!first) {
                        sb2.append(',');
                    }
                    sb2.append(typeparm.toString());
                    first = false;
                }
                sb2.append("> ");
            }
            specificToGenericStringHeader(sb2);
            sb2.append('(');
            Type[] params = getGenericParameterTypes();
            for (int j10 = 0; j10 < params.length; j10++) {
                String param = params[j10].getTypeName();
                if (isVarArgs() && j10 == params.length - 1) {
                    param = param.replaceFirst("\\[\\]$", "...");
                }
                sb2.append(param);
                if (j10 < params.length - 1) {
                    sb2.append(',');
                }
            }
            sb2.append(')');
            Type[] exceptions = getGenericExceptionTypes();
            if (exceptions.length > 0) {
                sb2.append(" throws ");
                for (int k10 = 0; k10 < exceptions.length; k10++) {
                    if (exceptions[k10] instanceof Class) {
                        obj = ((Class) exceptions[k10]).getName();
                    } else {
                        obj = exceptions[k10].toString();
                    }
                    sb2.append(obj);
                    if (k10 < exceptions.length - 1) {
                        sb2.append(',');
                    }
                }
            }
            return sb2.toString();
        } catch (Exception e2) {
            return "<" + ((Object) e2) + ">";
        }
    }

    public int getParameterCount() {
        throw new AbstractMethodError();
    }

    public Type[] getGenericParameterTypes() {
        return Types.getTypeArray(getMethodOrConstructorGenericInfoInternal().genericParameterTypes, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] getAllGenericParameterTypes() {
        boolean genericInfo = hasGenericInformation();
        if (!genericInfo) {
            return getParameterTypes();
        }
        boolean realParamData = hasRealParameterData();
        Type[] genericParamTypes = getGenericParameterTypes();
        Type[] nonGenericParamTypes = getParameterTypes();
        Type[] out = new Type[nonGenericParamTypes.length];
        Parameter[] params = getParameters();
        int fromidx = 0;
        if (!realParamData) {
            return genericParamTypes.length == nonGenericParamTypes.length ? genericParamTypes : nonGenericParamTypes;
        }
        for (int i10 = 0; i10 < out.length; i10++) {
            Parameter param = params[i10];
            if (param.isSynthetic() || param.isImplicit()) {
                out[i10] = nonGenericParamTypes[i10];
            } else {
                out[i10] = genericParamTypes[fromidx];
                fromidx++;
            }
        }
        return out;
    }

    public Parameter[] getParameters() {
        return (Parameter[]) privateGetParameters().clone();
    }

    private Parameter[] synthesizeAllParams() {
        int realparams = getParameterCount();
        Parameter[] out = new Parameter[realparams];
        for (int i10 = 0; i10 < realparams; i10++) {
            out[i10] = new Parameter("arg" + i10, 0, this, i10);
        }
        return out;
    }

    private void verifyParameters(Parameter[] parameters) {
        if (getParameterTypes().length != parameters.length) {
            throw new MalformedParametersException("Wrong number of parameters in MethodParameters attribute");
        }
        for (Parameter parameter : parameters) {
            String name = parameter.getRealName();
            int mods = parameter.getModifiers();
            if (name != null && (name.isEmpty() || name.indexOf(46) != -1 || name.indexOf(59) != -1 || name.indexOf(91) != -1 || name.indexOf(47) != -1)) {
                throw new MalformedParametersException("Invalid parameter name \"" + name + "\"");
            }
            if (mods != (36880 & mods)) {
                throw new MalformedParametersException("Invalid parameter modifiers");
            }
        }
    }

    private Parameter[] privateGetParameters() {
        Parameter[] tmp = this.parameters;
        if (tmp == null) {
            try {
                tmp = getParameters0();
                if (tmp == null) {
                    this.hasRealParameterData = false;
                    tmp = synthesizeAllParams();
                } else {
                    this.hasRealParameterData = true;
                    verifyParameters(tmp);
                }
                this.parameters = tmp;
            } catch (IllegalArgumentException e2) {
                MalformedParametersException e22 = new MalformedParametersException("Invalid parameter metadata in class file");
                e22.initCause(e2);
                throw e22;
            }
        }
        return tmp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasRealParameterData() {
        if (this.parameters == null) {
            privateGetParameters();
        }
        return this.hasRealParameterData;
    }

    public Type[] getGenericExceptionTypes() {
        return Types.getTypeArray(getMethodOrConstructorGenericInfoInternal().genericExceptionTypes, false);
    }

    public boolean isVarArgs() {
        return (this.accessFlags & 128) != 0;
    }

    public boolean isSynthetic() {
        return (this.accessFlags & 4096) != 0;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Objects.requireNonNull(cls);
        return (T) getAnnotationNative(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T[] getAnnotationsByType(Class<T> cls) {
        return (T[]) AnnotatedElements.getDirectOrIndirectAnnotationsByType(this, cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return getDeclaredAnnotationsNative();
    }

    private static int fixMethodFlags(int flags) {
        if ((flags & 1024) != 0) {
            flags &= -257;
        }
        int flags2 = flags & (-33);
        if ((flags2 & 131072) != 0) {
            flags2 |= 32;
        }
        return 65535 & flags2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getModifiersInternal() {
        return fixMethodFlags(this.accessFlags);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<?> getDeclaringClassInternal() {
        return this.declaringClass;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        Objects.requireNonNull(annotationType);
        return isAnnotationPresentNative(annotationType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Annotation[][] getParameterAnnotationsInternal() {
        Annotation[][] parameterAnnotations = getParameterAnnotationsNative();
        if (parameterAnnotations == null) {
            return (Annotation[][]) Array.newInstance((Class<?>) Annotation.class, getParameterTypes().length, 0);
        }
        return parameterAnnotations;
    }

    public final int getAccessFlags() {
        return this.accessFlags;
    }

    public final long getArtMethod() {
        return this.artMethod;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class GenericInfo {
        final TypeVariable<?>[] formalTypeParameters;
        final ListOfTypes genericExceptionTypes;
        final ListOfTypes genericParameterTypes;
        final Type genericReturnType;

        GenericInfo(ListOfTypes exceptions, ListOfTypes parameters, Type ret, TypeVariable<?>[] formal) {
            this.genericExceptionTypes = exceptions;
            this.genericParameterTypes = parameters;
            this.genericReturnType = ret;
            this.formalTypeParameters = formal;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasGenericInformationInternal() {
        return getSignatureAnnotation() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GenericInfo getMethodOrConstructorGenericInfoInternal() {
        String signatureAttribute = getSignatureAttribute();
        Class<?>[] exceptionTypes = getExceptionTypes();
        GenericSignatureParser parser = new GenericSignatureParser(getDeclaringClass().getClassLoader());
        if (this instanceof Method) {
            parser.parseForMethod(this, signatureAttribute, exceptionTypes);
        } else {
            parser.parseForConstructor(this, signatureAttribute, exceptionTypes);
        }
        return new GenericInfo(parser.exceptionTypes, parser.parameterTypes, parser.returnType, parser.formalTypeParameters);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean equalNameAndParametersInternal(Method m10) {
        return getName().equals(m10.getName()) && compareMethodParametersInternal(m10) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDefaultMethodInternal() {
        return (this.accessFlags & 4194304) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isBridgeMethodInternal() {
        return (this.accessFlags & 64) != 0;
    }
}
