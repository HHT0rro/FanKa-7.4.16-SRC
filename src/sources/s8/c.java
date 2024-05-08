package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: DateProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53633a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53634b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53635c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016google/type/date.proto\u0012\u000bgoogle.type\"0\n\u0004Date\u0012\f\n\u0004year\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005month\u0018\u0002 \u0001(\u0005\u0012\u000b\n\u0003day\u0018\u0003 \u0001(\u0005B]\n\u000fcom.google.typeB\tDateProtoP\u0001Z4google.golang.org/genproto/googleapis/type/date;dateø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53633a = descriptor;
        f53634b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Year", "Month", "Day"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53635c;
    }
}
