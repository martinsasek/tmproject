package cz.mojespolecnost.tmproject.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import cz.mojespolecnost.tmproject.rest.UserRestService;

public class UserApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public UserApplication() {
		singletons.add(new UserRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
