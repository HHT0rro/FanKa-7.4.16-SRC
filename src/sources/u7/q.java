package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: LabelProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53943a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53944b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53945c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016google/api/label.proto\u0012\ngoogle.api\"\u009c\u0001\n\u000fLabelDescriptor\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u00129\n\nvalue_type\u0018\u0002 \u0001(\u000e2%.google.api.LabelDescriptor.ValueType\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\",\n\tValueType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004BOOL\u0010\u0001\u0012\t\n\u0005INT64\u0010\u0002B_\n\u000ecom.google.apiB\nLabelProtoP\u0001Z5google.golang.org/genproto/googleapis/api/label;labelø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53943a = descriptor;
        f53944b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Key", "ValueType", "Description"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53945c;
    }
}
