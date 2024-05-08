package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: LoggingProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53950a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53951b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53952c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53953d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53954e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018google/api/logging.proto\u0012\ngoogle.api\"×\u0001\n\u0007Logging\u0012E\n\u0015producer_destinations\u0018\u0001 \u0003(\u000b2&.google.api.Logging.LoggingDestination\u0012E\n\u0015consumer_destinations\u0018\u0002 \u0003(\u000b2&.google.api.Logging.LoggingDestination\u001a>\n\u0012LoggingDestination\u0012\u001a\n\u0012monitored_resource\u0018\u0003 \u0001(\t\u0012\f\n\u0004logs\u0018\u0001 \u0003(\tBn\n\u000ecom.google.apiB\fLoggingProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53950a = descriptor;
        f53951b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"ProducerDestinations", "ConsumerDestinations"});
        Descriptors.Descriptor descriptor2 = descriptor.getNestedTypes().get(0);
        f53952c = descriptor2;
        f53953d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"MonitoredResource", "Logs"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53954e;
    }
}
