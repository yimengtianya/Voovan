package org.voovan.test.network.aio;

import java.io.IOException;

import org.voovan.network.aio.AioServerSocket;
import org.voovan.network.filter.StringFilter;
import org.voovan.network.messagesplitter.BufferLengthSplitter;
import org.voovan.test.network.ServerHandlerTest;

public class AioServerSocketTest  {

	public static void main(String[] args) throws IOException {
		AioServerSocket serverSocket = new AioServerSocket("127.0.0.1",2031,5000);
		serverSocket.handler(new ServerHandlerTest());
		serverSocket.filterChain().add(new StringFilter());
		serverSocket.messageSplitter(new BufferLengthSplitter(4));
		serverSocket.start();
	}
}
