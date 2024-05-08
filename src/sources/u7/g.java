package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: ConsumerProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53892a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53893b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53894c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53895d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53896e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019google/api/consumer.proto\u0012\ngoogle.api\"=\n\u0011ProjectProperties\u0012(\n\nproperties\u0018\u0001 \u0003(\u000b2\u0014.google.api.Property\"¬\u0001\n\bProperty\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012/\n\u0004type\u0018\u0002 \u0001(\u000e2!.google.api.Property.PropertyType\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\"L\n\fPropertyType\u0012\u000f\n\u000bUNSPECIFIED\u0010\u0000\u0012\t\n\u0005INT64\u0010\u0001\u0012\b\n\u0004BOOL\u0010\u0002\u0012\n\n\u0006STRING\u0010\u0003\u0012\n\n\u0006DOUBLE\u0010\u0004Bh\n\u000ecom.google.apiB\rConsumerProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfigb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53892a = descriptor;
        f53893b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Properties"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53894c = descriptor2;
        f53895d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Name", "Type", "Description"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53896e;
    }
}
