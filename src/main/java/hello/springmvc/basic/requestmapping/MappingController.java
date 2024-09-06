package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    //@RequestMapping({"/hello-basic" , "/hello-go"})
    //@RequestMapping("/hello-basic")
    @RequestMapping(value = "/hello-basic" , method = RequestMethod.GET)
    public String HelloBasic(){
        log.info("basic");
        return "OK";
    }

    @RequestMapping(value = "/mapping-get-v1" , method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "OK";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "OK";
    }
    //PahtVariable(경로 변수 사용)
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mapping data ={}" ,data);
        return data;

    }
    //다중 PathVarivable 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId , @PathVariable String orderId){
        log.info("mapping userId = {} , orderId = {}" , userId, orderId);
        return "Ok";

    }
    //params로 받기
    @GetMapping(value = "/mapping-param" , params = "mod=debug")
    public String mappingParam(){
        log.info("mappingHeader");
        return "ok";
    }

    //특정 헤더로 추가 매핑 헤더에 값이 있어야 함
    @GetMapping(value = "/mapping-header" , headers = "mod=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    //미디어 타입 조건 매핑 컨텐츠 타입이 cosumes랑 일치해야 함
    @PostMapping(value = "/mapping-consume" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    //미디어 타입 Accept 타입 맞아야 함
    @PostMapping(value = "/mapping-produce" , produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mappingProduce");
        return "ok";
    }
}
