package java.nio.file.attribute;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class AclEntry {
    private final Set<AclEntryFlag> flags;
    private volatile int hash;
    private final Set<AclEntryPermission> perms;
    private final AclEntryType type;
    private final UserPrincipal who;

    private AclEntry(AclEntryType type, UserPrincipal who, Set<AclEntryPermission> perms, Set<AclEntryFlag> flags) {
        this.type = type;
        this.who = who;
        this.perms = perms;
        this.flags = flags;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Set<AclEntryFlag> flags;
        private Set<AclEntryPermission> perms;
        private AclEntryType type;
        private UserPrincipal who;

        private Builder(AclEntryType type, UserPrincipal who, Set<AclEntryPermission> perms, Set<AclEntryFlag> flags) {
            this.type = type;
            this.who = who;
            this.perms = perms;
            this.flags = flags;
        }

        public AclEntry build() {
            AclEntryType aclEntryType = this.type;
            if (aclEntryType == null) {
                throw new IllegalStateException("Missing type component");
            }
            UserPrincipal userPrincipal = this.who;
            if (userPrincipal == null) {
                throw new IllegalStateException("Missing who component");
            }
            return new AclEntry(aclEntryType, userPrincipal, this.perms, this.flags);
        }

        public Builder setType(AclEntryType type) {
            if (type == null) {
                throw new NullPointerException();
            }
            this.type = type;
            return this;
        }

        public Builder setPrincipal(UserPrincipal who) {
            if (who == null) {
                throw new NullPointerException();
            }
            this.who = who;
            return this;
        }

        private static void checkSet(Set<?> set, Class<?> type) {
            for (Object e2 : set) {
                if (e2 == null) {
                    throw new NullPointerException();
                }
                type.cast(e2);
            }
        }

        public Builder setPermissions(Set<AclEntryPermission> perms) {
            Set<AclEntryPermission> perms2;
            if (perms.isEmpty()) {
                perms2 = Collections.emptySet();
            } else {
                perms2 = EnumSet.copyOf((Collection) perms);
                checkSet(perms2, AclEntryPermission.class);
            }
            this.perms = perms2;
            return this;
        }

        public Builder setPermissions(AclEntryPermission... perms) {
            Set<AclEntryPermission> set = EnumSet.noneOf(AclEntryPermission.class);
            for (AclEntryPermission p10 : perms) {
                if (p10 == null) {
                    throw new NullPointerException();
                }
                set.add(p10);
            }
            this.perms = set;
            return this;
        }

        public Builder setFlags(Set<AclEntryFlag> flags) {
            Set<AclEntryFlag> flags2;
            if (flags.isEmpty()) {
                flags2 = Collections.emptySet();
            } else {
                flags2 = EnumSet.copyOf((Collection) flags);
                checkSet(flags2, AclEntryFlag.class);
            }
            this.flags = flags2;
            return this;
        }

        public Builder setFlags(AclEntryFlag... flags) {
            Set<AclEntryFlag> set = EnumSet.noneOf(AclEntryFlag.class);
            for (AclEntryFlag f10 : flags) {
                if (f10 == null) {
                    throw new NullPointerException();
                }
                set.add(f10);
            }
            this.flags = set;
            return this;
        }
    }

    public static Builder newBuilder() {
        Set<AclEntryPermission> perms = Collections.emptySet();
        Set<AclEntryFlag> flags = Collections.emptySet();
        return new Builder(null, null, perms, flags);
    }

    public static Builder newBuilder(AclEntry entry) {
        return new Builder(entry.type, entry.who, entry.perms, entry.flags);
    }

    public AclEntryType type() {
        return this.type;
    }

    public UserPrincipal principal() {
        return this.who;
    }

    public Set<AclEntryPermission> permissions() {
        return new HashSet(this.perms);
    }

    public Set<AclEntryFlag> flags() {
        return new HashSet(this.flags);
    }

    public boolean equals(Object ob2) {
        if (ob2 == this) {
            return true;
        }
        if (ob2 == null || !(ob2 instanceof AclEntry)) {
            return false;
        }
        AclEntry other = (AclEntry) ob2;
        if (this.type == other.type && this.who.equals(other.who) && this.perms.equals(other.perms) && this.flags.equals(other.flags)) {
            return true;
        }
        return false;
    }

    private static int hash(int h10, Object o10) {
        return (h10 * 127) + o10.hashCode();
    }

    public int hashCode() {
        if (this.hash != 0) {
            return this.hash;
        }
        int h10 = this.type.hashCode();
        this.hash = hash(hash(hash(h10, this.who), this.perms), this.flags);
        return this.hash;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.who.getName());
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        for (AclEntryPermission perm : this.perms) {
            sb2.append(perm.name());
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        }
        sb2.setLength(sb2.length() - 1);
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        if (!this.flags.isEmpty()) {
            for (AclEntryFlag flag : this.flags) {
                sb2.append(flag.name());
                sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            }
            sb2.setLength(sb2.length() - 1);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        sb2.append(this.type.name());
        return sb2.toString();
    }
}
