package java.text;

import libcore.icu.CollationKeyICU;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RuleBasedCollator extends Collator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RuleBasedCollator(android.icu.text.RuleBasedCollator wrapper) {
        super(wrapper);
    }

    public RuleBasedCollator(String rules) throws ParseException {
        if (rules == null) {
            throw new NullPointerException("rules == null");
        }
        try {
            this.icuColl = new android.icu.text.RuleBasedCollator(rules);
        } catch (Exception e2) {
            if (e2 instanceof ParseException) {
                throw ((ParseException) e2);
            }
            throw new ParseException(e2.getMessage(), -1);
        }
    }

    public String getRules() {
        return collAsICU().getRules();
    }

    public CollationElementIterator getCollationElementIterator(String source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        return new CollationElementIterator(collAsICU().getCollationElementIterator(source));
    }

    public CollationElementIterator getCollationElementIterator(CharacterIterator source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        return new CollationElementIterator(collAsICU().getCollationElementIterator(source));
    }

    @Override // java.text.Collator
    public synchronized int compare(String source, String target) {
        if (source == null || target == null) {
            throw new NullPointerException();
        }
        return this.icuColl.compare(source, target);
    }

    @Override // java.text.Collator
    public synchronized CollationKey getCollationKey(String source) {
        if (source == null) {
            return null;
        }
        return new CollationKeyICU(source, this.icuColl.getCollationKey(source));
    }

    @Override // java.text.Collator
    public Object clone() {
        return super.clone();
    }

    @Override // java.text.Collator, java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return super.equals(obj);
    }

    @Override // java.text.Collator
    public int hashCode() {
        return this.icuColl.hashCode();
    }

    private android.icu.text.RuleBasedCollator collAsICU() {
        return (android.icu.text.RuleBasedCollator) this.icuColl;
    }
}
