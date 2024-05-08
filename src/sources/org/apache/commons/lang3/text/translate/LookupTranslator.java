package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<String, String> lookupMap = new HashMap<>();
    private final HashSet<Character> prefixSet = new HashSet<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i10 = 0;
        int i11 = Integer.MAX_VALUE;
        if (charSequenceArr != null) {
            int i12 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.prefixSet.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i11 = length < i11 ? length : i11;
                if (length > i12) {
                    i12 = length;
                }
            }
            i10 = i12;
        }
        this.shortest = i11;
        this.longest = i10;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i10, Writer writer) throws IOException {
        if (!this.prefixSet.contains(Character.valueOf(charSequence.charAt(i10)))) {
            return 0;
        }
        int i11 = this.longest;
        if (i10 + i11 > charSequence.length()) {
            i11 = charSequence.length() - i10;
        }
        while (i11 >= this.shortest) {
            String str = this.lookupMap.get(charSequence.subSequence(i10, i10 + i11).toString());
            if (str != null) {
                writer.write(str);
                return i11;
            }
            i11--;
        }
        return 0;
    }
}
