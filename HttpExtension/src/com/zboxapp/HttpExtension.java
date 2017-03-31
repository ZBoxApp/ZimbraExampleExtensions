package com.zboxapp;

import com.zimbra.cs.extension.ZimbraExtension;
import com.zimbra.cs.extension.ExtensionDispatcherServlet;
import com.zimbra.common.service.ServiceException;

public class HttpExtension implements ZimbraExtension {

	// Register the Extension and run all the 
	// initilization process that we need to do
	// when the server starts
	public void init() throws ServiceException {
		ExtensionDispatcherServlet.register(this, new HttpExtensionHandler());
	}

  // All the cleaning operations to do when the server
  // is stopped
	public void destroy() {
		ExtensionDispatcherServlet.unregister(this);
	}
  
  // The extension name
  public String getName() {
    return "HttpExtension";
  }
}