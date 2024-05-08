package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: DocumentationProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53920a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53921b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53922c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53923d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53924e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53925f;

    /* renamed from: g, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53926g = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001egoogle/api/documentation.proto\u0012\ngoogle.api\"»\u0001\n\rDocumentation\u0012\u000f\n\u0007summary\u0018\u0001 \u0001(\t\u0012\u001f\n\u0005pages\u0018\u0005 \u0003(\u000b2\u0010.google.api.Page\u0012,\n\u0005rules\u0018\u0003 \u0003(\u000b2\u001d.google.api.DocumentationRule\u0012\u001e\n\u0016documentation_root_url\u0018\u0004 \u0001(\t\u0012\u0018\n\u0010service_root_url\u0018\u0006 \u0001(\t\u0012\u0010\n\boverview\u0018\u0002 \u0001(\t\"[\n\u0011DocumentationRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bdescription\u0018\u0002 \u0001(\t\u0012\u001f\n\u0017deprecation_description\u0018\u0003 \u0001(\t\"I\n\u0004Page\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007content\u0018\u0002 \u0001(\t\u0012\"\n\bsubpages\u0018\u0003 \u0003(\u000b2\u0010.google.api.PageBt\n\u000ecom.google.apiB\u0012DocumentationProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53920a = descriptor;
        f53921b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Summary", "Pages", "Rules", "DocumentationRootUrl", "ServiceRootUrl", "Overview"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53922c = descriptor2;
        f53923d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "Description", "DeprecationDescription"});
        Descriptors.Descriptor descriptor3 = a().getMessageTypes().get(2);
        f53924e = descriptor3;
        f53925f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Name", "Content", "Subpages"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53926g;
    }
}
