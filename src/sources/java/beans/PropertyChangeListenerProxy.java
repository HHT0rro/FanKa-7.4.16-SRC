package java.beans;

import java.util.EventListenerProxy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PropertyChangeListenerProxy extends EventListenerProxy<PropertyChangeListener> implements PropertyChangeListener {
    private final String propertyName;

    public PropertyChangeListenerProxy(String propertyName, PropertyChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
    }

    @Override // java.beans.PropertyChangeListener
    public void propertyChange(PropertyChangeEvent event) {
        getListener().propertyChange(event);
    }

    public String getPropertyName() {
        return this.propertyName;
    }
}
