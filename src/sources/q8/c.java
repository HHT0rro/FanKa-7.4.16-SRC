package q8;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: StatusProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53179a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53180b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53181c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017google/rpc/status.proto\u0012\ngoogle.rpc\u001a\u0019google/protobuf/any.proto\"N\n\u0006Status\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012%\n\u0007details\u0018\u0003 \u0003(\u000b2\u0014.google.protobuf.AnyBa\n\u000ecom.google.rpcB\u000bStatusProtoP\u0001Z7google.golang.org/genproto/googleapis/rpc/status;statusø\u0001\u0001¢\u0002\u0003RPCb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53179a = descriptor;
        f53180b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Code", "Message", "Details"});
        AnyProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53181c;
    }
}
