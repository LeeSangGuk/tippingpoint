package kr.pe.tippingpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.tippingpoint.dao.TpProjectDao;
import kr.pe.tippingpoint.util.PagingBean;
import kr.pe.tippingpoint.vo.TpProject;

@Service
public class TpProjectServiceImpl implements TpProjectService {

	@Autowired
	private TpProjectDao dao;
	
	@Override
	public Map allListTpProject(int pageNo) {
			HashMap map = new HashMap();
			List<TpProject> list = dao.selectAllTpProject(pageNo);
			PagingBean pagingBean = new PagingBean(dao.selectCountProject(), pageNo);
			map.put("list", list); //목록에 뿌려질 고객들 정보
			map.put("pagingBean", pagingBean); //페이징 처리위한 pagingBean
		return map;
	}

	@Override
	public TpProject findTpProjectById(String tppId) {
		return dao.selectTpProjectById(tppId);
	}

	@Override
	public List<TpProject> findToProjectByCategory(String tppCategory) {
		return null;
	}

	@Override
	public void registerTpProject(TpProject tpvo) {
		dao.insertTpProject(tpvo);
	}

	
	
}
