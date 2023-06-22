package org.comstudy.myweb;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	void execute(HttpServletRequest req);

}