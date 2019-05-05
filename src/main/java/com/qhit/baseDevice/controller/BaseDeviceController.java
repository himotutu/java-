package com.qhit.baseDevice.controller; 

import com.qhit.baseDevice.pojo.BaseDevice; 
import com.qhit.baseDevice.service.IBaseDeviceService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.utils.CommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/08
*/ 

@RestController 
@RequestMapping("/baseDevice") 
public class BaseDeviceController { 

    @Resource 
    IBaseDeviceService baseDeviceService; 

    @RequestMapping("/insert") 
    public void insert(BaseDevice baseDevice) {
        baseDeviceService.insert(baseDevice); 
    }

    @RequestMapping("/delete") 
    public void delete(Integer devid) { 
        baseDeviceService.delete(devid); 
    } 

    @RequestMapping("/update") 
    public void update(BaseDevice baseDevice) { 
        baseDeviceService.update(baseDevice); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(BaseDevice baseDevice) { 
        baseDeviceService.updateSelective(baseDevice); 
    } 

    @RequestMapping("/load") 
    public BaseDevice load(Integer devid) { 
        BaseDevice baseDevice = baseDeviceService.findById(devid); 
        return baseDevice; 
    } 

    @RequestMapping("/list") 
    public List<BaseDevice> list()  { 
        List<BaseDevice> list = baseDeviceService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<BaseDevice> search(BaseDevice baseDevice) { 
        List<BaseDevice> list = baseDeviceService.search(baseDevice); 
        return list; 
    }

    //查找斗轮机
    @RequestMapping("/findDljByCompid")
    public List<BaseDevice> findDljByCompid(BaseDevice baseDevice, HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        List<BaseDevice> list = baseDeviceService.findDljByCompid(baseUser.getCompid());
        return list;
    }

    //查找装船机
    @RequestMapping("/findCzjByCompid")
    public List<BaseDevice> findCzjByCompid(BaseDevice baseDevice,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        List<BaseDevice> list = baseDeviceService.findCzjByCompid(baseUser.getCompid());
        return list;
    }

    //查找皮带机
    @RequestMapping("/findPdjByCompid")
    public List<BaseDevice> findPdjByCompid(BaseDevice baseDevice,HttpSession session){
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        List<BaseDevice> list = baseDeviceService.findPdjByCompid(baseUser.getCompid());
        return list;
    }

    //1 导出设备信息到excel或者pdf
    @RequestMapping("/exportToExcel")
    public void exportToExcel() throws Exception {
        String title = "设备信息表";
        String[] name = {"序号","设备名称","设备类别","投入时间","责任人","所属企业"};
        //获取数据
        Connection connection = CommonUtil.getConnection();
        java.sql.Statement statement = connection.createStatement();
        String sql = "SELECT bd.devid,bd.devname,bt.typename,bd.devdate,bd.devuser,bc.compname\n" +
                " FROM base_device bd  JOIN base_devtype bt ON bd.devid=bt.typeid\n" +
                "       JOIN base_company bc ON bd.devid=bc.compid";
        ResultSet rs = statement.executeQuery(sql);

        CommonUtil.exportExcel(title,name,rs);
    }
} 
