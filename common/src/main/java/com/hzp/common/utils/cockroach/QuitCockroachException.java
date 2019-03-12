package com.hzp.common.utils.cockroach;

/**
 * @author HZP
 * @version created at 2017/4/6 16:24
 */
final class QuitCockroachException extends RuntimeException {
    public QuitCockroachException(String message) {
        super(message);
    }
}
