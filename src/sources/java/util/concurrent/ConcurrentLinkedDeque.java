package java.util.concurrent;

import com.android.ims.ImsConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConcurrentLinkedDeque<E> extends AbstractCollection<E> implements Deque<E>, Serializable {
    private static final VarHandle HEAD;
    private static final int HOPS = 2;
    private static final VarHandle ITEM;
    private static final VarHandle NEXT;
    private static final Node<Object> NEXT_TERMINATOR;
    private static final VarHandle PREV;
    private static final Node<Object> PREV_TERMINATOR;
    private static final VarHandle TAIL;
    private static final long serialVersionUID = 876323262645176354L;
    private volatile transient Node<E> head;
    private volatile transient Node<E> tail;

    Node<E> prevTerminator() {
        return (Node<E>) PREV_TERMINATOR;
    }

    Node<E> nextTerminator() {
        return (Node<E>) NEXT_TERMINATOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Node<E> {
        volatile E item;
        volatile Node<E> next;
        volatile Node<E> prev;

        Node() {
        }
    }

    static <E> Node<E> newNode(E item) {
        Node<E> node = new Node<>();
        (void) ITEM.set(node, item);
        return node;
    }

    private void linkFirst(E e2) {
        Node<E> h10;
        Node<E> p10;
        Node<E> newNode = newNode(Objects.requireNonNull(e2));
        loop0: while (true) {
            h10 = this.head;
            p10 = h10;
            while (true) {
                Node<E> q10 = p10.prev;
                if (q10 != null) {
                    p10 = q10;
                    Node<E> q11 = q10.prev;
                    if (q11 != null) {
                        Node<E> h11 = this.head;
                        p10 = h10 != h11 ? h11 : q11;
                        h10 = h11;
                    }
                }
                if (p10.next == p10) {
                    break;
                }
                (void) NEXT.set(newNode, p10);
                if ((boolean) PREV.compareAndSet(p10, null, newNode)) {
                    break loop0;
                }
            }
        }
        if (p10 != h10) {
            (boolean) HEAD.weakCompareAndSet(this, h10, newNode);
        }
    }

    private void linkLast(E e2) {
        Node<E> t2;
        Node<E> p10;
        Node<E> newNode = newNode(Objects.requireNonNull(e2));
        loop0: while (true) {
            t2 = this.tail;
            p10 = t2;
            while (true) {
                Node<E> q10 = p10.next;
                if (q10 != null) {
                    p10 = q10;
                    Node<E> q11 = q10.next;
                    if (q11 != null) {
                        Node<E> t10 = this.tail;
                        p10 = t2 != t10 ? t10 : q11;
                        t2 = t10;
                    }
                }
                if (p10.prev == p10) {
                    break;
                }
                (void) PREV.set(newNode, p10);
                if ((boolean) NEXT.compareAndSet(p10, null, newNode)) {
                    break loop0;
                }
            }
        }
        if (p10 != t2) {
            (boolean) TAIL.weakCompareAndSet(this, t2, newNode);
        }
    }

    void unlink(Node<E> x10) {
        boolean isFirst;
        Node<E> activePred;
        Node<E> q10;
        boolean isLast;
        Node<E> prev = x10.prev;
        Node<E> next = x10.next;
        if (prev == null) {
            unlinkFirst(x10, next);
            return;
        }
        if (next == null) {
            unlinkLast(x10, prev);
            return;
        }
        int hops = 1;
        Node<E> p10 = prev;
        while (true) {
            if (p10.item != null) {
                Node<E> activePred2 = p10;
                isFirst = false;
                activePred = activePred2;
                break;
            }
            Node<E> activePred3 = p10.prev;
            if (activePred3 == null) {
                if (p10.next == p10) {
                    return;
                }
                activePred = p10;
                isFirst = true;
            } else {
                if (p10 == activePred3) {
                    return;
                }
                p10 = activePred3;
                hops++;
            }
        }
        Node<E> p11 = next;
        while (true) {
            if (p11.item != null) {
                q10 = p11;
                isLast = false;
                break;
            }
            Node<E> activeSucc = p11.next;
            if (activeSucc == null) {
                if (p11.prev == p11) {
                    return;
                }
                q10 = p11;
                isLast = true;
            } else {
                if (p11 == activeSucc) {
                    return;
                }
                p11 = activeSucc;
                hops++;
            }
        }
        if (hops < 2 && (isFirst | isLast)) {
            return;
        }
        skipDeletedSuccessors(activePred);
        skipDeletedPredecessors(q10);
        if ((isFirst | isLast) && activePred.next == q10 && q10.prev == activePred) {
            if (isFirst) {
                if (activePred.prev != null) {
                    return;
                }
            } else if (activePred.item == null) {
                return;
            }
            if (isLast) {
                if (q10.next != null) {
                    return;
                }
            } else if (q10.item == null) {
                return;
            }
            updateHead();
            updateTail();
            (void) PREV.setRelease(x10, isFirst ? prevTerminator() : x10);
            (void) NEXT.setRelease(x10, isLast ? nextTerminator() : x10);
        }
    }

    private void unlinkFirst(Node<E> first, Node<E> next) {
        Node<E> q10;
        Node<E> o10 = null;
        Node<E> p10 = next;
        while (p10.item == null && (q10 = p10.next) != null) {
            if (p10 == q10) {
                return;
            }
            o10 = p10;
            p10 = q10;
        }
        if (o10 != null && p10.prev != p10) {
            VarHandle varHandle = NEXT;
            if ((boolean) varHandle.compareAndSet(first, next, p10)) {
                skipDeletedPredecessors(p10);
                if (first.prev == null) {
                    if ((p10.next == null || p10.item != null) && p10.prev == first) {
                        updateHead();
                        updateTail();
                        (void) varHandle.setRelease(o10, o10);
                        (void) PREV.setRelease(o10, prevTerminator());
                    }
                }
            }
        }
    }

    private void unlinkLast(Node<E> last, Node<E> prev) {
        Node<E> q10;
        Node<E> o10 = null;
        Node<E> p10 = prev;
        while (p10.item == null && (q10 = p10.prev) != null) {
            if (p10 == q10) {
                return;
            }
            o10 = p10;
            p10 = q10;
        }
        if (o10 != null && p10.next != p10) {
            VarHandle varHandle = PREV;
            if ((boolean) varHandle.compareAndSet(last, prev, p10)) {
                skipDeletedSuccessors(p10);
                if (last.next == null) {
                    if ((p10.prev == null || p10.item != null) && p10.next == last) {
                        updateHead();
                        updateTail();
                        (void) varHandle.setRelease(o10, o10);
                        (void) NEXT.setRelease(o10, nextTerminator());
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        if ((boolean) java.util.concurrent.ConcurrentLinkedDeque.HEAD.compareAndSet(r4, r0, r2) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateHead() {
        /*
            r4 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r4.head
            r1 = r0
            E r0 = r0.item
            if (r0 != 0) goto L2a
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r1.prev
            r2 = r0
            if (r0 == 0) goto L2a
        Ld:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r2.prev
            r3 = r0
            if (r0 == 0) goto L20
            r2 = r3
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r3.prev
            r3 = r0
            if (r0 != 0) goto L19
            goto L20
        L19:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r4.head
            if (r1 == r0) goto L1e
            goto L1
        L1e:
            r2 = r3
            goto Ld
        L20:
            java.lang.invoke.VarHandle r0 = java.util.concurrent.ConcurrentLinkedDeque.HEAD
            boolean r0 = (boolean) r0.compareAndSet(r4, r1, r2)
            if (r0 == 0) goto L1
            return
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.updateHead():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        if ((boolean) java.util.concurrent.ConcurrentLinkedDeque.TAIL.compareAndSet(r4, r0, r2) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateTail() {
        /*
            r4 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r4.tail
            r1 = r0
            E r0 = r0.item
            if (r0 != 0) goto L2a
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r1.next
            r2 = r0
            if (r0 == 0) goto L2a
        Ld:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r2.next
            r3 = r0
            if (r0 == 0) goto L20
            r2 = r3
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r3.next
            r3 = r0
            if (r0 != 0) goto L19
            goto L20
        L19:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r4.tail
            if (r1 == r0) goto L1e
            goto L1
        L1e:
            r2 = r3
            goto Ld
        L20:
            java.lang.invoke.VarHandle r0 = java.util.concurrent.ConcurrentLinkedDeque.TAIL
            boolean r0 = (boolean) r0.compareAndSet(r4, r1, r2)
            if (r0 == 0) goto L1
            return
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.updateTail():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x000f, code lost:
    
        if (r1.next == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0012, code lost:
    
        if (r0 == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x001b, code lost:
    
        if ((boolean) java.util.concurrent.ConcurrentLinkedDeque.PREV.compareAndSet(r5, r0, r1) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x001d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipDeletedPredecessors(java.util.concurrent.ConcurrentLinkedDeque.Node<E> r5) {
        /*
            r4 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r5.prev
            r1 = r0
        L4:
            E r2 = r1.item
            if (r2 == 0) goto L9
            goto L12
        L9:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r1.prev
            if (r2 != 0) goto L1e
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r3 = r1.next
            if (r3 != r1) goto L12
            goto L21
        L12:
            if (r0 == r1) goto L1d
            java.lang.invoke.VarHandle r2 = java.util.concurrent.ConcurrentLinkedDeque.PREV
            boolean r2 = (boolean) r2.compareAndSet(r5, r0, r1)
            if (r2 == 0) goto L21
        L1d:
            return
        L1e:
            if (r1 != r2) goto L2a
        L21:
            E r0 = r5.item
            if (r0 != 0) goto L1
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r5.next
            if (r0 == 0) goto L1
            return
        L2a:
            r1 = r2
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.skipDeletedPredecessors(java.util.concurrent.ConcurrentLinkedDeque$Node):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x000f, code lost:
    
        if (r1.prev == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0012, code lost:
    
        if (r0 == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x001b, code lost:
    
        if ((boolean) java.util.concurrent.ConcurrentLinkedDeque.NEXT.compareAndSet(r5, r0, r1) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x001d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipDeletedSuccessors(java.util.concurrent.ConcurrentLinkedDeque.Node<E> r5) {
        /*
            r4 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r5.next
            r1 = r0
        L4:
            E r2 = r1.item
            if (r2 == 0) goto L9
            goto L12
        L9:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r1.next
            if (r2 != 0) goto L1e
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r3 = r1.prev
            if (r3 != r1) goto L12
            goto L21
        L12:
            if (r0 == r1) goto L1d
            java.lang.invoke.VarHandle r2 = java.util.concurrent.ConcurrentLinkedDeque.NEXT
            boolean r2 = (boolean) r2.compareAndSet(r5, r0, r1)
            if (r2 == 0) goto L21
        L1d:
            return
        L1e:
            if (r1 != r2) goto L2a
        L21:
            E r0 = r5.item
            if (r0 != 0) goto L1
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r5.prev
            if (r0 == 0) goto L1
            return
        L2a:
            r1 = r2
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.skipDeletedSuccessors(java.util.concurrent.ConcurrentLinkedDeque$Node):void");
    }

    final Node<E> succ(Node<E> p10) {
        Node<E> p11 = p10.next;
        return p10 == p11 ? first() : p11;
    }

    final Node<E> pred(Node<E> p10) {
        Node<E> p11 = p10.prev;
        return p10 == p11 ? last() : p11;
    }

    Node<E> first() {
        Node<E> h10;
        Node<E> p10;
        do {
            h10 = this.head;
            p10 = h10;
            while (true) {
                Node<E> q10 = p10.prev;
                if (q10 == null) {
                    break;
                }
                p10 = q10;
                Node<E> q11 = q10.prev;
                if (q11 == null) {
                    break;
                }
                Node<E> h11 = this.head;
                p10 = h10 != h11 ? h11 : q11;
                h10 = h11;
            }
            if (p10 == h10) {
                break;
            }
        } while (!(boolean) HEAD.compareAndSet(this, h10, p10));
        return p10;
    }

    Node<E> last() {
        Node<E> t2;
        Node<E> p10;
        do {
            t2 = this.tail;
            p10 = t2;
            while (true) {
                Node<E> q10 = p10.next;
                if (q10 == null) {
                    break;
                }
                p10 = q10;
                Node<E> q11 = q10.next;
                if (q11 == null) {
                    break;
                }
                Node<E> t10 = this.tail;
                p10 = t2 != t10 ? t10 : q11;
                t2 = t10;
            }
            if (p10 == t2) {
                break;
            }
        } while (!(boolean) TAIL.compareAndSet(this, t2, p10));
        return p10;
    }

    private E screenNullResult(E v2) {
        if (v2 == null) {
            throw new NoSuchElementException();
        }
        return v2;
    }

    public ConcurrentLinkedDeque() {
        Node<E> node = new Node<>();
        this.tail = node;
        this.head = node;
    }

    public ConcurrentLinkedDeque(Collection<? extends E> c4) {
        Node<E> h10 = null;
        Node<E> t2 = null;
        for (E e2 : c4) {
            Node<E> newNode = newNode(Objects.requireNonNull(e2));
            if (h10 == null) {
                t2 = newNode;
                h10 = newNode;
            } else {
                (void) NEXT.set(t2, newNode);
                (void) PREV.set(newNode, t2);
                t2 = newNode;
            }
        }
        initHeadTail(h10, t2);
    }

    private void initHeadTail(Node<E> h10, Node<E> t2) {
        if (h10 == t2) {
            if (h10 == null) {
                Node<E> node = new Node<>();
                t2 = node;
                h10 = node;
            } else {
                Node<E> newNode = new Node<>();
                (void) NEXT.set(t2, newNode);
                (void) PREV.set(newNode, t2);
                t2 = newNode;
            }
        }
        this.head = h10;
        this.tail = t2;
    }

    @Override // java.util.Deque
    public void addFirst(E e2) {
        linkFirst(e2);
    }

    @Override // java.util.Deque
    public void addLast(E e2) {
        linkLast(e2);
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e2) {
        linkFirst(e2);
        return true;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e2) {
        linkLast(e2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r0.prev == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0001, code lost:
    
        continue;
     */
    @Override // java.util.Deque
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E peekFirst() {
        /*
            r5 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node r0 = r5.first()
            r1 = r0
        L6:
            E r2 = r1.item
            r3 = r2
            if (r2 != 0) goto L17
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r1.next
            r4 = r2
            if (r1 != r2) goto L11
            goto L1
        L11:
            if (r4 != 0) goto L15
            r1 = r4
            goto L17
        L15:
            r1 = r4
            goto L6
        L17:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r0.prev
            if (r2 == 0) goto L1c
            goto L1
        L1c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.peekFirst():java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r0.next == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0001, code lost:
    
        continue;
     */
    @Override // java.util.Deque
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E peekLast() {
        /*
            r5 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node r0 = r5.last()
            r1 = r0
        L6:
            E r2 = r1.item
            r3 = r2
            if (r2 != 0) goto L17
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r1.prev
            r4 = r2
            if (r1 != r2) goto L11
            goto L1
        L11:
            if (r4 != 0) goto L15
            r1 = r4
            goto L17
        L15:
            r1 = r4
            goto L6
        L17:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r0.next
            if (r2 == 0) goto L1c
            goto L1
        L1c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.peekLast():java.lang.Object");
    }

    @Override // java.util.Deque
    public E getFirst() {
        return screenNullResult(peekFirst());
    }

    @Override // java.util.Deque
    public E getLast() {
        return screenNullResult(peekLast());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0001, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0001, code lost:
    
        continue;
     */
    @Override // java.util.Deque
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E pollFirst() {
        /*
            r6 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node r0 = r6.first()
            r1 = r0
        L6:
            E r2 = r1.item
            r3 = r2
            r4 = 0
            if (r2 == 0) goto L1e
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r0.prev
            if (r2 == 0) goto L11
            goto L1
        L11:
            java.lang.invoke.VarHandle r2 = java.util.concurrent.ConcurrentLinkedDeque.ITEM
            boolean r2 = (boolean) r2.compareAndSet(r1, r3, r4)
            if (r2 == 0) goto L1e
            r6.unlink(r1)
            return r3
        L1e:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r1.next
            r5 = r2
            if (r1 != r2) goto L24
            goto L1
        L24:
            if (r5 != 0) goto L2c
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r1 = r0.prev
            if (r1 == 0) goto L2b
            goto L1
        L2b:
            return r4
        L2c:
            r1 = r5
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.pollFirst():java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0001, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0001, code lost:
    
        continue;
     */
    @Override // java.util.Deque
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E pollLast() {
        /*
            r6 = this;
        L1:
            java.util.concurrent.ConcurrentLinkedDeque$Node r0 = r6.last()
            r1 = r0
        L6:
            E r2 = r1.item
            r3 = r2
            r4 = 0
            if (r2 == 0) goto L1e
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r0.next
            if (r2 == 0) goto L11
            goto L1
        L11:
            java.lang.invoke.VarHandle r2 = java.util.concurrent.ConcurrentLinkedDeque.ITEM
            boolean r2 = (boolean) r2.compareAndSet(r1, r3, r4)
            if (r2 == 0) goto L1e
            r6.unlink(r1)
            return r3
        L1e:
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r2 = r1.prev
            r5 = r2
            if (r1 != r2) goto L24
            goto L1
        L24:
            if (r5 != 0) goto L2c
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r1 = r0.next
            if (r1 == 0) goto L2b
            goto L1
        L2b:
            return r4
        L2c:
            r1 = r5
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.pollLast():java.lang.Object");
    }

    @Override // java.util.Deque
    public E removeFirst() {
        return screenNullResult(pollFirst());
    }

    @Override // java.util.Deque
    public E removeLast() {
        return screenNullResult(pollLast());
    }

    @Override // java.util.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        return offerLast(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return offerLast(e2);
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // java.util.Deque
    public void push(E e2) {
        addFirst(e2);
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object o10) {
        Objects.requireNonNull(o10);
        Node<E> p10 = first();
        while (p10 != null) {
            E item = p10.item;
            if (item == null || !o10.equals(item) || !(boolean) ITEM.compareAndSet(p10, item, null)) {
                p10 = succ(p10);
            } else {
                unlink(p10);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object o10) {
        Objects.requireNonNull(o10);
        Node<E> p10 = last();
        while (p10 != null) {
            E item = p10.item;
            if (item == null || !o10.equals(item) || !(boolean) ITEM.compareAndSet(p10, item, null)) {
                p10 = pred(p10);
            } else {
                unlink(p10);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 != null) {
            Node<E> p10 = first();
            while (p10 != null) {
                E item = p10.item;
                if (item == null || !o10.equals(item)) {
                    p10 = succ(p10);
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return peekFirst() == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        int count;
        loop0: while (true) {
            count = 0;
            Node<E> p10 = first();
            while (p10 != null && (p10.item == null || (count = count + 1) != Integer.MAX_VALUE)) {
                Node<E> p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        return count;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return removeFirstOccurrence(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        Node<E> t2;
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        Node<E> beginningOfTheEnd = null;
        Node<E> last = null;
        for (E e2 : c4) {
            Node<E> newNode = newNode(Objects.requireNonNull(e2));
            if (beginningOfTheEnd == null) {
                last = newNode;
                beginningOfTheEnd = newNode;
            } else {
                (void) NEXT.set(last, newNode);
                (void) PREV.set(newNode, last);
                last = newNode;
            }
        }
        if (beginningOfTheEnd == null) {
            return false;
        }
        loop1: while (true) {
            t2 = this.tail;
            Node<E> p10 = t2;
            while (true) {
                Node<E> q10 = p10.next;
                if (q10 != null) {
                    p10 = q10;
                    Node<E> q11 = q10.next;
                    if (q11 != null) {
                        Node<E> t10 = this.tail;
                        p10 = t2 != t10 ? t10 : q11;
                        t2 = t10;
                    }
                }
                if (p10.prev == p10) {
                    break;
                }
                (void) PREV.set(beginningOfTheEnd, p10);
                if ((boolean) NEXT.compareAndSet(p10, null, beginningOfTheEnd)) {
                    break loop1;
                }
            }
        }
        VarHandle varHandle = TAIL;
        if (!(boolean) varHandle.weakCompareAndSet(this, t2, last)) {
            Node<E> t11 = this.tail;
            if (last.next == null) {
                (boolean) varHandle.weakCompareAndSet(this, t11, last);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        do {
        } while (pollFirst() != null);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        int charLength;
        int size;
        String[] a10 = null;
        loop0: while (true) {
            charLength = 0;
            size = 0;
            Node<E> p10 = first();
            while (p10 != null) {
                E item = p10.item;
                if (item != null) {
                    if (a10 == null) {
                        a10 = new String[4];
                    } else if (size == a10.length) {
                        a10 = (String[]) Arrays.copyOf(a10, size * 2);
                    }
                    String s2 = item.toString();
                    a10[size] = s2;
                    charLength += s2.length();
                    size++;
                }
                Node<E> p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        if (size == 0) {
            return "[]";
        }
        return Helpers.toString(a10, size, charLength);
    }

    private Object[] toArrayInternal(Object[] a10) {
        int size;
        Object[] x10 = a10;
        loop0: while (true) {
            size = 0;
            Node<E> p10 = first();
            while (p10 != null) {
                E item = p10.item;
                if (item != null) {
                    if (x10 == null) {
                        x10 = new Object[4];
                    } else if (size == x10.length) {
                        x10 = Arrays.copyOf(x10, (size + 4) * 2);
                    }
                    x10[size] = item;
                    size++;
                }
                Node<E> p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        if (x10 == null) {
            return new Object[0];
        }
        if (a10 == null || size > a10.length) {
            return size == x10.length ? x10 : Arrays.copyOf(x10, size);
        }
        if (a10 != x10) {
            System.arraycopy(x10, 0, a10, 0, size);
        }
        if (size < a10.length) {
            a10[size] = null;
        }
        return a10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArrayInternal(null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr == null) {
            throw new NullPointerException();
        }
        return (T[]) toArrayInternal(tArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        private E nextItem;
        private Node<E> nextNode;

        abstract Node<E> nextNode(Node<E> node);

        abstract Node<E> startNode();

        AbstractItr() {
            advance();
        }

        private void advance() {
            Node<E> node = this.nextNode;
            this.lastRet = node;
            Node<E> p10 = node == null ? startNode() : nextNode(node);
            while (p10 != null) {
                E item = p10.item;
                if (item == null) {
                    p10 = nextNode(p10);
                } else {
                    this.nextNode = p10;
                    this.nextItem = item;
                    return;
                }
            }
            this.nextNode = null;
            this.nextItem = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextItem != null;
        }

        @Override // java.util.Iterator
        public E next() {
            E item = this.nextItem;
            if (item == null) {
                throw new NoSuchElementException();
            }
            advance();
            return item;
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<E> l10 = this.lastRet;
            if (l10 == null) {
                throw new IllegalStateException();
            }
            l10.item = null;
            ConcurrentLinkedDeque.this.unlink(l10);
            this.lastRet = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Itr extends ConcurrentLinkedDeque<E>.AbstractItr {
        Itr() {
            super();
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> startNode() {
            return ConcurrentLinkedDeque.this.first();
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> nextNode(Node<E> p10) {
            return ConcurrentLinkedDeque.this.succ(p10);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class DescendingItr extends ConcurrentLinkedDeque<E>.AbstractItr {
        DescendingItr() {
            super();
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> startNode() {
            return ConcurrentLinkedDeque.this.last();
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> nextNode(Node<E> p10) {
            return ConcurrentLinkedDeque.this.pred(p10);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class CLDSpliterator implements Spliterator<E> {
        static final int MAX_BATCH = 33554432;
        int batch;
        Node<E> current;
        boolean exhausted;

        CLDSpliterator() {
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            Node<E> current = current();
            Node<E> p10 = current;
            if (current != null) {
                Node<E> node = p10.next;
                Node<E> q10 = node;
                if (node != null) {
                    int i10 = 0;
                    int n10 = Math.min(this.batch + 1, 33554432);
                    this.batch = n10;
                    Object[] a10 = null;
                    do {
                        E e2 = p10.item;
                        if (e2 != null) {
                            if (a10 == null) {
                                a10 = new Object[n10];
                            }
                            a10[i10] = e2;
                            i10++;
                        }
                        Node<E> p11 = q10;
                        if (p10 != q10) {
                            p10 = p11;
                        } else {
                            p10 = ConcurrentLinkedDeque.this.first();
                        }
                        if (p10 == null) {
                            break;
                        }
                        Node<E> node2 = p10.next;
                        q10 = node2;
                        if (node2 == null) {
                            break;
                        }
                    } while (i10 < n10);
                    setCurrent(p10);
                    if (i10 == 0) {
                        return null;
                    }
                    return Spliterators.spliterator(a10, 0, i10, 4368);
                }
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            Node<E> current = current();
            Node<E> node = current;
            if (current != null) {
                this.current = null;
                this.exhausted = true;
                do {
                    E e2 = node.item;
                    if (e2 != null) {
                        consumer.accept(e2);
                    }
                    Node<E> node2 = node.next;
                    if (node != node2) {
                        node = node2;
                    } else {
                        node = ConcurrentLinkedDeque.this.first();
                    }
                } while (node != null);
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            E e2;
            Objects.requireNonNull(consumer);
            Node<E> current = current();
            Node<E> node = current;
            if (current == null) {
                return false;
            }
            do {
                e2 = node.item;
                Node<E> node2 = node.next;
                if (node != node2) {
                    node = node2;
                } else {
                    node = ConcurrentLinkedDeque.this.first();
                }
                if (e2 != null) {
                    break;
                }
            } while (node != null);
            setCurrent(node);
            if (e2 != null) {
                consumer.accept(e2);
                return true;
            }
            return false;
        }

        private void setCurrent(Node<E> p10) {
            this.current = p10;
            if (p10 == null) {
                this.exhausted = true;
            }
        }

        private Node<E> current() {
            Node<E> p10 = this.current;
            if (p10 != null || this.exhausted) {
                return p10;
            }
            Node<E> p11 = ConcurrentLinkedDeque.this.first();
            setCurrent(p11);
            return p11;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return Long.MAX_VALUE;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new CLDSpliterator();
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        Node<E> p10 = first();
        while (p10 != null) {
            E item = p10.item;
            if (item != null) {
                s2.writeObject(item);
            }
            p10 = succ(p10);
        }
        s2.writeObject(null);
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        Node<E> h10 = null;
        Node<E> t2 = null;
        while (true) {
            Object item = s2.readObject();
            if (item != null) {
                Node<E> newNode = newNode(item);
                if (h10 == null) {
                    t2 = newNode;
                    h10 = newNode;
                } else {
                    (void) NEXT.set(t2, newNode);
                    (void) PREV.set(newNode, t2);
                    t2 = newNode;
                }
            } else {
                initHeadTail(h10, t2);
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.ConcurrentLinkedDeque$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = Collection.this.contains(obj);
                return contains;
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.ConcurrentLinkedDeque$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ConcurrentLinkedDeque.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    private boolean bulkRemove(Predicate<? super E> filter) {
        boolean removed = false;
        Node<E> p10 = first();
        while (p10 != null) {
            Node<E> succ = succ(p10);
            Object obj = p10.item;
            if (obj != null && filter.test(obj) && (boolean) ITEM.compareAndSet(p10, obj, null)) {
                unlink(p10);
                removed = true;
            }
            p10 = succ;
        }
        return removed;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        Node<E> first = first();
        while (first != null) {
            E e2 = first.item;
            if (e2 != null) {
                consumer.accept(e2);
            }
            first = succ(first);
        }
    }

    static {
        Node<E> node = new Node<>();
        PREV_TERMINATOR = node;
        node.next = node;
        Node<E> node2 = new Node<>();
        NEXT_TERMINATOR = node2;
        node2.prev = node2;
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            HEAD = l10.findVarHandle(ConcurrentLinkedDeque.class, "head", Node.class);
            TAIL = l10.findVarHandle(ConcurrentLinkedDeque.class, "tail", Node.class);
            PREV = l10.findVarHandle(Node.class, "prev", Node.class);
            NEXT = l10.findVarHandle(Node.class, "next", Node.class);
            ITEM = l10.findVarHandle(Node.class, ImsConfig.EXTRA_CHANGED_ITEM, Object.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
