package com.zboxapp;

import com.zimbra.cs.extension.ZimbraExtension;
import com.zimbra.cs.extension.ExtensionHttpHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletException;
import java.io.IOException;
import com.zimbra.common.service.ServiceException;

public class HttpExtensionHandler extends ExtensionHttpHandler {
  
  // Register the path were we expect request
  // it will be: /service/extension/HttpExtension/http
  public String getPath() {
	 return super.getPath() + "/http";
  }

  // Process GET requests
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    ServletOutputStream os = resp.getOutputStream();
    os.print("It Works!!!!\n");
  }
  
  public void init (ZimbraExtension ext) throws ServiceException {
    super.init(ext);
  }
  
 } 