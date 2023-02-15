package Presenter;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import IObserver.IObserver;
import IObserver.ISubject;
import Persistence.Files;
import model.HealthSystem;
public class Presenter implements ISubject{

	private ServerSocket server;
	private Socket client;
	private int port = 1234;	
	private HealthSystem manager;
	private ArrayList<IObserver> observers;
	//private int port = 23143;

	public Presenter() throws IOException {
		server = new ServerSocket(port);
		manager = new HealthSystem(Files.readFilesAdministrator(), Files.readFilesHealthPostWithPatient(),
				Files.readFilesCity());
		observers = new ArrayList<IObserver>();
		accept();
	}
	
	
	public void accept() {
		try {
			while (true) {
				client = server.accept();
				HealthSystemThread observer = new HealthSystemThread(client,manager,this);	
				attach(observer);
				observer.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void attach(IObserver o) {
		observers.add(o);
	}

	@Override
	public void detach(IObserver o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for (IObserver iObserver : observers) {
			iObserver.update();
		}
		
	}
	

	public static void main(String[] args) {
		try {
			new Presenter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


	

}
