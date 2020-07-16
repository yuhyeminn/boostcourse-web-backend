package kr.or.connect.reservation.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.WebAppInitializer;
import kr.or.connect.reservation.controller.api.ProductController;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppInitializer.class, ApplicationConfig.class })
public class ReservationApiControllerTest {
    @InjectMocks
    public ProductController productController;

    @Mock
    CommentService CommentService;

    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void getComments() throws Exception {
    	ReservationUserComment comment = new ReservationUserComment();
        comment.setId(1);
        comment.setProductId(50);
        comment.setReservationInfoId(50);
        comment.setScore(5.0);
        comment.setReservationEmail("test@test.com");
        comment.setCreateDate(new Date());
        comment.setModifyDate(new Date());
        
        int productId = 1;
        List<ReservationUserComment> list = Arrays.asList(comment);
        when(CommentService.getComments(productId,1)).thenReturn(list);

        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/comments").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());

        verify(CommentService).getComments(productId,1);
    }

    
}
