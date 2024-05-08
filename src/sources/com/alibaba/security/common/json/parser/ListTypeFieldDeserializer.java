package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPJSONArray;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.deserializer.FieldDeserializer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.ParameterizedTypeImpl;
import com.alibaba.security.common.json.util.RPFieldInfo;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ListTypeFieldDeserializer extends FieldDeserializer {
    private final boolean array;
    private ObjectDeserializer deserializer;
    private final Type itemType;

    public ListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, RPFieldInfo rPFieldInfo) {
        super(cls, rPFieldInfo, 14);
        Type type = rPFieldInfo.fieldType;
        Class<?> cls2 = rPFieldInfo.fieldClass;
        if (cls2.isArray()) {
            this.itemType = cls2.getComponentType();
            this.array = true;
        } else {
            this.itemType = RPTypeUtils.getCollectionItemType(type);
            this.array = false;
        }
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i10;
        int i11;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i11 = 0;
                    while (i11 < length) {
                        if (cls.getTypeParameters()[i11].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                i11 = -1;
                if (i11 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i11];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
                    }
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                    if (cls != null) {
                        int length2 = cls.getTypeParameters().length;
                        i10 = 0;
                        while (i10 < length2) {
                            if (cls.getTypeParameters()[i10].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i10++;
                            }
                        }
                    }
                    i10 = -1;
                    if (i10 != -1) {
                        actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i10];
                        type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (objectDeserializer == null) {
            objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
            this.deserializer = objectDeserializer;
        }
        int i12 = jSONLexer.token;
        if (i12 != 14) {
            if (i12 == 12) {
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
                return;
            }
            String str = "exepct '[', but " + JSONToken.name(jSONLexer.token);
            if (type != null) {
                str = str + ", type : " + ((Object) type);
            }
            throw new RPJSONException(str);
        }
        int i13 = 0;
        char c4 = jSONLexer.ch;
        int i14 = 15;
        if (c4 == '[') {
            int i15 = jSONLexer.bp + 1;
            jSONLexer.bp = i15;
            jSONLexer.ch = i15 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i15);
            jSONLexer.token = 14;
        } else if (c4 == '{') {
            int i16 = jSONLexer.bp + 1;
            jSONLexer.bp = i16;
            jSONLexer.ch = i16 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i16);
            jSONLexer.token = 12;
        } else if (c4 == '\"') {
            jSONLexer.scanString();
        } else if (c4 == ']') {
            int i17 = jSONLexer.bp + 1;
            jSONLexer.bp = i17;
            jSONLexer.ch = i17 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i17);
            jSONLexer.token = 15;
        } else {
            jSONLexer.nextToken();
        }
        while (true) {
            int i18 = jSONLexer.token;
            if (i18 == 16) {
                jSONLexer.nextToken();
            } else {
                if (i18 == i14) {
                    break;
                }
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, Integer.valueOf(i13)));
                if (defaultJSONParser.resolveStatus == 1) {
                    defaultJSONParser.checkListResolve(collection);
                }
                if (jSONLexer.token == 16) {
                    char c10 = jSONLexer.ch;
                    if (c10 == '[') {
                        int i19 = jSONLexer.bp + 1;
                        jSONLexer.bp = i19;
                        jSONLexer.ch = i19 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i19);
                        jSONLexer.token = 14;
                    } else if (c10 == '{') {
                        int i20 = jSONLexer.bp + 1;
                        jSONLexer.bp = i20;
                        jSONLexer.ch = i20 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i20);
                        jSONLexer.token = 12;
                    } else if (c10 == '\"') {
                        jSONLexer.scanString();
                    } else {
                        jSONLexer.nextToken();
                    }
                }
                i13++;
                i14 = 15;
            }
        }
        if (jSONLexer.ch == ',') {
            int i21 = jSONLexer.bp + 1;
            jSONLexer.bp = i21;
            jSONLexer.ch = i21 < jSONLexer.len ? jSONLexer.text.charAt(i21) : (char) 26;
            jSONLexer.token = 16;
            return;
        }
        jSONLexer.nextToken();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.security.common.json.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        ArrayList arrayList;
        RPJSONArray rPJSONArray;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 != 8 && (i10 != 4 || jSONLexer.stringVal().length() != 0)) {
            if (this.array) {
                RPJSONArray rPJSONArray2 = new RPJSONArray();
                rPJSONArray2.setComponentType(this.itemType);
                rPJSONArray = rPJSONArray2;
                arrayList = rPJSONArray2;
            } else {
                arrayList = new ArrayList();
                rPJSONArray = null;
            }
            ParseContext parseContext = defaultJSONParser.contex;
            defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
            parseArray(defaultJSONParser, type, arrayList);
            defaultJSONParser.setContext(parseContext);
            Object obj2 = arrayList;
            if (this.array) {
                Object array = arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.itemType, arrayList.size()));
                rPJSONArray.setRelatedArray(array);
                obj2 = array;
            }
            if (obj == null) {
                map.put(this.fieldInfo.name, obj2);
                return;
            } else {
                setValue(obj, obj2);
                return;
            }
        }
        setValue(obj, (Object) null);
        defaultJSONParser.lexer.nextToken();
    }
}
