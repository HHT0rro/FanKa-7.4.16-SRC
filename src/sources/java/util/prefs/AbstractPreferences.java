package java.util.prefs;

import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPreferences extends Preferences {
    private final String absolutePath;
    private final String name;
    final AbstractPreferences parent;
    private final AbstractPreferences root;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final AbstractPreferences[] EMPTY_ABSTRACT_PREFS_ARRAY = new AbstractPreferences[0];
    private static final List<EventObject> eventQueue = new LinkedList();
    private static Thread eventDispatchThread = null;
    protected boolean newNode = false;
    private Map<String, AbstractPreferences> kidCache = new HashMap();
    private boolean removed = false;
    private final ArrayList<PreferenceChangeListener> prefListeners = new ArrayList<>();
    private final ArrayList<NodeChangeListener> nodeListeners = new ArrayList<>();
    protected final Object lock = new Object();

    protected abstract AbstractPreferences childSpi(String str);

    protected abstract String[] childrenNamesSpi() throws BackingStoreException;

    protected abstract void flushSpi() throws BackingStoreException;

    protected abstract String getSpi(String str);

    protected abstract String[] keysSpi() throws BackingStoreException;

    protected abstract void putSpi(String str, String str2);

    protected abstract void removeNodeSpi() throws BackingStoreException;

    protected abstract void removeSpi(String str);

    protected abstract void syncSpi() throws BackingStoreException;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPreferences(AbstractPreferences parent, String name) {
        if (parent == null) {
            if (!name.equals("")) {
                throw new IllegalArgumentException("Root name '" + name + "' must be \"\"");
            }
            this.absolutePath = "/";
            this.root = this;
        } else {
            if (name.indexOf(47) != -1) {
                throw new IllegalArgumentException("Name '" + name + "' contains '/'");
            }
            if (name.equals("")) {
                throw new IllegalArgumentException("Illegal name: empty string");
            }
            AbstractPreferences abstractPreferences = parent.root;
            this.root = abstractPreferences;
            this.absolutePath = parent == abstractPreferences ? "/" + name : parent.absolutePath() + "/" + name;
        }
        this.name = name;
        this.parent = parent;
    }

    @Override // java.util.prefs.Preferences
    public void put(String key, String value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        if (key.length() > 80) {
            throw new IllegalArgumentException("Key too long: " + key);
        }
        if (value.length() > 8192) {
            throw new IllegalArgumentException("Value too long: " + value);
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            putSpi(key, value);
            enqueuePreferenceChangeEvent(key, value);
        }
    }

    @Override // java.util.prefs.Preferences
    public String get(String key, String def) {
        String str;
        if (key == null) {
            throw new NullPointerException("Null key");
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            String result = null;
            try {
                result = getSpi(key);
            } catch (Exception e2) {
            }
            str = result == null ? def : result;
        }
        return str;
    }

    @Override // java.util.prefs.Preferences
    public void remove(String key) {
        Objects.requireNonNull(key, "Specified key cannot be null");
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            removeSpi(key);
            enqueuePreferenceChangeEvent(key, null);
        }
    }

    @Override // java.util.prefs.Preferences
    public void clear() throws BackingStoreException {
        synchronized (this.lock) {
            String[] keys = keys();
            for (String str : keys) {
                remove(str);
            }
        }
    }

    @Override // java.util.prefs.Preferences
    public void putInt(String key, int value) {
        put(key, Integer.toString(value));
    }

    @Override // java.util.prefs.Preferences
    public int getInt(String key, int def) {
        try {
            String value = get(key, null);
            if (value == null) {
                return def;
            }
            int result = Integer.parseInt(value);
            return result;
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    @Override // java.util.prefs.Preferences
    public void putLong(String key, long value) {
        put(key, Long.toString(value));
    }

    @Override // java.util.prefs.Preferences
    public long getLong(String key, long def) {
        try {
            String value = get(key, null);
            if (value == null) {
                return def;
            }
            long result = Long.parseLong(value);
            return result;
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    @Override // java.util.prefs.Preferences
    public void putBoolean(String key, boolean value) {
        put(key, String.valueOf(value));
    }

    @Override // java.util.prefs.Preferences
    public boolean getBoolean(String key, boolean def) {
        String value = get(key, null);
        if (value == null) {
            return def;
        }
        if (value.equalsIgnoreCase("true")) {
            return true;
        }
        if (!value.equalsIgnoreCase("false")) {
            return def;
        }
        return false;
    }

    @Override // java.util.prefs.Preferences
    public void putFloat(String key, float value) {
        put(key, Float.toString(value));
    }

    @Override // java.util.prefs.Preferences
    public float getFloat(String key, float def) {
        try {
            String value = get(key, null);
            if (value == null) {
                return def;
            }
            float result = Float.parseFloat(value);
            return result;
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    @Override // java.util.prefs.Preferences
    public void putDouble(String key, double value) {
        put(key, Double.toString(value));
    }

    @Override // java.util.prefs.Preferences
    public double getDouble(String key, double def) {
        try {
            String value = get(key, null);
            if (value == null) {
                return def;
            }
            double result = Double.parseDouble(value);
            return result;
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    @Override // java.util.prefs.Preferences
    public void putByteArray(String key, byte[] value) {
        put(key, Base64.byteArrayToBase64(value));
    }

    @Override // java.util.prefs.Preferences
    public byte[] getByteArray(String key, byte[] def) {
        String value = get(key, null);
        if (value == null) {
            return def;
        }
        try {
            byte[] result = Base64.base64ToByteArray(value);
            return result;
        } catch (RuntimeException e2) {
            return def;
        }
    }

    @Override // java.util.prefs.Preferences
    public String[] keys() throws BackingStoreException {
        String[] keysSpi;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            keysSpi = keysSpi();
        }
        return keysSpi;
    }

    @Override // java.util.prefs.Preferences
    public String[] childrenNames() throws BackingStoreException {
        String[] strArr;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            Set<String> s2 = new TreeSet<>(this.kidCache.h());
            for (String kid : childrenNamesSpi()) {
                s2.add(kid);
            }
            strArr = (String[]) s2.toArray(EMPTY_STRING_ARRAY);
        }
        return strArr;
    }

    protected final AbstractPreferences[] cachedChildren() {
        return (AbstractPreferences[]) this.kidCache.values().toArray(EMPTY_ABSTRACT_PREFS_ARRAY);
    }

    @Override // java.util.prefs.Preferences
    public Preferences parent() {
        AbstractPreferences abstractPreferences;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            abstractPreferences = this.parent;
        }
        return abstractPreferences;
    }

    @Override // java.util.prefs.Preferences
    public Preferences node(String path) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            if (path.equals("")) {
                return this;
            }
            if (path.equals("/")) {
                return this.root;
            }
            if (path.charAt(0) != '/') {
                return node(new StringTokenizer(path, "/", true));
            }
            return this.root.node(new StringTokenizer(path.substring(1), "/", true));
        }
    }

    private Preferences node(StringTokenizer path) {
        String token = path.nextToken();
        if (token.equals("/")) {
            throw new IllegalArgumentException("Consecutive slashes in path");
        }
        synchronized (this.lock) {
            AbstractPreferences child = this.kidCache.get(token);
            if (child == null) {
                if (token.length() > 80) {
                    throw new IllegalArgumentException("Node name " + token + " too long");
                }
                child = childSpi(token);
                if (child.newNode) {
                    enqueueNodeAddedEvent(child);
                }
                this.kidCache.put(token, child);
            }
            if (!path.hasMoreTokens()) {
                return child;
            }
            path.nextToken();
            if (!path.hasMoreTokens()) {
                throw new IllegalArgumentException("Path ends with slash");
            }
            return child.node(path);
        }
    }

    @Override // java.util.prefs.Preferences
    public boolean nodeExists(String path) throws BackingStoreException {
        synchronized (this.lock) {
            if (path.equals("")) {
                return this.removed ? false : true;
            }
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            if (path.equals("/")) {
                return true;
            }
            if (path.charAt(0) != '/') {
                return nodeExists(new StringTokenizer(path, "/", true));
            }
            return this.root.nodeExists(new StringTokenizer(path.substring(1), "/", true));
        }
    }

    private boolean nodeExists(StringTokenizer path) throws BackingStoreException {
        String token = path.nextToken();
        if (token.equals("/")) {
            throw new IllegalArgumentException("Consecutive slashes in path");
        }
        synchronized (this.lock) {
            AbstractPreferences child = this.kidCache.get(token);
            if (child == null) {
                child = getChild(token);
            }
            if (child == null) {
                return false;
            }
            if (!path.hasMoreTokens()) {
                return true;
            }
            path.nextToken();
            if (!path.hasMoreTokens()) {
                throw new IllegalArgumentException("Path ends with slash");
            }
            return child.nodeExists(path);
        }
    }

    @Override // java.util.prefs.Preferences
    public void removeNode() throws BackingStoreException {
        if (this == this.root) {
            throw new UnsupportedOperationException("Can't remove the root!");
        }
        synchronized (this.parent.lock) {
            removeNode2();
            this.parent.kidCache.remove(this.name);
        }
    }

    private void removeNode2() throws BackingStoreException {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node already removed.");
            }
            String[] kidNames = childrenNamesSpi();
            for (int i10 = 0; i10 < kidNames.length; i10++) {
                if (!this.kidCache.containsKey(kidNames[i10])) {
                    this.kidCache.put(kidNames[i10], childSpi(kidNames[i10]));
                }
            }
            Iterator<AbstractPreferences> i11 = this.kidCache.values().iterator2();
            while (i11.hasNext()) {
                try {
                    i11.next().removeNode2();
                    i11.remove();
                } catch (BackingStoreException e2) {
                }
            }
            removeNodeSpi();
            this.removed = true;
            this.parent.enqueueNodeRemovedEvent(this);
        }
    }

    @Override // java.util.prefs.Preferences
    public String name() {
        return this.name;
    }

    @Override // java.util.prefs.Preferences
    public String absolutePath() {
        return this.absolutePath;
    }

    @Override // java.util.prefs.Preferences
    public boolean isUserNode() {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: java.util.prefs.AbstractPreferences.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                return Boolean.valueOf(AbstractPreferences.this.root == Preferences.userRoot());
            }
        })).booleanValue();
    }

    @Override // java.util.prefs.Preferences
    public void addPreferenceChangeListener(PreferenceChangeListener pcl) {
        if (pcl == null) {
            throw new NullPointerException("Change listener is null.");
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            this.prefListeners.add(pcl);
        }
        startEventDispatchThreadIfNecessary();
    }

    @Override // java.util.prefs.Preferences
    public void removePreferenceChangeListener(PreferenceChangeListener pcl) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            if (!this.prefListeners.contains(pcl)) {
                throw new IllegalArgumentException("Listener not registered.");
            }
            this.prefListeners.remove(pcl);
        }
    }

    @Override // java.util.prefs.Preferences
    public void addNodeChangeListener(NodeChangeListener ncl) {
        if (ncl == null) {
            throw new NullPointerException("Change listener is null.");
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            this.nodeListeners.add(ncl);
        }
        startEventDispatchThreadIfNecessary();
    }

    @Override // java.util.prefs.Preferences
    public void removeNodeChangeListener(NodeChangeListener ncl) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            if (!this.nodeListeners.contains(ncl)) {
                throw new IllegalArgumentException("Listener not registered.");
            }
            this.nodeListeners.remove(ncl);
        }
    }

    protected AbstractPreferences getChild(String nodeName) throws BackingStoreException {
        synchronized (this.lock) {
            String[] kidNames = childrenNames();
            for (int i10 = 0; i10 < kidNames.length; i10++) {
                if (kidNames[i10].equals(nodeName)) {
                    return childSpi(kidNames[i10]);
                }
            }
            return null;
        }
    }

    @Override // java.util.prefs.Preferences
    public String toString() {
        return (isUserNode() ? "User" : "System") + " Preference Node: " + absolutePath();
    }

    @Override // java.util.prefs.Preferences
    public void sync() throws BackingStoreException {
        sync2();
    }

    private void sync2() throws BackingStoreException {
        AbstractPreferences[] cachedKids;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed");
            }
            syncSpi();
            cachedKids = cachedChildren();
        }
        for (AbstractPreferences abstractPreferences : cachedKids) {
            abstractPreferences.sync2();
        }
    }

    @Override // java.util.prefs.Preferences
    public void flush() throws BackingStoreException {
        flush2();
    }

    private void flush2() throws BackingStoreException {
        synchronized (this.lock) {
            flushSpi();
            if (this.removed) {
                return;
            }
            AbstractPreferences[] cachedKids = cachedChildren();
            for (AbstractPreferences abstractPreferences : cachedKids) {
                abstractPreferences.flush2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRemoved() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.removed;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class NodeAddedEvent extends NodeChangeEvent {
        private static final long serialVersionUID = -6743557530157328528L;

        NodeAddedEvent(Preferences parent, Preferences child) {
            super(parent, child);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class NodeRemovedEvent extends NodeChangeEvent {
        private static final long serialVersionUID = 8735497392918824837L;

        NodeRemovedEvent(Preferences parent, Preferences child) {
            super(parent, child);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EventDispatchThread extends Thread {
        private EventDispatchThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            EventObject event;
            while (true) {
                synchronized (AbstractPreferences.eventQueue) {
                    while (AbstractPreferences.eventQueue.isEmpty()) {
                        try {
                            AbstractPreferences.eventQueue.wait();
                        } catch (InterruptedException e2) {
                            return;
                        }
                    }
                    event = (EventObject) AbstractPreferences.eventQueue.remove(0);
                }
                AbstractPreferences src = (AbstractPreferences) event.getSource();
                if (event instanceof PreferenceChangeEvent) {
                    PreferenceChangeEvent pce = (PreferenceChangeEvent) event;
                    for (PreferenceChangeListener preferenceChangeListener : src.prefListeners()) {
                        preferenceChangeListener.preferenceChange(pce);
                    }
                } else {
                    NodeChangeEvent nce = (NodeChangeEvent) event;
                    NodeChangeListener[] listeners = src.nodeListeners();
                    if (nce instanceof NodeAddedEvent) {
                        for (NodeChangeListener nodeChangeListener : listeners) {
                            nodeChangeListener.childAdded(nce);
                        }
                    } else {
                        for (NodeChangeListener nodeChangeListener2 : listeners) {
                            nodeChangeListener2.childRemoved(nce);
                        }
                    }
                }
            }
        }
    }

    private static synchronized void startEventDispatchThreadIfNecessary() {
        synchronized (AbstractPreferences.class) {
            if (eventDispatchThread == null) {
                EventDispatchThread eventDispatchThread2 = new EventDispatchThread();
                eventDispatchThread = eventDispatchThread2;
                eventDispatchThread2.setDaemon(true);
                eventDispatchThread.start();
            }
        }
    }

    PreferenceChangeListener[] prefListeners() {
        PreferenceChangeListener[] preferenceChangeListenerArr;
        synchronized (this.lock) {
            ArrayList<PreferenceChangeListener> arrayList = this.prefListeners;
            preferenceChangeListenerArr = (PreferenceChangeListener[]) arrayList.toArray(new PreferenceChangeListener[arrayList.size()]);
        }
        return preferenceChangeListenerArr;
    }

    NodeChangeListener[] nodeListeners() {
        NodeChangeListener[] nodeChangeListenerArr;
        synchronized (this.lock) {
            ArrayList<NodeChangeListener> arrayList = this.nodeListeners;
            nodeChangeListenerArr = (NodeChangeListener[]) arrayList.toArray(new NodeChangeListener[arrayList.size()]);
        }
        return nodeChangeListenerArr;
    }

    private void enqueuePreferenceChangeEvent(String key, String newValue) {
        if (!this.prefListeners.isEmpty()) {
            List<EventObject> list = eventQueue;
            synchronized (list) {
                list.add(new PreferenceChangeEvent(this, key, newValue));
                list.notify();
            }
        }
    }

    private void enqueueNodeAddedEvent(Preferences child) {
        if (!this.nodeListeners.isEmpty()) {
            List<EventObject> list = eventQueue;
            synchronized (list) {
                list.add(new NodeAddedEvent(this, child));
                list.notify();
            }
        }
    }

    private void enqueueNodeRemovedEvent(Preferences child) {
        if (!this.nodeListeners.isEmpty()) {
            List<EventObject> list = eventQueue;
            synchronized (list) {
                list.add(new NodeRemovedEvent(this, child));
                list.notify();
            }
        }
    }

    @Override // java.util.prefs.Preferences
    public void exportNode(OutputStream os) throws IOException, BackingStoreException {
        XmlSupport.export(os, this, false);
    }

    @Override // java.util.prefs.Preferences
    public void exportSubtree(OutputStream os) throws IOException, BackingStoreException {
        XmlSupport.export(os, this, true);
    }
}
