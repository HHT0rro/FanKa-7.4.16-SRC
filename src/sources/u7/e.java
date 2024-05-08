package u7;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import java.util.List;

/* compiled from: ClientProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, List<String>> f53872a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.ServiceOptions, String> f53873b;

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.ServiceOptions, String> f53874c;

    /* renamed from: d, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53875d;

    static {
        GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, List<String>> newFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(String.class, null);
        f53872a = newFileScopedGeneratedExtension;
        GeneratedMessage.GeneratedExtension<DescriptorProtos.ServiceOptions, String> newFileScopedGeneratedExtension2 = GeneratedMessage.newFileScopedGeneratedExtension(String.class, null);
        f53873b = newFileScopedGeneratedExtension2;
        GeneratedMessage.GeneratedExtension<DescriptorProtos.ServiceOptions, String> newFileScopedGeneratedExtension3 = GeneratedMessage.newFileScopedGeneratedExtension(String.class, null);
        f53874c = newFileScopedGeneratedExtension3;
        Descriptors.FileDescriptor internalBuildGeneratedFileFrom = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017google/api/client.proto\u0012\ngoogle.api\u001a google/protobuf/descriptor.proto:9\n\u0010method_signature\u0012\u001e.google.protobuf.MethodOptions\u0018\u009b\b \u0003(\t:6\n\fdefault_host\u0012\u001f.google.protobuf.ServiceOptions\u0018\u0099\b \u0001(\t:6\n\foauth_scopes\u0012\u001f.google.protobuf.ServiceOptions\u0018\u009a\b \u0001(\tBi\n\u000ecom.google.apiB\u000bClientProtoP\u0001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotations¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        f53875d = internalBuildGeneratedFileFrom;
        newFileScopedGeneratedExtension.internalInit(internalBuildGeneratedFileFrom.getExtensions().get(0));
        newFileScopedGeneratedExtension2.internalInit(f53875d.getExtensions().get(1));
        newFileScopedGeneratedExtension3.internalInit(f53875d.getExtensions().get(2));
        DescriptorProtos.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53875d;
    }
}
