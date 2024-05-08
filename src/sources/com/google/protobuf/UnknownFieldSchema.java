package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(B b4, int i10, int i11);

    public abstract void addFixed64(B b4, int i10, long j10);

    public abstract void addGroup(B b4, int i10, T t2);

    public abstract void addLengthDelimited(B b4, int i10, ByteString byteString);

    public abstract void addVarint(B b4, int i10, long j10);

    public abstract B getBuilderFromMessage(Object obj);

    public abstract T getFromMessage(Object obj);

    public abstract int getSerializedSize(T t2);

    public abstract int getSerializedSizeAsMessageSet(T t2);

    public abstract void makeImmutable(Object obj);

    public abstract T merge(T t2, T t10);

    public final void mergeFrom(B b4, Reader reader) throws IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b4, reader)) {
        }
    }

    public final boolean mergeOneFieldFrom(B b4, Reader reader) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b4, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b4, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b4, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                addFixed32(b4, tagFieldNumber, reader.readFixed32());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        B newBuilder = newBuilder();
        int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
        mergeFrom(newBuilder, reader);
        if (makeTag == reader.getTag()) {
            addGroup(b4, tagFieldNumber, toImmutable(newBuilder));
            return true;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b4);

    public abstract void setToMessage(Object obj, T t2);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    public abstract T toImmutable(B b4);

    public abstract void writeAsMessageSetTo(T t2, Writer writer) throws IOException;

    public abstract void writeTo(T t2, Writer writer) throws IOException;
}
