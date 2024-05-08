package java.text;

import java.text.AttributedCharacterIterator;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AttributedString {
    private static final int INITIAL_CAPACITY = 10;
    Vector<Object>[] runAttributeValues;
    Vector<AttributedCharacterIterator.Attribute>[] runAttributes;
    int runCount;
    int[] runStarts;
    String text;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributedString(AttributedCharacterIterator[] iterators) {
        if (iterators == null) {
            throw new NullPointerException("Iterators must not be null");
        }
        if (iterators.length == 0) {
            this.text = "";
            return;
        }
        StringBuffer buffer = new StringBuffer();
        for (AttributedCharacterIterator attributedCharacterIterator : iterators) {
            appendContents(buffer, attributedCharacterIterator);
        }
        String stringBuffer = buffer.toString();
        this.text = stringBuffer;
        if (!stringBuffer.isEmpty()) {
            int offset = 0;
            Map<AttributedCharacterIterator.Attribute, Object> last = null;
            for (AttributedCharacterIterator iterator : iterators) {
                int start = iterator.getBeginIndex();
                int end = iterator.getEndIndex();
                for (int index = start; index < end; index = iterator.getRunLimit()) {
                    iterator.setIndex(index);
                    Map<AttributedCharacterIterator.Attribute, Object> attrs = iterator.getAttributes();
                    if (mapsDiffer(last, attrs)) {
                        setAttributes(attrs, (index - start) + offset);
                    }
                    last = attrs;
                }
                offset += end - start;
            }
        }
    }

    public AttributedString(String text) {
        if (text == null) {
            throw new NullPointerException();
        }
        this.text = text;
    }

    public AttributedString(String text, Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        if (text == null || attributes == null) {
            throw new NullPointerException();
        }
        this.text = text;
        if (text.isEmpty()) {
            if (attributes.isEmpty()) {
                return;
            } else {
                throw new IllegalArgumentException("Can't add attribute to 0-length text");
            }
        }
        int attributeCount = attributes.size();
        if (attributeCount > 0) {
            createRunAttributeDataVectors();
            Vector<AttributedCharacterIterator.Attribute> newRunAttributes = new Vector<>(attributeCount);
            Vector<Object> newRunAttributeValues = new Vector<>(attributeCount);
            this.runAttributes[0] = newRunAttributes;
            this.runAttributeValues[0] = newRunAttributeValues;
            for (Map.Entry<? extends AttributedCharacterIterator.Attribute, ?> entry : attributes.entrySet()) {
                newRunAttributes.addElement(entry.getKey());
                newRunAttributeValues.addElement(entry.getValue());
            }
        }
    }

    public AttributedString(AttributedCharacterIterator text) {
        this(text, text.getBeginIndex(), text.getEndIndex(), null);
    }

    public AttributedString(AttributedCharacterIterator text, int beginIndex, int endIndex) {
        this(text, beginIndex, endIndex, null);
    }

    public AttributedString(AttributedCharacterIterator text, int beginIndex, int endIndex, AttributedCharacterIterator.Attribute[] attributes) {
        if (text == null) {
            throw new NullPointerException();
        }
        int textBeginIndex = text.getBeginIndex();
        int textEndIndex = text.getEndIndex();
        if (beginIndex < textBeginIndex || endIndex > textEndIndex || beginIndex > endIndex) {
            throw new IllegalArgumentException("Invalid substring range");
        }
        StringBuilder textBuilder = new StringBuilder();
        text.setIndex(beginIndex);
        char c4 = text.current();
        while (text.getIndex() < endIndex) {
            textBuilder.append(c4);
            c4 = text.next();
        }
        this.text = textBuilder.toString();
        if (beginIndex == endIndex) {
            return;
        }
        HashSet<AttributedCharacterIterator.Attribute> keys = new HashSet<>();
        if (attributes == null) {
            keys.addAll(text.getAllAttributeKeys());
        } else {
            for (AttributedCharacterIterator.Attribute attribute : attributes) {
                keys.add(attribute);
            }
            keys.retainAll(text.getAllAttributeKeys());
        }
        if (keys.isEmpty()) {
            return;
        }
        Iterator<AttributedCharacterIterator.Attribute> itr = keys.iterator2();
        while (itr.hasNext()) {
            AttributedCharacterIterator.Attribute attributeKey = itr.next();
            text.setIndex(textBeginIndex);
            while (text.getIndex() < endIndex) {
                int start = text.getRunStart(attributeKey);
                int limit = text.getRunLimit(attributeKey);
                Object value = text.getAttribute(attributeKey);
                if (value != null) {
                    if (value instanceof Annotation) {
                        if (start >= beginIndex && limit <= endIndex) {
                            addAttribute(attributeKey, value, start - beginIndex, limit - beginIndex);
                        } else if (limit > endIndex) {
                            break;
                        }
                    } else {
                        if (start >= endIndex) {
                            break;
                        }
                        if (limit > beginIndex) {
                            start = start < beginIndex ? beginIndex : start;
                            limit = limit > endIndex ? endIndex : limit;
                            if (start != limit) {
                                addAttribute(attributeKey, value, start - beginIndex, limit - beginIndex);
                            }
                        }
                    }
                }
                text.setIndex(limit);
            }
        }
    }

    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        int len = length();
        if (len == 0) {
            throw new IllegalArgumentException("Can't add attribute to 0-length text");
        }
        addAttributeImpl(attribute, value, 0, len);
    }

    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value, int beginIndex, int endIndex) {
        if (attribute == null) {
            throw new NullPointerException();
        }
        if (beginIndex < 0 || endIndex > length() || beginIndex >= endIndex) {
            throw new IllegalArgumentException("Invalid substring range");
        }
        addAttributeImpl(attribute, value, beginIndex, endIndex);
    }

    public void addAttributes(Map<? extends AttributedCharacterIterator.Attribute, ?> attributes, int beginIndex, int endIndex) {
        if (attributes == null) {
            throw new NullPointerException();
        }
        if (beginIndex < 0 || endIndex > length() || beginIndex > endIndex) {
            throw new IllegalArgumentException("Invalid substring range");
        }
        if (beginIndex == endIndex) {
            if (attributes.isEmpty()) {
                return;
            } else {
                throw new IllegalArgumentException("Can't add attribute to 0-length text");
            }
        }
        if (this.runCount == 0) {
            createRunAttributeDataVectors();
        }
        int beginRunIndex = ensureRunBreak(beginIndex);
        int endRunIndex = ensureRunBreak(endIndex);
        for (Map.Entry<? extends AttributedCharacterIterator.Attribute, ?> entry : attributes.entrySet()) {
            addAttributeRunData(entry.getKey(), entry.getValue(), beginRunIndex, endRunIndex);
        }
    }

    private synchronized void addAttributeImpl(AttributedCharacterIterator.Attribute attribute, Object value, int beginIndex, int endIndex) {
        if (this.runCount == 0) {
            createRunAttributeDataVectors();
        }
        int beginRunIndex = ensureRunBreak(beginIndex);
        int endRunIndex = ensureRunBreak(endIndex);
        addAttributeRunData(attribute, value, beginRunIndex, endRunIndex);
    }

    private final void createRunAttributeDataVectors() {
        int[] newRunStarts = new int[10];
        Vector<AttributedCharacterIterator.Attribute>[] newRunAttributes = new Vector[10];
        Vector<Object>[] newRunAttributeValues = new Vector[10];
        this.runStarts = newRunStarts;
        this.runAttributes = newRunAttributes;
        this.runAttributeValues = newRunAttributeValues;
        this.runCount = 1;
    }

    private final int ensureRunBreak(int offset) {
        return ensureRunBreak(offset, true);
    }

    private final int ensureRunBreak(int offset, boolean copyAttrs) {
        int i10;
        if (offset == length()) {
            return this.runCount;
        }
        int runIndex = 0;
        while (true) {
            i10 = this.runCount;
            if (runIndex >= i10 || this.runStarts[runIndex] >= offset) {
                break;
            }
            runIndex++;
        }
        if (runIndex < i10 && this.runStarts[runIndex] == offset) {
            return runIndex;
        }
        int[] iArr = this.runStarts;
        int currentCapacity = iArr.length;
        if (i10 == currentCapacity) {
            int newCapacity = (currentCapacity >> 2) + currentCapacity;
            int[] newRunStarts = Arrays.copyOf(iArr, newCapacity);
            Vector<AttributedCharacterIterator.Attribute>[] newRunAttributes = (Vector[]) Arrays.copyOf(this.runAttributes, newCapacity);
            Vector<Object>[] newRunAttributeValues = (Vector[]) Arrays.copyOf(this.runAttributeValues, newCapacity);
            this.runStarts = newRunStarts;
            this.runAttributes = newRunAttributes;
            this.runAttributeValues = newRunAttributeValues;
        }
        Vector<AttributedCharacterIterator.Attribute> newRunAttributes2 = null;
        Vector<Object> newRunAttributeValues2 = null;
        if (copyAttrs) {
            Vector<AttributedCharacterIterator.Attribute> oldRunAttributes = this.runAttributes[runIndex - 1];
            Vector<Object> oldRunAttributeValues = this.runAttributeValues[runIndex - 1];
            if (oldRunAttributes != null) {
                newRunAttributes2 = new Vector<>(oldRunAttributes);
            }
            if (oldRunAttributeValues != null) {
                newRunAttributeValues2 = new Vector<>(oldRunAttributeValues);
            }
        }
        int i11 = this.runCount + 1;
        this.runCount = i11;
        for (int i12 = i11 - 1; i12 > runIndex; i12--) {
            int[] iArr2 = this.runStarts;
            iArr2[i12] = iArr2[i12 - 1];
            Vector<AttributedCharacterIterator.Attribute>[] vectorArr = this.runAttributes;
            vectorArr[i12] = vectorArr[i12 - 1];
            Vector<Object>[] vectorArr2 = this.runAttributeValues;
            vectorArr2[i12] = vectorArr2[i12 - 1];
        }
        this.runStarts[runIndex] = offset;
        this.runAttributes[runIndex] = newRunAttributes2;
        this.runAttributeValues[runIndex] = newRunAttributeValues2;
        return runIndex;
    }

    private void addAttributeRunData(AttributedCharacterIterator.Attribute attribute, Object value, int beginRunIndex, int endRunIndex) {
        for (int i10 = beginRunIndex; i10 < endRunIndex; i10++) {
            int keyValueIndex = -1;
            Vector<AttributedCharacterIterator.Attribute> vector = this.runAttributes[i10];
            if (vector == null) {
                Vector<AttributedCharacterIterator.Attribute> newRunAttributes = new Vector<>();
                Vector<Object> newRunAttributeValues = new Vector<>();
                this.runAttributes[i10] = newRunAttributes;
                this.runAttributeValues[i10] = newRunAttributeValues;
            } else {
                keyValueIndex = vector.indexOf(attribute);
            }
            if (keyValueIndex == -1) {
                int oldSize = this.runAttributes[i10].size();
                this.runAttributes[i10].addElement(attribute);
                try {
                    this.runAttributeValues[i10].addElement(value);
                } catch (Exception e2) {
                    this.runAttributes[i10].setSize(oldSize);
                    this.runAttributeValues[i10].setSize(oldSize);
                }
            } else {
                this.runAttributeValues[i10].set(keyValueIndex, value);
            }
        }
    }

    public AttributedCharacterIterator getIterator() {
        return getIterator(null, 0, length());
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator.Attribute[] attributes) {
        return getIterator(attributes, 0, length());
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator.Attribute[] attributes, int beginIndex, int endIndex) {
        return new AttributedStringIterator(attributes, beginIndex, endIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int length() {
        return this.text.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Object getAttribute(AttributedCharacterIterator.Attribute attribute, int runIndex) {
        Vector<AttributedCharacterIterator.Attribute> currentRunAttributes = this.runAttributes[runIndex];
        Vector<Object> currentRunAttributeValues = this.runAttributeValues[runIndex];
        if (currentRunAttributes == null) {
            return null;
        }
        int attributeIndex = currentRunAttributes.indexOf(attribute);
        if (attributeIndex == -1) {
            return null;
        }
        return currentRunAttributeValues.elementAt(attributeIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getAttributeCheckRange(AttributedCharacterIterator.Attribute attribute, int runIndex, int beginIndex, int endIndex) {
        Object value = getAttribute(attribute, runIndex);
        if (value instanceof Annotation) {
            if (beginIndex > 0) {
                int currIndex = runIndex;
                int runStart = this.runStarts[currIndex];
                while (runStart >= beginIndex && valuesMatch(value, getAttribute(attribute, currIndex - 1))) {
                    currIndex--;
                    runStart = this.runStarts[currIndex];
                }
                if (runStart < beginIndex) {
                    return null;
                }
            }
            int textLength = length();
            if (endIndex < textLength) {
                int currIndex2 = runIndex;
                int runLimit = currIndex2 < this.runCount + (-1) ? this.runStarts[currIndex2 + 1] : textLength;
                while (runLimit <= endIndex && valuesMatch(value, getAttribute(attribute, currIndex2 + 1))) {
                    currIndex2++;
                    runLimit = currIndex2 < this.runCount + (-1) ? this.runStarts[currIndex2 + 1] : textLength;
                }
                if (runLimit > endIndex) {
                    return null;
                }
            }
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean attributeValuesMatch(Set<? extends AttributedCharacterIterator.Attribute> attributes, int runIndex1, int runIndex2) {
        for (AttributedCharacterIterator.Attribute key : attributes) {
            if (!valuesMatch(getAttribute(key, runIndex1), getAttribute(key, runIndex2))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean valuesMatch(Object value1, Object value2) {
        if (value1 == null) {
            return value2 == null;
        }
        return value1.equals(value2);
    }

    private final void appendContents(StringBuffer buf, CharacterIterator iterator) {
        int end = iterator.getEndIndex();
        for (int index = iterator.getBeginIndex(); index < end; index++) {
            iterator.setIndex(index);
            buf.append(iterator.current());
        }
    }

    private void setAttributes(Map<AttributedCharacterIterator.Attribute, Object> attrs, int offset) {
        int size;
        if (this.runCount == 0) {
            createRunAttributeDataVectors();
        }
        int index = ensureRunBreak(offset, false);
        if (attrs != null && (size = attrs.size()) > 0) {
            Vector<AttributedCharacterIterator.Attribute> runAttrs = new Vector<>(size);
            Vector<Object> runValues = new Vector<>(size);
            for (Map.Entry<AttributedCharacterIterator.Attribute, Object> entry : attrs.entrySet()) {
                runAttrs.add(entry.getKey());
                runValues.add(entry.getValue());
            }
            this.runAttributes[index] = runAttrs;
            this.runAttributeValues[index] = runValues;
        }
    }

    private static <K, V> boolean mapsDiffer(Map<K, V> last, Map<K, V> attrs) {
        if (last == null) {
            return attrs != null && attrs.size() > 0;
        }
        return true ^ last.equals(attrs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class AttributedStringIterator implements AttributedCharacterIterator {
        private int beginIndex;
        private int currentIndex;
        private int currentRunIndex;
        private int currentRunLimit;
        private int currentRunStart;
        private int endIndex;
        private AttributedCharacterIterator.Attribute[] relevantAttributes;

        AttributedStringIterator(AttributedCharacterIterator.Attribute[] attributes, int beginIndex, int endIndex) {
            if (beginIndex < 0 || beginIndex > endIndex || endIndex > AttributedString.this.length()) {
                throw new IllegalArgumentException("Invalid substring range");
            }
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.currentIndex = beginIndex;
            updateRunInfo();
            if (attributes != null) {
                this.relevantAttributes = (AttributedCharacterIterator.Attribute[]) attributes.clone();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AttributedStringIterator)) {
                return false;
            }
            AttributedStringIterator that = (AttributedStringIterator) obj;
            return AttributedString.this == that.getString() && this.currentIndex == that.currentIndex && this.beginIndex == that.beginIndex && this.endIndex == that.endIndex;
        }

        public int hashCode() {
            return ((AttributedString.this.text.hashCode() ^ this.currentIndex) ^ this.beginIndex) ^ this.endIndex;
        }

        @Override // java.text.CharacterIterator
        public Object clone() {
            try {
                AttributedStringIterator other = (AttributedStringIterator) super.clone();
                return other;
            } catch (CloneNotSupportedException e2) {
                throw new InternalError(e2);
            }
        }

        @Override // java.text.CharacterIterator
        public char first() {
            return internalSetIndex(this.beginIndex);
        }

        @Override // java.text.CharacterIterator
        public char last() {
            int i10 = this.endIndex;
            if (i10 == this.beginIndex) {
                return internalSetIndex(i10);
            }
            return internalSetIndex(i10 - 1);
        }

        @Override // java.text.CharacterIterator
        public char current() {
            int i10 = this.currentIndex;
            if (i10 == this.endIndex) {
                return (char) 65535;
            }
            return AttributedString.this.charAt(i10);
        }

        @Override // java.text.CharacterIterator
        public char next() {
            int i10 = this.currentIndex;
            if (i10 < this.endIndex) {
                return internalSetIndex(i10 + 1);
            }
            return (char) 65535;
        }

        @Override // java.text.CharacterIterator
        public char previous() {
            int i10 = this.currentIndex;
            if (i10 > this.beginIndex) {
                return internalSetIndex(i10 - 1);
            }
            return (char) 65535;
        }

        @Override // java.text.CharacterIterator
        public char setIndex(int position) {
            if (position < this.beginIndex || position > this.endIndex) {
                throw new IllegalArgumentException("Invalid index");
            }
            return internalSetIndex(position);
        }

        @Override // java.text.CharacterIterator
        public int getBeginIndex() {
            return this.beginIndex;
        }

        @Override // java.text.CharacterIterator
        public int getEndIndex() {
            return this.endIndex;
        }

        @Override // java.text.CharacterIterator
        public int getIndex() {
            return this.currentIndex;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunStart() {
            return this.currentRunStart;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            int i10 = this.currentRunStart;
            if (i10 == this.beginIndex || this.currentRunIndex == -1) {
                return i10;
            }
            Object value = getAttribute(attribute);
            int runStart = this.currentRunStart;
            int runIndex = this.currentRunIndex;
            while (runStart > this.beginIndex && AttributedString.valuesMatch(value, AttributedString.this.getAttribute(attribute, runIndex - 1))) {
                runIndex--;
                runStart = AttributedString.this.runStarts[runIndex];
            }
            if (runStart < this.beginIndex) {
                int runStart2 = this.beginIndex;
                return runStart2;
            }
            return runStart;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunStart(Set<? extends AttributedCharacterIterator.Attribute> attributes) {
            int runStart = this.currentRunStart;
            if (runStart == this.beginIndex || this.currentRunIndex == -1) {
                return runStart;
            }
            int runStart2 = this.currentRunStart;
            int runIndex = this.currentRunIndex;
            while (runStart2 > this.beginIndex && AttributedString.this.attributeValuesMatch(attributes, this.currentRunIndex, runIndex - 1)) {
                runIndex--;
                runStart2 = AttributedString.this.runStarts[runIndex];
            }
            if (runStart2 < this.beginIndex) {
                return this.beginIndex;
            }
            return runStart2;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunLimit() {
            return this.currentRunLimit;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            int i10 = this.currentRunLimit;
            if (i10 == this.endIndex || this.currentRunIndex == -1) {
                return i10;
            }
            Object value = getAttribute(attribute);
            int runLimit = this.currentRunLimit;
            int runIndex = this.currentRunIndex;
            while (runLimit < this.endIndex && AttributedString.valuesMatch(value, AttributedString.this.getAttribute(attribute, runIndex + 1))) {
                runIndex++;
                runLimit = runIndex < AttributedString.this.runCount + (-1) ? AttributedString.this.runStarts[runIndex + 1] : this.endIndex;
            }
            if (runLimit > this.endIndex) {
                int runLimit2 = this.endIndex;
                return runLimit2;
            }
            return runLimit;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunLimit(Set<? extends AttributedCharacterIterator.Attribute> attributes) {
            int runLimit = this.currentRunLimit;
            if (runLimit == this.endIndex || this.currentRunIndex == -1) {
                return runLimit;
            }
            int runLimit2 = this.currentRunLimit;
            int runIndex = this.currentRunIndex;
            while (runLimit2 < this.endIndex && AttributedString.this.attributeValuesMatch(attributes, this.currentRunIndex, runIndex + 1)) {
                runIndex++;
                runLimit2 = runIndex < AttributedString.this.runCount + (-1) ? AttributedString.this.runStarts[runIndex + 1] : this.endIndex;
            }
            if (runLimit2 > this.endIndex) {
                return this.endIndex;
            }
            return runLimit2;
        }

        @Override // java.text.AttributedCharacterIterator
        public Map<AttributedCharacterIterator.Attribute, Object> getAttributes() {
            if (AttributedString.this.runAttributes != null && this.currentRunIndex != -1) {
                Vector<AttributedCharacterIterator.Attribute>[] vectorArr = AttributedString.this.runAttributes;
                int i10 = this.currentRunIndex;
                if (vectorArr[i10] != null) {
                    return new AttributeMap(i10, this.beginIndex, this.endIndex);
                }
            }
            return new Hashtable();
        }

        @Override // java.text.AttributedCharacterIterator
        public Set<AttributedCharacterIterator.Attribute> getAllAttributeKeys() {
            Set<AttributedCharacterIterator.Attribute> keys;
            Vector<AttributedCharacterIterator.Attribute> currentRunAttributes;
            if (AttributedString.this.runAttributes == null) {
                return new HashSet();
            }
            synchronized (AttributedString.this) {
                keys = new HashSet<>();
                for (int i10 = 0; i10 < AttributedString.this.runCount; i10++) {
                    if (AttributedString.this.runStarts[i10] < this.endIndex && ((i10 == AttributedString.this.runCount - 1 || AttributedString.this.runStarts[i10 + 1] > this.beginIndex) && (currentRunAttributes = AttributedString.this.runAttributes[i10]) != null)) {
                        int j10 = currentRunAttributes.size();
                        while (true) {
                            int j11 = j10 - 1;
                            if (j10 > 0) {
                                keys.add(currentRunAttributes.get(j11));
                                j10 = j11;
                            }
                        }
                    }
                }
            }
            return keys;
        }

        @Override // java.text.AttributedCharacterIterator
        public Object getAttribute(AttributedCharacterIterator.Attribute attribute) {
            int runIndex = this.currentRunIndex;
            if (runIndex < 0) {
                return null;
            }
            return AttributedString.this.getAttributeCheckRange(attribute, runIndex, this.beginIndex, this.endIndex);
        }

        private AttributedString getString() {
            return AttributedString.this;
        }

        private char internalSetIndex(int position) {
            this.currentIndex = position;
            if (position < this.currentRunStart || position >= this.currentRunLimit) {
                updateRunInfo();
            }
            if (this.currentIndex == this.endIndex) {
                return (char) 65535;
            }
            return AttributedString.this.charAt(position);
        }

        private void updateRunInfo() {
            int i10 = this.currentIndex;
            int i11 = this.endIndex;
            if (i10 == i11) {
                this.currentRunLimit = i11;
                this.currentRunStart = i11;
                this.currentRunIndex = -1;
                return;
            }
            synchronized (AttributedString.this) {
                int runIndex = -1;
                while (runIndex < AttributedString.this.runCount - 1 && AttributedString.this.runStarts[runIndex + 1] <= this.currentIndex) {
                    runIndex++;
                }
                this.currentRunIndex = runIndex;
                if (runIndex >= 0) {
                    int i12 = AttributedString.this.runStarts[runIndex];
                    this.currentRunStart = i12;
                    int i13 = this.beginIndex;
                    if (i12 < i13) {
                        this.currentRunStart = i13;
                    }
                } else {
                    this.currentRunStart = this.beginIndex;
                }
                if (runIndex < AttributedString.this.runCount - 1) {
                    int i14 = AttributedString.this.runStarts[runIndex + 1];
                    this.currentRunLimit = i14;
                    int i15 = this.endIndex;
                    if (i14 > i15) {
                        this.currentRunLimit = i15;
                    }
                } else {
                    this.currentRunLimit = this.endIndex;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private final class AttributeMap extends AbstractMap<AttributedCharacterIterator.Attribute, Object> {
        int beginIndex;
        int endIndex;
        int runIndex;

        AttributeMap(int runIndex, int beginIndex, int endIndex) {
            this.runIndex = runIndex;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<AttributedCharacterIterator.Attribute, Object>> entrySet() {
            HashSet<Map.Entry<AttributedCharacterIterator.Attribute, Object>> set = new HashSet<>();
            synchronized (AttributedString.this) {
                int size = AttributedString.this.runAttributes[this.runIndex].size();
                for (int i10 = 0; i10 < size; i10++) {
                    AttributedCharacterIterator.Attribute key = AttributedString.this.runAttributes[this.runIndex].get(i10);
                    Object value = AttributedString.this.runAttributeValues[this.runIndex].get(i10);
                    if (!(value instanceof Annotation) || (value = AttributedString.this.getAttributeCheckRange(key, this.runIndex, this.beginIndex, this.endIndex)) != null) {
                        Map.Entry<AttributedCharacterIterator.Attribute, Object> entry = new AttributeEntry(key, value);
                        set.add(entry);
                    }
                }
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object key) {
            return AttributedString.this.getAttributeCheckRange((AttributedCharacterIterator.Attribute) key, this.runIndex, this.beginIndex, this.endIndex);
        }
    }
}
