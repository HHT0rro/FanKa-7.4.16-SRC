package java.security;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class UnresolvedPermissionCollection extends PermissionCollection implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("permissions", Hashtable.class)};
    private static final long serialVersionUID = -7176153071733132400L;
    private transient ConcurrentHashMap<String, List<UnresolvedPermission>> perms = new ConcurrentHashMap<>(11);

    @Override // java.security.PermissionCollection
    public void add(Permission permission) {
        if (!(permission instanceof UnresolvedPermission)) {
            throw new IllegalArgumentException("invalid permission: " + ((Object) permission));
        }
        final UnresolvedPermission up = (UnresolvedPermission) permission;
        this.perms.compute(up.getName(), new BiFunction<String, List<UnresolvedPermission>, List<UnresolvedPermission>>() { // from class: java.security.UnresolvedPermissionCollection.1
            @Override // java.util.function.BiFunction
            public List<UnresolvedPermission> apply(String key, List<UnresolvedPermission> oldValue) {
                if (oldValue == null) {
                    List<UnresolvedPermission> v2 = new CopyOnWriteArrayList<>();
                    v2.add(up);
                    return v2;
                }
                oldValue.add(up);
                return oldValue;
            }
        });
    }

    List<UnresolvedPermission> getUnresolvedPermissions(Permission p10) {
        return this.perms.get(p10.getClass().getName());
    }

    @Override // java.security.PermissionCollection
    public boolean implies(Permission permission) {
        return false;
    }

    @Override // java.security.PermissionCollection
    public Enumeration<Permission> elements() {
        List<Permission> results = new ArrayList<>();
        for (List<UnresolvedPermission> l10 : this.perms.values()) {
            results.addAll(l10);
        }
        return Collections.enumeration(results);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        Hashtable<String, Vector<UnresolvedPermission>> permissions = new Hashtable<>(this.perms.size() * 2);
        Set<Map.Entry<String, List<UnresolvedPermission>>> set = this.perms.entrySet();
        for (Map.Entry<String, List<UnresolvedPermission>> e2 : set) {
            List<UnresolvedPermission> list = e2.getValue();
            Vector<UnresolvedPermission> vec = new Vector<>(list);
            permissions.put(e2.getKey(), vec);
        }
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("permissions", permissions);
        out.writeFields();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        Hashtable<String, Vector<UnresolvedPermission>> permissions = (Hashtable) gfields.get("permissions", (Object) null);
        this.perms = new ConcurrentHashMap<>(permissions.size() * 2);
        Set<Map.Entry<String, Vector<UnresolvedPermission>>> set = permissions.entrySet();
        for (Map.Entry<String, Vector<UnresolvedPermission>> e2 : set) {
            Vector<UnresolvedPermission> vec = e2.getValue();
            List<UnresolvedPermission> list = new CopyOnWriteArrayList<>(vec);
            this.perms.put(e2.getKey(), list);
        }
    }
}
