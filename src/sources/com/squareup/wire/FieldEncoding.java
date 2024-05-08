package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    public final int value;

    /* renamed from: com.squareup.wire.FieldEncoding$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            $SwitchMap$com$squareup$wire$FieldEncoding = iArr;
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    FieldEncoding(int i10) {
        this.value = i10;
    }

    public static FieldEncoding get(int i10) throws IOException {
        if (i10 == 0) {
            return VARINT;
        }
        if (i10 == 1) {
            return FIXED64;
        }
        if (i10 == 2) {
            return LENGTH_DELIMITED;
        }
        if (i10 == 5) {
            return FIXED32;
        }
        throw new ProtocolException("Unexpected FieldEncoding: " + i10);
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i10 = AnonymousClass1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (i10 == 1) {
            return ProtoAdapter.UINT64;
        }
        if (i10 == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (i10 == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (i10 == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new AssertionError();
    }
}
