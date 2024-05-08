package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: MoneyProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53660a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53661b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53662c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017google/type/money.proto\u0012\u000bgoogle.type\"<\n\u0005Money\u0012\u0015\n\rcurrency_code\u0018\u0001 \u0001(\t\u0012\r\n\u0005units\u0018\u0002 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0003 \u0001(\u0005B`\n\u000fcom.google.typeB\nMoneyProtoP\u0001Z6google.golang.org/genproto/googleapis/type/money;moneyø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53660a = descriptor;
        f53661b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"CurrencyCode", "Units", "Nanos"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53662c;
    }
}
