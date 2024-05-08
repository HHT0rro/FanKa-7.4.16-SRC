package com.android.framework.protobuf.nano;

import com.android.framework.protobuf.nano.MapFactories;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InternalNano {
    public static final int TYPE_BOOL = 8;
    public static final int TYPE_BYTES = 12;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_ENUM = 14;
    public static final int TYPE_FIXED32 = 7;
    public static final int TYPE_FIXED64 = 6;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_GROUP = 10;
    public static final int TYPE_INT32 = 5;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_MESSAGE = 11;
    public static final int TYPE_SFIXED32 = 15;
    public static final int TYPE_SFIXED64 = 16;
    public static final int TYPE_SINT32 = 17;
    public static final int TYPE_SINT64 = 18;
    public static final int TYPE_STRING = 9;
    public static final int TYPE_UINT32 = 13;
    public static final int TYPE_UINT64 = 4;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    static final Charset ISO_8859_1 = Charset.forName(CharEncoding.ISO_8859_1);
    public static final Object LAZY_INIT_LOCK = new Object();

    private InternalNano() {
    }

    public static String stringDefaultValue(String bytes) {
        return new String(bytes.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] bytesDefaultValue(String bytes) {
        return bytes.getBytes(ISO_8859_1);
    }

    public static byte[] copyFromUtf8(String text) {
        return text.getBytes(UTF_8);
    }

    public static boolean equals(int[] field1, int[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(long[] field1, long[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(float[] field1, float[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(double[] field1, double[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(boolean[] field1, boolean[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(byte[][] field1, byte[][] field2) {
        boolean atEndOf1;
        boolean atEndOf2;
        int index1 = 0;
        int length1 = field1 == null ? 0 : field1.length;
        int index2 = 0;
        int length2 = field2 == null ? 0 : field2.length;
        while (true) {
            if (index1 < length1 && field1[index1] == null) {
                index1++;
            } else {
                while (index2 < length2 && field2[index2] == null) {
                    index2++;
                }
                if (index1 < length1) {
                    atEndOf1 = false;
                } else {
                    atEndOf1 = true;
                }
                if (index2 < length2) {
                    atEndOf2 = false;
                } else {
                    atEndOf2 = true;
                }
                if (atEndOf1 && atEndOf2) {
                    return true;
                }
                if (atEndOf1 != atEndOf2 || !Arrays.equals(field1[index1], field2[index2])) {
                    return false;
                }
                index1++;
                index2++;
            }
        }
    }

    public static boolean equals(Object[] field1, Object[] field2) {
        boolean atEndOf1;
        boolean atEndOf2;
        int index1 = 0;
        int length1 = field1 == null ? 0 : field1.length;
        int index2 = 0;
        int length2 = field2 == null ? 0 : field2.length;
        while (true) {
            if (index1 < length1 && field1[index1] == null) {
                index1++;
            } else {
                while (index2 < length2 && field2[index2] == null) {
                    index2++;
                }
                if (index1 < length1) {
                    atEndOf1 = false;
                } else {
                    atEndOf1 = true;
                }
                if (index2 < length2) {
                    atEndOf2 = false;
                } else {
                    atEndOf2 = true;
                }
                if (atEndOf1 && atEndOf2) {
                    return true;
                }
                if (atEndOf1 != atEndOf2 || !field1[index1].equals(field2[index2])) {
                    return false;
                }
                index1++;
                index2++;
            }
        }
    }

    public static int hashCode(int[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(long[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(float[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(double[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(boolean[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(byte[][] field) {
        int result = 0;
        int size = field == null ? 0 : field.length;
        for (int i10 = 0; i10 < size; i10++) {
            byte[] element = field[i10];
            if (element != null) {
                result = (result * 31) + Arrays.hashCode(element);
            }
        }
        return result;
    }

    public static int hashCode(Object[] field) {
        int result = 0;
        int size = field == null ? 0 : field.length;
        for (int i10 = 0; i10 < size; i10++) {
            Object element = field[i10];
            if (element != null) {
                result = (result * 31) + element.hashCode();
            }
        }
        return result;
    }

    private static Object primitiveDefaultValue(int type) {
        switch (type) {
            case 1:
                return Double.valueOf(ShadowDrawableWrapper.COS_45);
            case 2:
                return Float.valueOf(0.0f);
            case 3:
            case 4:
            case 6:
            case 16:
            case 18:
                return 0L;
            case 5:
            case 7:
            case 13:
            case 14:
            case 15:
            case 17:
                return 0;
            case 8:
                return Boolean.FALSE;
            case 9:
                return "";
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Type: " + type + " is not a primitive type.");
            case 12:
                return WireFormatNano.EMPTY_BYTES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> mergeMapEntry(CodedInputByteBufferNano codedInputByteBufferNano, Map<K, V> map, MapFactories.MapFactory mapFactory, int i10, int i11, V v2, int i12, int i13) throws IOException {
        Map<K, V> forMap = mapFactory.forMap(map);
        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
        Object obj = null;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
            if (readTag == i12) {
                obj = codedInputByteBufferNano.readPrimitiveField(i10);
            } else if (readTag == i13) {
                if (i11 == 11) {
                    codedInputByteBufferNano.readMessage(v2);
                } else {
                    v2 = (V) codedInputByteBufferNano.readPrimitiveField(i11);
                }
            } else if (!codedInputByteBufferNano.skipField(readTag)) {
                break;
            }
        }
        codedInputByteBufferNano.checkLastTagWas(0);
        codedInputByteBufferNano.popLimit(pushLimit);
        if (obj == null) {
            obj = primitiveDefaultValue(i10);
        }
        if (v2 == 0) {
            v2 = primitiveDefaultValue(i11);
        }
        forMap.put(obj, v2);
        return forMap;
    }

    public static <K, V> void serializeMapField(CodedOutputByteBufferNano output, Map<K, V> map, int number, int keyType, int valueType) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int entrySize = CodedOutputByteBufferNano.computeFieldSize(1, keyType, key) + CodedOutputByteBufferNano.computeFieldSize(2, valueType, value);
            output.writeTag(number, 2);
            output.writeRawVarint32(entrySize);
            output.writeField(1, keyType, key);
            output.writeField(2, valueType, value);
        }
    }

    public static <K, V> int computeMapFieldSize(Map<K, V> map, int number, int keyType, int valueType) {
        int size = 0;
        int tagSize = CodedOutputByteBufferNano.computeTagSize(number);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int entrySize = CodedOutputByteBufferNano.computeFieldSize(1, keyType, key) + CodedOutputByteBufferNano.computeFieldSize(2, valueType, value);
            size += tagSize + entrySize + CodedOutputByteBufferNano.computeRawVarint32Size(entrySize);
        }
        return size;
    }

    public static <K, V> boolean equals(Map<K, V> a10, Map<K, V> b4) {
        if (a10 == b4) {
            return true;
        }
        if (a10 == null) {
            if (b4.size() == 0) {
                return true;
            }
            return false;
        }
        if (b4 == null) {
            if (a10.size() == 0) {
                return true;
            }
            return false;
        }
        if (a10.size() != b4.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : a10.entrySet()) {
            if (!b4.containsKey(entry.getKey()) || !equalsMapValue(entry.getValue(), b4.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean equalsMapValue(Object a10, Object b4) {
        if (a10 == null || b4 == null) {
            throw new IllegalStateException("keys and values in maps cannot be null");
        }
        if ((a10 instanceof byte[]) && (b4 instanceof byte[])) {
            return Arrays.equals((byte[]) a10, (byte[]) b4);
        }
        return a10.equals(b4);
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        if (map == null) {
            return 0;
        }
        int result = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result += hashCodeForMap(entry.getKey()) ^ hashCodeForMap(entry.getValue());
        }
        return result;
    }

    private static int hashCodeForMap(Object o10) {
        if (o10 instanceof byte[]) {
            return Arrays.hashCode((byte[]) o10);
        }
        return o10.hashCode();
    }

    public static void cloneUnknownFieldData(ExtendableMessageNano original, ExtendableMessageNano cloned) {
        if (original.unknownFieldData != null) {
            cloned.unknownFieldData = original.unknownFieldData.m1999clone();
        }
    }
}
