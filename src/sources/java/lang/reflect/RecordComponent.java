package java.lang.reflect;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.RecordComponents;
import libcore.util.EmptyArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class RecordComponent implements AnnotatedElement {
    private Method accessor;
    private Class<?> clazz;
    private volatile transient Map<Class<? extends Annotation>, Annotation> declaredAnnotations;
    private String name;
    private RecordComponents parent;
    private int selfIndex;
    private String signature;
    private Class<?> type;

    public RecordComponent(Class<?> clazz, String name, Class<?> type, RecordComponents parent, int selfIndex) {
        this.clazz = clazz;
        this.name = name;
        this.type = type;
        this.parent = parent;
        this.selfIndex = selfIndex;
        this.signature = parent.getGenericSignature(selfIndex);
        if (name != null) {
            try {
                this.accessor = clazz.getDeclaredMethod(name, new Class[0]);
            } catch (NoSuchMethodException e2) {
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.type;
    }

    public String getGenericSignature() {
        return this.signature;
    }

    public Type getGenericType() {
        String signatureAttribute = getGenericSignature();
        ClassLoader cl = this.clazz.getClassLoader();
        GenericSignatureParser parser = new GenericSignatureParser(cl);
        parser.parseForField(this.clazz, signatureAttribute);
        Type genericType = parser.fieldType;
        if (genericType == null) {
            return getType();
        }
        return genericType;
    }

    public Method getAccessor() {
        return this.accessor;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        Objects.requireNonNull(annotationClass);
        return annotationClass.cast(declaredAnnotations().get(annotationClass));
    }

    private Map<Class<? extends Annotation>, Annotation> declaredAnnotations() {
        Map<Class<? extends Annotation>, Annotation> map = this.declaredAnnotations;
        Map<Class<? extends Annotation>, Annotation> declAnnos = map;
        if (map == null) {
            synchronized (this) {
                Map<Class<? extends Annotation>, Annotation> map2 = this.declaredAnnotations;
                declAnnos = map2;
                if (map2 == null) {
                    Annotation[] annotations = this.parent.getVisibleAnnotations(this.selfIndex);
                    if (annotations == null) {
                        annotations = EmptyArray.ANNOTATION;
                    }
                    declAnnos = new HashMap(annotations.length);
                    for (Annotation a10 : annotations) {
                        declAnnos.put(a10.annotationType(), a10);
                    }
                    this.declaredAnnotations = declAnnos;
                }
            }
        }
        return declAnnos;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) declaredAnnotations().values().toArray(EmptyArray.ANNOTATION);
    }

    public String toString() {
        return getType().getTypeName() + " " + getName();
    }

    public Class<?> getDeclaringRecord() {
        return this.clazz;
    }
}
