package com.factory.reportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class ReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportServiceApplication.class, args);

		// blocking main thread
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
	}

}
