package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        int i11;
        Object obj3;
        boolean z10;
        SerializeWriter serializeWriter = jSONSerializer.out;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        boolean z11 = serializeWriter.isEnabled(serializerFeature) || SerializerFeature.isEnabled(i10, serializerFeature);
        SerializeWriter serializeWriter2 = jSONSerializer.out;
        Type collectionItemType = z11 ? TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            serializeWriter2.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            serializeWriter2.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            char c4 = ',';
            if (serializeWriter2.isEnabled(SerializerFeature.PrettyFormat)) {
                serializeWriter2.append('[');
                jSONSerializer.incrementIndent();
                int i12 = 0;
                for (Object obj4 : list) {
                    if (i12 != 0) {
                        serializeWriter2.append(c4);
                    }
                    jSONSerializer.println();
                    if (obj4 != null) {
                        if (jSONSerializer.containsReference(obj4)) {
                            jSONSerializer.writeReference(obj4);
                        } else {
                            ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(obj4.getClass());
                            jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                            objectWriter.write(jSONSerializer, obj4, Integer.valueOf(i12), collectionItemType, i10);
                        }
                    } else {
                        jSONSerializer.out.writeNull();
                    }
                    i12++;
                    c4 = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter2.append(']');
                return;
            }
            char c10 = ']';
            serializeWriter2.append('[');
            int size = list.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj5 = list.get(i13);
                if (i13 != 0) {
                    serializeWriter2.append(',');
                }
                if (obj5 == null) {
                    serializeWriter2.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        serializeWriter2.writeInt(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj5).longValue();
                        if (z11) {
                            serializeWriter2.writeLong(longValue);
                            serializeWriter2.write(76);
                        } else {
                            serializeWriter2.writeLong(longValue);
                        }
                    } else {
                        if ((SerializerFeature.DisableCircularReferenceDetect.mask & i10) != 0) {
                            i11 = i13;
                            jSONSerializer.getObjectWriter(obj5.getClass()).write(jSONSerializer, obj5, Integer.valueOf(i13), collectionItemType, i10);
                            z10 = z11;
                        } else {
                            i11 = i13;
                            if (serializeWriter2.disableCircularReferenceDetect) {
                                obj3 = obj5;
                                z10 = z11;
                            } else {
                                obj3 = obj5;
                                z10 = z11;
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                            }
                            if (jSONSerializer.containsReference(obj3)) {
                                jSONSerializer.writeReference(obj3);
                            } else {
                                ObjectSerializer objectWriter2 = jSONSerializer.getObjectWriter(obj3.getClass());
                                if ((SerializerFeature.WriteClassName.mask & i10) != 0 && (objectWriter2 instanceof JavaBeanSerializer)) {
                                    ((JavaBeanSerializer) objectWriter2).writeNoneASM(jSONSerializer, obj3, Integer.valueOf(i11), collectionItemType, i10);
                                } else {
                                    objectWriter2.write(jSONSerializer, obj3, Integer.valueOf(i11), collectionItemType, i10);
                                }
                            }
                        }
                        i13 = i11 + 1;
                        z11 = z10;
                        c10 = ']';
                    }
                }
                i11 = i13;
                z10 = z11;
                i13 = i11 + 1;
                z11 = z10;
                c10 = ']';
            }
            serializeWriter2.append(c10);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
