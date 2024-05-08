package u7;

import com.google.api.RoutingRule;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: RoutingProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, RoutingRule> f53999a;

    /* renamed from: b, reason: collision with root package name */
    public static final Descriptors.Descriptor f54000b;

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54001c;

    /* renamed from: d, reason: collision with root package name */
    public static final Descriptors.Descriptor f54002d;

    /* renamed from: e, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54003e;

    /* renamed from: f, reason: collision with root package name */
    public static Descriptors.FileDescriptor f54004f;

    static {
        GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, RoutingRule> newFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(RoutingRule.class, RoutingRule.getDefaultInstance());
        f53999a = newFileScopedGeneratedExtension;
        f54004f = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018google/api/routing.proto\u0012\ngoogle.api\u001a google/protobuf/descriptor.proto\"G\n\u000bRoutingRule\u00128\n\u0012routing_parameters\u0018\u0002 \u0003(\u000b2\u001c.google.api.RoutingParameter\"8\n\u0010RoutingParameter\u0012\r\n\u0005field\u0018\u0001 \u0001(\t\u0012\u0015\n\rpath_template\u0018\u0002 \u0001(\t:K\n\u0007routing\u0012\u001e.google.protobuf.MethodOptions\u0018±Ê¼\" \u0001(\u000b2\u0017.google.api.RoutingRuleBj\n\u000ecom.google.apiB\fRoutingProtoP\u0001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotations¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f54000b = descriptor;
        f54001c = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"RoutingParameters"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f54002d = descriptor2;
        f54003e = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Field", "PathTemplate"});
        newFileScopedGeneratedExtension.internalInit(f54004f.getExtensions().get(0));
        DescriptorProtos.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f54004f;
    }
}
