package cn.ly.mlc.mg.action.home;

import javax.servlet.http.HttpServletRequest;

import cn.ly.mlc.mg.entity.request.BaseRequest;
import cn.ly.mlc.mg.entity.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.web.annotation.TopdeepMethodAttribute;
import cn.ly.mlc.mg.action.base.BaseAction;
import cn.ly.mlc.mg.entity.request.BaseRequest;
import cn.ly.mlc.mg.entity.response.BaseResponse;

@Controller
@RequestMapping(value = {
		"/h", "/home"
})
public class IndexAction extends BaseAction {

	@TopdeepMethodAttribute(loginRequired = true)
	@RequestMapping(value = "index", method = {
		RequestMethod.GET
	})
	public String execute(BaseRequest req, Model model, HttpServletRequest request) throws Exception {
		BaseResponse res = new BaseResponse();
		super.execute(req, res);
		model.addAttribute("res", res);
		return res.getTarget("/home/index-success");
	}

}
