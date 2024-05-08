package sun.nio.fs;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixMountEntry {
    private long dev;
    private byte[] dir;
    private byte[] fstype;
    private volatile String fstypeAsString;
    private byte[] name;
    private volatile String optionsAsString;
    private byte[] opts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String name() {
        return Util.toString(this.name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String fstype() {
        if (this.fstypeAsString == null) {
            this.fstypeAsString = Util.toString(this.fstype);
        }
        return this.fstypeAsString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] dir() {
        return this.dir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dev() {
        return this.dev;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasOption(String requested) {
        if (this.optionsAsString == null) {
            this.optionsAsString = Util.toString(this.opts);
        }
        for (String opt : Util.split(this.optionsAsString, ',')) {
            if (opt.equals(requested)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIgnored() {
        return hasOption("ignore");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReadOnly() {
        return hasOption("ro");
    }
}
