package sun.nio.fs;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalNotFoundException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixUserPrincipals {
    static final User SPECIAL_OWNER = createSpecial("OWNER@");
    static final User SPECIAL_GROUP = createSpecial("GROUP@");
    static final User SPECIAL_EVERYONE = createSpecial("EVERYONE@");

    UnixUserPrincipals() {
    }

    private static User createSpecial(String name) {
        return new User(-1, name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class User implements UserPrincipal {

        /* renamed from: id, reason: collision with root package name */
        private final int f53740id;
        private final boolean isGroup;
        private final String name;

        private User(int id2, boolean isGroup, String name) {
            this.f53740id = id2;
            this.isGroup = isGroup;
            this.name = name;
        }

        User(int id2, String name) {
            this(id2, false, name);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int uid() {
            if (this.isGroup) {
                throw new AssertionError();
            }
            return this.f53740id;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int gid() {
            if (this.isGroup) {
                return this.f53740id;
            }
            throw new AssertionError();
        }

        boolean isSpecial() {
            return this.f53740id == -1;
        }

        @Override // java.security.Principal
        public String getName() {
            return this.name;
        }

        @Override // java.security.Principal
        public String toString() {
            return this.name;
        }

        @Override // java.security.Principal
        public boolean equals(Object obj) {
            User other;
            int i10;
            int i11;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof User) || (i10 = this.f53740id) != (i11 = (other = (User) obj).f53740id) || this.isGroup != other.isGroup) {
                return false;
            }
            if (i10 != -1 || i11 != -1) {
                return true;
            }
            return this.name.equals(other.name);
        }

        @Override // java.security.Principal
        public int hashCode() {
            int i10 = this.f53740id;
            return i10 != -1 ? i10 : this.name.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Group extends User implements GroupPrincipal {
        Group(int id2, String name) {
            super(id2, true, name);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static User fromUid(int uid) {
        String name;
        try {
            name = Util.toString(UnixNativeDispatcher.getpwuid(uid));
        } catch (UnixException e2) {
            name = Integer.toString(uid);
        }
        return new User(uid, name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Group fromGid(int gid) {
        String name;
        try {
            name = Util.toString(UnixNativeDispatcher.getgrgid(gid));
        } catch (UnixException e2) {
            name = Integer.toString(gid);
        }
        return new Group(gid, name);
    }

    private static int lookupName(String name, boolean isGroup) throws IOException {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("lookupUserInformation"));
        }
        try {
            int id2 = isGroup ? UnixNativeDispatcher.getgrnam(name) : UnixNativeDispatcher.getpwnam(name);
            if (id2 == -1) {
                try {
                    return Integer.parseInt(name);
                } catch (NumberFormatException e2) {
                    throw new UserPrincipalNotFoundException(name);
                }
            }
            return id2;
        } catch (UnixException x10) {
            throw new IOException(name + ": " + x10.errorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UserPrincipal lookupUser(String name) throws IOException {
        User user = SPECIAL_OWNER;
        if (name.equals(user.getName())) {
            return user;
        }
        User user2 = SPECIAL_GROUP;
        if (name.equals(user2.getName())) {
            return user2;
        }
        User user3 = SPECIAL_EVERYONE;
        if (name.equals(user3.getName())) {
            return user3;
        }
        int uid = lookupName(name, false);
        return new User(uid, name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GroupPrincipal lookupGroup(String group) throws IOException {
        int gid = lookupName(group, true);
        return new Group(gid, group);
    }
}
