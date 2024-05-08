package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: LogProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53947a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53948b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53949c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014google/api/log.proto\u0012\ngoogle.api\u001a\u0016google/api/label.proto\"u\n\rLogDescriptor\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012+\n\u0006labels\u0018\u0002 \u0003(\u000b2\u001b.google.api.LabelDescriptor\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\u0012\u0014\n\fdisplay_name\u0018\u0004 \u0001(\tBj\n\u000ecom.google.apiB\bLogProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{q.a()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53947a = descriptor;
        f53948b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Name", "Labels", "Description", "DisplayName"});
        q.a();
    }

    public static Descriptors.FileDescriptor a() {
        return f53949c;
    }
}
