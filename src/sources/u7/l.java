package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: EndpointProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53927a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53928b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53929c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019google/api/endpoint.proto\u0012\ngoogle.api\"Q\n\bEndpoint\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0013\n\u0007aliases\u0018\u0002 \u0003(\tB\u0002\u0018\u0001\u0012\u000e\n\u0006target\u0018e \u0001(\t\u0012\u0012\n\nallow_cors\u0018\u0005 \u0001(\bBo\n\u000ecom.google.apiB\rEndpointProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53927a = descriptor;
        f53928b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Name", "Aliases", "Target", "AllowCors"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53929c;
    }
}
