package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: PhoneNumberProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53664a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53665b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53666c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53667d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53668e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001egoogle/type/phone_number.proto\u0012\u000bgoogle.type\"«\u0001\n\u000bPhoneNumber\u0012\u0015\n\u000be164_number\u0018\u0001 \u0001(\tH\u0000\u00128\n\nshort_code\u0018\u0002 \u0001(\u000b2\".google.type.PhoneNumber.ShortCodeH\u0000\u0012\u0011\n\textension\u0018\u0003 \u0001(\t\u001a0\n\tShortCode\u0012\u0013\n\u000bregion_code\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\tB\u0006\n\u0004kindBt\n\u000fcom.google.typeB\u0010PhoneNumberProtoP\u0001ZDgoogle.golang.org/genproto/googleapis/type/phone_number;phone_numberø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53664a = descriptor;
        f53665b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"E164Number", "ShortCode", "Extension", "Kind"});
        Descriptors.Descriptor descriptor2 = descriptor.getNestedTypes().get(0);
        f53666c = descriptor2;
        f53667d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"RegionCode", "Number"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53668e;
    }
}
