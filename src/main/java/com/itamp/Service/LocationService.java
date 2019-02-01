package com.itamp.Service;

import java.util.List;

import com.itamp.Model.DS;
import com.itamp.Model.GN;
import com.itamp.Model.MOH;
import com.itamp.Model.PHM;
import com.itamp.Model.RDHS;

public interface LocationService {

List<RDHS> findAll();
List<DS> dsAreaInOneRdhs(String name);
List<MOH> mohAreaInOneDs(String name);
List<PHM> phmAreaInOneMoh(String name);
List<GN> gnAreaInOnePhm(String name);

}
