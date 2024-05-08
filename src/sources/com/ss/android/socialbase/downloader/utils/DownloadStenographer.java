package com.ss.android.socialbase.downloader.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadStenographer {
    private static final int MAX_NODE_COUNT = 20;
    private static final int SECONDS_TO_MILLS = 1000;
    private int count;
    private Node head;
    private int maxCount;
    private Node tail;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Node {
        public long curBytes;
        public Node next;
        public Node prev;
        public long when;

        private Node() {
        }
    }

    public DownloadStenographer() {
        this.maxCount = 10;
    }

    private Node findFirstNodeNearWhen(long j10) {
        Node node = this.head;
        Node node2 = null;
        while (node != null && node.when > j10) {
            node2 = node;
            node = node.next;
        }
        return (node == null || node2 == null || node == node2 || j10 - node.when >= node2.when - j10) ? node2 : node;
    }

    private Node obtainNode() {
        Node node;
        int i10 = this.count;
        if (i10 >= this.maxCount && (node = this.tail) != null) {
            Node node2 = node.prev;
            node.prev = null;
            this.tail = node2;
            if (node2 != null) {
                node2.next = null;
            }
            return node;
        }
        this.count = i10 + 1;
        return new Node();
    }

    public long getRecentDownloadSpeed(long j10, long j11) {
        synchronized (this) {
            Node node = this.head;
            if (node == null) {
                return -1L;
            }
            Node findFirstNodeNearWhen = findFirstNodeNearWhen(j10);
            if (findFirstNodeNearWhen == null) {
                return -1L;
            }
            long j12 = node.curBytes - findFirstNodeNearWhen.curBytes;
            long j13 = j11 - findFirstNodeNearWhen.when;
            if (j12 < 0 || j13 <= 0) {
                return -1L;
            }
            return j12 / j13;
        }
    }

    public boolean markProgress(long j10, long j11) {
        synchronized (this) {
            Node node = this.head;
            if (node != null) {
                if (j10 >= node.curBytes && j11 >= node.when) {
                    Node node2 = node.next;
                    if (node2 != null && j11 - node2.when < 1000) {
                        node.curBytes = j10;
                        node.when = j11;
                        return true;
                    }
                }
                return false;
            }
            Node obtainNode = obtainNode();
            obtainNode.curBytes = j10;
            obtainNode.when = j11;
            if (node != null) {
                obtainNode.next = node;
                node.prev = obtainNode;
            }
            this.head = obtainNode;
            return true;
        }
    }

    public DownloadStenographer(int i10) {
        this.maxCount = i10 > 20 ? 20 : i10;
    }
}
