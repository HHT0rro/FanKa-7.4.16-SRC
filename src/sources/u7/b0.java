package u7;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: SourceInfoProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53847a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53848b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53849c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cgoogle/api/source_info.proto\u0012\ngoogle.api\u001a\u0019google/protobuf/any.proto\"8\n\nSourceInfo\u0012*\n\fsource_files\u0018\u0001 \u0003(\u000b2\u0014.google.protobuf.AnyBq\n\u000ecom.google.apiB\u000fSourceInfoProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53847a = descriptor;
        f53848b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"SourceFiles"});
        AnyProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53849c;
    }
}
