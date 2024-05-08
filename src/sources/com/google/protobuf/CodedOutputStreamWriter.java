package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i10, boolean z10, V v2, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z10), v2));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z10), v2);
    }

    private <V> void writeDeterministicIntegerMap(int i10, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> iterator2 = map.h().iterator2();
        int i11 = 0;
        while (iterator2.hasNext()) {
            iArr[i11] = iterator2.next().intValue();
            i11++;
        }
        Arrays.sort(iArr);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            V v2 = map.get(Integer.valueOf(i13));
            this.output.writeTag(i10, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i13), v2));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i13), v2);
        }
    }

    private <V> void writeDeterministicLongMap(int i10, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> iterator2 = map.h().iterator2();
        int i11 = 0;
        while (iterator2.hasNext()) {
            jArr[i11] = iterator2.next().longValue();
            i11++;
        }
        Arrays.sort(jArr);
        for (int i12 = 0; i12 < size; i12++) {
            long j10 = jArr[i12];
            V v2 = map.get(Long.valueOf(j10));
            this.output.writeTag(i10, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j10), v2));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j10), v2);
        }
    }

    private <K, V> void writeDeterministicMap(int i10, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v2 = map.get(Boolean.FALSE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(i10, false, v2, metadata);
                }
                V v10 = map.get(Boolean.TRUE);
                if (v10 != null) {
                    writeDeterministicBooleanMapEntry(i10, true, v10, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i10, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i10, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i10, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + ((Object) metadata.keyType));
        }
    }

    private <V> void writeDeterministicStringMap(int i10, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> iterator2 = map.h().iterator2();
        int i11 = 0;
        while (iterator2.hasNext()) {
            strArr[i11] = iterator2.next();
            i11++;
        }
        Arrays.sort(strArr);
        for (int i12 = 0; i12 < size; i12++) {
            String str = strArr[i12];
            V v2 = map.get(str);
            this.output.writeTag(i10, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v2));
            MapEntryLite.writeTo(this.output, metadata, str, v2);
        }
    }

    private void writeLazyString(int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i10, (String) obj);
        } else {
            this.output.writeBytes(i10, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i10, boolean z10) throws IOException {
        this.output.writeBool(i10, z10);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeBoolSizeNoTag(list.get(i13).booleanValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeBoolNoTag(list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeBool(i10, list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i10, ByteString byteString) throws IOException {
        this.output.writeBytes(i10, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i10, List<ByteString> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.output.writeBytes(i10, list.get(i11));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i10, double d10) throws IOException {
        this.output.writeDouble(i10, d10);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i13).doubleValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeDouble(i10, list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i10) throws IOException {
        this.output.writeTag(i10, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i10, int i11) throws IOException {
        this.output.writeEnum(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeEnumSizeNoTag(list.get(i13).intValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeEnumNoTag(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeEnum(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i10, int i11) throws IOException {
        this.output.writeFixed32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i13).intValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeFixed32(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i10, long j10) throws IOException {
        this.output.writeFixed64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i13).longValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeFixed64(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i10, float f10) throws IOException {
        this.output.writeFloat(i10, f10);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeFloatSizeNoTag(list.get(i13).floatValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeFloatNoTag(list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeFloat(i10, list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroup(int i10, Object obj) throws IOException {
        this.output.writeGroup(i10, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i10, List<?> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeGroup(i10, list.get(i11));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i10, int i11) throws IOException {
        this.output.writeInt32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeInt32SizeNoTag(list.get(i13).intValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeInt32NoTag(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeInt32(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i10, long j10) throws IOException {
        this.output.writeInt64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeInt64SizeNoTag(list.get(i13).longValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeInt64NoTag(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeInt64(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i10, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i10, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i10, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i10, Object obj) throws IOException {
        this.output.writeMessage(i10, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i10, List<?> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeMessage(i10, list.get(i11));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i10, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i10, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i10, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i10, int i11) throws IOException {
        this.output.writeSFixed32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i13).intValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeSFixed32(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i10, long j10) throws IOException {
        this.output.writeSFixed64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i13).longValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeSFixed64(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i10, int i11) throws IOException {
        this.output.writeSInt32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i13).intValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeSInt32(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i10, long j10) throws IOException {
        this.output.writeSInt64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i13).longValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeSInt64(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i10) throws IOException {
        this.output.writeTag(i10, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i10, String str) throws IOException {
        this.output.writeString(i10, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i11 < list.size()) {
                writeLazyString(i10, lazyStringList.getRaw(i11));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeString(i10, list.get(i11));
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i10, int i11) throws IOException {
        this.output.writeUInt32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i13).intValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeUInt32(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i10, long j10) throws IOException {
        this.output.writeUInt64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.output.writeTag(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i13).longValue());
            }
            this.output.writeUInt32NoTag(i12);
            while (i11 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.output.writeUInt64(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i10, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i10, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i10, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i10, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i10, List<?> list, Schema schema) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeGroup(i10, list.get(i11), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i10, List<?> list, Schema schema) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeMessage(i10, list.get(i11), schema);
        }
    }
}
