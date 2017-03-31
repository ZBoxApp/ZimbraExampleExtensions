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
  
  public String getPath() {
	 return super.getPath() + "/http";
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    ServletOutputStream os = resp.getOutputStream();
    os.print("It Works!!!!");
  }
  
  public void init (ZimbraExtension ext) throws ServiceException {
    super.init(ext);
  }
  
 } 