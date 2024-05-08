package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSONArray;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    private CollectionCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.alibaba.security.common.json.RPJSONArray, T, java.util.Collection] */
    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Collection collection;
        Type type2;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        if (type == RPJSONArray.class) {
            ?? r42 = (T) new RPJSONArray();
            defaultJSONParser.parseArray((Collection) r42);
            return r42;
        }
        Type type3 = type;
        while (!(type3 instanceof Class)) {
            if (type3 instanceof ParameterizedType) {
                type3 = ((ParameterizedType) type3).getRawType();
            } else {
                throw new RPJSONException("TODO");
            }
        }
        Class cls = (Class) type3;
        if (cls != AbstractCollection.class && cls != Collection.class) {
            if (cls.isAssignableFrom(HashSet.class)) {
                collection = (T) new HashSet();
            } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
                collection = (T) new LinkedHashSet();
            } else if (cls.isAssignableFrom(TreeSet.class)) {
                collection = (T) new TreeSet();
            } else if (cls.isAssignableFrom(ArrayList.class)) {
                collection = (T) new ArrayList();
            } else if (cls.isAssignableFrom(EnumSet.class)) {
                if (type instanceof ParameterizedType) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    type2 = Object.class;
                }
                collection = (T) EnumSet.noneOf((Class) type2);
            } else {
                try {
                    collection = (T) ((Collection) cls.newInstance());
                } catch (Exception unused) {
                    throw new RPJSONException("create instane error, class " + cls.getName());
                }
            }
        } else {
            collection = (T) new ArrayList();
        }
        defaultJSONParser.parseArray(RPTypeUtils.getCollectionItemType(type), collection, obj);
        return (T) collection;
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int i10 = serializeWriter.features;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        Type collectionItemType = (i10 & serializerFeature.mask) != 0 ? RPTypeUtils.getCollectionItemType(type) : null;
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        int i11 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if ((serializeWriter.features & serializerFeature.mask) != 0) {
            if (HashSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "Set");
            } else if (TreeSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.write(91);
            for (Object obj3 : collection) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) obj3).longValue());
                        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer.config.get(cls).write(jSONSerializer, obj3, Integer.valueOf(i12 - 1), collectionItemType);
                    }
                }
                i11 = i12;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
