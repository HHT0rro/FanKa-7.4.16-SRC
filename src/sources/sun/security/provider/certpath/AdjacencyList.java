package sun.security.provider.certpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AdjacencyList {
    private List<List<Vertex>> mOrigList;
    private ArrayList<BuildStep> mStepList = new ArrayList<>();

    public AdjacencyList(List<List<Vertex>> list) {
        this.mOrigList = list;
        buildList(list, 0, null);
    }

    public Iterator<BuildStep> iterator() {
        return Collections.unmodifiableList(this.mStepList).iterator2();
    }

    private boolean buildList(List<List<Vertex>> theList, int index, BuildStep follow) {
        List<Vertex> l10 = theList.get(index);
        boolean allNegOne = true;
        boolean allXcps = true;
        for (Vertex v2 : l10) {
            if (v2.getIndex() != -1) {
                if (theList.get(v2.getIndex()).size() != 0) {
                    allNegOne = false;
                }
            } else if (v2.getThrowable() == null) {
                allXcps = false;
            }
            this.mStepList.add(new BuildStep(v2, 1));
        }
        if (allNegOne) {
            if (allXcps) {
                if (follow == null) {
                    this.mStepList.add(new BuildStep(null, 4));
                } else {
                    this.mStepList.add(new BuildStep(follow.getVertex(), 2));
                }
                return false;
            }
            List<Vertex> possibles = new ArrayList<>();
            for (Vertex v10 : l10) {
                if (v10.getThrowable() == null) {
                    possibles.add(v10);
                }
            }
            if (possibles.size() == 1) {
                this.mStepList.add(new BuildStep(possibles.get(0), 5));
            } else {
                this.mStepList.add(new BuildStep(possibles.get(0), 5));
            }
            return true;
        }
        boolean success = false;
        for (Vertex v11 : l10) {
            if (v11.getIndex() != -1 && theList.get(v11.getIndex()).size() != 0) {
                BuildStep bs = new BuildStep(v11, 3);
                this.mStepList.add(bs);
                success = buildList(theList, v11.getIndex(), bs);
            }
        }
        if (success) {
            return true;
        }
        if (follow == null) {
            this.mStepList.add(new BuildStep(null, 4));
        } else {
            this.mStepList.add(new BuildStep(follow.getVertex(), 2));
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[\n");
        int i10 = 0;
        for (List<Vertex> l10 : this.mOrigList) {
            int i11 = i10 + 1;
            sb2.append("LinkedList[").append(i10).append("]:\n");
            for (Vertex step : l10) {
                sb2.append(step.toString()).append("\n");
            }
            i10 = i11;
        }
        sb2.append("]\n");
        return sb2.toString();
    }
}
