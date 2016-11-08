package com.xutao.spitter.mvc;

import com.xutao.spitter.domain.Spittle;
import com.xutao.spitter.service.SpitterService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tau_Hsu on 2016/10/6.
 */
public class HomeControllerTest {

    @Test
    public  void shouldDisplayRecentSpittles(){
        List<Spittle>  expecttedSpittles = Arrays.asList(new Spittle(),new Spittle(),new Spittle());
        SpitterService spitterService = Mockito.mock(SpitterService.class);//模拟SpitterService
        Mockito.when(spitterService.getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expecttedSpittles);
        HomeController homeController = new HomeController(spitterService);//创建控制器
        Map<String, Object>  model = new HashMap<String, Object>();
        String viewName = homeController.showHomePage(model);//调用处理方法
        Assert.assertEquals("home",viewName);
        Assert.assertSame(expecttedSpittles,model.get("spittles"));//对结果进行断言
        Mockito.verify(spitterService).getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE);
    }
}
