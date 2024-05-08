package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: ContextProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53897a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53898b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53899c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53900d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53901e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018google/api/context.proto\u0012\ngoogle.api\"1\n\u0007Context\u0012&\n\u0005rules\u0018\u0001 \u0003(\u000b2\u0017.google.api.ContextRule\"\u008d\u0001\n\u000bContextRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012\u0011\n\trequested\u0018\u0002 \u0003(\t\u0012\u0010\n\bprovided\u0018\u0003 \u0003(\t\u0012\"\n\u001aallowed_request_extensions\u0018\u0004 \u0003(\t\u0012#\n\u001ballowed_response_extensions\u0018\u0005 \u0003(\tBn\n\u000ecom.google.apiB\fContextProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53897a = descriptor;
        f53898b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Rules"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53899c = descriptor2;
        f53900d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "Requested", "Provided", "AllowedRequestExtensions", "AllowedResponseExtensions"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53901e;
    }
}
