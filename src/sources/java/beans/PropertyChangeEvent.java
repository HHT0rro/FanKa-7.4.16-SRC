package java.beans;

import java.util.EventObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PropertyChangeEvent extends EventObject {
    private static final long serialVersionUID = 7042693688939648123L;
    private Object newValue;
    private Object oldValue;
    private Object propagationId;
    private String propertyName;

    public PropertyChangeEvent(Object source, String propertyName, Object oldValue, Object newValue) {
        super(source);
        this.propertyName = propertyName;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public Object getNewValue() {
        return this.newValue;
    }

    public Object getOldValue() {
        return this.oldValue;
    }

    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
    }

    public Object getPropagationId() {
        return this.propagationId;
    }

    @Override // java.util.EventObject
    public String toString() {
        StringBuilder sb2 = new StringBuilder(getClass().getName());
        sb2.append("[propertyName=").append(getPropertyName());
        appendTo(sb2);
        sb2.append("; oldValue=").append(getOldValue());
        sb2.append("; newValue=").append(getNewValue());
        sb2.append("; propagationId=").append(getPropagationId());
        sb2.append("; source=").append(getSource());
        return sb2.append("]").toString();
    }

    void appendTo(StringBuilder sb2) {
    }
}
