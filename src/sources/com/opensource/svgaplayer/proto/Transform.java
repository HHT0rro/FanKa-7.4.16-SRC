package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Transform extends Message<Transform, Builder> {
    public static final ProtoAdapter<Transform> ADAPTER = new ProtoAdapter_Transform();
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float f38032a;

    /* renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float f38033b;

    /* renamed from: c, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float f38034c;

    /* renamed from: d, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float f38035d;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder extends Message.Builder<Transform, Builder> {

        /* renamed from: a, reason: collision with root package name */
        public Float f38036a;

        /* renamed from: b, reason: collision with root package name */
        public Float f38037b;

        /* renamed from: c, reason: collision with root package name */
        public Float f38038c;

        /* renamed from: d, reason: collision with root package name */
        public Float f38039d;
        public Float tx;
        public Float ty;

        public Builder a(Float f10) {
            this.f38036a = f10;
            return this;
        }

        public Builder b(Float f10) {
            this.f38037b = f10;
            return this;
        }

        public Builder c(Float f10) {
            this.f38038c = f10;
            return this;
        }

        public Builder d(Float f10) {
            this.f38039d = f10;
            return this;
        }

        public Builder tx(Float f10) {
            this.tx = f10;
            return this;
        }

        public Builder ty(Float f10) {
            this.ty = f10;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public Transform build() {
            return new Transform(this.f38036a, this.f38037b, this.f38038c, this.f38039d, this.tx, this.ty, super.buildUnknownFields());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class ProtoAdapter_Transform extends ProtoAdapter<Transform> {
        public ProtoAdapter_Transform() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Transform decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.a(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 2:
                            builder.b(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 3:
                            builder.c(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 4:
                            builder.d(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 5:
                            builder.tx(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 6:
                            builder.ty(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Transform transform) throws IOException {
            Float f10 = transform.f38032a;
            if (f10 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f10);
            }
            Float f11 = transform.f38033b;
            if (f11 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f11);
            }
            Float f12 = transform.f38034c;
            if (f12 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f12);
            }
            Float f13 = transform.f38035d;
            if (f13 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f13);
            }
            Float f14 = transform.tx;
            if (f14 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 5, f14);
            }
            Float f15 = transform.ty;
            if (f15 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, f15);
            }
            protoWriter.writeBytes(transform.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Transform transform) {
            Float f10 = transform.f38032a;
            int encodedSizeWithTag = f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f10) : 0;
            Float f11 = transform.f38033b;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f11) : 0);
            Float f12 = transform.f38034c;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f12) : 0);
            Float f13 = transform.f38035d;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f13) : 0);
            Float f14 = transform.tx;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (f14 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f14) : 0);
            Float f15 = transform.ty;
            return encodedSizeWithTag5 + (f15 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f15) : 0) + transform.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Transform redact(Transform transform) {
            Message.Builder<Transform, Builder> newBuilder2 = transform.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    public Transform(Float f10, Float f11, Float f12, Float f13, Float f14, Float f15) {
        this(f10, f11, f12, f13, f14, f15, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Transform)) {
            return false;
        }
        Transform transform = (Transform) obj;
        return unknownFields().equals(transform.unknownFields()) && Internal.equals(this.f38032a, transform.f38032a) && Internal.equals(this.f38033b, transform.f38033b) && Internal.equals(this.f38034c, transform.f38034c) && Internal.equals(this.f38035d, transform.f38035d) && Internal.equals(this.tx, transform.tx) && Internal.equals(this.ty, transform.ty);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Float f10 = this.f38032a;
        int hashCode2 = (hashCode + (f10 != null ? f10.hashCode() : 0)) * 37;
        Float f11 = this.f38033b;
        int hashCode3 = (hashCode2 + (f11 != null ? f11.hashCode() : 0)) * 37;
        Float f12 = this.f38034c;
        int hashCode4 = (hashCode3 + (f12 != null ? f12.hashCode() : 0)) * 37;
        Float f13 = this.f38035d;
        int hashCode5 = (hashCode4 + (f13 != null ? f13.hashCode() : 0)) * 37;
        Float f14 = this.tx;
        int hashCode6 = (hashCode5 + (f14 != null ? f14.hashCode() : 0)) * 37;
        Float f15 = this.ty;
        int hashCode7 = hashCode6 + (f15 != null ? f15.hashCode() : 0);
        this.hashCode = hashCode7;
        return hashCode7;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f38032a != null) {
            sb2.append(", a=");
            sb2.append((Object) this.f38032a);
        }
        if (this.f38033b != null) {
            sb2.append(", b=");
            sb2.append((Object) this.f38033b);
        }
        if (this.f38034c != null) {
            sb2.append(", c=");
            sb2.append((Object) this.f38034c);
        }
        if (this.f38035d != null) {
            sb2.append(", d=");
            sb2.append((Object) this.f38035d);
        }
        if (this.tx != null) {
            sb2.append(", tx=");
            sb2.append((Object) this.tx);
        }
        if (this.ty != null) {
            sb2.append(", ty=");
            sb2.append((Object) this.ty);
        }
        StringBuilder replace = sb2.replace(0, 2, "Transform{");
        replace.append('}');
        return replace.toString();
    }

    public Transform(Float f10, Float f11, Float f12, Float f13, Float f14, Float f15, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f38032a = f10;
        this.f38033b = f11;
        this.f38034c = f12;
        this.f38035d = f13;
        this.tx = f14;
        this.ty = f15;
    }

    @Override // com.squareup.wire.Message
    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Message.Builder<Transform, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.f38036a = this.f38032a;
        builder.f38037b = this.f38033b;
        builder.f38038c = this.f38034c;
        builder.f38039d = this.f38035d;
        builder.tx = this.tx;
        builder.ty = this.ty;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
