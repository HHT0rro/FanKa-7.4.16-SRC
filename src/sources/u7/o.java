package u7;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import sun.security.pkcs.PKCS9Attribute;

/* compiled from: HttpBodyProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53933a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53934b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53935c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019google/api/httpbody.proto\u0012\ngoogle.api\u001a\u0019google/protobuf/any.proto\"X\n\bHttpBody\u0012\u0014\n\fcontent_type\u0018\u0001 \u0001(\t\u0012\f\n\u0004data\u0018\u0002 \u0001(\f\u0012(\n\nextensions\u0018\u0003 \u0003(\u000b2\u0014.google.protobuf.AnyBh\n\u000ecom.google.apiB\rHttpBodyProtoP\u0001Z;google.golang.org/genproto/googleapis/api/httpbody;httpbodyø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53933a = descriptor;
        f53934b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{PKCS9Attribute.CONTENT_TYPE_STR, "Data", "Extensions"});
        AnyProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53935c;
    }
}
