package java.lang.constant;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import java.lang.constant.DirectMethodHandleDesc;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ConstantDescs {
    public static final DirectMethodHandleDesc BSM_ENUM_CONSTANT;
    public static final DirectMethodHandleDesc BSM_EXPLICIT_CAST;
    public static final DirectMethodHandleDesc BSM_GET_STATIC_FINAL;
    public static final DirectMethodHandleDesc BSM_INVOKE;
    public static final DirectMethodHandleDesc BSM_NULL_CONSTANT;
    public static final DirectMethodHandleDesc BSM_PRIMITIVE_CLASS;
    public static final DirectMethodHandleDesc BSM_VARHANDLE_ARRAY;
    public static final DirectMethodHandleDesc BSM_VARHANDLE_FIELD;
    public static final DirectMethodHandleDesc BSM_VARHANDLE_STATIC_FIELD;
    public static final ClassDesc CD_Boolean;
    public static final ClassDesc CD_Byte;
    public static final ClassDesc CD_CallSite;
    public static final ClassDesc CD_Character;
    public static final ClassDesc CD_Class;
    public static final ClassDesc CD_ClassDesc;
    public static final ClassDesc CD_Collection;
    public static final ClassDesc CD_ConstantBootstraps;
    public static final ClassDesc CD_ConstantDesc;
    public static final ClassDesc CD_DirectMethodHandleDesc;
    public static final ClassDesc CD_Double;
    public static final ClassDesc CD_DynamicCallSiteDesc;
    public static final ClassDesc CD_DynamicConstantDesc;
    public static final ClassDesc CD_Enum;
    public static final ClassDesc CD_EnumDesc;
    public static final ClassDesc CD_Exception;
    public static final ClassDesc CD_Float;
    public static final ClassDesc CD_Integer;
    public static final ClassDesc CD_List;
    public static final ClassDesc CD_Long;
    public static final ClassDesc CD_Map;
    public static final ClassDesc CD_MethodHandle;
    public static final ClassDesc CD_MethodHandleDesc;
    public static final ClassDesc CD_MethodHandleDesc_Kind;
    public static final ClassDesc CD_MethodHandles;
    public static final ClassDesc CD_MethodHandles_Lookup;
    public static final ClassDesc CD_MethodType;
    public static final ClassDesc CD_MethodTypeDesc;
    public static final ClassDesc CD_Number;
    public static final ClassDesc CD_Object;
    public static final ClassDesc CD_Set;
    public static final ClassDesc CD_Short;
    public static final ClassDesc CD_String;
    public static final ClassDesc CD_Throwable;
    public static final ClassDesc CD_VarHandle;
    public static final ClassDesc CD_VarHandleDesc;
    public static final ClassDesc CD_Void;
    public static final ClassDesc CD_boolean;
    public static final ClassDesc CD_byte;
    public static final ClassDesc CD_char;
    public static final ClassDesc CD_double;
    public static final ClassDesc CD_float;
    public static final ClassDesc CD_int;
    public static final ClassDesc CD_long;
    public static final ClassDesc CD_short;
    public static final ClassDesc CD_void;
    private static final ClassDesc[] CONDY_BOOTSTRAP_ARGS;
    public static final String DEFAULT_NAME = "_";
    public static final DynamicConstantDesc<Boolean> FALSE;
    private static final ClassDesc[] INDY_BOOTSTRAP_ARGS;
    static final DirectMethodHandleDesc MHD_METHODHANDLE_ASTYPE;
    public static final ConstantDesc NULL;
    public static final DynamicConstantDesc<Boolean> TRUE;

    private ConstantDescs() {
    }

    static {
        ClassDesc of = ClassDesc.of("java.lang.Object");
        CD_Object = of;
        ClassDesc of2 = ClassDesc.of("java.lang.String");
        CD_String = of2;
        ClassDesc of3 = ClassDesc.of("java.lang.Class");
        CD_Class = of3;
        CD_Number = ClassDesc.of("java.lang.Number");
        CD_Integer = ClassDesc.of("java.lang.Integer");
        CD_Long = ClassDesc.of("java.lang.Long");
        CD_Float = ClassDesc.of("java.lang.Float");
        CD_Double = ClassDesc.of("java.lang.Double");
        CD_Short = ClassDesc.of("java.lang.Short");
        CD_Byte = ClassDesc.of("java.lang.Byte");
        CD_Character = ClassDesc.of("java.lang.Character");
        ClassDesc of4 = ClassDesc.of("java.lang.Boolean");
        CD_Boolean = of4;
        CD_Void = ClassDesc.of("java.lang.Void");
        CD_Throwable = ClassDesc.of("java.lang.Throwable");
        CD_Exception = ClassDesc.of("java.lang.Exception");
        ClassDesc of5 = ClassDesc.of("java.lang.Enum");
        CD_Enum = of5;
        ClassDesc of6 = ClassDesc.of("java.lang.invoke.VarHandle");
        CD_VarHandle = of6;
        ClassDesc of7 = ClassDesc.of("java.lang.invoke.MethodHandles");
        CD_MethodHandles = of7;
        ClassDesc nested = of7.nested("Lookup");
        CD_MethodHandles_Lookup = nested;
        ClassDesc of8 = ClassDesc.of("java.lang.invoke.MethodHandle");
        CD_MethodHandle = of8;
        ClassDesc of9 = ClassDesc.of("java.lang.invoke.MethodType");
        CD_MethodType = of9;
        CD_CallSite = ClassDesc.of("java.lang.invoke.CallSite");
        CD_Collection = ClassDesc.of("java.util.Collection");
        CD_List = ClassDesc.of("java.util.List");
        CD_Set = ClassDesc.of("java.util.Set");
        CD_Map = ClassDesc.of("java.util.Map");
        CD_ConstantDesc = ClassDesc.of("java.lang.constant.ConstantDesc");
        CD_ClassDesc = ClassDesc.of("java.lang.constant.ClassDesc");
        CD_EnumDesc = of5.nested("EnumDesc");
        CD_MethodTypeDesc = ClassDesc.of("java.lang.constant.MethodTypeDesc");
        CD_MethodHandleDesc = ClassDesc.of("java.lang.constant.MethodHandleDesc");
        ClassDesc of10 = ClassDesc.of("java.lang.constant.DirectMethodHandleDesc");
        CD_DirectMethodHandleDesc = of10;
        CD_VarHandleDesc = of6.nested("VarHandleDesc");
        CD_MethodHandleDesc_Kind = of10.nested("Kind");
        CD_DynamicConstantDesc = ClassDesc.of("java.lang.constant.DynamicConstantDesc");
        CD_DynamicCallSiteDesc = ClassDesc.of("java.lang.constant.DynamicCallSiteDesc");
        ClassDesc of11 = ClassDesc.of("java.lang.invoke.ConstantBootstraps");
        CD_ConstantBootstraps = of11;
        INDY_BOOTSTRAP_ARGS = new ClassDesc[]{nested, of2, of9};
        CONDY_BOOTSTRAP_ARGS = new ClassDesc[]{nested, of2, of3};
        BSM_PRIMITIVE_CLASS = ofConstantBootstrap(of11, "primitiveClass", of3, new ClassDesc[0]);
        BSM_ENUM_CONSTANT = ofConstantBootstrap(of11, "enumConstant", of5, new ClassDesc[0]);
        DirectMethodHandleDesc ofConstantBootstrap = ofConstantBootstrap(of11, "getStaticFinal", of, of3);
        BSM_GET_STATIC_FINAL = ofConstantBootstrap;
        DirectMethodHandleDesc ofConstantBootstrap2 = ofConstantBootstrap(of11, "nullConstant", of, new ClassDesc[0]);
        BSM_NULL_CONSTANT = ofConstantBootstrap2;
        BSM_VARHANDLE_FIELD = ofConstantBootstrap(of11, "fieldVarHandle", of6, of3, of3);
        BSM_VARHANDLE_STATIC_FIELD = ofConstantBootstrap(of11, "staticFieldVarHandle", of6, of3, of3);
        BSM_VARHANDLE_ARRAY = ofConstantBootstrap(of11, "arrayVarHandle", of6, of3);
        BSM_INVOKE = ofConstantBootstrap(of11, "invoke", of, of8, of.arrayType());
        BSM_EXPLICIT_CAST = ofConstantBootstrap(of11, "explicitCast", of, of);
        CD_int = ClassDesc.ofDescriptor("I");
        CD_long = ClassDesc.ofDescriptor(ContentClassification.AD_CONTENT_CLASSIFICATION_J);
        CD_float = ClassDesc.ofDescriptor("F");
        CD_double = ClassDesc.ofDescriptor("D");
        CD_short = ClassDesc.ofDescriptor(ExifInterface.LATITUDE_SOUTH);
        CD_byte = ClassDesc.ofDescriptor("B");
        CD_char = ClassDesc.ofDescriptor("C");
        CD_boolean = ClassDesc.ofDescriptor("Z");
        CD_void = ClassDesc.ofDescriptor(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        NULL = DynamicConstantDesc.ofNamed(ofConstantBootstrap2, "_", of, new ConstantDesc[0]);
        TRUE = DynamicConstantDesc.ofNamed(ofConstantBootstrap, "TRUE", of4, of4);
        FALSE = DynamicConstantDesc.ofNamed(ofConstantBootstrap, "FALSE", of4, of4);
        MHD_METHODHANDLE_ASTYPE = MethodHandleDesc.ofMethod(DirectMethodHandleDesc.Kind.VIRTUAL, of8, "asType", MethodTypeDesc.of(of8, of9));
    }

    public static DirectMethodHandleDesc ofCallsiteBootstrap(ClassDesc owner, String name, ClassDesc returnType, ClassDesc... paramTypes) {
        return MethodHandleDesc.ofMethod(DirectMethodHandleDesc.Kind.STATIC, owner, name, MethodTypeDesc.of(returnType, paramTypes).insertParameterTypes(0, INDY_BOOTSTRAP_ARGS));
    }

    public static DirectMethodHandleDesc ofConstantBootstrap(ClassDesc owner, String name, ClassDesc returnType, ClassDesc... paramTypes) {
        return MethodHandleDesc.ofMethod(DirectMethodHandleDesc.Kind.STATIC, owner, name, MethodTypeDesc.of(returnType, paramTypes).insertParameterTypes(0, CONDY_BOOTSTRAP_ARGS));
    }
}
