package com.threadcontrol.example;

public interface IController {
	public void release() throws InterruptedException;
	public void acquire() throws InterruptedException;
}
