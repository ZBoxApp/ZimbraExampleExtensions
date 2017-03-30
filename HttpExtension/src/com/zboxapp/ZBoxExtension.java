package com.zboxapp;

import com.zimbra.cs.extension.ZimbraExtension;
import com.zimbra.cs.extension.ExtensionDispatcherServlet;
import com.zimbra.common.service.ServiceException;

public class ZBoxExtension implements ZimbraExtension {

 public void init() throws ServiceException {
	ExtensionDispatcherServlet.register(this, new ZBoxExtensionHandler());
 }

  public void destroy() {
    ExtensionDispatcherServlet.unregister(this);
  }
  
  public String getName() {
    return "ZBoxExtension";
  }
}