package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: MonitoringProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53975a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53976b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53977c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53978d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53979e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bgoogle/api/monitoring.proto\u0012\ngoogle.api\"ì\u0001\n\nMonitoring\u0012K\n\u0015producer_destinations\u0018\u0001 \u0003(\u000b2,.google.api.Monitoring.MonitoringDestination\u0012K\n\u0015consumer_destinations\u0018\u0002 \u0003(\u000b2,.google.api.Monitoring.MonitoringDestination\u001aD\n\u0015MonitoringDestination\u0012\u001a\n\u0012monitored_resource\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007metrics\u0018\u0002 \u0003(\tBq\n\u000ecom.google.apiB\u000fMonitoringProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53975a = descriptor;
        f53976b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"ProducerDestinations", "ConsumerDestinations"});
        Descriptors.Descriptor descriptor2 = descriptor.getNestedTypes().get(0);
        f53977c = descriptor2;
        f53978d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"MonitoredResource", "Metrics"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53979e;
    }
}
