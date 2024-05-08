package java.lang.invoke;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MethodHandleImpl extends MethodHandle implements Cloneable {
    private HandleInfo info;

    public native Member getMemberInternal();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodHandleImpl(long artFieldOrMethod, int handleKind, MethodType type) {
        super(artFieldOrMethod, handleKind, type);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodHandleInfo reveal() {
        if (this.info == null) {
            Member member = getMemberInternal();
            this.info = new HandleInfo(member, this);
        }
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HandleInfo implements MethodHandleInfo {
        private final MethodHandle handle;
        private final Member member;

        HandleInfo(Member member, MethodHandle handle) {
            this.member = member;
            this.handle = handle;
        }

        @Override // java.lang.invoke.MethodHandleInfo
        public int getReferenceKind() {
            switch (this.handle.getHandleKind()) {
                case 0:
                    if (this.member.getDeclaringClass().isInterface()) {
                        return 9;
                    }
                    return 5;
                case 1:
                    return 7;
                case 2:
                    return this.member instanceof Constructor ? 8 : 7;
                case 3:
                    return 6;
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    throw new AssertionError((Object) ("Unexpected handle kind: " + this.handle.getHandleKind()));
                case 8:
                    return 1;
                case 9:
                    return 3;
                case 10:
                    return 2;
                case 11:
                    return 4;
            }
        }

        @Override // java.lang.invoke.MethodHandleInfo
        public Class<?> getDeclaringClass() {
            return this.member.getDeclaringClass();
        }

        @Override // java.lang.invoke.MethodHandleInfo
        public String getName() {
            Member member = this.member;
            if (member instanceof Constructor) {
                return "<init>";
            }
            return member.getName();
        }

        @Override // java.lang.invoke.MethodHandleInfo
        public MethodType getMethodType() {
            MethodType handleType = this.handle.type();
            boolean omitLeadingParam = false;
            if (this.member instanceof Constructor) {
                handleType = handleType.changeReturnType((Class<?>) Void.TYPE);
                omitLeadingParam = true;
            }
            switch (this.handle.getHandleKind()) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 8:
                case 9:
                    omitLeadingParam = true;
                    break;
            }
            return omitLeadingParam ? handleType.dropParameterTypes(0, 1) : handleType;
        }

        @Override // java.lang.invoke.MethodHandleInfo
        public <T extends Member> T reflectAs(Class<T> cls, MethodHandles.Lookup lookup) {
            try {
                Class<?> declaringClass = this.member.getDeclaringClass();
                if (Modifier.isNative(getModifiers()) && (MethodHandle.class.isAssignableFrom(declaringClass) || VarHandle.class.isAssignableFrom(declaringClass))) {
                    Member member = this.member;
                    if ((member instanceof Method) && ((Method) member).isVarArgs()) {
                        throw new IllegalArgumentException("Reflecting signature polymorphic method");
                    }
                }
                lookup.checkAccess(declaringClass, declaringClass, this.member.getModifiers(), this.member.getName());
                return (T) this.member;
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException("Unable to access member.", e2);
            }
        }

        @Override // java.lang.invoke.MethodHandleInfo
        public int getModifiers() {
            return this.member.getModifiers();
        }

        public String toString() {
            return MethodHandleInfo.toString(getReferenceKind(), getDeclaringClass(), getName(), getMethodType());
        }
    }
}
