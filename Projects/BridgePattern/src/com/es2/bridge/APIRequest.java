package com.es2.bridge;

import java.util.HashMap;

public class APIRequest {
	protected HashMap<String, APIServiceInterface> services = new HashMap<>();
	private int _serviceId = 0;

	public String addService(APIServiceInterface service) {
		String serviceIdString = String.valueOf(_serviceId);

		this.services.put(serviceIdString, service);

		this._serviceId++;
		return serviceIdString;
	}

	public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
		APIServiceInterface service = this.services.get(serviceId);
		if (service == null) {
			throw new ServiceNotFoundException();
		}

		return service.getContent(contentId);
	}

	public String setContent(String serviceId, String content) throws ServiceNotFoundException {
		APIServiceInterface service = this.services.get(serviceId);
		if (service == null) {
			throw new ServiceNotFoundException();
		}

		return service.setContent(content);
	}
}
