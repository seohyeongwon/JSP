package org.comstudy.myweb;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	void doProcess(HttpServletRequest req);
}
