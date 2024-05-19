package com.factory.reportservice.controller;

public interface Controller<T> {
    void visit(T param);
}
