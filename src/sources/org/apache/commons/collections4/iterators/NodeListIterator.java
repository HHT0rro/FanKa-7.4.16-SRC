package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NodeListIterator implements Iterator<Node> {
    private int index = 0;
    private final NodeList nodeList;

    public NodeListIterator(Node node) {
        Objects.requireNonNull(node, "Node must not be null.");
        this.nodeList = node.getChildNodes();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        NodeList nodeList = this.nodeList;
        return nodeList != null && this.index < nodeList.getLength();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
    }

    @Override // java.util.Iterator
    public Node next() {
        NodeList nodeList = this.nodeList;
        if (nodeList != null && this.index < nodeList.getLength()) {
            NodeList nodeList2 = this.nodeList;
            int i10 = this.index;
            this.index = i10 + 1;
            return nodeList2.item(i10);
        }
        throw new NoSuchElementException("underlying nodeList has no more elements");
    }

    public NodeListIterator(NodeList nodeList) {
        Objects.requireNonNull(nodeList, "NodeList must not be null.");
        this.nodeList = nodeList;
    }
}
