package com.itamp.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itamp.ExceptionHandle.LocationNotFoundException;
import com.itamp.ItampService.DSRepository;
import com.itamp.ItampService.MOHRepository;
import com.itamp.ItampService.PHMRepository;
import com.itamp.ItampService.RDHSRepository;
import com.itamp.Model.DS;
import com.itamp.Model.GN;
import com.itamp.Model.MOH;
import com.itamp.Model.PHM;
import com.itamp.Model.RDHS;
import com.itamp.Service.LocationService;
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private RDHSRepository rdhsRepository;
	@Autowired
	private DSRepository dsRepository;
	@Autowired
	private MOHRepository mohRepository;
	@Autowired
	private PHMRepository phmRepository;
	
	//all rdhs area
	@Override
	public List<RDHS> findAll() {
		return rdhsRepository.findAll();
	}
	//get all ds area in one rdhs area
	@Override
	public List<DS> dsAreaInOneRdhs(String name) {
		if(rdhsRepository.findByName(name)==null)throw new LocationNotFoundException();
		return rdhsRepository.findByName(name).getDs();
	    
	}
	//get all moh area in one ds area
	@Override
	public List<MOH> mohAreaInOneDs(String name) {
		return dsRepository.findByName(name).getMoh() ;
	}
	//get all phm area in one moh area
	@Override
	public List<PHM> phmAreaInOneMoh(String name) {
		return mohRepository.findByName(name).getPhm();
	}
	//get all gn area in one phm
	@Override
	public List<GN> gnAreaInOnePhm(String name) {
		return phmRepository.findByName(name).getGn();
	}
}
