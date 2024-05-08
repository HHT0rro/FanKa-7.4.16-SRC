package java.util.jar;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.jar.Manifest;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Attributes implements Map<Object, Object>, Cloneable {
    protected Map<Object, Object> map;

    public Attributes() {
        this(11);
    }

    public Attributes(int size) {
        this.map = new LinkedHashMap(size);
    }

    public Attributes(Attributes attr) {
        this.map = new LinkedHashMap(attr);
    }

    @Override // java.util.Map
    public Object get(Object name) {
        return this.map.get(name);
    }

    public String getValue(String name) {
        return (String) get(Name.of(name));
    }

    public String getValue(Name name) {
        return (String) get(name);
    }

    @Override // java.util.Map
    public Object put(Object name, Object value) {
        return this.map.put((Name) name, (String) value);
    }

    public String putValue(String name, String value) {
        return (String) put(Name.of(name), value);
    }

    @Override // java.util.Map
    public Object remove(Object name) {
        return this.map.remove(name);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override // java.util.Map
    public boolean containsKey(Object name) {
        return this.map.containsKey(name);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Object, ? extends Object> map) {
        if (!Attributes.class.isInstance(map)) {
            throw new ClassCastException();
        }
        for (Map.Entry<?, ?> me2 : map.entrySet()) {
            put(me2.getKey(), me2.getValue());
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<Object> h() {
        return this.map.h();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object o10) {
        return this.map.equals(o10);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    public Object clone() {
        return new Attributes(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(DataOutputStream out) throws IOException {
        StringBuilder buffer = new StringBuilder(72);
        for (Map.Entry<Object, Object> e2 : entrySet()) {
            buffer.setLength(0);
            buffer.append(e2.getKey().toString());
            buffer.append(": ");
            buffer.append(e2.getValue());
            Manifest.println72(out, buffer.toString());
        }
        Manifest.println(out);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeMain(DataOutputStream out) throws IOException {
        StringBuilder buffer = new StringBuilder(72);
        String vername = Name.MANIFEST_VERSION.toString();
        String version = getValue(vername);
        if (version == null) {
            vername = Name.SIGNATURE_VERSION.toString();
            version = getValue(vername);
        }
        if (version != null) {
            buffer.append(vername);
            buffer.append(": ");
            buffer.append(version);
            out.write(buffer.toString().getBytes(StandardCharsets.UTF_8));
            Manifest.println(out);
        }
        for (Map.Entry<Object, Object> e2 : entrySet()) {
            String name = ((Name) e2.getKey()).toString();
            if (version != null && !name.equalsIgnoreCase(vername)) {
                buffer.setLength(0);
                buffer.append(name);
                buffer.append(": ");
                buffer.append(e2.getValue());
                Manifest.println72(out, buffer.toString());
            }
        }
        Manifest.println(out);
    }

    void read(Manifest.FastInputStream is, byte[] lbuf) throws IOException {
        read(is, lbuf, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int read(Manifest.FastInputStream is, byte[] lbuf, String filename, int lineNumber) throws IOException {
        String value;
        String value2;
        String name;
        ByteArrayOutputStream fullLine = new ByteArrayOutputStream();
        String name2 = null;
        int i10 = lineNumber;
        while (true) {
            int len = is.readLine(lbuf);
            if (len != -1) {
                int len2 = len - 1;
                byte c4 = lbuf[len2];
                int lineNumber2 = i10 + 1;
                if (c4 != 10 && c4 != 13) {
                    throw new IOException("line too long (" + Manifest.getErrorPosition(filename, lineNumber2) + ")");
                }
                if (len2 > 0 && lbuf[len2 - 1] == 13) {
                    len2--;
                }
                if (len2 == 0) {
                    return lineNumber2;
                }
                int i11 = 0;
                if (lbuf[0] != 32) {
                    while (true) {
                        int i12 = i11 + 1;
                        if (lbuf[i11] != 58) {
                            if (i12 >= len2) {
                                throw new IOException("invalid header field (" + Manifest.getErrorPosition(filename, lineNumber2) + ")");
                            }
                            i11 = i12;
                        } else {
                            int i13 = i12 + 1;
                            if (lbuf[i12] == 32) {
                                name2 = new String(lbuf, 0, i13 - 2, StandardCharsets.UTF_8);
                                if (is.peek() != 32) {
                                    value = new String(lbuf, i13, len2 - i13, StandardCharsets.UTF_8);
                                    value2 = null;
                                    name = name2;
                                } else {
                                    fullLine.reset();
                                    fullLine.write(lbuf, i13, len2 - i13);
                                    i10 = lineNumber2;
                                }
                            } else {
                                throw new IOException("invalid header field (" + Manifest.getErrorPosition(filename, lineNumber2) + ")");
                            }
                        }
                    }
                } else if (name2 != null) {
                    fullLine.write(lbuf, 1, len2 - 1);
                    if (is.peek() == 32) {
                        i10 = lineNumber2;
                    } else {
                        String value3 = fullLine.toString(StandardCharsets.UTF_8);
                        fullLine.reset();
                        value = value3;
                        value2 = 1;
                        name = name2;
                        try {
                            if (putValue(name, value) != null && value2 == null) {
                                PlatformLogger.getLogger("java.util.jar").warning("Duplicate name in Manifest: " + name + ".\nEnsure that the manifest does not have duplicate entries, and\nthat blank lines separate individual sections in both your\nmanifest and in the META-INF/MANIFEST.MF entry in the jar file.");
                            }
                            name2 = name;
                            i10 = lineNumber2;
                        } catch (IllegalArgumentException e2) {
                            throw new IOException("invalid header field name: " + name + " (" + Manifest.getErrorPosition(filename, lineNumber2) + ")");
                        }
                    }
                } else {
                    throw new IOException("misplaced continuation line (" + Manifest.getErrorPosition(filename, lineNumber2) + ")");
                }
            } else {
                return i10;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Name {
        public static final Name CLASS_PATH;
        public static final Name CONTENT_TYPE;

        @Deprecated
        public static final Name EXTENSION_INSTALLATION;
        public static final Name EXTENSION_LIST;
        public static final Name EXTENSION_NAME;
        public static final Name IMPLEMENTATION_TITLE;

        @Deprecated
        public static final Name IMPLEMENTATION_URL;
        public static final Name IMPLEMENTATION_VENDOR;

        @Deprecated
        public static final Name IMPLEMENTATION_VENDOR_ID;
        public static final Name IMPLEMENTATION_VERSION;
        private static Map<String, Name> KNOWN_NAMES;
        public static final Name MAIN_CLASS;
        public static final Name MANIFEST_VERSION;
        public static final Name SEALED;
        public static final Name SIGNATURE_VERSION;
        public static final Name SPECIFICATION_TITLE;
        public static final Name SPECIFICATION_VENDOR;
        public static final Name SPECIFICATION_VERSION;
        private final int hashCode;
        private final String name;

        static final Name of(String name) {
            Name n10 = KNOWN_NAMES.get(name);
            if (n10 != null) {
                return n10;
            }
            return new Name(name);
        }

        public Name(String name) {
            this.hashCode = hash(name);
            this.name = name.intern();
        }

        private final int hash(String name) {
            int i10;
            Objects.requireNonNull(name, "name");
            int len = name.length();
            if (len > 70 || len == 0) {
                throw new IllegalArgumentException(name);
            }
            int h10 = 0;
            for (int i11 = 0; i11 < len; i11++) {
                char c4 = name.charAt(i11);
                if (c4 >= 'a' && c4 <= 'z') {
                    i10 = (h10 * 31) + (c4 - ' ');
                } else if ((c4 >= 'A' && c4 <= 'Z') || ((c4 >= '0' && c4 <= '9') || c4 == '_' || c4 == '-')) {
                    i10 = (h10 * 31) + c4;
                } else {
                    throw new IllegalArgumentException(name);
                }
                h10 = i10;
            }
            return h10;
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 instanceof Name) {
                return ((Name) o10).name.equalsIgnoreCase(this.name);
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public String toString() {
            return this.name;
        }

        private static void addName(Map<String, Name> names, Name name) {
            names.put(name.name, name);
        }

        static {
            Map<String, Name> map = KNOWN_NAMES;
            if (map == null) {
                Name name = new Name("Manifest-Version");
                MANIFEST_VERSION = name;
                Name name2 = new Name("Signature-Version");
                SIGNATURE_VERSION = name2;
                Name name3 = new Name("Content-Type");
                CONTENT_TYPE = name3;
                Name name4 = new Name("Class-Path");
                CLASS_PATH = name4;
                Name name5 = new Name("Main-Class");
                MAIN_CLASS = name5;
                Name name6 = new Name("Sealed");
                SEALED = name6;
                Name name7 = new Name("Extension-List");
                EXTENSION_LIST = name7;
                Name name8 = new Name("Extension-Name");
                EXTENSION_NAME = name8;
                Name name9 = new Name("Extension-Installation");
                EXTENSION_INSTALLATION = name9;
                Name name10 = new Name("Implementation-Title");
                IMPLEMENTATION_TITLE = name10;
                Name name11 = new Name("Implementation-Version");
                IMPLEMENTATION_VERSION = name11;
                Name name12 = new Name("Implementation-Vendor");
                IMPLEMENTATION_VENDOR = name12;
                Name name13 = new Name("Implementation-Vendor-Id");
                IMPLEMENTATION_VENDOR_ID = name13;
                Name name14 = new Name("Implementation-URL");
                IMPLEMENTATION_URL = name14;
                Name name15 = new Name("Specification-Title");
                SPECIFICATION_TITLE = name15;
                Name name16 = new Name("Specification-Version");
                SPECIFICATION_VERSION = name16;
                Name name17 = new Name("Specification-Vendor");
                SPECIFICATION_VENDOR = name17;
                HashMap<String, Name> names = new HashMap<>(64);
                addName(names, name);
                addName(names, name2);
                addName(names, name3);
                addName(names, name4);
                addName(names, name5);
                addName(names, name6);
                addName(names, name7);
                addName(names, name8);
                addName(names, name9);
                addName(names, name10);
                addName(names, name11);
                addName(names, name12);
                addName(names, name13);
                addName(names, name14);
                addName(names, name15);
                addName(names, name16);
                addName(names, name17);
                addName(names, new Name("Add-Exports"));
                addName(names, new Name("Add-Opens"));
                addName(names, new Name("Launcher-Agent-Class"));
                addName(names, new Name("JavaFX-Application-Class"));
                addName(names, new Name("Name"));
                addName(names, new Name("Created-By"));
                addName(names, new Name("SHA1-Digest"));
                addName(names, new Name("SHA-256-Digest"));
                KNOWN_NAMES = Map.copyOf(names);
                return;
            }
            MANIFEST_VERSION = map.get("Manifest-Version");
            SIGNATURE_VERSION = KNOWN_NAMES.get("Signature-Version");
            CONTENT_TYPE = KNOWN_NAMES.get("Content-Type");
            CLASS_PATH = KNOWN_NAMES.get("Class-Path");
            MAIN_CLASS = KNOWN_NAMES.get("Main-Class");
            SEALED = KNOWN_NAMES.get("Sealed");
            EXTENSION_LIST = KNOWN_NAMES.get("Extension-List");
            EXTENSION_NAME = KNOWN_NAMES.get("Extension-Name");
            EXTENSION_INSTALLATION = KNOWN_NAMES.get("Extension-Installation");
            IMPLEMENTATION_TITLE = KNOWN_NAMES.get("Implementation-Title");
            IMPLEMENTATION_VERSION = KNOWN_NAMES.get("Implementation-Version");
            IMPLEMENTATION_VENDOR = KNOWN_NAMES.get("Implementation-Vendor");
            IMPLEMENTATION_VENDOR_ID = KNOWN_NAMES.get("Implementation-Vendor-Id");
            IMPLEMENTATION_URL = KNOWN_NAMES.get("Implementation-URL");
            SPECIFICATION_TITLE = KNOWN_NAMES.get("Specification-Title");
            SPECIFICATION_VERSION = KNOWN_NAMES.get("Specification-Version");
            SPECIFICATION_VENDOR = KNOWN_NAMES.get("Specification-Vendor");
        }
    }
}
