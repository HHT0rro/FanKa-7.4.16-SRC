package javax.security.auth;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.DomainCombiner;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.text.MessageFormat;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import sun.security.util.ResourcesMgr;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Subject implements Serializable {
    private static final ProtectionDomain[] NULL_PD_ARRAY = new ProtectionDomain[0];
    private static final int PRINCIPAL_SET = 1;
    private static final int PRIV_CREDENTIAL_SET = 3;
    private static final int PUB_CREDENTIAL_SET = 2;
    private static final long serialVersionUID = -8308522755600156056L;
    Set<Principal> principals;
    transient Set<Object> privCredentials;
    transient Set<Object> pubCredentials;
    private volatile boolean readOnly;

    public Subject() {
        this.readOnly = false;
        this.principals = Collections.synchronizedSet(new SecureSet(this, 1));
        this.pubCredentials = Collections.synchronizedSet(new SecureSet(this, 2));
        this.privCredentials = Collections.synchronizedSet(new SecureSet(this, 3));
    }

    public Subject(boolean readOnly, Set<? extends Principal> principals, Set<?> pubCredentials, Set<?> privCredentials) {
        this.readOnly = false;
        if (principals == null || pubCredentials == null || privCredentials == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.input.s."));
        }
        this.principals = Collections.synchronizedSet(new SecureSet(this, 1, principals));
        this.pubCredentials = Collections.synchronizedSet(new SecureSet(this, 2, pubCredentials));
        this.privCredentials = Collections.synchronizedSet(new SecureSet(this, 3, privCredentials));
        this.readOnly = readOnly;
    }

    public void setReadOnly() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(AuthPermissionHolder.SET_READ_ONLY_PERMISSION);
        }
        this.readOnly = true;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public static Subject getSubject(final AccessControlContext acc) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(AuthPermissionHolder.GET_SUBJECT_PERMISSION);
        }
        if (acc == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.AccessControlContext.provided"));
        }
        return (Subject) AccessController.doPrivileged(new PrivilegedAction<Subject>() { // from class: javax.security.auth.Subject.1
            @Override // java.security.PrivilegedAction
            public Subject run() {
                DomainCombiner dc2 = AccessControlContext.this.getDomainCombiner();
                if (!(dc2 instanceof SubjectDomainCombiner)) {
                    return null;
                }
                SubjectDomainCombiner sdc = (SubjectDomainCombiner) dc2;
                return sdc.getSubject();
            }
        });
    }

    public static <T> T doAs(Subject subject, PrivilegedAction<T> privilegedAction) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(AuthPermissionHolder.DO_AS_PERMISSION);
        }
        if (privilegedAction == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.action.provided"));
        }
        return (T) AccessController.doPrivileged(privilegedAction, createContext(subject, AccessController.getContext()));
    }

    public static <T> T doAs(Subject subject, PrivilegedExceptionAction<T> privilegedExceptionAction) throws PrivilegedActionException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(AuthPermissionHolder.DO_AS_PERMISSION);
        }
        if (privilegedExceptionAction == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.action.provided"));
        }
        return (T) AccessController.doPrivileged(privilegedExceptionAction, createContext(subject, AccessController.getContext()));
    }

    public static <T> T doAsPrivileged(Subject subject, PrivilegedAction<T> privilegedAction, AccessControlContext accessControlContext) {
        AccessControlContext accessControlContext2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(AuthPermissionHolder.DO_AS_PRIVILEGED_PERMISSION);
        }
        if (privilegedAction == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.action.provided"));
        }
        if (accessControlContext == null) {
            accessControlContext2 = new AccessControlContext(NULL_PD_ARRAY);
        } else {
            accessControlContext2 = accessControlContext;
        }
        return (T) AccessController.doPrivileged(privilegedAction, createContext(subject, accessControlContext2));
    }

    public static <T> T doAsPrivileged(Subject subject, PrivilegedExceptionAction<T> privilegedExceptionAction, AccessControlContext accessControlContext) throws PrivilegedActionException {
        AccessControlContext accessControlContext2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(AuthPermissionHolder.DO_AS_PRIVILEGED_PERMISSION);
        }
        if (privilegedExceptionAction == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.action.provided"));
        }
        if (accessControlContext == null) {
            accessControlContext2 = new AccessControlContext(NULL_PD_ARRAY);
        } else {
            accessControlContext2 = accessControlContext;
        }
        return (T) AccessController.doPrivileged(privilegedExceptionAction, createContext(subject, accessControlContext2));
    }

    private static AccessControlContext createContext(Subject subject, final AccessControlContext acc) {
        return (AccessControlContext) AccessController.doPrivileged(new PrivilegedAction<AccessControlContext>() { // from class: javax.security.auth.Subject.2
            @Override // java.security.PrivilegedAction
            public AccessControlContext run() {
                Subject subject2 = Subject.this;
                if (subject2 == null) {
                    return new AccessControlContext(acc, (DomainCombiner) null);
                }
                return new AccessControlContext(acc, new SubjectDomainCombiner(subject2));
            }
        });
    }

    public Set<Principal> getPrincipals() {
        return this.principals;
    }

    public <T extends Principal> Set<T> getPrincipals(Class<T> c4) {
        if (c4 == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.Class.provided"));
        }
        return new ClassSet(1, c4);
    }

    public Set<Object> getPublicCredentials() {
        return this.pubCredentials;
    }

    public Set<Object> getPrivateCredentials() {
        return this.privCredentials;
    }

    public <T> Set<T> getPublicCredentials(Class<T> c4) {
        if (c4 == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.Class.provided"));
        }
        return new ClassSet(2, c4);
    }

    public <T> Set<T> getPrivateCredentials(Class<T> c4) {
        if (c4 == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.Class.provided"));
        }
        return new ClassSet(3, c4);
    }

    public boolean equals(Object o10) {
        Set<Principal> thatPrincipals;
        Set<Object> thatPubCredentials;
        Set<Object> thatPrivCredentials;
        if (o10 == null) {
            return false;
        }
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof Subject)) {
            return false;
        }
        Subject that = (Subject) o10;
        synchronized (that.principals) {
            thatPrincipals = new HashSet<>(that.principals);
        }
        if (!this.principals.equals(thatPrincipals)) {
            return false;
        }
        synchronized (that.pubCredentials) {
            thatPubCredentials = new HashSet<>(that.pubCredentials);
        }
        if (!this.pubCredentials.equals(thatPubCredentials)) {
            return false;
        }
        synchronized (that.privCredentials) {
            thatPrivCredentials = new HashSet<>(that.privCredentials);
        }
        if (!this.privCredentials.equals(thatPrivCredentials)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return toString(true);
    }

    String toString(boolean includePrivateCredentials) {
        String s2 = ResourcesMgr.getString("Subject.");
        String suffix = "";
        synchronized (this.principals) {
            for (Principal p10 : this.principals) {
                suffix = suffix + ResourcesMgr.getString(".Principal.") + p10.toString() + ResourcesMgr.getString("NEWLINE");
            }
        }
        synchronized (this.pubCredentials) {
            for (Object o10 : this.pubCredentials) {
                suffix = suffix + ResourcesMgr.getString(".Public.Credential.") + o10.toString() + ResourcesMgr.getString("NEWLINE");
            }
        }
        if (includePrivateCredentials) {
            synchronized (this.privCredentials) {
                for (Object o11 : this.privCredentials) {
                    try {
                        suffix = suffix + ResourcesMgr.getString(".Private.Credential.") + o11.toString() + ResourcesMgr.getString("NEWLINE");
                    } catch (SecurityException e2) {
                        suffix = suffix + ResourcesMgr.getString(".Private.Credential.inaccessible.");
                    }
                }
            }
        }
        return s2 + suffix;
    }

    public int hashCode() {
        int hashCode = 0;
        synchronized (this.principals) {
            for (Principal p10 : this.principals) {
                hashCode ^= p10.hashCode();
            }
        }
        synchronized (this.pubCredentials) {
            Iterator<Object> pubCIterator = this.pubCredentials.iterator2();
            while (pubCIterator.hasNext()) {
                hashCode ^= getCredHashCode(pubCIterator.next());
            }
        }
        return hashCode;
    }

    private int getCredHashCode(Object o10) {
        try {
            return o10.hashCode();
        } catch (IllegalStateException e2) {
            return o10.getClass().toString().hashCode();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        synchronized (this.principals) {
            oos.defaultWriteObject();
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gf = s2.readFields();
        this.readOnly = gf.get("readOnly", false);
        Set<Principal> inputPrincs = (Set) gf.get("principals", (Object) null);
        if (inputPrincs == null) {
            throw new NullPointerException(ResourcesMgr.getString("invalid.null.input.s."));
        }
        try {
            this.principals = Collections.synchronizedSet(new SecureSet(this, 1, inputPrincs));
        } catch (NullPointerException e2) {
            this.principals = Collections.synchronizedSet(new SecureSet(this, 1));
        }
        this.pubCredentials = Collections.synchronizedSet(new SecureSet(this, 2));
        this.privCredentials = Collections.synchronizedSet(new SecureSet(this, 3));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SecureSet<E> extends AbstractSet<E> implements Serializable {
        private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("this$0", Subject.class), new ObjectStreamField("elements", LinkedList.class), new ObjectStreamField("which", Integer.TYPE)};
        private static final long serialVersionUID = 7911754171111800359L;
        LinkedList<E> elements;
        Subject subject;
        private int which;

        SecureSet(Subject subject, int which) {
            this.subject = subject;
            this.which = which;
            this.elements = new LinkedList<>();
        }

        SecureSet(Subject subject, int which, Set<? extends E> set) {
            this.subject = subject;
            this.which = which;
            this.elements = new LinkedList<>(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.elements.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            LinkedList<E> list = this.elements;
            return new Iterator<E>(list) { // from class: javax.security.auth.Subject.SecureSet.1

                /* renamed from: i, reason: collision with root package name */
                ListIterator<E> f50552i;
                final /* synthetic */ LinkedList val$list;

                {
                    this.val$list = list;
                    this.f50552i = list.listIterator(0);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f50552i.hasNext();
                }

                @Override // java.util.Iterator
                public E next() {
                    if (SecureSet.this.which != 3) {
                        return this.f50552i.next();
                    }
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        try {
                            sm.checkPermission(new PrivateCredentialPermission(this.val$list.get(this.f50552i.nextIndex()).getClass().getName(), SecureSet.this.subject.getPrincipals()));
                        } catch (SecurityException se) {
                            this.f50552i.next();
                            throw se;
                        }
                    }
                    return this.f50552i.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (SecureSet.this.subject.isReadOnly()) {
                        throw new IllegalStateException(ResourcesMgr.getString("Subject.is.read.only"));
                    }
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        switch (SecureSet.this.which) {
                            case 1:
                                sm.checkPermission(AuthPermissionHolder.MODIFY_PRINCIPALS_PERMISSION);
                                break;
                            case 2:
                                sm.checkPermission(AuthPermissionHolder.MODIFY_PUBLIC_CREDENTIALS_PERMISSION);
                                break;
                            default:
                                sm.checkPermission(AuthPermissionHolder.MODIFY_PRIVATE_CREDENTIALS_PERMISSION);
                                break;
                        }
                    }
                    this.f50552i.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E o10) {
            if (this.subject.isReadOnly()) {
                throw new IllegalStateException(ResourcesMgr.getString("Subject.is.read.only"));
            }
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                switch (this.which) {
                    case 1:
                        sm.checkPermission(AuthPermissionHolder.MODIFY_PRINCIPALS_PERMISSION);
                        break;
                    case 2:
                        sm.checkPermission(AuthPermissionHolder.MODIFY_PUBLIC_CREDENTIALS_PERMISSION);
                        break;
                    default:
                        sm.checkPermission(AuthPermissionHolder.MODIFY_PRIVATE_CREDENTIALS_PERMISSION);
                        break;
                }
            }
            switch (this.which) {
                case 1:
                    if (!(o10 instanceof Principal)) {
                        throw new SecurityException(ResourcesMgr.getString("attempting.to.add.an.object.which.is.not.an.instance.of.java.security.Principal.to.a.Subject.s.Principal.Set"));
                    }
                    break;
            }
            if (!this.elements.contains(o10)) {
                return this.elements.add(o10);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            Object doPrivileged;
            final Iterator<E> e2 = iterator2();
            while (e2.hasNext()) {
                if (this.which != 3) {
                    doPrivileged = e2.next();
                } else {
                    doPrivileged = AccessController.doPrivileged(new PrivilegedAction<E>() { // from class: javax.security.auth.Subject.SecureSet.2
                        @Override // java.security.PrivilegedAction
                        public E run() {
                            return (E) e2.next();
                        }
                    });
                }
                if (doPrivileged == null) {
                    if (o10 == null) {
                        e2.remove();
                        return true;
                    }
                } else if (doPrivileged.equals(o10)) {
                    e2.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            Object next;
            final Iterator<E> e2 = iterator2();
            while (e2.hasNext()) {
                if (this.which != 3) {
                    next = e2.next();
                } else {
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkPermission(new PrivateCredentialPermission(o10.getClass().getName(), this.subject.getPrincipals()));
                    }
                    next = AccessController.doPrivileged(new PrivilegedAction<E>() { // from class: javax.security.auth.Subject.SecureSet.3
                        @Override // java.security.PrivilegedAction
                        public E run() {
                            return (E) e2.next();
                        }
                    });
                }
                if (next == null) {
                    if (o10 == null) {
                        return true;
                    }
                } else if (next.equals(o10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            Object doPrivileged;
            Objects.requireNonNull(c4);
            boolean modified = false;
            final Iterator<E> e2 = iterator2();
            while (e2.hasNext()) {
                if (this.which != 3) {
                    doPrivileged = e2.next();
                } else {
                    doPrivileged = AccessController.doPrivileged(new PrivilegedAction<E>() { // from class: javax.security.auth.Subject.SecureSet.4
                        @Override // java.security.PrivilegedAction
                        public E run() {
                            return (E) e2.next();
                        }
                    });
                }
                Iterator<?> ce2 = c4.iterator2();
                while (true) {
                    if (ce2.hasNext()) {
                        Object o10 = ce2.next();
                        if (doPrivileged == null) {
                            if (o10 == null) {
                                e2.remove();
                                modified = true;
                                break;
                            }
                        } else if (doPrivileged.equals(o10)) {
                            e2.remove();
                            modified = true;
                            break;
                        }
                    }
                }
            }
            return modified;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c4) {
            Object doPrivileged;
            Objects.requireNonNull(c4);
            boolean modified = false;
            final Iterator<E> e2 = iterator2();
            while (e2.hasNext()) {
                boolean retain = false;
                if (this.which != 3) {
                    doPrivileged = e2.next();
                } else {
                    doPrivileged = AccessController.doPrivileged(new PrivilegedAction<E>() { // from class: javax.security.auth.Subject.SecureSet.5
                        @Override // java.security.PrivilegedAction
                        public E run() {
                            return (E) e2.next();
                        }
                    });
                }
                Iterator<?> ce2 = c4.iterator2();
                while (true) {
                    if (!ce2.hasNext()) {
                        break;
                    }
                    Object o10 = ce2.next();
                    if (doPrivileged == null) {
                        if (o10 == null) {
                            retain = true;
                            break;
                        }
                    } else if (doPrivileged.equals(o10)) {
                        retain = true;
                        break;
                    }
                }
                if (!retain) {
                    e2.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            final Iterator<E> e2 = iterator2();
            while (e2.hasNext()) {
                if (this.which != 3) {
                    e2.next();
                } else {
                    AccessController.doPrivileged(new PrivilegedAction<E>() { // from class: javax.security.auth.Subject.SecureSet.6
                        @Override // java.security.PrivilegedAction
                        public E run() {
                            return (E) e2.next();
                        }
                    });
                }
                e2.remove();
            }
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            if (this.which == 3) {
                Iterator<E> i10 = iterator2();
                while (i10.hasNext()) {
                    i10.next();
                }
            }
            ObjectOutputStream.PutField fields = oos.putFields();
            fields.put("this$0", this.subject);
            fields.put("elements", this.elements);
            fields.put("which", this.which);
            oos.writeFields();
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ObjectInputStream.GetField fields = ois.readFields();
            this.subject = (Subject) fields.get("this$0", (Object) null);
            this.which = fields.get("which", 0);
            LinkedList<E> tmp = (LinkedList) fields.get("elements", (Object) null);
            if (tmp.getClass() != LinkedList.class) {
                this.elements = new LinkedList<>(tmp);
            } else {
                this.elements = tmp;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class ClassSet<T> extends AbstractSet<T> {

        /* renamed from: c, reason: collision with root package name */
        private Class<T> f50551c;
        private Set<T> set = new HashSet();
        private int which;

        ClassSet(int which, Class<T> c4) {
            this.which = which;
            this.f50551c = c4;
            switch (which) {
                case 1:
                    synchronized (Subject.this.principals) {
                        populateSet();
                    }
                    return;
                case 2:
                    synchronized (Subject.this.pubCredentials) {
                        populateSet();
                    }
                    return;
                default:
                    synchronized (Subject.this.privCredentials) {
                        populateSet();
                    }
                    return;
            }
        }

        private void populateSet() {
            final Iterator<Principal> iterator2;
            Object next;
            switch (this.which) {
                case 1:
                    iterator2 = Subject.this.principals.iterator2();
                    break;
                case 2:
                    iterator2 = Subject.this.pubCredentials.iterator2();
                    break;
                default:
                    iterator2 = Subject.this.privCredentials.iterator2();
                    break;
            }
            while (iterator2.hasNext()) {
                if (this.which == 3) {
                    next = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: javax.security.auth.Subject.ClassSet.1
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            return iterator2.next();
                        }
                    });
                } else {
                    next = iterator2.next();
                }
                if (this.f50551c.isAssignableFrom(next.getClass())) {
                    if (this.which != 3) {
                        this.set.add(next);
                    } else {
                        SecurityManager securityManager = System.getSecurityManager();
                        if (securityManager != null) {
                            securityManager.checkPermission(new PrivateCredentialPermission(next.getClass().getName(), Subject.this.getPrincipals()));
                        }
                        this.set.add(next);
                    }
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.set.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return this.set.iterator2();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(T o10) {
            if (!o10.getClass().isAssignableFrom(this.f50551c)) {
                MessageFormat form = new MessageFormat(ResourcesMgr.getString("attempting.to.add.an.object.which.is.not.an.instance.of.class"));
                Object[] source = {this.f50551c.toString()};
                throw new SecurityException(form.format(source));
            }
            return this.set.add(o10);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class AuthPermissionHolder {
        static final AuthPermission DO_AS_PERMISSION = new AuthPermission("doAs");
        static final AuthPermission DO_AS_PRIVILEGED_PERMISSION = new AuthPermission("doAsPrivileged");
        static final AuthPermission SET_READ_ONLY_PERMISSION = new AuthPermission("setReadOnly");
        static final AuthPermission GET_SUBJECT_PERMISSION = new AuthPermission("getSubject");
        static final AuthPermission MODIFY_PRINCIPALS_PERMISSION = new AuthPermission("modifyPrincipals");
        static final AuthPermission MODIFY_PUBLIC_CREDENTIALS_PERMISSION = new AuthPermission("modifyPublicCredentials");
        static final AuthPermission MODIFY_PRIVATE_CREDENTIALS_PERMISSION = new AuthPermission("modifyPrivateCredentials");

        AuthPermissionHolder() {
        }
    }
}
