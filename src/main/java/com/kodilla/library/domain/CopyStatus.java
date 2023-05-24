package com.kodilla.library.domain;

public enum CopyStatus {
    AVAILABLE("available"), LOST("lost"), LENT("lent"), DESTROYED("destroyed");
    private String status;

    CopyStatus(String status) {
        this.status = status;
    }
}
