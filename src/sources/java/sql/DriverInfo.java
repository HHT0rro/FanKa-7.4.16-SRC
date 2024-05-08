package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: DriverManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class DriverInfo {
    final Driver driver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverInfo(Driver driver) {
        this.driver = driver;
    }

    public boolean equals(Object other) {
        return (other instanceof DriverInfo) && this.driver == ((DriverInfo) other).driver;
    }

    public int hashCode() {
        return this.driver.hashCode();
    }

    public String toString() {
        return "driver[className=" + ((Object) this.driver) + "]";
    }
}
