package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: BillingProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53862a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53863b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53864c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53865d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53866e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018google/api/billing.proto\u0012\ngoogle.api\u001a\u0017google/api/metric.proto\"\u0093\u0001\n\u0007Billing\u0012E\n\u0015consumer_destinations\u0018\b \u0003(\u000b2&.google.api.Billing.BillingDestination\u001aA\n\u0012BillingDestination\u0012\u001a\n\u0012monitored_resource\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007metrics\u0018\u0002 \u0003(\tBn\n\u000ecom.google.apiB\fBillingProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{u.a()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53862a = descriptor;
        f53863b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"ConsumerDestinations"});
        Descriptors.Descriptor descriptor2 = descriptor.getNestedTypes().get(0);
        f53864c = descriptor2;
        f53865d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"MonitoredResource", "Metrics"});
        u.a();
    }

    public static Descriptors.FileDescriptor a() {
        return f53866e;
    }
}
