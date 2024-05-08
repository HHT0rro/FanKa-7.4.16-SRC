package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SequencesComparator<T> {
    private final Equator<? super T> equator;
    private final List<T> sequence1;
    private final List<T> sequence2;
    private final int[] vDown;
    private final int[] vUp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        public Snake(int i10, int i11, int i12) {
            this.start = i10;
            this.end = i11;
            this.diag = i12;
        }

        public int getDiag() {
            return this.diag;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    private void buildScript(int i10, int i11, int i12, int i13, EditScript<T> editScript) {
        Snake middleSnake = getMiddleSnake(i10, i11, i12, i13);
        if (middleSnake != null && ((middleSnake.getStart() != i11 || middleSnake.getDiag() != i11 - i13) && (middleSnake.getEnd() != i10 || middleSnake.getDiag() != i10 - i12))) {
            buildScript(i10, middleSnake.getStart(), i12, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(this.sequence1.get(start)));
            }
            buildScript(middleSnake.getEnd(), i11, middleSnake.getEnd() - middleSnake.getDiag(), i13, editScript);
            return;
        }
        int i14 = i10;
        int i15 = i12;
        while (true) {
            if (i14 >= i11 && i15 >= i13) {
                return;
            }
            if (i14 < i11 && i15 < i13 && this.equator.equate(this.sequence1.get(i14), this.sequence2.get(i15))) {
                editScript.append(new KeepCommand<>(this.sequence1.get(i14)));
                i14++;
            } else if (i11 - i10 > i13 - i12) {
                editScript.append(new DeleteCommand<>(this.sequence1.get(i14)));
                i14++;
            } else {
                editScript.append(new InsertCommand<>(this.sequence2.get(i15)));
            }
            i15++;
        }
    }

    private Snake buildSnake(int i10, int i11, int i12, int i13) {
        int i14 = i10;
        while (true) {
            int i15 = i14 - i11;
            if (i15 >= i13 || i14 >= i12 || !this.equator.equate(this.sequence1.get(i14), this.sequence2.get(i15))) {
                break;
            }
            i14++;
        }
        return new Snake(i10, i14, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r11[r10 - 1] < r11[r10 + 1]) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00be, code lost:
    
        if (r11[r12 + 1] <= r11[r12 - 1]) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0128, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8 A[LOOP:4: B:55:0x00de->B:59:0x00f8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106 A[EDGE_INSN: B:60:0x0106->B:61:0x0106 BREAK  A[LOOP:4: B:55:0x00de->B:59:0x00f8], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.collections4.sequence.SequencesComparator.Snake getMiddleSnake(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.sequence.SequencesComparator.getMiddleSnake(int, int, int, int):org.apache.commons.collections4.sequence.SequencesComparator$Snake");
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
        return editScript;
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.sequence1 = list;
        this.sequence2 = list2;
        this.equator = equator;
        int size = list.size() + list2.size() + 2;
        this.vDown = new int[size];
        this.vUp = new int[size];
    }
}
