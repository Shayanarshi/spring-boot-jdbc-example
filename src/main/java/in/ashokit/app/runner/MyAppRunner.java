package in.ashokit.app.runner;

import in.ashokit.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class MyAppRunner implements ApplicationRunner {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        // saveOrder
        orderRepository.saveOrder(10101, LocalDate.of(2026,9,15),"Placed");
        orderRepository.saveOrder(10102, LocalDate.of(2026,9,14),"Delivered");
        orderRepository.saveOrder(10103, LocalDate.of(2026,9,13),"Pending");

    // fetchOrderById
        Map<String,Object> map = orderRepository.fetchOrderById(10103);
        map.forEach((k,v)-> System.out.println(k+", "+v));


        // deleteOrderById
        orderRepository.deleteOrderByID(10102);

    }
}
