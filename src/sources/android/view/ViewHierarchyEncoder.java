package android.view;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewHierarchyEncoder {
    private static final byte SIG_BOOLEAN = 90;
    private static final byte SIG_BYTE = 66;
    private static final byte SIG_DOUBLE = 68;
    private static final short SIG_END_MAP = 0;
    private static final byte SIG_FLOAT = 70;
    private static final byte SIG_INT = 73;
    private static final byte SIG_LONG = 74;
    private static final byte SIG_MAP = 77;
    private static final byte SIG_SHORT = 83;
    private static final byte SIG_STRING = 82;
    private final DataOutputStream mStream;
    private final Map<String, Short> mPropertyNames = new HashMap(200);
    private short mPropertyId = 1;
    private Charset mCharset = Charset.forName("utf-8");
    private boolean mUserPropertiesEnabled = true;

    public ViewHierarchyEncoder(ByteArrayOutputStream stream) {
        this.mStream = new DataOutputStream(stream);
    }

    public void setUserPropertiesEnabled(boolean enabled) {
        this.mUserPropertiesEnabled = enabled;
    }

    public void beginObject(Object o10) {
        startPropertyMap();
        addProperty("meta:__name__", o10.getClass().getName());
        addProperty("meta:__hash__", o10.hashCode());
    }

    public void endObject() {
        endPropertyMap();
    }

    public void endStream() {
        startPropertyMap();
        addProperty("__name__", "propertyIndex");
        for (Map.Entry<String, Short> entry : this.mPropertyNames.entrySet()) {
            writeShort(entry.getValue().shortValue());
            writeString(entry.getKey());
        }
        endPropertyMap();
    }

    public void addProperty(String name, boolean v2) {
        writeShort(createPropertyIndex(name));
        writeBoolean(v2);
    }

    public void addProperty(String name, short s2) {
        writeShort(createPropertyIndex(name));
        writeShort(s2);
    }

    public void addProperty(String name, int v2) {
        writeShort(createPropertyIndex(name));
        writeInt(v2);
    }

    public void addProperty(String name, float v2) {
        writeShort(createPropertyIndex(name));
        writeFloat(v2);
    }

    public void addProperty(String name, String s2) {
        writeShort(createPropertyIndex(name));
        writeString(s2);
    }

    public void addUserProperty(String name, String s2) {
        if (this.mUserPropertiesEnabled) {
            addProperty(name, s2);
        }
    }

    public void addPropertyKey(String name) {
        writeShort(createPropertyIndex(name));
    }

    private short createPropertyIndex(String name) {
        Short index = this.mPropertyNames.get(name);
        if (index == null) {
            short s2 = this.mPropertyId;
            this.mPropertyId = (short) (s2 + 1);
            index = Short.valueOf(s2);
            this.mPropertyNames.put(name, index);
        }
        return index.shortValue();
    }

    private void startPropertyMap() {
        try {
            this.mStream.write(77);
        } catch (IOException e2) {
        }
    }

    private void endPropertyMap() {
        writeShort((short) 0);
    }

    private void writeBoolean(boolean v2) {
        try {
            this.mStream.write(90);
            this.mStream.write(v2 ? 1 : 0);
        } catch (IOException e2) {
        }
    }

    private void writeShort(short s2) {
        try {
            this.mStream.write(83);
            this.mStream.writeShort(s2);
        } catch (IOException e2) {
        }
    }

    private void writeInt(int i10) {
        try {
            this.mStream.write(73);
            this.mStream.writeInt(i10);
        } catch (IOException e2) {
        }
    }

    private void writeFloat(float v2) {
        try {
            this.mStream.write(70);
            this.mStream.writeFloat(v2);
        } catch (IOException e2) {
        }
    }

    private void writeString(String s2) {
        if (s2 == null) {
            s2 = "";
        }
        try {
            this.mStream.write(82);
            byte[] bytes = s2.getBytes(this.mCharset);
            short len = (short) Math.min(bytes.length, 32767);
            this.mStream.writeShort(len);
            this.mStream.write(bytes, 0, len);
        } catch (IOException e2) {
        }
    }
}
