package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: BackendProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53850a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53851b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53852c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53853d;

    /* renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53854e = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018google/api/backend.proto\u0012\ngoogle.api\"1\n\u0007Backend\u0012&\n\u0005rules\u0018\u0001 \u0003(\u000b2\u0017.google.api.BackendRule\"ò\u0002\n\u000bBackendRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007address\u0018\u0002 \u0001(\t\u0012\u0010\n\bdeadline\u0018\u0003 \u0001(\u0001\u0012\u0014\n\fmin_deadline\u0018\u0004 \u0001(\u0001\u0012\u001a\n\u0012operation_deadline\u0018\u0005 \u0001(\u0001\u0012A\n\u0010path_translation\u0018\u0006 \u0001(\u000e2'.google.api.BackendRule.PathTranslation\u0012\u0016\n\fjwt_audience\u0018\u0007 \u0001(\tH\u0000\u0012\u0016\n\fdisable_auth\u0018\b \u0001(\bH\u0000\u0012\u0010\n\bprotocol\u0018\t \u0001(\t\"e\n\u000fPathTranslation\u0012 \n\u001cPATH_TRANSLATION_UNSPECIFIED\u0010\u0000\u0012\u0014\n\u0010CONSTANT_ADDRESS\u0010\u0001\u0012\u001a\n\u0016APPEND_PATH_TO_ADDRESS\u0010\u0002B\u0010\n\u000eauthenticationBn\n\u000ecom.google.apiB\fBackendProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53850a = descriptor;
        f53851b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Rules"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53852c = descriptor2;
        f53853d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "Address", "Deadline", "MinDeadline", "OperationDeadline", "PathTranslation", "JwtAudience", "DisableAuth", "Protocol", "Authentication"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53854e;
    }
}
