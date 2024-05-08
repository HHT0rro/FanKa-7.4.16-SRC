package java.nio.file.attribute;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 java.nio.file.attribute.AclEntryPermission, still in use, count: 1, list:
  (r0v0 java.nio.file.attribute.AclEntryPermission) from 0x0098: SPUT (r0v0 java.nio.file.attribute.AclEntryPermission) (LINE:119) java.nio.file.attribute.AclEntryPermission.LIST_DIRECTORY java.nio.file.attribute.AclEntryPermission
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:238)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class AclEntryPermission {
    READ_DATA,
    WRITE_DATA,
    APPEND_DATA,
    READ_NAMED_ATTRS,
    WRITE_NAMED_ATTRS,
    EXECUTE,
    DELETE_CHILD,
    READ_ATTRIBUTES,
    WRITE_ATTRIBUTES,
    DELETE,
    READ_ACL,
    WRITE_ACL,
    WRITE_OWNER,
    SYNCHRONIZE;

    public static final AclEntryPermission LIST_DIRECTORY = new AclEntryPermission();
    public static final AclEntryPermission ADD_FILE = new AclEntryPermission();
    public static final AclEntryPermission ADD_SUBDIRECTORY = new AclEntryPermission();

    private AclEntryPermission() {
    }

    public static AclEntryPermission valueOf(String name) {
        return (AclEntryPermission) Enum.valueOf(AclEntryPermission.class, name);
    }

    public static AclEntryPermission[] values() {
        return (AclEntryPermission[]) $VALUES.clone();
    }

    static {
    }
}
