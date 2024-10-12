package model;

import security.SecurityManager;

public class ServiceLocator {
	
	private static final RegistryDataAcces registryDataAcces = new RegistryDataAcces();
	private static final SecurityManager  securityManager = new SecurityManager(); 

	public static RegistryDataAcces getRegistry() {
		return registryDataAcces;
	}
	
	public static SecurityManager getSecurity() {
		return securityManager;
	}
	
}
