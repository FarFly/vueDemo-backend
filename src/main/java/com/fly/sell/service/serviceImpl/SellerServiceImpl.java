package com.fly.sell.service.serviceImpl;

import com.fly.sell.dao.SellerInfoMapper;
import com.fly.sell.dao.SellerMasterMapper;
import com.fly.sell.dao.SellerSupportsMapper;
import com.fly.sell.entity.SellerInfo;
import com.fly.sell.entity.SellerMaster;
import com.fly.sell.entity.SellerSupports;
import com.fly.sell.service.SellerService;
import com.fly.sell.vo.SellerSupportsVO;
import com.fly.sell.vo.SellerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMasterMapper sellerMasterMapper;
    @Autowired
    private SellerInfoMapper sellerInfoMapper;
    @Autowired
    private SellerSupportsMapper sellerSupportsMapper;

    @Override
    public SellerVO querySeller(int sellerId){
        SellerMaster sellerMaster = sellerMasterMapper.selectByPrimaryKey(sellerId);
        List<SellerInfo> sellerInfoList = sellerInfoMapper.selectBySellId(sellerId);
        List<SellerSupports> sellerSupportList = sellerSupportsMapper.selectBySellId(sellerId);

        SellerVO sellerVO = new SellerVO();
        BeanUtils.copyProperties(sellerMaster, sellerVO);

        List<SellerSupportsVO> sellerSupportsVOs = new ArrayList<>();
        for (SellerSupports sellerSupports : sellerSupportList){
            SellerSupportsVO sellerSupportsVO = new SellerSupportsVO();
            BeanUtils.copyProperties(sellerSupports, sellerSupportsVO);
            sellerSupportsVOs.add(sellerSupportsVO);
        }
        sellerVO.setSupports(sellerSupportsVOs);

        List<String> infos = sellerInfoList.stream().map(SellerInfo::getInfo).collect(Collectors.toList());
        sellerVO.setInfos(infos);

        return sellerVO;
    }

    @Override
    public SellerMaster login(String username, String password) {
        return sellerMasterMapper.login(username, password);
    }


}
