package sun.security.x509;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GeneralSubtrees implements Cloneable {
    private static final int NAME_DIFF_TYPE = -1;
    private static final int NAME_MATCH = 0;
    private static final int NAME_NARROWS = 1;
    private static final int NAME_SAME_TYPE = 3;
    private static final int NAME_WIDENS = 2;
    private final List<GeneralSubtree> trees;

    public GeneralSubtrees() {
        this.trees = new ArrayList();
    }

    private GeneralSubtrees(GeneralSubtrees source) {
        this.trees = new ArrayList(source.trees);
    }

    public GeneralSubtrees(DerValue val) throws IOException {
        this();
        if (val.tag != 48) {
            throw new IOException("Invalid encoding of GeneralSubtrees.");
        }
        while (val.data.available() != 0) {
            DerValue opt = val.data.getDerValue();
            GeneralSubtree tree = new GeneralSubtree(opt);
            add(tree);
        }
    }

    public GeneralSubtree get(int index) {
        return this.trees.get(index);
    }

    public void remove(int index) {
        this.trees.remove(index);
    }

    public void add(GeneralSubtree tree) {
        if (tree == null) {
            throw new NullPointerException();
        }
        this.trees.add(tree);
    }

    public boolean contains(GeneralSubtree tree) {
        if (tree == null) {
            throw new NullPointerException();
        }
        return this.trees.contains(tree);
    }

    public int size() {
        return this.trees.size();
    }

    public Iterator<GeneralSubtree> iterator() {
        return this.trees.iterator2();
    }

    public List<GeneralSubtree> trees() {
        return this.trees;
    }

    public Object clone() {
        return new GeneralSubtrees(this);
    }

    public String toString() {
        String s2 = "   GeneralSubtrees:\n" + this.trees.toString() + "\n";
        return s2;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream seq = new DerOutputStream();
        int n10 = size();
        for (int i10 = 0; i10 < n10; i10++) {
            get(i10).encode(seq);
        }
        out.write((byte) 48, seq);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeneralSubtrees)) {
            return false;
        }
        GeneralSubtrees other = (GeneralSubtrees) obj;
        return this.trees.equals(other.trees);
    }

    public int hashCode() {
        return this.trees.hashCode();
    }

    private GeneralNameInterface getGeneralNameInterface(int ndx) {
        return getGeneralNameInterface(get(ndx));
    }

    private static GeneralNameInterface getGeneralNameInterface(GeneralSubtree gs) {
        GeneralName gn = gs.getName();
        GeneralNameInterface gni = gn.getName();
        return gni;
    }

    private void minimize() {
        int i10 = 0;
        while (i10 < size() - 1) {
            GeneralNameInterface current = getGeneralNameInterface(i10);
            boolean remove1 = false;
            int j10 = i10 + 1;
            while (true) {
                if (j10 < size()) {
                    GeneralNameInterface subsequent = getGeneralNameInterface(j10);
                    switch (current.constrains(subsequent)) {
                        case 0:
                            remove1 = true;
                            break;
                        case 1:
                            remove(j10);
                            j10--;
                            break;
                        case 2:
                            remove1 = true;
                            break;
                    }
                    j10++;
                }
            }
            if (remove1) {
                remove(i10);
                i10--;
            }
            i10++;
        }
    }

    private GeneralSubtree createWidestSubtree(GeneralNameInterface name) {
        GeneralName newName;
        try {
            switch (name.getType()) {
                case 0:
                    ObjectIdentifier otherOID = ((OtherName) name).getOID();
                    GeneralName newName2 = new GeneralName(new OtherName(otherOID, null));
                    newName = newName2;
                    break;
                case 1:
                    newName = new GeneralName(new RFC822Name(""));
                    break;
                case 2:
                    newName = new GeneralName(new DNSName(""));
                    break;
                case 3:
                    newName = new GeneralName(new X400Address((byte[]) null));
                    break;
                case 4:
                    newName = new GeneralName(new X500Name(""));
                    break;
                case 5:
                    newName = new GeneralName(new EDIPartyName(""));
                    break;
                case 6:
                    newName = new GeneralName(new URIName(""));
                    break;
                case 7:
                    newName = new GeneralName(new IPAddressName((byte[]) null));
                    break;
                case 8:
                    newName = new GeneralName(new OIDName(new ObjectIdentifier((int[]) null)));
                    break;
                default:
                    throw new IOException("Unsupported GeneralNameInterface type: " + name.getType());
            }
            return new GeneralSubtree(newName, 0, -1);
        } catch (IOException e2) {
            throw new RuntimeException("Unexpected error: " + ((Object) e2), e2);
        }
    }

    public GeneralSubtrees intersect(GeneralSubtrees other) {
        if (other == null) {
            throw new NullPointerException("other GeneralSubtrees must not be null");
        }
        GeneralSubtrees newThis = new GeneralSubtrees();
        GeneralSubtrees newExcluded = null;
        if (size() == 0) {
            union(other);
            return null;
        }
        minimize();
        other.minimize();
        int i10 = 0;
        while (i10 < size()) {
            GeneralNameInterface thisEntry = getGeneralNameInterface(i10);
            boolean sameType = false;
            int j10 = 0;
            while (true) {
                if (j10 < other.size()) {
                    GeneralSubtree otherEntryGS = other.get(j10);
                    GeneralNameInterface otherEntry = getGeneralNameInterface(otherEntryGS);
                    switch (thisEntry.constrains(otherEntry)) {
                        case 0:
                        case 2:
                            sameType = false;
                            break;
                        case 1:
                            remove(i10);
                            i10--;
                            newThis.add(otherEntryGS);
                            sameType = false;
                            break;
                        case 3:
                            sameType = true;
                            break;
                    }
                    j10++;
                }
            }
            if (sameType) {
                boolean intersection = false;
                for (int j11 = 0; j11 < size(); j11++) {
                    GeneralNameInterface thisAltEntry = getGeneralNameInterface(j11);
                    if (thisAltEntry.getType() == thisEntry.getType()) {
                        for (int k10 = 0; k10 < other.size(); k10++) {
                            GeneralNameInterface othAltEntry = other.getGeneralNameInterface(k10);
                            int constraintType = thisAltEntry.constrains(othAltEntry);
                            if (constraintType == 0 || constraintType == 2 || constraintType == 1) {
                                intersection = true;
                            }
                        }
                    }
                }
                if (!intersection) {
                    if (newExcluded == null) {
                        newExcluded = new GeneralSubtrees();
                    }
                    GeneralSubtree widestSubtree = createWidestSubtree(thisEntry);
                    if (!newExcluded.contains(widestSubtree)) {
                        newExcluded.add(widestSubtree);
                    }
                }
                remove(i10);
                i10--;
            }
            i10++;
        }
        int i11 = newThis.size();
        if (i11 > 0) {
            union(newThis);
        }
        for (int i12 = 0; i12 < other.size(); i12++) {
            GeneralSubtree otherEntryGS2 = other.get(i12);
            GeneralNameInterface otherEntry2 = getGeneralNameInterface(otherEntryGS2);
            boolean diffType = false;
            int j12 = 0;
            while (true) {
                if (j12 < size()) {
                    switch (getGeneralNameInterface(j12).constrains(otherEntry2)) {
                        case -1:
                            diffType = true;
                            break;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            diffType = false;
                            break;
                    }
                    j12++;
                }
            }
            if (diffType) {
                add(otherEntryGS2);
            }
        }
        return newExcluded;
    }

    public void union(GeneralSubtrees other) {
        if (other != null) {
            int n10 = other.size();
            for (int i10 = 0; i10 < n10; i10++) {
                add(other.get(i10));
            }
            minimize();
        }
    }

    public void reduce(GeneralSubtrees excluded) {
        if (excluded == null) {
            return;
        }
        int n10 = excluded.size();
        for (int i10 = 0; i10 < n10; i10++) {
            GeneralNameInterface excludedName = excluded.getGeneralNameInterface(i10);
            int j10 = 0;
            while (j10 < size()) {
                GeneralNameInterface permitted = getGeneralNameInterface(j10);
                switch (excludedName.constrains(permitted)) {
                    case 0:
                        remove(j10);
                        j10--;
                        break;
                    case 1:
                        remove(j10);
                        j10--;
                        break;
                }
                j10++;
            }
        }
    }
}
