package java.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import sun.util.ResourceBundleEnumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PropertyResourceBundle extends ResourceBundle {
    private final Map<String, Object> lookup;

    public PropertyResourceBundle(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(stream);
        this.lookup = new HashMap(properties);
    }

    public PropertyResourceBundle(Reader reader) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        this.lookup = new HashMap(properties);
    }

    @Override // java.util.ResourceBundle
    public Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return this.lookup.get(key);
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        ResourceBundle parent = this.parent;
        return new ResourceBundleEnumeration(this.lookup.h(), parent != null ? parent.getKeys() : null);
    }

    @Override // java.util.ResourceBundle
    protected Set<String> handleKeySet() {
        return this.lookup.h();
    }
}
