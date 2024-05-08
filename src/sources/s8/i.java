package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.TimestampProto;

/* compiled from: IntervalProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53651a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53652b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53653c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001agoogle/type/interval.proto\u0012\u000bgoogle.type\u001a\u001fgoogle/protobuf/timestamp.proto\"h\n\bInterval\u0012.\n\nstart_time\u0018\u0001 \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012,\n\bend_time\u0018\u0002 \u0001(\u000b2\u001a.google.protobuf.TimestampBi\n\u000fcom.google.typeB\rIntervalProtoP\u0001Z<google.golang.org/genproto/googleapis/type/interval;intervalø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[]{TimestampProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53651a = descriptor;
        f53652b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"StartTime", "EndTime"});
        TimestampProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53653c;
    }
}
