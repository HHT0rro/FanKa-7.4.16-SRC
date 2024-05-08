package com.alibaba.security.common.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ArraySerializer implements ObjectSerializer {
    private final ObjectSerializer compObjectSerializer;
    private final Class<?> componentType;

    public ArraySerializer(Class<?> cls, ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
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
        int i10 = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i10 < zArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            serializeWriter.writeString(new String((char[]) obj));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                serializeWriter.append((CharSequence) "[]");
                return;
            }
            serializeWriter.write(91);
            while (i10 < length) {
                double d10 = dArr[i10];
                if (Double.isNaN(d10)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Double.toString(d10));
                }
                serializeWriter.write(44);
                i10++;
            }
            double d11 = dArr[length];
            if (Double.isNaN(d11)) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.append((CharSequence) Double.toString(d11));
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length - 1;
            if (length2 == -1) {
                serializeWriter.append((CharSequence) "[]");
                return;
            }
            serializeWriter.write(91);
            while (i10 < length2) {
                float f10 = fArr[i10];
                if (Float.isNaN(f10)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f10));
                }
                serializeWriter.write(44);
                i10++;
            }
            float f11 = fArr[length2];
            if (Float.isNaN(f11)) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.append((CharSequence) Float.toString(f11));
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i10 < iArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i10 < jArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i10 < sArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length3 = objArr.length;
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            while (i10 < length3) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                Object obj3 = objArr[i10];
                if (obj3 == null) {
                    if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        serializeWriter.writeString("");
                    } else {
                        serializeWriter.append((CharSequence) "null");
                    }
                } else if (obj3.getClass() == this.componentType) {
                    this.compObjectSerializer.write(jSONSerializer, obj3, Integer.valueOf(i10), null);
                } else {
                    jSONSerializer.config.get(obj3.getClass()).write(jSONSerializer, obj3, Integer.valueOf(i10), null);
                }
                i10++;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
