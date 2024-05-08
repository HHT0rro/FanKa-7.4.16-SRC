package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: ExprProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53645a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53646b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53647c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016google/type/expr.proto\u0012\u000bgoogle.type\"P\n\u0004Expr\u0012\u0012\n\nexpression\u0018\u0001 \u0001(\t\u0012\r\n\u0005title\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\u0012\u0010\n\blocation\u0018\u0004 \u0001(\tBZ\n\u000fcom.google.typeB\tExprProtoP\u0001Z4google.golang.org/genproto/googleapis/type/expr;expr¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53645a = descriptor;
        f53646b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Expression", "Title", "Description", "Location"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53647c;
    }
}
