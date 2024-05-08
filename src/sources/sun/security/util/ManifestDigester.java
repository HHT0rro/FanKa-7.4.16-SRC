package sun.security.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ManifestDigester {
    public static final String MF_MAIN_ATTRS = "Manifest-Main-Attributes";
    private HashMap<String, Entry> entries = new HashMap<>();
    private byte[] rawBytes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Position {
        int endOfFirstLine;
        int endOfSection;
        int startOfNext;

        Position() {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    private boolean findSection(int offset, Position pos) {
        int i10 = offset;
        int len = this.rawBytes.length;
        int last = offset;
        boolean allBlank = true;
        pos.endOfFirstLine = -1;
        while (i10 < len) {
            byte b4 = this.rawBytes[i10];
            switch (b4) {
                case 13:
                    if (pos.endOfFirstLine == -1) {
                        pos.endOfFirstLine = i10 - 1;
                    }
                    if (i10 < len && this.rawBytes[i10 + 1] == 10) {
                        i10++;
                    }
                    break;
                case 10:
                    if (pos.endOfFirstLine == -1) {
                        pos.endOfFirstLine = i10 - 1;
                    }
                    if (allBlank || i10 == len - 1) {
                        if (i10 == len - 1) {
                            pos.endOfSection = i10;
                        } else {
                            pos.endOfSection = last;
                        }
                        pos.startOfNext = i10 + 1;
                        return true;
                    }
                    last = i10;
                    allBlank = true;
                    i10++;
                    break;
                default:
                    allBlank = false;
                    i10++;
            }
        }
        return false;
    }

    public ManifestDigester(byte[] bytes) {
        int wrapLen;
        this.rawBytes = bytes;
        new ByteArrayOutputStream();
        Position pos = new Position();
        if (findSection(0, pos)) {
            this.entries.put(MF_MAIN_ATTRS, new Entry(0, pos.endOfSection + 1, pos.startOfNext, this.rawBytes));
            for (int start = pos.startOfNext; findSection(start, pos); start = pos.startOfNext) {
                int len = (pos.endOfFirstLine - start) + 1;
                int sectionLen = (pos.endOfSection - start) + 1;
                int sectionLenWithBlank = pos.startOfNext - start;
                if (len > 6 && isNameAttr(bytes, start)) {
                    StringBuilder nameBuf = new StringBuilder(sectionLen);
                    try {
                        nameBuf.append(new String(bytes, start + 6, len - 6, "UTF8"));
                        int i10 = start + len;
                        if (i10 - start < sectionLen) {
                            if (bytes[i10] == 13) {
                                i10 += 2;
                            } else {
                                i10++;
                            }
                        }
                        while (i10 - start < sectionLen) {
                            int i11 = i10 + 1;
                            if (bytes[i10] != 32) {
                                break;
                            }
                            while (true) {
                                if (i11 - start >= sectionLen) {
                                    break;
                                }
                                int i12 = i11 + 1;
                                if (bytes[i11] == 10) {
                                    i11 = i12;
                                    break;
                                }
                                i11 = i12;
                            }
                            if (bytes[i11 - 1] != 10) {
                                return;
                            }
                            if (bytes[i11 - 2] == 13) {
                                wrapLen = (i11 - i11) - 2;
                            } else {
                                int wrapLen2 = i11 - i11;
                                wrapLen = wrapLen2 - 1;
                            }
                            nameBuf.append(new String(bytes, i11, wrapLen, "UTF8"));
                            i10 = i11;
                        }
                        this.entries.put(nameBuf.toString(), new Entry(start, sectionLen, sectionLenWithBlank, this.rawBytes));
                    } catch (UnsupportedEncodingException e2) {
                        throw new IllegalStateException("UTF8 not available on platform");
                    }
                }
            }
        }
    }

    private boolean isNameAttr(byte[] bytes, int start) {
        return (bytes[start] == 78 || bytes[start] == 110) && (bytes[start + 1] == 97 || bytes[start + 1] == 65) && ((bytes[start + 2] == 109 || bytes[start + 2] == 77) && ((bytes[start + 3] == 101 || bytes[start + 3] == 69) && bytes[start + 4] == 58 && bytes[start + 5] == 32));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Entry {
        int length;
        int lengthWithBlankLine;
        int offset;
        boolean oldStyle;
        byte[] rawBytes;

        public Entry(int offset, int length, int lengthWithBlankLine, byte[] rawBytes) {
            this.offset = offset;
            this.length = length;
            this.lengthWithBlankLine = lengthWithBlankLine;
            this.rawBytes = rawBytes;
        }

        public byte[] digest(MessageDigest md2) {
            md2.reset();
            if (this.oldStyle) {
                doOldStyle(md2, this.rawBytes, this.offset, this.lengthWithBlankLine);
            } else {
                md2.update(this.rawBytes, this.offset, this.lengthWithBlankLine);
            }
            return md2.digest();
        }

        private void doOldStyle(MessageDigest md2, byte[] bytes, int offset, int length) {
            int i10 = offset;
            int start = offset;
            int max = offset + length;
            int prev = -1;
            while (i10 < max) {
                if (bytes[i10] == 13 && prev == 32) {
                    md2.update(bytes, start, (i10 - start) - 1);
                    start = i10;
                }
                prev = bytes[i10];
                i10++;
            }
            md2.update(bytes, start, i10 - start);
        }

        public byte[] digestWorkaround(MessageDigest md2) {
            md2.reset();
            md2.update(this.rawBytes, this.offset, this.length);
            return md2.digest();
        }
    }

    public Entry get(String name, boolean oldStyle) {
        Entry e2 = this.entries.get(name);
        if (e2 != null) {
            e2.oldStyle = oldStyle;
        }
        return e2;
    }

    public byte[] manifestDigest(MessageDigest md2) {
        md2.reset();
        byte[] bArr = this.rawBytes;
        md2.update(bArr, 0, bArr.length);
        return md2.digest();
    }
}
