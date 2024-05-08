package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.WrappersProto;

/* compiled from: ColorProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53630a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53631b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53632c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017google/type/color.proto\u0012\u000bgoogle.type\u001a\u001egoogle/protobuf/wrappers.proto\"]\n\u0005Color\u0012\u000b\n\u0003red\u0018\u0001 \u0001(\u0002\u0012\r\n\u0005green\u0018\u0002 \u0001(\u0002\u0012\f\n\u0004blue\u0018\u0003 \u0001(\u0002\u0012*\n\u0005alpha\u0018\u0004 \u0001(\u000b2\u001b.google.protobuf.FloatValueB`\n\u000fcom.google.typeB\nColorProtoP\u0001Z6google.golang.org/genproto/googleapis/type/color;colorø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[]{WrappersProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53630a = descriptor;
        f53631b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Red", "Green", "Blue", "Alpha"});
        WrappersProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53632c;
    }
}
