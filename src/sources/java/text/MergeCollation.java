package java.text;

import java.text.PatternEntry;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class MergeCollation {
    ArrayList<PatternEntry> patterns = new ArrayList<>();
    private transient PatternEntry saveEntry = null;
    private transient PatternEntry lastEntry = null;
    private transient StringBuffer excess = new StringBuffer();
    private transient byte[] statusArray = new byte[8192];
    private final byte BITARRAYMASK = 1;
    private final int BYTEPOWER = 3;
    private final int BYTEMASK = 7;

    public MergeCollation(String pattern) throws ParseException {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.statusArray;
            if (i10 < bArr.length) {
                bArr[i10] = 0;
                i10++;
            } else {
                setPattern(pattern);
                return;
            }
        }
    }

    public String getPattern() {
        return getPattern(true);
    }

    public String getPattern(boolean withWhiteSpace) {
        StringBuffer result = new StringBuffer();
        ArrayList<PatternEntry> extList = null;
        int i10 = 0;
        while (i10 < this.patterns.size()) {
            PatternEntry entry = this.patterns.get(i10);
            if (!entry.extension.isEmpty()) {
                if (extList == null) {
                    extList = new ArrayList<>();
                }
                extList.add(entry);
            } else {
                if (extList != null) {
                    PatternEntry last = findLastWithNoExtension(i10 - 1);
                    for (int j10 = extList.size() - 1; j10 >= 0; j10--) {
                        PatternEntry tmp = extList.get(j10);
                        tmp.addToBuffer(result, false, withWhiteSpace, last);
                    }
                    extList = null;
                }
                entry.addToBuffer(result, false, withWhiteSpace, null);
            }
            i10++;
        }
        if (extList != null) {
            PatternEntry last2 = findLastWithNoExtension(i10 - 1);
            for (int j11 = extList.size() - 1; j11 >= 0; j11--) {
                PatternEntry tmp2 = extList.get(j11);
                tmp2.addToBuffer(result, false, withWhiteSpace, last2);
            }
        }
        return result.toString();
    }

    private final PatternEntry findLastWithNoExtension(int i10) {
        PatternEntry entry;
        do {
            i10--;
            if (i10 >= 0) {
                entry = this.patterns.get(i10);
            } else {
                return null;
            }
        } while (!entry.extension.isEmpty());
        return entry;
    }

    public String emitPattern() {
        return emitPattern(true);
    }

    public String emitPattern(boolean withWhiteSpace) {
        StringBuffer result = new StringBuffer();
        for (int i10 = 0; i10 < this.patterns.size(); i10++) {
            PatternEntry entry = this.patterns.get(i10);
            if (entry != null) {
                entry.addToBuffer(result, true, withWhiteSpace, null);
            }
        }
        return result.toString();
    }

    public void setPattern(String pattern) throws ParseException {
        this.patterns.clear();
        addPattern(pattern);
    }

    public void addPattern(String pattern) throws ParseException {
        if (pattern == null) {
            return;
        }
        PatternEntry.Parser parser = new PatternEntry.Parser(pattern);
        for (PatternEntry entry = parser.next(); entry != null; entry = parser.next()) {
            fixEntry(entry);
        }
    }

    public int getCount() {
        return this.patterns.size();
    }

    public PatternEntry getItemAt(int index) {
        return this.patterns.get(index);
    }

    private final void fixEntry(PatternEntry newEntry) throws ParseException {
        if (this.lastEntry != null && newEntry.chars.equals(this.lastEntry.chars) && newEntry.extension.equals(this.lastEntry.extension)) {
            if (newEntry.strength != 3 && newEntry.strength != -2) {
                throw new ParseException("The entries " + ((Object) this.lastEntry) + " and " + ((Object) newEntry) + " are adjacent in the rules, but have conflicting strengths: A character can't be unequal to itself.", -1);
            }
            return;
        }
        boolean changeLastEntry = true;
        if (newEntry.strength != -2) {
            int oldIndex = -1;
            if (newEntry.chars.length() == 1) {
                char c4 = newEntry.chars.charAt(0);
                int statusIndex = c4 >> 3;
                byte[] bArr = this.statusArray;
                byte bitClump = bArr[statusIndex];
                byte setBit = (byte) (1 << (c4 & 7));
                if (bitClump != 0 && (bitClump & setBit) != 0) {
                    oldIndex = this.patterns.lastIndexOf(newEntry);
                } else {
                    bArr[statusIndex] = (byte) (bitClump | setBit);
                }
            } else {
                oldIndex = this.patterns.lastIndexOf(newEntry);
            }
            if (oldIndex != -1) {
                this.patterns.remove(oldIndex);
            }
            this.excess.setLength(0);
            int lastIndex = findLastEntry(this.lastEntry, this.excess);
            if (this.excess.length() != 0) {
                newEntry.extension = ((Object) this.excess) + newEntry.extension;
                if (lastIndex != this.patterns.size()) {
                    this.lastEntry = this.saveEntry;
                    changeLastEntry = false;
                }
            }
            if (lastIndex == this.patterns.size()) {
                this.patterns.add(newEntry);
                this.saveEntry = newEntry;
            } else {
                this.patterns.add(lastIndex, newEntry);
            }
        }
        if (changeLastEntry) {
            this.lastEntry = newEntry;
        }
    }

    private final int findLastEntry(PatternEntry entry, StringBuffer excessChars) throws ParseException {
        if (entry == null) {
            return 0;
        }
        if (entry.strength != -2) {
            int oldIndex = -1;
            if (entry.chars.length() == 1) {
                int index = entry.chars.charAt(0) >> 3;
                if (((1 << (entry.chars.charAt(0) & 7)) & this.statusArray[index]) != 0) {
                    oldIndex = this.patterns.lastIndexOf(entry);
                }
            } else {
                oldIndex = this.patterns.lastIndexOf(entry);
            }
            if (oldIndex == -1) {
                throw new ParseException("couldn't find last entry: " + ((Object) entry), oldIndex);
            }
            return oldIndex + 1;
        }
        int i10 = this.patterns.size() - 1;
        while (true) {
            if (i10 < 0) {
                break;
            }
            PatternEntry e2 = this.patterns.get(i10);
            if (!e2.chars.regionMatches(0, entry.chars, 0, e2.chars.length())) {
                i10--;
            } else {
                excessChars.append((CharSequence) entry.chars, e2.chars.length(), entry.chars.length());
                break;
            }
        }
        if (i10 == -1) {
            throw new ParseException("couldn't find: " + ((Object) entry), i10);
        }
        return i10 + 1;
    }
}
