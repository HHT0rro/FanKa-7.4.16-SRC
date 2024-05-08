package u7;

import com.google.api.ResourceDescriptor;
import com.google.api.ResourceReference;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import java.util.List;

/* compiled from: ResourceProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FieldOptions, ResourceReference> f53991a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FileOptions, List<ResourceDescriptor>> f53992b;

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MessageOptions, ResourceDescriptor> f53993c;

    /* renamed from: d, reason: collision with root package name */
    public static final Descriptors.Descriptor f53994d;

    /* renamed from: e, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53995e;

    /* renamed from: f, reason: collision with root package name */
    public static final Descriptors.Descriptor f53996f;

    /* renamed from: g, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53997g;

    /* renamed from: h, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53998h;

    static {
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FieldOptions, ResourceReference> newFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(ResourceReference.class, ResourceReference.getDefaultInstance());
        f53991a = newFileScopedGeneratedExtension;
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FileOptions, List<ResourceDescriptor>> newFileScopedGeneratedExtension2 = GeneratedMessage.newFileScopedGeneratedExtension(ResourceDescriptor.class, ResourceDescriptor.getDefaultInstance());
        f53992b = newFileScopedGeneratedExtension2;
        GeneratedMessage.GeneratedExtension<DescriptorProtos.MessageOptions, ResourceDescriptor> newFileScopedGeneratedExtension3 = GeneratedMessage.newFileScopedGeneratedExtension(ResourceDescriptor.class, ResourceDescriptor.getDefaultInstance());
        f53993c = newFileScopedGeneratedExtension3;
        f53998h = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019google/api/resource.proto\u0012\ngoogle.api\u001a google/protobuf/descriptor.proto\"î\u0002\n\u0012ResourceDescriptor\u0012\f\n\u0004type\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007pattern\u0018\u0002 \u0003(\t\u0012\u0012\n\nname_field\u0018\u0003 \u0001(\t\u00127\n\u0007history\u0018\u0004 \u0001(\u000e2&.google.api.ResourceDescriptor.History\u0012\u000e\n\u0006plural\u0018\u0005 \u0001(\t\u0012\u0010\n\bsingular\u0018\u0006 \u0001(\t\u00123\n\u0005style\u0018\n \u0003(\u000e2$.google.api.ResourceDescriptor.Style\"[\n\u0007History\u0012\u0017\n\u0013HISTORY_UNSPECIFIED\u0010\u0000\u0012\u001d\n\u0019ORIGINALLY_SINGLE_PATTERN\u0010\u0001\u0012\u0018\n\u0014FUTURE_MULTI_PATTERN\u0010\u0002\"8\n\u0005Style\u0012\u0015\n\u0011STYLE_UNSPECIFIED\u0010\u0000\u0012\u0018\n\u0014DECLARATIVE_FRIENDLY\u0010\u0001\"5\n\u0011ResourceReference\u0012\f\n\u0004type\u0018\u0001 \u0001(\t\u0012\u0012\n\nchild_type\u0018\u0002 \u0001(\t:Y\n\u0012resource_reference\u0012\u001d.google.protobuf.FieldOptions\u0018\u009f\b \u0001(\u000b2\u001d.google.api.ResourceReference:Z\n\u0013resource_definition\u0012\u001c.google.protobuf.FileOptions\u0018\u009d\b \u0003(\u000b2\u001e.google.api.ResourceDescriptor:R\n\bresource\u0012\u001f.google.protobuf.MessageOptions\u0018\u009d\b \u0001(\u000b2\u001e.google.api.ResourceDescriptorBn\n\u000ecom.google.apiB\rResourceProtoP\u0001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotationsø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53994d = descriptor;
        f53995e = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Type", "Pattern", "NameField", "History", "Plural", "Singular", "Style"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53996f = descriptor2;
        f53997g = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Type", "ChildType"});
        newFileScopedGeneratedExtension.internalInit(f53998h.getExtensions().get(0));
        newFileScopedGeneratedExtension2.internalInit(f53998h.getExtensions().get(1));
        newFileScopedGeneratedExtension3.internalInit(f53998h.getExtensions().get(2));
        DescriptorProtos.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53998h;
    }
}
