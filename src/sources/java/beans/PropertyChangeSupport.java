package java.beans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PropertyChangeSupport implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("children", Hashtable.class), new ObjectStreamField("source", Object.class), new ObjectStreamField("propertyChangeSupportSerializedDataVersion", Integer.TYPE)};
    static final long serialVersionUID = 6401253773779951803L;
    private PropertyChangeListenerMap map = new PropertyChangeListenerMap();
    private Object source;

    public PropertyChangeSupport(Object sourceBean) {
        if (sourceBean == null) {
            throw new NullPointerException();
        }
        this.source = sourceBean;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener == null) {
            return;
        }
        if (listener instanceof PropertyChangeListenerProxy) {
            PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) listener;
            addPropertyChangeListener(proxy.getPropertyName(), proxy.getListener());
        } else {
            this.map.add(null, listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (listener == null) {
            return;
        }
        if (listener instanceof PropertyChangeListenerProxy) {
            PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) listener;
            removePropertyChangeListener(proxy.getPropertyName(), proxy.getListener());
        } else {
            this.map.remove(null, listener);
        }
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        return this.map.getListeners();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        PropertyChangeListener listener2;
        if (listener != null && propertyName != null && (listener2 = this.map.extract(listener)) != null) {
            this.map.add(propertyName, listener2);
        }
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        PropertyChangeListener listener2;
        if (listener != null && propertyName != null && (listener2 = this.map.extract(listener)) != null) {
            this.map.remove(propertyName, listener2);
        }
    }

    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        return this.map.getListeners(propertyName);
    }

    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            firePropertyChange(new PropertyChangeEvent(this.source, propertyName, oldValue, newValue));
        }
    }

    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        if (oldValue != newValue) {
            firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        }
    }

    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        }
    }

    public void firePropertyChange(PropertyChangeEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            String name = event.getPropertyName();
            PropertyChangeListener[] common = this.map.get(null);
            PropertyChangeListener[] named = name != null ? this.map.get(name) : null;
            fire(common, event);
            fire(named, event);
        }
    }

    private static void fire(PropertyChangeListener[] listeners, PropertyChangeEvent event) {
        if (listeners != null) {
            for (PropertyChangeListener listener : listeners) {
                listener.propertyChange(event);
            }
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            firePropertyChange(new IndexedPropertyChangeEvent(this.source, propertyName, oldValue, newValue, index));
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, int oldValue, int newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        }
    }

    public boolean hasListeners(String propertyName) {
        return this.map.hasListeners(propertyName);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        Hashtable<String, PropertyChangeSupport> children = null;
        PropertyChangeListener[] listeners = null;
        synchronized (this.map) {
            for (Map.Entry<String, PropertyChangeListener[]> entry : this.map.getEntries()) {
                String property = entry.getKey();
                if (property == null) {
                    listeners = entry.getValue();
                } else {
                    if (children == null) {
                        children = new Hashtable<>();
                    }
                    PropertyChangeSupport pcs = new PropertyChangeSupport(this.source);
                    pcs.map.set(null, entry.getValue());
                    children.put(property, pcs);
                }
            }
        }
        ObjectOutputStream.PutField fields = s2.putFields();
        fields.put("children", children);
        fields.put("source", this.source);
        fields.put("propertyChangeSupportSerializedDataVersion", 2);
        s2.writeFields();
        if (listeners != null) {
            for (PropertyChangeListener l10 : listeners) {
                if (l10 instanceof Serializable) {
                    s2.writeObject(l10);
                }
            }
        }
        s2.writeObject(null);
    }

    private void readObject(ObjectInputStream s2) throws ClassNotFoundException, IOException {
        this.map = new PropertyChangeListenerMap();
        ObjectInputStream.GetField fields = s2.readFields();
        Hashtable<String, PropertyChangeSupport> children = (Hashtable) fields.get("children", (Object) null);
        this.source = fields.get("source", (Object) null);
        fields.get("propertyChangeSupportSerializedDataVersion", 2);
        while (true) {
            Object listenerOrNull = s2.readObject();
            if (listenerOrNull == null) {
                break;
            } else {
                this.map.add(null, (PropertyChangeListener) listenerOrNull);
            }
        }
        if (children != null) {
            for (Map.Entry<String, PropertyChangeSupport> entry : children.entrySet()) {
                for (PropertyChangeListener listener : entry.getValue().getPropertyChangeListeners()) {
                    this.map.add(entry.getKey(), listener);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class PropertyChangeListenerMap extends ChangeListenerMap<PropertyChangeListener> {
        private static final PropertyChangeListener[] EMPTY = new PropertyChangeListener[0];

        private PropertyChangeListenerMap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.beans.ChangeListenerMap
        public PropertyChangeListener[] newArray(int length) {
            if (length > 0) {
                return new PropertyChangeListener[length];
            }
            return EMPTY;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.beans.ChangeListenerMap
        public PropertyChangeListener newProxy(String name, PropertyChangeListener listener) {
            return new PropertyChangeListenerProxy(name, listener);
        }

        @Override // java.beans.ChangeListenerMap
        public final PropertyChangeListener extract(PropertyChangeListener listener) {
            while (listener instanceof PropertyChangeListenerProxy) {
                listener = ((PropertyChangeListenerProxy) listener).getListener();
            }
            return listener;
        }
    }
}
