package kr.pe.tippingpoint.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.pe.tippingpoint.service.TpFunderAccountAccessServiceImpl;
import kr.pe.tippingpoint.vo.TpFunder;

@Controller
@RequestMapping("/pay/")
public class tpPaymentController {
	
	@Autowired
	private TpFunderAccountAccessServiceImpl TpFunderAccService;

	@RequestMapping("payRequest.tp")
	public String payRequest(@RequestParam String tppPayType, @RequestParam String tppTitle, @RequestParam int tpAmount, HttpSession session, ModelMap model){
		// TODO: 세션 처리되는 페이지 통합시 테스트 코드 삭제		
		session.setAttribute("userLoginInfo", "1");

		
		String tppId = (String)session.getAttribute("userLoginInfo");
				
		// 세션 사용자ID 체크
		// FIXME: 인터셉터로 세션 ID 존재 유무 체크로 수정하기 & 이전에 보고 있던 페이지로 되돌아가도록 처리하기
		if(tppId.trim().length() < 1){
			return "redirct:/tpProjectBoard.tp";
		}
		
		// user정보 가져오기
		TpFunder tpFunder = TpFunderAccService.findTpFunderById(tppId);
		
		
		// Start: 주문 번호 생성
		SimpleDateFormat sf = new SimpleDateFormat("MMddHHmmss");
		Date current = new Date();
		String strCurrent = sf.format(current);

		String strUuid = UUID.randomUUID().toString();
		strUuid = strUuid.replace("-", "") ;


		String strOrderUId = tppId + "_" + strCurrent + strUuid;
		// End: 주문 번호 생성
		
		// 타임스탬프
		sf = new SimpleDateFormat("yyyyMMddHHmmss");
		strCurrent = sf.format(current);
		
		
		
		
		String strView = "/WEB-INF/view/body/tpPayment/";
		if(tppPayType == "p"){ // 현금 계좌이체
			strView += "payAccountReq.jsp";
		} else { // card
			strView += "payCardReq.jsp";
		}
		
		
		// TODO: 테스트 후 삭제
		System.out.println("tppPayType: " + tppPayType + " / tppId: " + tppId + " / tpAmount: " + tpAmount + " / strView: " + strView);
		
		
		model.addAttribute("tppId", tppId);
		model.addAttribute("tppTitle", tppTitle);
		
		model.addAttribute("tppPayType", tppPayType);
		model.addAttribute("tpAmount", tpAmount);
		model.addAttribute("strOrderUId", strOrderUId);
		model.addAttribute("tpfEmail", tpFunder.getTpfEmail());
		model.addAttribute("LGD_TIMESTAMP", strCurrent);
		
		
		return strView;
	}
}
