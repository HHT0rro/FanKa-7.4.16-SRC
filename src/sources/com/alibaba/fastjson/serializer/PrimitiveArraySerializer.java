package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i11 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i11 < iArr.length) {
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i11]);
                i11++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i11 < sArr.length) {
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i11]);
                i11++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i11 < jArr.length) {
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i11]);
                i11++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i11 < zArr.length) {
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i11]);
                i11++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i11 < fArr.length) {
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                float f10 = fArr[i11];
                if (Float.isNaN(f10)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f10));
                }
                i11++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            serializeWriter.write(91);
            while (i11 < dArr.length) {
                if (i11 != 0) {
                    serializeWriter.write(44);
                }
                double d10 = dArr[i11];
                if (Double.isNaN(d10)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Double.toString(d10));
                }
                i11++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
        } else {
            serializeWriter.writeString((char[]) obj);
        }
    }
}
