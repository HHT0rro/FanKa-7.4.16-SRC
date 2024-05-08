package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: HttpProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53936a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53937b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53938c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53939d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53940e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53941f;

    /* renamed from: g, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53942g = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015google/api/http.proto\u0012\ngoogle.api\"T\n\u0004Http\u0012#\n\u0005rules\u0018\u0001 \u0003(\u000b2\u0014.google.api.HttpRule\u0012'\n\u001ffully_decode_reserved_expansion\u0018\u0002 \u0001(\b\"\u0081\u0002\n\bHttpRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012\r\n\u0003get\u0018\u0002 \u0001(\tH\u0000\u0012\r\n\u0003put\u0018\u0003 \u0001(\tH\u0000\u0012\u000e\n\u0004post\u0018\u0004 \u0001(\tH\u0000\u0012\u0010\n\u0006delete\u0018\u0005 \u0001(\tH\u0000\u0012\u000f\n\u0005patch\u0018\u0006 \u0001(\tH\u0000\u0012/\n\u0006custom\u0018\b \u0001(\u000b2\u001d.google.api.CustomHttpPatternH\u0000\u0012\f\n\u0004body\u0018\u0007 \u0001(\t\u0012\u0015\n\rresponse_body\u0018\f \u0001(\t\u00121\n\u0013additional_bindings\u0018\u000b \u0003(\u000b2\u0014.google.api.HttpRuleB\t\n\u0007pattern\"/\n\u0011CustomHttpPattern\u0012\f\n\u0004kind\u0018\u0001 \u0001(\t\u0012\f\n\u0004path\u0018\u0002 \u0001(\tBj\n\u000ecom.google.apiB\tHttpProtoP\u0001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotationsø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53936a = descriptor;
        f53937b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Rules", "FullyDecodeReservedExpansion"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53938c = descriptor2;
        f53939d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "Get", "Put", "Post", "Delete", "Patch", "Custom", "Body", "ResponseBody", "AdditionalBindings", "Pattern"});
        Descriptors.Descriptor descriptor3 = a().getMessageTypes().get(2);
        f53940e = descriptor3;
        f53941f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Kind", "Path"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53942g;
    }
}
