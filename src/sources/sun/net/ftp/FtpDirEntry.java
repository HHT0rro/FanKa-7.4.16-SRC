package sun.net.ftp;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FtpDirEntry {
    private Date created;
    private HashMap<String, String> facts;
    private String group;
    private Date lastModified;
    private final String name;
    private boolean[][] permissions;
    private long size;
    private Type type;
    private String user;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Type {
        FILE,
        DIR,
        PDIR,
        CDIR,
        LINK
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Permission {
        USER(0),
        GROUP(1),
        OTHERS(2);

        int value;

        Permission(int v2) {
            this.value = v2;
        }
    }

    private FtpDirEntry() {
        this.user = null;
        this.group = null;
        this.size = -1L;
        this.created = null;
        this.lastModified = null;
        this.type = Type.FILE;
        this.permissions = null;
        this.facts = new HashMap<>();
        this.name = null;
    }

    public FtpDirEntry(String name) {
        this.user = null;
        this.group = null;
        this.size = -1L;
        this.created = null;
        this.lastModified = null;
        this.type = Type.FILE;
        this.permissions = null;
        this.facts = new HashMap<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getUser() {
        return this.user;
    }

    public FtpDirEntry setUser(String user) {
        this.user = user;
        return this;
    }

    public String getGroup() {
        return this.group;
    }

    public FtpDirEntry setGroup(String group) {
        this.group = group;
        return this;
    }

    public long getSize() {
        return this.size;
    }

    public FtpDirEntry setSize(long size) {
        this.size = size;
        return this;
    }

    public Type getType() {
        return this.type;
    }

    public FtpDirEntry setType(Type type) {
        this.type = type;
        return this;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public FtpDirEntry setLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public boolean canRead(Permission p10) {
        boolean[][] zArr = this.permissions;
        if (zArr != null) {
            return zArr[p10.value][0];
        }
        return false;
    }

    public boolean canWrite(Permission p10) {
        boolean[][] zArr = this.permissions;
        if (zArr != null) {
            return zArr[p10.value][1];
        }
        return false;
    }

    public boolean canExexcute(Permission p10) {
        boolean[][] zArr = this.permissions;
        if (zArr != null) {
            return zArr[p10.value][2];
        }
        return false;
    }

    public FtpDirEntry setPermissions(boolean[][] permissions) {
        this.permissions = permissions;
        return this;
    }

    public FtpDirEntry addFact(String fact, String value) {
        this.facts.put(fact.toLowerCase(), value);
        return this;
    }

    public String getFact(String fact) {
        return this.facts.get(fact.toLowerCase());
    }

    public Date getCreated() {
        return this.created;
    }

    public FtpDirEntry setCreated(Date created) {
        this.created = created;
        return this;
    }

    public String toString() {
        if (this.lastModified == null) {
            return this.name + " [" + ((Object) this.type) + "] (" + this.user + " / " + this.group + ") " + this.size;
        }
        return this.name + " [" + ((Object) this.type) + "] (" + this.user + " / " + this.group + ") {" + this.size + "} " + DateFormat.getDateInstance().format(this.lastModified);
    }
}
