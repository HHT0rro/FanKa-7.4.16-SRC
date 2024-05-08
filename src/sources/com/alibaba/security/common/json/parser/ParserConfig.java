package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPPropertyNamingStrategy;
import com.alibaba.security.common.json.annotation.RPJSONType;
import com.alibaba.security.common.json.parser.deserializer.FieldDeserializer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.serializer.ArrayCodec;
import com.alibaba.security.common.json.serializer.BigDecimalCodec;
import com.alibaba.security.common.json.serializer.BooleanCodec;
import com.alibaba.security.common.json.serializer.CollectionCodec;
import com.alibaba.security.common.json.serializer.DateCodec;
import com.alibaba.security.common.json.serializer.IntegerCodec;
import com.alibaba.security.common.json.serializer.MiscCodec;
import com.alibaba.security.common.json.serializer.NumberCodec;
import com.alibaba.security.common.json.serializer.StringCodec;
import com.alibaba.security.common.json.util.IdentityHashMap;
import com.alibaba.security.common.json.util.RPFieldInfo;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ParserConfig {
    public static ParserConfig global = new ParserConfig();
    public ClassLoader defaultClassLoader;
    private final IdentityHashMap<ObjectDeserializer> derializers;
    public RPPropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;

    public ParserConfig() {
        IdentityHashMap<ObjectDeserializer> identityHashMap = new IdentityHashMap<>(1024);
        this.derializers = identityHashMap;
        this.symbolTable = new SymbolTable(16384);
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        DateCodec dateCodec = DateCodec.instance;
        identityHashMap.put(Date.class, dateCodec);
        identityHashMap.put(Calendar.class, dateCodec);
        identityHashMap.put(Map.class, MapDeserializer.instance);
        identityHashMap.put(HashMap.class, MapDeserializer.instance);
        identityHashMap.put(LinkedHashMap.class, MapDeserializer.instance);
        identityHashMap.put(TreeMap.class, MapDeserializer.instance);
        identityHashMap.put(ConcurrentMap.class, MapDeserializer.instance);
        identityHashMap.put(ConcurrentHashMap.class, MapDeserializer.instance);
        CollectionCodec collectionCodec = CollectionCodec.instance;
        identityHashMap.put(Collection.class, collectionCodec);
        identityHashMap.put(List.class, collectionCodec);
        identityHashMap.put(ArrayList.class, collectionCodec);
        JavaObjectDeserializer javaObjectDeserializer = JavaObjectDeserializer.instance;
        identityHashMap.put(Object.class, javaObjectDeserializer);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Character.TYPE, miscCodec);
        identityHashMap.put(Character.class, miscCodec);
        Class<Byte> cls = Byte.TYPE;
        NumberCodec numberCodec = NumberCodec.instance;
        identityHashMap.put(cls, numberCodec);
        identityHashMap.put(Byte.class, numberCodec);
        identityHashMap.put(Short.TYPE, numberCodec);
        identityHashMap.put(Short.class, numberCodec);
        identityHashMap.put(Integer.TYPE, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.TYPE, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        BigDecimalCodec bigDecimalCodec = BigDecimalCodec.instance;
        identityHashMap.put(BigInteger.class, bigDecimalCodec);
        identityHashMap.put(BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(Float.TYPE, numberCodec);
        identityHashMap.put(Float.class, numberCodec);
        identityHashMap.put(Double.TYPE, numberCodec);
        identityHashMap.put(Double.class, numberCodec);
        Class<Boolean> cls2 = Boolean.TYPE;
        BooleanCodec booleanCodec = BooleanCodec.instance;
        identityHashMap.put(cls2, booleanCodec);
        identityHashMap.put(Boolean.class, booleanCodec);
        identityHashMap.put(Class.class, miscCodec);
        ArrayCodec arrayCodec = ArrayCodec.instance;
        identityHashMap.put(char[].class, arrayCodec);
        identityHashMap.put(Object[].class, arrayCodec);
        identityHashMap.put(UUID.class, miscCodec);
        identityHashMap.put(TimeZone.class, miscCodec);
        identityHashMap.put(Locale.class, miscCodec);
        identityHashMap.put(Currency.class, miscCodec);
        identityHashMap.put(URI.class, miscCodec);
        identityHashMap.put(URL.class, miscCodec);
        identityHashMap.put(Pattern.class, miscCodec);
        identityHashMap.put(Charset.class, miscCodec);
        identityHashMap.put(Number.class, numberCodec);
        identityHashMap.put(StackTraceElement.class, miscCodec);
        identityHashMap.put(Serializable.class, javaObjectDeserializer);
        identityHashMap.put(Cloneable.class, javaObjectDeserializer);
        identityHashMap.put(Comparable.class, javaObjectDeserializer);
        identityHashMap.put(Closeable.class, javaObjectDeserializer);
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, RPFieldInfo rPFieldInfo) {
        Class<?> cls2 = rPFieldInfo.fieldClass;
        if (cls2 != List.class && cls2 != ArrayList.class && (!cls2.isArray() || cls2.getComponentType().isPrimitive())) {
            return new DefaultFieldDeserializer(parserConfig, cls, rPFieldInfo);
        }
        return new ListTypeFieldDeserializer(parserConfig, cls, rPFieldInfo);
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.derializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return getDeserializer((Class) rawType, type);
            }
            return getDeserializer(rawType);
        }
        return JavaObjectDeserializer.instance;
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.derializers.put(type, objectDeserializer);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls, int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        ObjectDeserializer objectDeserializer = this.derializers.get(cls);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        JavaBeanDeserializer javaBeanDeserializer = new JavaBeanDeserializer(this, cls, cls, JavaBeanInfo.build(cls, i10, cls, z10, z11, z12, z13, this.propertyNamingStrategy));
        putDeserializer(cls, javaBeanDeserializer);
        return javaBeanDeserializer;
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer objectDeserializer;
        RPJSONType rPJSONType;
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer2 = this.derializers.get(type);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        if (type == null) {
            type = cls;
        }
        ObjectDeserializer objectDeserializer3 = this.derializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (!isPrimitive(cls) && (rPJSONType = (RPJSONType) cls.getAnnotation(RPJSONType.class)) != null && (mappingTo = rPJSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            objectDeserializer3 = this.derializers.get(cls);
        }
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        ObjectDeserializer objectDeserializer4 = this.derializers.get(type);
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        if (cls.isEnum()) {
            objectDeserializer = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            objectDeserializer = ArrayCodec.instance;
        } else if (cls != Set.class && cls != HashSet.class && cls != Collection.class && cls != List.class && cls != ArrayList.class) {
            if (Collection.class.isAssignableFrom(cls)) {
                objectDeserializer = CollectionCodec.instance;
            } else if (Map.class.isAssignableFrom(cls)) {
                objectDeserializer = MapDeserializer.instance;
            } else if (Throwable.class.isAssignableFrom(cls)) {
                objectDeserializer = new ThrowableDeserializer(this, cls);
            } else if (cls.getName().equals("android.net.Uri")) {
                objectDeserializer = MiscCodec.instance;
            } else {
                objectDeserializer = new JavaBeanDeserializer(this, cls, type);
            }
        } else {
            objectDeserializer = CollectionCodec.instance;
        }
        putDeserializer(type, objectDeserializer);
        return objectDeserializer;
    }
}
