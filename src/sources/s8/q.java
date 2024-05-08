package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: TimeOfDayProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53675a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53676b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53677c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bgoogle/type/timeofday.proto\u0012\u000bgoogle.type\"K\n\tTimeOfDay\u0012\r\n\u0005hours\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007minutes\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007seconds\u0018\u0003 \u0001(\u0005\u0012\r\n\u0005nanos\u0018\u0004 \u0001(\u0005Bl\n\u000fcom.google.typeB\u000eTimeOfDayProtoP\u0001Z>google.golang.org/genproto/googleapis/type/timeofday;timeofdayø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53675a = descriptor;
        f53676b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Hours", "Minutes", "Seconds", "Nanos"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53677c;
    }
}
