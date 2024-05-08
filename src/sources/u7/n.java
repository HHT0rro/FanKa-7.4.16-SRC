package u7;

import com.google.api.FieldBehavior;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import java.util.List;

/* compiled from: FieldBehaviorProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FieldOptions, List<FieldBehavior>> f53931a;

    /* renamed from: b, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53932b;

    static {
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FieldOptions, List<FieldBehavior>> newFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(FieldBehavior.class, null);
        f53931a = newFileScopedGeneratedExtension;
        Descriptors.FileDescriptor internalBuildGeneratedFileFrom = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fgoogle/api/field_behavior.proto\u0012\ngoogle.api\u001a google/protobuf/descriptor.proto*¦\u0001\n\rFieldBehavior\u0012\u001e\n\u001aFIELD_BEHAVIOR_UNSPECIFIED\u0010\u0000\u0012\f\n\bOPTIONAL\u0010\u0001\u0012\f\n\bREQUIRED\u0010\u0002\u0012\u000f\n\u000bOUTPUT_ONLY\u0010\u0003\u0012\u000e\n\nINPUT_ONLY\u0010\u0004\u0012\r\n\tIMMUTABLE\u0010\u0005\u0012\u0012\n\u000eUNORDERED_LIST\u0010\u0006\u0012\u0015\n\u0011NON_EMPTY_DEFAULT\u0010\u0007:Q\n\u000efield_behavior\u0012\u001d.google.protobuf.FieldOptions\u0018\u009c\b \u0003(\u000e2\u0019.google.api.FieldBehaviorBp\n\u000ecom.google.apiB\u0012FieldBehaviorProtoP\u0001ZAgoogle.golang.org/genproto/googleapis/api/annotations;annotations¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        f53932b = internalBuildGeneratedFileFrom;
        newFileScopedGeneratedExtension.internalInit(internalBuildGeneratedFileFrom.getExtensions().get(0));
        DescriptorProtos.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53932b;
    }
}
