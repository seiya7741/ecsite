package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO dao = new LoginDAO();
	private LoginDTO dto = new LoginDTO();
	private BuyItemDAO bidao = new BuyItemDAO();
	public String execute(){
		String result = ERROR;
		dto = dao.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", dto);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO bidto = bidao.getBuyItemInfo();

			session.put("login_user_id", dto.getLoginId());
			session.put("id", bidto.getId());
			session.put("buyItem_name", bidto.getItemName());
			session.put("buyItem_price", bidto.getItemPrice());

			return result;
		}
		return result;

	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
