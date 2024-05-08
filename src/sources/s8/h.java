package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: FractionProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53648a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53649b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53650c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001agoogle/type/fraction.proto\u0012\u000bgoogle.type\"2\n\bFraction\u0012\u0011\n\tnumerator\u0018\u0001 \u0001(\u0003\u0012\u0013\n\u000bdenominator\u0018\u0002 \u0001(\u0003Bf\n\u000fcom.google.typeB\rFractionProtoP\u0001Z<google.golang.org/genproto/googleapis/type/fraction;fraction¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53648a = descriptor;
        f53649b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Numerator", "Denominator"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53650c;
    }
}
