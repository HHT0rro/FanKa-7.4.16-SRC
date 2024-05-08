package java.lang.constant;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DynamicCallSiteDesc {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ConstantDesc[] bootstrapArgs;
    private final DirectMethodHandleDesc bootstrapMethod;
    private final String invocationName;
    private final MethodTypeDesc invocationType;

    private DynamicCallSiteDesc(DirectMethodHandleDesc bootstrapMethod, String invocationName, MethodTypeDesc invocationType, ConstantDesc[] bootstrapArgs) {
        this.invocationName = ConstantUtils.validateMemberName((String) Objects.requireNonNull(invocationName), true);
        this.invocationType = (MethodTypeDesc) Objects.requireNonNull(invocationType);
        this.bootstrapMethod = (DirectMethodHandleDesc) Objects.requireNonNull(bootstrapMethod);
        this.bootstrapArgs = (ConstantDesc[]) Objects.requireNonNull((ConstantDesc[]) bootstrapArgs.clone());
        int i10 = 0;
        while (true) {
            ConstantDesc[] constantDescArr = this.bootstrapArgs;
            if (i10 >= constantDescArr.length) {
                break;
            }
            Objects.requireNonNull(constantDescArr[i10]);
            i10++;
        }
        int i11 = invocationName.length();
        if (i11 == 0) {
            throw new IllegalArgumentException("Illegal invocation name: " + invocationName);
        }
    }

    public static DynamicCallSiteDesc of(DirectMethodHandleDesc bootstrapMethod, String invocationName, MethodTypeDesc invocationType, ConstantDesc... bootstrapArgs) {
        return new DynamicCallSiteDesc(bootstrapMethod, invocationName, invocationType, bootstrapArgs);
    }

    public static DynamicCallSiteDesc of(DirectMethodHandleDesc bootstrapMethod, String invocationName, MethodTypeDesc invocationType) {
        return new DynamicCallSiteDesc(bootstrapMethod, invocationName, invocationType, ConstantUtils.EMPTY_CONSTANTDESC);
    }

    public static DynamicCallSiteDesc of(DirectMethodHandleDesc bootstrapMethod, MethodTypeDesc invocationType) {
        return of(bootstrapMethod, "_", invocationType);
    }

    public DynamicCallSiteDesc withArgs(ConstantDesc... bootstrapArgs) {
        return new DynamicCallSiteDesc(this.bootstrapMethod, this.invocationName, this.invocationType, bootstrapArgs);
    }

    public DynamicCallSiteDesc withNameAndType(String invocationName, MethodTypeDesc invocationType) {
        return new DynamicCallSiteDesc(this.bootstrapMethod, invocationName, invocationType, this.bootstrapArgs);
    }

    public String invocationName() {
        return this.invocationName;
    }

    public MethodTypeDesc invocationType() {
        return this.invocationType;
    }

    public MethodHandleDesc bootstrapMethod() {
        return this.bootstrapMethod;
    }

    public ConstantDesc[] bootstrapArgs() {
        return (ConstantDesc[]) this.bootstrapArgs.clone();
    }

    public CallSite resolveCallSiteDesc(MethodHandles.Lookup lookup) throws Throwable {
        MethodHandle bsm = (MethodHandle) this.bootstrapMethod.resolveConstantDesc(lookup);
        Object[] args = new Object[this.bootstrapArgs.length + 3];
        args[0] = lookup;
        args[1] = this.invocationName;
        args[2] = this.invocationType.resolveConstantDesc(lookup);
        ConstantDesc[] constantDescArr = this.bootstrapArgs;
        System.arraycopy(constantDescArr, 0, args, 3, constantDescArr.length);
        return (CallSite) bsm.invokeWithArguments(args);
    }

    public final boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        DynamicCallSiteDesc specifier = (DynamicCallSiteDesc) o10;
        if (Objects.equals(this.bootstrapMethod, specifier.bootstrapMethod) && Arrays.equals(this.bootstrapArgs, specifier.bootstrapArgs) && Objects.equals(this.invocationName, specifier.invocationName) && Objects.equals(this.invocationType, specifier.invocationType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = Objects.hash(this.bootstrapMethod, this.invocationName, this.invocationType);
        return (result * 31) + Arrays.hashCode(this.bootstrapArgs);
    }

    public String toString() {
        Object[] objArr = new Object[5];
        objArr[0] = this.bootstrapMethod.owner().displayName();
        objArr[1] = this.bootstrapMethod.methodName();
        objArr[2] = this.invocationName.equals("_") ? "" : this.invocationName + "/";
        objArr[3] = Stream.of((Object[]) this.bootstrapArgs).map(new Function() { // from class: java.lang.constant.DynamicCallSiteDesc$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String obj2;
                obj2 = ((ConstantDesc) obj).toString();
                return obj2;
            }
        }).collect(Collectors.joining(","));
        objArr[4] = this.invocationType.displayDescriptor();
        return String.format("DynamicCallSiteDesc[%s::%s(%s%s):%s]", objArr);
    }
}
