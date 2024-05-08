package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: UsageProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53867a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53868b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53869c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53870d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53871e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016google/api/usage.proto\u0012\ngoogle.api\"j\n\u0005Usage\u0012\u0014\n\frequirements\u0018\u0001 \u0003(\t\u0012$\n\u0005rules\u0018\u0006 \u0003(\u000b2\u0015.google.api.UsageRule\u0012%\n\u001dproducer_notification_channel\u0018\u0007 \u0001(\t\"]\n\tUsageRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012 \n\u0018allow_unregistered_calls\u0018\u0002 \u0001(\b\u0012\u001c\n\u0014skip_service_control\u0018\u0003 \u0001(\bBl\n\u000ecom.google.apiB\nUsageProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53867a = descriptor;
        f53868b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Requirements", "Rules", "ProducerNotificationChannel"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53869c = descriptor2;
        f53870d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "AllowUnregisteredCalls", "SkipServiceControl"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53871e;
    }
}
