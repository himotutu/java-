package com.qhit.baseFlow.controller; 

import com.qhit.baseFlow.pojo.BaseFlow; 
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.utils.CommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/09
*/ 

@RestController 
@RequestMapping("/baseFlow") 
public class BaseFlowController { 

    @Resource 
    IBaseFlowService baseFlowService; 

    @RequestMapping("/insert") 
    public void insert(BaseFlow baseFlow, HttpSession session) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        baseFlow.setCompid(baseUser.getCompid());
        baseFlowService.insert(baseFlow); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer flowid) { 
        baseFlowService.delete(flowid); 
    } 

    @RequestMapping("/update") 
    public void update(BaseFlow baseFlow) { 
        baseFlowService.update(baseFlow); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(BaseFlow baseFlow) { 
        baseFlowService.updateSelective(baseFlow); 
    } 

    @RequestMapping("/load") 
    public BaseFlow load(Integer flowid) { 
        BaseFlow baseFlow = baseFlowService.findById(flowid); 
        return baseFlow; 
    } 

    @RequestMapping("/list") 
    public List<BaseFlow> list()  { 
        List<BaseFlow> list = baseFlowService.findAll();
        return list; 
    } 

    @RequestMapping("/search") 
    public List<BaseFlow> search(BaseFlow baseFlow) { 
        List<BaseFlow> list = baseFlowService.search(baseFlow); 
        return list; 
    }

    //2 导出流程信息到excel或者pdf
    @RequestMapping("/exportToExcel")
    public  void  exportToExcel() throws Exception {
        String title = "流程信息表";
        String[] name = {"序号","流程名称","斗轮机","装船机","皮带机","所属企业"};
        //获取数据设备信息
        Connection connection = CommonUtil.getConnection();
        java.sql.Statement statement = connection.createStatement();
        String sql = "SELECT bf.flowid,bf.flowname,bd1.devname AS dljname,bd2.devname AS zcjname,bd3.devname AS pdjname,bc.compname\n" +
                "\t\tFROM base_flow bf LEFT JOIN base_device bd1 ON bf.dljid=bd1.devid\n" +
                "\t\t LEFT JOIN base_device bd2 ON bf.zcjid=bd2.devid\n" +
                "\t\tLEFT JOIN base_device bd3 ON bf.pdjid=bd3.devid\n" +
                "\t\tLEFT JOIN base_company bc ON bf.compid=bc.compid  ";
        ResultSet rs = statement.executeQuery(sql);

        CommonUtil.exportExcel(title,name,rs);
    }

} 
