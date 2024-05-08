package java.text;

import java.text.Format;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class CharacterIteratorFieldDelegate implements Format.FieldDelegate {
    private ArrayList<AttributedString> attributedStrings = new ArrayList<>();
    private int size;

    @Override // java.text.Format.FieldDelegate
    public void formatted(Format.Field attr, Object value, int start, int end, StringBuffer buffer) {
        if (start != end) {
            if (start < this.size) {
                int index = this.size;
                int asIndex = this.attributedStrings.size() - 1;
                while (start < index) {
                    int asIndex2 = asIndex - 1;
                    AttributedString as = this.attributedStrings.get(asIndex);
                    int newIndex = index - as.length();
                    int aStart = Math.max(0, start - newIndex);
                    as.addAttribute(attr, value, aStart, Math.min(end - start, as.length() - aStart) + aStart);
                    index = newIndex;
                    asIndex = asIndex2;
                }
            }
            int index2 = this.size;
            if (index2 < start) {
                this.attributedStrings.add(new AttributedString(buffer.substring(index2, start)));
                this.size = start;
            }
            int i10 = this.size;
            if (i10 < end) {
                AttributedString string = new AttributedString(buffer.substring(Math.max(start, i10), end));
                string.addAttribute(attr, value);
                this.attributedStrings.add(string);
                this.size = end;
            }
        }
    }

    @Override // java.text.Format.FieldDelegate
    public void formatted(int fieldID, Format.Field attr, Object value, int start, int end, StringBuffer buffer) {
        formatted(attr, value, start, end, buffer);
    }

    public AttributedCharacterIterator getIterator(String string) {
        int length = string.length();
        int i10 = this.size;
        if (length > i10) {
            this.attributedStrings.add(new AttributedString(string.substring(i10)));
            this.size = string.length();
        }
        int iCount = this.attributedStrings.size();
        AttributedCharacterIterator[] iterators = new AttributedCharacterIterator[iCount];
        for (int counter = 0; counter < iCount; counter++) {
            iterators[counter] = this.attributedStrings.get(counter).getIterator();
        }
        return new AttributedString(iterators).getIterator();
    }
}
