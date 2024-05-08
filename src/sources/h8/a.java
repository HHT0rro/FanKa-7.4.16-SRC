package h8;

import com.google.longrunning.OperationInfo;
import com.google.protobuf.AnyProto;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DurationProto;
import com.google.protobuf.EmptyProto;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import q8.c;
import u7.e;

/* compiled from: OperationsProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, OperationInfo> f49534a;

    /* renamed from: b, reason: collision with root package name */
    public static final Descriptors.Descriptor f49535b;

    /* renamed from: c, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49536c;

    /* renamed from: d, reason: collision with root package name */
    public static final Descriptors.Descriptor f49537d;

    /* renamed from: e, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49538e;

    /* renamed from: f, reason: collision with root package name */
    public static final Descriptors.Descriptor f49539f;

    /* renamed from: g, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49540g;

    /* renamed from: h, reason: collision with root package name */
    public static final Descriptors.Descriptor f49541h;

    /* renamed from: i, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49542i;

    /* renamed from: j, reason: collision with root package name */
    public static final Descriptors.Descriptor f49543j;

    /* renamed from: k, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49544k;

    /* renamed from: l, reason: collision with root package name */
    public static final Descriptors.Descriptor f49545l;

    /* renamed from: m, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49546m;

    /* renamed from: n, reason: collision with root package name */
    public static final Descriptors.Descriptor f49547n;

    /* renamed from: o, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49548o;

    /* renamed from: p, reason: collision with root package name */
    public static final Descriptors.Descriptor f49549p;

    /* renamed from: q, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49550q;

    /* renamed from: r, reason: collision with root package name */
    public static Descriptors.FileDescriptor f49551r;

    static {
        GeneratedMessage.GeneratedExtension<DescriptorProtos.MethodOptions, OperationInfo> newFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(OperationInfo.class, OperationInfo.getDefaultInstance());
        f49534a = newFileScopedGeneratedExtension;
        f49551r = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/longrunning/operations.proto\u0012\u0012google.longrunning\u001a\u001cgoogle/api/annotations.proto\u001a\u0017google/api/client.proto\u001a\u0019google/protobuf/any.proto\u001a\u001egoogle/protobuf/duration.proto\u001a\u001bgoogle/protobuf/empty.proto\u001a\u0017google/rpc/status.proto\u001a google/protobuf/descriptor.proto\"¨\u0001\n\tOperation\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012&\n\bmetadata\u0018\u0002 \u0001(\u000b2\u0014.google.protobuf.Any\u0012\f\n\u0004done\u0018\u0003 \u0001(\b\u0012#\n\u0005error\u0018\u0004 \u0001(\u000b2\u0012.google.rpc.StatusH\u0000\u0012(\n\bresponse\u0018\u0005 \u0001(\u000b2\u0014.google.protobuf.AnyH\u0000B\b\n\u0006result\"#\n\u0013GetOperationRequest\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\"\\\n\u0015ListOperationsRequest\u0012\f\n\u0004name\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006filter\u0018\u0001 \u0001(\t\u0012\u0011\n\tpage_size\u0018\u0002 \u0001(\u0005\u0012\u0012\n\npage_token\u0018\u0003 \u0001(\t\"d\n\u0016ListOperationsResponse\u00121\n\noperations\u0018\u0001 \u0003(\u000b2\u001d.google.longrunning.Operation\u0012\u0017\n\u000fnext_page_token\u0018\u0002 \u0001(\t\"&\n\u0016CancelOperationRequest\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\"&\n\u0016DeleteOperationRequest\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\"P\n\u0014WaitOperationRequest\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012*\n\u0007timeout\u0018\u0002 \u0001(\u000b2\u0019.google.protobuf.Duration\"=\n\rOperationInfo\u0012\u0015\n\rresponse_type\u0018\u0001 \u0001(\t\u0012\u0015\n\rmetadata_type\u0018\u0002 \u0001(\t2ª\u0005\n\nOperations\u0012\u0094\u0001\n\u000eListOperations\u0012).google.longrunning.ListOperationsRequest\u001a*.google.longrunning.ListOperationsResponse\"+\u0082Óä\u0093\u0002\u0017\u0012\u0015/v1/{name=operations}ÚA\u000bname,filter\u0012\u007f\n\fGetOperation\u0012'.google.longrunning.GetOperationRequest\u001a\u001d.google.longrunning.Operation\"'\u0082Óä\u0093\u0002\u001a\u0012\u0018/v1/{name=operations/**}ÚA\u0004name\u0012~\n\u000fDeleteOperation\u0012*.google.longrunning.DeleteOperationRequest\u001a\u0016.google.protobuf.Empty\"'\u0082Óä\u0093\u0002\u001a*\u0018/v1/{name=operations/**}ÚA\u0004name\u0012\u0088\u0001\n\u000fCancelOperation\u0012*.google.longrunning.CancelOperationRequest\u001a\u0016.google.protobuf.Empty\"1\u0082Óä\u0093\u0002$\"\u001f/v1/{name=operations/**}:cancel:\u0001*ÚA\u0004name\u0012Z\n\rWaitOperation\u0012(.google.longrunning.WaitOperationRequest\u001a\u001d.google.longrunning.Operation\"\u0000\u001a\u001dÊA\u001alongrunning.googleapis.com:Z\n\u000eoperation_info\u0012\u001e.google.protobuf.MethodOptions\u0018\u0099\b \u0001(\u000b2!.google.longrunning.OperationInfoB\u0097\u0001\n\u0016com.google.longrunningB\u000fOperationsProtoP\u0001Z=google.golang.org/genproto/googleapis/longrunning;longrunningø\u0001\u0001ª\u0002\u0012Google.LongRunningÊ\u0002\u0012Google\\LongRunningb\u0006proto3"}, new Descriptors.FileDescriptor[]{u7.a.a(), e.a(), AnyProto.getDescriptor(), DurationProto.getDescriptor(), EmptyProto.getDescriptor(), c.a(), DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f49535b = descriptor;
        f49536c = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Name", "Metadata", "Done", "Error", "Response", "Result"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f49537d = descriptor2;
        f49538e = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Name"});
        Descriptors.Descriptor descriptor3 = a().getMessageTypes().get(2);
        f49539f = descriptor3;
        f49540g = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Name", "Filter", "PageSize", "PageToken"});
        Descriptors.Descriptor descriptor4 = a().getMessageTypes().get(3);
        f49541h = descriptor4;
        f49542i = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Operations", "NextPageToken"});
        Descriptors.Descriptor descriptor5 = a().getMessageTypes().get(4);
        f49543j = descriptor5;
        f49544k = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Name"});
        Descriptors.Descriptor descriptor6 = a().getMessageTypes().get(5);
        f49545l = descriptor6;
        f49546m = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Name"});
        Descriptors.Descriptor descriptor7 = a().getMessageTypes().get(6);
        f49547n = descriptor7;
        f49548o = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"Name", "Timeout"});
        Descriptors.Descriptor descriptor8 = a().getMessageTypes().get(7);
        f49549p = descriptor8;
        f49550q = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"ResponseType", "MetadataType"});
        newFileScopedGeneratedExtension.internalInit(f49551r.getExtensions().get(0));
        ExtensionRegistry newInstance = ExtensionRegistry.newInstance();
        newInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) e.f53873b);
        newInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) u7.a.f53829a);
        newInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) e.f53872a);
        Descriptors.FileDescriptor.internalUpdateFileDescriptor(f49551r, newInstance);
        u7.a.a();
        e.a();
        AnyProto.getDescriptor();
        DurationProto.getDescriptor();
        EmptyProto.getDescriptor();
        c.a();
        DescriptorProtos.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f49551r;
    }
}
