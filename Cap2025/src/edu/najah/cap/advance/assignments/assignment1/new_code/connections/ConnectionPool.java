package edu.najah.cap.advance.assignments.assignment1.new_code.connections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final int MAX_CONNECTIONS = 10;
    private final BlockingQueue<Connection> pool;

    public ConnectionPool() {
        this.pool = new ArrayBlockingQueue<>(MAX_CONNECTIONS);
        // نجهز 10 connections مرة واحدة
        for (int i = 1; i <= MAX_CONNECTIONS; i++) {
            pool.add(new Connection("Conn-" + i));
        }
    }

    public Connection acquire() {
        try {
            Connection conn = pool.take();
            System.out.println("[ConnectionPool] Acquired " + conn.getId());
            return conn;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while acquiring connection from pool", e);
        }
    }

    public void release(Connection conn) {
        if (conn == null) return;
        try {
            pool.put(conn);
            System.out.println("[ConnectionPool] Released " + conn.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
