package java.lang;

import com.huawei.openalliance.ad.constant.u;
import java.io.Serializable;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StackTraceElement implements Serializable {
    private static final long serialVersionUID = 6992337162326171013L;
    private String declaringClass;
    private String fileName;
    private int lineNumber;
    private String methodName;

    public StackTraceElement(String declaringClass, String methodName, String fileName, int lineNumber) {
        this.declaringClass = (String) Objects.requireNonNull(declaringClass, "Declaring class is null");
        this.methodName = (String) Objects.requireNonNull(methodName, "Method name is null");
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    private StackTraceElement() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getClassName() {
        return this.declaringClass;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public boolean isNativeMethod() {
        return this.lineNumber == -2;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClassName()).append(".").append(this.methodName);
        if (isNativeMethod()) {
            result.append("(Native Method)");
        } else if (this.fileName != null) {
            if (this.lineNumber >= 0) {
                result.append("(").append(this.fileName).append(u.bD).append(this.lineNumber).append(")");
            } else {
                result.append("(").append(this.fileName).append(")");
            }
        } else if (this.lineNumber >= 0) {
            result.append("(Unknown Source:").append(this.lineNumber).append(")");
        } else {
            result.append("(Unknown Source)");
        }
        return result.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StackTraceElement)) {
            return false;
        }
        StackTraceElement e2 = (StackTraceElement) obj;
        return e2.declaringClass.equals(this.declaringClass) && e2.lineNumber == this.lineNumber && Objects.equals(this.methodName, e2.methodName) && Objects.equals(this.fileName, e2.fileName);
    }

    public int hashCode() {
        int result = (this.declaringClass.hashCode() * 31) + this.methodName.hashCode();
        return (((result * 31) + Objects.hashCode(this.fileName)) * 31) + this.lineNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StackTraceElement of(StackFrameInfo sfi) {
        StackTraceElement ste = new StackTraceElement(sfi.getClassName(), sfi.getMethodName(), sfi.getFileName(), sfi.getLineNumber());
        return ste;
    }
}
